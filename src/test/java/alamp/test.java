package alamp;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.renyuwo.alamp.entity.ResultMsg;
import com.renyuwo.alamp.setting.DataTrans;
import com.renyuwo.alamp.util.Encoder;
import com.renyuwo.alamp.util.HttpRequest;

public class test {

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {

		StringBuilder datastr = new StringBuilder();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String formatTime = dateFormat.format(new Date());

		datastr.append(DataTrans.E_Secret_Key + "app_key" + DataTrans.E_App_Key + "formatXMLmethod" + DataTrans.E_method
				+ "timestamp" + formatTime + "user_id" + DataTrans.E_User_Id + "v1.01");

		StringBuilder md5Str = new StringBuilder();
		md5Str.append(Encoder.string2MD5(datastr.toString()));

		StringBuilder parastr = new StringBuilder();
		parastr.append("<?xml  version=\"1.0\"?><ufinterface><Result><WaybillCode><Number>"+"810118083767"+"</Number></WaybillCode></Result></ufinterface>");

		StringBuilder postPam = new StringBuilder();
		postPam.append("sign=" + md5Str.toString().toUpperCase() + "&app_key=" + DataTrans.E_App_Key + "&format=XML"
				+ "&method=" + DataTrans.E_method + "&timestamp=" + formatTime + "&user_id=" + DataTrans.E_User_Id
				+ "&v=1.01" + "&param=" + parastr.toString());
		
		System.out.println(postPam.toString());
		StringBuilder responseString = new StringBuilder();
		responseString.append(HttpRequest.sendPost(DataTrans.E_Search_url, postPam.toString()));
		
		ResultMsg resultMsg = new ResultMsg();
		resultMsg.setCode("200");
		resultMsg.setSuccess("Y");
		
		if(responseString.indexOf("")>0){
			resultMsg.setMessage("无查询结果");
		}else{
			resultMsg.setMessage("查询结果");
		}
		
		resultMsg.setDetail(responseString.toString());
		
		System.out.println("返回结果："+JSON.toJSONString(resultMsg));
		
//		System.out.println(responseString.toString());
	}
}
