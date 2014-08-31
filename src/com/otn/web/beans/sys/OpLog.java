package com.otn.web.beans.sys;

import java.util.Date;

/**
 * 操作日志信息
 * @author xuquan
 * 2014-8-14
 */
public class OpLog {
	private long logId;
	private int opType;
	private String opContent;
	private long userId;
	private Date opTime;
	
	public long getLogId() {
		return logId;
	}
	public void setLogId(long logId) {
		this.logId = logId;
	}
	public int getOpType() {
		return opType;
	}
	public void setOpType(int opType) {
		this.opType = opType;
	}
	public String getOpContent() {
		return opContent;
	}
	public void setOpContent(String opContent) {
		this.opContent = opContent;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public Date getOpTime() {
		return opTime;
	}
	public void setOpTime(Date opTime) {
		this.opTime = opTime;
	}
	@Override
	public String toString() {
		return "SysOpLog [logId=" + logId + ", opType=" + opType
				+ ", opContent=" + opContent + ", userId=" + userId
				+ ", opTime=" + opTime + "]";
	}
}
