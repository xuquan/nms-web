package com.otn.common.dbo.hibernate;


import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.otn.common.beans.Bearer;
import com.otn.common.beans.Och;
import com.otn.common.beans.OchNode;
import com.otn.common.beans.OchPort;
import com.otn.common.beans.OmsNode;
import com.otn.common.beans.OmsPort;
import com.otn.common.beans.Path;
import com.otn.common.beans.Site;
import com.otn.common.beans.Subnet;
import com.otn.common.beans.Xc;
import com.otn.common.beans.XcPhy;
import com.otn.common.beans.Xcplane;

public class Base {

	private static Logger log4j = Logger.getLogger(Base.class);  
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
        // test log
		log4j.error("log4j error"); 
		// 测试映射文件，注意，第二次运行的时候会插入重复
		//testSaveBeans();
		// 关闭数据库连接
		//HibernateSessionFactory.closeSession();
		
		try {
			List<Subnet> subnets = (List<Subnet>) BaseDAO.getInstance().getList(Subnet.class.getName());
			for(Subnet subnet : subnets){
				System.out.println(subnet);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		BaseSettings.getInstance();
//		System.out.println("table count "+ BaseDAO.getInstance().count(TestBean.class.getName()));
//		System.out.println(BaseDAO.getInstance().getList(TestBean.class.getName()));
//		BaseDAO.getInstance().deleteAll(TestBean.class.getName());
//		TestBean user = null;
//		for(int i=0;i<10;i++){
//			user = new TestBean();
//			user.setId(i);
//			user.setName("ddd-" + i);
//			BaseDAO.getInstance().add(user);
//			if(i%2 == 0){
//				user.setName("eee-" + i*2);
//			}
//			BaseDAO.getInstance().update(user);
//		}
//
//		try {
////			BaseDAO.getInstance().add(user);
//		} catch (Exception e) {
//			log4j.error("aaaaa.....", e);
//		}
//		
//		System.out.println("all table : " + BaseDAO.getInstance().getList(TestBean.class.getName()));
//		
//		System.out.println("table count "+ BaseDAO.getInstance().count(TestBean.class.getName()));

		System.out.println("--------------------------------end");
	}
	
	/**
	 * 测试映射文件
	 */
	private static void testSaveBeans(){
		Subnet subnet = new Subnet();
		subnet.setId(0);
		subnet.setName("SubnetA");
		subnet.setPosX(100);
		subnet.setPosY(100);
		subnet.setParentId(0);
		BaseDAO.getInstance().add(subnet);
		
		Site site = new Site();
		site.setId(1001);
		site.setName("SiteA");
		site.setPosX(100);
		site.setPosY(100);
		site.setParentId(0);
		BaseDAO.getInstance().add(site);
		
		Och och = new Och();
		och.setId(0);
		och.setName("Och-001");
		och.setWavelength(2);
		BaseDAO.getInstance().add(och);
		
		Bearer bearer = new Bearer();
		bearer.setId(0);
		bearer.setName("Och-001");
		bearer.setSignalLevel(12392);
		BaseDAO.getInstance().add(bearer);
		
		OchNode ochnode = new OchNode();
		ochnode.setId(0);
		ochnode.setName("Ne-shelf-slot-port-cptype");
		ochnode.setCpType(2390);
		ochnode.setXcplane(0);
		BaseDAO.getInstance().add(ochnode);
		
		OmsNode omsnode = new OmsNode();
		omsnode.setId(0);
		omsnode.setName("Ne-shelf-slot-port-cptype");
		omsnode.setSysCapacity(80);;
		omsnode.setPortid(0);
		BaseDAO.getInstance().add(omsnode);
		
		OchPort ochport = new OchPort();
		ochport.setId(0);
		ochport.setName("Ne-shelf-slot-port-cptype");
		ochport.setNe(234566);;
		ochport.setShelf(2);
		ochport.setSlot(1);
		ochport.setPort(1);
		ochport.setCptype(2390);
		BaseDAO.getInstance().add(ochport);
		
		OmsPort omsport = new OmsPort();
		omsport.setId(0);
		omsport.setName("Ne-shelf-slot-port-cptype");
		omsport.setNe(234566);;
		omsport.setShelf(2);
		omsport.setSlot(1);
		omsport.setPort(1);
		omsport.setCptype(2390);
		BaseDAO.getInstance().add(omsport);
		
		Xcplane xcp = new Xcplane();
		xcp.setId(0);
		xcp.setName("SiteA");
		xcp.setNe(234566);;
		xcp.setShelf(2);
		xcp.setSlot(1);
		BaseDAO.getInstance().add(xcp);
		
		Path path = new Path();
		path.setId(0);
		path.setBearer(0);
		path.setSignalLevel(12392);
		path.setTs("Och:1/ODU2:1");
		path.setUsage(2);
		BaseDAO.getInstance().add(path);
		
		Xc xc = new Xc();
		xc.setId(0);
		xc.setSrcNode(0);
		xc.setSrcts("ODU2:1/ODU1:1/ODU0:1");
		xc.setSnkNode(0);
		xc.setSnkts("ODU2:1/ODU1:1/ODU0:1");
		BaseDAO.getInstance().add(xc);
		
		XcPhy xcphy = new XcPhy();
		xcphy.setId(0);
		xcphy.setSrcNe(123489);
		xcphy.setSrcShelf(1);
		xcphy.setSrcSlot(1);
		xcphy.setSrcPort(1);
		xcphy.setSrcSignalLevel(12392);
		xcphy.setSrcts("ODU2:2/ODU1:0/ODU0:1");
		xcphy.setSnkNe(123489);
		xcphy.setSnkShelf(1);
		xcphy.setSnkSlot(1);
		xcphy.setSnkPort(1);
		xcphy.setSnkSignalLevel(12392);
		xcphy.setSnkts("ODU2:2/ODU1:0/ODU0:1");
		BaseDAO.getInstance().add(xcphy);
	}

}
