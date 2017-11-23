<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/jquery-easyui-1.3.0/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/jquery-easyui-1.3.0/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/index.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-easyui-1.3.0/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-easyui-1.3.0/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-easyui-1.3.0/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/opentabs.js"></script>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/jquery-autocomplete/jquery.autocomplete.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-autocomplete/jquery.autocomplete.min.js"></script>
<script type="text/javascript">
	/*
	 * classMethod : 它的值类似 com.yuwin.Group-add这样的组合
	 * myMethod    : 请求完成后调用的方法
	 * params      : 被调用方法的参数
	*/
	function verifyPrivilege(classMethod, myMethod, params){
		var url = "${pageContext.request.contextPath }/privilegeAction!verify.action";
		$.ajax({ 
			url: url,
			async:true,
			cache:false,
			data:{'classMethod':classMethod},
			dataType:"json",
			success: function(data){
				var message = data.message;
	        	if("success"==message){
	        		if(params==null){
	        			myMethod(params);
	        		}else{
	        			if(params.length==1){
	        				myMethod(params[0]);
	        			}else if(params.length==2){
	        				myMethod(params[0], params[1]);
	        			}
	        		}
	        	}else{
	        		alert("您的权限不足");
	        		return false;
	        	}
	      	}
		});
	}
	
	/*
	 * classMethod : 它的值类似 com.yuwin.Group-add这样的组合
	*/
	function hasPrivilege(classMethod){
		var url = "${pageContext.request.contextPath }/privilegeAction!verify.action";
		var hasPri = false;
		$.ajax({ 
			url: url,
			async:false,
			cache:false,
			data:{'classMethod':classMethod},
			dataType:"json",
			success: function(data){
				var message = data.message;
	        	if("success"==message){
	        		hasPri = true;
	        	}else{
	        		alert("您的权限不足");
	        		hasPri = false;
	        	}
	      	}
		});
		return hasPri;
	}
</script>
