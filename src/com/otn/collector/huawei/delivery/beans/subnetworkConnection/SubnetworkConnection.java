package com.otn.collector.huawei.delivery.beans.subnetworkConnection;

import java.util.Arrays;

import mtnm.tmforum.org.globaldefs.NameAndStringValue_T;

import com.google.gson.Gson;


/**
 * SNC对象属性的数据类型
 * @author xuquan
 * 2014-6-4
 */
public class SubnetworkConnection {
	
	/**
	 * SNC对象名称
	 */
	private NameAndStringValue_T[] name;
	private String nameStr;

	/**
	 * 用户标识符
	 */
	private String userLabel = "";

	/**
	 * 本地名称
	 */
	private String nativeEMSName = "";

	/**
	 * 对象所有者名称
	 */
	private String owner = "";

	/**
	 * SNC的激活状态
	 */
	private String sncState;

	/**
	 * 方向，取值范围：CD_UNI、CD_BI
	 */
	private String direction;

	/**
	 * SNC的层速率级别
	 */
	private short rate;

	/**
	 * 静态保护级别。
	 * 取值范围：PREEMPTIBLE UNPROTECTED PARTIALLY_PROTECTED
	 * FULLY_PROTECTED HIGHLY_PROTECTED
	 */
	private String staticProtectionLevel;

	/**
	 * SNC类型
	 * 目前只支持ST_SIMPLE（一源一宿），
	 * ST_ADD_DROP_A（两源一宿），
	 * ST_ADD_DROP_Z（一源两宿）。
	 */
	private String sncType;

	/**
	 * SNC源端tp列表，元素模型请参考TPData
	 */
	private TPData[] aEnd;

	/**
	 * SNC宿端tp列表，元素模型请参考TPData
	 */
	private TPData[] zEnd;

	/**
	 * 重路由指示，取值包括：RR_NA，RR_NO，RR_YES
	 */
	private String rerouteAllowed;

	/**
	 * 网络路由指示，取值包括：NR_NA，NR_NO，NR_YES
	 */
	private String networkRouted;

	/**
	 * 附加信息
	 */
	private SubnetworkConnectionAdditionalInfo additionalInfo;
	
	private String subnetworkNameStr;

	public TPData[] getaEnd() {
		return aEnd;
	}

	public String getDirection() {
		return direction;
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

	public String getNetworkRouted() {
		return networkRouted;
	}

	public String getOwner() {
		return owner;
	}

	public short getRate() {
		return rate;
	}

	public String getRerouteAllowed() {
		return rerouteAllowed;
	}

	public String getSncState() {
		return sncState;
	}

	public String getSncType() {
		return sncType;
	}

	public String getStaticProtectionLevel() {
		return staticProtectionLevel;
	}

	public String getUserLabel() {
		return userLabel;
	}

	public TPData[] getzEnd() {
		return zEnd;
	}

	public void setaEnd(TPData[] aEnd) {
		this.aEnd = aEnd;
	}

	public void setDirection(String direction) {
		this.direction = direction;
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

	public void setNetworkRouted(String networkRouted) {
		this.networkRouted = networkRouted;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setRate(short rate) {
		this.rate = rate;
	}

	public void setRerouteAllowed(String rerouteAllowed) {
		this.rerouteAllowed = rerouteAllowed;
	}

	public void setSncState(String sncState) {
		this.sncState = sncState;
	}

	public void setSncType(String sncType) {
		this.sncType = sncType;
	}

	public void setStaticProtectionLevel(String staticProtectionLevel) {
		this.staticProtectionLevel = staticProtectionLevel;
	}

	public void setUserLabel(String userLabel) {
		this.userLabel = userLabel;
	}

	public void setzEnd(TPData[] zEnd) {
		this.zEnd = zEnd;
	}

	public SubnetworkConnectionAdditionalInfo getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(SubnetworkConnectionAdditionalInfo additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	@Override
	public String toString() {
		return "SubnetworkConnection [name=" + Arrays.toString(name)
				+ ", nameStr=" + nameStr + ", userLabel=" + userLabel
				+ ", nativeEMSName=" + nativeEMSName + ", owner=" + owner
				+ ", sncState=" + sncState + ", direction=" + direction
				+ ", rate=" + rate + ", staticProtectionLevel="
				+ staticProtectionLevel + ", sncType=" + sncType + ", aEnd="
				+ Arrays.toString(aEnd) + ", zEnd=" + Arrays.toString(zEnd)
				+ ", rerouteAllowed=" + rerouteAllowed + ", networkRouted="
				+ networkRouted + ", additionalInfo=" + additionalInfo
				+ ", subnetworkNameStr=" + subnetworkNameStr + "]";
	}

	public String getSubnetworkNameStr() {
		return subnetworkNameStr;
	}

	public void setSubnetworkNameStr(String subnetworkNameStr) {
		this.subnetworkNameStr = subnetworkNameStr;
	}

}
