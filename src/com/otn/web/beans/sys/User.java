package com.otn.web.beans.sys;

import java.util.Date;

/**
 * 用户信息
 * @author xuquan
 * 2014-8-14
 */
public class User {
	private long userId;
	private long orgId;
	private String loginName;
	private String password;
	private String username;
	private String mobile;
	private String email;
	private Date createTime;
	private Date loginTime;
	private Date lastLoginTime;
	private long count;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getOrgId() {
		return orgId;
	}
	public void setOrgId(long orgId) {
		this.orgId = orgId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "SysUser [userId=" + userId + ", orgId=" + orgId
				+ ", loginName=" + loginName + ", password=" + password
				+ ", username=" + username + ", mobile=" + mobile + ", email="
				+ email + ", createTime=" + createTime + ", loginTime="
				+ loginTime + ", lastLoginTime=" + lastLoginTime + ", count="
				+ count + "]";
	}
}
