<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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


</head>
<body>
	
			 
		
		<!-- 展示订单详情 -->
		<table border="1">
			<tr>
				<th>订单编号</th>
				<th>商品图片</th>
				<th>商品名称</th>
				<th>申请人</th>
				<th>申请时间</th>
				<th>类型</th>
				<th>退款原因</th>
				<th>订单金额</th>
				<th>退款金额</th>
			</tr>
			<tr>
				<td>${rodd.orderSn}</td>
				<td><img src="${rodd.titleImg }" alt='商品图片' width='50' height='50'></td>
				<td>${rodd.productName }</td>
				<td>${rodd.userName }</td>
				<td>${rodd.createDate }</td>
				<c:if test="${rodd.refundType==0 }">
					<td>退货退款</td>
				</c:if>
				<c:if test="${rodd.refundType==1 }">
					<td>退款</td>
				</c:if>
				<td>${rodd.contentDesc }</td>
				<td>${rodd.productSubtotal }</td>
				<td>${rodd.refundAmount }</td>
			</tr>
		</table>
		<div id="dd">
			
        		
    			<c:forEach items="${rodd.list}" var="record">
    		
    					<img src="${record.picture }" alt='用户头像' width='50' height='50'>${record.userName }${record.refundRecord }   
    					
    					<fmt:formatDate value="${record.createDate }" pattern="yyyy/MM/dd  HH:mm:ss" /><br/>
    					
    			
    			</c:forEach>
    		
		</div>
		<a href="${pageContext.request.contextPath}/refund/selectAllOrderRefundByStatus?approveStatus=4">返回上一层</a>
	</div>	
</body>
</html>
