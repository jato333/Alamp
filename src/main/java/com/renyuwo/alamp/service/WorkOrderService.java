package com.renyuwo.alamp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renyuwo.alamp.dao.WorkOrderDao;
import com.renyuwo.alamp.entity.WorkOrder;
import com.renyuwo.alamp.entity.WorkOrderWhere;

@Service
public class WorkOrderService {

	@Autowired
	WorkOrderDao workOrderDao;

	public List<WorkOrder> getWorkOrderBy(WorkOrderWhere workOrderWhere, int page, int pagesize) {
		return workOrderDao.selectWorkOrder(workOrderWhere, (page - 1) * pagesize, pagesize);
	}

	public int insertWorkOrder(WorkOrder workOrder) {
		return workOrderDao.insertWorkOrder(workOrder);
	}

	public int updateWorkOrder(WorkOrder workOrder, WorkOrderWhere workOrderWhere) {
		return workOrderDao.updateWorkOrder(workOrder, workOrderWhere);
	}

}
