package com.otn.collector.huawei.delivery.beans.protection;

import java.util.Arrays;
import java.util.List;

import mtnm.tmforum.org.globaldefs.NameAndStringValue_T;

import com.google.gson.Gson;

/**
 * 该信息模型描述SDH保护子网信息
 * @author xuquan
 * 2014-6-6
 */
public class ProtectionSubnetwork {
	
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
	 * 保护子网速率级别
	 */
	private short layerRate;
	/**
	 * 保护子网类型,取值范围如下:
	 * 1+1保护子网:PSNT_MSP_1_PLUS_1，
	 * M:N保护子网:PSNT_MSP_M_FOR_N，
	 * 2纤单向环保护子网:PSNT_2_FIBER_ULSR，
	 * 2纤双向环保护子网:PSNT_2_FIBER_BLSR，
	 * 4纤双向环保护子网:PSNT_4_FIBER_BLSR，
	 * 2纤单向MSP保护子网:PSNT_USNCP，
	 * 2纤双向MSP保护子网:PSNT_BSNCP，
	 * 单向通道保护子网:PSNT_UPP，
	 * 双向通道双向保护子网:PSNT_BPP，
	 * 网络节点:PSNT_NP，
	 * SNC节点:PSNT_SNC_NODE
	 */
	private String psnType;
	/**
	 * 保护子网内网元ID列表
	 */
	private int[] neIDList;
	private String neIDListStr;
	
	/**
	 * 保护子网连接信息,包括链路源与宿端名称以及端口下的VC4通道号列表信息。
	 * 元素模型请参考：ProtectionSubnetworkLink
	 */
	//private ProtectionSubnetworkLink[][] psnLinks; // 作废，不使用
	private List<ProtectionSubnetworkLink> psnLinkList;
	
	/**
	 * 保护子网附加信息,目前仅体现保护子网绑定的VC4通道数量字段VC4Number
	 */
	private NameAndStringValue_T[] additionalInfo;
	private String additionalInfoStr;

	public NameAndStringValue_T[] getAdditionalInfo() {
		return additionalInfo;
	}
	public String getAdditionalInfoStr() {
		return additionalInfoStr;
	}
	public short getLayerRate() {
		return layerRate;
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
	public int[] getNeIDList() {
		return neIDList;
	}
	public String getOwner() {
		return owner;
	}
	public String getPsnType() {
		return psnType;
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
	public void setLayerRate(short layerRate) {
		this.layerRate = layerRate;
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
	public void setNeIDList(int[] neIDList) {
		Gson gson = new Gson();
		neIDListStr = gson.toJson(neIDList);
		this.neIDList = neIDList;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public void setPsnType(String psnType) {
		this.psnType = psnType;
	}
	public void setUserLabel(String userLabel) {
		this.userLabel = userLabel;
	}
	@Override
	public String toString() {
		return "ProtectionSubnetwork [name="
				+ Arrays.toString(name) + ", userLabel=" + userLabel
				+ ", nativeEMSName=" + nativeEMSName + ", owner=" + owner
				+ ", layerRate=" + layerRate + ", psnType=" + psnType
				+ ", neIDList=" + Arrays.toString(neIDList) + ", additionalInfo="
				+ Arrays.toString(additionalInfo) + "]";
	}
	public String getNeIDListStr() {
		return neIDListStr;
	}
	public void setNeIDListStr(String neIDListStr) {
		Gson gson = new Gson();
		neIDList = gson.fromJson(neIDListStr, int[].class);
		this.neIDListStr = neIDListStr;
	}
	public List<ProtectionSubnetworkLink> getPsnLinkList() {
		return psnLinkList;
	}
	public void setPsnLinkList(List<ProtectionSubnetworkLink> psnLinkList) {
		this.psnLinkList = psnLinkList;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(name);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProtectionSubnetwork other = (ProtectionSubnetwork) obj;
		if (!Arrays.equals(name, other.name))
			return false;
		return true;
	}
}
