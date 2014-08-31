package com.otn.collector.huawei.delivery.connection;

import mtnm.tmforum.org.emsSession.EmsSession_I;
import mtnm.tmforum.org.emsSession.EmsSession_IHolder;
import mtnm.tmforum.org.emsSessionFactory.EmsSessionFactory_I;
import mtnm.tmforum.org.emsSessionFactory.EmsSessionFactory_IHelper;
import mtnm.tmforum.org.globaldefs.ProcessingFailureException;
import mtnm.tmforum.org.nmsSession.NmsSession_I;
import mtnm.tmforum.org.nmsSession.NmsSession_IPOA;

import org.apache.log4j.Logger;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.DynamicAny.DynAnyFactory;
import org.omg.DynamicAny.DynAnyFactoryHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;

import com.otn.collector.huawei.delivery.util.PropertiesUtil;

/**
 * CORBA协议连接
 * @author xuquan
 * 2014-6-1
 */
public class CorbaConnection {
	
	private static Logger logger = Logger.getLogger(CorbaConnection.class);

	private CorbaConnection(){
		
	}
	
	private static CorbaConnection instance = new CorbaConnection();
	
	public static CorbaConnection getInstance(){
		return instance;
	}
	
	//ORB object
	private ORB orb = null;
	
	//POA object reference
	private POA rootPOA = null;
	
	//emsSession object
	private EmsSession_I emsSession = null;
	
	//动态工厂，用于转换任意类型到动态类型
	private DynAnyFactory dynAnyFactory = null;
	
	public static void main(String[] args){
		if(args.length<4){
			log("usage:java com.otn.collector.huawei.delivery.connection.CorbaConnection 192.168.134.2 12001 corbanbi Test_1234");
			return;
		}
		log("-------------------------------------------------------");
		log("Naming service IP: " + args[0]);
		log("Naming service port: " + args[1]);
		log("EMS user name : " + args[2]);
		log("Password for user " + args[2] + " : " + args[3]);
		log("-------------------------------------------------------");
		CorbaConnection.getInstance().connect(args[0], args[1], args[2], args[3]);
	}
	
	private static void log(String log){
		System.out.println(log);
	}
	
	public int connect(String nsip,String nsport,String username,String password){
		try {
			// 初始化 ORB参数
			String argv[] = new String[2];
			argv[0] = "-ORBInitRef";
			argv[1] = "NameService=corbaloc::"+nsip+":"+nsport+"/NameService";
			// 第一步: 初始化ORB
			orb = ORB.init(argv, null);
			
			// 第二步: 获取RootPOA
			rootPOA = org.omg.PortableServer.POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootPOA.the_POAManager().activate();
			
			// 第三步: 构造动态工厂
			dynAnyFactory = DynAnyFactoryHelper.narrow(orb.resolve_initial_references("DynAnyFactory"));

			// 第四步: 获取命名服务根对象引用
			org.omg.CosNaming.NamingContextExt nc = 
				org.omg.CosNaming.NamingContextExtHelper.narrow(orb.resolve_initial_references("NameService"));
			
			// 第五步: 从命名服务获取EmsSessionFactory_I对象引用  
			NameComponent[] name = new NameComponent[5];
			name[0] = new NameComponent("TMF_MTNM", "Class");
			name[1] = new NameComponent("HUAWEI","Vendor");
			name[2] = new NameComponent("Huawei/U2000","EmsInstance");
			name[3] = new NameComponent("2.0","Version");
			name[4] = new NameComponent("Huawei/U2000","EmsSessionFactory_I");
			
			EmsSessionFactory_I emsSessionFactory = null;
			try {
				emsSessionFactory = EmsSessionFactory_IHelper.narrow(nc.resolve(name));
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("第五步: 从命名服务获取EmsSessionFactory_I对象引用 失败! \n 请确认 U2000 CORBA 正常运行!",e);
				return 0;
			}
			
			// 获取emsSession
			NmsSession_IPOA pNmsSessionServant = new NmsSessionIImpl();
			NmsSession_I nmsSession = pNmsSessionServant._this(orb);
			
			// 第六步: 调用 getEmsSession接口登录 U2000
			EmsSession_IHolder emsSessionInterfaceHolder = new EmsSession_IHolder();
			try {
				emsSessionFactory.getEmsSession(username, password, nmsSession, emsSessionInterfaceHolder);
				emsSession = emsSessionInterfaceHolder.value;
			} catch (ProcessingFailureException e) {
				e.printStackTrace();
				logger.error("第六步: 调用 getEmsSession接口登录 U2000失败!",e);
				return 0;
			}
		} catch (InvalidName e) {
			e.printStackTrace();
		} catch (AdapterInactive e) {
			e.printStackTrace();
		} 
		return 0;
	}
	
	public EmsSession_I getEmsSession(){
		if(emsSession==null){
			PropertiesUtil util = new PropertiesUtil("conf/collector/U2000.properties");
			String nsip = util.getProperty("NameServiceIP");
			String nsport = util.getProperty("NameServicePort");
			String username = util.getProperty("username");
			String password = util.getProperty("password");
			connect(nsip,nsport,username,password);
		}
		return emsSession;
	}
	
	public void closeEmsSession(){
		if(emsSession!=null){
			emsSession.endSession();
		}
	}

	public DynAnyFactory getDynAnyFactory() {
		return dynAnyFactory;
	}

	public void setDynAnyFactory(DynAnyFactory dynAnyFactory) {
		this.dynAnyFactory = dynAnyFactory;
	}
	
}
