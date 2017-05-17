package com.renyuwo.alamp.restful;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.renyuwo.alamp.entity.WorkOrder;
import com.renyuwo.alamp.entity.WorkOrderWhere;
import com.renyuwo.alamp.service.WorkOrderService;
import com.renyuwo.alamp.setting.DesSetting;
import com.renyuwo.alamp.util.DES;
import com.renyuwo.alamp.util.Encoder;

@RestController
public class WorkOrderApi {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	WorkOrderService workOrderService;

	@RequestMapping(value = "/getworkorder")
	public String getWorkorder(@RequestParam(value = "jsonwhere", required = true) String jsonwhere,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "pagesize", required = false, defaultValue = "10") int pagesize) {

		logger.info("Begin call getworkorder,params:");
		logger.info("jsonwhere:" + jsonwhere);

		WorkOrderWhere workOrderWhere = JSON.parseObject(jsonwhere, WorkOrderWhere.class);
		List<WorkOrder> WorkOrders = workOrderService.getWorkOrderBy(workOrderWhere, page, pagesize);
		return JSONObject.toJSONString(WorkOrders);
	}

	@RequestMapping(value = "/addworkorder")
	public int addWorkorder(@RequestParam(value = "jsonstring", required = true) String jsonstring,
			@RequestParam(value = "jsonmd5", required = true) String jsonmd5) throws UnsupportedEncodingException {

		logger.info("Begin call addworkorder,params:");
		logger.info("jsonstring:" + jsonstring);
		logger.info("jsonmd5:" + jsonmd5);

		//url解码
		Base64.Decoder urlDecoder = Base64.getUrlDecoder();
		byte[] urlOutput = urlDecoder.decode(jsonstring);
		String afterString = new String(urlOutput, "UTF-8");
		logger.info("afterString:" + afterString);
		
		//DES解密
		String dejsonstring = "";
		try {
			dejsonstring=DES.decrypt(afterString, DesSetting.DES_KEY);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("dejsonstring:" + dejsonstring);
		
		String desString="";
		
		try {
			desString=DES.encrypt(dejsonstring, DesSetting.DES_KEY);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Base64.Encoder urlEncoder = Base64.getUrlEncoder(); 
		try {
			desString = urlEncoder.encodeToString(Encoder.EncoderByMd5(dejsonstring).getBytes("utf-8"));
			logger.info("dejsonstring2:" + desString);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}  
		
		if(desString.equals(jsonmd5))
		{
			logger.info("true");
		}
		
		//保存数据
		afterString=new StringBuffer(dejsonstring).reverse().toString();
		
		WorkOrder workOrder = JSON.parseObject(afterString, WorkOrder.class);
		return workOrderService.insertWorkOrder(workOrder);
	}

	@RequestMapping(value = "/updateworkorder")
	public int updateWorkorder(@RequestParam(value = "jsonstring", required = true) String jsonstring,
			@RequestParam(value = "jsonwhere", required = true) String jsonwhere) {
		logger.info("Begin call updateworkorder,params:");
		logger.info("jsonwhere:" + jsonwhere);
		WorkOrder workOrder = JSON.parseObject(jsonstring, WorkOrder.class);
		WorkOrderWhere workOrderWhere = JSON.parseObject(jsonwhere, WorkOrderWhere.class);

		return workOrderService.updateWorkOrder(workOrder, workOrderWhere);
	}
}
