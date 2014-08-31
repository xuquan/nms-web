package com.otn.common.beans;
/**
 * 路径封装
 * @author 高彪
 *
 * 2014年5月26日
 */
public class Path {

	/**
	 * 路径ID
	 */
	private int id;
	
	/**
	 * 信号级别
	 */
	private int signalLevel;
	
	/**
	 * 占用状态，高阶占用3，低阶占用1，自身占用2，空闲0
	 */
	private int usage;
	
	/**
	 * 时隙描述字符串
	 */
	private String ts;
	
	/**
	 * 关联的bearerID
	 */
	private int bearer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSignalLevel() {
		return signalLevel;
	}

	public void setSignalLevel(int signalLevel) {
		this.signalLevel = signalLevel;
	}

	public int getUsage() {
		return usage;
	}

	public void setUsage(int usage) {
		this.usage = usage;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public int getBearer() {
		return bearer;
	}

	public void setBearer(int bearer) {
		this.bearer = bearer;
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
		Path other = (Path) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
