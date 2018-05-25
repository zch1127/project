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
	function addHF(){
		var HF = $("#addHF").val();
		//alert(HF);
		var id = $("#cid").val();
		$.ajax({
			url:"${pageContext.request.contextPath}/comment/addHF",
			data:"reply="+HF+"&id="+id,
			dataType:"json",
			success:function(data){
				alert("回复成功");
			}
		})
	}
</script>

</head>
<body>
	<div style="width: 100%;height: 90%" id="newDiv">
		<input type="hidden" value="${comment.id }" id="cid"/>
		<h1>评论详情</h1>
		<hr>
		<h3>商品：${comment.name }</h3>
		<hr>
		<h3>发表人：${comment.userName }   &nbsp;${comment.createDate }</h3>
		<h3>内容：${comment.commentContent }</h3>
		<hr>
		<c:if test="${list1.size()!=0 }">
		<h3>晒单：</h3>
			<c:forEach items="${list1}" var="sp">
				<img src=${sp.sourceImg } style="width: 80px; height: 100px" alt="评论图片">
			</c:forEach>
		</c:if></br>
		<textarea rows="5" cols="100" name="sellerReplyContent"></textarea></br>
		<input type="button" onclick="addHF()" value="回复"/>
		
	</div>	
</body>
</html>
