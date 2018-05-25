<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
 <script type="text/javascript">
 var basePath="<%=basePath %>"
 window.UEDITOR_HOME_URL="<%=basePath %>/ueditor/";
 </script>
<head>

<title>新闻发布</title>

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
	/* // 实例化UEditer编辑器
	$("#categoryId").combobox({
		url : "../pub/category/100006",
		valueField : 'categoryId',
		textField : 'categoryName'
	}); */
	$("#btnSubmit").click(function() {
		var parameter = getParameter();
		console.log(parameter);
		if(parameter){
			curd('addNotice', parameter);
			parent.$("#list").datagrid('reload');
		}
	});
});

//获取表单数据
function getParameter() {
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
	<div region="center" title="数据添加">
		<form id ="newForm" enctype="multipart/form-data" method="post">
			<table>
				<tr>
					<td>活动标题</td><td><input id="title" name="title" style="width: 400px"
					class="easyui-textbox" type="text" placeholder="名称"
					required="true"></td>
				</tr>
				<tr>
					<td>活动时间</td>
					<td><input class="easyui-datetimebox" id="ksDate" name="createDate" data-options="required:true,showSeconds:false"
	     				style="width:400px"></td>
				</tr>
				<tr>
					<td>分类信息</td><td>
						<select id="twoType"  class="easyui-combobox"  name="twoType" style="width:400px;" data-options="required:true">  
							<option value="1">固定通知</option>
							<option value="2">活动通知</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>活动简介</td><td><textarea rows="5" cols="50" name="introduction" id="introduction"/></textarea></td>
				</tr>
				<tr>
					<td>活动链接</td>
					<td><input type="text" id="htmlUrl" name="htmlUrl" style="width: 400px"
					class="easyui-textbox" type="text" ></td>    
				</tr>
				<tr>
					<td colspan="2" align="center"><a id="btnSubmit" href="#"
					class="easyui-linkbutton">提交表单</a>
					</td>
					<!-- <td colspan="2" align="center"><input type="button" value="添加" onclick="addNotice()"/> </td> -->
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
