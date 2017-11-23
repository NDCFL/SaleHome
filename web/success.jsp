<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=path %>/css/bootstrap.min1.css">
<link rel="stylesheet" type="text/css" href="<%=path %>/css/style1.css">
<link rel="stylesheet" type="text/css" href="<%=path %>/css/font-awesome.min.css">
<link rel="apple-touch-icon-precomposed" href="<%=path %>/images/icon/icon.png">
<link rel="shortcut icon" href="<%=path %>/images/icon/favicon.ico">
<script src="<%=path %>/js/jquery-2.1.4.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-lg-10 col-md-offset-2 main" id="main">
	<table class="table">
	<caption>上下文表格布局</caption>
	<thead>
		<tr>
			<th>产品</th>
			<th>付款日期</th>
			<th>状态</th>
		</tr>
	</thead>
	<tbody>
		<tr class="active">
			<td>产品1</td>
			<td>23/11/2013</td>
			<td>待发货</td>
		</tr>
		<tr class="success">
			<td>产品2</td>
			<td>10/11/2013</td>
			<td>发货中</td>
		</tr>
		<tr  class="warning">
			<td>产品3</td>
			<td>20/10/2013</td>
			<td>待确认</td>
		</tr>
		<tr  class="danger">
			<td>产品4</td>
			<td>20/10/2013</td>
			<td>已退货</td>
		</tr>
	</tbody>
</table>
	      
</div>
</body>
</html>
