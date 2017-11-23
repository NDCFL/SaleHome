package com.ht.API;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**  
 * @Title: http://www.smschinese.cn/api.shtml
 * @date 2011-3-22
 * @version V1.2  
 */
public class test {
	
	//用户名
	private static String Uid = "絮落锦乡";
	
	//接口安全秘钥
	private static String Key = "7dc6e6e7cf7ca510a6a4";
	
	//手机号码，多个号码如13800000000,13800000001,13800000002
	private static String smsMob = "15679760329";
	
	//短信内容
	private static String smsText = "欢迎登录IT课堂:验证码:"+new Random(899999)+100000+"。10分钟之内有效";

	
	public static void main(String[] args) {
		
		HttpClientUtil client = HttpClientUtil.getInstance();
		
		//UTF发送
		int result = client.sendMsgUtf8(Uid, Key, smsText, smsMob);
		if(result>0){
			System.out.println("UTF8成功发送条数=="+result);
		}else{
			System.out.println(client.getErrorMsg(result));
		}
	}
}
