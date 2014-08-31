package com.otn.collector.huawei.delivery.beans.equipment;

import java.util.Arrays;

import mtnm.tmforum.org.globaldefs.NameAndStringValue_T;

import com.google.gson.Gson;

/**
 * 特定对象附加信息
 * @author xuquan
 * 2014-6-4
 */
public class ObjectAdditionalInfo {
	
	private int id;
	
	private String meOrHolderId;

	/**
	 * 对象名称
	 */
	private NameAndStringValue_T[] objectName;
	private String objectNameStr;
	
	/**
	 * 对象附加信息
	 */
	private NameAndStringValue_T[] additionalInfo;
	private String additionalInfoStr;

	public NameAndStringValue_T[] getObjectName() {
		return objectName;
	}

	public void setObjectName(NameAndStringValue_T[] objectName) {
		Gson gson = new Gson();
		objectNameStr = gson.toJson(objectName);
		this.objectName = objectName;
	}

	public NameAndStringValue_T[] getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(NameAndStringValue_T[] additionalInfo) {
		Gson gson = new Gson();
		additionalInfoStr = gson.toJson(additionalInfo);
		this.additionalInfo = additionalInfo;
	}

	@Override
	public String toString() {
		return "ObjectAdditionalInfo [id=" + id + ", meOrHolderId="
				+ meOrHolderId + ", objectName=" + Arrays.toString(objectName)
				+ ", additionalInfo=" + Arrays.toString(additionalInfo) + "]";
	}

	public String getObjectNameStr() {
		return objectNameStr;
	}

	public void setObjectNameStr(String objectNameStr) {
		Gson gson = new Gson();
		objectName = gson.fromJson(objectNameStr, NameAndStringValue_T[].class);
		this.objectNameStr = objectNameStr;
	}

	public String getAdditionalInfoStr() {
		return additionalInfoStr;
	}

	public void setAdditionalInfoStr(String additionalInfoStr) {
		Gson gson = new Gson();
		additionalInfo = gson.fromJson(additionalInfoStr, NameAndStringValue_T[].class);
		this.additionalInfoStr = additionalInfoStr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMeOrHolderId() {
		return meOrHolderId;
	}

	public void setMeOrHolderId(String meOrHolderId) {
		this.meOrHolderId = meOrHolderId;
	}

}
