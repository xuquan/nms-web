package com.otn.collector.huawei.delivery.beans.equipment;


public class EquipmentOrHolder{
	private int id;
	private String discriminator;
	private Equipment equip;
	private EquipmentHolder holder;
	
	public String getDiscriminator() {
		return discriminator;
	}
	public Equipment getEquip() {
		return equip;
	}
	public EquipmentHolder getHolder() {
		return holder;
	}
	public int getId() {
		return id;
	}
	public void setDiscriminator(String discriminator) {
		this.discriminator = discriminator;
	}
	public void setEquip(Equipment equip) {
		this.equip = equip;
	}
	public void setHolder(EquipmentHolder holder) {
		this.holder = holder;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "EquipmentOrHolder [id=" + id + ", discriminator="
				+ discriminator + ", equip=" + equip + ", holder=" + holder
				+ "]";
	}
}
