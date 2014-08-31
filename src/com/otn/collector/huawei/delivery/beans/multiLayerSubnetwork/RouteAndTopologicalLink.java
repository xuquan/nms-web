package com.otn.collector.huawei.delivery.beans.multiLayerSubnetwork;

import java.util.Arrays;

import mtnm.tmforum.org.globaldefs.NameAndStringValue_T;

import com.google.gson.Gson;
import com.otn.collector.huawei.delivery.beans.subnetworkConnection.CrossConnect;
import com.otn.collector.huawei.delivery.beans.topologicalLink.TopologicalLink;

/**
 * 路由和拓扑链接的数据类型
 * @author xuquan
 * 2014-6-4
 */
public class RouteAndTopologicalLink {
	
	private int id;
	
	/**
	 * SNC名称
	 */
	private NameAndStringValue_T[] sncName;
	private String sncNameStr;

	/**
	 * SNC的路由信息
	 */
	private CrossConnect[] route;
	

	/**
	 * SNC的拓扑连接信息
	 */
	private TopologicalLink[] topologicalLinkList;

	/**
	 * 附加信息
	 */
	private NameAndStringValue_T[] additionalInfo;
	private String additionalInfoStr;

	public NameAndStringValue_T[] getAdditionalInfo() {
		return additionalInfo;
	}

	public String getAdditionalInfoStr() {
		return additionalInfoStr;
	}

	public int getId() {
		return id;
	}

	public CrossConnect[] getRoute() {
		return route;
	}

	public NameAndStringValue_T[] getSncName() {
		return sncName;
	}

	public String getSncNameStr() {
		return sncNameStr;
	}

	public TopologicalLink[] getTopologicalLinkList() {
		return topologicalLinkList;
	}

	public void setAdditionalInfo(NameAndStringValue_T[] additionalInfo) {
		Gson gson = new Gson();
		additionalInfoStr = gson.toJson(additionalInfo);
		this.additionalInfo = additionalInfo;
	}

	public void setAdditionalInfoStr(String additionalInfoStr) {
		Gson gson = new Gson();
		additionalInfo = gson.fromJson(additionalInfoStr, NameAndStringValue_T[].class);
		this.additionalInfoStr = additionalInfoStr;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setRoute(CrossConnect[] route) {
		this.route = route;
	}

	public void setSncName(NameAndStringValue_T[] sncName) {
		Gson gson = new Gson();
		sncNameStr = gson.toJson(sncName);
		this.sncName = sncName;
	}

	public void setSncNameStr(String sncNameStr) {
		Gson gson = new Gson();
		sncName = gson.fromJson(sncNameStr, NameAndStringValue_T[].class);
		this.sncNameStr = sncNameStr;
	}

	public void setTopologicalLinkList(TopologicalLink[] topologicalLinkList) {
		this.topologicalLinkList = topologicalLinkList;
	}

	@Override
	public String toString() {
		return "RouteAndTopologicalLink [id=" + id + ", sncName="
				+ Arrays.toString(sncName) + ", route="
				+ Arrays.toString(route) + ", topologicalLinkList="
				+ Arrays.toString(topologicalLinkList) + ", additionalInfo="
				+ Arrays.toString(additionalInfo) + "]";
	}

}
