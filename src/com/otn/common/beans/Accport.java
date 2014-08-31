package com.otn.common.beans;
/**
 * 客户侧端口
 * @author 高彪
 *
 * 2014年5月26日
 */
public class Accport {

	/**
	 * ID
	 */
	private int id;
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 级别标签
	 */
	private String ts;
	
	/**
	 * 类型
	 */
	private String mode;
	

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
		Accport other = (Accport) obj;
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

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}


}
