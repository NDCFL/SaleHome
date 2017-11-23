<%@page import="com.ht.pojo.TUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	TUser user = (TUser) session.getAttribute("user");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<style type="text/css">
</style>
</head>
<body>
	<div></div>
	<script type="text/javascript">
        //openDatabase方法打开已经存在的数据库，如果不存在将会创建一个数据库
        var db = window.openDatabase("mydatabase", "1.0", "我的数据库描述", 20000);

        //创建数据表
        var sql = "CREATE TABLE mytable (mytitle TEXT, timestamp REAL)";
        db.transaction(function (tx) {
            tx.executeSql(sql);
        });
//         db.transaction(function (tx) {
//             tx.executeSql('DELETE FROM LOGS  WHERE mytitle=15679760329');
//         });
        //往数据表插入数据
//         db.transaction(function (tx) {
//             tx.executeSql("INSERT INTO mytable (mytitle, timestamp) values(?, ?)", ["15679760329", "111111"], null, null);
//             tx.executeSql("INSERT INTO mytable (mytitle, timestamp) values(?, ?)", ["17607975702", "111111"], null, null);
//         });
        //删除数据表
        //db.transaction(function (tx) {
        //   tx.executeSql("DROP TABLE mytable ");
        //});
        db.transaction(function (tx) {
            tx.executeSql("SELECT * FROM mytable", [],function (tx, result) {
                 for (var i = 0; i < result.rows.length; i++) {
                         document.write('<h1>' + result.rows.item(i)['mytitle'] + " " + result.rows.item(i)['timestamp'] +'</h1>');
                 }
            },function () {
                 alert("error");
            });
        });

    </script>

</body>
</html>