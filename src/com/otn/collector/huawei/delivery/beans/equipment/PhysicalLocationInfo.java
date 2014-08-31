package com.otn.collector.huawei.delivery.beans.equipment;


/**
 * 全网物理位置信息，包含机框、机架、机房的结构描述
 * @author xuquan
 * 2014-6-4
 */
public class PhysicalLocationInfo {
	
	private int id;
	
	private String discriminator;
	
	/**
	 * 机房信息
	 */
	private EquipmentRoom equipmentRoom;
	
	/**
	 * 机架信息
	 */
	private Cabinet cabinet;
	
	/**
	 * 机框信息
	 */
	private Shelf shelf;

	public EquipmentRoom getEquipmentRoom() {
		return equipmentRoom;
	}

	public void setEquipmentRoom(EquipmentRoom equipmentRoom) {
		this.equipmentRoom = equipmentRoom;
	}

	public Cabinet getCabinet() {
		return cabinet;
	}

	public void setCabinet(Cabinet cabinet) {
		this.cabinet = cabinet;
	}

	public Shelf getShelf() {
		return shelf;
	}

	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}

	@Override
	public String toString() {
		return "PhysicalLocationInfo [discriminator=" + discriminator
				+ ", equipmentRoom=" + equipmentRoom + ", cabinet=" + cabinet
				+ ", shelf=" + shelf + "]";
	}

	public String getDiscriminator() {
		return discriminator;
	}

	public void setDiscriminator(String discriminator) {
		this.discriminator = discriminator;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
