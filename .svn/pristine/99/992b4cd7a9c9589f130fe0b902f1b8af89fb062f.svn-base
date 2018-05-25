<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>订单管理</title>

<script type="text/javascript" src="<%=basePath%>js/common/constants.js"></script>

<link rel="stylesheet" type="text/css"
	href="<%=basePath%>easyui/css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>easyui/css/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>easyui/css/demo.css">

<script type="text/javascript"
	src="<%=basePath%>easyui/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>easyui/js/jquery.easyui.min.js"></script>

<script type="text/javascript"
	src="<%=basePath%>easyui/js/easyui-lang-zh_CN.js"></script>

<script type="text/javascript" src="<%=basePath%>js/common/common.js"></script>
<script type="text/javascript">
	/* 页面初始化操作  */
	$(function(){

	})
	function submitForm(){
		$("#submitForm").form("submit",{
			url:"${pageContext.request.contextPath}/order/setTime",
			dataType:"JSON",
			success:function(data){
				if(data){
					alert("设置成功");
				}else{
					alert("设置失败，请重新设置");
				}
			}
		});
	}
</script>

</head>
<body>
	<div style="width: 100%;height: 90%" id="newDiv">
		<form method="post" id="submitForm">
			<h1>交易时间设置：</h1>
			<h3>待付款订单取消时间设置</h3><br>
			拍下未付款订单<input type="text" name="costTime"/>分钟内未付款,自动取消订单。
			<h3>发货后自动确认收货时间设置</h3><br>
			发货后<input type="text" name="totalTime" id="yy"/>天,自动确认收货。<br>
			<h3>收货后自动好评时间设置</h3><br>
			发货后<input type="text" name="finishDate" id="xx"/>天,自动五星好评。<br>
			<input type="button" onclick="submitForm()" value="保存"/>
		</form>	
	</div>	
</body>
</html>
