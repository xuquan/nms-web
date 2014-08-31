package com.otn.collector.huawei.delivery.northbound;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mtnm.tmforum.org.globaldefs.NameAndStringValue_T;
import mtnm.tmforum.org.globaldefs.NamingAttributesIterator_IHolder;
import mtnm.tmforum.org.globaldefs.NamingAttributesList_THolder;
import mtnm.tmforum.org.globaldefs.ProcessingFailureException;
import mtnm.tmforum.org.managedElement.ManagedElementIterator_IHolder;
import mtnm.tmforum.org.managedElement.ManagedElementList_THolder;
import mtnm.tmforum.org.managedElement.ManagedElement_T;
import mtnm.tmforum.org.managedElement.ManagedElement_THolder;
import mtnm.tmforum.org.managedElementManager.ManagedElementMgr_I;
import mtnm.tmforum.org.subnetworkConnection.CCIterator_IHolder;
import mtnm.tmforum.org.subnetworkConnection.CrossConnectList_THolder;
import mtnm.tmforum.org.subnetworkConnection.CrossConnect_T;
import mtnm.tmforum.org.subnetworkConnection.TPDataList_THolder;
import mtnm.tmforum.org.subnetworkConnection.TPData_T;
import mtnm.tmforum.org.terminationPoint.TerminationPointIterator_IHolder;
import mtnm.tmforum.org.terminationPoint.TerminationPointList_THolder;
import mtnm.tmforum.org.terminationPoint.TerminationPoint_T;

import com.otn.collector.huawei.delivery.beans.managedElement.ManagedElement;
import com.otn.collector.huawei.delivery.beans.subnetworkConnection.CrossConnect;
import com.otn.collector.huawei.delivery.beans.subnetworkConnection.TPData;
import com.otn.collector.huawei.delivery.beans.terminationPoint.TerminationPoint;
import com.otn.collector.huawei.delivery.convertor.Convertor;
import com.otn.collector.huawei.delivery.exception.AppException;
import com.otn.collector.huawei.delivery.factory.BeanFactory;

/**
 * 提供了网元或终结点管理的接口
 * 包括：网元、端口、网元内的交叉连接管理等接口。
 * @author xuquan
 * 2014-6-4
 */
public class ManagedElementNBI {

	private ManagedElementMgr_I managedElementMgr = (ManagedElementMgr_I) BeanFactory.getInstance().getBean(ManagedElementMgr_I.class);
	
	/**
	 * 该接口通过网元名称查询指定网元的详细信息
	 * 功能：根据网元名称查询指定网元的详细信息
	 * @param managedElementName 要查询的网元名称
	 * @return
	 * @throws AppException 
	 */
	public ManagedElement getManagedElement(NameAndStringValue_T[] managedElementName) throws AppException{
		try {
			ManagedElement_THolder meTholder = new ManagedElement_THolder();
			managedElementMgr.getManagedElement(managedElementName, meTholder);
			ManagedElement_T me_t = meTholder.value;
			ManagedElement me = Convertor.convert(me_t);
			return me;
		} catch (ProcessingFailureException e) {
			throw new AppException("根据网元名称"+Arrays.toString(managedElementName)+"查询指定网元的详细信息失败!",e);
		}
	}
	
	/**
	 * 查询网管系统内所有的网元对象的详细信息
	 * @return
	 * @throws AppException 
	 */
	public List<ManagedElement> getAllManagedElements() throws AppException{
		try {
			int how_many=1;
			ManagedElementList_THolder meList = new ManagedElementList_THolder();
			ManagedElementIterator_IHolder meIt = new ManagedElementIterator_IHolder();
			managedElementMgr.getAllManagedElements(how_many, meList, meIt);
			List<ManagedElement> list = new ArrayList<ManagedElement>();
			do{
				ManagedElement_T[] mes = meList.value;
				for(int i=0;i<mes.length;i++){
					ManagedElement_T me_t = mes[i];
					ManagedElement me = Convertor.convert(me_t);
					list.add(me);
				}
			}while(meIt.value!=null && meIt.value.next_n(how_many, meList));
			return list;
		} catch (ProcessingFailureException e) {
			throw new AppException("查询网管系统内所有的网元对象的详细信息失败!",e);
		}
	}
	
	/**
	 * 查询网管系统内所有的网元对象的名称
	 * @return
	 * @throws AppException 
	 */
	public NameAndStringValue_T[][] getAllManagedElementNames() throws AppException{
		try {
			List<NameAndStringValue_T[]> list = new ArrayList<NameAndStringValue_T[]>();
			int how_many=1;
			
			NamingAttributesList_THolder nameList = new NamingAttributesList_THolder();
			NamingAttributesIterator_IHolder nameIt = new NamingAttributesIterator_IHolder();
			managedElementMgr.getAllManagedElementNames(how_many, nameList, nameIt);
			do{
				NameAndStringValue_T[][] names = nameList.value;
				for(NameAndStringValue_T[] name : names){
					list.add(name);
				}
			}while(nameIt.value!=null && nameIt.value.next_n(how_many, nameList));
			NameAndStringValue_T[][] rsArray = new NameAndStringValue_T[list.size()][];
			list.toArray(rsArray);
			return rsArray;
		} catch (ProcessingFailureException e) {
			throw new AppException("查询网管系统内所有的网元对象的名称失败!",e);
		}
	}
	
	/**
	 * 该接口通过网元名称，获取该网元内的交叉连接
	 * 功能：查询指定网元内的交叉连接，包括静态交叉、动态交叉
	 * 
	 * 支持的交叉连接级别包括：
	 * VC12、VC3、VC4、4C、8C、16C、64C、OCH、Client（包括GE、FC等）、
	 * OMS、OS（对应U2000上Free交叉）、ODU0、ODU1、ODU2、ODU3、ODU4、
	 * ODU5G、OTU1、OTU2、OTU3、OTU5G。
	 * 
	 * @param managedElementName 网元名称
	 * @param connectionRateList 要查询的交叉速率级别列表，按照TMF建议，该字段不能为空。
	 * @return 交叉连接列表
	 * @throws AppException 
	 */
	public List<CrossConnect> getAllCrossConnections(NameAndStringValue_T[] managedElementName,short[] connectionRateList) throws AppException{
		try {
			int how_many=1;
			CrossConnectList_THolder ccList = new CrossConnectList_THolder();
			CCIterator_IHolder ccIt = new CCIterator_IHolder();
			managedElementMgr.getAllCrossConnections(managedElementName, connectionRateList, how_many, ccList, ccIt);
			List<CrossConnect> rs = new ArrayList<CrossConnect>();
			do{
				CrossConnect_T[] crossConnects = ccList.value;
				for(int i=0;i<crossConnects.length;i++){
					CrossConnect_T cc_t = crossConnects[i];
					CrossConnect cc = Convertor.convert(cc_t);
					rs.add(cc);
				}
			}while(ccIt.value!=null && ccIt.value.next_n(how_many, ccList));
			return rs;
		} catch (ProcessingFailureException e) {
			throw new AppException("查询"+Arrays.toString(managedElementName)+"网元内的交叉连接失败!",e);
		}
	}
	
	/**
	 * 该接口通过下发网元名称，查询该指定网元所包含的符合条件的所有PTP详细信息
	 * 功能：查询指定网元包含的符合条件的PTP信息列表
	 * 
	 * 约束：
	 * tpLayerRateList和connectionLayerRateList输入均可以为空，此时返回整个网元的PTP；
	 * 或输入其中之一，符合该条件的PTP均返回。
	 * 这里的连接层速率connectionLayerRateList指的是PTP可能支持的所有的连接层速率，
	 * 和PTP下CTP当前使用情况无关。
	 * 
	 * @param managedElementName 要查询的网元名称
	 * @param tpLayerRateList 层速率过滤条件
	 * @param connectionLayerRateList 连接层速率过滤条件
	 * @return 返回的PTP详细信息
	 * @throws AppException 
	 */
	public List<TerminationPoint> getAllPTPs(NameAndStringValue_T[] managedElementName,short[] tpLayerRateList,short[] connectionLayerRateList) throws AppException{
		try {
			int how_many = 1;
			TerminationPointList_THolder tpList = new TerminationPointList_THolder();
			TerminationPointIterator_IHolder tpIt = new TerminationPointIterator_IHolder();
			managedElementMgr.getAllPTPs(managedElementName, tpLayerRateList, connectionLayerRateList, how_many, tpList, tpIt);
			List<TerminationPoint> rs = new ArrayList<TerminationPoint>();
			do{
				TerminationPoint_T[] tps = tpList.value;
				for(TerminationPoint_T tp : tps){
					rs.add(Convertor.convert(tp));
				}
			}while(tpIt.value!=null && tpIt.value.next_n(how_many, tpList));
			return rs;
		} catch (ProcessingFailureException e) {
			throw new AppException("查询"+Arrays.toString(managedElementName)+"网元包含的符合条件的PTP信息列表失败!",e);
		}
	}
	
	/**
	 * 该接口通过输入指定的网元，查询该网元的静态信息
	 * 功能：查询网元的静态信息
	 * staticInfoList中元素取值的格式：{name 网元ID value 网元支持的领域}
	 * 网元支持的领域取值包括：
	 * 		“domain_sdh = true”、“domain_sonet = true”、“domain_wdm = true”、“domain_other = true”。
	 * 
	 * @param managedElementName 要查询的网元名称
	 * @return 返回的静态信息列表
	 * @throws AppException 
	 */
	public void getNEStaticInfo(NameAndStringValue_T[] managedElementName) throws AppException{
		try {
			int how_many=1;
			NamingAttributesList_THolder staticInfoList = new NamingAttributesList_THolder();
			NamingAttributesIterator_IHolder staticInfoIt = new NamingAttributesIterator_IHolder();
			managedElementMgr.getNEStaticInfo(managedElementName, how_many, staticInfoList, staticInfoIt);
			do{
				NameAndStringValue_T[][] staticInfos = staticInfoList.value;
				for(int i=0;i<staticInfos.length;i++){
					for(int j=0;j<staticInfos[0].length;j++){
						System.out.println(staticInfos[i][j]);
					}
				}
			}while(staticInfoIt.value!=null && staticInfoIt.value.next_n(how_many, staticInfoList));
		} catch (ProcessingFailureException e) {
			throw new AppException("查询网管系统内所有的网元对象的详细信息失败!",e);
		}
	}
	
	/**
	 * 该接口根据指定的FTP，获取该逻辑端口的成员信息
	 * 功能：查询指定FTP的成员信息
	 * 
	 * 参数说明：
	 * WDM 1.name="EMS"; value="Huawei/U2000"
	 *     2.name="ManagedElement"; value="33554433"
	 *     3.name="FTP"; value="/rack=1/shelf=590225/slot=8/domain=wdm/port=201"
	 * 
	 * PTN 1.name="EMS"; value="Huawei/U2000"
	 * 	   2.name="ManagedElement"; value="3145433"
	 * 	   3.name="FTP"; value="/rack=1/shelf=1/domain=ptn/type=mp/port=1"
	 * 	   PTN领域FTP，对于端口类型【type】的可能取值：
	 * 			mp：MP组
	 * 			ethtrunk：链路聚合组(LAG)
	 * 			EoVLAN：VLAN子接口
	 * 			EoATM：基于DSL接口(ATM绑定组)的以太虚接口
	 * 			EoEFM：基于DSL接口(EFM绑定组)的以太虚接口
	 * 			serial：逻辑串口
	 * 			ima：ATM IMA组
	 * 
	 * @param type 端口类型，取值包括：physical、lag、iptrunk、atmtrunk、serial、vctrunk、virtual、pw、tunnel
	 * @param port 端口
	 * @return FTP的成员信息
	 * @throws AppException 
	 */
	public List<TPData> getFTPMembers(NameAndStringValue_T[] ftpName) throws AppException{
		try {
			TPDataList_THolder tpList = new TPDataList_THolder();
			managedElementMgr.getFTPMembers(ftpName, tpList);
			TPData_T[] tpDatas = tpList.value;
			List<TPData> rs = new ArrayList<TPData>();
			for(TPData_T tp : tpDatas){
				rs.add(Convertor.convert(tp));
			}
			return rs;
		} catch (ProcessingFailureException e) {
			throw new AppException("查询指定FTP的成员信息失败!",e);
		}
	}
}
