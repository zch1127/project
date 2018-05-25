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
	/* 页面初始化操作  */
	$(function(){
		$("#showForm").dialog({
			closed:true
		})
		$("#updateCategory").dialog({
			closed:true
		})
	})
	function addCat(){
		$("#showForm").dialog({
			closed:false,
			title:"添加分类"
		})
	}
	//添加分类
	function addCategory(){
		//alert("123");
		$("#addCategory").form("submit",{
			url:"${pageContext.request.contextPath}/category/addFirstCategory",
			dataType:"json",
			success:function(data){
				//根据返回值进行一下判断
				if(data){
					alert("添加成功");
					//重置添加框内信息  重新加载数据
					$("#addCategory").form("reset");
					//$("#newTable").datagrid("reload");
					$("#showForm").dialog("close");
				}else{
					alert("添加失败");
					//重置添加框内信息  重新加载数据
					$("#addCategory").form("reset");
					$("#showForm").dialog("close");
				}
			}
		});
	}
	//删除分类功能
	function deleteCate(id){
		alert(id);
		$.ajax({
			url:"${pageContext.request.contextPath}/category/deleteCategory?id="+id,
			dataType:"json",
			success:function(data){
				//根据返回值进行一下判断
				if(data){
					alert("删除成功");
					
				}else{
					alert("删除失败");
				}
			}
		})
	}
	//弹出修改框 并赋值
	function updateCate(id,name){
		//alert(id+""+name);
		$("#updateCategory").dialog({
			closed:false
		})
		$("#cid").val(id);
		$("#cname").val(name);
	}
	//修改分类信息功能
	function updateCategory(){
		$("#updateProductCategory").form("submit",{
			url:"${pageContext.request.contextPath}/category/updateProductCategory",
			dataType:"json",
			success:function(data){
				//根据返回值进行一下判断
				if(data){
					alert("修改成功");
					$("#updateProductCategory").form("reset");
					$("#updateCategory").dialog("close");
				}else{
					alert("修改失败");
					$("#updateProductCategory").form("reset");
					$("#updateCategory").dialog("close");
				}
			}
		});
	
	}
</script>

</head>

<body>
	<h2>分类管理</h2>
	
		<div style="width: 500px"><!--添加一级分类  -->
			<input align="left" type="button" value="+添加分类" onclick="addCat()"/>
		</div>
		<table id="newTable">
			<thead>
        		<tr>
        			<th style="width: 100px">分类名字</th>
        			<th style="width: 100px">排序</th>
        			<th style="width: 100px">创建时间</th>
        			<th style="width: 100px">商品数量</th>
        			<th style="width: 100px">操作</th>
        		</tr>
    		</thead>
    		<!--二级循环 二级分类信息加载在特定的一级分类信息下面  -->
    			<c:forEach items="${list }" var="pro">
    				<tr >
    					<td >${pro.name }</td>
    					<td align="center">默认</td>
    					<td align="center">${pro.createDate}</td>
    					<td align="center">${pro.cNumber }</td>
    					<td align="center"><a href="javascript:void(0);" onclick="deleteCate('${pro.id}')">删除分类</a>&nbsp;&nbsp;&nbsp;<a href="javascript:void(0);" onclick="updateCate('${pro.id}','${pro.name }')">修改名称</a></td>
    				
    				</tr>
    				<c:forEach items="${pro.children}" var ="pp">
	    				<tr>
	    					<td align="center">${pp.name }</td>
	    					<td align="center">默认</td>
	    					<td align="center">${pp.createDate}</td>
	    					<td align="center">${pp.cNumber }</td>
	    					<td align="center"><a href="javascript:void(0);" onclick="deleteCate('${pp.id}')">删除分类</a>&nbsp;&nbsp;&nbsp;<a href="javascript:void(0);" onclick="updateCate('${pp.id}','${pp.name }')">修改名称</a></td>
	    				</tr>
    				</c:forEach>
    				<tr>
    					<td><input type="button" value="+添加子分类" onclick="addCat()"></td>
    				</tr>
    			</c:forEach>
		</table>
	<div id="showForm">
		<form id="addCategory" method="post" >
			分类名字：<input type="text" name="name"/><br>
			所属类别：<input name="id" class="easyui-combobox" value="一级分类" data-options="
		    		valueField:'id',
		    		textField:'name',
		    		url:'${pageContext.request.contextPath }/product/selectFirstCategory'
		    		" /><br>
			
			<input type="button" value="添加" onclick="addCategory()" />
		</form>
	</div>
	<div id="updateCategory">
		<form id="updateProductCategory" method="post" >
			<input type="hidden" id="cid" name="id"><br>
			分类名字：<input type="text" id="cname" name="cname"/><br>
			
			<input type="button" value="修改" onclick="updateCategory()" />
		</form>
	</div>
	<!-- <div id="hh">
	
		<input type="button" onclick="hah()"/>
	</div> -->
	
</body>
</html>
