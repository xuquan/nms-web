package com.otn.collector.huawei.delivery.beans.topologicalLink;

/**
 * 拓扑链路数据类型中附加字段信息
 * @author xuquan
 * 2014-6-18
 */
public class TopologicalLinkAdditionalInfo {
	private int id;
	private String memo;
	private String linkType;
	private String topologicalLinkNameStr;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getLinkType() {
		return linkType;
	}
	public void setLinkType(String linkType) {
		this.linkType = linkType;
	}
	@Override
	public String toString() {
		return "TopologicalLinkAdditionalInfo [id=" + id + ", memo=" + memo
				+ ", linkType=" + linkType + "]";
	}
	public String getTopologicalLinkNameStr() {
		return topologicalLinkNameStr;
	}
	public void setTopologicalLinkNameStr(String topologicalLinkNameStr) {
		this.topologicalLinkNameStr = topologicalLinkNameStr;
	}
}
