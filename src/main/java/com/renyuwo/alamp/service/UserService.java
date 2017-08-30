package com.renyuwo.alamp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renyuwo.alamp.dao.UserDao;
import com.renyuwo.alamp.entity.User;
import com.renyuwo.alamp.entity.UserWhere;



@Service
public class UserService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    private UserDao userDao;

    public List<User> getUserByName(UserWhere user,int page,int pagesize){
        return userDao.selectUser(user,(page-1)*pagesize,pagesize);
    }
    
    public int insertUser(User user){
        return userDao.insertUser(user);
    }
    
    public int updateUser(User user,UserWhere userWhere){
        return userDao.updateUser(user, userWhere);
    }
    
   public User getLogin(UserWhere userWhere){
	   return userDao.getLogin(userWhere);
   }
}
