package com.otn.collector.huawei.delivery.beans.equipment;

/**
 * 容器属性的数据类型中附加字段信息
 * @author xuquan
 * 2014-6-18
 */
public class EquipmentHolderAdditionalInfo {
	private int id;
	private String alarmSeverity;
	private String phyInfo;
	private String gateWay;
	private String version;
	private String productName;
	private String shelfType;
	private String preConfig;
	private String equipmentHolderNameStr;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAlarmSeverity() {
		return alarmSeverity;
	}
	public void setAlarmSeverity(String alarmSeverity) {
		this.alarmSeverity = alarmSeverity;
	}
	public String getPhyInfo() {
		return phyInfo;
	}
	public void setPhyInfo(String phyInfo) {
		this.phyInfo = phyInfo;
	}
	public String getGateWay() {
		return gateWay;
	}
	public void setGateWay(String gateWay) {
		this.gateWay = gateWay;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getShelfType() {
		return shelfType;
	}
	public void setShelfType(String shelfType) {
		this.shelfType = shelfType;
	}
	public String getPreConfig() {
		return preConfig;
	}
	public void setPreConfig(String preConfig) {
		this.preConfig = preConfig;
	}
	@Override
	public String toString() {
		return "EquipmentHolderAdditionalInfo [id=" + id + ", alarmSeverity="
				+ alarmSeverity + ", phyInfo=" + phyInfo + ", gateWay="
				+ gateWay + ", version=" + version + ", productName="
				+ productName + ", shelfType=" + shelfType + ", preConfig="
				+ preConfig + ", equipmentHolderNameStr="
				+ equipmentHolderNameStr + "]";
	}
	public String getEquipmentHolderNameStr() {
		return equipmentHolderNameStr;
	}
	public void setEquipmentHolderNameStr(String equipmentHolderNameStr) {
		this.equipmentHolderNameStr = equipmentHolderNameStr;
	}
}
