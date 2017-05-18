package com.renyuwo.alamp.task;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.renyuwo.alamp.entity.Response;
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
import com.renyuwo.alamp.util.Encoder;
import com.renyuwo.alamp.util.HttpRequest;

@Component
public class ScheduledTasks {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	WorkOrderService workOrderService;
	
	//用于设置任务间隔
	@Scheduled(cron="0/15 * * * * *")
	public void doSomething() throws ParseException, UnsupportedEncodingException {
		int page=1;
		int pagesize=10;
		
		WorkOrderWhere workOrderWhere=new WorkOrderWhere();
		workOrderWhere.setUpStatus(0);
		List<WorkOrder> workOrderL=new ArrayList<WorkOrder>();
		
		logger.info(JSON.toJSONString(workOrderWhere));
		
		try
		{
			workOrderL=workOrderService.selectWorkOrderForUp(0, page, pagesize);
		}catch(Exception e){
			logger.error("报错了");
		}
		
		if(workOrderL.size()>0){
			logger.info("即将处理"+workOrderL.size()+"条数据");
			
			for (WorkOrder workOrder : workOrderL) {
				YtoWorkOrder ytoWorkOrder=new YtoWorkOrder();
				
				ytoWorkOrder.setClientID(DataTrans.E_ClientId);
				ytoWorkOrder.setLogisticProviderID("YTO");
				ytoWorkOrder.setCustomerId(DataTrans.E_ClientId);
				ytoWorkOrder.setTxLogisticID(workOrder.getTxLogisticID());
				ytoWorkOrder.setType(workOrder.getType());
				ytoWorkOrder.setOrderType(1);
				ytoWorkOrder.setServiceType(1);
				ytoWorkOrder.setFlag(0);
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
				
				
				
//				YtoWorkOrder ytoWorkOrder=new YtoWorkOrder();
//				
//				ytoWorkOrder.setClientID(DataTrans.E_ClientId);
//				ytoWorkOrder.setLogisticProviderID("YTO");
//				ytoWorkOrder.setCustomerId(DataTrans.E_ClientId);
//				ytoWorkOrder.setTxLogisticID("111111");
//				ytoWorkOrder.setTradeNo("1");
//				
//				//ytoWorkOrder.setType(workOrder.getType());
//				ytoWorkOrder.setTotalServiceFee(0.0);
//				ytoWorkOrder.setCodSplitFee(0.0);
//				
//				ytoWorkOrder.setOrderType(1);
//				ytoWorkOrder.setServiceType(1);
//				ytoWorkOrder.setFlag(1);
//				
//				sender sender=new sender();
//				sender.setName("寄件人姓名");
//				sender.setPostCode("526238");
//				sender.setPhone("021-12345678");
//				sender.setMobile("18112345678");
//				sender.setProv("上海");
//				sender.setCity("上海,青浦区");
//				sender.setAddress("华徐公路3029弄28号");	
//				
//				ytoWorkOrder.setSender(sender);
//				
//				receiver receiver=new receiver();
//				receiver.setName("收件人姓名");
//				receiver.setPostCode("0");
//				receiver.setPhone("0");
//				receiver.setMobile("18112345678");
//				receiver.setProv("上海");
//				receiver.setCity("上海,青浦区");
//				receiver.setAddress("华徐公路3029弄28号");
//				
//				ytoWorkOrder.setReceiver(receiver);
//				SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
//				ytoWorkOrder.setSendStartTime(sdf.parse("2015-12-12 12:12:12"));
//				ytoWorkOrder.setSendEndTime(sdf.parse("2015-12-12 12:12:12"));
//				ytoWorkOrder.setGoodsValue(1);
//				
//				List<item> itemL=new ArrayList<item>();
//				item item=new item();
//				item.setItemName("商品");
//				item.setNumber(2);
//				item.setItemValue(0);
//				itemL.add(item);
//				
//				items items=new items();
//				items.setItem(itemL);
//				
//				ytoWorkOrder.setItems(items);
//				
//				ytoWorkOrder.setInsuranceValue(1);
//				ytoWorkOrder.setSpecial(1);
//				ytoWorkOrder.setRemark("1");
				
				String datastr ="";	
				try {
					datastr =  DataConvert.beanToXml(ytoWorkOrder, YtoWorkOrder.class);
				} catch (JAXBException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				logger.info("传送数据："+datastr);
				
				String data_digest= datastr + DataTrans.E_PartnerID;
				
				logger.info("待签名数据："+data_digest);
				
				String md5Str="";
				try {
					md5Str=Encoder.EncoderByMd5(data_digest);
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}

				logger.info("签名后内容："+md5Str);
				
				
				 String newmd5Str = URLEncoder.encode(md5Str,"utf-8");
				
				String postPam="logistics_interface="
						+URLEncoder.encode(datastr,"utf-8")
						+"&data_digest="
						+URLEncoder.encode(newmd5Str,"utf-8")
						+"&type=offline&clientId="+DataTrans.E_ClientId;
				logger.info("提交参数："+postPam);
				String s=HttpRequest.sendPost(DataTrans.E_URL,postPam);
				logger.info("返回结果："+s);
				
				Response response=null;
				try {
					response=DataConvert.xmlToBean(s, Response.class);
					
					System.out.println(response.getCode());
				} catch (JAXBException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//String str =  beanToXml(workOrder, WorkOrder.class);
			
		}else{
			logger.info("无待要处理的数据");
		}
    }
	
	
}
