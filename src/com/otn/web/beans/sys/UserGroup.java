package com.otn.web.beans.sys;

/**
 * 用户组信息
 * @author xuquan
 * 2014-8-14
 */
public class UserGroup {
	private long userGroupId;
	private long userId;
	private long groupId;
	
	public long getUserGroupId() {
		return userGroupId;
	}
	public void setUserGroupId(long userGroupId) {
		this.userGroupId = userGroupId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	@Override
	public String toString() {
		return "SysUserGroupRelation [userGroupId=" + userGroupId + ", userId="
				+ userId + ", groupId=" + groupId + "]";
	}
}
