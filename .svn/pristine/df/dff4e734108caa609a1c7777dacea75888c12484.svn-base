
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>商品添加</title>

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
	});
	
	/*添加商品信息  */
	function addProduct(){
		//文件非空判断
		$("input[name='fileName']").each(function(index,item){
			if($(this).val()==""){
				$(this).remove();}
		 	}
		 );
		 $("input[name='fileNamePro']").each(function(index,item){
			if($(this).val()==""){
				$(this).remove();}
		 	}
		 );
		 $("input[name='attrName']").each(function(index,item){
			if($(this).val()==""){
				$(this).remove();
			}
		 });
		var sts= $("#abbotId").val();
		$("#addProduct").form("submit",{
			url:"${pageContext.request.contextPath}/product/addProduct",
			dataType:"json",
			success:function(data){
				if(data){
					alert("添加数据成功");
				};
				$("#addBannerInformation").form("reset");
			}	
		})
	}
	/*计算利润  */
	function calculate(){
		/*只有当选择了包装  才计算包装的价格  */
		if($("input[name='isPacking']:checked").val()== "1"){
			var packcost = $("#packing").val();
		}else {
			var packcost = 0;
			$("input[name='isPacking']:checked").val(packcost);
		}
		if($("input[name='isFreight']:checked").val()== "1"){
			var freightcost = $("#money").val();
		}else{
			var freightcost = 0;
			$("input[name='isFreight']:checked").val(freightcost);
		}
		var cost= $("#costPrice").val();
		var sell = $("#sellPrice").val();
		var pro=sell-cost-packcost-freightcost;
		$("#profits").val(pro);	
		
	}
	
	/*添加图片  */
	function addTr(){
		var ins = $("input[name='fileName']");
		if(ins.length>4){
			$.messager.alert("提示","最多添加五张图片","warning");
		}else{
			$("#newSpan").append('<br><img id="imgPreview"/><input id="file" name="fileName" type="file" />');
		}
	}
	/*添加商品详情图片  */	
	function addPicture(){

		var id=id+1;
		var ins = $("input[name='fileNamePro']");
		if(ins.length>20){
			$.messager.alert("提示","最多添加二十张图片","warning");
		}else{
			$("#newspan").append('<br><img id="imgPreview1"/><input id="file" name="fileNamePro" type="file"/>');
		}
	} 
	//添加参数
	function addAttribute(){
		//alert("666");
		$("#newAdd").append('<input type="text" name="attrName" style="width: 100px" placeholder="参数名"/><input type="text" placeholder="参数值" name="attrValue" style="width: 300px"/><br>');
	}
	//二级联动添加寺院信息
	</script>
	<style>
	form#addProduct div {
	    margin-top: 5px;
	    margin-left: 20px;
	}
	.submit {
    color: white;
    font-weight: 900;
    background: #486f9f;
    margin-top: 10px;
    margin-left: 440px;
}
	input.easyui-linkbutton.l-btn.l-btn-small {
    font-size: 13px;
    padding: 3px 5px;
}
#file {
    width: 254px;
}
	</style>
</head>

<body class="easyui-layout">
<div style="width:90%px; height:85%; overflow:auto;">
<!--文件上传需要设计提交方式为复式提交   enctype  -->
	<form method="post" enctype="multipart/form-data" id="addProduct">
	
		<h3>商品信息</h3>
		<div>商品名称:<input type="text" name="name" style="width: 300px" required="true"><br></div>
		<div>商品编码:<input type="text" name="code" style="width: 300px" required="true"><br></div>
		<div onclick="showInput()">
		是否包装:<input type="radio" id="isPacking" name="isPacking" value="1"/>是
				<input type="radio" name="isPacking" value="0" checked="checked"/>否<br>
		</div>
			<div id="ip1">
				包装费用:<input type="text" name="packPrice" id="packing" value="0"/><br>
			</div>		
				<!-- 设置固定邮费  监测复选框状态   选中了 获取输入的值 -->
		<div>	
		是否包邮:<input type="radio"  name="isFreight" value="1"/>是
				<input type="radio" name="isFreight" value="0" checked="checked"/>否<br>
		</div>
			<div id="ip2">
				运费设置:<input type="text" name="freightPrice" style="width: 300px" id="money" value="0" /><br>
			</div>
		<div>成本价格:<input type="text" name="costPrice" style="width: 300px" value="0" id="costPrice" /><br></div>
		<div>销售价格:<input type="text" name="sellPrice" style="width: 300px" value="0" id="sellPrice" onblur="calculate()" /><br></div>
		<div>原始价格:<input type="text" name="originalPrice" style="width: 300px" value="0" id="originalPrice"/><br></div>
		<div>销售利润:<input type="text" name="profitPrice" style="width: 300px" value="0" id="profits"/><br></div>
		<div>库存数量:<input type="text" name="quantityNumber" style="width: 300px" placeholder="库存数量>=1" id="quantityNumber"/><br></div>
		<!--上传图片 点击上传图片 触发事件 上传图片 上传到指定的地址  获取到地址 在页面进行展示  -->
		<div>商品标题图片:</div>
		<div>
		<img id="imgPreview" width="150"  src="../images/defaultImg.jpg"/><br/>
			      <input id="picture"  name="titleImg" type="text" hidden="1" /> <input id="file"   name="file" type="file" /> 
			       <a id="btnUpload" href="#"   class="easyui-linkbutton">上传图片</a><br/>
		</div>
		<div>商品图片:</div>
		<div id="addTr()">
			<span id="newSpan">
				<img id="imgPreview"/><input name="fileName" type="file" />
			</span>
			<input type="button" value="更多图片"   class="easyui-linkbutton"   onclick="addTr()"/><br>
		</div>
		<hr>
		<h3>基本信息</h3>
		<div>主持信息:<input id ="abbotId" name="abbotId" class="easyui-combobox" data-options="
					method:'get',
					mode:'remote',
		    		valueField:'abbotId',
		    		textField:'abbotName',
		    		url:'${pageContext.request.contextPath }/temple/selectAbbot',
			        onSelect:function(rec){ 
	           			$('[comboname=templeId]').combobox('clear');  
	            		$('[comboname=templeId]').combobox('reload', '${pageContext.request.contextPath }/temple/selectTemple?id='+rec.abbotId);  
        			}"/><br>
        </div>
        <div>
		寺院信息:<input name="templeId" class="easyui-combobox" data-options="valueField:'templeId',textField:'templeName'" /></br>
	</div>
	<div>
		商品类目:<input name="productTypeId" class="easyui-combobox" data-options="
		    		valueField:'id',
		    		textField:'name',
		    		url:'${pageContext.request.contextPath }/product/showType'
		    		" /><br>
	  </div>
       <div>
		商品分类:<input name="productCategoryId" class="easyui-combobox" data-options="
		    		valueField:'id',
		    		textField:'name',
		    		url:'${pageContext.request.contextPath }/product/showCategory'
		    		" /><br>
		</div>
		<div>
		发货地址:<input type="text" name="areaAddress" value="北京"><br>	
		</div>	
		<!-- 单选框  是否   获取值，查询出当前类目下的推荐商品的数量，推荐商品数量不能超过5个 -->	
		<div id="tt" onclick="showIn()">
		店长推荐:
		<input type="radio" value="1" name="isRecommend"/>是
		<input type="radio" value="0" name="isRecommend"  checked="checked"/>否<br>
		</div>
		<hr>
		<h3>规格参数</h3><!--key-value方式存储数据  -->
				<div id="newDiv">
					<span id="newAdd">			
						<input type="text" name="attrName" style="width: 100px" placeholder="参数"/><input type="text" placeholder="规格" name="attrValue" style="width: 300px"/><br>
					</span>
					<input type="button" value="更多参数"   class="easyui-linkbutton"   onclick="addAttribute()"/><br>
				</div>
		<h3>商品详情</h3>	
		<div id="addPicture">
			详情图片:<br>
			<span id="newspan">
				
				<img id="imgPreview1"/><input name="fileNamePro" type="file" />
			</span>
			<input type="button" value="更多图片" onclick="addPicture()"  class="easyui-linkbutton"  /><br><br><br>
		</div>
		<input type="button" value="提    交"    class="easyui-linkbutton  submit"  onclick="addProduct()"><br>
	</form>
</div>
</body>
</html>
