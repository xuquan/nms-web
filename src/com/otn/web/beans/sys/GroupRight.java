package com.otn.web.beans.sys;

/**
 * 组权限信息
 * @author xuquan
 * 2014-8-14
 */
public class GroupRight {
	private long groupRightId;
	private long groupId;
	private long rightId;
	private int rightType;
	
	public long getGroupRightId() {
		return groupRightId;
	}
	public void setGroupRightId(long groupRightId) {
		this.groupRightId = groupRightId;
	}
	public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public long getRightId() {
		return rightId;
	}
	public void setRightId(long rightId) {
		this.rightId = rightId;
	}
	public int getRightType() {
		return rightType;
	}
	public void setRightType(int rightType) {
		this.rightType = rightType;
	}
	@Override
	public String toString() {
		return "SysGroupRightRelation [groupRightId=" + groupRightId
				+ ", groupId=" + groupId + ", rightId=" + rightId
				+ ", rightType=" + rightType + "]";
	}
}
