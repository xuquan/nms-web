package com.otn.collector.huawei.delivery.beans.subnetworkConnection;

/**
 * SNC对象属性的数据类型中附加字段信息
 * @author xuquan
 * 2014-6-18
 */
public class SubnetworkConnectionAdditionalInfo {
	private int id;
	private String ovpnCustomer;
	private String priority;
	private String opciState;
	private String sncNameStr;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOvpnCustomer() {
		return ovpnCustomer;
	}
	public void setOvpnCustomer(String ovpnCustomer) {
		this.ovpnCustomer = ovpnCustomer;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getOpciState() {
		return opciState;
	}
	public void setOpciState(String opciState) {
		this.opciState = opciState;
	}
	@Override
	public String toString() {
		return "SubnetworkConnectionAdditionalInfo [id=" + id
				+ ", ovpnCustomer=" + ovpnCustomer + ", priority=" + priority
				+ ", opciState=" + opciState + "]";
	}
	public String getSncNameStr() {
		return sncNameStr;
	}
	public void setSncNameStr(String sncNameStr) {
		this.sncNameStr = sncNameStr;
	}
}
