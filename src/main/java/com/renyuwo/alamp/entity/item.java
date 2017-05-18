package com.renyuwo.alamp.entity;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"itemName","number","itemValue"})
public class item {
	private String itemName;

	private int number;

	private double itemValue;

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
	
}
