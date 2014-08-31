package com.otn.web.beans.sys;

/**
 * 数据字典
 * @author xuquan
 * 2014-8-17
 */
public class Dictionary {
	
	private long dictId;
	private String dictCode;
	private String dictName;
	private String description;
	
	public long getDictId() {
		return dictId;
	}
	public void setDictId(long dictId) {
		this.dictId = dictId;
	}
	public String getDictCode() {
		return dictCode;
	}
	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}
	public String getDictName() {
		return dictName;
	}
	public void setDictName(String dictName) {
		this.dictName = dictName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Dictionary [dictId=" + dictId + ", dictCode=" + dictCode
				+ ", dictName=" + dictName + ", description=" + description
				+ "]";
	}
	
}
