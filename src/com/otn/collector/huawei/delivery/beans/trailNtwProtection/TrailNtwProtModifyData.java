package com.otn.collector.huawei.delivery.beans.trailNtwProtection;

import java.util.Arrays;

import mtnm.tmforum.org.globaldefs.NameAndStringValue_T;

public class TrailNtwProtModifyData{
	private String userLabel = "";
	private boolean forceUniqueness;
	private String nativeEMSName = "";
	private String owner = "";
	private String protectionGroupType;
	private String reversionMode;
	private NameAndStringValue_T[][] pgATPList;
	private NameAndStringValue_T[][] pgZTPList;
	private NameAndStringValue_T[] tnpParameters;
	private String apsFunction = "";
	private String networkAccessDomain = "";
	private NameAndStringValue_T[] additionalInfo;
	
	public String getUserLabel() {
		return userLabel;
	}
	public void setUserLabel(String userLabel) {
		this.userLabel = userLabel;
	}
	public boolean isForceUniqueness() {
		return forceUniqueness;
	}
	public void setForceUniqueness(boolean forceUniqueness) {
		this.forceUniqueness = forceUniqueness;
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
	public String getProtectionGroupType() {
		return protectionGroupType;
	}
	public void setProtectionGroupType(String protectionGroupType) {
		this.protectionGroupType = protectionGroupType;
	}
	public String getReversionMode() {
		return reversionMode;
	}
	public void setReversionMode(String reversionMode) {
		this.reversionMode = reversionMode;
	}
	public String getApsFunction() {
		return apsFunction;
	}
	public void setApsFunction(String apsFunction) {
		this.apsFunction = apsFunction;
	}
	public String getNetworkAccessDomain() {
		return networkAccessDomain;
	}
	public void setNetworkAccessDomain(String networkAccessDomain) {
		this.networkAccessDomain = networkAccessDomain;
	}
	public NameAndStringValue_T[][] getPgATPList() {
		return pgATPList;
	}
	public void setPgATPList(NameAndStringValue_T[][] pgATPList) {
		this.pgATPList = pgATPList;
	}
	public NameAndStringValue_T[][] getPgZTPList() {
		return pgZTPList;
	}
	public void setPgZTPList(NameAndStringValue_T[][] pgZTPList) {
		this.pgZTPList = pgZTPList;
	}
	public NameAndStringValue_T[] getTnpParameters() {
		return tnpParameters;
	}
	public void setTnpParameters(NameAndStringValue_T[] tnpParameters) {
		this.tnpParameters = tnpParameters;
	}
	public NameAndStringValue_T[] getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(NameAndStringValue_T[] additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	@Override
	public String toString() {
		return "TrailNtwProtModifyData [userLabel=" + userLabel
				+ ", forceUniqueness=" + forceUniqueness + ", nativeEMSName="
				+ nativeEMSName + ", owner=" + owner + ", protectionGroupType="
				+ protectionGroupType + ", reversionMode=" + reversionMode
				+ ", pgATPList=" + Arrays.toString(pgATPList) + ", pgZTPList="
				+ Arrays.toString(pgZTPList) + ", tnpParameters="
				+ Arrays.toString(tnpParameters) + ", apsFunction="
				+ apsFunction + ", networkAccessDomain=" + networkAccessDomain
				+ ", additionalInfo=" + Arrays.toString(additionalInfo) + "]";
	}
}
