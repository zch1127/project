<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>编辑优惠券</title>

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
		window.location.href="${pageContext.request.contextPath}/activity/showAllRedPacket?activityStatus=1";
	}
	function publish(){
		alert();
		$('#addForm').form('submit', {
			url:"${pageContext.request.contextPath}/activity/coupon/updateCoupon",
			dataType:"json",
			onSubmit: function(){
				var isValid = $(this).form('validate');
				/* if (!isValid){
					
				}
				return isValid;	// 返回false终止表单提交 */
				return true;
				
			},
			success: function(){
				var isins = JSON.parse(data);
		         //alert(isins);
		        if(isins){
					$.messager.show({
						title:'添加消息',
						msg:'添加成功',
						showType:'show',
					});
		        }else{
			        $.messager.show({
							title:'添加消息',
							msg:'添加失败',
							showType:'show',
					});
		        }    
			}
		});


	}
	function check(form){
		
	}
	function checkFaceValue(value){
    //这里就不做兼容了
    
        var cfv=/(?!^0\.0?0$)^[0-9][0-9]?(\.[0-9]{1,2})?$|^100$/;
        if(!cfv.test(value)){
           alert("请输入大于0的整数或者保留两位有效小数");
        }
    
	}
</script>
</head>

<body>

	<h3>优惠券列表>>编辑优惠券</h3><br>
	<form action="javascript:void(0)" id="addForm" method="post">
		<input type="hidden" name="id" value="${coupon.id}">
		优惠券名称：<input type="text" name="couponName" value="${coupon.couponName}"><br/><br/>
		发放张数：&nbsp;&nbsp;&nbsp;<input type="text" name="grantNum" value="${coupon.grantNum}"><br/><br/>
		优惠券面值：<input type="text" name="faceValue" value="${coupon.faceValue}"><br/><br/>
		
		使用门槛：
			<c:if test="${coupon.usingThreshold==0}">
				<input type="radio" name="usingThreshold" checked value="0">不限制<br/><br/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="usingThreshold"  value="1">满<input type="text" name="fullAmountReduction" value="${coupon.fullAmountReduction}">元可使用<br/><br/>
			</c:if>	
			<c:if test="${coupon.usingThreshold!=0}">
				<input type="radio" name="usingThreshold"  value="0">不限制<br/><br/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="usingThreshold" checked value="1">满<input type="text" name="fullAmountReduction" value="${coupon.fullAmountReduction}">元可使用<br/><br/>
			</c:if>	
		<!-- 每人限领：<input type="text" name="limitNum">张<br/><br/> -->
		
		活动时间：<input id="d1" type="text" name="startTimeStr" value="${coupon.startTime}"> —— <input type="text" id="d2" name="endTimeStr" onblur="compareD1ToD2()" value="${coupon.startTime}"><br/><br/>
		
		到期提醒：
		
			<input type="checkbox" name="remind" value="1">到期两天提醒<br/><br/>
		
		<input type="button" value="取消" onclick="cancle1()">&nbsp; 
		<input type="submit" value="确定发布" onclick="publish()">
	</form>
</body>
</html>
