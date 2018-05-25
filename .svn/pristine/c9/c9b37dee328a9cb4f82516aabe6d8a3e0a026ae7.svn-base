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

<title>编辑付费推送</title>

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
			curd('editPayNotice', parameter);
			parent.$("#list").datagrid('reload');
		}
	});
	
	var value=$("#intro").val();
    $("#introduction").val(value);  
    	$("#templeId").combobox({
		url : "${pageContext.request.contextPath}/temple/queryAllTemple",
		valueField : 'templeId',
		textField : 'templeName',
		onLoadSuccess: function(data){ $("#templeId").combobox('select', '${notice.templeId }')}
	});
});

//获取表单数据
function getParameter() {
	var templeId = $("#templeId").combobox('getValue');
	var infoType = $("#infoType").combobox('getValue');
	var noticeId = $("#noticeId").val();
	var title = $("#title").val();
	var createDate = $("#ksDate").val();
	var type = $("#type").val();//系统通知类型
	var twoType = $("#twoType").val();//付费通知类型
	var introduction = $("#introduction").val();
	var payNoticeDetailTitle = $("#payNoticeDetailTitle").val();
	var htmlUrl = UE.getEditor('myEditor').getContent();//付费内容描述，用于生成html页面
	
	
	if (title == "") {
		alert("请输入标题");
		return false;
	}
	if(introduction==""){
		alert("请输入简介内容");
		return false;
	}
	var parameter = {
		templeId:templeId,
		infoType:infoType,
		noticeId : noticeId,
		title : title,
		createDate : createDate,
		type : type,
		twoType : twoType,
		introduction : introduction,
		htmlUrl:htmlUrl,
		payNoticeDetailTitle:payNoticeDetailTitle,
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
					<td>分类信息</td><td>
						<select id="infoType"  class="easyui-combobox"  style="width:400px;" data-options="required:true">  
				            <option value="3"  <c:if test="${notice.infoType ==3}">selected</c:if>>供奉通知 </option>
				            <option value="4"  <c:if test="${notice.infoType ==4}">selected</c:if>>点灯通知 </option>
				            <option value="5"  <c:if test="${notice.infoType ==5}">selected</c:if>>敲钟通知</option> 
				   		    <option value="6"  <c:if test="${notice.infoType ==6}">selected</c:if>>许愿通知</option> 
						    <option value="7"  <c:if test="${notice.infoType ==7}">selected</c:if>>积庆寺通知</option>
					    </select>         
					</td>
				</tr>
				<tr>                                                                                                                        
					<td>寺院信息</td><td id="sel">                                                                                              
						<select id="templeId"  class="easyui-combobox"  style="width:200px;" data-options="required:true">  
						</select>                                                                                                           
					</td>                                                                                                                   
				</tr>                                                                                                                       
				<tr>
					<td>付费通知标题</td><td><input id="title" style="width: 400px"
					 type="text" value="${notice.title }" required="true"></td>
				</tr>
				<tr>
					<td>付费通知显示时间</td>
					<td><input class="easyui-datetimebox" id="ksDate" data-options="required:true,showSeconds:false"
	     				style="width:400px" value="${notice.createDate }"></td>
				</tr>
				<tr>
					<td><input id="type" type="hidden" value="${notice.type }"></td>
				</tr>
				<tr>
					<td><input id="twoType" type="hidden" value="${notice.twoType }"></td>
				</tr>
				<tr>
					<input type="hidden" value="${notice.introduction }" id="intro">
					<td>活动简介</td><td><textarea rows="5" cols="50" id="introduction" /></textarea></td>
				</tr>
			<%-- 	<tr style="display:none">
					<td>活动链接</td>
					<td><input type="text" id="htmlUrl" value="${notice.htmlUrl }" style="width: 400px"
					class="easyui-textbox" type="text" ></td>    
				</tr> --%>
				<td>付费通知详情标题</td><td><input id="payNoticeDetailTitle"  style="width: 300px"
					class="easyui-textbox" type="text" placeholder="通知详情标题" value="${notice.payNoticeDetailTitle }"/></td>
						
				</tr>
				<tr>
					<td>付费用户通知链接修改</td>
					<td>
						<div style="display: none;"><p id="content"></p></div>
						<div id="myEditor"  style="width: 600px; height: 300px;">
							<script type="text/javascript" charset="utf-8">
									var editor = new baidu.editor.ui.Editor();
									editor.render("myEditor");
							</script>
						</div>	
					</td>    
				</tr>
				<tr>
					<td colspan="2" align="center"><a id="btnSubmit" href="#"
					class="easyui-linkbutton">确认修改</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
