package com.otn.collector.huawei.delivery.factory;

import java.util.HashMap;
import java.util.Map;

import mtnm.tmforum.org.TopoManagementManager.TopoMgr_I;
import mtnm.tmforum.org.TopoManagementManager.TopoMgr_IHelper;
import mtnm.tmforum.org.common.Common_IHolder;
import mtnm.tmforum.org.emsMgr.EMSMgr_I;
import mtnm.tmforum.org.emsMgr.EMSMgr_IHelper;
import mtnm.tmforum.org.emsSession.EmsSession_I;
import mtnm.tmforum.org.equipment.EquipmentInventoryMgr_I;
import mtnm.tmforum.org.equipment.EquipmentInventoryMgr_IHelper;
import mtnm.tmforum.org.globaldefs.ProcessingFailureException;
import mtnm.tmforum.org.managedElementManager.ManagedElementMgr_I;
import mtnm.tmforum.org.managedElementManager.ManagedElementMgr_IHelper;
import mtnm.tmforum.org.multiLayerSubnetwork.MultiLayerSubnetworkMgr_I;
import mtnm.tmforum.org.multiLayerSubnetwork.MultiLayerSubnetworkMgr_IHelper;
import mtnm.tmforum.org.protection.ProtectionMgr_I;
import mtnm.tmforum.org.protection.ProtectionMgr_IHelper;
import trailNtwProtection.TrailNtwProtMgr_I;
import trailNtwProtection.TrailNtwProtMgr_IHelper;

import com.otn.collector.huawei.delivery.connection.CorbaConnection;

/**
 * Bean工厂
 * @author xuquan
 * 2014-6-5
 */
public class BeanFactory {
	private static BeanFactory instance = new BeanFactory();
	
	//存放产品{key=产品编号, value=具体产品实例}
	private Map<String,Object> beans = new HashMap<String,Object>();
	
	private BeanFactory(){
		
	}
	
	public static BeanFactory getInstance(){
		return instance;
	}
	
	public synchronized Object getBean(Class<?> cls){
		String beanName = cls.getSimpleName();
		synchronized (beans) {
			//如果在Map存在已经创建的产品则返回
			if(beans.containsKey(beanName)){
				return beans.get(beanName);
			}
			
			Object object = null;
			Common_IHolder commonHolder = new Common_IHolder();
			EmsSession_I emsSession = CorbaConnection.getInstance().getEmsSession();
			
			try {
				if("EMSMgr_I".equals(beanName)){
					emsSession.getManager("EMS", commonHolder);
					EMSMgr_I emsMgr = EMSMgr_IHelper.narrow(commonHolder.value);
					object = emsMgr;
					beans.put(beanName, emsMgr);
				}else if("ManagedElementMgr_I".equals(beanName)){
					emsSession.getManager("ManagedElement", commonHolder);
					ManagedElementMgr_I managedElementMgr = ManagedElementMgr_IHelper.narrow(commonHolder.value);
					object = managedElementMgr;
					beans.put(beanName, managedElementMgr);
				}else if("EquipmentInventoryMgr_I".equals(beanName)){
					emsSession.getManager("EquipmentInventory", commonHolder);
					EquipmentInventoryMgr_I equipmentInventoryMgr = EquipmentInventoryMgr_IHelper.narrow(commonHolder.value);
					object = equipmentInventoryMgr;
					beans.put(beanName, equipmentInventoryMgr);
				}else if("MultiLayerSubnetworkMgr_I".equals(beanName)){
					emsSession.getManager("MultiLayerSubnetwork", commonHolder);
					MultiLayerSubnetworkMgr_I multiLayerSubnetworkMgr = MultiLayerSubnetworkMgr_IHelper.narrow(commonHolder.value);
					object = multiLayerSubnetworkMgr;
					beans.put(beanName, multiLayerSubnetworkMgr);
				}else if("ProtectionMgr_I".equals(beanName)){
					emsSession.getManager("Protection", commonHolder);
					ProtectionMgr_I protectionMgr = ProtectionMgr_IHelper.narrow(commonHolder.value);
					object = protectionMgr;
					beans.put(beanName, protectionMgr);
				}else if("TopoMgr_I".equals(beanName)){
					emsSession.getManager("TopoManagement", commonHolder);
					TopoMgr_I topoMgr = TopoMgr_IHelper.narrow(commonHolder.value);
					object = topoMgr;
					beans.put(beanName, topoMgr);
				}else if("TrailNtwProtMgr_I".equals(beanName)){
					emsSession.getManager("TrailNetworkProtection", commonHolder);
					TrailNtwProtMgr_I trailNtwProtMgr = TrailNtwProtMgr_IHelper.narrow(commonHolder.value);
					object = trailNtwProtMgr;
					beans.put(beanName, trailNtwProtMgr);
				}
			} catch (ProcessingFailureException e) {
				e.printStackTrace();
			}
			return object;
		}
	}
}
