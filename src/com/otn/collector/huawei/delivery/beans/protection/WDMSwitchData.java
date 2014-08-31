package com.otn.collector.huawei.delivery.beans.protection;

import java.util.Arrays;

import mtnm.tmforum.org.globaldefs.NameAndStringValue_T;

import com.google.gson.Gson;

/**
 * WDM保护组倒换数据类型
 * @author xuquan
 * 2014-6-7
 */
public class WDMSwitchData {
	
	private int id;
	
	/**
	 * 保护组类型，对于1:N保护为1VN，其它类型为1P1
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
	 * 保护组名称
	 */
	private NameAndStringValue_T[] wPGPName;
	private String wPGPNameStr;

	/**
	 * 倒换发生时被保护TP
	 * 如果重路由后当前工作在主IP，则恢复模式和非恢复模式均工作在主IP上。
	 * 如果重路由后当前工作在备IP，则恢复模式下由备IP倒换到主IP上工作，
	 * 非恢复模式下不进行切换，仍在备IP上工作。
	 * 
	 * 关于1:N的特殊说明：
	 * 		锁定倒换，TP固定均为第一个工作通道；
	 * 		清除倒换，如果当前为正常状态，TP固定均为第一个工作通道；
	 * 		如果当前为其他的倒换状态，则protectedTP填写发生倒换的工作通道。
	 */
	private NameAndStringValue_T[] protectedTP;
	private String protectedTPStr;
	
	/**
	 * 倒换目的TP
	 * 如果重路由后当前工作在主IP，则恢复模式和非恢复模式均工作在主IP上。
	 * 如果重路由后当前工作在备IP，则恢复模式下由备IP倒换到主IP上工作，
	 * 非恢复模式下不进行切换，仍在备IP上工作。
	 * 
	 * 关于1:N的特殊说明：
	 * 		锁定倒换，TP固定均为第一个工作通道；
	 * 		清除倒换，如果当前为正常状态，TP固定均为第一个工作通道；
	 * 		如果当前为其他的倒换状态，则protectedTP填写发生倒换的工作通道。
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

	public int getId() {
		return id;
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

	public NameAndStringValue_T[] getwPGPName() {
		return wPGPName;
	}

	public String getwPGPNameStr() {
		return wPGPNameStr;
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

	public void setId(int id) {
		this.id = id;
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

	public void setwPGPName(NameAndStringValue_T[] wPGPName) {
		Gson gson = new Gson();
		wPGPNameStr = gson.toJson(wPGPName);
		this.wPGPName = wPGPName;
	}

	public void setwPGPNameStr(String wPGPNameStr) {
		Gson gson = new Gson();
		wPGPName = gson.fromJson(wPGPNameStr, NameAndStringValue_T[].class);
		this.wPGPNameStr = wPGPNameStr;
	}

	@Override
	public String toString() {
		return "WDMSwitchData [id=" + id + ", protectionType=" + protectionType
				+ ", switchReason=" + switchReason + ", wPGPName="
				+ Arrays.toString(wPGPName) + ", protectedTP="
				+ Arrays.toString(protectedTP) + ", switchToTP="
				+ Arrays.toString(switchToTP) + ", additionalInfo="
				+ Arrays.toString(additionalInfo) + "]";
	}

}
