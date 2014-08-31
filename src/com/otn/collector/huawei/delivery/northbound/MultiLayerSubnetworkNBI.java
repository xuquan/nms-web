package com.otn.collector.huawei.delivery.northbound;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mtnm.tmforum.org.globaldefs.ConnectionDirection_T;
import mtnm.tmforum.org.globaldefs.NameAndStringValue_T;
import mtnm.tmforum.org.globaldefs.ProcessingFailureException;
import mtnm.tmforum.org.managedElement.ManagedElementIterator_IHolder;
import mtnm.tmforum.org.managedElement.ManagedElementList_THolder;
import mtnm.tmforum.org.managedElement.ManagedElement_T;
import mtnm.tmforum.org.multiLayerSubnetwork.MultiLayerSubnetworkMgr_I;
import mtnm.tmforum.org.multiLayerSubnetwork.MultiLayerSubnetwork_T;
import mtnm.tmforum.org.multiLayerSubnetwork.MultiLayerSubnetwork_THolder;
import mtnm.tmforum.org.multiLayerSubnetwork.RouteAndTopologicalLinkIterator_IHolder;
import mtnm.tmforum.org.multiLayerSubnetwork.RouteAndTopologicalLinkList_THolder;
import mtnm.tmforum.org.multiLayerSubnetwork.RouteAndTopologicalLink_T;
import mtnm.tmforum.org.subnetworkConnection.CrossConnect_T;
import mtnm.tmforum.org.subnetworkConnection.Route_THolder;
import mtnm.tmforum.org.subnetworkConnection.SNCIterator_IHolder;
import mtnm.tmforum.org.subnetworkConnection.SubnetworkConnectionList_THolder;
import mtnm.tmforum.org.subnetworkConnection.SubnetworkConnection_T;
import mtnm.tmforum.org.subnetworkConnection.WaveLengthStatusList_THolder;
import mtnm.tmforum.org.subnetworkConnection.WaveLengthStatus_T;
import mtnm.tmforum.org.topologicalLink.TopologicalLinkIterator_IHolder;
import mtnm.tmforum.org.topologicalLink.TopologicalLinkList_THolder;
import mtnm.tmforum.org.topologicalLink.TopologicalLink_T;

import com.otn.collector.huawei.delivery.beans.managedElement.ManagedElement;
import com.otn.collector.huawei.delivery.beans.multiLayerSubnetwork.MultiLayerSubnetwork;
import com.otn.collector.huawei.delivery.beans.multiLayerSubnetwork.RouteAndTopologicalLink;
import com.otn.collector.huawei.delivery.beans.subnetworkConnection.CrossConnect;
import com.otn.collector.huawei.delivery.beans.subnetworkConnection.SubnetworkConnection;
import com.otn.collector.huawei.delivery.beans.subnetworkConnection.WaveLengthStatus;
import com.otn.collector.huawei.delivery.beans.topologicalLink.TopologicalLink;
import com.otn.collector.huawei.delivery.convertor.Convertor;
import com.otn.collector.huawei.delivery.exception.AppException;
import com.otn.collector.huawei.delivery.factory.BeanFactory;

/**
 * 提供了子网管理的接口
 * @author xuquan
 * 2014-6-6
 */
public class MultiLayerSubnetworkNBI {
	
	private MultiLayerSubnetworkMgr_I multiLayerSubnetworkMgr = (MultiLayerSubnetworkMgr_I) BeanFactory.getInstance().getBean(MultiLayerSubnetworkMgr_I.class);
	
	/**
	 * 该接口查询指定子网内所有的网元对象的详细信息
	 * @param subnetName 子网名称
	 * @return 返回的网元信息列表
	 * @throws AppException 
	 */
	public List<ManagedElement> getAllManagedElements(NameAndStringValue_T[] subnetName) throws AppException{
		try {
			int how_many = 10;
			ManagedElementList_THolder meList = new ManagedElementList_THolder();
			ManagedElementIterator_IHolder meIt = new ManagedElementIterator_IHolder();
			multiLayerSubnetworkMgr.getAllManagedElements(subnetName, how_many, meList, meIt);
			
			List<ManagedElement> rs = new ArrayList<ManagedElement>();
			do{
				ManagedElement_T[] mes = meList.value;
				for(ManagedElement_T me_t : mes){
					ManagedElement me = Convertor.convert(me_t);
					rs.add(me);
				}
			}while(meIt.value!=null && meIt.value.next_n(how_many, meList));
			return rs;
		} catch (ProcessingFailureException e) {
			throw new AppException("查询"+Arrays.toString(subnetName)+"子网内所有的网元对象的详细信息失败!",e);
		}
	}
	
	/**
	 * 该接口查询指定子网内所有子网连接的详细信息
	 * 查询指定子网内所有子网连接信息
	 * SDH 支持E1 (VC12)、E3 (VC3)、E4 (VC4)、VC4 (VC4 server)、4C、8C、16C和64C。
	 * WDM 支持OCH、OCH client、ODU和OTU。
	 * 
	 * @param subnetId 子网名称
	 * @param connectionRateList 支持的连接层速率过滤条件
	 * @return 子网连接列表
	 * @throws AppException 
	 */
	public List<SubnetworkConnection> getAllSubnetworkConnections(NameAndStringValue_T[] subnetName,short[] connectionRateList) throws AppException{
		try {
			int how_many = 50;
			SubnetworkConnectionList_THolder sncList = new SubnetworkConnectionList_THolder();
			SNCIterator_IHolder sncIt = new SNCIterator_IHolder();
			multiLayerSubnetworkMgr.getAllSubnetworkConnections(subnetName, connectionRateList, how_many, sncList, sncIt);
			
			List<SubnetworkConnection> rs = new ArrayList<SubnetworkConnection>();
			do{
				SubnetworkConnection_T[] sncs = sncList.value;
				for(SubnetworkConnection_T snc_t : sncs){
					SubnetworkConnection snc = Convertor.convert(snc_t);
					rs.add(snc);
				}
			}while(sncIt.value!=null && sncIt.value.next_n(how_many, sncList));
			return rs;
		} catch (ProcessingFailureException e) {
			throw new AppException("查询"+Arrays.toString(subnetName)+"子网内所有子网连接信息失败!",e);
		}
	}
	
	/**
	 * 该接口查询指定SNC的路由信息
	 * 说明：如果输入的路径是客户层路径，但是其服务路径不存在路由（如：两点间的VC4 Server路径），
	 * 则includeHigherOrderCCs取值为false和true，异常值都是一样的。
	 * 对于OTN路径，includeHigherOrderCCs参数为true时，查询返回所有服务层的路由。
	 * 
	 * @param sncName 要查询的SNC名称
	 * @param includeHigherOrderCCs 是否查询服务层路径路由
	 * @return 子网连接的路由列表
	 * @throws AppException 
	 */
	public List<CrossConnect> getRoute(NameAndStringValue_T[] sncName,boolean includeHigherOrderCCs) throws AppException{
		try {
			Route_THolder route = new Route_THolder();
			multiLayerSubnetworkMgr.getRoute(sncName, includeHigherOrderCCs, route);
			CrossConnect_T[] cc_t = route.value;
			List<CrossConnect> rs = new ArrayList<CrossConnect>();
			for(CrossConnect_T cc : cc_t){
				rs.add(Convertor.convert(cc));
			}
			return rs;
		} catch (ProcessingFailureException e) {
			throw new AppException("查询"+Arrays.toString(sncName)+"SNC的路由信息失败!",e);
		}
	}
	
	/**
	 * 该接口获取光网元的WDM波长资源信息
	 * 功能：WDM波长可达的资源统计
	 * @param aEndName 源端网元名称
	 * @param zEndName 宿端网元名称
	 * @param direction 方向  CD_BI：双向(srcEnd->snkEndsnkEnd->srcEnd) CD_UNI：单向(srcEnd->snkEnd)
	 * @return 波长列表
	 * @throws AppException 
	 */
	public List<WaveLengthStatus> getWaveLengthStatusByEndObject(NameAndStringValue_T[] aEndName,NameAndStringValue_T[] zEndName,String direction) throws AppException{
		try {
			NameAndStringValue_T[][] inclusionNameList = new NameAndStringValue_T[0][2];
			NameAndStringValue_T[][] exclusionNameList = new NameAndStringValue_T[0][2];
			ConnectionDirection_T direc = null;
			if("CD_UNI".equals(direction)){
				direc = ConnectionDirection_T.CD_UNI;
			}else if("CD_BI".equals(direction)){
				direc = ConnectionDirection_T.CD_BI;
			}
			WaveLengthStatusList_THolder waveLengthStatusList = new WaveLengthStatusList_THolder();
			multiLayerSubnetworkMgr.getWaveLengthStatusByEndObject(aEndName, inclusionNameList, exclusionNameList, zEndName, direc, waveLengthStatusList);
			WaveLengthStatus_T[] waveLengthStatus = waveLengthStatusList.value;
			List<WaveLengthStatus> rs = new ArrayList<WaveLengthStatus>();
			for(WaveLengthStatus_T wls : waveLengthStatus){
				rs.add(Convertor.convert(wls));
			}
			return rs;
		} catch (ProcessingFailureException e) {
			throw new AppException("WDM波长可达的资源统计失败!",e);
		}
	}
	
	/**
	 * 该接口根据输入的子网名称，获取该子网的详细信息
	 * 功能：根据输入的子网名称，查询指定的子网信息
	 * @param subnetName 子网名称
	 * @return 子网信息
	 * @throws AppException 
	 */
	public MultiLayerSubnetwork getMultiLayerSubnetwork(NameAndStringValue_T[] subnetName) throws AppException{
		try {
			MultiLayerSubnetwork_THolder subnetwork = new MultiLayerSubnetwork_THolder();
			multiLayerSubnetworkMgr.getMultiLayerSubnetwork(subnetName, subnetwork);
			MultiLayerSubnetwork_T multiLayerSubnetwork_t = subnetwork.value;
			MultiLayerSubnetwork snc = Convertor.convert(multiLayerSubnetwork_t);
			return snc;
		} catch (ProcessingFailureException e) {
			throw new AppException("根据输入的子网名称"+Arrays.toString(subnetName)+"查询指定的子网信息失败!",e);
		}
	}
	
	/**
	 * 该接口通过指定多条SNC的名称，获取这些SNC的路由和拓扑连接信息
	 * 查询SNC名称列表指定的SNC的路由和拓扑连接信息
	 * 
	 * @param sncNames SNC名称列表
	 * @return 路由和拓扑链接信息列表
	 * @throws AppException 
	 */
	public List<RouteAndTopologicalLink> getRouteAndTopologicalLinksBySNCs(NameAndStringValue_T[][] sncNameList) throws AppException{
		try {
			int how_many = 10;
			RouteAndTopologicalLinkList_THolder routeAndTlList = new RouteAndTopologicalLinkList_THolder();
			RouteAndTopologicalLinkIterator_IHolder routeAndTlIt = new RouteAndTopologicalLinkIterator_IHolder();
			multiLayerSubnetworkMgr.getRouteAndTopologicalLinksBySNCs(sncNameList, how_many, routeAndTlList, routeAndTlIt);
			List<RouteAndTopologicalLink> rs = new ArrayList<RouteAndTopologicalLink>();
			do{
				RouteAndTopologicalLink_T[] routeAndTls = routeAndTlList.value;
				for(RouteAndTopologicalLink_T routeAndTl : routeAndTls){
					rs.add(Convertor.covert(routeAndTl));
				}
			}while(routeAndTlIt.value!=null && routeAndTlIt.value.next_n(how_many, routeAndTlList));
			return rs;
		} catch (ProcessingFailureException e) {
			throw new AppException("查询SNC名称列表"+Arrays.toString(sncNameList)+"的SNC的路由和拓扑连接信息失败!",e);
		}
	}
	
	/**
	 * 该接口通过指定子网名称，获取该子网内网元之间的拓扑连接的详细信息
	 * 功能：查询指定子网内网元之间的拓扑连接
	 * @param subnetName 子网名称
	 * @return 拓扑连接信息列表
	 * @throws AppException 
	 */
	public List<TopologicalLink> getAllTopologicalLinks(NameAndStringValue_T[] subnetName) throws AppException{
		try {
			int how_many = 1;
			TopologicalLinkList_THolder topoList = new TopologicalLinkList_THolder();
			TopologicalLinkIterator_IHolder topoIt = new TopologicalLinkIterator_IHolder();
			multiLayerSubnetworkMgr.getAllTopologicalLinks(subnetName, how_many, topoList, topoIt);
			List<TopologicalLink> rs = new ArrayList<TopologicalLink>();
			do{
				TopologicalLink_T[] tls = topoList.value;
				for(TopologicalLink_T tl : tls){
					rs.add(Convertor.convert(tl));
				}
			}while(topoIt.value!=null && topoIt.value.next_n(how_many, topoList));
			return rs;
		} catch (ProcessingFailureException e) {
			throw new AppException("查询"+Arrays.toString(subnetName)+"子网内网元之间的拓扑连接失败!",e);
		}
	}
	
	/**
	 * 该接口通过指定网元名称，获取该网元内的拓扑连接信息
	 * 功能：查询指定网元内的拓扑连接信息
	 * @param meName 网元名称
	 * @return 拓扑连接列表
	 * @throws AppException 
	 */
	public List<TopologicalLink> getAllInternalTopologicalLinks(NameAndStringValue_T[] meName) throws AppException{
		try {
			int how_many = 1;
			TopologicalLinkList_THolder topoList = new TopologicalLinkList_THolder();
			TopologicalLinkIterator_IHolder topoIt = new TopologicalLinkIterator_IHolder();
			multiLayerSubnetworkMgr.getAllInternalTopologicalLinks(meName, how_many, topoList, topoIt);
			List<TopologicalLink> rs = new ArrayList<TopologicalLink>();
			do{
				TopologicalLink_T[] tls = topoList.value;
				for(TopologicalLink_T tl : tls){
					rs.add(Convertor.convert(tl));
				}
			}while(topoIt.value!=null && topoIt.value.next_n(how_many, topoList));
			return rs;
		} catch (ProcessingFailureException e) {
			throw new AppException("查询"+Arrays.toString(meName)+"网元内的拓扑连接信息失败!",e);
		}
	}
}
