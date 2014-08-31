package com.otn.web.beans.sys;

/**
 * 组角色信息
 * @author xuquan
 * 2014-8-14
 */
public class GroupRole {
	private long groupRoleId;
	private long groupId;
	private long roleId;
	
	public long getGroupRoleId() {
		return groupRoleId;
	}
	public void setGroupRoleId(long groupRoleId) {
		this.groupRoleId = groupRoleId;
	}
	public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	@Override
	public String toString() {
		return "SysGroupRoleRelation [groupRoleId=" + groupRoleId
				+ ", groupId=" + groupId + ", roleId=" + roleId + "]";
	}
}
