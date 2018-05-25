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

<title>优惠券列表</title>

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
	function selectByStu(){
		var activityStatus=$("#sta").val();
		//alert("进入状态查询");
		window.location.href="${pageContext.request.contextPath}/activity/coupon/showAllCoupon?activityStatus="+activityStatus;
	}
	function addCoupon(){
		//alert("开始创建优惠券");
		var activityStatus=$("#sta").val();
		window.location.href="${pageContext.request.contextPath}/activity/coupon/toAddCoupon";
	}
	//删除红包   
	function delCoupon(id){
		//alert(id);
		var activityStatus=$("#sta").val();
		var msg="";
		if(activityStatus!=1){
			msg = "您真的确定要删除吗？\n\n请确认！";
		}else{
			msg = "删除后活动将立即结束，并不可恢复!\n\n请确认！"
		}
		if (confirm(msg)==true){
			//alert("执行删除");
			alert("删除成功");
			window.location.href="${pageContext.request.contextPath}/activity/coupon/deleteCoupon?id="+id+"&activityStatus="+activityStatus;
		}else{
			var activityStatus=$("#sta").val();
			//alert(activityStatus);
			window.location.href="${pageContext.request.contextPath}/activity/coupon/showAllCoupon?activityStatus="+activityStatus;
		}
	}
	//编辑红包
	function updateCoupon(id){
		//alert(id);
		var activityStatus=$("#sta").val();
		//alert(activityStatus);
		window.location.href="${pageContext.request.contextPath}/activity/coupon/toUpdateCoupon?id="+id+"&activityStatus="+activityStatus;
	}
</script>

</head>
<body>
		<h3>优惠券列表</h3><br/>
		<input type="button" onclick="addCoupon()" value="新建优惠券"><br/><br/>
	
		<div style="width:100px; height:40px;">
			<select onchange="selectByStu()" style="width: 80px;height: 30px; color: orange;" id="sta">
				<c:if test="${activityStatus ==-1}">
					<option  selected="selected" value="-1">全部订单</option>
					<option value="0" >未开始</option>
					<option value="1" >已开始</option>
					<option value="2" >已结束</option>
				</c:if>
				<c:if test="${activityStatus ==0}">
					<option value="-1">全部订单</option>
					<option selected="selected" value="0">未开始</option>
					<option value="1" >已开始</option>
					<option value="2" >已结束</option>
				</c:if>
				<c:if test="${activityStatus ==1}">
					<option value="-1">全部订单</option>
					<option value="0" >未开始</option>
					<option selected="selected" value="1">已开始</option>
					<option value="2" >已结束</option>
				</c:if>
				<c:if test="${activityStatus ==2}">
					<option value="-1">全部订单</option>
					<option value="0" >未开始</option>
					<option value="1" >已开始</option>
					<option selected="selected" value="2">已结束</option>
				</c:if>
			</select>
		</div>
		<hr>
		<!-- 展示所有优惠券 -->
		<table border="1">
			<tr>
				<th STYLE="white-space: nowrap;">优惠券名称</th>
				<th STYLE="white-space: nowrap;">活动时间</th>
				<th STYLE="white-space: nowrap;">优惠券面值</th>
				<th STYLE="white-space: nowrap;">发放张数</th>
				<th STYLE="white-space: nowrap;">使用门槛</th>
				<th STYLE="white-space: nowrap;">领取人数</th>
				<th STYLE="white-space: nowrap;">已使用</th>
				<th STYLE="white-space: nowrap;">状态</th>
				<th STYLE="white-space: nowrap;">操作</th>
			</tr>
			<c:forEach items="${list}" var="coupon">
			<tr>
				<td style="display: none;" id="rpId">${coupon.id}</td>
				<td>${coupon.couponName }</td>
				<td>${coupon.startTime }至<br/>
					${coupon.endTime }</td>
				<td >${coupon.faceValue }</td>
				<td align="center">${coupon.grantNum }</td>
				<c:if test="${coupon.fullAmountReduction!=null }">
				<td align="center">${coupon.fullAmountReduction }</td>
				</c:if>
				<c:if test="${coupon.fullAmountReduction==null }">
				<td align="center">不限制</td>
				</c:if>
				<td align="center" STYLE="white-space: nowrap;"><c:if test="${coupon.receiveNum>0 }">
				<a href="${pageContext.request.contextPath}/activity/coupon/toAllUsedCoupon?activityStatus=${activityStatus}&couponId=${coupon.id}" >${coupon.receiveNum }</a>
				</c:if>
				<c:if test="${coupon.receiveNum==0}">
					${coupon.receiveNum }
				</c:if>/${coupon.grantNum }</td>
				<td align="center">${coupon.useNum }</td>
				<c:if test="${coupon.activityStatus==0 }">
					<td align="center" STYLE="white-space: nowrap;"  >未开始</td>
				</c:if>
				<c:if test="${coupon.activityStatus==1 }">
					<td align="center" STYLE="white-space: nowrap;">已开始</td>
				</c:if>
				<c:if test="${coupon.activityStatus==2 }">
					<td align="center" STYLE="white-space: nowrap;">已结束</td>
				</c:if>
				<td align="center" STYLE="white-space: nowrap;">
				<c:choose>
				<c:when test="${coupon.activityStatus==2 }">
					<input type="button" onclick="updateCoupon(${coupon.id})" disabled="disabled" value="编辑">&nbsp;
				</c:when>
				<c:otherwise>
					<input type="button" onclick="updateCoupon(${coupon.id})"  value="编辑">&nbsp;
				</c:otherwise>
				</c:choose>
				<input type="button" onclick="delCoupon(${coupon.id})" value="删除"></td>
			
			</tr>
			</c:forEach>
		</table>
		
</body>
</html>
