<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>商品管理</title>

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
	$(function(){
		$("#showAllProduct").datagrid({
			queryParams: {
				type:null
			},
			url:"${pageContext.request.contextPath}/product/selectAllProduct",
			method:"GET",
			pagination:true,
		    pageNumber:1,
		    pageSize:5,
		    pageList:[5,10,20],
			columns:[[    
					{field:"",title:"",checkbox:true},
			        {field:"id",title:"商品ID",width:80,align:"center",hidden:true},  
			        {field:"titleImg",title:"商品图片",width:95,align:"center",
			        formatter:function(value,row){
					   var str = "";
				 	if(value!="" || value!=null){
				 	str = "<img style='height:120px;width:95px;' src="+domain+value+">";
				       return str;
				 }}},  
			        {field:"name",title:"商品名字",width:250,align:"center"},  
			        {field:"sellPrice",title:"价格",width:80,align:"center"},  
			        {field:"saleNumber",title:"销量",width:80,align:"center"},  
			        {field:"quantityNumber",title:"库存",width:80,align:"center"},   
			        {field:"productCategoryId",title:"分类",width:80,align:"center",
			        	formatter : function(value, row, index) {
			        		//alert(value);
			        		var str;
							$.ajax({
								url:"${pageContext.request.contextPath}/product/showCategoryById",
								data:"id="+value,
								dataType:"json",
								async: false,
								success:function(data){
									console.log(data.productCategory.name);
									str = data.productCategory.name;
								}
							})
							return str;
						}
			        },  
			        {field:"createDate",title:"上架时间",width:180,align:"center",
			        formatter:function(value, rowData,rowIndex){
			        	var date = new Date(value);
					    var y = date.getFullYear().toString();
					    var m = (date.getMonth() + 1);
					    var d = date.getDate().toString();
					    var h = date.getHours().toString();
					    var i = date.getMinutes().toString();
					    var s = date.getSeconds().toString();
					    //+ ':' + (s < 10 ? '0' + s : s)
					    return y + '-' + (m < 10 ? '0' + m : m) + '-' + (d < 10 ? '0' + d : d)+ '  ' + (h < 10 ? '0' + h : h) + ':' + (i < 10 ? '0' + i : i)+ ':' + (s < 10 ? '0' + s : s) ;
			        }},
			]]
		});

		$("#cateId").change(function(){
			var value=$("#cateId").val();
			//$.messager.alert("提示",value,"warning");
			if (value == "1"||value == 1) {
				value = encodeURI(value);
				
				$("#newSpan").html("");
				$("#newSpan").html('<input type="button" onclick="editPro()" value="编辑"/>&nbsp;&nbsp;&nbsp;<input type="button" onclick="deletePro()" value="删除"/>&nbsp;&nbsp;&nbsp;<input type="button" onclick="updatePro()" value="下架"/>');
				$("#showAllProduct").datagrid("load", {
					type :value
				});
			}else if(value=="2"||value==2){
				value = encodeURI(value);
				$("#newSpan").html("");
				$("#newSpan").html('<input type="button" onclick="editPro()" value="编辑"/>&nbsp;&nbsp;&nbsp;<input type="button" onclick="deletePro()" value="删除"/>&nbsp;&nbsp;&nbsp;<input type="button" onclick="updatePro1()" value="上架"/>');
				$("#showAllProduct").datagrid("load", {
					type :value
				});
			}else if(value=="3"||value == 3){
				value = encodeURI(value);
				$("#newSpan").html("");
				$("#newSpan").html('<input type="button" onclick="editPro()" value="编辑"/>&nbsp;&nbsp;&nbsp;<input type="button" onclick="deletePro()" value="删除"/>');
				$("#showAllProduct").datagrid("load", {
					type :value
				});
			}else{
				value = encodeURI(value);
				$("#newSpan").html("");
				$("#newSpan").html('<input type="button" onclick="editPro()" value="编辑"/>&nbsp;&nbsp;&nbsp;<input type="button" onclick="deletePro()" value="删除"/>&nbsp;&nbsp;&nbsp;<input type="button" onclick="updateProByRecommend()" value="取消推荐"/>');
				$("#showAllProduct").datagrid("load", {
					type :value
				});
			}
	});
	//搜索功能
	$("#btnSearch").click(function() {
		var keywordName = $("#keywordName").val();
		if (keywordName != "") {
			
		}
		
		$("#showAllProduct").datagrid("load", {
			name: keywordName
		});
	});
});
	/*删除功能  */
	function deletePro(){
		var allSelected = $("#showAllProduct").datagrid("getSelections");
		//console.log(allSelected);
		if(allSelected.length == 0){
			$.messager.alert("删除确认","请选择要删除的商品","warning");			
		}else{
			$.messager.confirm("确认删除","确认要删除选中的商品吗",function(r){
				if(r){
					var ids= new Array(allSelected.length); 
					/*把选中的id都给赋值给这个数组  得到所有选中的id  */
					for(var i =0;i<allSelected.length;i++){
						ids[i] = allSelected[i].id;
					}
					$.ajax({
						url:"${pageContext.request.contextPath}/product/deleteProduct",
						data:"id="+ids,
						dataType:"JSON",
						success:function(data){
							if(data){
								/*删除成功进行数据回显 */
								//alert("删除成功");
								$("#showAllProduct").datagrid("reload"); 
							}else{
								alert("删除失败");
								$("#showAllProduct").datagrid("reload"); 
							}
						}
					});	
				}
			});
		}		
	}
	//下架功能  吧状态改为0 仓库中	
	function updatePro(){
		var allSelected = $("#showAllProduct").datagrid("getSelections");
		//console.log(allSelected);
		if(allSelected.length == 0){
			$.messager.alert("下架确认","请选择要下架的商品","warning");			
		}else{
			$.messager.confirm("确认下架","确认要下架选中的商品吗",function(r){
				if(r){
					var ids= new Array(allSelected.length); 
					/*把选中的id都给赋值给这个数组  得到所有选中的id  */
					for(var i =0;i<allSelected.length;i++){
						ids[i] = allSelected[i].id;
					}
					$.ajax({
						url:"${pageContext.request.contextPath}/product/updatePro",
						data:"id="+ids,
						dataType:"JSON",
						success:function(data){
							if(data){
								$("#showAllProduct").datagrid("reload"); 
							}else{
								$("#showAllProduct").datagrid("reload"); 
							}
						}
					});	
				}
			});
		}		
	}
	//批量上架
	
	function updatePro1(){
		var allSelected = $("#showAllProduct").datagrid("getSelections");
		//console.log(allSelected);
		if(allSelected.length == 0){
			$.messager.alert("上架确认","请选择要上架的商品","warning");			
		}else{
			$.messager.confirm("确认上架","确认要上架选中的商品吗",function(r){
				if(r){
					var ids= new Array(allSelected.length); 
					/*把选中的id都给赋值给这个数组  得到所有选中的id  */
					for(var i =0;i<allSelected.length;i++){
						ids[i] = allSelected[i].id;
					}
					$.ajax({
						url:"${pageContext.request.contextPath}/product/shelvesProduct",
						data:"id="+ids,
						dataType:"JSON",
						success:function(data){
							if(data){
								$("#showAllProduct").datagrid("reload"); 
							}else{
								$("#showAllProduct").datagrid("reload"); 
							}
						}
					});	
				}
			});
		}		
	}
	//取消推荐
	function updateProByRecommend(){
		var allSelected = $("#showAllProduct").datagrid("getSelections");
		//console.log(allSelected);
		if(allSelected.length == 0){
			$.messager.alert("取消推荐","请选择要取消推荐的商品","warning");			
		}else{
			$.messager.confirm("确认取消","确认要取消推荐选中的商品吗",function(r){
				if(r){
					var ids= new Array(allSelected.length); 
					/*把选中的id都给赋值给这个数组  得到所有选中的id  */
					for(var i =0;i<allSelected.length;i++){
						ids[i] = allSelected[i].id;
					}
					$.ajax({
						url:"${pageContext.request.contextPath}/product/updateProByRecommend",
						data:"id="+ids,
						dataType:"JSON",
						success:function(data){
							if(data){
								$("#showAllProduct").datagrid("reload"); 
							}else{
								$("#showAllProduct").datagrid("reload"); 
							}
						}
					});	
				}
			});
		}
	
	}
	/*编辑功能   点击跳转到添加的页面  把数据赋值给添加模块*/
	function editPro(){
		var selected = $("#showAllProduct").datagrid("getSelections");
		console.log(selected);
		var id=selected[0].id;
		if(selected.length!=1){
			$.messager.confirm("提示信息","请选择一行数据","warning");
		}else{
			$.messager.confirm("确认修改","确认修改么",function(r){    
			    if (r){  
					window.location.href="${pageContext.request.contextPath}/product/toEditProduct?id="+id;
			    }    
			}); 
		}	
	}
	
	
</script>

</head>

<body class="easyui-layout">

	<!--多个点击按钮绑定同一个事件，根据按钮事件的状态进行相应的数据操作  -->
	<select id="cateId"  style="height: 22px;">
		<option value="1">出售中</option>
		<option value="2">仓库中</option>
		<option value="3">已告罄</option>
		<option value="4">推荐商品</option>
	</select>
	
	<input type="text" class="easyui-txtbox"  style="margin-left:20px;" placeholder="请输入名称" id="keywordName"> 
				<td colspan="2"><button id="btnSearch">搜索</button></td>
	
	
	
	
	<div id="editProduct">
		<span id="newSpan">
			<input type="button" onclick="editPro()" value="编辑"/>&nbsp;&nbsp;&nbsp;
			<input type="button" onclick="deletePro()" value="删除"/>&nbsp;&nbsp;&nbsp;
			<input type="button" onclick="updatePro()" value="下架"/>
			<!--<a class="easyui-linkbutton" onclick="updatePro()" id="jia" sta="1">下架</a> -->
		</span>
		
	</div>	<!--0 上架  1 下架 -->
	<!--展示所有的商品信息  -->
	<div style="width: 100%;height: 90%;overflow:auto;" id="newDiv" >
		<table id="showAllProduct"></table>
	</div>
</body>
</html>
