package com.otn.collector.huawei.delivery.beans.managedElement;

/**
 * 网元属性数据类型中附加字段信息
 * @author xuquan
 * 2014-6-18
 */
public class ManagedElementAdditionalInfo {
	
	private int id;
	private String phyInfo;
	private String gateWay;
	private String alarmSeverity;
	private String shelfType;
	private String preConfig;
	private String maxTransferRate;
	private String subnetwork;
	private String psnName;
	private String lsrID;
	private String ipAddress;
	private String waveNumber;
	private String managedElementNameStr;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getAlarmSeverity() {
		return alarmSeverity;
	}
	public void setAlarmSeverity(String alarmSeverity) {
		this.alarmSeverity = alarmSeverity;
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
	public String getMaxTransferRate() {
		return maxTransferRate;
	}
	public void setMaxTransferRate(String maxTransferRate) {
		this.maxTransferRate = maxTransferRate;
	}
	public String getSubnetwork() {
		return subnetwork;
	}
	public void setSubnetwork(String subnetwork) {
		this.subnetwork = subnetwork;
	}
	public String getPsnName() {
		return psnName;
	}
	public void setPsnName(String psnName) {
		this.psnName = psnName;
	}
	public String getLsrID() {
		return lsrID;
	}
	public void setLsrID(String lsrID) {
		this.lsrID = lsrID;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getWaveNumber() {
		return waveNumber;
	}
	public void setWaveNumber(String waveNumber) {
		this.waveNumber = waveNumber;
	}
	@Override
	public String toString() {
		return "ManagedElementAdditionalInfo [id=" + id + ", phyInfo="
				+ phyInfo + ", gateWay=" + gateWay + ", alarmSeverity="
				+ alarmSeverity + ", shelfType=" + shelfType + ", preConfig="
				+ preConfig + ", maxTransferRate=" + maxTransferRate
				+ ", subnetwork=" + subnetwork + ", psnName=" + psnName
				+ ", lsrID=" + lsrID + ", ipAddress=" + ipAddress
				+ ", waveNumber=" + waveNumber + "]";
	}
	public String getManagedElementNameStr() {
		return managedElementNameStr;
	}
	public void setManagedElementNameStr(String managedElementNameStr) {
		this.managedElementNameStr = managedElementNameStr;
	}
}
