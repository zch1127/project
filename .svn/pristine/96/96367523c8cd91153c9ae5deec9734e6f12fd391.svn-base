<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>展示已使用优惠券</title>

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
	
	$(function(){
	
		$("#selectAllRedPacketReceive").datagrid({
			loadMsg:'数据加载中,请稍后...',
			title:'展示所有使用优惠券',
			pageNumber:1,
			pageSize: 5,//每页显示的记录条数，默认为10    
            pageList: [5, 10, 20],//可以设置每页记录条数的列表    
            beforePageText: '跳转到',//页数文本框前显示的汉字    
            afterPageText: '页    共 {pages} 页',  
            displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',
			pagination: true,//显示分页栏
		 	url:"${pageContext.request.contextPath}/activity/coupon/selectAllUsedCoupon",
	    	columns:[[    
	        {field:'id',title:'优惠券id',width:100,hidden:true},    
	        {field:'userName',title:'用户昵称',width:100},    
	        {field:'useTime',title:'使用时间',width:100},    
	        {field:'useType',title:'使用方式',width:100,formatter: function(value,row,index){
				if (value==1){
						return "购物抵扣";
					} else {
						return "其他";
					}
				}
	        } 
	        
	        ]],
	       }); 
	});
	
</script>
</head>

<body>
	
	<div>已使用优惠券&nbsp;&nbsp;|&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/activity/coupon/showAllCoupon?activityStatus=1" >优惠券</a></div><br/>
	 <table id="selectAllRedPacketReceive"></table>
</body>
</html>
