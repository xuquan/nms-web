package com.otn.collector.huawei.delivery.beans.protection;

import java.util.Arrays;

import mtnm.tmforum.org.globaldefs.NameAndStringValue_T;

import com.google.gson.Gson;

/**
 * 保护组倒换数据类型
 * @author xuquan
 * 2014-6-4
 */
public class SwitchData {
	
	private int id;
	
	/**
	 * 1+1、1：N、2F、4F保护组为“PT_MSP_APS”；
	 * SNCP保护组为“PT_SNCP”
	 */
	private String protectionType;
	
	/**
	 * 倒换原因。
	 * （1）空闲时SwitchReason为SR_RESTORED；
	 * （2）锁定、强制倒换、人工倒换SwitchReason为SR_MANUAL；
	 * （3）等待恢复、自动倒换SwitchReason为SR_AUTOMATIC_SWITCH；
	 * （4）SD倒换SwitchReason为SR_SIGNAL_DEGRADE；
	 * （5）SF倒换SwitchReason为SR_SIGNAL_FAIL；
	 * （6）其他为SR_NA。
	 */
	private String switchReason;

	/**
	 * 保护组层速率
	 */
	private short layerRate;

	/**
	 * 保护组名
	 */
	private NameAndStringValue_T[] groupName;
	private String groupNameStr;

	/**
	 * 倒换发生时被保护TP
	 */
	private NameAndStringValue_T[] protectedTP;
	private String protectedTPStr;
	
	/**
	 * 倒换目的TP
	 */
	private NameAndStringValue_T[] switchToTP;
	private String switchToTPStr;

	/**
	 * 取值为空
	 */
	private NameAndStringValue_T[] additionalInfo;
	private String additionalInfoStr;

	public NameAndStringValue_T[] getAdditionalInfo() {
		return additionalInfo;
	}

	public String getAdditionalInfoStr() {
		return additionalInfoStr;
	}

	public NameAndStringValue_T[] getGroupName() {
		return groupName;
	}

	public String getGroupNameStr() {
		return groupNameStr;
	}

	public int getId() {
		return id;
	}

	public short getLayerRate() {
		return layerRate;
	}

	public NameAndStringValue_T[] getProtectedTP() {
		return protectedTP;
	}

	public String getProtectedTPStr() {
		return protectedTPStr;
	}

	public String getProtectionType() {
		return protectionType;
	}

	public String getSwitchReason() {
		return switchReason;
	}

	public NameAndStringValue_T[] getSwitchToTP() {
		return switchToTP;
	}

	public String getSwitchToTPStr() {
		return switchToTPStr;
	}

	public void setAdditionalInfo(NameAndStringValue_T[] additionalInfo) {
		Gson gson = new Gson();
		additionalInfoStr = gson.toJson(additionalInfo);
		this.additionalInfo = additionalInfo;
	}

	public void setAdditionalInfoStr(String additionalInfoStr) {
		Gson gson = new Gson();
		additionalInfo = gson.fromJson(additionalInfoStr, NameAndStringValue_T[].class);
		this.additionalInfoStr = additionalInfoStr;
	}

	public void setGroupName(NameAndStringValue_T[] groupName) {
		Gson gson = new Gson();
		groupNameStr = gson.toJson(groupName);
		this.groupName = groupName;
	}

	public void setGroupNameStr(String groupNameStr) {
		Gson gson = new Gson();
		groupName = gson.fromJson(groupNameStr, NameAndStringValue_T[].class);
		this.groupNameStr = groupNameStr;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLayerRate(short layerRate) {
		this.layerRate = layerRate;
	}

	public void setProtectedTP(NameAndStringValue_T[] protectedTP) {
		Gson gson = new Gson();
		protectedTPStr = gson.toJson(protectedTP);
		this.protectedTP = protectedTP;
	}

	public void setProtectedTPStr(String protectedTPStr) {
		Gson gson = new Gson();
		protectedTP = gson.fromJson(protectedTPStr, NameAndStringValue_T[].class);
		this.protectedTPStr = protectedTPStr;
	}

	public void setProtectionType(String protectionType) {
		this.protectionType = protectionType;
	}

	public void setSwitchReason(String switchReason) {
		this.switchReason = switchReason;
	}

	public void setSwitchToTP(NameAndStringValue_T[] switchToTP) {
		Gson gson = new Gson();
		switchToTPStr = gson.toJson(switchToTP);
		this.switchToTP = switchToTP;
	}

	public void setSwitchToTPStr(String switchToTPStr) {
		Gson gson = new Gson();
		switchToTP = gson.fromJson(switchToTPStr, NameAndStringValue_T[].class);
		this.switchToTPStr = switchToTPStr;
	}

	@Override
	public String toString() {
		return "SwitchData [id=" + id + ", protectionType=" + protectionType
				+ ", switchReason=" + switchReason + ", layerRate=" + layerRate
				+ ", groupName=" + Arrays.toString(groupName)
				+ ", protectedTP=" + Arrays.toString(protectedTP)
				+ ", switchToTP=" + Arrays.toString(switchToTP)
				+ ", additionalInfo=" + Arrays.toString(additionalInfo) + "]";
	}

}
