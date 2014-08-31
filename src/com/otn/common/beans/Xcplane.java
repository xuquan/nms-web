package com.otn.common.beans;
/**
 * 交叉板封装
 * @author 高彪
 *
 * 2014年5月26日
 */
public class Xcplane {

	/**
	 * 波长ID
	 */
	private int id;
	/**
	 * 名称，由其他字段拼装
	 */
	private String name;
	/**
	 * 网元
	 */
	private int ne;
	/**
	 * 子架
	 */
	private int shelf;
	/**
	 * 槽位
	 */
	private int slot;
	/**
	 * 单板类型
	 */
	private int cptype;
	
	
	
	public int getNe() {
		return ne;
	}

	public void setNe(int ne) {
		this.ne = ne;
	}

	public int getShelf() {
		return shelf;
	}

	public void setShelf(int shelf) {
		this.shelf = shelf;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}


	public int getCptype() {
		return cptype;
	}

	public void setCptype(int cptype) {
		this.cptype = cptype;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Xcplane other = (Xcplane) obj;
		if (id != other.id)
			return false;
		return true;
	}

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


}
