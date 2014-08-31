package com.otn.collector.huawei.delivery.beans.protection;

import java.util.Arrays;

import mtnm.tmforum.org.globaldefs.NameAndStringValue_T;

import com.google.gson.Gson;

/**
 * WDM保护组数据类型
 * @author xuquan
 * 2014-6-4
 */
public class WDMProtectionGroup {
	
	/**
	 * 表示保护组名称，
	 * 其形式为：{name EMS value XXXX}{name ManagedElement value YYYY}{name PGP value /保护组类型/子架/保护组ID}
	 * 其中保护组类型（pgtype）取值及含义如下：
	 * 0：未知
	 * 1：1:N光通道保护组
	 * 2：光线路保护组
	 * 3：板内1＋1保护组
	 * 4：板间1＋1保护组
	 * 5：客户侧1＋1保护组
	 * 6：子架间1＋1保护组
	 * 7：光波长共享保护组
	 * 8：WXCP保护组（传统波分网元）SNCP保护组（NGWDM网元）
	 * 9：OptiX BWS 320G上的1+1光通道保护组
	 * 10：OptiX BWS 320G上基于OLP单板的光线路保护组，暂不支持
	 * 11：扩展板内保护
	 * 12：光线路保护（NGWDM网元）
	 * 13：板内1＋1保护（NGWDM网元）
	 * 14：客户侧1＋1保护（NGWDM网元）
	 * 15：DPPS保护
	 * 16：TPS保护
	 * 17：子架间1＋1保护（OptiX OSN 1800网元）
	 */
	private NameAndStringValue_T[] name;
	private String nameStr;
	
	/**
	 * 默认为空，支持通过setUserLabel接口进行设置。
	 */
	private String userLabel = "";

	/**
	 * 非OLP保护组命名规则为：网元名称＋保护组ID
	 * OLP保护组规则为：网元名称＋OLP＋槽位ID 不支持设置
	 */
	private String nativeEMSName = "";

	/**
	 * 默认为空，支持setOwner接口进行设置
	 */
	private String owner = "";

	/**
	 * 1:N保护组为1VN，其他保护组为1P1
	 */
	private String protectionGroupType;

	/**
	 * 通道正常态
	 * 未知态：PSS_UNKNOWN
	 * 锁定倒换、强制倒换、人工倒换：PSS_FORCED_OR_LOCKED_OUT
	 * 自动倒换：PSS_AUTOMATIC
	 */
	private String protectionSchemeState;

	/**
	 * 恢复式：RM_REVERTIVE
	 * 非恢复式：RM_NON_REVERTIVE
	 * 未知：RM_ UNKNOWN
	 */
	private String reversionMode;

	/**
	 * 保护组tp列表这里的tp应该是PTP或FTP；
	 * pgpTPLisg中tp的顺序规则如下：
	 * 1．先工作后保护，如：工作1，保护1，工作2，保护2。
	 * 2．对于1+1非恢复式情况，如果发生倒换，则其tp的保护和工作角色也随之发生变化。
	 */
	private NameAndStringValue_T[][] pgpTPList;
	private String pgpTPListStr;

	/**
	 * 恢复式：支持HoldOffTime，取值为：Unknown。
	 * 非恢复式：支持wtrTime，取值为：保护组的等待恢复时间。支持HoldOffTime，取值为：Unknown。
	 */
	private NameAndStringValue_T[] pgpParameters;
	private String pgpParametersStr;

	/**
	 * 附加信息，目前为空。
	 */
	private NameAndStringValue_T[] additionalInfo;
	private String additionalInfoStr;
	
	private String managedElementNameStr;

	public NameAndStringValue_T[] getAdditionalInfo() {
		return additionalInfo;
	}

	public String getAdditionalInfoStr() {
		return additionalInfoStr;
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

	public NameAndStringValue_T[] getPgpParameters() {
		return pgpParameters;
	}

	public String getPgpParametersStr() {
		return pgpParametersStr;
	}

	public NameAndStringValue_T[][] getPgpTPList() {
		return pgpTPList;
	}

	public String getPgpTPListStr() {
		return pgpTPListStr;
	}

	public String getProtectionGroupType() {
		return protectionGroupType;
	}

	public String getProtectionSchemeState() {
		return protectionSchemeState;
	}

	public String getReversionMode() {
		return reversionMode;
	}

	public String getUserLabel() {
		return userLabel;
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

	public void setPgpParameters(NameAndStringValue_T[] pgpParameters) {
		Gson gson = new Gson();
		pgpParametersStr = gson.toJson(pgpParameters);
		this.pgpParameters = pgpParameters;
	}

	public void setPgpParametersStr(String pgpParametersStr) {
		Gson gson = new Gson();
		pgpParameters = gson.fromJson(pgpParametersStr, NameAndStringValue_T[].class);
		this.pgpParametersStr = pgpParametersStr;
	}

	public void setPgpTPList(NameAndStringValue_T[][] pgpTPList) {
		Gson gson = new Gson();
		pgpTPListStr = gson.toJson(pgpTPList);
		this.pgpTPList = pgpTPList;
	}

	public void setPgpTPListStr(String pgpTPListStr) {
		Gson gson = new Gson();
		pgpTPList = gson.fromJson(pgpTPListStr, NameAndStringValue_T[][].class);
		this.pgpTPListStr = pgpTPListStr;
	}

	public void setProtectionGroupType(String protectionGroupType) {
		this.protectionGroupType = protectionGroupType;
	}

	public void setProtectionSchemeState(String protectionSchemeState) {
		this.protectionSchemeState = protectionSchemeState;
	}

	public void setReversionMode(String reversionMode) {
		this.reversionMode = reversionMode;
	}

	public void setUserLabel(String userLabel) {
		this.userLabel = userLabel;
	}

	@Override
	public String toString() {
		return "WDMProtectionGroup [name="
				+ Arrays.toString(name) + ", userLabel=" + userLabel
				+ ", nativeEMSName=" + nativeEMSName + ", owner=" + owner
				+ ", protectionGroupType=" + protectionGroupType
				+ ", protectionSchemeState=" + protectionSchemeState
				+ ", reversionMode=" + reversionMode + ", pgpTPList="
				+ Arrays.toString(pgpTPList) + ", pgpParameters="
				+ Arrays.toString(pgpParameters) + ", additionalInfo="
				+ Arrays.toString(additionalInfo) + "]";
	}

	public String getManagedElementNameStr() {
		return managedElementNameStr;
	}

	public void setManagedElementNameStr(String managedElementNameStr) {
		this.managedElementNameStr = managedElementNameStr;
	}

}
