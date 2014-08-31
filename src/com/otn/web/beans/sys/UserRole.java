package com.otn.web.beans.sys;

/**
 * 用户角色信息
 * @author xuquan
 * 2014-8-14
 */
public class UserRole {
	private long userRoleId;
	private long userId;
	private long roleId;
	
	public long getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(long userRoleId) {
		this.userRoleId = userRoleId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	@Override
	public String toString() {
		return "SysUserRoleRelation [userRoleId=" + userRoleId + ", userId="
				+ userId + ", roleId=" + roleId + "]";
	}
}
