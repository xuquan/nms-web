package com.otn.collector.huawei.delivery.beans.ems;

/**
 * EMS对象属性的数据类型中附加字段信息
 * @author xuquan
 * 2014-6-18
 */
public class EmsAdditionalInfo {
	
	private int id;
	
	/**
	 * 网管当前最高告警级别,默认为空
	 */
	private String alarmSeverity;
	
	/**
	 * 网管所属在物理位置
	 */
	private String location;
	
	/**
	 * CORBA Agent的通讯IP和端口信息
	 * 例如：127.0.0.1:12003
	 * 其中127.0.0.1为CORBA Agent通讯IP，
	 * 12003为CORBA Agent通讯端口
	 */
	private String commuAddress;
	
	/**
	 * 网管系统的当前时间
	 * 例如：20071102110027.0Z
	 */
	private String emsTime;
	
	/**
	 * 系统接口版本号
	 * 例如：2.0
	 */
	private String interfaceVersion;
	
	/**
	 * 网管统当前运行状态
	 * 固定填写Normal
	 */
	private String emsState;
	
	/**
	 * 管理状态
	 */
	private String administrativeState;
	
	private String emsNameStr;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAlarmSeverity() {
		return alarmSeverity;
	}

	public void setAlarmSeverity(String alarmSeverity) {
		this.alarmSeverity = alarmSeverity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCommuAddress() {
		return commuAddress;
	}

	public void setCommuAddress(String commuAddress) {
		this.commuAddress = commuAddress;
	}

	public String getEmsTime() {
		return emsTime;
	}

	public void setEmsTime(String emsTime) {
		this.emsTime = emsTime;
	}

	public String getInterfaceVersion() {
		return interfaceVersion;
	}

	public void setInterfaceVersion(String interfaceVersion) {
		this.interfaceVersion = interfaceVersion;
	}

	public String getEmsState() {
		return emsState;
	}

	public void setEmsState(String emsState) {
		this.emsState = emsState;
	}

	public String getAdministrativeState() {
		return administrativeState;
	}

	public void setAdministrativeState(String administrativeState) {
		this.administrativeState = administrativeState;
	}

	@Override
	public String toString() {
		return "EmsAdditionalInfo [id=" + id + ", alarmSeverity="
				+ alarmSeverity + ", location=" + location + ", commuAddress="
				+ commuAddress + ", emsTime=" + emsTime + ", interfaceVersion="
				+ interfaceVersion + ", emsState=" + emsState
				+ ", administrativeState=" + administrativeState
				+ ", emsNameStr=" + emsNameStr + "]";
	}

	public String getEmsNameStr() {
		return emsNameStr;
	}

	public void setEmsNameStr(String emsNameStr) {
		this.emsNameStr = emsNameStr;
	}

}
