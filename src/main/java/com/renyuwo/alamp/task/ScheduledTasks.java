package com.renyuwo.alamp.task;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.renyuwo.alamp.entity.Response;
import com.renyuwo.alamp.entity.UpdateWorkOrderStatus;
import com.renyuwo.alamp.entity.WorkOrder;
import com.renyuwo.alamp.entity.WorkOrderWhere;
import com.renyuwo.alamp.entity.YtoWorkOrder;
import com.renyuwo.alamp.entity.item;
import com.renyuwo.alamp.entity.items;
import com.renyuwo.alamp.entity.receiver;
import com.renyuwo.alamp.entity.sender;
import com.renyuwo.alamp.service.WorkOrderService;
import com.renyuwo.alamp.setting.DataTrans;
import com.renyuwo.alamp.util.DataConvert;
import com.renyuwo.alamp.util.Encoder2;
import com.renyuwo.alamp.util.HttpRequest;

@Component
public class ScheduledTasks {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	WorkOrderService workOrderService;
	
	//用于设置任务间隔
	@Scheduled(cron="0/1 * * * * *")
	public void doSomething() throws ParseException, UnsupportedEncodingException, InterruptedException, NoSuchAlgorithmException {
		int page=1;
		int pagesize=5;
		
		WorkOrderWhere workOrderWhere=new WorkOrderWhere();
		workOrderWhere.setUpStatus(0);
		List<WorkOrder> workOrderL=new ArrayList<WorkOrder>();
		
//		logger.info(JSON.toJSONString(workOrderWhere));
		
		try
		{
			workOrderL=workOrderService.selectWorkOrderForUp(0, page, pagesize);
		}catch(Exception e){
			logger.error("获取代处理数据报错了");
		}
		
		if(workOrderL.size()>0){
			logger.info("即将处理"+workOrderL.size()+"条数据");
			
			for (WorkOrder workOrder : workOrderL) {
				
				logger.info("开始处理ID为:"+workOrder.getId()+"的数据..........");
				YtoWorkOrder ytoWorkOrder=new YtoWorkOrder();
				
				ytoWorkOrder.setClientID(DataTrans.E_ClientId);
				ytoWorkOrder.setLogisticProviderID(workOrder.getLogisticProviderID());
				ytoWorkOrder.setCustomerId(DataTrans.E_ClientId);
				ytoWorkOrder.setTxLogisticID(workOrder.getTxLogisticID());
				ytoWorkOrder.setType(1);
				ytoWorkOrder.setOrderType(1);
				ytoWorkOrder.setServiceType(1);
				ytoWorkOrder.setFlag(1);
				ytoWorkOrder.setTradeNo("1");
				Date now = new Date(); 
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				String noewString = dateFormat.format( now ); 
				ytoWorkOrder.setSendStartTime(noewString);
				ytoWorkOrder.setSendEndTime(noewString);
				
				sender sender=new sender();
				sender.setName(workOrder.getSname());
				sender.setPostCode(workOrder.getSpostCode());
				sender.setPhone(workOrder.getSphone());
				sender.setMobile(workOrder.getSmobile());
				sender.setProv(workOrder.getSprov());
				sender.setCity(workOrder.getScity()+","+workOrder.getScountry());
				sender.setAddress(workOrder.getSaddress());	
				
				ytoWorkOrder.setSender(sender);
				
				receiver receiver=new receiver();
				receiver.setName(workOrder.getRname());
				receiver.setPostCode(workOrder.getRpostCode());
				receiver.setPhone(workOrder.getRphone());
				receiver.setMobile(workOrder.getRmobile());
				receiver.setProv(workOrder.getRprov());
				receiver.setCity(workOrder.getRcity()+","+workOrder.getRcountry());
				receiver.setAddress(workOrder.getRaddress());
				
				ytoWorkOrder.setReceiver(receiver);
				
				List<item> itemL=new ArrayList<item>();
				
				item item=new item();
				item.setItemName(workOrder.getItemName());
				item.setNumber(workOrder.getNumber());
				item.setItemValue(workOrder.getItemsValue());
				itemL.add(item);
				
				items items=new items();
				items.setItem(itemL);
				
				ytoWorkOrder.setItems(items);
				
				ytoWorkOrder.setSpecial(1);
				ytoWorkOrder.setRemark(workOrder.getRemark());
				
				StringBuilder datastr =new StringBuilder();
				try {
					datastr.append(DataConvert.beanToXml(ytoWorkOrder, YtoWorkOrder.class).toString());
				} catch (JAXBException e) {
					e.printStackTrace();
				}
				
				StringBuilder data_digest= new StringBuilder();
				data_digest.append(datastr.toString() + DataTrans.E_PartnerID);
				
				StringBuilder md5Str=new StringBuilder();
				md5Str.append(Encoder2.EncoderByMd5(data_digest.toString()));

				StringBuilder newmd5Str =new StringBuilder();
				
				newmd5Str.append(URLEncoder.encode(md5Str.toString(),"utf-8"));
				
				StringBuilder postPam=new StringBuilder();
				
				postPam.append("logistics_interface="
						+URLEncoder.encode(datastr.toString(),"utf-8")
						+"&data_digest="
						+URLEncoder.encode(newmd5Str.toString(),"utf-8")
						+"&type=offline&clientId="+DataTrans.E_ClientId);
				
				StringBuilder responseString=new StringBuilder();
				
				logger.info("报文内容："+postPam.toString());
				
				responseString.append(HttpRequest.sendPost(DataTrans.E_URL,postPam.toString()));
				
				
				logger.info("返回结果："+responseString);
				Response response=null;
				try {
					response=DataConvert.xmlToBean(responseString.toString(), Response.class);
					
					if(response.getCode().equals("200") && response.getSuccess().toLowerCase().equals("true")){
						UpdateWorkOrderStatus updateWorkOrderStatus=new UpdateWorkOrderStatus();
						updateWorkOrderStatus.setId(workOrder.getId());
						updateWorkOrderStatus.setMailNo(response.getMailNo());
						updateWorkOrderStatus.setPackageCenterCode(response.getDistributeInfo().getPackageCenterCode());
						updateWorkOrderStatus.setConsigneeBranchCode(response.getDistributeInfo().getConsigneeBranchCode());
						updateWorkOrderStatus.setPackageCenterName(response.getDistributeInfo().getPackageCenterName());
						updateWorkOrderStatus.setShortAddress(response.getDistributeInfo().getShortAddress());
						updateWorkOrderStatus.setUpStatus(1);
						Date now1 = new Date(); 
						SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
						updateWorkOrderStatus.setUpTime(dateFormat.format( now1 ));
						if(workOrderService.updateWorkOrderByID(updateWorkOrderStatus)>0)
						{
							logger.info(workOrder.getId()+"更新成功过！");
						}else{
							logger.error(workOrder.getId()+"更新成失败！");
						}
					}else{
						UpdateWorkOrderStatus updateWorkOrderStatus=new UpdateWorkOrderStatus();
						updateWorkOrderStatus.setId(workOrder.getId());
						updateWorkOrderStatus.setMailNo(response.getMailNo());
						updateWorkOrderStatus.setPackageCenterCode(response.getDistributeInfo().getPackageCenterCode());
						updateWorkOrderStatus.setConsigneeBranchCode(response.getDistributeInfo().getConsigneeBranchCode());
						updateWorkOrderStatus.setPackageCenterName(response.getDistributeInfo().getPackageCenterName());
						updateWorkOrderStatus.setShortAddress(response.getDistributeInfo().getShortAddress());
						updateWorkOrderStatus.setUpStatus(1);
						Date now1 = new Date(); 
						SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
						updateWorkOrderStatus.setUpTime(dateFormat.format( now1 ));
						if(workOrderService.updateWorkOrderByID(updateWorkOrderStatus)>0)
						{
							logger.info(workOrder.getId()+"更新成功过！");
						}else{
							logger.error(workOrder.getId()+"更新成失败！");
						}
					}
				} catch (JAXBException e) {
					
					logger.error(workOrder.getId()+"上传失败！");
				}
				
				Thread.sleep(100);
			}
		}else{
			logger.info("无待要处理的数据");
		}
    }
	
	
}
