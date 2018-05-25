<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>添加红包</title>

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
	function cancle1(){
		window.location.href="${pageContext.request.contextPath}/activity/showAllRedPacket?activityStatus=1";
	}
	function publish(){
		alert();
		$('#addForm').form('submit', {
			url:"${pageContext.request.contextPath}/activity/updateRedPacket",
			dataType:"json",
			onSubmit: function(){
				var isValid = $(this).form('validate');
				/* if (!isValid){
					
				}
				return isValid;	// 返回false终止表单提交 */
				return true;
				
			},
			success: function(){
				var isins = JSON.parse(data);
		         //alert(isins);
		        if(isins){
					$.messager.show({
						title:'添加消息',
						msg:'添加成功',
						showType:'show',
					});
		        }else{
			        $.messager.show({
							title:'添加消息',
							msg:'添加失败',
							showType:'show',
					});
		        }    
			}
		});


	}
	function check(form){
		
	}
	function checkFaceValue(value){
    //这里就不做兼容了
    
        var cfv=/(?!^0\.0?0$)^[0-9][0-9]?(\.[0-9]{1,2})?$|^100$/;
        if(!cfv.test(value)){
           alert("请输入大于0的整数或者保留两位有效小数");
        }
    
	}
</script>
</head>

<body>

	<h3>现金红包列表>>编辑红包</h3><br>
	<form action="javascript:void(0)" id="addForm" method="post">
		<input type="hidden" name="id" value="${redPacket.id}">
		红包名称：<input type="text" name="redPacketName" value="${redPacket.redPacketName}"><br/><br/>
		活动时间：<input id="d1" type="text" name="startTimeStr" value="${redPacket.startTime}"> —— <input type="text" id="d2" name="endTimeStr" onblur="compareD1ToD2()" value="${redPacket.endTime }"><br/><br/>
		随机红包面额：<input id="minFaceValue" type="text" name="minFaceValue" value="${redPacket.minFaceValue }" onblur="checkFaceValue(this.value)"> —— <input type="text" id="maxFaceValue" name="maxFaceValue" onblur="checkFaceValue(this.value)" value="${redPacket.maxFaceValue }"><br/><br/>
		预计发放总金额：<input type="text" name="predictAmount" value="${redPacket.predictAmount }"><br/><br/>
		<input type="button" value="取消" onclick="cancle1()">&nbsp; 
		<input type="submit" value="确定发布" onclick="publish()">
	</form>
</body>
</html>
