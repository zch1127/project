$(function() {

	var offsetWidth = document.body.offsetWidth;// 网页可见区域宽 (包括边线的宽)
	var offsetHeight = document.body.offsetHeight;// 网页可见区域高(包括边线的高)

	// 初始化控件 事件
	$("#btnAdd").click(function() {
		$("#iframe").attr('src', 'toAddNews');
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
					temID = selRow[i].newsid;
				} else {
					temID = selRow[i].newsid + "," + temID;
				}
			}
			$.messager.confirm('提示', '是否删除选中数据?', function (r) { 
				if (!r) {  
                    return;  
                }
				$.ajax({
					url : 'delNews',
					data : {
						newsid : temID
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

	var sortName = 'publishDate';
	var sortOrder = 'asc';

	var index;
	$("#list")
			.datagrid(
					{
						url : 'getNewsByPage',
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
									    //var h = date.getHours().toString();
									    //var i = date.getMinutes().toString();
									    //var s = date.getSeconds().toString();
									    //+ ' ' + (h < 10 ? '0' + h : h) + ':' + (i < 10 ? '0' + i : i)+ ':' + (s < 10 ? '0' + s : s)
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
						onDblClickRow : function(index, row) {
							$("#iframe").attr('src',
									'toEditNews?newsid=' + row.newsid);
							$("#win").window({
								maximized : true
							});
							$("#win").window('open');

						}
					});

});