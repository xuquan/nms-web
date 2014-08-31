package com.otn.collector.huawei.delivery.beans.terminationPoint;

import java.util.Arrays;

import mtnm.tmforum.org.globaldefs.NameAndStringValue_T;

import com.google.gson.Gson;
import com.otn.collector.huawei.delivery.beans.transmissionParameters.LayeredParameters;

/**
 * 终结点数据类型
 * @author xuquan
 * 2014-6-4
 */
public class TerminationPoint {
	
	/**
	 * tp对象名称标识
	 */
	private NameAndStringValue_T[] name;
	private String nameStr;

	/**
	 * 用户标识符
	 */
	private String userLabel = "";

	/**
	 * 本地名称
	 */
	private String nativeEMSName = "";

	/**
	 * 对象所有者名称，默认为空
	 */
	private String owner = "";

	/**
	 * 流入的流量描述符。默认取值为空。
	 * 对于PTN（不包含PTN6900）、RTN、MSTP+ 设备,
	 * 如果流入方向应用了一个策略，则在CTP结构体的当前性中填写该qos策略信息，
	 * 如果应用了多个策略，则在CTP结构体的当前属性中填写一个策略，
	 * 其它的在传输参数IngressTCProfileName（无方向的也填写到这里）属性，
	 * 填写ingressTmdRef以外的Qos策略信息，多个qos策略通过逗号隔开。
	 * 格式：\name=EMS\value=Huawei/U2000\name=TCPROFILE\value=/type=xx/devtype=xx/name=xx
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
	
	/**
	 * tp的类型。
	 * 取值包括：TPT_PTP，表示对象是PTP或FTP；
	 * TPT_CTP，标识对象是CTP。
	 */
	private String type;

	/**
	 * 连接状态
	 * 对PTP对象和反向复用的FTP对象固定为TPCS_NA。
	 * 对于非反向复用的FTP对象和CTP对象，
	 * 取值包括：TPCS_SOURCE_CONNECTED 源连接
	 * TPCS_SINK_CONNECTED 宿连接
	 * TPCS_BI_CONNECTED 双向连接
	 * TPCS_NOT_CONNECTED未连接。
	 */
	private String connectionState;

	/**
	 * tp的映射模式
	 */
	private String tpMappingMode;

	/**
	 * tp的方向。
	 * 取值包括：D_BIDIRECTIONAL（双向）、D_SOURCE（源）、D_SINK（宿）、DIR_NA(未知)
	 */
	private String direction;

	/**
	 * 传输参数
	 */
	private LayeredParameters[] transmissionParams;

	/**
	 * 不支持该属性，固定为TPPA_NA
	 */
	private String tpProtectionAssociation;

	/**
	 * 是否边界点属性标志。
	 * CTP和FTP为false，如果PTP上有光纤为false，其它为true
	 */
	private boolean edgePoint;

	/**
	 * 附加信息
	 */
	private TerminationPointAdditionalInfo additionalInfo;
	
	private String managedElementNameStr;
	
	public String getConnectionState() {
		return connectionState;
	}
	public String getDirection() {
		return direction;
	}
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
	public NameAndStringValue_T[] getName() {
		return name;
	}
	public String getNameStr() {
		return nameStr;
	}
	public String getNativeEMSName() {
		return nativeEMSName;
	}
	public String getOwner() {
		return owner;
	}
	public String getTpMappingMode() {
		return tpMappingMode;
	}
	public String getTpProtectionAssociation() {
		return tpProtectionAssociation;
	}
	public LayeredParameters[] getTransmissionParams() {
		return transmissionParams;
	}
	public String getType() {
		return type;
	}
	public String getUserLabel() {
		return userLabel;
	}
	public boolean isEdgePoint() {
		return edgePoint;
	}
	public void setConnectionState(String connectionState) {
		this.connectionState = connectionState;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public void setEdgePoint(boolean edgePoint) {
		this.edgePoint = edgePoint;
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
	public void setName(NameAndStringValue_T[] name) {
		Gson gson = new Gson();
		nameStr = gson.toJson(name);
		this.name = name;
	}
	public void setNameStr(String nameStr) {
		Gson gson = new Gson();
		name = gson.fromJson(nameStr, NameAndStringValue_T[].class);
		this.nameStr = nameStr;
	}
	public void setNativeEMSName(String nativeEMSName) {
		this.nativeEMSName = nativeEMSName;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public void setTpMappingMode(String tpMappingMode) {
		this.tpMappingMode = tpMappingMode;
	}
	public void setTpProtectionAssociation(String tpProtectionAssociation) {
		this.tpProtectionAssociation = tpProtectionAssociation;
	}
	public void setTransmissionParams(LayeredParameters[] transmissionParams) {
		this.transmissionParams = transmissionParams;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setUserLabel(String userLabel) {
		this.userLabel = userLabel;
	}
	public TerminationPointAdditionalInfo getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(TerminationPointAdditionalInfo additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	@Override
	public String toString() {
		return "TerminationPoint [name=" + Arrays.toString(name)
				+ ", nameStr=" + nameStr + ", userLabel=" + userLabel
				+ ", nativeEMSName=" + nativeEMSName + ", owner=" + owner
				+ ", ingressTrafficDescriptorName="
				+ Arrays.toString(ingressTrafficDescriptorName)
				+ ", ingressTrafficDescriptorNameStr="
				+ ingressTrafficDescriptorNameStr
				+ ", egressTrafficDescriptorName="
				+ Arrays.toString(egressTrafficDescriptorName)
				+ ", egressTrafficDescriptorNameStr="
				+ egressTrafficDescriptorNameStr + ", type=" + type
				+ ", connectionState=" + connectionState + ", tpMappingMode="
				+ tpMappingMode + ", direction=" + direction
				+ ", transmissionParams=" + Arrays.toString(transmissionParams)
				+ ", tpProtectionAssociation=" + tpProtectionAssociation
				+ ", edgePoint=" + edgePoint + ", additionalInfo="
				+ additionalInfo + "]";
	}
	public String getManagedElementNameStr() {
		return managedElementNameStr;
	}
	public void setManagedElementNameStr(String managedElementNameStr) {
		this.managedElementNameStr = managedElementNameStr;
	}

}
