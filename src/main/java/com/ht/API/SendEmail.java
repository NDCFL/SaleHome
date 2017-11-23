package com.ht.API;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;


public class SendEmail {

	// 这里是SMTP发送服务器的协议
	public static final String HOST_NAME = "smtp.163.com";
	// 登陆邮件服务器的用户名、密码、昵称
	public static final String USERNAME = "xljx_888888@163.com";
	public static final String PASSWORD = "cfl1997";//lanqiao123
	public static final String NICKNAME = "xljx_888888@163.com";

	
	/**
	 * 发送邮件（成功true、失败false）
	 * @param receiveEmail	收件人邮箱
	 * @param receiveNick	收件人昵称（随便取）
	 * @param subject		邮件主题
	 * @param contents		邮件内容
	 * @return
	 */
	public static final boolean sendMail(String receiveEmail,String receiveNick,String subject,String contents){
		HtmlEmail email = new HtmlEmail ();
		try {
			//smtp host 
			email.setHostName(HOST_NAME);
			//登陆邮件服务器的用户名和密码
			email.setAuthentication(USERNAME,PASSWORD);
			//接收人
			email.addTo(receiveEmail, receiveNick);
			//发送人
			email.setFrom(USERNAME, NICKNAME);
			//标题
			email.setSubject(subject);
			//邮件内容
			email.setCharset("utf-8");
			email.setHtmlMsg(contents);
			//发送
			email.send();
			return true;
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
//		MultiPartEmail email = new MultiPartEmail();
//		try {
//			//smtp host 
//			email.setHostName(HOST_NAME);
//			//登陆邮件服务器的用户名和密码
//			email.setAuthentication(USERNAME,PASSWORD);
//			//接收人
//			email.addTo(receiveEmail, receiveNick);
//			//发送人
//			email.setFrom(USERNAME, NICKNAME);
//			//标题
//			email.setSubject(subject);
//			//邮件内容
//			email.setMsg(contents);
//			//发送
//			email.send();
//			return true;
//			
//		} catch (EmailException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return false;
//		}
		
	}
}
