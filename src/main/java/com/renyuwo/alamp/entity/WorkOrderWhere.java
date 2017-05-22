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
	private String sname;
	
	/*
	 * 用户邮编
	 */
	private String spostCode;
	
	/*
	 * 用户电话，包括区号、电话号码及分机号，中间用-分隔
	 */
	private String sphone;
	
	/*
	 * 用户移动电话， 手机和电话至少填一项
	 */
	private String smobile;
	
	/*
	 * 用户所在省
	 */
	private String sprov;
	
	/*
	 * 用户所在市县（区）
	 */
	private String scity;
	
	/*
	 * 
	 */
	private String scountry;
	
	/*
	 * 用户详细地址
	 */
	private String saddress;
	
	
	/*
	 * 用户姓名
	 */
	private String rname;
	
	/*
	 * 用户邮编
	 */
	private String rpostCode;
	
	/*
	 * 用户电话，包括区号、电话号码及分机号，中间用-分隔
	 */
	private String rphone;
	
	/*
	 * 用户移动电话， 手机和电话至少填一项
	 */
	private String rmobile;
	
	/*
	 * 用户所在省
	 */
	private String rprov;
	
	/*
	 * 用户所在市县（区）
	 */
	private String rcity;
	
	/*
	 * 
	 */
	private String rcountry;
	
	/*
	 * 用户详细地址
	 */
	private String raddress;
	
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
	private String reciveTime;
	
	/*
	 * 提交时间
	 */
	private String upTime;
	
	private int upStatus;
	
	private String upError;
	
	private String shortAddress;
	
	private String consigneeBranchCode;
	
	private String packageCenterCode;  
	
	private String packageCenterName;
	
	private int printStatus;
	
	private String backTime;
	
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

	
	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSpostCode() {
		return spostCode;
	}

	public void setSpostCode(String spostCode) {
		this.spostCode = spostCode;
	}

	public String getSphone() {
		return sphone;
	}

	public void setSphone(String sphone) {
		this.sphone = sphone;
	}

	public String getSmobile() {
		return smobile;
	}

	public void setSmobile(String smobile) {
		this.smobile = smobile;
	}

	public String getSprov() {
		return sprov;
	}

	public void setSprov(String sprov) {
		this.sprov = sprov;
	}

	public String getScity() {
		return scity;
	}

	public void setScity(String scity) {
		this.scity = scity;
	}

	public String getScountry() {
		return scountry;
	}

	public void setScountry(String scountry) {
		this.scountry = scountry;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRpostCode() {
		return rpostCode;
	}

	public void setRpostCode(String rpostCode) {
		this.rpostCode = rpostCode;
	}

	public String getRphone() {
		return rphone;
	}

	public void setRphone(String rphone) {
		this.rphone = rphone;
	}

	public String getRmobile() {
		return rmobile;
	}

	public void setRmobile(String rmobile) {
		this.rmobile = rmobile;
	}

	public String getRprov() {
		return rprov;
	}

	public void setRprov(String rprov) {
		this.rprov = rprov;
	}

	public String getRcity() {
		return rcity;
	}

	public void setRcity(String rcity) {
		this.rcity = rcity;
	}

	public String getRcountry() {
		return rcountry;
	}

	public void setRcountry(String rcountry) {
		this.rcountry = rcountry;
	}

	public String getRaddress() {
		return raddress;
	}

	public void setRaddress(String raddress) {
		this.raddress = raddress;
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

	public String getReciveTime() {
		return reciveTime;
	}

	public void setReciveTime(String reciveTime) {
		this.reciveTime = reciveTime;
	}

	public String getUpTime() {
		return upTime;
	}

	public void setUpTime(String upTime) {
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

	public String getShortAddress() {
		return shortAddress;
	}

	public void setShortAddress(String shortAddress) {
		this.shortAddress = shortAddress;
	}

	public String getConsigneeBranchCode() {
		return consigneeBranchCode;
	}

	public void setConsigneeBranchCode(String consigneeBranchCode) {
		this.consigneeBranchCode = consigneeBranchCode;
	}

	public String getPackageCenterCode() {
		return packageCenterCode;
	}

	public void setPackageCenterCode(String packageCenterCode) {
		this.packageCenterCode = packageCenterCode;
	}

	public String getPackageCenterName() {
		return packageCenterName;
	}

	public void setPackageCenterName(String packageCenterName) {
		this.packageCenterName = packageCenterName;
	}

	public int getPrintStatus() {
		return printStatus;
	}

	public void setPrintStatus(int printStatus) {
		this.printStatus = printStatus;
	}

	public String getBackTime() {
		return backTime;
	}

	public void setBackTime(String backTime) {
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
