package com.otn.web.beans.sys;

import java.util.Date;

/**
 * 组信息
 * @author xuquan
 * 2014-8-14
 */
public class Group {
	private long groupId;
	private long parentGroupId;
	private String groupName;
	private Date createTime;
	private String description;
	
	public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public long getParentGroupId() {
		return parentGroupId;
	}
	public void setParentGroupId(long parentGroupId) {
		this.parentGroupId = parentGroupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
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
		return "SysGroup [groupId=" + groupId + ", parentGroupId="
				+ parentGroupId + ", groupName=" + groupName + ", createTime="
				+ createTime + ", description=" + description + "]";
	}
}
