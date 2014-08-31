package com.otn.collector.huawei.delivery.beans.equipment;

/**
 * 机房信息
 * @author xuquan
 * 2014-6-4
 */
public class EquipmentRoom {
	
	private int id;
	
	/**
	 * 机房名称
	 */
	private String name;
	
	/**
	 * 机房所包含的机柜名称
	 */
	private String containedCabinet;
	
	/**
	 * 机房所属的网管名称
	 */
	private String containedNMManager;
	
	/**
	 * 国家
	 */
	private String country;
	
	/**
	 * 省
	 */
	private String province;
	
	/**
	 * 市
	 */
	private String city;
	
	/**
	 * 站点名称
	 */
	private String site;
	
	/**
	 * 位置
	 */
	private String location;
	
	/**
	 * 电缆排布方式
	 */
	private String cableArrange;
	
	/**
	 * 是否有防静电地板
	 */
	private String defendStaticFloor;
	
	/**
	 * 防静电地板高度
	 */
	private short floorHeight;
	
	/**
	 * 备注
	 */
	private String memo;
	
	private int physicalLocationInfoId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContainedCabinet() {
		return containedCabinet;
	}

	public void setContainedCabinet(String containedCabinet) {
		this.containedCabinet = containedCabinet;
	}

	public String getContainedNMManager() {
		return containedNMManager;
	}

	public void setContainedNMManager(String containedNMManager) {
		this.containedNMManager = containedNMManager;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCableArrange() {
		return cableArrange;
	}

	public void setCableArrange(String cableArrange) {
		this.cableArrange = cableArrange;
	}

	public String getDefendStaticFloor() {
		return defendStaticFloor;
	}

	public void setDefendStaticFloor(String defendStaticFloor) {
		this.defendStaticFloor = defendStaticFloor;
	}

	public short getFloorHeight() {
		return floorHeight;
	}

	public void setFloorHeight(short floorHeight) {
		this.floorHeight = floorHeight;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "EquipmentRoom [id=" + id + ", name=" + name
				+ ", containedCabinet=" + containedCabinet
				+ ", containedNMManager=" + containedNMManager + ", country="
				+ country + ", province=" + province + ", city=" + city
				+ ", site=" + site + ", location=" + location
				+ ", cableArrange=" + cableArrange + ", defendStaticFloor="
				+ defendStaticFloor + ", floorHeight=" + floorHeight
				+ ", memo=" + memo + "]";
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
