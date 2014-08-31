package com.otn.collector.huawei.delivery.beans.equipment;

/**
 * 单板属性数据类型中附加字段信息
 * @author xuquan
 * 2014-6-18
 */
public class EquipmentAdditionalInfo {
	private int id;
	private String alarmSeverity;
	private String hardwareVersion;
	private String port_XX_SFP;
	private String port_X_SFP_BarCode;
	private String manufactured;
	private String clei;
	private String port_X_SFP_CLEI;
	private String port_X_SFP_Item;
	private String port_X_SFP_Manufactured;
	private String equipmentNameStr;
	
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
	public String getHardwareVersion() {
		return hardwareVersion;
	}
	public void setHardwareVersion(String hardwareVersion) {
		this.hardwareVersion = hardwareVersion;
	}
	public String getPort_XX_SFP() {
		return port_XX_SFP;
	}
	public void setPort_XX_SFP(String port_XX_SFP) {
		this.port_XX_SFP = port_XX_SFP;
	}
	public String getPort_X_SFP_BarCode() {
		return port_X_SFP_BarCode;
	}
	public void setPort_X_SFP_BarCode(String port_X_SFP_BarCode) {
		this.port_X_SFP_BarCode = port_X_SFP_BarCode;
	}
	public String getManufactured() {
		return manufactured;
	}
	public void setManufactured(String manufactured) {
		this.manufactured = manufactured;
	}
	public String getClei() {
		return clei;
	}
	public void setClei(String clei) {
		this.clei = clei;
	}
	public String getPort_X_SFP_CLEI() {
		return port_X_SFP_CLEI;
	}
	public void setPort_X_SFP_CLEI(String port_X_SFP_CLEI) {
		this.port_X_SFP_CLEI = port_X_SFP_CLEI;
	}
	public String getPort_X_SFP_Item() {
		return port_X_SFP_Item;
	}
	public void setPort_X_SFP_Item(String port_X_SFP_Item) {
		this.port_X_SFP_Item = port_X_SFP_Item;
	}
	public String getPort_X_SFP_Manufactured() {
		return port_X_SFP_Manufactured;
	}
	public void setPort_X_SFP_Manufactured(String port_X_SFP_Manufactured) {
		this.port_X_SFP_Manufactured = port_X_SFP_Manufactured;
	}
	@Override
	public String toString() {
		return "EquipmentAdditionalInfo [id=" + id + ", alarmSeverity="
				+ alarmSeverity + ", hardwareVersion=" + hardwareVersion
				+ ", port_XX_SFP=" + port_XX_SFP + ", port_X_SFP_BarCode="
				+ port_X_SFP_BarCode + ", manufactured=" + manufactured
				+ ", clei=" + clei + ", port_X_SFP_CLEI=" + port_X_SFP_CLEI
				+ ", port_X_SFP_Item=" + port_X_SFP_Item
				+ ", port_X_SFP_Manufactured=" + port_X_SFP_Manufactured
				+ ", equipmentNameStr=" + equipmentNameStr + "]";
	}
	public String getEquipmentNameStr() {
		return equipmentNameStr;
	}
	public void setEquipmentNameStr(String equipmentNameStr) {
		this.equipmentNameStr = equipmentNameStr;
	}
}
