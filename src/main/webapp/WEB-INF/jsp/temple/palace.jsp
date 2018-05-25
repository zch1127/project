
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
<script type="text/javascript" src="<%=basePath%>js/temple/commonTemple.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>easyui/js/jquery.easyui.min.js"></script>

<script type="text/javascript"
	src="<%=basePath%>easyui/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	/*页面初始化完成时 自动加载的数据 */
	$(function(){
		$("#newForm").dialog({
			closed:true,
		});
		$("#secondForm").dialog({
			closed:true,
		});
		$("#newTable").datagrid({
			queryParams: {
				type:null
			},
			url:"${pageContext.request.contextPath}/temple/selectAllPalace",
			method:"GET",
			pagination:true,
		    pageNumber:1,
		    pageSize:10,
		    pageList:[10,20],
			columns:[[    
					{field:"",title:"",checkbox:true},
			        {field:"palaceId",title:"宫殿ID",align:"center",hidden:true},  
			        {field:"imgUrl",title:"宫殿图片",width:125,align:"center",
			        formatter:function(value,row){
					   var str = "";
				 	if(value!="" || value!=null){
				 	str = "<img style='height:80px;width:120px;' src="+domain+value+">";
				       return str;
				 }}},  
			        {field:"palaceName",title:"宫殿名字",width:100,align:"center"},  
			        {field:"templeId",title:"寺院信息",width:100	,align:"center",
			        	formatter: function(value,row,index){
			        		var val;
			        		$.ajax({
			        			url:"${pageContext.request.contextPath}/temple/selectTempleById?templeId="+value,
			        			dataType:"json",
			        			async:false,//同步执行
			        			success:function(data){
			        				val = data.temple.templeName;
			        			}
			        		});
			        		return val;
						}
			        },
			        {field:"backgroundImgUrl",title:"宫殿背景图片",width:125,align:"center",
			        formatter:function(value,row){
					   var str = "";
				 	if(value!="" || value!=null){
				 	str = "<img style='height:80px;width:120px;' src="+domain+value+">";
				       return str;
				 }}}, 
			        {field:"content",title:"宫殿介绍",width:222,align:"center"}
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
				},'-',{
				text:'修改',
					iconCls: 'icon-edit',
					handler: function(){
						var allSelected = $("#newTable").datagrid("getSelections");
						if(allSelected.length !=1){
							alert("请选择一条数据");
						}else{
							$("#secondForm").dialog({
								closed:false,
								title:"修改宫殿信息"
							});
							var id = allSelected[0].templeId;
							console.log(allSelected[0]);
							$("#tid").val(allSelected[0].palaceId);
							$("#temName").val(allSelected[0].palaceName);
							$("#imgPreview2").attr('src',domain+allSelected[0].imgUrl);
							$("#picture2").val(allSelected[0].imgUrl);
							$("#imgPreview3").attr('src',domain+allSelected[0].backgroundImgUrl);
							$("#picture3").val(allSelected[0].backgroundImgUrl);
							$("#content2").val(allSelected[0].content);
							$.ajax({
							 	url:"${pageContext.request.contextPath }/temple/queryAllTemple",
							 	method:"GET",
							 	dataType:"json",
							 	success:function(data){
							 		//console.log(data);
							 		$.each(data,function(index,data){
								//将查询出的数据填充到select 标签下面
										if(data.templeId == id){
											$("#aId").append("<option selected='selected' value="+data.templeId+">"+data.templeName+"</option>");				
										}else{
											$("#aId").append("<option value="+data.templeId+">"+data.templeName+"</option>");		
										}
									});
								 }
							});
						}
					}
				},'-',{
				text:'删除',
				iconCls: 'icon-remove',
				handler: function(){
					var allSelected = $("#newTable").datagrid("getSelections");
					//console.log(allSelected);
					if(allSelected.length == 0){
						$.messager.alert("删除确认","请选择要删除的寺院信息","warning");			
					}else{
						$.messager.confirm("确认删除","确认要删除选中的寺院信息吗",function(r){
							if(r){
								var ids= new Array(allSelected.length); 
								/*把选中的id都给赋值给这个数组  得到所有选中的id  */
								for(var i =0;i<allSelected.length;i++){
									ids[i] = allSelected[i].palaceId;
								}
								$.ajax({
									url:"${pageContext.request.contextPath}/temple/deletePalace",
									data:"ids="+ids,
									dataType:"JSON",
									success:function(data){
										if(data){
											/*删除成功进行数据回显 */
											alert("删除成功");
											$("#newTable").datagrid("reload"); 
										}else{
											alert("删除失败");
											$("#newTable").datagrid("reload"); 
										}
									}
								});	
							}
						});
					}		
				}
			}]
		});
		$("#btnUpload").click(
			function() {
				var formData = new FormData();
				formData.append("upfile",
						document.getElementById("file").files[0]);
				$.ajax({
					url : "upload/pictrue",
					type : "POST",
					data : formData,
					contentType : false,
					processData : false,
					success : function(data) {
						console.log(data);
						$.messager.show({
							title : "系统消息",
							msg : data.message
						});
						$("#imgPreview").attr("src",
								domain + data.object);
						$("#picture").val(data.object);
					},
					error : function() {
						alert("上传失败！");
						$("#imgWait").hide();
					}
				});
			 });
		
		$("#btnUpload1").click(function() {
			//alert("哈哈");
			var formData = new FormData();
			formData.append("upfile",
					document.getElementById("file1").files[0]);
			$.ajax({
				url : "upload/pictrue",
				type : "POST",
				data : formData,
				contentType : false, 
				processData : false,
				success : function(data) {
					console.log(data);
					$.messager.show({
						title : "系统消息",
						msg : data.message
					});
					$("#imgPreview1").attr("src",
							domain  + data.object);
					$("#picture1").val(data.object);
				},
				error : function() {
					alert("上传失败！");
					$("#imgWait").hide();
				}
			});
		});
		$("#btnUpload2").click(
			function() {
				var formData = new FormData();
				formData.append("upfile",
						document.getElementById("file2").files[0]);
				$.ajax({
					url : "upload/pictrue",
					type : "POST",
					data : formData,
					contentType : false,
					processData : false,
					success : function(data) {
						console.log(data);
						$.messager.show({
							title : "系统消息",
							msg : data.message
						});
						$("#imgPreview2").attr("src",
								domain + data.object);
						$("#picture2").val(data.object);
					},
					error : function() {
						alert("上传失败！");
						$("#imgWait").hide();
					}
				});
			 });
		$("#btnUpload3").click(
			function() {
				var formData = new FormData();
				formData.append("upfile",
						document.getElementById("file3").files[0]);
				$.ajax({
					url : "upload/pictrue",
					type : "POST",
					data : formData,
					contentType : false,
					processData : false,
					success : function(data) {
						console.log(data);
						$.messager.show({
							title : "系统消息",
							msg : data.message
						});
						$("#imgPreview3").attr("src",
								domain + data.object);
						$("#picture3").val(data.object);
					},
					error : function() {
						alert("上传失败！");
						$("#imgWait").hide();
					}
				});
			 });
	});
	function addTemple(){
		//alert("666");
		$("#newForm").form("submit",{
			url:"${pageContext.request.contextPath}/temple/addTemplePalace",
			dataType:"json",
			success:function(data){
				if(!data){
					alert("添加失败");
					
				}else{
					alert("添加成功");
					window.location.href="${pageContext.request.contextPath}/temple/toPalace";
				}
			}
		});
	}
	function updateTemple(){
		$("#secondForm").form("submit",{
			url:"${pageContext.request.contextPath}/temple/updateTemplePalace",
			dataType:"json",
			success:function(data){
				if(!data){
					alert("修改失败");
				}else{
					alert("修改成功");
					window.location.href="${pageContext.request.contextPath}/temple/toPalace";
				}
			}
		});
	}
</script>	
</head>

<body class="easyui-layout">
	<div style="width:90%px; height:100%; overflow:auto;">
		<table id="newTable"></table>

		<form id ="newForm" enctype="multipart/form-data" method="post">
			<table>
				<tr>
					<td>宫殿名字</td><td><input id="palaceName" name="palaceName" style="width: 300px"
					class="easyui-textbox" type="text" placeholder="名称"
					required="true"></td>
				</tr>
				<tr>
					<td>宫殿图片</td>
					<td  height="50"><img id="imgPreview" width="150"  src="../images/defaultImg.jpg"/><br/>
					<input id="picture" name="imgUrl" type="text" hidden="1" />
					 <input id="file"  name="file"   type="file" /> 
					 <a id="btnUpload" href="#"  class="easyui-linkbutton">上传图片</a></td>
				</tr>
				<tr>
					<td>寺院信息</td><td>
						<input id ="abbotId" name="templeId" class="easyui-combobox" data-options="
						method:'get',
						mode:'remote',
			    		valueField:'templeId',
			    		textField:'templeName',
			    		url:'${pageContext.request.contextPath }/temple/queryAllTemple'
	        			"/><br>
					</td>
				</tr>
				<tr>
					<td>背景图片</td>
					<td  height="50"><img id="imgPreview1" width="150"  src="../images/defaultImg.jpg"/><br/>
					<input id="picture1" name="backgroundImgUrl" type="text" hidden="1" />
					<input id="file1"  name="file"   type="file" /> 
					<a id="btnUpload1" href="#"  class="easyui-linkbutton">上传图片</a></td>
				</tr>
				<tr>
					<td>寺院简介</td><td><input type="text" name="content" id="content"/></td>
				</tr>
				<tr>
					<td><input type="button" id="btnSubmit" onclick="addTemple()" value="提交" /></td>
				</tr>
			</table>
		</form>
		
		<form id ="secondForm" enctype="multipart/form-data" method="post">
			<table>
				<tr>
					<td><input id="tid" name="palaceId" type="hidden"></td>
				</tr>
				<tr>
					<td>宫殿名字</td><td><input id="temName" name="palaceName" type="text"></td>
				</tr>
				<tr>
					<td>宫殿图片</td>
					<td  height="50"><img id="imgPreview2" width="150" src="#"/><br/>
					<input id="picture2" name="imgUrl" type="text" />
					 <input id="file2"  name="file"   type="file" /> 
					 <a id="btnUpload2" href="#"  class="easyui-linkbutton">上传图片</a></td>
				</tr>
				<tr>
					<td>寺院信息</td><td><select id="aId" name="templeId">
					</select></td>
				</tr>
				<tr>
					<td>背景图片</td>
					<td  height="50"><img id="imgPreview3" width="150"  src="../images/defaultImg.jpg"/><br/>
					<input id="picture3" name="backgroundImgUrl" type="text" />
					<input id="file3"  name="file"   type="file" /> 
					<a id="btnUpload3" href="#"  class="easyui-linkbutton">上传图片</a></td>
				</tr>
				<tr>
					<td>寺院简介</td><td><input type="text" name="content" id="content2"/></td>
				</tr>
				<tr>
					<td><input type="button" id="btnSubmit2" onclick="updateTemple()" value="提交" /></td>
				</tr>
			</table>
		</form>
		
	</div>
</body>
</html>
