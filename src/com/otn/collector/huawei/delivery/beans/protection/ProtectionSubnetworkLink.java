package com.otn.collector.huawei.delivery.beans.protection;

import java.util.Arrays;

import mtnm.tmforum.org.globaldefs.NameAndStringValue_T;

import com.google.gson.Gson;

/**
 * 该信息模型描述保护子网连接信息
 * @author xuquan
 * 2014-6-6
 */
public class ProtectionSubnetworkLink {
	
	private int id;
	
	/**
	 * 端口下的VC4通道号列表
	 */
	private short[] vc4List;
	private String vc4ListStr;
	
	/**
	 * 链路源端口名称
	 */
	private NameAndStringValue_T[] srcTP;
	private String srcTPStr;
	
	/**
	 * 链路宿端口名称
	 */
	private NameAndStringValue_T[] snkTP;
	private String snkTPStr;
	
	private String protectionSubnetworkNameStr;
	
	public int getId() {
		return id;
	}
	public NameAndStringValue_T[] getSnkTP() {
		return snkTP;
	}
	public String getSnkTPStr() {
		return snkTPStr;
	}
	public NameAndStringValue_T[] getSrcTP() {
		return srcTP;
	}
	public String getSrcTPStr() {
		return srcTPStr;
	}
	public short[] getVc4List() {
		return vc4List;
	}
	public String getVc4ListStr() {
		return vc4ListStr;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setSnkTP(NameAndStringValue_T[] snkTP) {
		Gson gson = new Gson();
		snkTPStr = gson.toJson(snkTP);
		this.snkTP = snkTP;
	}
	public void setSnkTPStr(String snkTPStr) {
		Gson gson = new Gson();
		snkTP = gson.fromJson(snkTPStr, NameAndStringValue_T[].class);
		this.snkTPStr = snkTPStr;
	}
	public void setSrcTP(NameAndStringValue_T[] srcTP) {
		Gson gson = new Gson();
		srcTPStr = gson.toJson(srcTP);
		this.srcTP = srcTP;
	}
	public void setSrcTPStr(String srcTPStr) {
		Gson gson = new Gson();
		srcTP = gson.fromJson(srcTPStr, NameAndStringValue_T[].class);
		this.srcTPStr = srcTPStr;
	}
	
	public void setVc4List(short[] vc4List) {
		Gson gson = new Gson();
		vc4ListStr = gson.toJson(vc4List);
		this.vc4List = vc4List;
	}
	public void setVc4ListStr(String vc4ListStr) {
		Gson gson = new Gson();
		vc4List = gson.fromJson(vc4ListStr, short[].class);
		this.vc4ListStr = vc4ListStr;
	}
	@Override
	public String toString() {
		return "ProtectionSubnetworkLink [id=" + id + ", vc4List="
				+ Arrays.toString(vc4List) + ", vc4ListStr=" + vc4ListStr
				+ ", srcTP=" + Arrays.toString(srcTP) + ", srcTPStr="
				+ srcTPStr + ", snkTP=" + Arrays.toString(snkTP)
				+ ", snkTPStr=" + snkTPStr + ", protectionSubnetworkNameStr="
				+ protectionSubnetworkNameStr + "]";
	}
	public String getProtectionSubnetworkNameStr() {
		return protectionSubnetworkNameStr;
	}
	public void setProtectionSubnetworkNameStr(String protectionSubnetworkNameStr) {
		this.protectionSubnetworkNameStr = protectionSubnetworkNameStr;
	}
}
