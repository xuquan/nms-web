package com.otn.collector.huawei.delivery.beans.topologicalLink;

import java.util.Arrays;

import mtnm.tmforum.org.globaldefs.NameAndStringValue_T;

import com.google.gson.Gson;

/**
 * 拓扑链路数据类型
 * @author xuquan
 * 2014-6-4
 */
public class TopologicalLink {
	
	/**
	 * 拓扑链路对象名称
	 */
	private NameAndStringValue_T[] name;
	private String nameStr;
	
	/**
	 * 用户标识符，默认为空
	 */
	private String userLabel = "";

	/**
	 * 本地名称
	 */
	private String nativeEMSName = "";

	/**
	 * 对象所有者名称，默认为空
	 */
	private String owner = "";

	/**
	 * 方向，取值范围：CD_UNI、CD_BI
	 */
	private String direction;

	/**
	 * 层速率
	 */
	private short rate;

	/**
	 * 源端
	 */
	private NameAndStringValue_T[] aEndTP;
	private String aEndTPStr;

	/**
	 * 宿端
	 */
	private NameAndStringValue_T[] zEndTP;
	private String zEndTPStr;

	/**
	 * 附加信息
	 */
	private TopologicalLinkAdditionalInfo additionalInfo;
	
	private int routeAndTopologicalLinkId;
	
	private String subnetworkNameStr;
	
	private String managedElementNameStr;

	public NameAndStringValue_T[] getName() {
		return name;
	}

	public void setName(NameAndStringValue_T[] name) {
		Gson gson = new Gson();
		nameStr = gson.toJson(name);
		this.name = name;
	}

	public String getNameStr() {
		return nameStr;
	}

	public void setNameStr(String nameStr) {
		Gson gson = new Gson();
		name = gson.fromJson(nameStr, NameAndStringValue_T[].class);
		this.nameStr = nameStr;
	}

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

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public short getRate() {
		return rate;
	}

	public void setRate(short rate) {
		this.rate = rate;
	}

	public NameAndStringValue_T[] getaEndTP() {
		return aEndTP;
	}

	public void setaEndTP(NameAndStringValue_T[] aEndTP) {
		Gson gson = new Gson();
		aEndTPStr = gson.toJson(aEndTP);
		this.aEndTP = aEndTP;
	}

	public String getaEndTPStr() {
		return aEndTPStr;
	}

	public void setaEndTPStr(String aEndTPStr) {
		Gson gson = new Gson();
		aEndTP = gson.fromJson(aEndTPStr, NameAndStringValue_T[].class);
		this.aEndTPStr = aEndTPStr;
	}

	public NameAndStringValue_T[] getzEndTP() {
		return zEndTP;
	}

	public void setzEndTP(NameAndStringValue_T[] zEndTP) {
		Gson gson = new Gson();
		zEndTPStr = gson.toJson(zEndTP);
		this.zEndTP = zEndTP;
	}

	public String getzEndTPStr() {
		return zEndTPStr;
	}

	public void setzEndTPStr(String zEndTPStr) {
		Gson gson = new Gson();
		zEndTP = gson.fromJson(zEndTPStr, NameAndStringValue_T[].class);
		this.zEndTPStr = zEndTPStr;
	}


	public TopologicalLinkAdditionalInfo getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(TopologicalLinkAdditionalInfo additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public int getRouteAndTopologicalLinkId() {
		return routeAndTopologicalLinkId;
	}

	public void setRouteAndTopologicalLinkId(int routeAndTopologicalLinkId) {
		this.routeAndTopologicalLinkId = routeAndTopologicalLinkId;
	}

	@Override
	public String toString() {
		return "TopologicalLink [name=" + Arrays.toString(name) + ", nameStr="
				+ nameStr + ", userLabel=" + userLabel + ", nativeEMSName="
				+ nativeEMSName + ", owner=" + owner + ", direction="
				+ direction + ", rate=" + rate + ", aEndTP="
				+ Arrays.toString(aEndTP) + ", aEndTPStr=" + aEndTPStr
				+ ", zEndTP=" + Arrays.toString(zEndTP) + ", zEndTPStr="
				+ zEndTPStr + ", additionalInfo=" + additionalInfo
				+ ", routeAndTopologicalLinkId=" + routeAndTopologicalLinkId
				+ ", subnetworkNameStr=" + subnetworkNameStr
				+ ", managedElementNameStr=" + managedElementNameStr + "]";
	}

	public String getSubnetworkNameStr() {
		return subnetworkNameStr;
	}

	public void setSubnetworkNameStr(String subnetworkNameStr) {
		this.subnetworkNameStr = subnetworkNameStr;
	}

	public String getManagedElementNameStr() {
		return managedElementNameStr;
	}

	public void setManagedElementNameStr(String managedElementNameStr) {
		this.managedElementNameStr = managedElementNameStr;
	}

}
