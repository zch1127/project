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
	function selectByStu(){
		var stateValue=$("#cc").val();
		alert("66");
		window.location.href="${pageContext.request.contextPath}/order/selectAllOrder?stateValue="+stateValue;
	}
	
</script>

</head>
<body>
	<div style="width: 100%;height: 90%" id="newDiv">
	<h1 align="center">订单管理</h1>
		<div style="width:100px; height:40px;">
			<select onchange="selectByStu()" style="width: 80px;height: 30px; color: orange;" id="cc">
				<c:if test="${status ==0}">
					<option selected="selected" value="0">待付款</option>
				</c:if>
				<c:if test="${status ==1}">
					<option selected="selected" value="1">待发货</option>
				</c:if>
				<c:if test="${status ==2}">
					<option selected="selected" value="2">已发货</option>
				</c:if>
				<c:if test="${status ==3}">
					<option selected="selected" value="3">待评价</option>
				</c:if>
				<c:if test="${status ==4}">
					<option selected="selected" value="4">已完成</option>
				</c:if>
				<c:if test="${status ==5}">
					<option selected="selected" value="5">交易关闭</option>
				</c:if>
				<c:if test="${status ==6}">
					<option selected="selected" value="6">全部订单</option>
				</c:if>
				<option value="6">全部订单</option>
				<option value="0">待付款</option>
				<option value="1">待发货</option>
				<option value="2">已发货</option>
				<option value="3">待评价</option>
				<option value="4">已完成</option>
				<option value="5">交易关闭</option>
				
			</select>
		</div>
		<div>
			<form id="searchINF" method="post" action="searchOrderByConditions">
				<input type="text" id="newSn" placeholder="请输入订单编号" name="orderSn"/>
				<input type="text" id="newName" placeholder="请输入商品名字" name="productName"/>
				<input type="submit" value="搜索"/>
			</form>
		</div>
		<div id="dd">
			<table id="newTable" style="width:100%">
        		<tr><td><h3 style="color: red;">未匹配到对应的订单信息</h3><td></tr>
    			<hr>
			</table>
		</div>
	</div>	
</body>
</html>
