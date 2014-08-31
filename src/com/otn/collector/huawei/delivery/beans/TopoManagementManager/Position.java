package com.otn.collector.huawei.delivery.beans.TopoManagementManager;

/**
 * 位置信息数据类型
 * @author xuquan
 * 2014-6-4
 */
public class Position {
	
	private int id;
	
	/**
	 * 横坐标
	 */
	private int xPos;

	/**
	 * 纵坐标
	 */
	private int yPos;
	
	private String nodeNameStr;

	public int getId() {
		return id;
	}

	public int getxPos() {
		return xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", xPos=" + xPos + ", yPos=" + yPos + "]";
	}

	public String getNodeNameStr() {
		return nodeNameStr;
	}

	public void setNodeNameStr(String nodeNameStr) {
		this.nodeNameStr = nodeNameStr;
	}

}
