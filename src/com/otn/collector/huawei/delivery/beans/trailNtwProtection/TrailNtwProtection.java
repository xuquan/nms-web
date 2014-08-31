package com.otn.collector.huawei.delivery.beans.trailNtwProtection;

import java.util.Arrays;

import mtnm.tmforum.org.globaldefs.NameAndStringValue_T;

import com.google.gson.Gson;

/**
 * TrailNtwProtection数据类型
 * TrailNtwProtection包括：Tunnel APS 1+1保护和1:1保护。
 * @author xuquan
 * 2014-6-4
 */
public class TrailNtwProtection {
	
	/**
	 * 名称标识
	 */
	private NameAndStringValue_T[] name;
	private String nameStr;
	
	/**
	 * 对象别名，默认为空
	 */
	private String userLabel = "";
	
	/**
	 * 本地名称
	 */
	private String nativeEMSName = "";

	/**
	 * 对象的属主，默认为空
	 */
	private String owner = "";

	/**
	 * 保护类型
	 * 取值包括：PGT_MSP_1_PLUS_1，PGT_MSP_1_FOR_N，PGT_2_FIBER_BLSR，PGT_4_FIBER_BLSR。
	 */
	private String protectionGroupType;

	/**
	 * 保护状态
	 * 取值包括：PSS_UNKNOWN，PSS_AUTOMATIC，PSS_FORCED_OR_LOCKED_OUT
	 */
	private String protectionSchemeState;

	/**
	 * 恢复模式
	 * 取值包括：RM_UNKNOWN，RM_NON_REVERTIVE，RM_REVERTIVE
	 */
	private String reversionMode;

	/**
	 * 保护组的速率
	 */
	private short rate;

	/**
	 * 保护方式，取值包括：Closed，Open
	 */
	private String trailNtwProtectionType = "";

	/**
	 * 源端保护组名称
	 */
	private NameAndStringValue_T[] protectionGroupAName;
	private String protectionGroupANameStr;

	/**
	 * 宿端保护组名称
	 */
	private NameAndStringValue_T[] protectionGroupZName;
	private String protectionGroupZNameStr;

	/**
	 * 源端接口列表
	 * 值为空时，表示该端点在网管系统管理域外。
	 */
	private NameAndStringValue_T[][] pgATPList;
	private String pgATPListStr;

	/**
	 * 宿端接口列表
	 * 值为空时，表示该端点在网管系统管理域外
	 */
	private NameAndStringValue_T[][] pgZTPList;
	private String pgZTPListStr;

	/**
	 * 工作路径列表（工作SNC对象名称列表）
	 */
	private NameAndStringValue_T[][][] workerTrailList;
	private String workerTrailListStr;

	/**
	 * 保护路径列表（保护SNC对象名称列表）
	 */
	private NameAndStringValue_T[][] protectionTrail;
	private String protectionTrailStr;

	/**
	 * 传输参数
	 * 请参见《北向CORBA接口开发指南（资源）》的"trailNtwProtection传输参数"。
	 */
	private NameAndStringValue_T[] tnpParameters;
	private String tnpParametersStr;

	/**
	 * APS协议类型，取值包括：G.783，Legacy，T-MPLS
	 */
	private String apsFunction = "";

	/**
	 * 网络访问域
	 */
	private String networkAccessDomain = "";

	/**
	 * 附加信息，固定为空
	 */
	private NameAndStringValue_T[] additionalInfo;
	private String additionalInfoStr;
	
	public NameAndStringValue_T[] getAdditionalInfo() {
		return additionalInfo;
	}
	public String getAdditionalInfoStr() {
		return additionalInfoStr;
	}
	public String getApsFunction() {
		return apsFunction;
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
	public String getNetworkAccessDomain() {
		return networkAccessDomain;
	}
	public String getOwner() {
		return owner;
	}
	public NameAndStringValue_T[][] getPgATPList() {
		return pgATPList;
	}
	public String getPgATPListStr() {
		return pgATPListStr;
	}
	public NameAndStringValue_T[][] getPgZTPList() {
		return pgZTPList;
	}
	public String getPgZTPListStr() {
		return pgZTPListStr;
	}
	public NameAndStringValue_T[] getProtectionGroupAName() {
		return protectionGroupAName;
	}
	public String getProtectionGroupANameStr() {
		return protectionGroupANameStr;
	}
	public String getProtectionGroupType() {
		return protectionGroupType;
	}
	public NameAndStringValue_T[] getProtectionGroupZName() {
		return protectionGroupZName;
	}
	public String getProtectionGroupZNameStr() {
		return protectionGroupZNameStr;
	}
	public String getProtectionSchemeState() {
		return protectionSchemeState;
	}
	public NameAndStringValue_T[][] getProtectionTrail() {
		return protectionTrail;
	}
	public String getProtectionTrailStr() {
		return protectionTrailStr;
	}
	public short getRate() {
		return rate;
	}
	public String getReversionMode() {
		return reversionMode;
	}
	public NameAndStringValue_T[] getTnpParameters() {
		return tnpParameters;
	}
	public String getTnpParametersStr() {
		return tnpParametersStr;
	}
	public String getTrailNtwProtectionType() {
		return trailNtwProtectionType;
	}
	public String getUserLabel() {
		return userLabel;
	}
	public NameAndStringValue_T[][][] getWorkerTrailList() {
		return workerTrailList;
	}
	public String getWorkerTrailListStr() {
		return workerTrailListStr;
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
	public void setApsFunction(String apsFunction) {
		this.apsFunction = apsFunction;
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
	public void setNetworkAccessDomain(String networkAccessDomain) {
		this.networkAccessDomain = networkAccessDomain;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public void setPgATPList(NameAndStringValue_T[][] pgATPList) {
		Gson gson = new Gson();
		pgATPListStr = gson.toJson(pgATPList);
		this.pgATPList = pgATPList;
	}
	public void setPgATPListStr(String pgATPListStr) {
		Gson gson = new Gson();
		pgATPList = gson.fromJson(pgATPListStr, NameAndStringValue_T[][].class);
		this.pgATPListStr = pgATPListStr;
	}
	public void setPgZTPList(NameAndStringValue_T[][] pgZTPList) {
		Gson gson = new Gson();
		pgZTPListStr = gson.toJson(pgZTPList);
		this.pgZTPList = pgZTPList;
	}
	public void setPgZTPListStr(String pgZTPListStr) {
		Gson gson = new Gson();
		pgZTPList = gson.fromJson(pgZTPListStr, NameAndStringValue_T[][].class);
		this.pgZTPListStr = pgZTPListStr;
	}
	public void setProtectionGroupAName(NameAndStringValue_T[] protectionGroupAName) {
		Gson gson = new Gson();
		protectionGroupANameStr = gson.toJson(protectionGroupAName);
		this.protectionGroupAName = protectionGroupAName;
	}
	public void setProtectionGroupANameStr(String protectionGroupANameStr) {
		Gson gson = new Gson();
		protectionGroupAName = gson.fromJson(protectionGroupANameStr, NameAndStringValue_T[].class);
		this.protectionGroupANameStr = protectionGroupANameStr;
	}
	public void setProtectionGroupType(String protectionGroupType) {
		this.protectionGroupType = protectionGroupType;
	}
	public void setProtectionGroupZName(NameAndStringValue_T[] protectionGroupZName) {
		Gson gson = new Gson();
		protectionGroupZNameStr = gson.toJson(protectionGroupZName);
		this.protectionGroupZName = protectionGroupZName;
	}
	public void setProtectionGroupZNameStr(String protectionGroupZNameStr) {
		Gson gson = new Gson();
		protectionGroupZName = gson.fromJson(protectionGroupZNameStr, NameAndStringValue_T[].class);
		this.protectionGroupZNameStr = protectionGroupZNameStr;
	}
	public void setProtectionSchemeState(String protectionSchemeState) {
		this.protectionSchemeState = protectionSchemeState;
	}
	public void setProtectionTrail(NameAndStringValue_T[][] protectionTrail) {
		Gson gson = new Gson();
		protectionTrailStr = gson.toJson(protectionTrail);
		this.protectionTrail = protectionTrail;
	}
	public void setProtectionTrailStr(String protectionTrailStr) {
		Gson gson = new Gson();
		protectionTrail = gson.fromJson(protectionTrailStr, NameAndStringValue_T[][].class);
		this.protectionTrailStr = protectionTrailStr;
	}
	public void setRate(short rate) {
		this.rate = rate;
	}
	public void setReversionMode(String reversionMode) {
		this.reversionMode = reversionMode;
	}
	public void setTnpParameters(NameAndStringValue_T[] tnpParameters) {
		Gson gson = new Gson();
		tnpParametersStr = gson.toJson(tnpParameters);
		this.tnpParameters = tnpParameters;
	}
	public void setTnpParametersStr(String tnpParametersStr) {
		Gson gson = new Gson();
		tnpParameters = gson.fromJson(tnpParametersStr, NameAndStringValue_T[].class);
		this.tnpParametersStr = tnpParametersStr;
	}
	public void setTrailNtwProtectionType(String trailNtwProtectionType) {
		this.trailNtwProtectionType = trailNtwProtectionType;
	}
	public void setUserLabel(String userLabel) {
		this.userLabel = userLabel;
	}
	public void setWorkerTrailList(NameAndStringValue_T[][][] workerTrailList) {
		Gson gson = new Gson();
		workerTrailListStr = gson.toJson(workerTrailList);
		this.workerTrailList = workerTrailList;
	}
	public void setWorkerTrailListStr(String workerTrailListStr) {
		Gson gson = new Gson();
		workerTrailList = gson.fromJson(workerTrailListStr, NameAndStringValue_T[][][].class);
		this.workerTrailListStr = workerTrailListStr;
	}
	@Override
	public String toString() {
		return "TrailNtwProtection [name="
				+ Arrays.toString(name) + ", userLabel=" + userLabel
				+ ", nativeEMSName=" + nativeEMSName + ", owner=" + owner
				+ ", protectionGroupType=" + protectionGroupType
				+ ", protectionSchemeState=" + protectionSchemeState
				+ ", reversionMode=" + reversionMode + ", rate=" + rate
				+ ", trailNtwProtectionType=" + trailNtwProtectionType
				+ ", protectionGroupAName="
				+ Arrays.toString(protectionGroupAName)
				+ ", protectionGroupZName="
				+ Arrays.toString(protectionGroupZName) + ", pgATPList="
				+ Arrays.toString(pgATPList) + ", pgZTPList="
				+ Arrays.toString(pgZTPList) + ", workerTrailList="
				+ Arrays.toString(workerTrailList) + ", protectionTrail="
				+ Arrays.toString(protectionTrail) + ", tnpParameters="
				+ Arrays.toString(tnpParameters) + ", apsFunction="
				+ apsFunction + ", networkAccessDomain=" + networkAccessDomain
				+ ", additionalInfo=" + Arrays.toString(additionalInfo) + "]";
	}

}
