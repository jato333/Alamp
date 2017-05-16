package com.renyuwo.alamp.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class User {
	private long id;

    private String name;
    
    private String password;
    
    private int age;
    
    @JSONField(format= "yyyy-MM-dd HH:mm:ss")
    private Date createtime;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}
