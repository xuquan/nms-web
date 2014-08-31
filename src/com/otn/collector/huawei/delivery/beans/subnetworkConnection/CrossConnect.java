package com.otn.collector.huawei.delivery.beans.subnetworkConnection;

import java.util.Arrays;

import mtnm.tmforum.org.globaldefs.NameAndStringValue_T;

import com.google.gson.Gson;

/**
 * 交叉连接属性数据类型
 * @author xuquan
 * 2014-6-4
 */
public class CrossConnect {
	
	private int id;
	
	/**
	 * 交叉连接激活状态
	 */
	private boolean active;
	
	/**
	 * 交叉连接方向，取值范围：CD_UNI，CD_BI
	 */
	private String direction;
	
	/**
	 * 交叉连接类型
	 * 取值范围：ST_SIMPLE，ST_ADD_DROP_A，
	 * ST_ADD_DROP_Z，ST_INTERCONNECT，
	 * ST_DOUBLE_INTERCONNECT，ST_DOUBLE_ADD_DROP，
	 * ST_OPEN_ADD_DROP，ST_EXPLICIT。
	 */
	private String ccType;
	
	/**
	 * 交叉连接源端tp标识列表
	 */
	private NameAndStringValue_T[][] aEndNameList;
	private String aEndNameListStr;
	
	/**
	 * 交叉连接宿端tp标识列表
	 */
	private NameAndStringValue_T[][] zEndNameList;
	private String zEndNameListStr;
	
	/**
	 * 附加信息
	 */
	private CrossConnectAdditionalInfo additionalInfo;
	
	private String managedElementNameStr;
	
	public NameAndStringValue_T[][] getaEndNameList() {
		return aEndNameList;
	}

	public String getaEndNameListStr() {
		return aEndNameListStr;
	}

	public String getCcType() {
		return ccType;
	}

	public String getDirection() {
		return direction;
	}

	public int getId() {
		return id;
	}

	public NameAndStringValue_T[][] getzEndNameList() {
		return zEndNameList;
	}

	public String getzEndNameListStr() {
		return zEndNameListStr;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setaEndNameList(NameAndStringValue_T[][] aEndNameList) {
		Gson gson = new Gson();
		aEndNameListStr = gson.toJson(aEndNameList);
		this.aEndNameList = aEndNameList;
	}

	public void setaEndNameListStr(String aEndNameListStr) {
		Gson gson = new Gson();
		aEndNameList = gson.fromJson(aEndNameListStr, NameAndStringValue_T[][].class);
		this.aEndNameListStr = aEndNameListStr;
	}

	public void setCcType(String ccType) {
		this.ccType = ccType;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setzEndNameList(NameAndStringValue_T[][] zEndNameList) {
		Gson gson = new Gson();
		zEndNameListStr = gson.toJson(zEndNameList);
		this.zEndNameList = zEndNameList;
	}

	public void setzEndNameListStr(String zEndNameListStr) {
		Gson gson = new Gson();
		zEndNameList = gson.fromJson(zEndNameListStr, NameAndStringValue_T[][].class);
		this.zEndNameListStr = zEndNameListStr;
	}

	public CrossConnectAdditionalInfo getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(CrossConnectAdditionalInfo additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	@Override
	public String toString() {
		return "CrossConnect [id=" + id + ", active=" + active + ", direction="
				+ direction + ", ccType=" + ccType + ", aEndNameList="
				+ Arrays.toString(aEndNameList) + ", aEndNameListStr="
				+ aEndNameListStr + ", zEndNameList="
				+ Arrays.toString(zEndNameList) + ", zEndNameListStr="
				+ zEndNameListStr + ", additionalInfo=" + additionalInfo
				+ ", managedElementNameStr=" + managedElementNameStr + "]";
	}

	public String getManagedElementNameStr() {
		return managedElementNameStr;
	}

	public void setManagedElementNameStr(String managedElementNameStr) {
		this.managedElementNameStr = managedElementNameStr;
	}


}
