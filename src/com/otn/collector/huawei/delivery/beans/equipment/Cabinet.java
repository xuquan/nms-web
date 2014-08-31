package com.otn.collector.huawei.delivery.beans.equipment;

/**
 * 机架信息
 * 
 * @author xuquan 2014-6-4
 */
public class Cabinet {

	/**
	 * ID
	 */
	private int id;

	/**
	 * 机架名称
	 */
	private String name = "";

	/**
	 * 机柜所在的机房的名称
	 */
	private String equipmentRoomName = "";

	/**
	 * 机柜所包含的子架名称列表
	 */
	private String containedShelfList = "";

	/**
	 * 机架类型
	 */
	private String type = "";

	/**
	 * 高度 1-3000的整数
	 */
	private short height;

	/**
	 * 宽度 1-1000的整数
	 */
	private short width;

	/**
	 * 深度 1-1000的整数
	 */
	private short depth;

	/**
	 * 电压值 约定“-65535”表示无效值
	 */
	private int voltage;

	/**
	 * 电源盒类型
	 */
	private String powerBoxType = "";

	/**
	 * 备注
	 */
	private String memo = "";
	
	private int physicalLocationInfoId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getContainedShelfList() {
		return containedShelfList;
	}

	public void setContainedShelfList(String containedShelfList) {
		this.containedShelfList = containedShelfList;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public short getHeight() {
		return height;
	}

	public void setHeight(short height) {
		this.height = height;
	}

	public short getWidth() {
		return width;
	}

	public void setWidth(short width) {
		this.width = width;
	}

	public short getDepth() {
		return depth;
	}

	public void setDepth(short depth) {
		this.depth = depth;
	}

	public int getVoltage() {
		return voltage;
	}

	public void setVoltage(int voltage) {
		this.voltage = voltage;
	}

	public String getPowerBoxType() {
		return powerBoxType;
	}

	public void setPowerBoxType(String powerBoxType) {
		this.powerBoxType = powerBoxType;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "Cabinet [name=" + name + ", equipmentRoomName="
				+ equipmentRoomName + ", containedShelfList="
				+ containedShelfList + ", type=" + type + ", height=" + height
				+ ", width=" + width + ", depth=" + depth + ", voltage="
				+ voltage + ", powerBoxType=" + powerBoxType + ", memo=" + memo
				+ "]";
	}

	public int getPhysicalLocationInfoId() {
		return physicalLocationInfoId;
	}

	public void setPhysicalLocationInfoId(int physicalLocationInfoId) {
		this.physicalLocationInfoId = physicalLocationInfoId;
	}

}
