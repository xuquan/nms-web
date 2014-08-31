package com.otn.collector.huawei.delivery.beans.ems;

import java.util.Arrays;

import mtnm.tmforum.org.globaldefs.NameAndStringValue_T;

import com.google.gson.Gson;

/**
 * 网元管理系统信息
 * @author xuquan
 * 2014-6-3
 */
public class Ems {
	
	/**
	 * 默认为空,支持通过setUserLabel接口进行设置
	 */
	private String userLabel;
	
	/**
	 * 该字段取值和name中的EMS名称取值是一致的，
	 * 默认值为Huawei/U2000,有多个网管的时候要保持名称唯一
	 * 支持通过网络管理系统维护工具进行设置。
	 */
	private String nativeEMSName;
	
	/**
	 * 默认为空,支持setOwner接口进行设置
	 */
	private String owner;
	
	/**
	 * 网管版本号，如：U2000V100R007C00
	 */
	private String emsVersion;
	
	/**
	 * 对于U2000，默认取值为U2000
	 */
	private String type;
	
	/**
	 * 表示EMS对象名称
	 */
	private NameAndStringValue_T[] name;
	
	/**
	 * 表示EMS对象名称
	 * 使用json格式保存NameAndStringValue[]到数据库
	 */
	private String nameStr="";
	
	/**
	 * 附加信息
	 */
	private EmsAdditionalInfo additionalInfo;
	
	public String getUserLabel() {
		return userLabel;
	}
	public void setUserLabel(String userLabel) {
		this.userLabel = userLabel;
	}
	public String getNativeEMSName() {
		return nativeEMSName;
	}
	public void setNativeEMSName(String nativeEMSName) {
		this.nativeEMSName = nativeEMSName;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getEmsVersion() {
		return emsVersion;
	}
	public void setEmsVersion(String emsVersion) {
		this.emsVersion = emsVersion;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public NameAndStringValue_T[] getName() {
		return name;
	}
	public void setName(NameAndStringValue_T[] name) {
		if(null!=name && name.length>0){
			Gson gson = new Gson();
			nameStr = gson.toJson(name);
		}
		this.name = name;
	}
	
	public String getNameStr() {
		return nameStr;
	}
	public void setNameStr(String nameStr) {
		if(null!=nameStr && !"".equals(nameStr)){
			Gson gson = new Gson();
			name = gson.fromJson(nameStr, NameAndStringValue_T[].class);
		}
		this.nameStr = nameStr;
	}

	public EmsAdditionalInfo getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(EmsAdditionalInfo additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	@Override
	public String toString() {
		return "Ems [userLabel=" + userLabel
				+ ", nativeEMSName=" + nativeEMSName + ", owner=" + owner
				+ ", emsVersion=" + emsVersion + ", type=" + type + ", name="
				+ Arrays.toString(name) + ", nameStr=" + nameStr
				+ ", additionalInfo=" + additionalInfo + "]";
	}
}
