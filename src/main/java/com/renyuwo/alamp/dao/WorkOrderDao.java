package com.renyuwo.alamp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.renyuwo.alamp.entity.WorkOrder;
import com.renyuwo.alamp.entity.WorkOrderWhere;

@Mapper
public interface WorkOrderDao {

	public List<WorkOrder> selectWorkOrder(@Param("workOrderWhere") WorkOrderWhere workOrderWhere, @Param("startsize") int page,@Param("pagesize") int pagesize);
	
	public int insertWorkOrder(@Param("workOrder") WorkOrder workOrder);
	
	public int updateWorkOrder(@Param("workOrder") WorkOrder workOrder, @Param("workOrderWhere") WorkOrderWhere workOrderWhere);

}
