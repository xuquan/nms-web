package com.otn.collector.huawei.delivery.beans.equipment;

import java.util.Arrays;

import mtnm.tmforum.org.globaldefs.NameAndStringValue_T;

import com.google.gson.Gson;

/**
 * 单板属性数据类型
 * 
 * @author xuquan 2014-6-4
 */
public class Equipment {
	
	/**
	 * 单板名称
	 */
	private NameAndStringValue_T[] name;
	private String nameStr;

	/**
	 * 单板的userLabel标识。默认为空
	 */
	private String userLabel;

	/**
	 * 单板的nativeEMSName
	 */
	private String nativeEMSName;

	/**
	 * 单板的owner标识。默认为空
	 */
	private String owner;

	/**
	 * 单板告警开关的打开或关闭状态。固定为true
	 */
	private boolean alarmReportingIndicator;

	/**
	 * 单板工作状态
	 */
	private String serviceState;

	/**
	 * 网管侧安装的单板类型
	 */
	private String expectedEquipmentObjectType;

	/**
	 * 网元侧安装的单板类型
	 */
	private String installedEquipmentObjectType;

	/**
	 * 单板条形码
	 */
	private String installedPartNumber;

	/**
	 * 单板版本号
	 */
	private String installedVersion;

	/**
	 * 单板序列号
	 */
	private String installedSerialNumber;

	/**
	 * 附加信息
	 */
	private EquipmentAdditionalInfo additionalInfo;
	
	private String managedElementNameStr;

	public String getUserLabel() {
		return userLabel;
	}

	public void setUserLabel(String userLabel) {
		this.userLabel = userLabel;
	}

	public String getNativeEMSName() {
		return nativeEMSName;
	}

	public void setNativeEMSName(String nativeEMSName) {
		this.nativeEMSName = nativeEMSName;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public boolean isAlarmReportingIndicator() {
		return alarmReportingIndicator;
	}

	public void setAlarmReportingIndicator(boolean alarmReportingIndicator) {
		this.alarmReportingIndicator = alarmReportingIndicator;
	}

	public String getServiceState() {
		return serviceState;
	}

	public void setServiceState(String serviceState) {
		this.serviceState = serviceState;
	}

	public String getExpectedEquipmentObjectType() {
		return expectedEquipmentObjectType;
	}

	public void setExpectedEquipmentObjectType(
			String expectedEquipmentObjectType) {
		this.expectedEquipmentObjectType = expectedEquipmentObjectType;
	}

	public String getInstalledEquipmentObjectType() {
		return installedEquipmentObjectType;
	}

	public void setInstalledEquipmentObjectType(
			String installedEquipmentObjectType) {
		this.installedEquipmentObjectType = installedEquipmentObjectType;
	}

	public String getInstalledPartNumber() {
		return installedPartNumber;
	}

	public void setInstalledPartNumber(String installedPartNumber) {
		this.installedPartNumber = installedPartNumber;
	}

	public String getInstalledSerialNumber() {
		return installedSerialNumber;
	}

	public void setInstalledSerialNumber(String installedSerialNumber) {
		this.installedSerialNumber = installedSerialNumber;
	}

	public String getInstalledVersion() {
		return installedVersion;
	}

	public void setInstalledVersion(String installedVersion) {
		this.installedVersion = installedVersion;
	}

	public NameAndStringValue_T[] getName() {
		return name;
	}

	public void setName(NameAndStringValue_T[] name) {
		if (null != name && name.length > 0) {
			Gson gson = new Gson();
			nameStr = gson.toJson(name);
		}
		this.name = name;
	}

	public String getNameStr() {
		return nameStr;
	}

	public void setNameStr(String nameStr) {
		if (null != nameStr && !"".equals(nameStr)) {
			Gson gson = new Gson();
			name = gson.fromJson(nameStr, NameAndStringValue_T[].class);
		}
		this.nameStr = nameStr;
	}

	public EquipmentAdditionalInfo getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(EquipmentAdditionalInfo additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	@Override
	public String toString() {
		return "Equipment [name=" + Arrays.toString(name) + ", nameStr="
				+ nameStr + ", userLabel=" + userLabel + ", nativeEMSName="
				+ nativeEMSName + ", owner=" + owner
				+ ", alarmReportingIndicator=" + alarmReportingIndicator
				+ ", serviceState=" + serviceState
				+ ", expectedEquipmentObjectType="
				+ expectedEquipmentObjectType
				+ ", installedEquipmentObjectType="
				+ installedEquipmentObjectType + ", installedPartNumber="
				+ installedPartNumber + ", installedVersion="
				+ installedVersion + ", installedSerialNumber="
				+ installedSerialNumber + ", additionalInfo=" + additionalInfo
				+ ", managedElementNameStr=" + managedElementNameStr + "]";
	}

	public String getManagedElementNameStr() {
		return managedElementNameStr;
	}

	public void setManagedElementNameStr(String managedElementNameStr) {
		this.managedElementNameStr = managedElementNameStr;
	}

}
