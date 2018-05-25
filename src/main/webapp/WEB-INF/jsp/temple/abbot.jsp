
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>商品添加</title>

<script type="text/javascript" src="<%=basePath%>js/common/constants.js"></script>

<link rel="stylesheet" type="text/css"
	href="<%=basePath%>easyui/css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>easyui/css/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>easyui/css/demo.css">

<script type="text/javascript"
	src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>easyui/js/jquery.easyui.min.js"></script>

<script type="text/javascript"
	src="<%=basePath%>easyui/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	/*页面初始化完成时 自动加载的数据 */
	$(function(){
	$("#newTable").datagrid({
			queryParams: {
				type:null
			},
			url:"${pageContext.request.contextPath}/temple/selectAbbot",
			method:"GET",
			pagination:true,
		    pageNumber:1,
		    pageSize:5,
		    pageList:[5,10,20],
			columns:[[    
					{field:"",title:"",checkbox:true},
			        {field:"abbotId",title:"住持ID",width:80,align:"center",hidden:true},  
			        {field:"titleImg",title:"商品图片",width:95,align:"center",
			        formatter:function(value,row){
					   var str = "";
				 	if(value!="" || value!=null){
				 	str = "<img style='height:120px;width:95px;' src="+value+">";
				       return str;
				 }}},  
			        {field:"name",title:"商品名字",width:250,align:"center"},  
			        {field:"sellPrice",title:"价格",width:80,align:"center"},  
			        {field:"saleNumber",title:"销量",width:80,align:"center"},  
			        {field:"quantityNumber",title:"库存",width:80,align:"center"},   
			        {field:"productCategoryId",title:"分类",width:80,align:"center"},  
			        {field:"createDate",title:"上架时间",width:180,align:"center"},
			]]
		});
	});
	
</script>	
</head>

<body class="easyui-layout">
	<div style="width:90%px; height:85%; overflow:auto;">
		
	</div>
</body>
</html>