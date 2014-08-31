package com.otn.common.beans;
/**
 * OMS两端端口的封装
 * @author 高彪
 *
 * 2014年5月26日
 */
public class OmsNode {

	/**
	 * 波长ID
	 */
	private int id;
	
	/**
	 * 波长名
	 */
	private String name;
	
	/**
	 * 系统波数，最多容纳OCH的数量
	 */
	private int sysCapacity;
	
	/**
	 * 站点
	 */
	private int site;
	
	/**
	 * 实际封装的OMS端点详情
	 */
	private int portid;
	
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
		OmsNode other = (OmsNode) obj;
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

	public int getSysCapacity() {
		return sysCapacity;
	}

	public void setSysCapacity(int sysCapacity) {
		this.sysCapacity = sysCapacity;
	}

	public int getSite() {
		return site;
	}

	public void setSite(int site) {
		this.site = site;
	}

	public int getPortid() {
		return portid;
	}

	public void setPortid(int portid) {
		this.portid = portid;
	}

}
