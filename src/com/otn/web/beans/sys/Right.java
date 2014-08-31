package com.otn.web.beans.sys;

import java.util.Date;

/**
 * 权限信息
 * @author xuquan
 * 2014-8-14
 */
public class Right {
	private long rightId;
	private long parentRightId;
	private String rightName;
	private Date createTime;
	private String description;
	public long getRightId() {
		return rightId;
	}
	public void setRightId(long rightId) {
		this.rightId = rightId;
	}
	public long getParentRightId() {
		return parentRightId;
	}
	public void setParentRightId(long parentRightId) {
		this.parentRightId = parentRightId;
	}
	public String getRightName() {
		return rightName;
	}
	public void setRightName(String rightName) {
		this.rightName = rightName;
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
		return "SysRight [rightId=" + rightId + ", parentRightId="
				+ parentRightId + ", rightName=" + rightName + ", createTime="
				+ createTime + ", description=" + description + "]";
	}
}
