package com.renyuwo.alamp.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="RequestOrder")
public class YtoWorkOrder {

	private String clientID;

	private String logisticProviderID;

	private String customerId;

	private String txLogisticID;

	private String tradeNo;

	private String mailNo;

	private int type;

	private int orderType;

	private int serviceType;

	private int flag;
	
	private sender sender;
	
	private receiver receiver;

	private String sendStartTime;

	private String sendEndTime;

	private double goodsValue;

//	private double totalValue;
	
//	private double agencyFund;
	
//	private double itemsValue;
//
//	private double itemsWeight;

	private items items;

	private int special;

	private String remark;

	private double insuranceValue;

	private double totalServiceFee;

	private double codSplitFee;

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getLogisticProviderID() {
		return logisticProviderID;
	}

	public void setLogisticProviderID(String logisticProviderID) {
		this.logisticProviderID = logisticProviderID;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getTxLogisticID() {
		return txLogisticID;
	}

	public void setTxLogisticID(String txLogisticID) {
		this.txLogisticID = txLogisticID;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getMailNo() {
		return mailNo;
	}

	public void setMailNo(String mailNo) {
		this.mailNo = mailNo;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	public int getServiceType() {
		return serviceType;
	}

	public void setServiceType(int serviceType) {
		this.serviceType = serviceType;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public sender getSender() {
		return sender;
	}

	public void setSender(sender sender) {
		this.sender = sender;
	}

	public receiver getReceiver() {
		return receiver;
	}

	public void setReceiver(receiver receiver) {
		this.receiver = receiver;
	}

	public String getSendStartTime() {
		return sendStartTime;
	}

	public void setSendStartTime(String sendStartTime) {
		this.sendStartTime = sendStartTime;
	}

	public String getSendEndTime() {
		return sendEndTime;
	}

	public void setSendEndTime(String sendEndTime) {
		this.sendEndTime = sendEndTime;
	}

	public double getGoodsValue() {
		return goodsValue;
	}

	public void setGoodsValue(double goodsValue) {
		this.goodsValue = goodsValue;
	}

//	public double getTotalValue() {
//		return totalValue;
//	}
//
//	public void setTotalValue(double totalValue) {
//		this.totalValue = totalValue;
//	}

//	public double getAgencyFund() {
//		return agencyFund;
//	}
//
//	public void setAgencyFund(double agencyFund) {
//		this.agencyFund = agencyFund;
//	}

//	public double getItemsValue() {
//		return itemsValue;
//	}
//
//	public void setItemsValue(double itemsValue) {
//		this.itemsValue = itemsValue;
//	}
//
//	public double getItemsWeight() {
//		return itemsWeight;
//	}
//
//	public void setItemsWeight(double itemsWeight) {
//		this.itemsWeight = itemsWeight;
//	}

	public items getItems() {
		return items;
	}

	public void setItems(items items) {
		this.items = items;
	}

	public int getSpecial() {
		return special;
	}

	public void setSpecial(int special) {
		this.special = special;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public double getInsuranceValue() {
		return insuranceValue;
	}

	public void setInsuranceValue(double insuranceValue) {
		this.insuranceValue = insuranceValue;
	}

	public double getTotalServiceFee() {
		return totalServiceFee;
	}

	public void setTotalServiceFee(double totalServiceFee) {
		this.totalServiceFee = totalServiceFee;
	}

	public double getCodSplitFee() {
		return codSplitFee;
	}

	public void setCodSplitFee(double codSplitFee) {
		this.codSplitFee = codSplitFee;
	}
	
}
