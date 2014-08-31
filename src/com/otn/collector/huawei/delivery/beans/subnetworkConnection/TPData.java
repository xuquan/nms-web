package com.otn.collector.huawei.delivery.beans.subnetworkConnection;

import java.util.Arrays;

import mtnm.tmforum.org.globaldefs.NameAndStringValue_T;

import com.google.gson.Gson;
import com.otn.collector.huawei.delivery.beans.transmissionParameters.LayeredParameters;

/**
 * 终结点对象属性的数据类型
 * @author xuquan
 * 2014-6-4
 */
public class TPData {
	
	private int id;
	
	/**
	 * 表示tp对象名称
	 */
	private NameAndStringValue_T[] tpName;
	private String tpNameStr;
	
	/**
	 * 映射模式
	 */
	private String tpMappingMode;

	/**
	 * 传输参数（包括TP支持的层速率以及层速率下开销字节和其他的属性）
	 * 目前开销字节包括：(需要使能开销字节才返回)
	 * SPRINGNodeId：结点ID
	 * SignalLabelExpectedRx：应收C2
	 * SignalLabelActualRx：实收C2
	 * SMTrailTraceActualTx：SM 应发TTI
	 * SMTrailTraceExpectedRx：SM 应收TTI
	 * SMTrailTraceActualRx：SM 实收TTI
	 * PMTrailTraceActualTx：PM 应发TTI
	 * PMTrailTraceExpectedRx：PM 应收TTI
	 * PMTrailTraceActualRx:PM实收TTI
	 * TCMLevel<n>TrailTraceMonitorDAPI：设置TCM开销源端，n=1-6，取值为On，Off
	 * TCMLevel<n>TrailTraceMonitorSAPI: 设置TCM开销源端，与TCMLevel<n>TrailTraceMonitorDAPI同时使用
	 * TCMLevel<n>ContraTrailTraceMonitorDAPI ：设置TCM开销宿端，n=1-6，取值为On，Off
	 * TCMLevel<n>ContraTrailTraceMonitorSAPI：设置TCM开销宿端，n=1-6，与TCMLevel<n>ContraTrailTraceMonitorDAPI同时使用
	 * TCMLevel<n>TrailTraceActualTx：TCMn应发TTI，n=1-6
	 * TCMLevel<n>TrailTraceExpectedRx：TCMn应收TTI，n=1-6
	 * TCMLevel<n>TrailTraceActualRx：TCMn实收TTI，n=1-6
	 */
	private LayeredParameters[] transmissionParams;

	/**
	 * 默认为空
	 * 查询场景：对于PTN（不包含PTN6900）、RTN、MSTP+ 设备,
	 * 如果流入方向应用了一个策略，则在CTP结构体的当前性中填写该qos策略信息，
	 * 如果应用了多个策略，则在CTP结构体的当前属性中填写一个策略，
	 * 其它的在传输参数IngressTCProfileName（无方向的也填写到这里）属性，填写ingressTmdRef以外的Qos策略信息，
	 * 多个qos策略通过逗号隔开。
	 * 格式：\name=EMS\value=Huawei/U2000\name=TCPROFILE\value=/type=xx/devtype=xx/name=xx
	 * 
	 * 下发场景：通过modifyFlowDomainFragment接口，下发action为modify，
	 * 仅支持某一个方向仅应用一个策略的情况，如果一个方向应用多个，则不支持。
	 * 如果希望去应用Ingress策略，则ingressTrafficDescriptorName格式如下：EMS Huawei/U2000 TCPROFILE
	 */
	private NameAndStringValue_T[] ingressTrafficDescriptorName;
	private String ingressTrafficDescriptorNameStr;

	/**
	 * 流出的流量描述符。默认取值为空。
	 * 如果流出方向仅应用了一个策略，则在当前属性中填写该qos策略信息，
	 * 如果应用了多个策略，则在CTP结构体的当前属性中填写一个策略，
	 * 其它的在传输参数和EgressTCProfileName（无方向的也填写到这里）属性，
	 * 填写egressTmdRef以外的Qos策略信息，多个qos策略通过逗号隔开。
	 * 格式：\name=EMS\value=Huawei/U2000\name=TCPROFILE\value=/type=xx/devtype=xx/name=xx
	 */
	private NameAndStringValue_T[] egressTrafficDescriptorName;
	private String egressTrafficDescriptorNameStr;
	
	private String aEndSncNameStr;
	
	private String zEndSncNameStr;

	public NameAndStringValue_T[] getEgressTrafficDescriptorName() {
		return egressTrafficDescriptorName;
	}

	public String getEgressTrafficDescriptorNameStr() {
		return egressTrafficDescriptorNameStr;
	}

	public NameAndStringValue_T[] getIngressTrafficDescriptorName() {
		return ingressTrafficDescriptorName;
	}

	public String getIngressTrafficDescriptorNameStr() {
		return ingressTrafficDescriptorNameStr;
	}

	public String getTpMappingMode() {
		return tpMappingMode;
	}

	public NameAndStringValue_T[] getTpName() {
		return tpName;
	}

	public String getTpNameStr() {
		return tpNameStr;
	}

	public LayeredParameters[] getTransmissionParams() {
		return transmissionParams;
	}

	public void setEgressTrafficDescriptorName(
			NameAndStringValue_T[] egressTrafficDescriptorName) {
		Gson gson = new Gson();
		egressTrafficDescriptorNameStr = gson.toJson(egressTrafficDescriptorName);
		this.egressTrafficDescriptorName = egressTrafficDescriptorName;
	}

	public void setEgressTrafficDescriptorNameStr(
			String egressTrafficDescriptorNameStr) {
		Gson gson = new Gson();
		egressTrafficDescriptorName = gson.fromJson(egressTrafficDescriptorNameStr, NameAndStringValue_T[].class);
		this.egressTrafficDescriptorNameStr = egressTrafficDescriptorNameStr;
	}

	public void setIngressTrafficDescriptorName(
			NameAndStringValue_T[] ingressTrafficDescriptorName) {
		Gson gson = new Gson();
		ingressTrafficDescriptorNameStr = gson.toJson(ingressTrafficDescriptorName);
		this.ingressTrafficDescriptorName = ingressTrafficDescriptorName;
	}

	public void setIngressTrafficDescriptorNameStr(
			String ingressTrafficDescriptorNameStr) {
		Gson gson = new Gson();
		ingressTrafficDescriptorName = gson.fromJson(ingressTrafficDescriptorNameStr, NameAndStringValue_T[].class);
		this.ingressTrafficDescriptorNameStr = ingressTrafficDescriptorNameStr;
	}

	public void setTpMappingMode(String tpMappingMode) {
		this.tpMappingMode = tpMappingMode;
	}

	public void setTpName(NameAndStringValue_T[] tpName) {
		Gson gson = new Gson();
		tpNameStr = gson.toJson(tpName);
		this.tpName = tpName;
	}

	public void setTpNameStr(String tpNameStr) {
		Gson gson = new Gson();
		tpName = gson.fromJson(tpNameStr, NameAndStringValue_T[].class);
		this.tpNameStr = tpNameStr;
	}

	public void setTransmissionParams(LayeredParameters[] transmissionParams) {
		this.transmissionParams = transmissionParams;
	}

	@Override
	public String toString() {
		return "TPData [tpName=" + Arrays.toString(tpName)
				+ ", tpMappingMode=" + tpMappingMode + ", transmissionParams="
				+ Arrays.toString(transmissionParams)
				+ ", ingressTrafficDescriptorName="
				+ Arrays.toString(ingressTrafficDescriptorName)
				+ ", egressTrafficDescriptorName="
				+ Arrays.toString(egressTrafficDescriptorName) + "]";
	}

	public String getaEndSncNameStr() {
		return aEndSncNameStr;
	}

	public void setaEndSncNameStr(String aEndSncNameStr) {
		this.aEndSncNameStr = aEndSncNameStr;
	}

	public String getzEndSncNameStr() {
		return zEndSncNameStr;
	}

	public void setzEndSncNameStr(String zEndSncNameStr) {
		this.zEndSncNameStr = zEndSncNameStr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
