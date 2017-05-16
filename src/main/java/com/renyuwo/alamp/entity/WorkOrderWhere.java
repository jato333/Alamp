package com.renyuwo.alamp.entity;

import java.util.Date;

public class WorkOrderWhere {
private int id;
	
	/*
	 * 公司名称
	 */
	private String companyName;
	
	/*
	 * 商家代码
	 */
	private String clientID;
	
	/*
	 * 物流公司ID
	 */
	private String logisticProviderID;
	
	/*
	 * 商家代码
	 */
	private String customerId;
	
	/*
	 * 物流订单号
	 */
	private String txLogisticID;
	
	/*
	 * 业务交易号
	 */
	private String tradeNo;
	
	/*
	 * 物流运单号
	 */
	private String mailNo;
	
	/*
	 *订单类型
	 */
	private int type;
	
	/*
	 * 订单类型(0-COD,1-普通订单,2-便携式订单3-退货单)
	 */
	private int orderType;
	
	/*
	 * 服务类型
	 */
	private int serviceType;
	
	/*
	 * 订单flag标识，默认为 0，暂无意义
	 */
	private int flag;
	
	/*
	 * 用户姓名
	 */
	private String name;
	
	/*
	 * 用户邮编
	 */
	private String postCode;
	
	/*
	 * 用户电话，包括区号、电话号码及分机号，中间用-分隔
	 */
	private String phone;
	
	/*
	 * 用户移动电话， 手机和电话至少填一项
	 */
	private String mobile;
	
	/*
	 * 用户所在省
	 */
	private String prov;
	
	/*
	 * 用户所在市县（区）
	 */
	private String city;
	
	/*
	 * 
	 */
	private String country;
	
	/*
	 * 用户详细地址
	 */
	private String address;
	
	/*
	 * 物流公司上门取货时间段
	 */
	private String sendStartTime;
	
	/*
	 * 商品金额
	 */
	private String sendEndTime;
	
	/*
	 * 总服务费
	 */
	private double goodsValue;
	
	/*
	 * goodsValue+总服务费
	 */
	private double totalValue;
	
	/*
	 * 代收金额
	 */
	private double agencyFund;
	
	/*
	 * 货物价值
	 */
	private double itemsValue;
	
	/*
	 * 货物总重量
	 */
	private double itemsWeight;
	
	/*
	 * 商品名称
	 */
	private String itemName;
	
	/*
	 * 商品数量
	 */
	private int number;
	
	/*
	 * 商品单价
	 */
	private double itemValue;
	
	/*
	 * 商品类型
	 */
	private int special;
	
	/*
	 * 备注
	 */
	private String remark;
	
	/*
	 * 保值金额
	 */
	private double insuranceValue;
	
	/*
	 * 保值金额=insuranceValue*货品数量(默认为0.0）
	 */
	private double totalServiceFee;
	
	/*
	 * 物流公司分润[COD] （暂时没有使用，默认为0.0）
	 */
	private double codSplitFee;
	
	/*
	 * 接收时间
	 */
	private Date reciveTime;
	
	/*
	 * 提交时间
	 */
	private Date upTime;
	
	private int upStatus;
	
	private String upError;
	
	private Date backTime;
	
	private String backError;
	
	private int backStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getProv() {
		return prov;
	}

	public void setProv(String prov) {
		this.prov = prov;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

	public double getAgencyFund() {
		return agencyFund;
	}

	public void setAgencyFund(double agencyFund) {
		this.agencyFund = agencyFund;
	}

	public double getItemsValue() {
		return itemsValue;
	}

	public void setItemsValue(double itemsValue) {
		this.itemsValue = itemsValue;
	}

	public double getItemsWeight() {
		return itemsWeight;
	}

	public void setItemsWeight(double itemsWeight) {
		this.itemsWeight = itemsWeight;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getItemValue() {
		return itemValue;
	}

	public void setItemValue(double itemValue) {
		this.itemValue = itemValue;
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

	public Date getReciveTime() {
		return reciveTime;
	}

	public void setReciveTime(Date reciveTime) {
		this.reciveTime = reciveTime;
	}

	public Date getUpTime() {
		return upTime;
	}

	public void setUpTime(Date upTime) {
		this.upTime = upTime;
	}

	public int getUpStatus() {
		return upStatus;
	}

	public void setUpStatus(int upStatus) {
		this.upStatus = upStatus;
	}

	public String getUpError() {
		return upError;
	}

	public void setUpError(String upError) {
		this.upError = upError;
	}

	public Date getBackTime() {
		return backTime;
	}

	public void setBackTime(Date backTime) {
		this.backTime = backTime;
	}

	public String getBackError() {
		return backError;
	}

	public void setBackError(String backError) {
		this.backError = backError;
	}

	public int getBackStatus() {
		return backStatus;
	}

	public void setBackStatus(int backStatus) {
		this.backStatus = backStatus;
	}
	
	
	
}
