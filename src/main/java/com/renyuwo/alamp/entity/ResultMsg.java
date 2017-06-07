package com.renyuwo.alamp.entity;

import javax.xml.bind.annotation.XmlRootElement;

import com.alibaba.fastjson.annotation.JSONField;

@XmlRootElement(name="ResultMsg")
public class ResultMsg {

	@JSONField(ordinal=1)
	private String code;
	
	@JSONField(ordinal=2)
	private String success;
	
	@JSONField(ordinal=3)
	private String transname;
	
	@JSONField(ordinal=4)
	private String message;
	
	@JSONField(ordinal=5)
	private String detail;
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getTransname() {
		return transname;
	}

	public void setTransname(String transname) {
		this.transname = transname;
	}
}
