package com.otn.collector.huawei.delivery.convertor;

import java.util.ArrayList;
import java.util.List;

import mtnm.tmforum.org.TopoManagementManager.Node_T;
import mtnm.tmforum.org.TopoManagementManager.Position_T;
import mtnm.tmforum.org.emsMgr.EMS_T;
import mtnm.tmforum.org.equipment.Cabinet_T;
import mtnm.tmforum.org.equipment.EquipmentHolder_T;
import mtnm.tmforum.org.equipment.EquipmentRoom_T;
import mtnm.tmforum.org.equipment.Equipment_T;
import mtnm.tmforum.org.equipment.ObjectAdditionalInfo_T;
import mtnm.tmforum.org.equipment.PhysicalLocationInfo_T;
import mtnm.tmforum.org.equipment.Shelf_T;
import mtnm.tmforum.org.globaldefs.NameAndStringValue_T;
import mtnm.tmforum.org.managedElement.ManagedElement_T;
import mtnm.tmforum.org.multiLayerSubnetwork.MultiLayerSubnetwork_T;
import mtnm.tmforum.org.multiLayerSubnetwork.RouteAndTopologicalLink_T;
import mtnm.tmforum.org.protection.ProtectionGroup_T;
import mtnm.tmforum.org.protection.ProtectionSubnetworkLink_T;
import mtnm.tmforum.org.protection.ProtectionSubnetwork_T;
import mtnm.tmforum.org.protection.SwitchData_T;
import mtnm.tmforum.org.protection.WDMProtectionGroup_T;
import mtnm.tmforum.org.protection.WDMSwitchData_T;
import mtnm.tmforum.org.subnetworkConnection.CrossConnect_T;
import mtnm.tmforum.org.subnetworkConnection.SubnetworkConnection_T;
import mtnm.tmforum.org.subnetworkConnection.TPData_T;
import mtnm.tmforum.org.subnetworkConnection.WaveLengthStatus_T;
import mtnm.tmforum.org.terminationPoint.TerminationPoint_T;
import mtnm.tmforum.org.topologicalLink.TopologicalLink_T;
import mtnm.tmforum.org.transmissionParameters.LayeredParameters_T;
import trailNtwProtection.TrailNtwProtection_T;

import com.otn.collector.huawei.delivery.beans.TopoManagementManager.Node;
import com.otn.collector.huawei.delivery.beans.TopoManagementManager.Position;
import com.otn.collector.huawei.delivery.beans.ems.Ems;
import com.otn.collector.huawei.delivery.beans.ems.EmsAdditionalInfo;
import com.otn.collector.huawei.delivery.beans.equipment.Cabinet;
import com.otn.collector.huawei.delivery.beans.equipment.Equipment;
import com.otn.collector.huawei.delivery.beans.equipment.EquipmentAdditionalInfo;
import com.otn.collector.huawei.delivery.beans.equipment.EquipmentHolder;
import com.otn.collector.huawei.delivery.beans.equipment.EquipmentHolderAdditionalInfo;
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

/**
 * 数据类型转换器
 * @author xuquan
 * 2014-6-5
 */
public class Convertor {
	
	public static Ems convert(EMS_T ems_t){
		Ems ems = new Ems();
		ems.setEmsVersion(ems_t.emsVersion);
		ems.setNativeEMSName(ems_t.nativeEMSName);
		ems.setOwner(ems_t.owner);
		ems.setType(ems_t.type);
		ems.setUserLabel(ems_t.userLabel);
		ems.setName(ems_t.name);
		NameAndStringValue_T[] additionInfos = ems_t.additionalInfo;
		if(additionInfos!=null && additionInfos.length>0){
			EmsAdditionalInfo additionalInfo = new EmsAdditionalInfo();
			for(NameAndStringValue_T nv : additionInfos){
				String name = nv.name;
				String value = nv.value;
				if("alarmSeverity".equals(name)){
					additionalInfo.setAlarmSeverity(value);
				}else if("location".equalsIgnoreCase(name)){
					additionalInfo.setLocation(value);
				}else if("commuAddress".equalsIgnoreCase(name)){
					additionalInfo.setCommuAddress(value);
				}else if("emsTime".equalsIgnoreCase(name)){
					additionalInfo.setEmsTime(value);
				}else if("interfaceVersion".equalsIgnoreCase(name)){
					additionalInfo.setInterfaceVersion(value);
				}else if("emsState".equalsIgnoreCase(name)){
					additionalInfo.setEmsState(value);
				}else if("administrativeState".equalsIgnoreCase(name)){
					additionalInfo.setAdministrativeState(value);
				}
			}
			ems.setAdditionalInfo(additionalInfo);
		}
		return ems;
	}
	
	public static MultiLayerSubnetwork convert(MultiLayerSubnetwork_T subnetwork_t){
		MultiLayerSubnetwork subnetwork = new MultiLayerSubnetwork();
		subnetwork.setName(subnetwork_t.name);
		subnetwork.setUserLabel(subnetwork_t.userLabel);
		subnetwork.setNativeEMSName(subnetwork_t.nativeEMSName);
		subnetwork.setOwner(subnetwork_t.owner);
		subnetwork.setSubnetworkType(subnetwork_t.subnetworkType.toString());
		subnetwork.setSupportedRates(subnetwork_t.supportedRates);
		NameAndStringValue_T[] additionInfos = subnetwork_t.additionalInfo;
		if(additionInfos!=null && additionInfos.length>0){
			for(NameAndStringValue_T nv : additionInfos){
				String name = nv.name;
				String value = nv.value;
				if("multiLayerSubnetworkLocation".equalsIgnoreCase(name)){
					subnetwork.setMultiLayerSubnetworkLocation(value);
				}
			}
		}
		return subnetwork;
	}
	
	public static TopologicalLink convert(TopologicalLink_T topologicalLink_t){
		TopologicalLink topologicalLink = new TopologicalLink();
		topologicalLink.setName(topologicalLink_t.name);
		topologicalLink.setUserLabel(topologicalLink_t.userLabel);
		topologicalLink.setNativeEMSName(topologicalLink_t.nativeEMSName);
		topologicalLink.setOwner(topologicalLink_t.owner);
		topologicalLink.setDirection(topologicalLink_t.direction.toString());
		topologicalLink.setRate(topologicalLink_t.rate);
		topologicalLink.setaEndTP(topologicalLink_t.aEndTP);
		topologicalLink.setzEndTP(topologicalLink_t.zEndTP);
		NameAndStringValue_T[] additionInfos = topologicalLink_t.additionalInfo;
		if(additionInfos!=null && additionInfos.length>0){
			TopologicalLinkAdditionalInfo additionalInfo = new TopologicalLinkAdditionalInfo();
			for(NameAndStringValue_T nv : additionInfos){
				String name = nv.name;
				String value = nv.value;
				if("memo".equals(name)){
					additionalInfo.setMemo(value);
				}else if("linkType".equalsIgnoreCase(name)){
					additionalInfo.setLinkType(value);
				}
			}
			topologicalLink.setAdditionalInfo(additionalInfo);
		}
		return topologicalLink;
	}
		
	public static ManagedElement convert(ManagedElement_T me_t){
		ManagedElement me = new ManagedElement();
		me.setName(me_t.name);
		me.setUserLabel(me_t.userLabel);
		me.setNativeEMSName(me_t.nativeEMSName);
		me.setOwner(me_t.owner);
		me.setLocation(me_t.location);
		me.setVersion(me_t.version);
		me.setProductName(me_t.productName);
		me.setCommunicationState(me_t.communicationState.toString());
		me.setEmsInSyncState(me_t.emsInSyncState);
		me.setSupportedRates(me_t.supportedRates);
		NameAndStringValue_T[] additionInfos = me_t.additionalInfo;
		if(additionInfos!=null && additionInfos.length>0){
			ManagedElementAdditionalInfo additionalInfo = new ManagedElementAdditionalInfo();
			for(NameAndStringValue_T nv : additionInfos){
				String name = nv.name;
				String value = nv.value;
				if("phyInfo".equals(name)){
					additionalInfo.setPhyInfo(value);
				}else if("gateWay".equalsIgnoreCase(name)){
					additionalInfo.setGateWay(value);
				}else if("alarmSeverity".equalsIgnoreCase(name)){
					additionalInfo.setAlarmSeverity(value);
				}else if("shelfType".equalsIgnoreCase(name)){
					additionalInfo.setShelfType(value);
				}else if("preConfig".equalsIgnoreCase(name)){
					additionalInfo.setPreConfig(value);
				}else if("maxTransferRate".equalsIgnoreCase(name)){
					additionalInfo.setMaxTransferRate(value);
				}else if("subnetwork".equalsIgnoreCase(name)){
					additionalInfo.setSubnetwork(value);
				}else if("psnName".equalsIgnoreCase(name)){
					additionalInfo.setPsnName(value);
				}else if("lsrID".equalsIgnoreCase(name)){
					additionalInfo.setLsrID(value);
				}else if("ipAddress".equalsIgnoreCase(name)){
					additionalInfo.setIpAddress(value);
				}else if("waveNumber".equalsIgnoreCase(name)){
					additionalInfo.setWaveNumber(value);
				}
			}
			me.setAdditionalInfo(additionalInfo);
		}
		return me;
	}
	
	public static EquipmentHolder convert(EquipmentHolder_T eqHolder_t){
		EquipmentHolder epHolder = new EquipmentHolder();
		epHolder.setName(eqHolder_t.name);
		epHolder.setUserLabel(eqHolder_t.userLabel);
		epHolder.setNativeEMSName(eqHolder_t.nativeEMSName);
		epHolder.setOwner(eqHolder_t.owner);
		epHolder.setAlarmReportingIndicator(eqHolder_t.alarmReportingIndicator);
		epHolder.setHolderType(eqHolder_t.holderType);
		epHolder.setExpectedOrInstalledEquipment(eqHolder_t.expectedOrInstalledEquipment);
		epHolder.setAcceptableEquipmentTypeList(eqHolder_t.acceptableEquipmentTypeList);
		epHolder.setHolderState(eqHolder_t.holderState.toString());
		NameAndStringValue_T[] additionInfos = eqHolder_t.additionalInfo;
		if(additionInfos!=null && additionInfos.length>0){
			EquipmentHolderAdditionalInfo additionalInfo = new EquipmentHolderAdditionalInfo();
			for(NameAndStringValue_T nv : additionInfos){
				String name = nv.name;
				String value = nv.value;
				if("alarmSeverity".equals(name)){
					additionalInfo.setAlarmSeverity(value);
				}else if("phyInfo".equalsIgnoreCase(name)){
					additionalInfo.setPhyInfo(value);
				}else if("gateWay".equalsIgnoreCase(name)){
					additionalInfo.setGateWay(value);
				}else if("version".equalsIgnoreCase(name)){
					additionalInfo.setVersion(value);
				}else if("productName".equalsIgnoreCase(name)){
					additionalInfo.setProductName(value);
				}else if("shelfType".equalsIgnoreCase(name)){
					additionalInfo.setShelfType(value);
				}else if("preConfig".equalsIgnoreCase(name)){
					additionalInfo.setPreConfig(value);
				}
			}
			epHolder.setAdditionalInfo(additionalInfo);
		}
		return epHolder;
	}
	
	public static Equipment convert(Equipment_T ep_t){
		Equipment ep = new Equipment();
		ep.setName(ep_t.name);
		ep.setUserLabel(ep_t.userLabel);
		ep.setNativeEMSName(ep_t.nativeEMSName);
		ep.setOwner(ep_t.owner);
		ep.setAlarmReportingIndicator(ep_t.alarmReportingIndicator);
		ep.setServiceState(ep_t.serviceState.toString());
		ep.setExpectedEquipmentObjectType(ep_t.expectedEquipmentObjectType);
		ep.setInstalledEquipmentObjectType(ep_t.installedEquipmentObjectType);
		ep.setInstalledPartNumber(ep_t.installedPartNumber);
		ep.setInstalledVersion(ep_t.installedVersion);
		ep.setInstalledSerialNumber(ep_t.installedSerialNumber);
		NameAndStringValue_T[] additionInfos = ep_t.additionalInfo;
		if(additionInfos!=null && additionInfos.length>0){
			EquipmentAdditionalInfo additionalInfo = new EquipmentAdditionalInfo();
			for(NameAndStringValue_T nv : additionInfos){
				String name = nv.name;
				String value = nv.value;
				if("alarmSeverity".equals(name)){
					additionalInfo.setAlarmSeverity(value);
				}else if("hardwareVersion".equalsIgnoreCase(name)){
					additionalInfo.setHardwareVersion(value);
				}else if("port_XX_SFP".equalsIgnoreCase(name)){
					additionalInfo.setPort_XX_SFP(value);
				}else if("port_X_SFP_BarCode".equalsIgnoreCase(name)){
					additionalInfo.setPort_X_SFP_BarCode(value);
				}else if("manufactured".equalsIgnoreCase(name)){
					additionalInfo.setManufactured(value);
				}else if("clei".equalsIgnoreCase(name)){
					additionalInfo.setClei(value);
				}else if("port_X_SFP_CLEI".equalsIgnoreCase(name)){
					additionalInfo.setPort_X_SFP_CLEI(value);
				}else if("port_X_SFP_Item".equalsIgnoreCase(name)){
					additionalInfo.setPort_X_SFP_Item(value);
				}else if("port_X_SFP_Manufactured".equalsIgnoreCase(name)){
					additionalInfo.setPort_X_SFP_Manufactured(value);
				}
			}
			ep.setAdditionalInfo(additionalInfo);
		}
		return ep;
	}
	
	public static ObjectAdditionalInfo convert(ObjectAdditionalInfo_T objectAdditionalInfo_t){
		ObjectAdditionalInfo rs = new ObjectAdditionalInfo();
		rs.setObjectName(objectAdditionalInfo_t.objectName);
		rs.setAdditionalInfo(objectAdditionalInfo_t.additionalInfo);
		return rs;
	}
	
	public static PhysicalLocationInfo convert(PhysicalLocationInfo_T phyLocationInfo_t){
		PhysicalLocationInfo phyLocationInfo = new PhysicalLocationInfo();
		Shelf shelf = null;
		EquipmentRoom equipmentRoom = null;
		Cabinet cabinet = null;
		String discriminator = phyLocationInfo_t.discriminator().toString();
		if("EQTROOM".equals(discriminator)){
			equipmentRoom = Convertor.convert(phyLocationInfo_t.equipRoom());
		}else if("CABINET".equals(discriminator)){
			cabinet = Convertor.convert(phyLocationInfo_t.cabinet_());
		}else if("SHELF".equals(discriminator)){
			shelf = Convertor.convert(phyLocationInfo_t.shelf_());
		}
		phyLocationInfo.setDiscriminator(discriminator);
		phyLocationInfo.setEquipmentRoom(equipmentRoom);
		phyLocationInfo.setCabinet(cabinet);
		phyLocationInfo.setShelf(shelf);
		return phyLocationInfo;
	}
	
	public static EquipmentRoom convert(EquipmentRoom_T equipmentRoom_t){
		EquipmentRoom er = new EquipmentRoom();
		er.setName(equipmentRoom_t.name);
		er.setContainedCabinet(equipmentRoom_t.containedCabinet);
		er.setContainedNMManager(equipmentRoom_t.containedNMManager);
		er.setCountry(equipmentRoom_t.country);
		er.setProvince(equipmentRoom_t.province);
		er.setCity(equipmentRoom_t.city);
		er.setSite(equipmentRoom_t.site);
		er.setLocation(equipmentRoom_t.location);
		er.setCableArrange(equipmentRoom_t.cableArrange);
		er.setDefendStaticFloor(equipmentRoom_t.defendStaticFloor);
		er.setFloorHeight(equipmentRoom_t.floorHeight);
		er.setMemo(equipmentRoom_t.memo);
		return er;
	}
	
	public static Cabinet convert(Cabinet_T cabinet_t){
		Cabinet cabinet = new Cabinet();
		cabinet.setName(cabinet_t.name);
		cabinet.setEquipmentRoomName(cabinet_t.equipmentRoomName);
		cabinet.setContainedShelfList(cabinet_t.containedShelfList);
		cabinet.setType(cabinet_t.type);
		cabinet.setHeight(cabinet_t.height);
		cabinet.setWidth(cabinet_t.width);
		cabinet.setDepth(cabinet_t.depth);
		cabinet.setVoltage(cabinet_t.voltage);
		cabinet.setPowerBoxType(cabinet_t.powerBoxType);
		cabinet.setMemo(cabinet_t.memo);
		return cabinet;
	}
	
	public static Shelf convert(Shelf_T shelf_t){
		Shelf shelf = new Shelf();
		shelf.setName(shelf_t.name);
		shelf.setEquipmentRoomName(shelf_t.equipmentRoomName);
		shelf.setCabinetName(shelf_t.cabinetName);
		shelf.setNumbering(shelf_t.numbering);
		shelf.setLocationOfCabinet(shelf_t.locationOfCabinet);
		shelf.setMemo(shelf_t.memo);
		return shelf;
	}
	
	public static CrossConnect convert(CrossConnect_T crossConnect_t){
		CrossConnect crossConnect = new CrossConnect();
		crossConnect.setActive(crossConnect_t.active);
		crossConnect.setDirection(crossConnect_t.direction.toString());
		crossConnect.setCcType(crossConnect_t.ccType.toString());
		crossConnect.setaEndNameList(crossConnect_t.aEndNameList);
		crossConnect.setzEndNameList(crossConnect_t.zEndNameList);
		NameAndStringValue_T[] additionInfos = crossConnect_t.additionalInfo;
		if(additionInfos!=null && additionInfos.length>0){
			CrossConnectAdditionalInfo additionalInfo = new CrossConnectAdditionalInfo();
			for(NameAndStringValue_T nv : additionInfos){
				String name = nv.name;
				String value = nv.value;
				if("direction".equals(name)){
					additionalInfo.setDirection(value);
				}else if("protectionRole".equalsIgnoreCase(name)){
					additionalInfo.setProtectionRole(value);
				}else if("fixed".equalsIgnoreCase(name)){
					additionalInfo.setFixed(value);
				}else if("clientType".equalsIgnoreCase(name)){
					additionalInfo.setClientType(value);
				}else if("clientRate".equalsIgnoreCase(name)){
					additionalInfo.setClientRate(value);
				}else if("frequency".equalsIgnoreCase(name)){
					additionalInfo.setFrequency(value);
				}else if("oduk_TimeSlot".equalsIgnoreCase(name)){
					additionalInfo.setOduk_TimeSlot(value);
				}
			}
			crossConnect.setAdditionalInfo(additionalInfo);
		}
		
		return crossConnect;
	}
	
	public static SubnetworkConnection convert(SubnetworkConnection_T snc_t){
		SubnetworkConnection snc = new SubnetworkConnection();
		snc.setName(snc_t.name);
		snc.setUserLabel(snc_t.userLabel);
		snc.setNativeEMSName(snc_t.nativeEMSName);
		snc.setOwner(snc_t.owner);
		snc.setSncState(snc_t.sncState.toString());
		snc.setDirection(snc_t.direction.toString());
		snc.setRate(snc_t.rate);
		snc.setStaticProtectionLevel(snc_t.staticProtectionLevel.toString());
		snc.setSncType(snc_t.sncType.toString());
		
		TPData_T[] aEnds = snc_t.aEnd;
		TPData[] aEndList = new TPData[aEnds.length];
		for(int i=0;i<aEnds.length;i++){
			aEndList[i] = Convertor.convert(aEnds[i]);
		}
		snc.setaEnd(aEndList);
		
		TPData_T[] zEnds = snc_t.zEnd;
		TPData[] zEndList = new TPData[zEnds.length];
		for(int i=0;i<zEnds.length;i++){
			zEndList[i] = Convertor.convert(zEnds[i]);
		}
		snc.setzEnd(zEndList);
		
		snc.setRerouteAllowed(snc_t.rerouteAllowed.toString());
		snc.setNetworkRouted(snc_t.networkRouted.toString());
		NameAndStringValue_T[] additionInfos = snc_t.additionalInfo;
		if(additionInfos!=null && additionInfos.length>0){
			SubnetworkConnectionAdditionalInfo additionalInfo = new SubnetworkConnectionAdditionalInfo();
			for(NameAndStringValue_T nv : additionInfos){
				String name = nv.name;
				String value = nv.value;
				if("ovpnCustomer".equals(name)){
					additionalInfo.setOvpnCustomer(value);
				}else if("priority".equalsIgnoreCase(name)){
					additionalInfo.setPriority(value);
				}else if("opciState".equalsIgnoreCase(name)){
					additionalInfo.setOpciState(value);
				}
			}
			snc.setAdditionalInfo(additionalInfo);
		}
		return snc;
	}
	
	public static TPData convert(TPData_T tpData_t){
		TPData tpData = new TPData();
		tpData.setTpName(tpData_t.tpName);
		tpData.setTpMappingMode(tpData_t.tpMappingMode.toString());
		LayeredParameters_T[] lps = tpData_t.transmissionParams;
		LayeredParameters[] lpList = new LayeredParameters[lps.length];
		for(int i=0;i<lps.length;i++){
			lpList[i] = Convertor.convert(lps[i]);
		}
		tpData.setTransmissionParams(lpList);
		tpData.setIngressTrafficDescriptorName(tpData_t.ingressTrafficDescriptorName);
		tpData.setEgressTrafficDescriptorName(tpData_t.egressTrafficDescriptorName);
		return tpData;
	}
	
	public static LayeredParameters convert(LayeredParameters_T layeredParameters_t){
		LayeredParameters lp = new LayeredParameters();
		lp.setLayer(layeredParameters_t.layer);
		lp.setTransmissionParams(layeredParameters_t.transmissionParams);
		return lp;
	}
	
	public static WaveLengthStatus convert(WaveLengthStatus_T waveLengthStatus_t){
		WaveLengthStatus wls = new WaveLengthStatus();
		wls.setFrequency(waveLengthStatus_t.frequency);
		wls.setUsed(waveLengthStatus_t.used);
		wls.setUnused(waveLengthStatus_t.unused);
		wls.setAddtionalInfo(waveLengthStatus_t.addtionalInfo);
		return wls;
	}
	
	public static RouteAndTopologicalLink covert(RouteAndTopologicalLink_T routeAndTopologicalLink_t){
		RouteAndTopologicalLink routeTl = new RouteAndTopologicalLink();
		routeTl.setSncName(routeAndTopologicalLink_t.sncName);
		
		CrossConnect_T[] ccs = routeAndTopologicalLink_t.route;
		CrossConnect[] ccList = new CrossConnect[ccs.length];
		for(int i=0;i<ccs.length;i++){
			ccList[i] = Convertor.convert(ccs[i]);
		}
		routeTl.setRoute(ccList);
		
		TopologicalLink_T[] tls = routeAndTopologicalLink_t.topologicalLinkList;
		TopologicalLink[] tlList = new TopologicalLink[tls.length];
		for(int i=0;i<tls.length;i++){
			tlList[i] = Convertor.convert(tls[i]);
		}
		routeTl.setTopologicalLinkList(tlList);
		routeTl.setAdditionalInfo(routeAndTopologicalLink_t.additionalInfo);
		
		return routeTl;
	}

	public static TerminationPoint convert(TerminationPoint_T tp_t) {
		TerminationPoint tp = new TerminationPoint();
		tp.setName(tp_t.name);
		tp.setUserLabel(tp_t.userLabel);
		tp.setNativeEMSName(tp_t.nativeEMSName);
		tp.setOwner(tp_t.owner);
		tp.setIngressTrafficDescriptorName(tp_t.ingressTrafficDescriptorName);
		tp.setEgressTrafficDescriptorName(tp_t.egressTrafficDescriptorName);
		tp.setType(tp_t.type.toString());
		tp.setConnectionState(tp_t.connectionState.toString());
		tp.setTpMappingMode(tp_t.tpMappingMode.toString());
		tp.setDirection(tp_t.direction.toString());
		LayeredParameters_T[] lps = tp_t.transmissionParams;
		LayeredParameters[] lpList = new LayeredParameters[lps.length];
		for(int i=0;i<lps.length;i++){
			lpList[i] = Convertor.convert(lps[i]);
		}
		tp.setTransmissionParams(lpList);
		tp.setTpProtectionAssociation(tp_t.tpProtectionAssociation.toString());
		tp.setEdgePoint(tp_t.edgePoint);
		NameAndStringValue_T[] additionInfos = tp_t.additionalInfo;
		if(additionInfos!=null && additionInfos.length>0){
			TerminationPointAdditionalInfo additionalInfo = new TerminationPointAdditionalInfo();
			for(NameAndStringValue_T nv : additionInfos){
				String name = nv.name;
				String value = nv.value;
				if("serviceLoadFlag".equals(name)){
					additionalInfo.setServiceLoadFlag(value);
				}else if("supportFEC".equalsIgnoreCase(name)){
					additionalInfo.setSupportFEC(value);
				}
			}
			tp.setAdditionalInfo(additionalInfo);
		}
		return tp;
	}

	public static ProtectionGroup convert(ProtectionGroup_T pg_t) {
		ProtectionGroup pg = new ProtectionGroup();
		pg.setName(pg_t.name);
		pg.setUserLabel(pg_t.userLabel);
		pg.setNativeEMSName(pg_t.nativeEMSName);
		pg.setOwner(pg_t.owner);
		pg.setProtectionGroupType(pg_t.protectionGroupType.toString());
		pg.setProtectionSchemeState(pg_t.protectionSchemeState.toString());
		pg.setReversionMode(pg_t.reversionMode.toString());
		pg.setRate(pg_t.rate);
		pg.setPgpTPList(pg_t.pgpTPList);
		pg.setPgpParameters(pg_t.pgpParameters);
		pg.setAdditionalInfo(pg_t.additionalInfo);
		return pg;
	}

	public static WDMProtectionGroup convert(WDMProtectionGroup_T wdmpg_t) {
		WDMProtectionGroup wdmpg = new WDMProtectionGroup();
		wdmpg.setName(wdmpg_t.name);
		wdmpg.setUserLabel(wdmpg_t.userLabel);
		wdmpg.setNativeEMSName(wdmpg_t.nativeEMSName);
		wdmpg.setOwner(wdmpg_t.owner);
		wdmpg.setProtectionGroupType(wdmpg_t.protectionGroupType);
		wdmpg.setProtectionSchemeState(wdmpg_t.protectionSchemeState.toString());
		wdmpg.setReversionMode(wdmpg_t.reversionMode.toString());
		wdmpg.setPgpTPList(wdmpg_t.pgpTPList);
		wdmpg.setPgpParameters(wdmpg_t.pgpParameters);
		wdmpg.setAdditionalInfo(wdmpg_t.additionalInfo);
		return wdmpg;
	}

	public static ProtectionSubnetwork convert(ProtectionSubnetwork_T psn_t) {
		ProtectionSubnetwork psn = new ProtectionSubnetwork();
		psn.setName(psn_t.name);
		psn.setUserLabel(psn_t.userLabel);
		psn.setNativeEMSName(psn_t.nativeEMSName);
		psn.setOwner(psn_t.owner);
		psn.setLayerRate(psn_t.layerRate);
		psn.setPsnType(psn_t.psnType.toString());
		psn.setNeIDList(psn_t.neIDList);
		ProtectionSubnetworkLink_T[][] psnlks = psn_t.psnLinks;
		List<ProtectionSubnetworkLink> psnLinkList = new ArrayList<ProtectionSubnetworkLink>();
		for(int i=0;i<psnlks.length;i++){
			for(int j=0;j<psnlks[0].length;j++){
				psnLinkList.add(Convertor.convert(psnlks[i][j]));
			}
		}
		psn.setPsnLinkList(psnLinkList);
		psn.setAdditionalInfo(psn_t.additionalInfo);
		return psn;
	}
	
	public static ProtectionSubnetworkLink convert(ProtectionSubnetworkLink_T psnLink_t){
		ProtectionSubnetworkLink psnLink = new ProtectionSubnetworkLink();
		psnLink.setVc4List(psnLink_t.vc4List);
		psnLink.setSrcTP(psnLink_t.srcTP);
		psnLink.setSnkTP(psnLink_t.snkTP);
		return psnLink;
	}

	public static SwitchData convert(SwitchData_T sd_t) {
		SwitchData sd = new SwitchData();
		sd.setProtectionType(sd_t.protectionType.toString());
		sd.setSwitchReason(sd_t.switchReason.toString());
		sd.setLayerRate(sd_t.layerRate);
		sd.setGroupName(sd_t.groupName);
		sd.setProtectedTP(sd_t.protectedTP);
		sd.setSwitchToTP(sd_t.switchToTP);
		sd.setAdditionalInfo(sd_t.additionalInfo);
		return sd;
	}

	public static WDMSwitchData convert(WDMSwitchData_T wSwitchData_t) {
		WDMSwitchData wSwitchData = new WDMSwitchData();
		wSwitchData.setProtectionType(wSwitchData_t.protectionType.toString());
		wSwitchData.setSwitchReason(wSwitchData_t.switchReason.toString());
		wSwitchData.setwPGPName(wSwitchData_t.wPGPName);
		wSwitchData.setProtectedTP(wSwitchData_t.protectedTP);
		wSwitchData.setSwitchToTP(wSwitchData_t.switchToTP);
		wSwitchData.setAdditionalInfo(wSwitchData_t.additionalInfo);
		return wSwitchData;
	}

	public static Node convert(Node_T node_t) {
		Node node = new Node();
		node.setName(node_t.name);
		node.setNativeEMSName(node_t.nativeEMSName);
		node.setNodeType(node_t.nodeType.toString());
		node.setPosition(Convertor.convert(node_t.position));
		node.setParent(node_t.parent);
		node.setAdditionalInfo(node_t.additionalInfo);
		return node;
	}

	public static Position convert(Position_T position_t) {
		Position position = new Position();
		position.setxPos(position_t.xPos);
		position.setyPos(position_t.yPos);
		return position;
	}

	public static TrailNtwProtection convert(TrailNtwProtection_T tnp_t) {
		TrailNtwProtection tnp = new TrailNtwProtection();
		tnp.setName(tnp_t.name);
		tnp.setUserLabel(tnp_t.userLabel);
		tnp.setNativeEMSName(tnp_t.nativeEMSName);
		tnp.setOwner(tnp_t.owner);
		tnp.setProtectionGroupType(tnp_t.protectionGroupType.toString());
		tnp.setProtectionSchemeState(tnp_t.protectionSchemeState.toString());
		tnp.setReversionMode(tnp_t.reversionMode.toString());
		tnp.setRate(tnp_t.rate);
		tnp.setTrailNtwProtectionType(tnp_t.trailNtwProtectionType);
		tnp.setProtectionGroupAName(tnp_t.protectionGroupAName);
		tnp.setProtectionGroupZName(tnp_t.protectionGroupZName);
		tnp.setPgATPList(tnp_t.pgATPList);
		tnp.setPgZTPList(tnp_t.pgZTPList);
		tnp.setWorkerTrailList(tnp_t.workerTrailList);
		tnp.setProtectionTrail(tnp_t.protectionTrail);
		tnp.setTnpParameters(tnp_t.tnpParameters);
		tnp.setApsFunction(tnp_t.apsFunction);
		tnp.setNetworkAccessDomain(tnp_t.networkAccessDomain);
		tnp.setAdditionalInfo(tnp_t.additionalInfo);
		return tnp;
	}

}