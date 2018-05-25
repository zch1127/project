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
	/* $(function(){
		var picture = $("#imgUrl").val();
		alert(picture);
		if(picture != ""){
		$("#imgUrl").attr('src', domain  + picture);
		}
	}) */
	function selectByStu(){
		var stateValue=$("#cc").val();
		window.location.href="${pageContext.request.contextPath}/order/selectAllOrder?stateValue="+stateValue;
		
	}
	//根据name进行查询
	function searchByName(){
		
		if(productName==""){
			alert("请输入要查询的商品名字");
		}else{
			window.location.href="${pageContext.request.contextPath}/order/searchOrder?productName="+productName;
		}
	}
	//根据订单编号
	function searchBySn(){
		var productName=$("#newName").val();
		var orderSn = $("#newSn").val();
		if(orderSn==""&&productName==""){
			alert("请输入要查询的订单信息");
		}else{
			$("#searchINF").form("submit",{
				url:"${pageContext.request.contextPath}/order/searchOrderByConditions"
			})
			//window.location.href="${pageContext.request.contextPath}/order/searchOrderByOrderSn?orderSn="+orderSn;
		}
	}
	//查询订单详情信息
	function queryByOrderSn(sum){
		var orderSn = sum;
		window.location.href="${pageContext.request.contextPath}/order/searchDetailOrderByOrderSn?orderSn="+orderSn;
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
        		<tr>
        			<td colspan="2" style="width: 40%"><h3>订单信息</h3></td>
        			<td colspan="2" style="width: 40%"><h3>收货信息</h3></td>
        			<td style="width: 20%"><h3>操作</h3></td>
        		</tr>
    			<c:forEach items="${list }" var="pro">
    				<tr>
    					<td>下单时间：${pro.createDate} </td><td>订单号：${pro.orderSn }</td>
    					<td>共${pro.totalProductNum}件商品</td><td>合计：￥${pro.totalAmount}</td>
    					<c:if test="${pro.orderStatus == 0}">
    					<td style="color: red">待付款</td>
    					</c:if> 
    					<c:if test="${pro.orderStatus == 1}">
    					<td style="color: red">待发货</td>
    					</c:if>
    					<c:if test="${pro.orderStatus == 2}">
    					<td style="color: red">已发货</td>
    					</c:if>
    					<c:if test="${pro.orderStatus == 3}">
    					<td style="color: red">待评价</td>
    					</c:if>
    					<c:if test="${pro.orderStatus == 4}">
    					<td style="color: red">已完成</td>
    					</c:if>
    					<c:if test="${pro.orderStatus == 5}">
    					<td style="color: red">交易关闭</td>
    					</c:if>
    				</tr>
    				<c:forEach items="${pro.orderDetail }" var="orderDetail">
    					<tr>
    						<td><img id ="imgUrl" src="${orderDetail.imgUrl }" alt='商品图片' width='50' height='50'>${orderDetail.productName }</td><td>￥${orderDetail.productPrice }×${orderDetail.productNum }</td>
    				</c:forEach>
    						<td colspan="2">${pro.receiptPersonName }  ${pro.receiptPersonMobile }${pro.receiptArea }</td>
    					<c:if test="${pro.orderStatus == 0}">
    						<td><a href="javascript:void(0);" onclick="queryByOrderSn('${pro.orderSn}')">订单详情</a><br/>
    							<a href="javascript:void(0);" onclick="queryByOrderSn('${pro.orderSn}')">修改价格</a></td>
    					</c:if>
    					<c:if test="${pro.orderStatus == 1}">
    						<td><a href="javascript:void(0);" onclick="queryByOrderSn('${pro.orderSn}')">订单详情</a><br/>
    						<a href="javascript:void(0);" onclick="queryByOrderSn('${pro.orderSn}')">发货</a></td>
    					</c:if>
    					<c:if test="${pro.orderStatus == 2 || pro.orderStatus == 3}">
    						<td><a href="javascript:void(0);" onclick="queryByOrderSn('${pro.orderSn}')">订单详情</a><br/>
    						<a href="javascript:void(0);" onclick="queryByOrderSn('${pro.orderSn}')">物流信息</a></td>
    						<%-- <a href="javascript:void(0);" onclick="queryLogisticsByOrderSn('${pro.orderSn}')"> --%>
    					</c:if>
    					<c:if test="${pro.orderStatus == 4 ||pro.orderStatus == 5 }">
    						<td><a href="javascript:void(0);" onclick="queryByOrderSn('${pro.orderSn}')">订单详情</a></td>
    					</c:if>
    				</tr>
    			</c:forEach>
    			<hr>
			</table>
		</div>
	</div>	
</body>
</html>
