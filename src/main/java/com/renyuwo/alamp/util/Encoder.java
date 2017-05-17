package com.renyuwo.alamp.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Encoder {
	 /**利用MD5进行加密*/
	 public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
	        //确定计算方法
		 MessageDigest md5=MessageDigest.getInstance("MD5");
	        byte[] input = str.getBytes("utf-8");  
			Base64.Encoder urlEncoder = Base64.getUrlEncoder();
			//加密后的字符串
		    String newstr = urlEncoder.encodeToString(md5.digest(input)); 
		    
	        return newstr;
	    }
}
