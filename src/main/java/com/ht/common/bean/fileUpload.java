package com.ht.common.bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class fileUpload {

	 /**
	  * 实现文件上传
	  * @param fileUpload
	  * @param request 
	  * @return
	  */
	  @RequestMapping( "/fileUpload" )
	   public void fileUpload(@RequestParam ("file") MultipartFile fileUpload,HttpServletRequest request,HttpServletResponse response){

	     SimpleDateFormat sFormat = new SimpleDateFormat("yyyyMMddhhmmss" );
	     String fileName = sFormat.format(Calendar.getInstance().getTime())+ new Random().nextInt(1000);
	     String originalFilename = fileUpload.getOriginalFilename();
	     fileName += originalFilename.substring(originalFilename.lastIndexOf("." ));
	     String dirName = request.getSession().getServletContext().getRealPath("/" )+"fileUpload" ;
	     System.out.println(dirName+"============");
	     double originalFilesize = request.getContentLength();//获取源文件大小

	     File file = new File(dirName);
	     InputStream inputStream = null ;
	     FileOutputStream outputStream = null ;
	      if (!file.exists())
	     {
	         file.mkdir();
	     }
	      try
	     {
	         inputStream = fileUpload.getInputStream();
	          if (!inputStream.equals(null)){
	              try {
	                 String table_type = request.getParameter("table_type" );
	                
	             } catch (Exception e) {

	                  e.printStackTrace();
	             }
	         }
	         outputStream = new FileOutputStream(dirName+"/" +fileName);
	          byte [] buffer = new byte[1024 * 1024];
	          int len=0;
	          while ((len=inputStream.read(buffer)) != -1)
	         {
	             outputStream.write(buffer, 0, len);
	             outputStream.flush();
	         }
	         outputStream.close();
	         inputStream.close();
	     }
	      catch (FileNotFoundException e)
	     {
	         e.printStackTrace();
	     }
	      catch (IOException e)
	     {
	         e.printStackTrace();
	     }

	   }
}
