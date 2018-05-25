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
		$("#newTable").datagrid({
			url:"${pageContext.request.contextPath}/comment/selectAllComment",
			method:"GET",
			pagination:true,
		    pageNumber:1,
		    pageSize:10,
		    pageList:[10,20,50],
			columns:[[    
					{field:"",title:"",checkbox:true},
			        {field:"id",title:"商品ID",align:"center",hidden:true},  
			        {field:"titleImg",title:"商品图片",width:60,align:"center",
				        formatter:function(value,row){
						   var str = "";
						 	if(value!="" || value!=null){
						 	str = "<img style='height: 50px;width: 35px;' src="+domain+value+">";
						       return str;
							}
						}
					},
			        {field:"name",title:"商品名字",width:240,align:"center"},  
			        {field:"userName",title:"发表人",width:80,align:"center"},  
			        {field:"commentContent",title:"内容",width:280,align:"center"},  
			        {field:"status",title:"前台显示",width:50,align:"center",
			        	formatter:function(value,row){
			            	if(value=="1"){
			            		return "是";
			            	}
			            	if(value=="0"){
			            		return "否";
			            	}
			        	}
			        },   
			        {field:"createDate",title:"发表时间",width:160,align:"center",
			        formatter:function(value, rowData,rowIndex){
			        	var date = new Date(value);
						    var y = date.getFullYear().toString();
						    var m = (date.getMonth() + 1);
						    var d = date.getDate().toString();
						    var h = date.getHours().toString();
						    var i = date.getMinutes().toString();
						    //var s = date.getSeconds().toString();
						    //+ ':' + (s < 10 ? '0' + s : s)
						    return y + '-' + (m < 10 ? '0' + m : m) + '-' + (d < 10 ? '0' + d : d)+ '  ' + (h < 10 ? '0' + h : h) + ':' + (i < 10 ? '0' + i : i) ;
			        }},
			        {field:"opt",title:"操作",width:100,align:"center",  
			            formatter:function(value,rec){  
			                var btn = '<a onclick="showRow(\''+rec.id+'\')" href="javascript:void(0)">查看</a>&nbsp;&nbsp;&nbsp;<a onclick="delRow(\''+rec.id+'\')" href="javascript:void(0)">删除</a>';  
			                return btn;  
			            }  
       				}    
			]],
			   	toolbar: [{
				text:'批量删除',
				iconCls: 'icon-remove',
				handler: function(){
					var allSelected = $("#newTable").datagrid("getSelections");
					 //获取id  循环赋值给id 传递到controller层进行删除
						if(allSelected.length == 0){
							$.messager.alert("删除确认","请选择要删除的内容","warning");			
						}else{
							$.messager.confirm("确认删除","确认要删除选中的内容吗",function(r){
								if(r){
									var ids= new Array(allSelected.length); 
									/*把选中的id都给赋值给这个数组  得到所有选中的id */
									for(var i =0;i<allSelected.length;i++){
										ids[i] = allSelected[i].id;
									}
									$.ajax({
										url:"${pageContext.request.contextPath}/comment/deleteManyComment",
										data:"ids="+ids,
										dataType:"json",
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
		})
	})
	function delRow(id){
		var id =id;
		$.messager.confirm("警告","确认删除评论?",function(data){
			if(data){
				$.ajax({
					url:"${pageContext.request.contextPath}/comment/deleteById",
					data:"id="+id,
					dataType:"json",
					success:function(data){
						$("#newTable").datagrid("reload");
					}
				})
			}
		});
	}
	function showRow(id){
		//alert(id);
		window.location.href="${pageContext.request.contextPath}/comment/selectCommentById?id="+id;
	}
</script>

</head>
<body>
	<div style="width: 100%;height: 90%" id="newDiv">
		<table id="newTable"></table>
	</div>	
</body>
</html>
