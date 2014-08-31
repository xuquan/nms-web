package com.otn.collector.huawei.delivery.synchronize;

import java.util.ArrayList;
import java.util.List;

import mtnm.tmforum.org.globaldefs.NameAndStringValue_T;

import org.apache.log4j.Logger;

import com.otn.collector.huawei.delivery.beans.TopoManagementManager.Node;
import com.otn.collector.huawei.delivery.beans.TopoManagementManager.Position;
import com.otn.collector.huawei.delivery.beans.ems.Ems;
import com.otn.collector.huawei.delivery.beans.ems.EmsAdditionalInfo;
import com.otn.collector.huawei.delivery.beans.equipment.Cabinet;
import com.otn.collector.huawei.delivery.beans.equipment.Equipment;
import com.otn.collector.huawei.delivery.beans.equipment.EquipmentAdditionalInfo;
import com.otn.collector.huawei.delivery.beans.equipment.EquipmentHolder;
import com.otn.collector.huawei.delivery.beans.equipment.EquipmentHolderAdditionalInfo;
import com.otn.collector.huawei.delivery.beans.equipment.EquipmentOrHolder;
import com.otn.collector.huawei.delivery.beans.equipment.EquipmentRoom;
import com.otn.collector.huawei.delivery.beans.equipment.ObjectAdditionalInfo;
import com.otn.collector.huawei.delivery.beans.equipment.PhysicalLocationInfo;
import com.otn.collector.huawei.delivery.beans.equipment.Shelf;
import com.otn.collector.huawei.delivery.beans.managedElement.ManagedElement;
import com.otn.collector.huawei.delivery.beans.managedElement.ManagedElementAdditionalInfo;
import com.otn.collector.huawei.delivery.beans.multiLayerSubnetwork.MultiLayerSubnetwork;
import com.otn.collector.huawei.delivery.beans.multiLayerSubnetwork.RouteAndTopologicalLink;
import com.otn.collector.huawei.delivery.beans.protection.ProtectionGroup;
import com.otn.collector.huawei.delivery.beans.protection.ProtectionSubnetwork;
import com.otn.collector.huawei.delivery.beans.protection.ProtectionSubnetworkLink;
import com.otn.collector.huawei.delivery.beans.protection.SwitchData;
import com.otn.collector.huawei.delivery.beans.protection.WDMProtectionGroup;
import com.otn.collector.huawei.delivery.beans.protection.WDMSwitchData;
import com.otn.collector.huawei.delivery.beans.subnetworkConnection.CrossConnect;
import com.otn.collector.huawei.delivery.beans.subnetworkConnection.CrossConnectAdditionalInfo;
import com.otn.collector.huawei.delivery.beans.subnetworkConnection.SubnetworkConnection;
import com.otn.collector.huawei.delivery.beans.subnetworkConnection.SubnetworkConnectionAdditionalInfo;
import com.otn.collector.huawei.delivery.beans.subnetworkConnection.TPData;
import com.otn.collector.huawei.delivery.beans.subnetworkConnection.WaveLengthStatus;
import com.otn.collector.huawei.delivery.beans.terminationPoint.TerminationPoint;
import com.otn.collector.huawei.delivery.beans.terminationPoint.TerminationPointAdditionalInfo;
import com.otn.collector.huawei.delivery.beans.topologicalLink.TopologicalLink;
import com.otn.collector.huawei.delivery.beans.topologicalLink.TopologicalLinkAdditionalInfo;
import com.otn.collector.huawei.delivery.beans.trailNtwProtection.TrailNtwProtection;
import com.otn.collector.huawei.delivery.beans.transmissionParameters.LayeredParameters;
import com.otn.collector.huawei.delivery.exception.AppException;
import com.otn.collector.huawei.delivery.northbound.EmsNBI;
import com.otn.collector.huawei.delivery.northbound.EquipmentInventoryNBI;
import com.otn.collector.huawei.delivery.northbound.ManagedElementNBI;
import com.otn.collector.huawei.delivery.northbound.MultiLayerSubnetworkNBI;
import com.otn.collector.huawei.delivery.northbound.ProtectionNBI;
import com.otn.collector.huawei.delivery.northbound.TopoNBI;
import com.otn.common.dbo.hibernate.BaseDAO;

/**
 * 同步管理器
 * @author xuquan
 * 2014-6-22
 */
public class SynchronizeMgr {
	
	private static Logger logger = Logger.getLogger(SynchronizeMgr.class);
	
	private static EmsNBI emsNBI = new EmsNBI();
	private static ManagedElementNBI managedElementNBI = new ManagedElementNBI();
	private static EquipmentInventoryNBI equipmentInventoryNBI = new EquipmentInventoryNBI();
	private static MultiLayerSubnetworkNBI multiLayerSubnetworkNBI = new MultiLayerSubnetworkNBI();
	private static ProtectionNBI protectionNBI = new ProtectionNBI();
	private static TopoNBI topoNBI = new TopoNBI();
	
	/**
	 * 同步EMS网管
	 */
	public static void synchronizeEms(){
		Ems ems = null;
		try {
			ems = emsNBI.getEms();
		} catch (AppException e) {
			logger.error(e);
		}
		BaseDAO.getInstance().add(ems);
		EmsAdditionalInfo additionalInfo = ems.getAdditionalInfo();
		if(additionalInfo!=null){
			additionalInfo.setEmsNameStr(ems.getNameStr());
			BaseDAO.getInstance().add(additionalInfo);
		}
	}
	
	/**
	 * 同步全网物理位置信息
	 */
	public static void synchronizePhysicalLocationInfo(){
		List<PhysicalLocationInfo> physicalLocationInfoList = null;
		try {
			physicalLocationInfoList = equipmentInventoryNBI.getPhysicalLocationInfo();
		} catch (AppException e) {
			logger.error(e);
		}
		if(physicalLocationInfoList==null){
			return;
		}
		for(PhysicalLocationInfo phy : physicalLocationInfoList){
			BaseDAO.getInstance().add(phy);
			String discriminator = phy.getDiscriminator();
			if("EQTROOM".equals(discriminator)){
				EquipmentRoom room = phy.getEquipmentRoom();
				room.setPhysicalLocationInfoId(phy.getId());
				BaseDAO.getInstance().add(room);
			}else if("CABINET".equals(discriminator)){
				Cabinet cabinet = phy.getCabinet();
				cabinet.setPhysicalLocationInfoId(phy.getId());
				BaseDAO.getInstance().add(cabinet);
			}else if("SHELF".equals(discriminator)){
				Shelf shelf = phy.getShelf();
				shelf.setPhysicalLocationInfoId(phy.getId());
				BaseDAO.getInstance().add(shelf);
			}
		}
	}
	
	/**
	 * 同步保护子网
	 */
	public static void synchronizeProtectionSubnetwork(){
		List<ProtectionSubnetwork> protectionSubnetworkList = null;
		try {
			protectionSubnetworkList = protectionNBI.getAllProtectionSubnetworks();
		} catch (AppException e) {
			logger.error(e);
		}
		
		if(protectionSubnetworkList==null){
			return;
		}
		for(ProtectionSubnetwork protectionSubnetwork : protectionSubnetworkList){
			BaseDAO.getInstance().add(protectionSubnetwork);
			List<ProtectionSubnetworkLink> psnLinkList = protectionSubnetwork.getPsnLinkList();
			if(psnLinkList!=null && psnLinkList.size()>0){
				for(int i=0;i<psnLinkList.size();i++){
					ProtectionSubnetworkLink psnLink = psnLinkList.get(i);
					psnLink.setProtectionSubnetworkNameStr(protectionSubnetwork.getNameStr());
					BaseDAO.getInstance().add(psnLink);
				}
			}
		}
	}
	
	/**
	 * 同步拓扑节点信息
	 */
	public static void synchronizeTopoSubnetworkViewInfo(){
		List<Node> nodeList = null;
		try {
			nodeList = topoNBI.getTopoSubnetworkViewInfo();
		} catch (AppException e) {
			logger.error(e);
		}
		if(nodeList!=null && nodeList.size()>0){
			for(Node node : nodeList){
				try {
					BaseDAO.getInstance().add(node);
					Position position = node.getPosition();
					if(position!=null){
						position.setNodeNameStr(node.getNameStr());
						BaseDAO.getInstance().add(position);
					}
				} catch (Exception e) {
					logger.error(e);
				}
			}
		}
		nodeList.clear();
		nodeList = null;
	}
	
	public static void synchronizeManagedElement(){
		//step 1:获取所有网元
		List<ManagedElement> meList = new ArrayList<ManagedElement>();
		try {
			meList = managedElementNBI.getAllManagedElements();
		} catch (AppException e) {
			logger.error(e);
		}
		
		//step 2:遍历每个网元下单板、容器、端口、交叉连接以及保护组信息
		if(meList!=null && meList.size()>0){
			for(int i=0;i<meList.size();i++){
				ManagedElement me = meList.get(i);
				System.out.println(i+"--"+me);
				BaseDAO.getInstance().add(me);
				ManagedElementAdditionalInfo additionalInfo = me.getAdditionalInfo();
				if(additionalInfo!=null){
					additionalInfo.setManagedElementNameStr(me.getNameStr());
					BaseDAO.getInstance().add(additionalInfo);
				}
			}
			meList.clear();
			meList=null;
		}
	}
	
	/**
	 * 同步网元下所有的波分保护组
	 * @param meList
	 */
	public static void synchronizeWDMProtectionGroup(List<ManagedElement> meList){
		for(ManagedElement me : meList){
			List<WDMProtectionGroup> wdmpgList = null;
			try {
				wdmpgList = protectionNBI.getAllWDMProtectionGroups(me.getName());
			} catch (AppException e) {
				logger.error(e);
			}
			if(wdmpgList!=null && wdmpgList.size()>0){
				for(WDMProtectionGroup wdmpg : wdmpgList){
					wdmpg.setManagedElementNameStr(me.getNameStr());
					try {
						BaseDAO.getInstance().add(wdmpg);
					} catch (Exception e) {
						logger.error(e);
					}
				}
			}
		}
	}
	
	/**
	 * 同步网元的所有SDH保护组的详细信息
	 * @param meList
	 */
	public static void synchronizeProtectionGroup(List<ManagedElement> meList){
		for(ManagedElement me : meList){
			//过滤4开头的网元
			String meId = me.getName()[1].value;
			if(meId.startsWith("4")){
				continue;
			}
			List<ProtectionGroup> pgList = null;
			try {
				pgList = protectionNBI.getAllProtectionGroups(me.getName());
			} catch (AppException e) {
				logger.error(e);
			}
			if(pgList!=null && pgList.size()>0){
				for(ProtectionGroup pg : pgList){
					pg.setManagedElementNameStr(me.getNameStr());
					try {
						BaseDAO.getInstance().add(pg);
					} catch (Exception e) {
						logger.error(e);
					}
				}
			}
		}
	}
	
	/**
	 * 同步网元的拓扑连接
	 * @param meList
	 */
	public static void synchronizeTopologicalLink(List<ManagedElement> meList){
		for(ManagedElement me : meList){
			List<TopologicalLink> tlList = null;
			try {
				tlList = multiLayerSubnetworkNBI.getAllInternalTopologicalLinks(me.getName());
			} catch (AppException e) {
				logger.error(e);
			}
			if(tlList!=null && tlList.size()>0){
				for(TopologicalLink tl : tlList){
					try {
						tl.setManagedElementNameStr(me.getNameStr());
						BaseDAO.getInstance().add(tl);
						TopologicalLinkAdditionalInfo additionalInfo = tl.getAdditionalInfo();
						if(additionalInfo!=null){
							additionalInfo.setTopologicalLinkNameStr(tl.getNameStr());
							BaseDAO.getInstance().add(additionalInfo);
						}
					} catch (Exception e) {
						logger.error(e);
					}
				}
			}
		}
	}
	
	/**
	 * 同步网元的所有交叉连接信息
	 * @param meList
	 */
	public static void synchronizeCrossConnect(List<ManagedElement> meList){
		for(ManagedElement me : meList){
			List<CrossConnect> crossConnectList = null;
			try {
				short[] connectionRateList = new short[]{11, 13, 15, 16, 29, 17, 18, 40, 50, 
						104, 105, 106, 107, 108, 109, 335, 8006, 8007, 8031, 8041, 8042};
				crossConnectList = managedElementNBI.getAllCrossConnections(me.getName(), connectionRateList);
			} catch (AppException e) {
				logger.error(e);
			}
			if(crossConnectList!=null && crossConnectList.size()>0){
				for(CrossConnect cc : crossConnectList){
					try {
						cc.setManagedElementNameStr(me.getNameStr());
						BaseDAO.getInstance().add(cc);
						CrossConnectAdditionalInfo additionalInfo = cc.getAdditionalInfo();
						if(additionalInfo!=null){
							additionalInfo.setCrossConnectId(cc.getId());
							BaseDAO.getInstance().add(additionalInfo);
						}
					} catch (Exception e) {
						logger.error(e);
					}
				}
			}
		}
	}
	
	/**
	 * 同步网元的所有物理端口(PTP)信息
	 * @param meList
	 */
	public static void synchronizeTerminationPoint(List<ManagedElement> meList){
		for(ManagedElement me : meList){
			List<TerminationPoint> tpList = null;
			try {
				short[] tpLayerRateList = new short[]{};
				short[] connectionLayerRateList = new short[]{};
				tpList = managedElementNBI.getAllPTPs(me.getName(), tpLayerRateList, connectionLayerRateList);
			} catch (AppException e) {
				logger.error(e);
			}
			if(tpList!=null && tpList.size()>0){
				for(TerminationPoint tp : tpList){
					try {
						tp.setManagedElementNameStr(me.getNameStr());
						BaseDAO.getInstance().add(tp);
						TerminationPointAdditionalInfo additionalInfo = tp.getAdditionalInfo();
						if(additionalInfo!=null){
							additionalInfo.setTerminationPointNameStr(tp.getNameStr());
							BaseDAO.getInstance().add(additionalInfo);
						}
						
						LayeredParameters[] transmissionParams = tp.getTransmissionParams();
						if(transmissionParams!=null && transmissionParams.length>0){
							for(LayeredParameters lp : transmissionParams){
								lp.setTerminationPointNameStr(tp.getNameStr());
								BaseDAO.getInstance().add(lp);
							}
						}
					} catch (Exception e) {
						logger.error(e);
					}
				}
			}
		}
	}
	
	/**
	 * 同步网元下所有单板以及容器信息
	 * @param meList
	 */
	public static void synchronizeEquipment(List<ManagedElement> meList){
		for(ManagedElement me : meList){
			List<EquipmentOrHolder> equipmentOrHolderList = null;
			
			// 处理Optix BWS 1600G
			String meId = me.getName()[1].value;
			if(meId.startsWith("4")){
				List<ObjectAdditionalInfo> objectAdditionalInfoList = null;
				try {
					objectAdditionalInfoList = equipmentInventoryNBI.getAllEquipmentAdditionalInfo(me.getName());
				} catch (AppException e) {
					logger.error(e);
				}
				if(objectAdditionalInfoList!=null && objectAdditionalInfoList.size()>0){
					equipmentOrHolderList = new ArrayList<EquipmentOrHolder>();
					for(ObjectAdditionalInfo oai : objectAdditionalInfoList){
						NameAndStringValue_T[] equipmentOrHolderName = oai.getObjectName();
						EquipmentOrHolder equipmentOrHolder = null;
						try {
							equipmentOrHolder = equipmentInventoryNBI.getEquipment(equipmentOrHolderName);
						} catch (AppException e) {
							logger.error(e);
						}
						if(equipmentOrHolder!=null){
							equipmentOrHolderList.add(equipmentOrHolder);
						}
					}
				}
			}else{
				NameAndStringValue_T[] meOrHolderName = me.getName();
				try {
					equipmentOrHolderList = equipmentInventoryNBI.getAllEquipment(meOrHolderName);
				} catch (AppException e) {
					logger.error(e);
				}
			}
			
			if(equipmentOrHolderList!=null && equipmentOrHolderList.size()>0){
				for(EquipmentOrHolder epOrHolder : equipmentOrHolderList){
					//组装网元的单板和容器
					String discriminator = epOrHolder.getDiscriminator();
					if("EQT_HOLDER".equals(discriminator)){
						EquipmentHolder holder = epOrHolder.getHolder();
						holder.setManagedElementNameStr(me.getNameStr());
						BaseDAO.getInstance().add(holder);
					
						EquipmentHolderAdditionalInfo additionalInfo = holder.getAdditionalInfo();
						if(additionalInfo!=null){
							additionalInfo.setEquipmentHolderNameStr(holder.getNameStr());
							BaseDAO.getInstance().add(additionalInfo);
						}
					}else if("EQT".equals(discriminator)){
						Equipment equipment = epOrHolder.getEquip();
						equipment.setManagedElementNameStr(me.getNameStr());
						BaseDAO.getInstance().add(equipment);
						
						EquipmentAdditionalInfo additionalInfo = equipment.getAdditionalInfo();
						if(additionalInfo!=null){
							additionalInfo.setEquipmentNameStr(equipment.getNameStr());
							BaseDAO.getInstance().add(additionalInfo);
						}
					}
				}
			}
		}
	}
	
	/**
	 * 同步子网
	 */
	public static void synchronizeSubnetwork(){
		//同步子网信息
		List<MultiLayerSubnetwork> subnetworkList = null;
		try {
			subnetworkList = emsNBI.getAllTopLevelSubnetworks();
		} catch (AppException e) {
			logger.error(e);
		}
		
		if(subnetworkList!=null && subnetworkList.size()>0){
			for(MultiLayerSubnetwork subnetwork : subnetworkList){
				BaseDAO.getInstance().add(subnetwork);
			}
			subnetworkList.clear();
			subnetworkList = null;
		}
	}
	
	/**
	 * 同步子网内网元之间的拓扑连接的详细信息
	 */
	public static void synchronizeAllTopologicalLinks(List<MultiLayerSubnetwork> subnetworkList){
		for(MultiLayerSubnetwork subnetwork : subnetworkList){
			List<TopologicalLink> tlList = null;
			try {
				tlList = multiLayerSubnetworkNBI.getAllTopologicalLinks(subnetwork.getName());
			} catch (AppException e) {
				logger.error(e);
			}
			if(tlList!=null && tlList.size()>0){
				for(TopologicalLink tl : tlList){
					tl.setSubnetworkNameStr(subnetwork.getNameStr());
					BaseDAO.getInstance().add(tl);
					TopologicalLinkAdditionalInfo additionalInfo = tl.getAdditionalInfo();
					if(additionalInfo!=null){
						additionalInfo.setTopologicalLinkNameStr(tl.getNameStr());
						BaseDAO.getInstance().add(additionalInfo);
					}
				}
			}
		}
	}
	
	/**
	 * 同步子网内所有子网连接的详细信息
	 * @param subnetwork
	 */
	public static void synchronizeSubnetworkConnection(List<MultiLayerSubnetwork> subnetworkList){
		for(MultiLayerSubnetwork subnetwork : subnetworkList){
			short[] connectionRateList = new short[]{};
			List<SubnetworkConnection> sncList = null;
			try {
				sncList = multiLayerSubnetworkNBI.getAllSubnetworkConnections(subnetwork.getName(), connectionRateList);
			} catch (AppException e) {
				logger.error(e);
			}
			if(sncList!=null && sncList.size()>0){
				for(SubnetworkConnection snc : sncList){
					snc.setSubnetworkNameStr(subnetwork.getNameStr());
					BaseDAO.getInstance().add(snc);
					SubnetworkConnectionAdditionalInfo additionalInfo = snc.getAdditionalInfo();
					if(additionalInfo!=null){
						additionalInfo.setSncNameStr(snc.getNameStr());
						BaseDAO.getInstance().add(additionalInfo);
					}
					
					TPData[] aEnd = snc.getaEnd();
					TPData[] zEnd = snc.getzEnd();
					
					if(aEnd!=null && aEnd.length>0){
						for(TPData tpData : aEnd){
							tpData.setaEndSncNameStr(snc.getNameStr());
							BaseDAO.getInstance().add(tpData);
						}
					}
					
					if(zEnd!=null && zEnd.length>0){
						for(TPData tpData : zEnd){
							tpData.setzEndSncNameStr(snc.getNameStr());
							BaseDAO.getInstance().add(tpData);
						}
					}
				}
			}
		}
	}
	
	public static void deleteTables(){
		try {
			BaseDAO.getInstance().deleteAll(Ems.class.getName());
			BaseDAO.getInstance().deleteAll(EmsAdditionalInfo.class.getName());
			BaseDAO.getInstance().deleteAll(Cabinet.class.getName());
			BaseDAO.getInstance().deleteAll(Equipment.class.getName());
			BaseDAO.getInstance().deleteAll(EquipmentAdditionalInfo.class.getName());
			BaseDAO.getInstance().deleteAll(EquipmentHolder.class.getName());
			BaseDAO.getInstance().deleteAll(EquipmentHolderAdditionalInfo.class.getName());
			BaseDAO.getInstance().deleteAll(EquipmentRoom.class.getName());
			BaseDAO.getInstance().deleteAll(ObjectAdditionalInfo.class.getName());
			BaseDAO.getInstance().deleteAll(PhysicalLocationInfo.class.getName());
			BaseDAO.getInstance().deleteAll(ManagedElement.class.getName());
			BaseDAO.getInstance().deleteAll(ManagedElementAdditionalInfo.class.getName());
			BaseDAO.getInstance().deleteAll(MultiLayerSubnetwork.class.getName());
			BaseDAO.getInstance().deleteAll(RouteAndTopologicalLink.class.getName());
			BaseDAO.getInstance().deleteAll(ProtectionGroup.class.getName());
			BaseDAO.getInstance().deleteAll(ProtectionSubnetwork.class.getName());
			BaseDAO.getInstance().deleteAll(ProtectionSubnetworkLink.class.getName());
			BaseDAO.getInstance().deleteAll(SwitchData.class.getName());
			BaseDAO.getInstance().deleteAll(WDMProtectionGroup.class.getName());
			BaseDAO.getInstance().deleteAll(WDMSwitchData.class.getName());
			BaseDAO.getInstance().deleteAll(CrossConnect.class.getName());
			BaseDAO.getInstance().deleteAll(CrossConnectAdditionalInfo.class.getName());
			BaseDAO.getInstance().deleteAll(SubnetworkConnection.class.getName());
			BaseDAO.getInstance().deleteAll(SubnetworkConnectionAdditionalInfo.class.getName());
			BaseDAO.getInstance().deleteAll(TPData.class.getName());
			BaseDAO.getInstance().deleteAll(WaveLengthStatus.class.getName());
			BaseDAO.getInstance().deleteAll(TerminationPoint.class.getName());
			BaseDAO.getInstance().deleteAll(TerminationPointAdditionalInfo.class.getName());
			BaseDAO.getInstance().deleteAll(TopologicalLink.class.getName());
			BaseDAO.getInstance().deleteAll(TopologicalLinkAdditionalInfo.class.getName());
			BaseDAO.getInstance().deleteAll(Node.class.getName());
			BaseDAO.getInstance().deleteAll(Position.class.getName());
			BaseDAO.getInstance().deleteAll(TrailNtwProtection.class.getName());
			BaseDAO.getInstance().deleteAll(LayeredParameters.class.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
