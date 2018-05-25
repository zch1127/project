<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>新闻资讯管理</title>

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
$(function() {
	// 初始化控件 事件
	$("#btnAdd").click(function() {
		$("#iframe").attr('src', 'toAddInformation');
		$("#win").window({
			maximized : true
		});
		$("#win").window('open');
	});
	// 删除
	$("#btnUnRec").click(function() {
		var selRow = $('#list').datagrid('getSelections');
		// 判断是否选中行
		if (selRow.length == 0) {
			alert("请选择要删除的行!");
			return;
		} else {
			var infoId = "";
			// 批量获取选中行的评估模板ID
			for (i = 0; i < selRow.length; i++) {
				if (infoId == "") {
					infoId = selRow[i].infoId;
				} else {
					infoId = selRow[i].infoId + "," + infoId;
				}
			}
			$.messager.confirm('提示', '是否删除选中数据?', function (r) { 
				if (!r) {  
                    return;  
                }
				$.ajax({
					url : '${pageContext.request.contextPath}/information/deleteInformation',
					data : {
						infoId : infoId
					},
					async : false,//同步请求
					success : function(data) {
						var result = data;// data.message;
						$.messager.show({
							title : "系统消息",
							msg : result.message
						});
					}
				});
				$("#list").datagrid('reload');
			});
		}
	});

	var sortName = 'publishDate';
	var sortOrder = 'asc';

	var index;
	$("#list").datagrid(
					{
						url:"${pageContext.request.contextPath}/information/showInformation",
						method:"GET",
						pagePosition : 'bottom',
						singleSelect : false,
						pagination:true,
					    pageNumber:1,
					    pageSize:5,
					    pageList:[5,10,20],
						columns : [[
								{
									field : 'ck',
									checkbox : true,
									width : '30'
								},{
									field : 'infoId',
									title : '新闻资讯主键',
									width : 70,
									hidden:true,
									sortable : true
								},{
									field : 'infoName',
									title : '资讯标题',
									width : 100,
									sortable : true
								},{
									field : 'infoContent',
									title : '主题内容',
									width : 300,
									sortable : true
								},{
									field : 'type',
									title : '资讯类型',
									width : 100,
									sortable : true,
									formatter : function(value, row, index) {
										if (value == 0) {
											return '实时';
										} else if (value == 1) {
											return '活动';
										} else if (value == 2) {
											return '政策';
										} else if (value == 3) {
											return "寺院";
										}else if (value == 4) {
											return "实时活动资讯";
										}
									}
								},{
									field : 'infoImg',
									title : '资讯图片',
									width : 150,
									sortable : true,
									height : 100,
									formatter : function(value, rowData,
											rowIndex) {
											/*数据图片  */
										return "<img src='"+ domain
												+ value
												+ "' style='width:120px;height:90px'/>";
									}
								}, {
									field : 'createTime',
									title : '发布日期',
									sortable : true,
									width : 200,
									formatter : function(value){
				                       var date = new Date(value);
									    var y = date.getFullYear().toString();
									    var m = (date.getMonth() + 1);
									    var d = date.getDate().toString();
									    //var h = date.getHours().toString();
									    //var i = date.getMinutes().toString();
									    //var s = date.getSeconds().toString();
									    //+ ' ' + (h < 10 ? '0' + h : h) + ':' + (i < 10 ? '0' + i : i)+ ':' + (s < 10 ? '0' + s : s)
									    return y + '-' + (m < 10 ? '0' + m : m) + '-' + (d < 10 ? '0' + d : d) ;
				                    }
								},{
										field : 'htmlUrl',
										title : 'HTML链接',
										width : 300,
										sortable : true
								} ]],
						//双击事件
						onDblClickRow : function(index, row) {
							$("#iframe").attr('src',
									'toEditInformation?infoId=' + row.infoId);
							$("#win").window({
								maximized : true
							});
							$("#win").window('open');
						}
					});
});

</script>
</head>

<body class="easyui-layout">

	<div region="center" title="新闻菜单">
		<div class="menus">
			<a href="javascript:void(0)" id="btnAdd" class="easyui-linkbutton"
				iconCls="icon-add" plain="true">新增</a> <a href="javascript:void(0)"
				id="btnUnRec" class="easyui-linkbutton" iconCls="icon-no"
				plain="true">删除</a>
		</div>
		<div id="list"></div>
	</div>


	<div id="win"
		style="padding: 5px; width: 750px; height: 350px; overflow: hidden"
		class="easyui-window" closed="true" modal="true" maximized='false'>
		<iframe name="iframe" id="iframe" scrolling="yes" frameborder="0"
			style="width: 100%; height: 100%;"></iframe>
	</div>

</body>
</html>
