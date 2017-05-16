package com.renyuwo.alamp.restful;

import java.io.UnsupportedEncodingException;
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

@RestController
public class WorkOrderApi {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	WorkOrderService workOrderService;
	
	@RequestMapping(value = "/getworkorder")
	public String getUser(
			@RequestParam(value = "jsonwhere", required = true) String jsonwhere,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "pagesize", required = false, defaultValue = "10") int pagesize) {
		logger.info("Begin call getworkorder,params:");
		logger.info("jsonwhere:"+jsonwhere);

		WorkOrderWhere workOrderWhere = JSON.parseObject(jsonwhere, WorkOrderWhere.class);
		List<WorkOrder> WorkOrders = workOrderService.getWorkOrderBy(workOrderWhere, page, pagesize);
		return JSONObject.toJSONString(WorkOrders);
	}

	@RequestMapping(value = "/addworkorder")
	public int addUser(@RequestParam(value = "jsonstring", required = true) String jsonstring) throws UnsupportedEncodingException {
		logger.info("Begin call addworkorder,params:");
		logger.info("jsonstring:"+jsonstring);
		
//		jsonstring= URLEncoder.encode(jsonstring, "GBK"); 
		WorkOrder workOrder = JSON.parseObject(jsonstring, WorkOrder.class);
		return workOrderService.insertWorkOrder(workOrder);
	}

	@RequestMapping(value = "/updateworkorder")
	public int updateUser(
			@RequestParam(value = "jsonstring", required = true) String jsonstring,
			@RequestParam(value = "jsonwhere", required = true) String jsonwhere) {
		logger.info("Begin call updateworkorder,params:");
		logger.info("jsonwhere:"+jsonwhere);
		WorkOrder workOrder = JSON.parseObject(jsonstring, WorkOrder.class);
		WorkOrderWhere workOrderWhere = JSON.parseObject(jsonwhere, WorkOrderWhere.class);

		return workOrderService.updateWorkOrder(workOrder, workOrderWhere);
	}
}
