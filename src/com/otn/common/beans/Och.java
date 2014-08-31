package com.otn.common.beans;
/**
 * 波长实体
 * @author 高彪
 *
 * 2014年5月26日
 */
public class Och {

	/**
	 * 波长ID
	 */
	private int id;
	
	/**
	 * 波长名
	 */
	private String name;
	
	/**
	 * 波长序号（1~80波）
	 */
	private int wavelength;
	
	/**
	 * 原端口封装
	 */
	private int srcNode;
	
	/**
	 * 宿端口封装
	 */
	private int snkNode;
	
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
		Och other = (Och) obj;
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

	public int getWavelength() {
		return wavelength;
	}

	public void setWavelength(int wavelength) {
		this.wavelength = wavelength;
	}

	public int getSrcNode() {
		return srcNode;
	}

	public void setSrcNode(int srcNode) {
		this.srcNode = srcNode;
	}

	public int getSnkNode() {
		return snkNode;
	}

	public void setSnkNode(int snkNode) {
		this.snkNode = snkNode;
	}
}
