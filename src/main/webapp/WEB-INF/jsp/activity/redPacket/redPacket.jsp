<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<title>现金红包列表</title>

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
	
	function selectByStu(){
		
		var activityStatus=$("#sta").val();
		alert("进入状态查询");
		window.location.href="${pageContext.request.contextPath}/activity/showAllRedPacket?activityStatus="+activityStatus;
	}
	function addRedPacket(){
		alert("开始创建红包");
		window.location.href="${pageContext.request.contextPath}/activity/toAddRedPacket";
	
	}
	//删除红包   
	function delRedPacket(id){
		alert(id);
		var activityStatus=$("#sta").val();
		var msg="";
		if(activityStatus!=1){
			msg = "您真的确定要删除吗？\n\n请确认！";
		}else{
			msg = "删除后活动将立即结束，并不可恢复!\n\n请确认！"
		}
		
		if (confirm(msg)==true){
			alert("执行删除");
			window.location.href="${pageContext.request.contextPath}/activity/deleteRedPacket?id="+id+"&activityStatus="+activityStatus;
			
		}else{
			var activityStatus=$("#sta").val();
			alert(activityStatus);
			window.location.href="${pageContext.request.contextPath}/activity/showAllRedPacket?activityStatus="+activityStatus;
		}
	}
	//编辑红包
	function updateRedPacket(id){
	
		var activityStatus=$("#sta").val();
		alert(id);
		window.location.href="${pageContext.request.contextPath}/activity/toUpdateRedPacket?id="+id+"&activityStatus="+activityStatus;
	}
	
	
	//展示已提现红包
	/* function changAShowDiv(){
		$("#showAllRedPacket").hiden();
		$("iframe").attr("src","${pageContext.request.contextPath}/activity/toAllRedPacketReceive?activityStatus=${activityStatus}&redPacketId=${redPacket.id}");
	} */
</script>

</head>
<body>
		<h3>现金红包列表</h3><br/>
		<input type="button" onclick="addRedPacket()" value="新建红包"><br/><br/>
	
		<div style="width:100px; height:40px;">
			<select onchange="selectByStu()" style="width: 80px;height: 30px; color: orange;" id="sta">
				<c:if test="${activityStatus ==0}">
					<option  selected="selected" value="0">未开始</option>
					<option value="1" >已开始</option>
					<option value="2" >已结束</option>
				</c:if>
				<c:if test="${activityStatus ==1}">
					<option selected="selected" value="1">已开始</option>
					<option value="0" >未开始</option>
					<option value="2" >已结束</option>
				</c:if>
				<c:if test="${activityStatus ==2}">
					<option selected="selected" value="2">已结束</option>
					<option value="0" >未开始</option>
					<option value="1" >已开始</option>
				</c:if>
			</select>
		</div>
		<hr>
		<!-- 展示所有红包 -->
		<!-- <div id="showRedPacketWithDraw">
			 <iframe src="javascript:void(0)"></iframe>
		</div> -->
		<div id="showAllRedPacket">
		<c:if test="${list.size()>0}">
			
		<table border="1">
			<tr>
				<th STYLE="white-space: nowrap;">红包名称</th>
				<th STYLE="white-space: nowrap;">活动时间</th>
				<th STYLE="white-space: nowrap;">红包面额￥</th>
				<th STYLE="white-space: nowrap;">预计发放总金额￥</th>
				<th STYLE="white-space: nowrap;">已领取总金额￥</th>
				<th STYLE="white-space: nowrap;">已领取（人）</th>
				<th STYLE="white-space: nowrap;">已提现（人）</th>
				<th STYLE="white-space: nowrap;">状态</th>
				<th STYLE="white-space: nowrap;">操作</th>
			</tr>
			<c:forEach items="${list}" var="redPacket">
			<tr>
				<td style="display: none;" id="rpId">${redPacket.id}</td>
				<td>${redPacket.redPacketName }</td>
				<td>${redPacket.startTime }至<br/>
					${redPacket.endTime }</td>
				<td >${redPacket.minFaceValue }~${redPacket.maxFaceValue }</td>
				<td align="center">${redPacket.predictAmount }</td>
				<td align="center">${redPacket.receiveAmount }</td>
				<!-- <td align="center">${redPacket.receivePeoples }</td> -->
				<td align="center">
				<c:if test="${redPacket.receivePeoples>0 }">
				<a href="${pageContext.request.contextPath}/activity/toAllRedPacketReceive?activityStatus=${activityStatus}&redPacketId=${redPacket.id}"  onclick="changAShowDiv()">${redPacket.receivePeoples }</a>
				</c:if>
				<c:if test="${redPacket.receivePeoples==0}">
					${redPacket.withDrawPeoples }
				</c:if>
				</td>
				<td align="center">
				<c:if test="${redPacket.withDrawPeoples>0 }">
				<a href="${pageContext.request.contextPath}/activity/toAllRedPacketReceive?activityStatus=${activityStatus}&redPacketId=${redPacket.id}"  onclick="changAShowDiv()">${redPacket.withDrawPeoples }</a>
				</c:if>
				<c:if test="${redPacket.withDrawPeoples==0}">
					${redPacket.withDrawPeoples }
				</c:if>
				</td>
				<c:if test="${redPacket.activityStatus==0 }">
					<td align="center" STYLE="white-space: nowrap;"  >未开始</td>
				</c:if>
				<c:if test="${redPacket.activityStatus==1 }">
					<td align="center" STYLE="white-space: nowrap;">已开始</td>
				</c:if>
				<c:if test="${redPacket.activityStatus==2 }">
					<td align="center" STYLE="white-space: nowrap;">已结束</td>
				</c:if>
				
				<td align="center" STYLE="white-space: nowrap;">
				<c:choose>
				<c:when test="${redPacket.activityStatus==2 }">
					<input type="button" onclick="updateRedPacket(${redPacket.id})" disabled="disabled" value="编辑">&nbsp;
				</c:when>
				<c:otherwise>
					<input type="button" onclick="updateRedPacket(${redPacket.id})"  value="编辑">&nbsp;
				</c:otherwise>
				</c:choose>
				<input type="button" onclick="delRedPacket(${redPacket.id})" value="删除"></td>
			
			</tr>
			</c:forEach>
		</table>
		</c:if>
		</div>
		<c:if test="${list.size()==0}">
			<h3>还没有相关数据</h3>
		</c:if>
</body>
</html>
