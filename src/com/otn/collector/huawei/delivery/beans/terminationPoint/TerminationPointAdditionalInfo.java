package com.otn.collector.huawei.delivery.beans.terminationPoint;

/**
 * 终结点数据类型中附加字段信息
 * @author xuquan
 * 2014-6-18
 */
public class TerminationPointAdditionalInfo {
	private int id;
	private String serviceLoadFlag;
	private String supportFEC;
	private String terminationPointNameStr;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getServiceLoadFlag() {
		return serviceLoadFlag;
	}
	public void setServiceLoadFlag(String serviceLoadFlag) {
		this.serviceLoadFlag = serviceLoadFlag;
	}
	public String getSupportFEC() {
		return supportFEC;
	}
	public void setSupportFEC(String supportFEC) {
		this.supportFEC = supportFEC;
	}
	@Override
	public String toString() {
		return "TerminationPointAdditionalInfo [id=" + id
				+ ", serviceLoadFlag=" + serviceLoadFlag + ", supportFEC="
				+ supportFEC + ", terminationPointNameStr="
				+ terminationPointNameStr + "]";
	}
	public String getTerminationPointNameStr() {
		return terminationPointNameStr;
	}
	public void setTerminationPointNameStr(String terminationPointNameStr) {
		this.terminationPointNameStr = terminationPointNameStr;
	}
}
