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
		  $( "#newDialog" ).dialog({
		  	closed: true,
		  });
	})
	//改价
	function updatePrice(){
		alert("未完待续");
		window.location.href="";
	}
	//提醒顾客付款
	function remindCustomer(){
		alert("未完待续");
	}
	//修改顾客留言
	function updateLan(){
		alert("修改留言");
	}
	//修改地址
	function updateAddress(){
		alert("修改收货地址信息");
	}
	 function delivery() {
	 	$( "#newDialog" ).dialog({
	 		closed:false,
	 		title:"发货",
	 	});
	 };
	//添加发货信息前 先去验证物流单号是否正确
	function deleiveryGoods(){
		//验证物流单号  
		var url="http://60.205.152.224:8091/buddha-api/logistics/judgment";
		var password=$("#newNumber").val();
		$.ajax({
			url:"${pageContext.request.contextPath}/order/validationCorp",
			data:"corpNumber="+password+"&url="+url,
			dataType:"json",
			success:function(data){
				//console.log(data.result.object);
				if(data.result.object.length==0){
					$.messager.alert("温馨提示","物流单号错误,请重新输入","warning");
				}else{
					//获取到返回的数据
					var kdCode = data.result.object[0].comCode;
					//选中的快递公司的id  根据id去获取到公司的代码
					var id =$("#logisticsId").val();
					$.ajax({
						url:"${pageContext.request.contextPath}/logistics/selectByid",
						data:"id="+id,
						dataType:"json",
						success:function(data){
							console.log(data.logistics.corpCode);
							var Code = data.logistics.corpCode;
							if(Code == kdCode){
								$("#deliver").form("submit",{
									url:"${pageContext.request.contextPath}/order/addOrderDelivery",
									dataType:"JSON",
									success:function(data){
										if(data){
											alert("发货成功");
											//window.location.href="${pageContext.request.contextPath}/order/searchDetailOrderByOrderSn?orderSn="+orderSn;
											//$("#deliver").form("reset");//表单数据重置
										}
									}
								});
							}else{
								$.messager.alert("温馨提示","请确认物流单号和对应的物流公司名字","warning");
							}
						}
					});
				}
			}
		});
	}
	function quit(){
		$("#newDialog").dialog({
			closed:true
		});
		$("#deliver").form("reset");
	}
	function showDel(id){
		//利用ajax在页面加载完成时去请求数据
		$.ajax({
			url:"${pageContext.request.contextPath}/order/queryDelivery",
			data:"id="+id,
		//	data:{url:"http://60.205.152.224:8091/buddha-api/logistics/record",corpCode:"shentong",corpNumber:"3345608996596"},
			dataType:"json",
			success:function(data){
				$("#showDel").html("");
				$("#showDel").append("物流单号:"+data.result.object.nu+"<br>物流公司:"+data.corp+"<br>物流费用:无<br>物流详情:<br>");
				var dd = data.result.object.data;
				$.each(dd,function(index,dd){
				//将查询出的数据填充到select 标签下面
					$("#showDel").append(dd.time+""+dd.context+"<br>");	
				});
			}
		});
	}
	//返回
	function returnDetailOrder(){
		window.location.href="${pageContext.request.contextPath}/order/toOrder";
	}
	
</script>
</head>
<body>
	<div style="width: 90%;height: 85%" id="newDiv">
	<h1 align="center">订单详情</h1>
		<div id="dd">
			<table id="newTable" style="width:100%">
    			<c:forEach items="${list }" var="pro">
    				<tr>	
    					<td>订单编号：${pro.orderSn }</td><td>用户名：${pro.receiptPersonName }</td><c:if test="${pro.orderStatus == 0}">
    					<td style="color: red">当前状态：待付款</td><td colspan="2" align="center"><a href="javascript:void(0);" onclick="updatePrice()"/>改价</a>&nbsp;&nbsp;&nbsp;<a href="javascript:void(0);" onclick="remindCustomer()"/>提醒买家付款</a></td>
    					</c:if> 
    					<c:if test="${pro.orderStatus == 1}">
    					<td style="color: red">当前状态：待发货</td><td colspan="2" align="center"><a href="javascript:void(0);" onclick="delivery('${pro.orderSn }')"/>发货</a></td>
    					</c:if>
    					<c:if test="${pro.orderStatus == 2}">
    					<td style="color: red">当前状态：已发货 </td><td colspan="2" align="center"><a href="javascript:void(0);" onclick="updatePrice()"/>完成</a></td>
    					</c:if>
    					<c:if test="${pro.orderStatus == 3}">
    					<td style="color: red">当前状态：待评价</td>
    					</c:if>
    					<c:if test="${pro.orderStatus == 4}">
    					<td style="color: red">当前状态：已完成</td>
    					</c:if>
    					<c:if test="${pro.orderStatus == 5}">
    					<td style="color: red">当前状态：交易关闭</td>
    					</c:if>
    				</tr>		
	        		<tr>
	        			<td style="width: 20%"><h3>商品图片</h3></td>
	        			<td style="width: 20%"><h3>商品名称</h3></td>
	        			<td style="width: 20%"><h3>单价</h3></td>
	        			<td style="width: 20%"><h3>数量</h3></td>
	        			<td style="width: 20%"><h3>金额小计</h3></td>
	        		</tr>
    				<c:forEach items="${pro.orderDetail }" var="orderDetail">
    					<tr>
    						<td><img src="${orderDetail.imgUrl }" alt='商品图片' width='50' height='50'></td><td>${orderDetail.productName }</td><td>￥${orderDetail.productPrice }</td><td>${orderDetail.productNum }</td><td>￥${orderDetail.productSubtotal }</td></tr>
    					</tr>
    				</c:forEach>
	    			<tr><td colspan="4"></td><td>商品金额：${pro.totalProductPrice }</td></tr>
	    			<tr><td colspan="4"></td><td>配送费用：0.0</td></tr>
	    			<tr></tr>
	    			<tr><td colspan="4"></td><td>应付金额：${pro.totalAmount }</td></tr>
	    			<tr><td>卖家备注：无</td><td align="left"><a href="javascript:void(0);" onclick="updateLan()"/>修改</a></td></tr>
	    			<tr><td colspan="5">买家留言：无</td></tr>
	    			<tr><c:if test="${pro.paymentType ==0}"><td colspan="5">支付方式：支付宝</td></c:if>
	    				<c:if test="${pro.paymentType ==1}"><td colspan="5">支付方式：微信</td></c:if>
	    			</tr>
	    			<tr><h1>收货信息</h1></tr>
	    			<tr><td>收货人：${pro.receiptPersonName}</td></tr>
	    			<tr><td>手机号码：${pro.receiptPersonMobile}</td></tr>
	    			<tr><td>收获地址：${pro.receiptArea}</td><td align="left"><a href="javascript:void(0);" onclick="updateAddress()"/>修改</a></td></tr>
	    			<tr><td><a href="javascript:void(0);" onclick="returnDetailOrder()"/><h3>返回</h3></a></td></tr>
    			</c:forEach>
    			<hr>
			</table>
		</div>
		<c:forEach items="${list }" var="pro">
			<div id="newDialog" >
				<form id="deliver" method="post">
				
				<input type="hidden" value="${pro.orderSn }" id="number1">
	   			<input type="hidden"  name="userId" value="${pro.userId }"/>
			   <c:forEach items="${pro.orderDetail }" var="orderDetail"   varStatus="stas" >
	                    <c:if test="${stas.index==0    }">
	                        <input type="hidden"  name="productName" value="${orderDetail.productName }"/>
	                     </c:if>
				</c:forEach>
					<div style="margin-top: 10px;margin-left: 5px;"><h3>订单：${pro.orderSn }</h3></div>
					<table style="margin-top: 10px;margin-left: 50px;" align="center">
						<tr>
							<td>订单：${pro.orderSn }</td><td><input type="hidden" name="orderMasterId" value="${pro.id}"></td>
							<td>下单时间：${pro.createDate }</td>
						</tr>
						<tr>
							<td>物流公司：<input id="logisticsId" name="logisticsId" class="easyui-combobox" data-options="
						    		valueField:'id',
						    		textField:'logisticsName',
						    		url:'${pageContext.request.contextPath }/logistics/selectAllLogistics'
						    		" /></td>
						    <td><input type="hidden" /></td>		
							<td>物流单号：<input type="text" name="logisticsNumber" id="newNumber" /></td>
						</tr>
						<tr>
							<td>退货地址：北京市朝阳区大望路</td>
							 <td><input type="hidden" /></td>
							<td>配送费用：0.0</td>
						</tr>
						<tr>
							<td colspan="2">发货备注：<textarea cols="20" rows="3" name="remark"></textarea></td>
						</tr>
						<tr>
							<td align="right"><input type="button" value="确认发货" onclick="deleiveryGoods()"></td>
							<td><input type="hidden" /></td>
							<td align="left"><input type="button" value="取消" onclick="quit()"></td>
						</tr>
					</table>	
				</form>
			</div>
		</c:forEach>
		<c:forEach items="${list }" var="pro">
			<c:if test="${pro.orderStatus == 2 || pro.orderStatus == 3}">
			<input type="button" value="查看物流信息" onclick="showDel('${pro.id}')">
				<h3>
					<div id="showDel">
					</div>
				</h3>
				
			</c:if>
		</c:forEach>	
	
		
	</div>
	
	
		
</body>
</html>
