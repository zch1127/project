<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>展示所有提现红包</title>

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


<link href="<%=basePath%>um/themes/default/css/umeditor.css"
	type="text/css" rel="stylesheet">
<script type="text/javascript"
	src="<%=basePath%>um/third-party/template.min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="<%=basePath%>um/umeditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="<%=basePath%>um/umeditor.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>um/lang/zh-cn/zh-cn.js"></script>

<script type="text/javascript" src="<%=basePath%>js/common/common.js"></script>
<script type="text/javascript">
	//展示已提现红包
	$(function(){
	
		$("#selectAllRedPacketReceive").datagrid({
			
			loadMsg:'数据加载中,请稍后...',
			title:'展示所有提现红包',
			pageNumber:1,
			pageSize: 5,//每页显示的记录条数，默认为10    
            pageList: [5, 10, 20],//可以设置每页记录条数的列表    
            beforePageText: '跳转到',//页数文本框前显示的汉字    
            afterPageText: '页    共 {pages} 页',  
            displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',
			pagination: true,//显示分页栏
			toolbar:"#toolbar",
		 	url:"${pageContext.request.contextPath}/activity/selectAllRedPacketReceive?isRemit=0",
	    	columns:[[
	    	{field:"",title:"",checkbox:true},    
	        {field:'id',title:'提现红包id',width:100,hidden:true},    
	        {field:'userName',title:'用户昵称',width:100},    
	        {field:'receiveTime',title:'领取时间',width:100},    
	        {field:'getFaceValue',title:'金额',width:100},   
	        {field:'withDrawAccount',title:'提现账户',width:100},   
	        {field:'useType',title:'使用方式',width:100,formatter: function(value,row,index){
				if (value==1){
						return "提现";
					} else {
						return "其他";
					}
				}
	        } ,
	        {field:'isRemit',title:'是否已打款',width:100,formatter: function(value,row,index){
		        	//alert(value);
		        	if (value==0){
							return "未打款";
					} 
				}
				 
	        
	        }
	        
	        
	        ]],
	       }); 
	});
	function remit(){
		var data = $("#selectAllRedPacketReceive").datagrid("getSelections");
		if(data.length==0){
			alert("请选择要打款的用户");
		}else{
			var ids = new Array(data.length);
			$.each(data,function(index,value){
				ids[index]=data[index].id;
			});
			console.info(ids);
			$.messager.confirm('打款信息','确认要打款吗',function(r){
			if(r){
				//发送Ajax请求执行删除操作
				$.ajax({
						url:"${pageContext.request.contextPath}/activity/remit",
						data:"idss="+ids,
						method:"POST",
						success:function(data){
						console.info(data);
							var isdel = JSON.parse(data);
							if(isdel){
								$.messager.show({
									title:'打款消息',
									msg:'打款成功',
									showType:'show',
								});
				        	
							$("#selectAllRedPacketReceive").datagrid('reload');
							}else{
							$("#selectAllRedPacketReceive").datagrid('reload');
								$.messager.show({
									title:'打款消息',
									msg:'打款失败',
									showType:'show',
								});
							}
						},
						dataType:"json"				
					});
				}
			});
		}
	}
	//未打款
	function reloadd(){
		//window.location.reload();
		$(function(){
	
		$("#selectAllRedPacketReceive").datagrid({
			
			loadMsg:'数据加载中,请稍后...',
			title:'展示所有提现红包',
			pageNumber:1,
			pageSize: 5,//每页显示的记录条数，默认为10    
            pageList: [5, 10, 20],//可以设置每页记录条数的列表    
            beforePageText: '跳转到',//页数文本框前显示的汉字    
            afterPageText: '页    共 {pages} 页',  
            displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',
			pagination: true,//显示分页栏
			toolbar:"#toolbar",
		 	url:"${pageContext.request.contextPath}/activity/selectAllRedPacketReceive?isRemit=0",
	    	columns:[[
	    	{field:"",title:"",checkbox:true},    
	        {field:'id',title:'提现红包id',width:100,hidden:true},    
	        {field:'userName',title:'用户昵称',width:100},    
	        {field:'receiveTime',title:'领取时间',width:100},    
	        {field:'getFaceValue',title:'金额',width:100},   
	        {field:'withDrawAccount',title:'提现账户',width:100},   
	        {field:'useType',title:'使用方式',width:100,formatter: function(value,row,index){
				if (value==1){
						return "提现";
					} else {
						return "其他";
					}
				}
	        } ,
	        {field:'isRemit',title:'是否已打款',width:100,formatter: function(value,row,index){
		        	//alert(value);
		        	if (value==0){
							return "未打款";
					} 
				}
				 
	        
	        }
	        
	        
	        ]],
	       }); 
	});
	}
	//已打款
	function repalceUrl(){
		//window.location.replace("${pageContext.request.contextPath}/activity/selectAllRedPacketReceive?isRemit=1");
		
		$(function(){
			
			$("#selectAllRedPacketReceive").datagrid({
				
				loadMsg:'数据加载中,请稍后...',
				title:'展示所有提现红包',
				pageNumber:1,
				pageSize: 5,//每页显示的记录条数，默认为10    
		           pageList: [5, 10, 20],//可以设置每页记录条数的列表    
		           beforePageText: '跳转到',//页数文本框前显示的汉字    
		           afterPageText: '页    共 {pages} 页',  
		           displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',
				pagination: true,//显示分页栏
				toolbar:"#toolbar",
			 	url:"${pageContext.request.contextPath}/activity/selectAllRedPacketReceive?isRemit=1",
		    	columns:[[
		    	   
		        {field:'id',title:'提现红包id',width:100,hidden:true},    
		        {field:'userName',title:'用户昵称',width:100},    
		        {field:'remitTime',title:'打款时间',width:100},    
		        {field:'getFaceValue',title:'金额',width:100},   
		        {field:'withDrawAccount',title:'提现账户',width:100},   
		        {field:'useType',title:'使用方式',width:100,formatter: function(value,row,index){
					if (value==1){
							return "提现";
						} else {
							return "其他";
						}
					}
		        } ,
		        {field:'isRemit',title:'是否已打款',width:100,formatter: function(value,row,index){
			        	//alert(value);
			        	if (value==1){
								return "已打款";
						} 
					}
					 
		        
		        }
		        ]],
		       }); 
	});
	$("#toolbar").attr("style","display:none;");
	}
</script>
</head>

<body>
	<div>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="reloadd()">未打款</a>&nbsp;&nbsp;|&nbsp;&nbsp;
	<a href="javascript:void(0)" onclick="repalceUrl()">已打款</a></div><br><hr>
	<div>已提现红包&nbsp;&nbsp;|&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/activity/showAllRedPacket?activityStatus=1" >现金红包</a></div>
	
	 <table id="selectAllRedPacketReceive">
	 	<div id="toolbar">
    		<a href="javascript:void(0)" class="easyui-linkbutton" onClick="remit();" data-options="iconCls:'icon-add'">批量打款</a>
    	</div>
	 </table>
</body>
</html>
