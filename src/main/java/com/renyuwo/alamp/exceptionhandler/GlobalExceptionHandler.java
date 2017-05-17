package com.renyuwo.alamp.exceptionhandler;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.renyuwo.alamp.entity.ResultMsg;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	    @ExceptionHandler(value = Exception.class)
	    @ResponseBody
	    public String defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
	        logger.error("---DefaultException Handler---Host {} invokes url {} ERROR: {}", req.getRemoteHost(), req.getRequestURL(), e.getMessage());
	        
	        ResultMsg resultMsg=new ResultMsg();
	        resultMsg.setCode("E01");
	        resultMsg.setSuccess("N");
	        resultMsg.setMessage("订单报文不合法");
	        resultMsg.setDetail(e.getMessage());
	        
	        return URLEncoder.encode(JSON.toJSONString(resultMsg), "UTF-8"); 
	    }
}
