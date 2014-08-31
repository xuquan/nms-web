package com.otn.collector.huawei.delivery.beans.protection;

import java.util.Arrays;

import mtnm.tmforum.org.globaldefs.NameAndStringValue_T;

import com.google.gson.Gson;

/**
 * 保护组数据类型
 * @author xuquan
 * 2014-6-4
 */
public class ProtectionGroup {
	
	/**
	 * 表示保护组名称，
	 * 其形式为：{name EMS value XXXX}{name ManagedElement value YYYY}{name PGP value 1/保护组ID/保护组位置ID}
	 * 其中保护组位置ID取值及含义如下：
	 * 11：1+1 TM类型保护组
	 * 12：1+1 ADM类型西向保护组
	 * 13：1+1 ADM类型东向保护组
	 * 14：1:N TM类型保护组
	 * 15：1:N ADM类型西向保护组
	 * 16：1:N ADM类型东向保护组
	 * 17：2F环保护组
	 * 18：2F环西向保护组，仅用于通知事件
	 * 19：2F环东向保护组，仅用于通知事件
	 * 20：4F环保护组
	 * 21：4F环西向1:N保护组
	 * 22：4F环东向1:N保护组
	 */
	private NameAndStringValue_T[] name;
	private String nameStr;

	/**
	 * 用户标识符，支持通过setUserLabel接口进行设置，默认为空。
	 */
	private String userLabel = "";

	/**
	 * 本地名称
	 */
	private String nativeEMSName = "";

	/**
	 * 对象所有者名称。支持通过setOwner接口进行设置，默认为空
	 */
	private String owner = "";

	/**
	 * 支持的保护组类型有：
	 * 1+1保护使用的值是PGT_MSP_1_PLUS_1；
	 * 1:N使用的值是PGT_MSP_1_FOR_N；
	 * 两纤双向的用PGT_2_FIBER_BLSR；
	 * 四纤双向的用PGT_4_FIBER_BLSRSNCP
	 * 保护组为“PT_SNCP”
	 */
	private String protectionGroupType;

	/**
	 * 取值以及相应的含义如下：
	 * PSS_UNKNOWN：PGP处于idle状态或正常态、或未知状态（保护组中存在两种状态或其它未知情形）。
	 * PSS_FORCED_OR_LOCKED_OUT：PGP处于锁定、强制倒换或者人工倒换状态。
	 * PSS_AUTOMATIC：PGP处于自动倒换状态。
	 */
	private String protectionSchemeState;

	/**
	 * 恢复模式
	 * 取值以及相应的含义如下：
	 * RM_REVERTIVE：恢复式。
	 * RM_NON_REVERTIVE：非恢复式。
	 * RM_UNKNOWN：未知
	 */
	private String reversionMode;

	/**
	 * 层速率
	 */
	private short rate;

	/**
	 * 排列顺序为先工作后保护。
	 * 1、1+1 TM类型保护组，排列顺序为：西向工作PTP、西向保护PTP；
	 * 	  1+1 ADM类型西向保护组，排列顺序为：西向工作PTP、西向保护PTP；
	 * 	  1+1 ADM类型东向保护组，排列顺序为：东向工作PTP、东向保护PTP；
	 * 2、1:N TM类型保护组，排列顺序为：西向1~N线路工作PTP、西向保护线路PTP；
	 * 	  1:N ADM类型西向保护组，排列顺序为：西向1~N线路工作PTP、西向保护线路PTP；
	 *    1:N ADM类型东向保护组，排列顺序为：东向1~N线路工作PTP、东向保护线路PTP；
	 * 3、2F环保护组，排列顺序为：西向工作PTP、东向保护PTP；
	 * 4、4F环保护组，排列顺序为：西向工作PTP、西向保护PTP、东向工作PTP、东向保护PTP；
	 * 	  4F环西向1:N保护组，排列顺序为：西向工作PTP、西向保护。
	 *    4F环东向1:N保护组，排列顺序为：东向工作PTP、东向保护。
	 */
	private NameAndStringValue_T[][] pgpTPList;
	private String pgpTPListStr;

	/**
	 * 支持九个参数：
	 * SwitchMode：倒换模式。
	 * 对于1+1保护组取值可为：SingleEnded（单端倒换），DualEnded（双端倒换）；
	 * 对于其它保护，取值为DualEnded（双端倒换）。
	 * wtrTime：恢复时间。
	 * HoldOffTime：持续时间。
	 * LODNumSwitches：倒换数值，目前不支持，恒填Unknown。
	 * LODDuration：用于和LODNumSwitches配合，目前不支持，恒填Unknown。
	 * SPRINGProtocol：环倒换协议，仅2F环和4F环有此参数，取值为Standard。
	 * SPRINGNodeId：环倒换节点ID，仅2F环和4F环有此参数。
	 * SwitchPosition：倒换位置。
	 * nonPre-EmptibleTraffic：用于标示保护上是否可以配置非预占业务。
	 * 仅2F环和1:N保护组有此字段，且取值为NOT_ALLOWED
	 */
	private NameAndStringValue_T[] pgpParameters;
	private String pgpParametersStr;

	/**
	 * 为空
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

	public short getRate() {
		return rate;
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

	public void setRate(short rate) {
		this.rate = rate;
	}

	public void setReversionMode(String reversionMode) {
		this.reversionMode = reversionMode;
	}

	public void setUserLabel(String userLabel) {
		this.userLabel = userLabel;
	}

	@Override
	public String toString() {
		return "ProtectionGroup [name=" + Arrays.toString(name)
				+ ", userLabel=" + userLabel + ", nativeEMSName="
				+ nativeEMSName + ", owner=" + owner + ", protectionGroupType="
				+ protectionGroupType + ", protectionSchemeState="
				+ protectionSchemeState + ", reversionMode=" + reversionMode
				+ ", rate=" + rate + ", pgpTPList="
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
