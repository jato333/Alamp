package com.renyuwo.alamp.restful;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
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
import com.renyuwo.alamp.entity.ResultMsg;
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
	public String addWorkorder(@RequestParam(value = "jsonstring", required = true) String jsonstring,
			@RequestParam(value = "jsonmd5", required = true) String jsonmd5) throws UnsupportedEncodingException {

//		logger.info(jsonstring);
//		logger.info(jsonmd5);
		
		String decodeString = "";
		
		// DES解密
		String dejsonstring = "";
		try {
			dejsonstring = DES.decrypt(jsonstring, DesSetting.DES_KEY);
		} catch (Exception e) {
			ResultMsg resultMsg = new ResultMsg();
			resultMsg.setCode("E02");
			resultMsg.setSuccess("N");
			resultMsg.setMessage("DES解密失败");
			resultMsg.setDetail(e.getMessage());

			return URLEncoder.encode(JSON.toJSONString(resultMsg), "UTF-8");
		}

//		logger.info("dejsonstring:"+dejsonstring);
		
		String desString = "";
		
		try {
			desString = DES.encrypt(dejsonstring, DesSetting.DES_KEY);
			
			desString = Encoder.EncoderByMd5(dejsonstring);
//			logger.info("MD5加密"+desString);
			if (!desString.equals(jsonmd5)) {
				ResultMsg resultMsg = new ResultMsg();
				resultMsg.setCode("E07");
				resultMsg.setSuccess("N");
				resultMsg.setMessage("数字签名不匹配");
				resultMsg.setDetail("数字签名不匹配");

				return URLEncoder.encode(JSON.toJSONString(resultMsg), "UTF-8");
			}
			
		} catch (Exception e) {
			ResultMsg resultMsg = new ResultMsg();
			resultMsg.setCode("E03");
			resultMsg.setSuccess("N");
			resultMsg.setMessage("服务器验证密钥时发生异常");
			resultMsg.setDetail(e.getMessage());

			return URLEncoder.encode(JSON.toJSONString(resultMsg), "UTF-8");
		}

		// 保存数据
		decodeString = new StringBuffer(dejsonstring).reverse().toString();

		WorkOrder workOrder = JSON.parseObject(decodeString, WorkOrder.class);
		
		if(workOrderService.insertWorkOrder(workOrder)==1)
		{
			ResultMsg resultMsg = new ResultMsg();
			resultMsg.setCode("200");
			resultMsg.setSuccess("Y");
			resultMsg.setMessage("保存成功");
			resultMsg.setDetail("");

			return URLEncoder.encode(JSON.toJSONString(resultMsg), "UTF-8");
		}else{
			ResultMsg resultMsg = new ResultMsg();
			resultMsg.setCode("E09");
			resultMsg.setSuccess("N");
			resultMsg.setMessage("数据保存异常");
			resultMsg.setDetail("数据保存异常");

			return URLEncoder.encode(JSON.toJSONString(resultMsg), "UTF-8");
		}
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
