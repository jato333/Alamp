package com.renyuwo.alamp.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Response")
public class Response {
	
	private String txLogisticID;
	
	private String logisticProviderID;
	
	private String code;
	
	private String success;
	
	private String reason;

	private String mailNo;
		
	private distributeInfo distributeInfo;
	
	public String getTxLogisticID() {
		return txLogisticID;
	}
	public void setTxLogisticID(String txLogisticID) {
		this.txLogisticID = txLogisticID;
	}
	public String getLogisticProviderID() {
		return logisticProviderID;
	}
	public void setLogisticProviderID(String logisticProviderID) {
		this.logisticProviderID = logisticProviderID;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String isSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getMailNo() {
		return mailNo;
	}
	public void setMailNo(String mailNo) {
		this.mailNo = mailNo;
	}
	public distributeInfo getDistributeInfo() {
		return distributeInfo;
	}
	public void setDistributeInfo(distributeInfo distributeInfo) {
		this.distributeInfo = distributeInfo;
	}
	public String getSuccess() {
		return success;
	}
}
