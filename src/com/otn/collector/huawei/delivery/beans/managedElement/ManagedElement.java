package com.otn.collector.huawei.delivery.beans.managedElement;

import java.util.Arrays;
import java.util.List;

import mtnm.tmforum.org.globaldefs.NameAndStringValue_T;

import com.google.gson.Gson;
import com.otn.collector.huawei.delivery.beans.equipment.Equipment;
import com.otn.collector.huawei.delivery.beans.equipment.EquipmentHolder;
import com.otn.collector.huawei.delivery.beans.protection.ProtectionGroup;
import com.otn.collector.huawei.delivery.beans.protection.WDMProtectionGroup;
import com.otn.collector.huawei.delivery.beans.subnetworkConnection.CrossConnect;
import com.otn.collector.huawei.delivery.beans.terminationPoint.TerminationPoint;

/**
 * 网元属性数据类型
 * @author xuquan
 * 2014-6-4
 */
public class ManagedElement {
	
	/**
	 * 网元名称标识
	 */
	private NameAndStringValue_T[] name;
	private String nameStr;

	/**
	 * 用户标识符，默认为空
	 */
	private String userLabel = "";

	/**
	 * 本地名称，即显示在网管界面的对象名称
	 */
	private String nativeEMSName = "";

	/**
	 * 对象所有者名称，可以调用setOwner接口进行设置，默认为空
	 */
	private String owner = "";

	/**
	 * 所在机房
	 */
	private String location = "";

	/**
	 * 网元软件版本
	 */
	private String version = "";

	/**
	 * 对于U2000为网元类型名称
	 */
	private String productName = "";

	/**
	 * 网元和网管通讯状态
	 */
	private String communicationState;

	/**
	 * 网元数据和网管数据同步状态
	 */
	private boolean emsInSyncState;

	/**
	 * 网元支持的交叉级别列表
	 */
	private short[] supportedRates;
	private String supportedRatesStr;

	/**
	 * 附加信息
	 */
	private ManagedElementAdditionalInfo additionalInfo;
	
	/**
	 * 网元的单板信息列表
	 */
	private List<Equipment> equipmentList;
	
	/**
	 * 网元的容器信息列表
	 */
	private List<EquipmentHolder> holderList;
	
	/**
	 * 网元的物理端口列表
	 */
	private List<TerminationPoint> tpList;
	
	/**
	 * 网元内的交叉连接列表
	 */
	private List<CrossConnect> crossConnectList;
	
	/**
	 * SDH保护组列表
	 */
	private List<ProtectionGroup> pgList;
	
	/**
	 * 波分保护组列表
	 */
	private List<WDMProtectionGroup> wdmpgList;

	public String getCommunicationState() {
		return communicationState;
	}

	public java.lang.String getLocation() {
		return location;
	}

	public NameAndStringValue_T[] getName() {
		return name;
	}

	public String getNameStr() {
		return nameStr;
	}

	public java.lang.String getNativeEMSName() {
		return nativeEMSName;
	}

	public java.lang.String getOwner() {
		return owner;
	}

	public java.lang.String getProductName() {
		return productName;
	}

	public short[] getSupportedRates() {
		return supportedRates;
	}

	public java.lang.String getUserLabel() {
		return userLabel;
	}

	public java.lang.String getVersion() {
		return version;
	}

	public boolean isEmsInSyncState() {
		return emsInSyncState;
	}

	public void setCommunicationState(String communicationState) {
		this.communicationState = communicationState;
	}

	public void setEmsInSyncState(boolean emsInSyncState) {
		this.emsInSyncState = emsInSyncState;
	}

	public void setLocation(java.lang.String location) {
		this.location = location;
	}

	public void setName(NameAndStringValue_T[] name) {
		Gson gson = new Gson();
		nameStr = gson.toJson(name);
		this.name = name;
	}

	public void setNameStr(String nameStr) {
		Gson gson = new Gson();
		name = gson.fromJson(nameStr, NameAndStringValue_T[].class);
		this.nameStr = nameStr;
	}

	public void setNativeEMSName(java.lang.String nativeEMSName) {
		this.nativeEMSName = nativeEMSName;
	}

	public void setOwner(java.lang.String owner) {
		this.owner = owner;
	}

	public void setProductName(java.lang.String productName) {
		this.productName = productName;
	}

	public void setSupportedRates(short[] supportedRates) {
		Gson gson = new Gson();
		supportedRatesStr = gson.toJson(supportedRates);
		this.supportedRates = supportedRates;
	}

	public void setUserLabel(java.lang.String userLabel) {
		this.userLabel = userLabel;
	}

	public void setVersion(java.lang.String version) {
		this.version = version;
	}

	public String getSupportedRatesStr() {
		return supportedRatesStr;
	}

	public void setSupportedRatesStr(String supportedRatesStr) {
		Gson gson = new Gson();
		supportedRates = gson.fromJson(supportedRatesStr, short[].class);
		this.supportedRatesStr = supportedRatesStr;
	}

	public List<Equipment> getEquipmentList() {
		return equipmentList;
	}

	public void setEquipmentList(List<Equipment> equipmentList) {
		this.equipmentList = equipmentList;
	}

	public List<EquipmentHolder> getHolderList() {
		return holderList;
	}

	public void setHolderList(List<EquipmentHolder> holderList) {
		this.holderList = holderList;
	}

	public List<TerminationPoint> getTpList() {
		return tpList;
	}

	public void setTpList(List<TerminationPoint> tpList) {
		this.tpList = tpList;
	}

	public List<CrossConnect> getCrossConnectList() {
		return crossConnectList;
	}

	public void setCrossConnectList(List<CrossConnect> crossConnectList) {
		this.crossConnectList = crossConnectList;
	}

	public List<ProtectionGroup> getPgList() {
		return pgList;
	}

	public void setPgList(List<ProtectionGroup> pgList) {
		this.pgList = pgList;
	}

	public List<WDMProtectionGroup> getWdmpgList() {
		return wdmpgList;
	}

	public void setWdmpgList(List<WDMProtectionGroup> wdmpgList) {
		this.wdmpgList = wdmpgList;
	}

	public ManagedElementAdditionalInfo getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(ManagedElementAdditionalInfo additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	@Override
	public String toString() {
		return "ManagedElement [name=" + Arrays.toString(name)
				+ ", nameStr=" + nameStr + ", userLabel=" + userLabel
				+ ", nativeEMSName=" + nativeEMSName + ", owner=" + owner
				+ ", location=" + location + ", version=" + version
				+ ", productName=" + productName + ", communicationState="
				+ communicationState + ", emsInSyncState=" + emsInSyncState
				+ ", supportedRates=" + Arrays.toString(supportedRates)
				+ ", supportedRatesStr=" + supportedRatesStr
				+ ", additionalInfo=" + additionalInfo + ", equipmentList="
				+ equipmentList + ", holderList=" + holderList + ", tpList="
				+ tpList + ", crossConnectList=" + crossConnectList
				+ ", pgList=" + pgList + ", wdmpgList=" + wdmpgList + "]";
	}

}
