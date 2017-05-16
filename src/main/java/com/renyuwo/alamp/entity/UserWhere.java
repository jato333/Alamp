package com.renyuwo.alamp.entity;

import java.util.Date;

public class UserWhere {
	private long id;

    private String name;
    
    private String password;
    
    private int age;
    
    private Date createtimeBG;
    
    private Date createtimeED;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getCreatetimeBG() {
		return createtimeBG;
	}

	public void setCreatetimeBG(Date createtimeBG) {
		this.createtimeBG = createtimeBG;
	}

	public Date getCreatetimeED() {
		return createtimeED;
	}

	public void setCreatetimeED(Date createtimeED) {
		this.createtimeED = createtimeED;
	}
    
    
}
