<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
 <script type="text/javascript">
 var basePath="<%=basePath %>"
 window.UEDITOR_HOME_URL="<%=basePath %>/ueditor/";
 </script>
<head>

<title>推送编辑</title>

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

<script type="text/javascript" src="<%=basePath%>ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="<%=basePath%>ueditor/ueditor.all.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>ueditor/themes/iframe.css"/> 

<script type="text/javascript" src="<%=basePath%>js/common/common.js"></script>
<script type="text/javascript">
$(function() {
	$("#btnSubmit").click(function() {
		var parameter = getParameter();
		console.log(parameter);
		if(parameter){
			curd('editNotice', parameter);
			parent.$("#list").datagrid('reload');
		}
	});
	
	var value=$("#intro").val();
    $("#introduction").val(value);  
});

//获取表单数据
function getParameter() {
	var noticeId = $("#noticeId").val();
	var title = $("#title").val();
	var createDate = $("#ksDate").val();
	var twoType = $("#twoType").combobox('getValue');//新闻类型
	var introduction = $("#introduction").val();
	var htmlUrl = $("#htmlUrl").val();//主题描述，用于生成html页面
	
	if (title == "") {
		alert("请输入标题");
		return false;
	}
	if(introduction==""){
		alert("请输入简介内容");
		return false;
	}
	var parameter = {
		noticeId : noticeId,
		title : title,
		createDate : createDate,
		twoType : twoType,
		introduction : introduction,
		htmlUrl:htmlUrl,
	};
	return parameter;

}

</script>
</head>

<body class="easyui-layout">
	<div region="center" title="数据修改">
		<form id ="newForm" enctype="multipart/form-data" method="post">
			<table>
				<tr>
					<td><input id="noticeId" type="hidden" value="${notice.noticeId }"></td>
				</tr>
				<tr>
					<td>活动标题</td><td><input id="title" style="width: 400px"
					 type="text" value="${notice.title }" required="true"></td>
				</tr>
				<tr>
					<td>活动时间</td>
					<td><input class="easyui-datetimebox" id="ksDate" data-options="required:true,showSeconds:false"
	     				style="width:400px"></td>
				</tr>
				<tr>
					<td>分类信息</td><td>
						<select id="twoType"  class="easyui-combobox"  name="twoType" style="width:400px;" data-options="required:true">  
				            <option value="1"  <c:if test="${notice.twoType == 1}">selected</c:if>>固定通知</option>
				            <option value="2"  <c:if test="${notice.twoType == 2}">selected</c:if>>活动通知</option>
				            <option value="3"  <c:if test="${notice.twoType == 3}">selected</c:if>>付费通知<option>
				   		</select>  
						
					</td>
				</tr>
				<tr>
					<input type="hidden" value="${notice.introduction }" id="intro">
					<td>活动简介</td><td><textarea rows="5" cols="50" id="introduction" /></textarea></td>
				</tr>
				<tr>
					<td>活动链接</td>
					<td><input type="text" id="htmlUrl" value="${notice.htmlUrl }" style="width: 400px"
					class="easyui-textbox" type="text" ></td>    
				</tr>
				<tr>
					<td colspan="2" align="center"><a id="btnSubmit" href="#"
					class="easyui-linkbutton">提交表单</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
