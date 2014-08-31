package com.otn.collector.huawei.delivery.northbound;

import java.util.ArrayList;
import java.util.List;

import mtnm.tmforum.org.emsMgr.EMSMgr_I;
import mtnm.tmforum.org.emsMgr.EMS_T;
import mtnm.tmforum.org.emsMgr.EMS_THolder;
import mtnm.tmforum.org.globaldefs.NameAndStringValue_T;
import mtnm.tmforum.org.globaldefs.NamingAttributesIterator_IHolder;
import mtnm.tmforum.org.globaldefs.NamingAttributesList_THolder;
import mtnm.tmforum.org.globaldefs.ProcessingFailureException;
import mtnm.tmforum.org.multiLayerSubnetwork.MultiLayerSubnetwork_T;
import mtnm.tmforum.org.multiLayerSubnetwork.SubnetworkIterator_IHolder;
import mtnm.tmforum.org.multiLayerSubnetwork.SubnetworkList_THolder;
import mtnm.tmforum.org.topologicalLink.TopologicalLinkIterator_IHolder;
import mtnm.tmforum.org.topologicalLink.TopologicalLinkList_THolder;
import mtnm.tmforum.org.topologicalLink.TopologicalLink_T;

import com.otn.collector.huawei.delivery.beans.ems.Ems;
import com.otn.collector.huawei.delivery.beans.multiLayerSubnetwork.MultiLayerSubnetwork;
import com.otn.collector.huawei.delivery.beans.topologicalLink.TopologicalLink;
import com.otn.collector.huawei.delivery.convertor.Convertor;
import com.otn.collector.huawei.delivery.exception.AppException;
import com.otn.collector.huawei.delivery.factory.BeanFactory;

/**
 * 网元系统管理接口
 * @author xuquan
 * 2014-6-3
 */
public class EmsNBI {
	
	private EMSMgr_I emsMgr = (EMSMgr_I) BeanFactory.getInstance().getBean(EMSMgr_I.class);
	
	/**
	 * 获取网管信息
	 * @return Ems
	 * @throws AppException 
	 */
	public Ems getEms() throws AppException{
		EMS_THolder emsHolder = new EMS_THolder();
		try {
			emsMgr.getEMS(emsHolder);
		} catch (ProcessingFailureException e) {
			throw new AppException("获取网管信息失败!",e);
		}
		EMS_T ems_t = emsHolder.value;
		Ems ems = Convertor.convert(ems_t);
		return ems;
	}
	
	/**
	 * 该接口查询网管系统中所有子网名称
	 * @return 所有子网名称
	 * @throws AppException 
	 */
	public List<NameAndStringValue_T[][]> getAllTopLevelSubnetworkNames() throws AppException{
		int how_many=1;
		NamingAttributesList_THolder nameList = new NamingAttributesList_THolder();
		NamingAttributesIterator_IHolder nameIt = new NamingAttributesIterator_IHolder();
		List<NameAndStringValue_T[][]> subnetworkNames = new ArrayList<NameAndStringValue_T[][]>();
		try {
			emsMgr.getAllTopLevelSubnetworkNames(how_many, nameList, nameIt);
			do{
				NameAndStringValue_T[][] names = nameList.value;
				subnetworkNames.add(names);
			}while(nameIt.value!=null && nameIt.value.next_n(how_many, nameList));
		} catch (ProcessingFailureException e) {
			throw new AppException("获取网管系统中所有子网名称失败!",e);
		}
		return subnetworkNames;
	}
	
	/**
	 * 该接口查询网管系统中所有子网的详细信息
	 * @return 所有子网
	 * @throws AppException 
	 */
	public List<MultiLayerSubnetwork> getAllTopLevelSubnetworks() throws AppException{
		int how_many=1;
		SubnetworkList_THolder sList = new SubnetworkList_THolder();
		SubnetworkIterator_IHolder sIt = new SubnetworkIterator_IHolder();
		List<MultiLayerSubnetwork> list = new ArrayList<MultiLayerSubnetwork>();
		try {
			emsMgr.getAllTopLevelSubnetworks(how_many, sList, sIt);
			do{
				MultiLayerSubnetwork_T[] subnetworks = sList.value;
				for(int i=0;i<subnetworks.length;i++){
					MultiLayerSubnetwork subnetwork = Convertor.convert(subnetworks[i]);
					list.add(subnetwork);
				}
			}while(sIt.value!=null && sIt.value.next_n(how_many, sList));
		} catch (ProcessingFailureException e) {
			throw new AppException("获取网管系统中所有子网失败!",e);
		}
		return list;
	}
	
	/**
	 * 该接口查询网管内所有顶层Topo子网之间的光纤连接的名称
	 * 由于U2000 只有一个Topo子网，不存在子网之间的光纤连接
	 * @return
	 * @throws AppException 
	 */
	public List<NameAndStringValue_T[][]> getAllTopLevelTopologicalLinkNames() throws AppException{
		int how_many=10;
		NamingAttributesList_THolder nameList = new NamingAttributesList_THolder();
		NamingAttributesIterator_IHolder nameIt = new NamingAttributesIterator_IHolder();
		List<NameAndStringValue_T[][]> topologicalLinkNames = new ArrayList<NameAndStringValue_T[][]>();
		try {
			emsMgr.getAllTopLevelTopologicalLinkNames(how_many, nameList, nameIt);
			do{
				NameAndStringValue_T[][] names = nameList.value;
				topologicalLinkNames.add(names);
			}while(nameIt.value!=null && nameIt.value.next_n(how_many, nameList));
			return topologicalLinkNames;
		} catch (ProcessingFailureException e) {
			throw new AppException("网管内所有顶层Topo子网之间的光纤连接的名称!",e);
		}
	}
	
	/**
	 * 该接口查询网管内所有顶层Topo子网之间的光纤连接的详细信息
	 * 由于U2000只有一个Topo子网，不存在子网直接的光纤连接
	 * @return
	 * @throws AppException
	 */
	public List<TopologicalLink> getAllTopLevelTopologicalLinks() throws AppException{
		int how_many=1;
		TopologicalLinkList_THolder topoList = new TopologicalLinkList_THolder();
		TopologicalLinkIterator_IHolder topoIt = new TopologicalLinkIterator_IHolder();
		List<TopologicalLink> list = new ArrayList<TopologicalLink>();
		try {
			emsMgr.getAllTopLevelTopologicalLinks(how_many, topoList, topoIt);
			do{
				TopologicalLink_T[] topologicalLinks = topoList.value;
				for(int i=0;i<topologicalLinks.length;i++){
					TopologicalLink topologicalLink = Convertor.convert(topologicalLinks[i]);
					list.add(topologicalLink);
				}
			}while(topoIt.value!=null && topoIt.value.next_n(how_many, topoList));
			return list;
		} catch (ProcessingFailureException e) {
			throw new AppException("查询网管内所有顶层Topo子网之间的光纤连接的详细信息!",e);
		}
	}
}
