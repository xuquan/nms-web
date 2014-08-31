package com.otn.collector.huawei.delivery.beans.transmissionParameters;

import java.util.Arrays;

import mtnm.tmforum.org.globaldefs.NameAndStringValue_T;

import com.google.gson.Gson;

public class LayeredParameters {
	private int id;
	private short layer;
	private NameAndStringValue_T[] transmissionParams;
	private String transmissionParamsStr;
	private String tpDataId;
	private String terminationPointNameStr;
	
	public int getId() {
		return id;
	}
	public short getLayer() {
		return layer;
	}
	public NameAndStringValue_T[] getTransmissionParams() {
		return transmissionParams;
	}
	public String getTransmissionParamsStr() {
		return transmissionParamsStr;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setLayer(short layer) {
		this.layer = layer;
	}
	public void setTransmissionParams(NameAndStringValue_T[] transmissionParams) {
		Gson gson = new Gson();
		transmissionParamsStr = gson.toJson(transmissionParams);
		this.transmissionParams = transmissionParams;
	}
	public void setTransmissionParamsStr(String transmissionParamsStr) {
		Gson gson = new Gson();
		transmissionParams = gson.fromJson(transmissionParamsStr, NameAndStringValue_T[].class);
		this.transmissionParamsStr = transmissionParamsStr;
	}
	@Override
	public String toString() {
		return "LayeredParameters [id=" + id + ", layer=" + layer
				+ ", transmissionParams=" + Arrays.toString(transmissionParams)
				+ "]";
	}
	public String getTerminationPointNameStr() {
		return terminationPointNameStr;
	}
	public void setTerminationPointNameStr(String terminationPointNameStr) {
		this.terminationPointNameStr = terminationPointNameStr;
	}
	public String getTpDataId() {
		return tpDataId;
	}
	public void setTpDataId(String tpDataId) {
		this.tpDataId = tpDataId;
	}
}
