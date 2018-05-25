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

<title>售后订单管理</title>

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


	//根据订单状态查询
	function selectByStu(){
		var approveStatus=$("#cc").val();
		alert("进入订单条件查询");
		window.location.href="${pageContext.request.contextPath}/refund/selectAllOrderRefundByStatus?approveStatus="+approveStatus;
	
	}
	/* $(function(){
	
		var approveStatus=$("#cc").val();
		
		$("#refundOrderTable").datagrid({
			loadMsg:'数据加载中,请稍后...',
			title:'展示退款订单',
			pageNumber:1,
			pageSize:5,//每页显示的记录条数，默认为10    
            pageList:[5, 10, 20],//可以设置每页记录条数的列表    
            beforePageText:'跳转到',//页数文本框前显示的汉字    
            afterPageText:'页    共 {pages} 页',  
            displayMsg:'当前显示 {from} - {to} 条记录   共 {total} 条记录',
			pagination:true,//显示分页栏
			metod:"POST",
		 	url:"${pageContext.request.contextPath}/refund/selectAllOrderRefundByStatus",
		 	 queryParams:{          
                approveStatus: approveStatus            
              },  
	    	columns:[[    
	        {field:'id',title:'提现红包id',width:100,hidden:true},    
	        {field:'userName',title:'用户昵称',width:100},    
	        {field:'useTime',title:'使用时间',width:100},    
	        {field:'getFaceValue',title:'金额',width:100},   
	        {field:'useType',title:'使用方式',width:100,formatter: function(value,row,index){
				if (value==1){
						return "提现";
					} else {
						return "其他";
					}
				}
	        } 
	        
	        ]], 
	       }); 
		});*/
	

	function slelectById(id){
		//alert(id);
		window.location.href="${pageContext.request.contextPath}/refund/selectRefundItemById?id="+id;
	
	}
	function addRecordAndUpdateRefund(id){
		//alert(id);
		    //是否退款
		    	if(confirm("是否退款给买家？")) {
				    window.location.href="${pageContext.request.contextPath}/refund/addRecordAndUpdateRefund?id="+id+"&approveStatus=3";//同意退款
				    alert("退款成功");
				} else {
				   window.location.href="${pageContext.request.contextPath}/refund/addRecordAndUpdateRefund?id="+id+"&approveStatus=2";//拒绝退款
				    alert("退款失败");
				}
	/* 	if(confirm("是否同意买家申请？")) {
		    alert("您已通过卖家申请"); 
		} else {
		    window.location.href="${pageContext.request.contextPath}/refund/addRecordAndUpdateRefund?id="+id+"&approveStatus=2";//拒绝申请
		    alert("您拒绝了卖家申请");
		}*/
		
/* 	     $(".refund").on('click',function(){  
           $.mbox({  
               area: [ "450px", "auto" ], //弹框大小  
               border: [ 0, .5, "#666" ],  
               dialog: {  
                   msg: "是否同意买家申请",  
                   btns: 2,   //1: 只有一个按钮   2：两个按钮  3：没有按钮 提示框  
                   type: 1,   //1:对钩   2：问号  3：叹号    
                   btn: [ "同意", "拒绝"],  //自定义按钮  
                   yes: function() {  //点击左侧按钮：成功   
				        $.alert('退款成功');
                       window.location.href="${pageContext.request.contextPath}/refund/addRecordAndUpdateRefund?id="+id+"&approveStatus=3";//同意退款
                   },  
                   no: function() { //点击右侧按钮：失败  
                    $.alert('您已拒绝退款');
		        	window.location.href="${pageContext.request.contextPath}/refund/addRecordAndUpdateRefund?id="+id+"&approveStatus=2";//拒绝退款
                       return false;  
                   }  
               }  
           });  
        });  */
		 /*  $.confirm({
		    title: '退款信息',
		    content: '是否同意用户退款请求',
		    confirm: function(){
		     $.alert('退款成功');
		      $.confirm({
				    title: '确认退款',
				    content: '确认退款给买家',
				    confirm: function(){
				    	window.location.href="${pageContext.request.contextPath}/refund/addRecordAndUpdateRefund?id="+id+"&approveStatus=3";//同意退款
				        $.alert('退款成功');
				    },
				    cancel: function(){
				        $.alert('您取消了退款');
				    }
				}); 
		    },
		    cancel: function(){
		        $.alert('您已拒绝退款');
		        window.location.href="${pageContext.request.contextPath}/refund/addRecordAndUpdateRefund?id="+id+"&approveStatus=2";//拒绝退款
		    }
		});*/
			
		
	}
		
</script>

</head>
<body>
	<div style="width: 100%;height: 90%" id="newDiv">
	<h1 align="center">售后订单</h1>
		<div style="width:100px; height:40px;">
			<select onchange="selectByStu()" style="width: 80px;height: 30px; color: orange;" id="cc">
				<c:if test="${approveStatus ==0}">
					<option  selected="selected" value="0">申请中</option>
					<option value="4" >全部</option>
					<option value="2" >已拒绝</option>
					<option value="3" >已通过</option>
					<option value="5" >退款中</option>
				</c:if>
				<c:if test="${approveStatus ==2}">
					<option selected="selected" value="2">已拒绝</option>
					<option value="4" >全部</option>
					<option value="0" >申请中</option>
					<option value="3" >已通过</option>
					<option value="5" >退款中</option>
				</c:if>
				<c:if test="${approveStatus ==3}">
					<option selected="selected" value="3">已通过</option>
					<option value="4" >全部</option>
					<option value="0" >申请中</option>
					<option value="2" >已拒绝</option>
					<option value="5" >退款中</option>
				</c:if>
				<c:if test="${approveStatus ==4}">
					<option selected="selected" value="4">全部</option>
					<option value="0" >申请中</option>
					<option value="2" >已拒绝</option>
					<option value="3" >已通过</option>
					<option value="5" >退款中</option>
				</c:if>
				<c:if test="${approveStatus ==5}">
					<option selected="selected" value="5">退款中</option>
					<option value="0" >申请中</option>
					<option value="2" >已拒绝</option>
					<option value="3" >已通过</option>
					<option value="4" >全部</option>
				</c:if>
			
				<!--||approveStatus ==null||approveStatus ==''  -->
				
				
				
			</select>
			 
		</div>
		<br/>
		
		
		<!-- 根据条件进行查询 -->
		<form action="${pageContext.request.contextPath}/refund/selectRefundOrderByCon" method="post" id="searchForm">
			<input type="text" id="refundNo" placeholder="请输入订单编号" name="refundNo"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="text" id="productName" placeholder="请输入商品名字" name="productName"/><br/><br/>
			<select onChange="changeDiv()" id='nameOrPhone'>
				<option  value="name" selected="selected">收货人姓名</option>
				<option value="phone">收货人手机</option>
			</select><br/><br/>
			<div id="name" style="display:block;">
				<input type="text" id="name1" placeholder="请输入收货人姓名" name="receiptPersonName"/><br/><br/>
			</div>
			<div id="phone" style="display:none;">
				<input type="text" id="phone1" placeholder="请输入收货人手机" name="receiptPersonMobile"/><br/>
			</div>
			下单时间:<input type="text" id="startDate" placeholder="请输入下单时间" name="startCreateDate"/> --
			<input type="text" id="endDate" placeholder="请输入截止时间" name="endCreateDate"/><br/>
			
			<input type="submit"  value="搜索" />
		</form>
		<div id="dd">
			<table id="refundOrderTable" style="width:100%" >
        		<tr>
        			<td colspan="3" style="width: 40%"><h3>订单信息</h3></td>
        			<td colspan="2" style="width: 40%"><h3>收货信息</h3></td>
        			<td style="width: 20%"><h3>操作</h3></td>
        		</tr>
    			<c:forEach items="${list}" var="pro">
    			
    				<%--  <c:if test="pro!=null"> --%>
    				<tr>
    					<td width="23%" colspan="2">下单时间：${pro.createDate} </td><td width="23%">退款订单号：${pro.refundNo}</td>
    					<td>共${pro.productNum}件商品</td><td>合计：￥${pro.refundAmount}</td>
    					<c:if test="${pro.approveStatus == 0}">
    					<td style="color: red">申请中</td>
    					</c:if> 
    					<c:if test="${pro.approveStatus == 2}">
    					<td style="color: red">已拒绝</td>
    					</c:if>
    					<c:if test="${pro.approveStatus == 3}">
    					<td style="color: red">已通过</td>
    					</c:if>
    					
    					<c:if test="${pro.approveStatus == 5}">
    					<td style="color: red">退款中</td>
    					</c:if>
    				</tr>
    				<tr>
   						<td><img src="${pro.imgUrl}" alt='商品图片' width='80px' height='80px'></td>
   						<td >${pro.productName }</td>
   						<!-- style="white-space: nowrap;text-overflow: ellipsis;overflow: hidden;" -->
   						<td align="center">
   						￥${pro.productPrice }<br/>
   						×${pro.productNum }</td>
   				
   						<td colspan="2">${pro.receiptPersonName }  ${pro.receiptPersonMobile }<br/><br/>
   						${pro.receiptDetailedAddress }<br/><br/>
   						卖家备注:
   						<br/><br/>
   						</td>
    					<!-- 显示订单状态 -->
    					<c:if test="${pro.approveStatus == 0}">
    						<td><a href="javascript:void(0);" onclick="slelectById('${pro.id}')">订单详情</a>
    						<c:if test="${pro.refundType==0 }">
    						<!-- 退款之前进行确认 -->
    								<a href="javascript:void(0)"  class="refund"  onclick="addRecordAndUpdateRefund('${pro.id}')">退货退款</a>
    							</c:if>
    							<c:if test="${pro.refundType==1 }">
									<a href="javascript:void(0)" class="refund"  onclick="addRecordAndUpdateRefund('${pro.id}')">退款</a>
								</c:if> 
							</td>
    					</c:if>
    					<c:if test="${pro.approveStatus == 2||pro.approveStatus == 3}">
    						<td><a href="javascript:void(0);" onclick="slelectById('${pro.id}')">订单详情</a></td>
    						
    					</c:if>
    					<%--  <c:if test="${pro.approveStatus == 3}">
    						<td><a href="javascript:void(0);" onclick="slelectById('${pro.id}')">订单详情</a></td>
    						
    					</c:if> --%>
    					
    					<c:if test="${pro.approveStatus == 5}">
    						<td><a href="javascript:void(0);" onclick="slelectById('${pro.id}')">订单详情</a>
    						<c:if test="${pro.refundType==0 }">
    						<!-- 退款之前进行确认 -->
    								<a href="javascript:void(0)"  class="refund"  onclick="addRecordAndUpdateRefund('${pro.id}')">退货退款</a>
    							</c:if>
    							<c:if test="${pro.refundType==1 }">
									<a href="javascript:void(0)" class="refund"  onclick="addRecordAndUpdateRefund('${pro.id}')">退款</a>
								</c:if> 
							</td>
    					</c:if>
    				</tr>
    				<%-- </c:if> --%>
    			</c:forEach>
    			<hr>
			</table>
			
		
		</div>
	</div>	
	
</body>
</html>
<script type="text/javascript">
	function changeDiv(){
		var a= $("#nameOrPhone").val();
		console.log(a);
		if(a=="name"){
			$("#phone").css('display','none'); 
			$("#name").css('display','block'); 
		}else{
			$("#phone").css('display','block'); 
			$("#name").css('display','none'); 
		}
		
		
	}
	

/* 	function submitForm(){
		$("#searchForm").form("submit",{
			url:"${pageContext.request.contextPath}/refund/selectRefundOrderByCon",
			dataType:"JSON",
			success:function(data){
				
			}
		});
	} */
	
</script>