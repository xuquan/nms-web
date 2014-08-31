package com.otn.web.beans.sys;

import java.util.Date;

/**
 * 角色信息
 * @author xuquan
 * 2014-8-14
 */
public class Role {
	private long roleId;
	private long parentRoleId;
	private String roleName;
	private Date createTime;
	private String description;
	
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public long getParentRoleId() {
		return parentRoleId;
	}
	public void setParentRoleId(long parentRoleId) {
		this.parentRoleId = parentRoleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "SysRole [roleId=" + roleId + ", parentRoleId=" + parentRoleId
				+ ", roleName=" + roleName + ", createTime=" + createTime
				+ ", description=" + description + "]";
	}
	
}
