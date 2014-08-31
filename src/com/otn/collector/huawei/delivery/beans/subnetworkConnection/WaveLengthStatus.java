package com.otn.collector.huawei.delivery.beans.subnetworkConnection;

import java.util.Arrays;

import mtnm.tmforum.org.globaldefs.NameAndStringValue_T;

import com.google.gson.Gson;

/**
 * 波长状态数据结构
 * @author xuquan
 * 2014-6-4
 */
public class WaveLengthStatus {
	
	private int id;
	
	/**
	 * 波长频率，单位Ghz
	 */
	private String frequency = "";

	/**
	 * 已经使用的波长数量
	 */
	private short used;

	/**
	 * 未使用的波长数量
	 */
	private short unused;

	/**
	 * 附加信息，目前为空
	 */
	private NameAndStringValue_T[] addtionalInfo;
	private String additionalInfoStr;

	public String getAdditionalInfoStr() {
		return additionalInfoStr;
	}

	public NameAndStringValue_T[] getAddtionalInfo() {
		return addtionalInfo;
	}

	public String getFrequency() {
		return frequency;
	}

	public int getId() {
		return id;
	}

	public short getUnused() {
		return unused;
	}

	public short getUsed() {
		return used;
	}

	public void setAdditionalInfoStr(String additionalInfoStr) {
		Gson gson = new Gson();
		addtionalInfo = gson.fromJson(additionalInfoStr, NameAndStringValue_T[].class);
		this.additionalInfoStr = additionalInfoStr;
	}

	public void setAddtionalInfo(NameAndStringValue_T[] addtionalInfo) {
		Gson gson = new Gson();
		additionalInfoStr = gson.toJson(addtionalInfo);
		this.addtionalInfo = addtionalInfo;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUnused(short unused) {
		this.unused = unused;
	}

	public void setUsed(short used) {
		this.used = used;
	}

	@Override
	public String toString() {
		return "WaveLengthStatus [id=" + id + ", frequency=" + frequency
				+ ", used=" + used + ", unused=" + unused + ", addtionalInfo="
				+ Arrays.toString(addtionalInfo) + "]";
	}

}