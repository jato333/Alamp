package com.renyuwo.alamp.entity;

import java.util.Date;

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
	
//	<Response>
//	<logisticProviderID>YTO</logisticProviderID>
//	<txLogisticID>885030080842650752</txLogisticID>
//	<clientID>K21000119</clientID>
//	<mailNo>800141223448</mailNo>
//	<distributeInfo>
//	<shortAddress>100-100-501</shortAddress>
//	<consigneeBranchCode>100010</consigneeBranchCode>
//	<packageCenterCode>100901</packageCenterCode>
//	<packageCenterName>北京转运中心</packageCenterName>
//	</distributeInfo>
//	<code>200</code>
//	<success>true</success>
//	</Response>
	
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
