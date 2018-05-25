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

<title>付费通知</title>

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
	$("#btnUpload").click(
		function() {
			// $("#imgWait").show();
			var formData = new FormData();
			formData.append("upfile",
					document.getElementById("file").files[0]);
			//console.log(1);
			$.ajax({
				url : "${pageContext.request.contextPath}/push/upload/pictrue",
				type : "POST",
				data : formData,
				/**
				 * 必须false才会自动加上正确的Content-Type
				 */
				contentType : false,
				/**
				 * 必须false才会避开jQuery对 formdata 的默认处理 XMLHttpRequest会对
				 * formdata 进行正确的处理
				 */
				processData : false,
				success : function(data) {
					//console.log(data);
					$.messager.show({
						title : "系统消息",
						msg : data.message
					});
					$("#imgPreview").attr("src",
							domain  + data.object);
							console.info(domain);
							console.info(data.object);
					$("#picture").val(data.object);
				},
				
				error : function() {
					alert("上传失败！");
					$("#imgWait").hide();
				}
				
		});
	});
	// 实例化编辑器
	$("#templeId").combobox({
		url : "${pageContext.request.contextPath}/temple/queryAllTemple",
		valueField : 'templeId',
		textField : 'templeName',
		onLoadSuccess: function(data){ $("#templeId").combobox('select', '-----------请选择寺院------------')}
	});

	$("#btnSubmit").click(function() {
		var parameter = getParameter();
		console.log(parameter);
		if(parameter){
			curd('${pageContext.request.contextPath}/push/addPayNotice', parameter);
			parent.$("#list").datagrid('reload');
		}
	});
});

//获取表单数据
function getParameter() {
	//var infoId = $("#newsid").val();
	var title = $("#title").val();
	var payNoticeDetailTitle = $("#payNoticeDetailTitle").val();
	var picture = $("#picture").val();
	//console.info(picture);
	var createDate = $("#ksDate").val();
	var infoType = $("#infoType").combobox('getValue');//付费通知类型
	var introduction = $("#introduction").val();
	var templeId = $("#templeId").combobox('getValue');
	//console.info(templeId);
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
		title : title,
		picture : picture,
		createDate : createDate,
		infoType : infoType,
		introduction : introduction,
		htmlUrl:htmlUrl,
		templeId:templeId,
		payNoticeDetailTitle:payNoticeDetailTitle,
	};
	return parameter;

}
</script>
</head>

<body class="easyui-layout">
	<div region="center" title="付费通知数据添加">
		<form id ="newForm" enctype="multipart/form-data" method="post">
			<table>
				<tr>
					<td>分类信息</td><td>
						<select id="infoType"  class="easyui-combobox"  name="infoType" style="width:200px;" data-options="required:true">  
							<option value="">---------请选择通知类型---------- </option>
							<option value="3">供奉通知 </option>
							<option value="4">点灯通知 </option>
							<option value="5">敲钟通知</option>
							<option value="6">许愿通知</option>
							<option value="7">积庆寺通知</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>寺院信息</td><td id="sel">
						<select id="templeId"  class="easyui-combobox"  name="templeId" style="width:200px;" data-options="required:true"> 
						</select>
					</td>
				</tr>
				<tr>
				<!-- <td>付费通知图片</td>
					<td  height="50"><img id="imgPreview" width="150"  src="../images/defaultImg.jpg"/><br/>
					<input id="picture" name="picture" type="text" hidden="1" />
					 <input id="file"  name="file"   type="file" /> 
					 <a id="btnUpload" href="#"  class="easyui-linkbutton">上传图片</a></td>
				</tr> -->
				<tr>
					<td>付费用户通知标题</td><td><input id="title" name="title" style="width: 300px"
					class="easyui-textbox" type="text" placeholder="通知标题"
					required="true"></td>
				</tr>
		
				<tr>
					<td>通知创建时间</td>
					<td><input class="easyui-datetimebox" id="ksDate" name="createDate" data-options="required:true,showSeconds:false"
	     				style="width:300px"></td>
				</tr>
				<tr>
					<td>活动简介</td><td><textarea rows="5" cols="50" name="introduction" id="introduction"/></textarea></td>
				</tr>
				<tr>
				<td>付费通知详情标题</td><td><input id="payNoticeDetailTitle" name="payNoticeDetailTitle" style="width: 300px"
					class="easyui-textbox" type="text" placeholder="通知详情标题"
					required="true"></td>
				</tr>
				<tr>
					<td>付费用户通知链接</td>
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
					class="easyui-linkbutton">提交表单</a>
					</td>
					<!-- <td colspan="2" align="center"><input type="button" value="添加" onclick="addNotice()"/> </td> -->
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
