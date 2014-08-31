package com.otn.web.beans.sys;

/**
 * 系统属性
 * @author xuquan
 * 2014-8-17
 */
public class Property {
	
	private long propId;
	private String propCode;
	private String propName;
	private String propValue;
	private String description;
	
	public long getPropId() {
		return propId;
	}
	public void setPropId(long propId) {
		this.propId = propId;
	}
	public String getPropCode() {
		return propCode;
	}
	public void setPropCode(String propCode) {
		this.propCode = propCode;
	}
	public String getPropName() {
		return propName;
	}
	public void setPropName(String propName) {
		this.propName = propName;
	}
	public String getPropValue() {
		return propValue;
	}
	public void setPropValue(String propValue) {
		this.propValue = propValue;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Property [propId=" + propId + ", propCode=" + propCode
				+ ", propName=" + propName + ", propValue=" + propValue
				+ ", description=" + description + "]";
	}
}
