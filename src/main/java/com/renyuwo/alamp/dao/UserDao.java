package com.renyuwo.alamp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.renyuwo.alamp.entity.User;
import com.renyuwo.alamp.entity.UserWhere;


@Mapper
public interface UserDao {
public List<User> selectUser(@Param("userWhere") UserWhere userWhere, @Param("startsize") int page,@Param("pagesize") int pagesize);
	
	public int insertUser(@Param("user") User user);
	
	public int updateUser(@Param("user") User User, @Param("userWhere") UserWhere userWhere);
	
	public User getLogin(@Param("userWhere") UserWhere userWhere);
}
