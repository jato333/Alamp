package com.renyuwo.alamp.entity;

public class SearchByCustCode {
	private int type; // 单号性质（物流单号\客户单号）

	private String workCode; // 单号

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getWorkCode() {
		return workCode;
	}

	public void setWorkCode(String workCode) {
		this.workCode = workCode;
	}

}
