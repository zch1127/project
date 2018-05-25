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
	
	function check(form){
		
	}
	function checkFaceValue1(value){
    //这里就不做兼容了
    
        var cfv=/(?!^0\.0?0$)^[0-9][0-9]?(\.[0-9]{1,2})?$|^100$/;
        if(!cfv.test(value)){
           alert("请输入大于0的整数或者保留两位有效小数");
        }
    
	}
	function checkFaceValue2(value){
   
    	
        var cfv=/(?!^0\.0?0$)^[0-9][0-9]?(\.[0-9]{1,2})?$|^100$/;
          if(!cfv.test(value)){
           alert("请输入大于0的整数或者保留两位有效小数");
        }
        var a = document.getElementById("minFaceValue").value;
    	var b = document.getElementById("maxFaceValue").value;
    	var c = a-b;
		if(!cfv.test(value)){
           alert("请输入大于0的整数或者保留两位有效小数");
        }
       	if(c>0){
       	
			alert("红包最大面额应大于最小面额");
		}
        
        
	}
	
	
	function check(){
		var date1=$("#d1").val();
	 	var date2=$("#d2").val();
	 	var cfv=/(?!^0\.0?0$)^[0-9][0-9]?(\.[0-9]{1,2})?$|^100$/;
	 	var a =$("#minFaceValue").val();
	    var b = $("#maxFaceValue").val();
	 	if(date1>=date2){
	 		alert("开始日期不能大于结束日期");
	 		return false;
	 	}else{
		 	
	    	var c = a-b;
			if(!cfv.test(a)){
	           alert("请确认最小红包金额的面值");
	           return false;
	        }else{
		        
				if(!cfv.test(b)){
		           alert("请确认最大红包金额的面值");
		           return false;
	        	}else{
		        
			       	if(c>0){
			       	
					alert("请确认红包最大面额大于最小面额");
					return false;
					}else{
		 				return true;
			
						}
	        		}
	        	}
	 	}
	}
	
	
</script>
</head>

<body>

	<h3>现金红包列表>>添加红包</h3><br>
	<form action="${pageContext.request.contextPath}/activity/addRedPacket" onsubmit="return check();" id="addForm" method="post">
		红包名称：<input type="text" name="redPacketName"><br/><br/>
		活动时间：<input id="d1" type="text" name="startTimeStr" class="easyui-datetimebox" data-options="required:true" > —— <input type="text" id="d2" name="endTimeStr" 
		class="easyui-datetimebox" data-options="required:true"><div id="datemsg"></div><br/><br/>
		随机红包面额：<input id="minFaceValue" type="text" name="minFaceValue" onblur="checkFaceValue1(this.value)"> 至 <input type="text" id="maxFaceValue" name="maxFaceValue" onblur="checkFaceValue2(this.value);">元<br/><br/>
		预计发放总金额：<input type="text" name="predictAmount"><br/><br/>
		<input type="button" value="取消" onclick="cancle1()">&nbsp; 
		<input type="submit" value="确定发布">
	</form>
</body>
</html>
