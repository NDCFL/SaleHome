<%@page import="com.ht.pojo.TUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	TUser user = (TUser) session.getAttribute("user");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>  
<head>  
    <meta charset="utf-8">  
    <title>HTML5本地存储之Web Storage篇</title>  
</head>  
<body>  
    <div style="border: 2px dashed #ccc;width:320px;text-align:center;">     
        <label for="sitename">网站名(key)：</label>  
        <input type="text" id="sitename" name="sitename" class="text"/>  
        <br/>  
        <label for="siteurl">网 址(value)：</label>  
        <input type="text" id="siteurl" name="siteurl"/>  
        <br/>  
        <input type="button" onclick="save()" value="新增记录"/>  
        <hr/>  
        <label for="search_phone">输入网站名：</label>  
        <input type="text" id="search_site" name="search_site"/>  
        <input type="button" onclick="find()" value="查找网站"/>  
        <p id="find_result"><br/></p>  
    </div>  
    <br/>  
    <script>
	// 载入所有存储在localStorage的数据
	loadAll(); 	
		
    //保存数据  
    function save(){  
        var siteurl = document.getElementById("siteurl").value;  
        var sitename = document.getElementById("sitename").value;  
        localStorage.setItem(sitename, siteurl);
        alert("添加成功");
    }
    //查找数据  
    function find(){  
        var search_site = document.getElementById("search_site").value;  
        var sitename = localStorage.getItem(search_site);  
        var find_result = document.getElementById("find_result");  
        find_result.innerHTML = search_site + "的网址是：" + sitename;  
    }
    //将所有存储在localStorage中的对象提取出来，并展现到界面上
    function loadAll(){  
        var list = document.getElementById("list");  
        if(localStorage.length>0){  
            var result = "<table border='1'>";  
            result += "<tr><td>网站名</td><td>网址</td></tr>";  
            for(var i=0;i<localStorage.length;i++){  
                var sitename = localStorage.key(i);  
                var siteurl = localStorage.getItem(sitename);  
                result += "<tr><td>"+sitename+"</td><td>"+siteurl+"</td></tr>";  
            }  
            result += "</table>";  
            list.innerHTML = result;  
        }else{  
            list.innerHTML = "数据为空……";  
        }  
    }      
    </script>
</body>  
</html>