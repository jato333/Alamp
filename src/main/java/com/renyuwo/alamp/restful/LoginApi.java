package com.renyuwo.alamp.restful;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.renyuwo.alamp.entity.User;
import com.renyuwo.alamp.entity.UserWhere;
import com.renyuwo.alamp.service.UserService;


@RestController
public class LoginApi {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/getuser")
	public String getUser(
			@RequestParam(value = "jsonwhere", required = true) String jsonwhere,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "pagesize", required = false, defaultValue = "10") int pagesize) {
		logger.info("Begin call getuser:");
		
		UserWhere user = JSON.parseObject(jsonwhere, UserWhere.class);
		List<User> users = userService.getUserByName(user, page, pagesize);
		return JSONObject.toJSONString(users);
	}

	@RequestMapping(value = "/adduser")
	public int addUser(@RequestParam(value = "jsonstring", required = true) String jsonstring) {
		User user = JSON.parseObject(jsonstring, User.class);
		return userService.insertUser(user);
	}

	@RequestMapping(value = "/updateuser")
	public int updateUser(
			@RequestParam(value = "jsonstring", required = true) String jsonstring,
			@RequestParam(value = "jsonwhere", required = true) String jsonwhere) {
		User user = JSON.parseObject(jsonstring, User.class);
		UserWhere userWhere = JSON.parseObject(jsonwhere, UserWhere.class);

		return userService.updateUser(user, userWhere);
	}

}
