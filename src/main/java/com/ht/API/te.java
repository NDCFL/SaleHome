package com.ht.API;

import java.text.SimpleDateFormat;
import java.util.Date;

/**  
 * @Title: http://www.smschinese.cn/api.shtml
 * @date 2011-3-22
 * @version V1.2  
 */
public class te {
	
	
	public static void main(String[] args) {
		
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	       Date d=new Date("Tue Aug 22 14:00:00 CST 2017");
	       System.out.println("格林威治时间:"+d);
	       String s=df.format(d);
	       System.out.println("格式化后的时间"+s);
	}
}
