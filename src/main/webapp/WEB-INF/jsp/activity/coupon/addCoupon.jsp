<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>添加优惠券</title>

<script type="text/javascript" src="<%=basePath%>js/common/constants.js"></script>

<link rel="stylesheet" type="text/css"
	href="<%=basePath%>easyui/css/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>easyui/css/themes/icon.css" />
<script type="text/javascript"
	src="<%=basePath%>easyui/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>easyui/js/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>easyui/js/easyui-lang-zh_CN.js"></script>


<link href="<%=basePath%>um/themes/default/css/umeditor.css"
	type="text/css" rel="stylesheet">
<script type="text/javascript"
	src="<%=basePath%>um/third-party/template.min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="<%=basePath%>um/umeditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="<%=basePath%>um/umeditor.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>um/lang/zh-cn/zh-cn.js"></script>

<script type="text/javascript" src="<%=basePath%>js/common/common.js"></script>
<script type="text/javascript">
	function cancle1(){
		window.location.href="${pageContext.request.contextPath}/activity/coupon/showAllCoupon?activityStatus=1";
	}

	function check(){
		var date1=$("#d1").val();
	 	var date2=$("#d2").val();
	 	if(date1>=date2){
	 		alert("开始日期不能大于结束日期");
	 	}
	 	return date1<date2;
	}
	
</script>
</head>

<body>
	
	<h3>优惠券列表>>新建优惠券</h3><br>
	<form action="${pageContext.request.contextPath}/activity/coupon/addCoupon" id="addForm" onsubmit="return check()" method="post">
		优惠券名称：<input type="text" name="couponName"><br/><br/>
		发放张数：&nbsp;&nbsp;&nbsp;<input type="text" name="grantNum"><br/><br/>
		优惠券面值：<input type="text" name="faceValue"><br/><br/>
		使用门槛：<input type="radio" name="usingThreshold"  value="0">不限制<br/><br/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="usingThreshold"  value="1">满<input type="text" name="fullAmountReduction">元可使用<br/><br/>
				
		<!-- 每人限领：<input type="text" name="limitNum">张<br/><br/> -->
		
		活动时间：<input id="d1" type="text" name="startTimeStr" class="easyui-datetimebox" data-options="required:true" > —— <input type="text" id="d2" name="endTimeStr" 
		class="easyui-datetimebox" data-options="required:true"><div id="datemsg"></div><br/><br/>
		
		<!-- 随机优惠券面额：<input id="minFaceValue" type="text" name="minFaceValue" onblur="checkFaceValue(this.value)"> —— <input type="text" id="maxFaceValue" name="maxFaceValue" onblur="checkFaceValue(this.value)"><br/><br/>-->
		到期提醒：<input type="checkbox" name="remind"  value="1" >到期两天提醒<br/><br/>
		<input type="button" value="取消" onclick="cancle1()" >&nbsp; 
		<input type="submit" value="确定发布" >
	</form>
</body>
</html>
