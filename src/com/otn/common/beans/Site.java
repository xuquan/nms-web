package com.otn.common.beans;

/**
 * 站点实体，由网元或者光网元转换来
 * 
 * @author 高彪
 * 
 *         2014年5月26日
 */
public class Site {

	/**
	 * ID
	 */
	private int id;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * X坐标
	 */
	private int posX;
	/**
	 * Y 坐标
	 */
	private int posY;
	/**
	 * 父节点ID
	 */
	private int parentId;

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
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
		Site other = (Site) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Site [id=" + id + ", name=" + name + "]";
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
