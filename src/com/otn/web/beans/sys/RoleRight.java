package com.otn.web.beans.sys;

/**
 * 角色权限信息
 * @author xuquan
 * 2014-8-14
 */
public class RoleRight {
	private long roleRightId;
	private long roleId;
	private long rightId;
	private int rightType;
	
	public long getRoleRightId() {
		return roleRightId;
	}
	public void setRoleRightId(long roleRightId) {
		this.roleRightId = roleRightId;
	}
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
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
		return "SysRoleRightRelation [roleRightId=" + roleRightId + ", roleId="
				+ roleId + ", rightId=" + rightId + ", rightType=" + rightType
				+ "]";
	}
}
