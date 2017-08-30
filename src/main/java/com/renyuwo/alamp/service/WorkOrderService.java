package com.renyuwo.alamp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renyuwo.alamp.dao.WorkOrderDao;
import com.renyuwo.alamp.entity.UpdateWorkOrderStatus;
import com.renyuwo.alamp.entity.WorkOrder;
import com.renyuwo.alamp.entity.WorkOrderWhere;

@Service
public class WorkOrderService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	WorkOrderDao workOrderDao;

	public List<WorkOrder> selectWorkOrderForUp(int upStatus, int page, int pagesize) {
		return workOrderDao.selectWorkOrderForUp(upStatus, (page - 1) * pagesize, pagesize);
	}
	
	public List<WorkOrder> selectWorkOrderByCustCode(String custCode) {
		System.out.println("custCode:"+custCode);
		return workOrderDao.selectWorkOrderByCustCode(custCode);
	}
	
	public List<WorkOrder> getWorkOrderBy(WorkOrderWhere workOrderWhere, int page, int pagesize) {
		return workOrderDao.selectWorkOrder(workOrderWhere, (page - 1) * pagesize, pagesize);
	}

	public int insertWorkOrder(WorkOrder workOrder) {
		return workOrderDao.insertWorkOrder(workOrder);
	}

	public int updateWorkOrder(WorkOrder workOrder, WorkOrderWhere workOrderWhere) {
		return workOrderDao.updateWorkOrder(workOrder, workOrderWhere);
	}

	public int updateWorkOrderByID(UpdateWorkOrderStatus updateWorkOrderStatus) {
		return workOrderDao.updateWorkOrderByID(updateWorkOrderStatus);
	}
}
