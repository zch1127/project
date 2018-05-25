<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>商品修改</title>

<script type="text/javascript" src="<%=basePath%>js/common/constants.js"></script>

<link rel="stylesheet" type="text/css"
	href="<%=basePath%>easyui/css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>easyui/css/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>easyui/css/demo.css">

<script type="text/javascript"
	src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>easyui/js/jquery.easyui.min.js"></script>

<script type="text/javascript"
	src="<%=basePath%>easyui/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	/*页面初始化完成时 自动加载的数据 */
	$(function(){
		var picture = $("#picture").val();
		if(picture != ""){
			$("#imgPreview").attr('src', domain + picture);
		}
	
		var productTypeId = ${requestScope.product.productTypeId}
		$.ajax({
			url:"${pageContext.request.contextPath }/product/showType",
			dataType:"JSON",
			success:function(data){
				//
				$("#productTypeId").empty();
				$.each(data,function(index,data){
				//将查询出的数据填充到select 标签下面
					if(data.id == productTypeId){
						$("#productTypeId").append("<option selected='selected' value="+data.id+">"+data.name+"</option>");		
					}else{
						$("#productTypeId").append("<option value="+data.id+">"+data.name+"</option>");		
					}
				});
			}
		});
		var abbotId = ${requestScope.product.abbotId};
		$.ajax({
			url:"${pageContext.request.contextPath }/temple/selectAbbot",
			dataType:"JSON",
			success:function(data){
				//
				$("#abbotId").empty();
				$.each(data,function(index,data){
				//将查询出的数据填充到select 标签下面
					if(data.abbotId == abbotId){
						$("#abbotId").append("<option selected='selected' value="+data.abbotId+">"+data.abbotName+"</option>");				
					}else{
						$("#abbotId").append("<option value="+data.abbotId+">"+data.abbotName+"</option>");		
					}
				})
			}
		});
		var templeId =${requestScope.product.templeId};
		$.ajax({
			url:"${pageContext.request.contextPath }/temple/selectTemple?id="+abbotId,
			dataType:"JSON",
			success:function(data){
				$("#templeId").empty();
				$.each(data,function(index,data){
				//将查询出的数据填充到select 标签下面
					if(data.templeId == templeId){
						$("#templeId").append("<option selected='selected' value="+data.templeId+">"+data.templeName+"</option>");				
					}else{
						$("#templeId").append("<option value="+data.templeId+">"+data.templeName+"</option>");		
					}
				})
			}
		});
		//分类信息
		var productCategoryId =${requestScope.product.productCategoryId};
		$.ajax({
			url:"${pageContext.request.contextPath }/product/showCategory",
			dataType:"JSON",
			success:function(data){
				$("#productCategoryId").empty();
				$.each(data,function(index,data){
				//将查询出的数据填充到select 标签下面
					if(data.id == productCategoryId){
						$("#productCategoryId").append("<option selected='selected' value="+data.id+">"+data.name+"</option>");		
					}else{
						$("#productCategoryId").append("<option value="+data.id+">"+data.name+"</option>");		
					}
				})
			}
		});
		//是否包装
		var isPacking = ${requestScope.product.isPacking};
		if(isPacking ==1){
			$("#in1").html('是否包装：<input type="radio" id="isPacking" name="isPacking" checked="checked" value="1"/>是<input type="radio" name="isPacking" value="0" />否<br>'); 
		}else{
			$("#in1").html('是否包装：<input type="radio" id="isPacking" name="isPacking" value="1"/>是<input type="radio" name="isPacking" value="0" checked="checked"/>否<br>'); 
		}
		//是否包邮
		var isFreight = ${requestScope.product.isFreight};
		if(isFreight ==1){
			$("#in2").html('是否包邮：<input type="radio" id="isFreight" name="isFreight" checked="checked" value="1"/>是<input type="radio" name="isFreight" value="0" />否<br>'); 
		}else{
			$("#in2").html('是否包邮：<input type="radio" id="isFreight" name="isFreight" value="1"/>是<input type="radio" name="isFreight" value="0" checked="checked"/>否<br>'); 
		}
		//推荐
		var isRecommend =${requestScope.product.isRecommend};
		if(isRecommend ==1){
			$("#in3").html('店长推荐：<input type="radio" id="isRecommend" name="isRecommend" checked="checked" value="1"/>是<input type="radio" name="isRecommend" value="0" />否<br>'); 
		}else{
			$("#in3").html('店长推荐：<input type="radio" id="isRecommend" name="isRecommend" value="1"/>是<input type="radio" name="isRecommend" value="0" checked="checked"/>否<br>'); 
		}
		/*参数信息 集合 遍历循环*/
		var id=${requestScope.product.id};
		//alert(id);
		$.ajax({
			type:"GET",
			url:"${pageContext.request.contextPath }/product/selectProductAttribute",
			data:"id="+id,
			dataType:"JSON",
			success:function(data){
				$("#newAdd").empty();
				
				$.each(data,function(index,data){
					$("#newAdd").append("<input type='text' name='attrName' value="+data.attrName+" style='width: 100px' /><input type='text' name='attrValue' value="+data.attrValue+" style='width: 300px'/><br>");		
				})
			}
		});
		//商品图片
		$.ajax({
			type:"GET",
			url:"${pageContext.request.contextPath }/product/selectImgJson",
			data:"id="+id,
			dataType:"JSON",
			success:function(data){
				//console.log(data);
				$("#newSpan").empty();
				$.each(data,function(index,data){
					$("#newSpan").append("<img src="+domain+data.sourceImg+" alt='商品图片' width='50' height='50'>");
				})
			}
		})
		//商品详情图片
		$.ajax({
			type:"GET",
			url:"${pageContext.request.contextPath }/product/selectDatailImgJson",
			data:"id="+id,
			dataType:"JSON",
			success:function(data){
			console.log(data);
			//console.log(data);
				$("#newspan1").empty();
				$.each(data,function(index,data){
					$("#newspan1").append("<img src="+domain+data.sourceImg+" alt='商品图片' width='50' height='50'>");
				});
			}
		})
		
		$("#btnUpload").click(
			function() {
				// $("#imgWait").show();
				var formData = new FormData();
				formData.append("upfile",
						document.getElementById("file").files[0]);
				$.ajax({
					url : "upload/pictrue",
					type : "POST",
					data : formData,
					/**
					 * 必须false才会自动加上正确的Content-Type
					 */
					contentType : false,
					/**
					 * 必须false才会避开jQuery对 formdata 的默认处理 XMLHttpRequest会对
					 * formdata 进行正确的处理
					 */
					processData : false,
					success : function(data) {
						console.log(data);
						$.messager.show({
							title : "系统消息",
							msg : data.message
						});
						$("#imgPreview").attr("src",
								domain  + data.object);
						$("#picture").val(data.object);
					},
					error : function() {
						alert("上传失败！");
						$("#imgWait").hide();
					}
				});
			});
	})
	
	/*添加图片*/
	function addTr(){
		var ins = $("input[name='fileName']");
		if(ins.length>4){
			$.messager.alert("提示","最多添加五张图片","warning");
		}else{
			$("#newSpan").append('<br><img id="imgPreview"/><input id="file" name="fileName" type="file" />');
		}
	}	
	/*添加商品详情图片 */	
	function addPicture(){
		$("#newspan1").append('<br><img id="imgPreview1"/><input id="file" name="fileNamePro" type="file" />');
	} 
	//添加参数表格
	function addAttribute(){
		$("#newAdd").append('<input type="text" name="attrName" style="width: 100px" /><input type="text" name="attrValue" style="width: 300px"/><br>');
	}
	/*修改商品信息  */
	function updateProduct(){
		$("input[name='fileName']").each(function(index,item){
			if($(this).val()==""){
				$(this).remove();}
		 });
		 $("input[name='fileNamePro']").each(function(index,item){
			if($(this).val()==""){
				$(this).remove();}
		 });
		 $("input[name='attrName']").each(function(index,item){
			if($(this).val()==""){
				$(this).remove();}
		 });
		$("#updateProduct").form("submit",{
			url:"${pageContext.request.contextPath}/product/updateProduct",
			dataType:"json",
			success:function(data){
				if(data){
					alert("修改成功");
				}
			},
		});
	}
	function queryTemple(obj){
		var abbotId = obj;
		$.ajax({
			url:"${pageContext.request.contextPath }/temple/selectTemple?id="+abbotId,
			dataType:"JSON",
			success:function(data){
				//
				$("#templeId").empty();
				$.each(data,function(index,data){
				//将查询出的数据填充到select 标签下面
					if(data.id == abbotId){
						$("#templeId").append("<option selected='selected' value="+data.templeId+">"+data.templeName+"</option>");				
					}else{
						$("#templeId").append("<option value="+data.templeId+">"+data.templeName+"</option>");		
					}
				});
			}
		});
	}
	</script>

</head>

<body class="easyui-layout">
<div style="width:100%px; height:85%; overflow:auto;">
<!--文件上传需要设计提交方式为复式提交   enctype  -->
	<form method="post" enctype="multipart/form-data" id="updateProduct">
	
		<h3>商品信息</h3>
		<input type="hidden" name="id" value="${requestScope.product.id}"/>
		商品名称：<input type="text" name="name" value="${requestScope.product.name}" required="true"><br><br>
		商品编码：<input type="text" name="code" value="${requestScope.product.code}" required="true"><br><br>
		<div id="in1">
		是否包装：
		</div><br>	      
		包装费用：<input type="text" name="packPrice" id="packing" value="${requestScope.product.packPrice}"/><br><br>
		<div id="in2">
		是否包邮：
		</div>	
		<!-- 设置固定邮费  监测复选框状态   选中了 获取输入的值 -->
		运费设置：<input type="text" name="freightPrice"  id="money" value="${requestScope.product.freightPrice}" /><br><br>
		<h3>价格</h3>
		成本价格：<input type="text" name="costPrice" value="${requestScope.product.costPrice }"/><br><br>
		销售价格：<input type="text" name="sellPrice" value="${requestScope.product.sellPrice }" onblur="calculate()"/><br><br>
		原始价格：<input type="text" name="originalPrice" value="${requestScope.product.originalPrice }"/><br><br>
		销售利润：<input type="text" name="profitPrice" value="${requestScope.product.profitPrice }"/><br><br>
		库存数量：<input type="text" name="quantityNumber" value="${requestScope.product.quantityNumber }"/><br><br>
		<hr>
			<img id="imgPreview" width="150" /><br/>
			<input id="picture"  name="titleImg" type="text" hidden="1" value="${requestScope.product.titleImg }" />
			<input id="file" name="file" type="file" />
			<a id="btnUpload" href="#" class="easyui-linkbutton">上传图片</a>
		<br/><br>
		<div id="addTr">
			商品图片：
			<span id="newSpan">
			</span>
			<span id="newSpan11">
			</span>
			<br><input type="button" value="添加新的图片" onclick="addTr()"/>
		</div><br>
		<hr>
		<h3>基本信息</h3>
		住持信息：<select id="abbotId" onchange="queryTemple(this.value)" name="abbotId"></select><br><br>
		住持信息：<select id="templeId" name="templeId"></select><br><br>
		商品类目：<select id="productTypeId" name="productTypeId"></select><br><br>
		商品分类：<select id ="productCategoryId" name="productCategoryId"></select> <br><br>
		发货地址：<input type="text" value="${requestScope.product.areaAddress }" /><br><br>
		<div id="in3">
		店长推荐：
		</div>	
		规格参数：<!--如果用户点击了添加按钮，就把原来的数据给覆盖掉   -->	<br>
				<div id="newDiv">
					<span id="newAdd">
					</span>
					<input type="button" value="添加" onclick="addAttribute()"/><br>
				</div>
				<br><br>
		商品详情：<div id="addPicture">
					<span id="newspan1">
					</span>
					<%-- <input type="hidden" name="productImgJson" id="imgPro" value="${requestScope.product.productImgJson }"/> --%>
					<br><br><input type="button" value="添加新的图片" onclick="addPicture()"/>
				</div><br>
		
		<br><input type="button" value="修改" onclick="updateProduct()"><br>
	</form>
</div>
</body>
</html>
