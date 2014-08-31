package com.otn.common.beans;
/**
 * 交叉物理存量封装
 * @author 高彪
 *
 * 2014年5月26日
 */
public class XcPhy {

	/**
	 * 波长ID
	 */
	private int id;
	
	/**
	 * 映射到源
	 */
	private int srcNe;
	/**
	 * 映射到源
	 */
	private int srcShelf;
	/**
	 * 映射到源
	 */
	private int srcSlot;
	/**
	 * 映射到源
	 */
	private int srcPort;
	/**
	 * 映射到源
	 */
	private int srcSignalLevel;
	/**
	 * 源时隙
	 */
	private String srcts;
	/**
	 * 映射到源
	 */
	private int snkNe;
	/**
	 * 映射到源
	 */
	private int snkShelf;
	/**
	 * 映射到源
	 */
	private int snkSlot;
	/**
	 * 映射到源
	 */
	private int snkPort;
	/**
	 * 映射到源
	 */
	private int snkSignalLevel;
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
		XcPhy other = (XcPhy) obj;
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


	public String getSrcts() {
		return srcts;
	}

	public void setSrcts(String srcts) {
		this.srcts = srcts;
	}


	public int getSrcNe() {
		return srcNe;
	}

	public void setSrcNe(int srcNe) {
		this.srcNe = srcNe;
	}

	public int getSrcShelf() {
		return srcShelf;
	}

	public void setSrcShelf(int srcShelf) {
		this.srcShelf = srcShelf;
	}

	public int getSrcSlot() {
		return srcSlot;
	}

	public void setSrcSlot(int srcSlot) {
		this.srcSlot = srcSlot;
	}

	public int getSrcPort() {
		return srcPort;
	}

	public void setSrcPort(int srcPort) {
		this.srcPort = srcPort;
	}

	public int getSrcSignalLevel() {
		return srcSignalLevel;
	}

	public void setSrcSignalLevel(int srcSignalLevel) {
		this.srcSignalLevel = srcSignalLevel;
	}

	public int getSnkNe() {
		return snkNe;
	}

	public void setSnkNe(int snkNe) {
		this.snkNe = snkNe;
	}

	public int getSnkShelf() {
		return snkShelf;
	}

	public void setSnkShelf(int snkShelf) {
		this.snkShelf = snkShelf;
	}

	public int getSnkSlot() {
		return snkSlot;
	}

	public void setSnkSlot(int snkSlot) {
		this.snkSlot = snkSlot;
	}

	public int getSnkPort() {
		return snkPort;
	}

	public void setSnkPort(int snkPort) {
		this.snkPort = snkPort;
	}

	public int getSnkSignalLevel() {
		return snkSignalLevel;
	}

	public void setSnkSignalLevel(int snkSignalLevel) {
		this.snkSignalLevel = snkSignalLevel;
	}

	public String getSnkts() {
		return snkts;
	}

	public void setSnkts(String snkts) {
		this.snkts = snkts;
	}



}
