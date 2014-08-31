package com.otn.web.beans.sys;

/**
 * 数据字典条目
 * @author xuquan
 * 2014-8-17
 */
public class DictionaryItem {
	
	private long dictItemId;
	private long dictId;
	private String dictItemName;
	private String dictItemValue;
	private int order;
	private String description;
	public long getDictItemId() {
		return dictItemId;
	}
	public void setDictItemId(long dictItemId) {
		this.dictItemId = dictItemId;
	}
	public long getDictId() {
		return dictId;
	}
	public void setDictId(long dictId) {
		this.dictId = dictId;
	}
	public String getDictItemName() {
		return dictItemName;
	}
	public void setDictItemName(String dictItemName) {
		this.dictItemName = dictItemName;
	}
	public String getDictItemValue() {
		return dictItemValue;
	}
	public void setDictItemValue(String dictItemValue) {
		this.dictItemValue = dictItemValue;
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
		return "DictionaryItem [dictItemId=" + dictItemId + ", dictId="
				+ dictId + ", dictItemName=" + dictItemName
				+ ", dictItemValue=" + dictItemValue + ", order=" + order
				+ ", description=" + description + "]";
	}
}
