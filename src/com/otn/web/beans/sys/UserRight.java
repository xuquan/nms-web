package com.otn.web.beans.sys;

/**
 * 用户权限信息
 * @author xuquan
 * 2014-8-14
 */
public class UserRight {
	private long userRightId;
	private long userId;
	private long rightId;
	private int rightType;
	
	public long getUserRightId() {
		return userRightId;
	}
	public void setUserRightId(long userRightId) {
		this.userRightId = userRightId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
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
		return "SysUserRightRelation [userRightId=" + userRightId + ", userId="
				+ userId + ", rightId=" + rightId + ", rightType=" + rightType
				+ "]";
	}
}
