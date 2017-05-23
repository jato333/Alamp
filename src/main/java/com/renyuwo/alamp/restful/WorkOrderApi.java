package com.renyuwo.alamp.restful;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.renyuwo.alamp.setting.DataTrans;
import com.renyuwo.alamp.setting.DesSetting;
import com.renyuwo.alamp.util.DES;
import com.renyuwo.alamp.util.Encoder;
import com.renyuwo.alamp.util.HttpRequest;

@RestController
public class WorkOrderApi {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	WorkOrderService workOrderService;

	@RequestMapping(value = "/getworkorder")
	public String getWorkorder(@RequestParam(value = "jsonwhere", required = true) String jsonwhere,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "pagesize", required = false, defaultValue = "10") int pagesize) {

		WorkOrderWhere workOrderWhere = JSON.parseObject(jsonwhere, WorkOrderWhere.class);
		List<WorkOrder> WorkOrders = workOrderService.getWorkOrderBy(workOrderWhere, page, pagesize);
		return JSONObject.toJSONString(WorkOrders);
	}

	@RequestMapping(value = "/addworkorder")
	public String addWorkorder(@RequestParam(value = "jsonstring", required = true) String jsonstring,
			@RequestParam(value = "jsonmd5", required = true) String jsonmd5) throws UnsupportedEncodingException {

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

		String desString = "";

		try {
			desString = DES.encrypt(dejsonstring, DesSetting.DES_KEY);

			desString = Encoder.EncoderByMd5(dejsonstring);
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
		workOrder.setLogisticProviderID("YTO");
		if (workOrderService.insertWorkOrder(workOrder) == 1) {
			ResultMsg resultMsg = new ResultMsg();
			resultMsg.setCode("200");
			resultMsg.setSuccess("Y");
			resultMsg.setMessage("保存成功");
			resultMsg.setDetail("");

			return URLEncoder.encode(JSON.toJSONString(resultMsg), "UTF-8");
		} else {
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

	@RequestMapping(value = "/getworkorderstate")
	public String getWorkorderState(@RequestParam(value = "jsonstring", required = true) String jsonstring,
			@RequestParam(value = "jsonmd5", required = true) String jsonmd5)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {

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

		String desString = "";

		try {
			desString = DES.encrypt(dejsonstring, DesSetting.DES_KEY);

			desString = Encoder.EncoderByMd5(dejsonstring);
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

		
		String decodeString = new StringBuffer(dejsonstring).reverse().toString();
		StringBuilder datastr = new StringBuilder();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String formatTime = dateFormat.format(new Date());

		datastr.append(DataTrans.E_Secret_Key + "app_key" + DataTrans.E_App_Key + "formatXMLmethod" + DataTrans.E_method
				+ "timestamp" + formatTime + "user_id" + DataTrans.E_User_Id + "v1.01");

		StringBuilder md5Str = new StringBuilder();
		md5Str.append(Encoder.string2MD5(datastr.toString()));

		StringBuilder parastr = new StringBuilder();
		parastr.append("<?xml  version=\"1.0\"?><ufinterface><Result><WaybillCode><Number>" + decodeString+ "</Number></WaybillCode></Result></ufinterface>");
		
		StringBuilder postPam = new StringBuilder();
		postPam.append("sign=" + md5Str.toString().toUpperCase() + "&app_key=" + DataTrans.E_App_Key + "&format=XML" + "&method="
				+ DataTrans.E_method + "&timestamp=" + formatTime + "&user_id=" + DataTrans.E_User_Id + "&v=1.01"
				+ "&param=" + parastr.toString());
		StringBuilder responseString = new StringBuilder();

		responseString.append(HttpRequest.sendPost(DataTrans.E_Search_url, postPam.toString()));

		ResultMsg resultMsg = new ResultMsg();
		resultMsg.setCode("200");
		resultMsg.setSuccess("Y");
		resultMsg.setMessage("查询结果");

		resultMsg.setDetail(responseString.toString());
		return URLEncoder.encode(JSON.toJSONString(resultMsg), "UTF-8");
	}
}
