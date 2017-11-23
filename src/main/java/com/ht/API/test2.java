package com.ht.API;

import java.util.Random;
public class test2 {
	
	//用户名
	private static String Uid = "絮落锦乡2";
	
	//接口安全秘钥
	private static String Key = "b9169f3196bc7084b30b";
	
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
