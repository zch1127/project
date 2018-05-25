$(function() {

	var offsetWidth = document.body.offsetWidth;// 网页可见区域宽 (包括边线的宽)
	var offsetHeight = document.body.offsetHeight;// 网页可见区域高(包括边线的高)

	// 初始化控件 事件
	$("#btnAdd").click(function() {
		$("#iframe").attr('src', 'toAddOfferings');
		$("#win").window({
			maximized : true
		});
		$("#win").window('open');
	});

	// 删除
	$("#btnUnRec").click(function() {
		var selRow = $('#list').datagrid('getSelections')
		// 判断是否选中行
		if (selRow.length == 0) {
			alert("请选择要删除的行!");
			return;
		} else {
			var temID = "";
			// 批量获取选中行的评估模板ID
			for (i = 0; i < selRow.length; i++) {
				if (temID == "") {
					temID = selRow[i].offeringsId;
				} else {
					temID = selRow[i].offeringsId + "," + temID;
				}
			}
			$.messager.confirm('提示', '是否删除选中数据?', function (r) { 
				if (!r) {  
                    return;  
                }
				$.ajax({
					url : 'delOfferings',
					data : {
						offeringsId : temID
					},
					async : false,
					success : function(data) {
						var result = data;// data.message;
						$.messager.show({
							title : "系统消息",
							msg : result.message
						});
					}
				});
				$("#list").datagrid('reload');
			})
		}

	});

	var sortName = 'createTime';
	var sortOrder = 'desc';

	var index;
	$("#list").datagrid({
			url : 'getOfferingsByPage',
			method : 'GET',
			pagination : true,
			pagePosition : 'bottom',
			singleSelect : false,
			sortName : sortName,
			sortOrder : sortOrder,

			columns : [ [
					{
						field : 'ck',
						checkbox : true,
						width : '30'
					},
					{
						field : 'offeringsId',
						title : '供品主键',
						width : 70,
						sortable : true
					},{
						field : 'imgUrl',
						title : '供品图片',
						width : 150,
						sortable : true,
						height : 100,
						formatter : function(value, rowData,
								rowIndex) {
							return "<img src='"+ domain 
									+ value
									+ "' style='width:120px;height:90px'/>";
						}
					},{
						field : 'offeringsName',
						title : '供品标题',
						width : 200,
						sortable : true
					},{
						field : 'type',
						title : '类型',
						width : 100,
						sortable : true,
						formatter : function(value, row, index) {
							if (value == '0') {
								return '香';
							} else if (value == '1') {
								return '水果';
							}else if (value == '2') {
								return '放生鱼';
							}
						}
					},{
						field : 'meritCoin',
						title : '功德币',
						width : 100,
						sortable : true
					},{
						field : 'content',
						title : '供品内容',
						width : 200,
						sortable : true
					}, {
						field : 'createTime',
						title : '发布日期',
						sortable : true,
						width : 200,
						formatter:function(value,row,index){
							var date = new Date(value);
						    var y = date.getFullYear().toString();
						    var m = (date.getMonth() + 1);
						    var d = date.getDate().toString();
						    var h = date.getHours().toString();
						    var i = date.getMinutes().toString();
						    var s = date.getSeconds().toString();
						    //+ ':' + (s < 10 ? '0' + s : s)
						    return y + '-' + (m < 10 ? '0' + m : m) + '-' + (d < 10 ? '0' + d : d)+ '  ' + (h < 10 ? '0' + h : h) + ':' + (i < 10 ? '0' + i : i)+ ':' + (s < 10 ? '0' + s : s) ;
						}
					} ] ],
			onDblClickRow : function(index, row) {
				$("#iframe").attr('src',
						'toEditOfferings?offeringsId=' + row.offeringsId);
				$("#win").window({
					maximized : true
				});
				$("#win").window('open');

			}
		});

	 //搜索按钮点击事件
	$("#btnSearch").click(function() {
		var keywordName = $("#keywordName").val();
		if (keywordName != "") {
			keywordName = encodeURI(keywordName);
		}
		
		$("#list").datagrid("load", {
			'offeringsName' : keywordName
		});
	});
	
	$("#cateId").change(function(){
		var value=$("#cateId").val();
		if (value != "9999") {
			value = encodeURI(value);
			$("#list").datagrid("load", {
				'type' :value
			});
		}else{
			$("#list").datagrid("load", {
				'type' :null
			});
		}
	});
	
});