package com.otn.collector.huawei.delivery.beans.TopoManagementManager;

import java.util.Arrays;

import mtnm.tmforum.org.globaldefs.NameAndStringValue_T;

import com.google.gson.Gson;


/**
 * 节点数据类型
 * @author xuquan
 * 2014-6-4
 */
public class Node {
	
	/**
	 * 名称标识
	 */
	private NameAndStringValue_T[] name;
	private String nameStr;

	/**
	 * 本地名称
	 */
	private String nativeEMSName = "";

	/**
	 * 节点类型
	 * 包括：NODETYPE_ME 网元节点类型
	 * NODETYPE_TOPO_SN 拓扑业务节点类型
	 */
	private String nodeType;

	/**
	 * 坐标信息
	 */
	private Position position;

	/**
	 * 父节点名称
	 */
	private NameAndStringValue_T[] parent;
	private String parentStr;

	/**
	 * 附加信息
	 */
	private NameAndStringValue_T[] additionalInfo;
	private String additionalInfoStr;

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

	public String getNodeType() {
		return nodeType;
	}

	public NameAndStringValue_T[] getParent() {
		return parent;
	}

	public String getParentStr() {
		return parentStr;
	}

	public Position getPosition() {
		return position;
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

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public void setParent(NameAndStringValue_T[] parent) {
		Gson gson = new Gson();
		parentStr = gson.toJson(parent);
		this.parent = parent;
	}

	public void setParentStr(String parentStr) {
		Gson gson = new Gson();
		parent = gson.fromJson(parentStr, NameAndStringValue_T[].class);
		this.parentStr = parentStr;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Node [name=" + Arrays.toString(name)
				+ ", nativeEMSName=" + nativeEMSName + ", nodeType=" + nodeType
				+ ", position=" + position + ", parent="
				+ Arrays.toString(parent) + ", additionalInfo="
				+ Arrays.toString(additionalInfo) + "]";
	}

}
