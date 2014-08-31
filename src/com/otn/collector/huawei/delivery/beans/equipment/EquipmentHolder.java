package com.otn.collector.huawei.delivery.beans.equipment;

import java.util.Arrays;

import mtnm.tmforum.org.globaldefs.NameAndStringValue_T;

import com.google.gson.Gson;

/**
 * 容器属性的数据类型
 * @author xuquan
 * 2014-6-4
 */
public class EquipmentHolder {
	
	/**
	 * Holder对象名称
	 */
	private NameAndStringValue_T[] name;
	private String nameStr;

	/**
	 * 用户标识符
	 */
	private String userLabel;

	/**
	 * 本地名称，即显示在网管界面的对象名称
	 */
	private String nativeEMSName;

	/**
	 * 该值默认为空，且如果是属于WDM子架时，
	 * 该值可以通过接口来修改，其它设备的值不能通过接口修改
	 */
	private String owner;

	/**
	 * 告警开关的打开或关闭状态。固定为true
	 */
	private boolean alarmReportingIndicator;

	/**
	 * 容器的类型。
	 * 包括："rack"、"shelf"、"slot"、"sub_slot"。
	 */
	private String holderType;

	/**
	 * 如果容器是slot，并且其上插有单板则该字段为单板对象的名称，否则为空
	 */
	private NameAndStringValue_T[] expectedOrInstalledEquipment;
	private String expectedOrInstalledEquipmentStr;

	/**
	 * 如果容器是slot，该字段为其上可以安装的单板列表。否则为空
	 */
	private String[] acceptableEquipmentTypeList;
	private String acceptableEquipmentTypeListStr;

	/**
	 * 容器状态。只对槽位有效。
	 */
	private String holderState;

	/**
	 * 附加信息
	 */
	private EquipmentHolderAdditionalInfo additionalInfo;
	
	private String managedElementNameStr;

	public String[] getAcceptableEquipmentTypeList() {
		return acceptableEquipmentTypeList;
	}

	public String getAcceptableEquipmentTypeListStr() {
		return acceptableEquipmentTypeListStr;
	}

	public NameAndStringValue_T[] getExpectedOrInstalledEquipment() {
		return expectedOrInstalledEquipment;
	}

	public String getExpectedOrInstalledEquipmentStr() {
		return expectedOrInstalledEquipmentStr;
	}

	public String getHolderState() {
		return holderState;
	}

	public String getHolderType() {
		return holderType;
	}

	public NameAndStringValue_T[] getName() {
		return name;
	}

	public String getNameStr() {
		return nameStr;
	}

	public String getNativeEMSName() {
		return nativeEMSName;
	}

	public String getOwner() {
		return owner;
	}

	public String getUserLabel() {
		return userLabel;
	}

	public boolean isAlarmReportingIndicator() {
		return alarmReportingIndicator;
	}

	public void setAcceptableEquipmentTypeList(String[] acceptableEquipmentTypeList) {
		Gson gson = new Gson();
		acceptableEquipmentTypeListStr = gson.toJson(acceptableEquipmentTypeList);
		this.acceptableEquipmentTypeList = acceptableEquipmentTypeList;
	}

	public void setAcceptableEquipmentTypeListStr(
			String acceptableEquipmentTypeListStr) {
		Gson gson = new Gson();
		acceptableEquipmentTypeList = gson.fromJson(acceptableEquipmentTypeListStr, String[].class);
		this.acceptableEquipmentTypeListStr = acceptableEquipmentTypeListStr;
	}

	public void setAlarmReportingIndicator(boolean alarmReportingIndicator) {
		this.alarmReportingIndicator = alarmReportingIndicator;
	}

	public void setExpectedOrInstalledEquipment(
			NameAndStringValue_T[] expectedOrInstalledEquipment) {
		Gson gson = new Gson();
		expectedOrInstalledEquipmentStr = gson.toJson(expectedOrInstalledEquipment);
		this.expectedOrInstalledEquipment = expectedOrInstalledEquipment;
	}

	public void setExpectedOrInstalledEquipmentStr(
			String expectedOrInstalledEquipmentStr) {
		Gson gson = new Gson();
		expectedOrInstalledEquipment = gson.fromJson(expectedOrInstalledEquipmentStr, NameAndStringValue_T[].class);
		this.expectedOrInstalledEquipmentStr = expectedOrInstalledEquipmentStr;
	}

	public void setHolderState(String holderState) {
		this.holderState = holderState;
	}

	public void setHolderType(String holderType) {
		this.holderType = holderType;
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

	public void setNativeEMSName(String nativeEMSName) {
		this.nativeEMSName = nativeEMSName;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setUserLabel(String userLabel) {
		this.userLabel = userLabel;
	}

	public EquipmentHolderAdditionalInfo getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(EquipmentHolderAdditionalInfo additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	@Override
	public String toString() {
		return "EquipmentHolder [name=" + Arrays.toString(name) + ", nameStr="
				+ nameStr + ", userLabel=" + userLabel + ", nativeEMSName="
				+ nativeEMSName + ", owner=" + owner
				+ ", alarmReportingIndicator=" + alarmReportingIndicator
				+ ", holderType=" + holderType
				+ ", expectedOrInstalledEquipment="
				+ Arrays.toString(expectedOrInstalledEquipment)
				+ ", expectedOrInstalledEquipmentStr="
				+ expectedOrInstalledEquipmentStr
				+ ", acceptableEquipmentTypeList="
				+ Arrays.toString(acceptableEquipmentTypeList)
				+ ", acceptableEquipmentTypeListStr="
				+ acceptableEquipmentTypeListStr + ", holderState="
				+ holderState + ", additionalInfo=" + additionalInfo
				+ ", managedElementNameStr=" + managedElementNameStr + "]";
	}

	public String getManagedElementNameStr() {
		return managedElementNameStr;
	}

	public void setManagedElementNameStr(String managedElementNameStr) {
		this.managedElementNameStr = managedElementNameStr;
	}

}
