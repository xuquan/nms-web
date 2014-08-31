package com.otn.collector.huawei.delivery.northbound;

import java.util.ArrayList;
import java.util.List;

import mtnm.tmforum.org.TopoManagementManager.NodeIterator_IHolder;
import mtnm.tmforum.org.TopoManagementManager.NodeList_THolder;
import mtnm.tmforum.org.TopoManagementManager.Node_T;
import mtnm.tmforum.org.TopoManagementManager.TopoMgr_I;
import mtnm.tmforum.org.globaldefs.ProcessingFailureException;

import com.otn.collector.huawei.delivery.beans.TopoManagementManager.Node;
import com.otn.collector.huawei.delivery.convertor.Convertor;
import com.otn.collector.huawei.delivery.exception.AppException;
import com.otn.collector.huawei.delivery.factory.BeanFactory;

/**
 * 提供了网络拓扑管理的接口
 * @author xuquan
 * 2014-6-7
 */
public class TopoNBI {
	
	private TopoMgr_I topoMgr = (TopoMgr_I) BeanFactory.getInstance().getBean(TopoMgr_I.class);

	/**
	 * 该接口查询网管拓扑视图中的网元和子网信息
	 * 查询网管拓扑视图中的网元和子网信息
	 * @return
	 * @throws AppException 
	 */
	public List<Node> getTopoSubnetworkViewInfo() throws AppException{
		try {
			int how_many = 1;
			NodeList_THolder nodeList = new NodeList_THolder();
			NodeIterator_IHolder nodeIt = new NodeIterator_IHolder();
			topoMgr.getTopoSubnetworkViewInfo(how_many, nodeList, nodeIt);
			List<Node> rs = new ArrayList<Node>();
			do{
				Node_T[] nodes = nodeList.value;
				for(Node_T node_t : nodes){
					rs.add(Convertor.convert(node_t));
				}
			}while(nodeIt.value!=null && nodeIt.value.next_n(how_many, nodeList));
			return rs;
		} catch (ProcessingFailureException e) {
			throw new AppException("查询网管拓扑视图中的网元和子网信息失败!",e);
		}
	}
	
	/**
	 * 该接口查询网管拓扑视图中的网元和子网信息
	 * 与接口getTopoSubnetworkViewInfo()功能相同
	 * @return
	 * @throws AppException
	 */
	public List<Node> getProtectSubnetworkViewInfo() throws AppException{
		try {
			int how_many = 1;
			NodeList_THolder nodeList = new NodeList_THolder();
			NodeIterator_IHolder nodeIt = new NodeIterator_IHolder();
			topoMgr.getProtectSubnetworkViewInfo(how_many, nodeList, nodeIt);
			List<Node> rs = new ArrayList<Node>();
			do{
				Node_T[] nodes = nodeList.value;
				for(Node_T node_t : nodes){
					rs.add(Convertor.convert(node_t));
				}
			}while(nodeIt.value!=null && nodeIt.value.next_n(how_many, nodeList));
			return rs;
		} catch (ProcessingFailureException e) {
			throw new AppException("查询网管拓扑视图中的网元和子网信息失败!",e);
		}
	}
}
