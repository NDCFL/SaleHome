<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>地图</title>
    <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>    
</head>
<body>
<div id="container"></div>
<script src="http://webapi.amap.com/maps?v=1.3&key=e80e5ecd570257a01b67ce71092cfe33值&callback=init"></script>
<script>
    function init(){
        var map = new AMap.Map('container', {
            center: [117.000923, 36.675807],
            zoom: 6
        });
        map.plugin(["AMap.ToolBar"], function() {
            map.addControl(new AMap.ToolBar());
        });
    }
</script>
</body>
</html>