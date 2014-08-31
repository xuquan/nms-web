package com.otn.common.beans;
/**
 * 交叉封装
 * @author 高彪
 *
 * 2014年5月26日
 */
public class Xc {

	/**
	 * 波长ID
	 */
	private int id;
	
	/**
	 * 映射到源端点
	 */
	private int srcNode;
	/**
	 * 源时隙
	 */
	private String srcts;
	/**
	 * 映射到源端点
	 */
	private int snkNode;
	/**
	 * 源时隙
	 */
	private String snkts;
	
	
	

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
		Xc other = (Xc) obj;
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

	public int getSrcNode() {
		return srcNode;
	}

	public void setSrcNode(int srcNode) {
		this.srcNode = srcNode;
	}

	public String getSrcts() {
		return srcts;
	}

	public void setSrcts(String srcts) {
		this.srcts = srcts;
	}

	public int getSnkNode() {
		return snkNode;
	}

	public void setSnkNode(int snkNode) {
		this.snkNode = snkNode;
	}

	public String getSnkts() {
		return snkts;
	}

	public void setSnkts(String snkts) {
		this.snkts = snkts;
	}



}
