package com.otn.common.beans;
/**
 * 波长两端的封装
 * @author 高彪
 *
 * 2014年5月26日
 */
public class OchNode {

	/**
	 * 波长ID
	 */
	private int id;
	
	/**
	 * 波长名
	 */
	private String name;
	
	/**
	 * 所在交叉板（子架）
	 */
	private int xcplane;
	
	/**
	 * 单板类型
	 */
	private int cpType;
	
	/**
	 * 物理存量映射，关联到OchPort
	 */
	private int portId;
	
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
		OchNode other = (OchNode) obj;
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

	public int getXcplane() {
		return xcplane;
	}

	public void setXcplane(int xcplane) {
		this.xcplane = xcplane;
	}

	public int getCpType() {
		return cpType;
	}

	public void setCpType(int cpType) {
		this.cpType = cpType;
	}

	public int getPortId() {
		return portId;
	}

	public void setPortId(int portId) {
		this.portId = portId;
	}

}
