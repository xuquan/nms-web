package com.otn.web.beans.sys;

/**
 * 模块信息
 * @author xuquan
 * 2014-8-17
 */
public class Module {
	
	private long moduleId;
	private String moduleName;
	private String moduleUrl;
	private long parentModuleId;
	private int order;
	private String description;
	
	public long getModuleId() {
		return moduleId;
	}
	public void setModuleId(long moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getModuleUrl() {
		return moduleUrl;
	}
	public void setModuleUrl(String moduleUrl) {
		this.moduleUrl = moduleUrl;
	}
	public long getParentModuleId() {
		return parentModuleId;
	}
	public void setParentModuleId(long parentModuleId) {
		this.parentModuleId = parentModuleId;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Module [moduleId=" + moduleId + ", moduleName=" + moduleName
				+ ", moduleUrl=" + moduleUrl + ", parentModuleId="
				+ parentModuleId + ", order=" + order + ", description="
				+ description + "]";
	}
}
