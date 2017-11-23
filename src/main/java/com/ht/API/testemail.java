package com.ht.API;

public class testemail {

	 public static void main(String[] args) {
		String receiveEmail = "1186614701@qq.com";
        String receiveNick="陈飞龙";
        String subject="【桃源盛景】";
        String contents="【桃源盛景】欢迎你来到本公司就总经理一职,公司已经为你字平台分配了你的账号，以后员工的管理由你负责，你的账号和密码为：,请你在24小时之内登录平台修改密码，网址为：http://192.168.43.14:8888/SaleHome/hui-jxs/employeelogin.jsp";
        SendEmail.sendMail(receiveEmail, receiveNick, subject, contents);
        System.out.println("邮箱发送成功！");
	 }
}
