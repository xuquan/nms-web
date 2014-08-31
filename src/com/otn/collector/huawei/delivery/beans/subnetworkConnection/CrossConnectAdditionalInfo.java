package com.otn.collector.huawei.delivery.beans.subnetworkConnection;

/**
 * 交叉连接属性数据类型中附加字段信息
 * @author xuquan
 * 2014-6-18
 */
public class CrossConnectAdditionalInfo {

	private int id;
	private String direction;
	private String protectionRole;
	private String fixed;
	private String clientType;
	private String clientRate;
	private String frequency;
	private String oduk_TimeSlot;
	private int crossConnectId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getProtectionRole() {
		return protectionRole;
	}
	public void setProtectionRole(String protectionRole) {
		this.protectionRole = protectionRole;
	}
	public String getFixed() {
		return fixed;
	}
	public void setFixed(String fixed) {
		this.fixed = fixed;
	}
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	public String getClientRate() {
		return clientRate;
	}
	public void setClientRate(String clientRate) {
		this.clientRate = clientRate;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getOduk_TimeSlot() {
		return oduk_TimeSlot;
	}
	public void setOduk_TimeSlot(String oduk_TimeSlot) {
		this.oduk_TimeSlot = oduk_TimeSlot;
	}
	@Override
	public String toString() {
		return "CrossConnectAdditionalInfo [id=" + id + ", direction="
				+ direction + ", protectionRole=" + protectionRole + ", fixed="
				+ fixed + ", clientType=" + clientType + ", clientRate="
				+ clientRate + ", frequency=" + frequency + ", oduk_TimeSlot="
				+ oduk_TimeSlot + ", crossConnectId=" + crossConnectId + "]";
	}
	public int getCrossConnectId() {
		return crossConnectId;
	}
	public void setCrossConnectId(int crossConnectId) {
		this.crossConnectId = crossConnectId;
	}
}
