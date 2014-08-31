package com.otn.collector.huawei.delivery.beans.multiLayerSubnetwork;

import java.util.Arrays;
import java.util.List;

import mtnm.tmforum.org.globaldefs.NameAndStringValue_T;

import com.google.gson.Gson;
import com.otn.collector.huawei.delivery.beans.subnetworkConnection.SubnetworkConnection;
import com.otn.collector.huawei.delivery.beans.topologicalLink.TopologicalLink;

/**
 * 子网对象属性的数据类型
 * @author xuquan
 * 2014-6-4
 */
public class MultiLayerSubnetwork {
	
	/**
	 * 表示子网对象名称
	 */
	private NameAndStringValue_T[] name;
	private String nameStr;
	
	/**
	 * 用户标识符，默认为“SubnetWork_1”
	 */
	private String userLabel = "";

	/**
	 * 本地名称，默认为“SubnetWork_1”
	 */
	private String nativeEMSName = "";

	/**
	 * 对象所有者名称，默认为空
	 */
	private String owner = "";

	/**
	 * 子网类型
	 * 固定为“multiLayerSubnetwork::TOPO_MESH”。
	 */
	private String subnetworkType;

	/**
	 * 支持的速率级别列表
	 */
	private short[] supportedRates;
	private String supportedRatesStr;

	/**
	 * 附加信息
	 */
	private String multiLayerSubnetworkLocation;
	
	/**
	 * 子网内所有子网连接的详细信息列表
	 */
	private List<SubnetworkConnection> sncList;
	
	/**
	 * 子网内网元之间的拓扑连接的详细信息列表
	 */
	private List<TopologicalLink> tlList;
	
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

	public String getSubnetworkType() {
		return subnetworkType;
	}

	public short[] getSupportedRates() {
		return supportedRates;
	}

	public String getSupportedRatesStr() {
		return supportedRatesStr;
	}

	public String getUserLabel() {
		return userLabel;
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

	public void setSubnetworkType(String subnetworkType) {
		this.subnetworkType = subnetworkType;
	}

	public void setSupportedRates(short[] supportedRates) {
		Gson gson = new Gson();
		supportedRatesStr = gson.toJson(supportedRates);
		this.supportedRates = supportedRates;
		this.supportedRates = supportedRates;
	}

	public void setSupportedRatesStr(String supportedRatesStr) {
		Gson gson = new Gson();
		supportedRates = gson.fromJson(supportedRatesStr, short[].class);
		this.supportedRatesStr = supportedRatesStr;
	}

	public void setUserLabel(String userLabel) {
		this.userLabel = userLabel;
	}

	public List<SubnetworkConnection> getSncList() {
		return sncList;
	}

	public void setSncList(List<SubnetworkConnection> sncList) {
		this.sncList = sncList;
	}

	public List<TopologicalLink> getTlList() {
		return tlList;
	}

	public void setTlList(List<TopologicalLink> tlList) {
		this.tlList = tlList;
	}

	public String getMultiLayerSubnetworkLocation() {
		return multiLayerSubnetworkLocation;
	}

	public void setMultiLayerSubnetworkLocation(String multiLayerSubnetworkLocation) {
		this.multiLayerSubnetworkLocation = multiLayerSubnetworkLocation;
	}

	@Override
	public String toString() {
		return "MultiLayerSubnetwork [name="
				+ Arrays.toString(name) + ", nameStr=" + nameStr
				+ ", userLabel=" + userLabel + ", nativeEMSName="
				+ nativeEMSName + ", owner=" + owner + ", subnetworkType="
				+ subnetworkType + ", supportedRates="
				+ Arrays.toString(supportedRates) + ", supportedRatesStr="
				+ supportedRatesStr + ", multiLayerSubnetworkLocation="
				+ multiLayerSubnetworkLocation + ", sncList=" + sncList
				+ ", tlList=" + tlList + "]";
	}

}
