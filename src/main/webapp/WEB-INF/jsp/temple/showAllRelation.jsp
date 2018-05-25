
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
		$("#btnUpload").click(
			function() {
				var formData = new FormData();
				formData.append("upfile",
						document.getElementById("file").files[0]);
				$.ajax({
					url : "upload/pictrue",
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
						console.log(data);
						$.messager.show({
							title : "系统消息",
							msg : data.message
						});
						$("#imgPreview").attr("src",
								domain + data.object);
								//alert(domain2 + data.object);
						$("#picture").val(data.object);
					},
					error : function() {
						alert("上传失败！");
						$("#imgWait").hide();
					}
				});
			});
	
		$("#newForm").dialog({
			closed:true,
		});
		$("#newTable").datagrid({
			queryParams: {
				type:null
			},
			url:"${pageContext.request.contextPath}/temple/selectAllRelation",
			method:"GET",
			pagination:true,
		    pageNumber:1,
		    pageSize:5,
		    pageList:[5,10,20],
			columns:[[    
					{field:"",title:"",checkbox:true},
			        {field:"templeId",title:"寺院名字",align:"center", 
				        formatter:function(value,row){
				        	var str;
				        	$.ajax({
				        		url:"${pageContext.request.contextPath}/temple/selectTempleById?templeId="+value,
				        		dataType:"json",
				        		async:false,
				        		success:function(data){
				        			console.log(data);
				        			
				        			str = data.temple.templeName;
				        		}
				        	})
				        	return str;
				        }},  
			        {field:"modeType",title:"寺院类型",align:"center",
				        formatter:function(value,row){
				        	if(value==0){
				        		return "供奉";
				        	}else if(value==1){
				        		return "许愿";
				        	}else if(value==2){
				        		return "敲钟";
				        	}
				        }},  
			        {field:"backgroundImgUrl",title:"寺院模块背景图片",width:125,align:"center",
			        formatter:function(value,row){
					   var str = "";
				 	if(value!="" || value!=null){
				 	str = "<img style='height:80px;width:120px;' src="+domain+value+">";
				       return str;
				 }}},  
			]],
			  //工具栏
		    toolbar: [{
			    text:'添加',
				iconCls: 'icon-add',
				handler: function(){
					$("#newForm").dialog({
					closed:false,
					title:"添加寺院"
					});
				}
			}]
		});
	});
	function addTemple(){
		//alert("666");
		$("#newForm").form("submit",{
			url:"${pageContext.request.contextPath}/temple/addTempleRelation",
			dataType:"json",
			success:function(data){
				if(data){
					alert("添加成功");
					$("#newForm").dialog({
						closed:true
					});
					$("#newTable").datagrid("reload");
				}else{
					alert("添加失败");
				}
			}
		})
	}
</script>	
</head>

<body class="easyui-layout">
	<div style="width:90%px; height:85%; overflow:auto;">
		<table id="newTable"></table>
	
		<form id ="newForm" enctype="multipart/form-data" method="post">
			<table>
				<tr>
					<td>寺院名字</td><td><input id ="templeId" name="templeId" value="" class="easyui-combobox" data-options="
			    		valueField:'templeId',
			    		textField:'templeName',
			    		url:'${pageContext.request.contextPath }/temple/queryAllTemple'
	        			"/><br>
					</td>
				</tr>
				<tr>
					<td>寺院类型</td><td>
						<select id="newSelect" style="width: 175px" name="modeType">
							<!-- if(){
								
							} -->
							<option value="0">供奉</option>
							<option value="1">许愿</option>
							<option value="2">敲钟</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>背景图片</td>
					<td  height="50"><img id="imgPreview" width="150"  src="../images/defaultImg.jpg"/><br/>
					<input id="picture" name="backgroundImgUrl" type="text" hidden="1" />
					 <input id="file"  name="file"   type="file" /> 
					 <a id="btnUpload" href="#"  class="easyui-linkbutton">上传图片</a></td>
				</tr>
				<tr>
					<td><input type="button" id="btnSubmit" onclick="addTemple()" value="提交" /></td>
				</tr>
			</table>
		</form>	
	</div>
</body>
</html>