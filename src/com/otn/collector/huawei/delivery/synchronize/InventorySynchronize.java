package com.otn.collector.huawei.delivery.synchronize;

import java.util.List;

import com.otn.collector.huawei.delivery.beans.managedElement.ManagedElement;
import com.otn.collector.huawei.delivery.beans.multiLayerSubnetwork.MultiLayerSubnetwork;
import com.otn.collector.huawei.delivery.connection.CorbaConnection;
import com.otn.common.dbo.hibernate.BaseDAO;

/**
 * 存量数据同步
 * @author xuquan
 * 2014-6-22
 */
public class InventorySynchronize {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SynchronizeMgr.deleteTables();
		SynchronizeMgr.synchronizeEms();
		SynchronizeMgr.synchronizePhysicalLocationInfo();
		SynchronizeMgr.synchronizeProtectionSubnetwork();
		SynchronizeMgr.synchronizeTopoSubnetworkViewInfo();
		
		
		SynchronizeMgr.synchronizeManagedElement();
		List<ManagedElement> meList = null;
		try {
			meList = (List<ManagedElement>) BaseDAO.getInstance().getList(ManagedElement.class.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		SynchronizeMgr.synchronizeEquipment(meList);
		SynchronizeMgr.synchronizeTerminationPoint(meList);
		SynchronizeMgr.synchronizeCrossConnect(meList);
		SynchronizeMgr.synchronizeTopologicalLink(meList);
		SynchronizeMgr.synchronizeProtectionGroup(meList);
		SynchronizeMgr.synchronizeWDMProtectionGroup(meList);
		
		
		SynchronizeMgr.synchronizeSubnetwork();
		List<MultiLayerSubnetwork> subnetworkList = null;
		try {
			subnetworkList = (List<MultiLayerSubnetwork>) BaseDAO.getInstance().getList(MultiLayerSubnetwork.class.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		SynchronizeMgr.synchronizeSubnetworkConnection(subnetworkList);
		SynchronizeMgr.synchronizeAllTopologicalLinks(subnetworkList);
		
		//主线程等待30秒，等待hibernate保存完成
		try {
			Thread.sleep(1000*30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CorbaConnection.getInstance().closeEmsSession();
	}

	
}
