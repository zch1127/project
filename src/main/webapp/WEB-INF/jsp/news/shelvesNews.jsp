<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>新闻管理</title>

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
	var status = 3;
	$("#list").datagrid({
	    url: 'getNewsByPageAndStatus',
	    method: 'GET',
	    queryParams: { 'status': status },
	    striped: true,
	    fitColumns: true,
	    singleSelect: false,
	    pagination: true,
	    nowrap: false,
	    pageNumber:1,
	    pageSize: 10,
	    pageList: [10, 20, 50],
	    showFooter: true,
		columns : [ [
				{
					field : 'ck',
					checkbox : true,
					width : '30'
				},{
					field : 'newsid',
					title : '新闻主键',
					width : 70,
					sortable : true
				},{
					field : 'newsTitle',
					title : '新闻标题',
					width : 100,
					sortable : true
				},{
					field : 'newsIntroduction',
					title : '新闻简介',
					width : 300,
					sortable : true
				},{
					field : 'type',
					title : '新闻类型',
					width : 100,
					sortable : true,
					formatter : function(value, row, index) {
						if (value == 0) {
							return '壁纸';
						} else if (value == 1) {
							return '高僧大德';
						} else if (value == 2) {
							return '小型活动';
						} else if (value == 3) {
							return '大型活动';
						} else if (value == 4) {
							return '历史活动';
						} 
					}
				},{
					field : 'picture',
					title : '新闻图片',
					width : 150,
					sortable : true,
					height : 100,
					formatter : function(value, rowData, rowIndex) {
						return "<img src='"+ domain 
								+ value
								+ "' style='width:145px;height:90px'/>";
					}
				}, {
					field : 'publishDate',
					title : '开始日期',
					sortable : true,
					width : 100,
					formatter : function(value){
						var date = new Date(value);
					    var y = date.getFullYear().toString();
					    var m = (date.getMonth() + 1);
					    var d = date.getDate().toString();
					    return y + '-' + (m < 10 ? '0' + m : m) + '-' + (d < 10 ? '0' + d : d) ;
                    }
				},{
					field : 'status',
					title : '新闻状态',
					width : 100,
					sortable : true,
					formatter:function(value){
						if(value == 0){
							return "删除";
						} else if(value == 1){
							return "新发布";
						} else if(value == 2){
							return "下架";
						} else if(value == 3){
							return "上架";
						}
					}
				},{
						field : 'htmlUrl',
						title : 'HTML链接',
						width : 300,
						sortable : true
				} 
				] ],
	});
	$("#newSelect").change(function(){
		var status = $("#newSelect").val();
		$("#list").datagrid("load", {
				status :status
		});
		$("#newDiv").html("");
		if(status == 1 || status == 2){
			$("#newDiv").html('<input type="button" class="easyui-linkbutton" iconCls="icon-add" id="btnUnRec" onclick="upNews()" value="上架" />');
		}else if(status == 3){
			$("#newDiv").html('<input type="button" class="easyui-linkbutton" iconCls="icon-cut" id="btnUnRec" onclick="downNews()" value="下架" />');
		}
	})
	
});
// 批量操作
	function downNews() {
		var status = 3;
		var selRow = $('#list').datagrid('getSelections')
		// 判断是否选中行
		if (selRow.length == 0) {
			alert("请选择要下架的数据！！！");
			return;
		} else {
			var temID = "";
			// 批量获取选中行的评估模板ID
			for (i = 0; i < selRow.length; i++) {
				if (temID == "") {
					temID = selRow[i].newsid;
				} else {
					temID = selRow[i].newsid + "," + temID;
				}
			}
			$.messager.confirm('提示', '是否下架选中的数据?', function (r) { 
				if (!r) {  
                    return;  
                }
				$.ajax({
					url : 'updateNewsStatusByNewsid',
					data : {
						newsid : temID,
						status : status				
					},
					async : false,
					success : function(data) {
						var result = data;// data.message;
						$.messager.show({
							title : "系统消息",
							msg : result.message
						});
						if(result){
							$("#list").datagrid('reload');
						}
					}
				});
				
			})
		}
	};
	
	//上架
	function upNews() {
		var status = $("#newSelect").val();
		//alert(status);
		var selRow = $('#list').datagrid('getSelections')
		// 判断是否选中行
		if (selRow.length == 0) {
			alert("请选择要上架的数据！！！");
			return;
		} else {
			var temID = "";
			// 批量获取选中行的评估模板ID
			for (i = 0; i < selRow.length; i++) {
				if (temID == "") {
					temID = selRow[i].newsid;
				} else {
					temID = selRow[i].newsid + "," + temID;
				}
			}
			$.messager.confirm('提示', '是否上架选中的数据?', function (r) { 
				if (!r) {  
                    return;  
                }
				$.ajax({
					url : 'updateNewsStatusByNewsid',
					data : {
						newsid : temID,
						status : status				
					},
					async : false,
					success : function(data) {
						var result = data;// data.message;
						$.messager.show({
							title : "系统消息",
							msg : result.message
						});
						if(result){
							$("#list").datagrid('reload');
						}
					}
				});
				
			})
		}
	};
	

</script>
</head>

<body class="easyui-layout">

	<div region="center" title="新闻菜单">
		<br>
		<select id="newSelect" name="status" style="height: 22px;">
			<option value="1">新发布</option>
			<option value="2">下架</option>
			<option selected="selected" value="3">上架</option>
		</select>
		<br><br>
		<div class="menus" id="newDiv">
			<!-- <a href="javascript:void(0)"
				id="btnUnRec" class="easyui-linkbutton" iconCls="icon-no"
				plain="true" onClick="downNews">下架</a> -->
			<input type="button" class="easyui-linkbutton" iconCls="icon-cut" id="btnUnRec" onclick="downNews()" style="height: 22px; width: 50px;" value="下架" />
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
