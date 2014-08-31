package com.otn.collector.huawei.delivery.beans.equipment;

/**
 * 机框信息
 * @author xuquan
 * 2014-6-4
 */
public class Shelf {
	
	private int id;
	
	/**
	 * 机框名称
	 */
	private String name = "";

	/**
	 * 机框所在的机房的名称
	 */
	private String equipmentRoomName = "";

	/**
	 * 机框所在的机柜的名称
	 */
	private String cabinetName = "";

	/**
	 * 机框ID
	 */
	private String numbering = "";

	/**
	 * 机架位置
	 */
	private String locationOfCabinet = "";

	/**
	 * 备注 
	 * 取值范围：NA、Up、Down、Middle
	 */
	private String memo = "";
	
	private int physicalLocationInfoId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEquipmentRoomName() {
		return equipmentRoomName;
	}

	public void setEquipmentRoomName(String equipmentRoomName) {
		this.equipmentRoomName = equipmentRoomName;
	}

	public String getCabinetName() {
		return cabinetName;
	}

	public void setCabinetName(String cabinetName) {
		this.cabinetName = cabinetName;
	}

	public String getNumbering() {
		return numbering;
	}

	public void setNumbering(String numbering) {
		this.numbering = numbering;
	}

	public String getLocationOfCabinet() {
		return locationOfCabinet;
	}

	public void setLocationOfCabinet(String locationOfCabinet) {
		this.locationOfCabinet = locationOfCabinet;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "Shelf [name=" + name + ", equipmentRoomName="
				+ equipmentRoomName + ", cabinetName=" + cabinetName
				+ ", numbering=" + numbering + ", locationOfCabinet="
				+ locationOfCabinet + ", memo=" + memo + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPhysicalLocationInfoId() {
		return physicalLocationInfoId;
	}

	public void setPhysicalLocationInfoId(int physicalLocationInfoId) {
		this.physicalLocationInfoId = physicalLocationInfoId;
	}

}
