package com.otn.web.beans.sys;

import java.util.Date;

/**
 * 组织信息
 * @author xuquan
 * 2014-8-14
 */
public class Org {
	private long orgId;
	private long parentOrgId;
	private String orgName;
	private Date createTime;
	private String description;
	
	public long getOrgId() {
		return orgId;
	}
	public void setOrgId(long orgId) {
		this.orgId = orgId;
	}
	public long getParentOrgId() {
		return parentOrgId;
	}
	public void setParentOrgId(long parentOrgId) {
		this.parentOrgId = parentOrgId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
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
		return "SysOrg [orgId=" + orgId + ", parentOrgId=" + parentOrgId
				+ ", orgName=" + orgName + ", createTime=" + createTime
				+ ", description=" + description + "]";
	}
}
