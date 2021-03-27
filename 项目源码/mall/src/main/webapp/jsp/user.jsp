
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>类别</title>
<link rel="stylesheet" href="../layui/css/layui.css">
</head>
<body>
	<script src="../layui/layui.js"></script>
	<script type="text/javascript">
		layui.use([ 'layer', 'form', 'jquery', 'table' ], function() {
			const layer = layui.layer;
			const form = layui.form;
			const $ = layui.jquery;
			const table = layui.table

			
			//删除
// 			$("#remove-but").click(function() {
// 				var array = table.checkStatus('dg').data;

// 				if (array.length == 0) {
// 					layer.msg('请选择要删除的记录');
// 				} else {
// 					var uids = [];
// 					for ( var i in array) {
// 						pids.push(array[i].userId);
// 						console.log("array[i].productTypeId"+array[i].userId);
// 					}
// 					$.post('../user/removeUser', {
// 						"uids[]" : uids
// 					}, function(flag) {
// 						if (flag) {
// 							layer.msg('删除成功')
// 							table.reload('dg', {});//刷新表格
// 						} else {
// 							layer.msg('删除失败');
// 						}

// 					})
// 				}

// 			})

			//条件查询
			$("#search-but").click(function() {
				table.reload('dg', {
					where : {
						type : $("#type").val()
					}
				});//刷新表格

			})

			//第一个实例
			table.render({
				elem : '#dg',
				url : '../user/listUser',
				page : true,
				cols : [ [ //表头
				{
					field : 'userId',
					title : 'ID',
					type : 'checkbox'
				}, {
					field : 'username',
					title : '用户名'
				}, {
					field : 'phoneNumber',
					title : '手机号'
				}, {
					field : 'nickname',
					title : '昵称名'
				}, {
					field : 'password',
					title : '登录密码'
				}, {
					field : 'type',
					title : '用户类型'
				}, {
					field : 'sex',
					title : '性别'
				}
// 				, {
// 					title : '操作',
// 					toolbar : '#barDemo',
// 					width : 100
// 				} 
				] ]
			});
		})
	</script>


<!-- 	<script type="text/html" id="barDemo"> 
     <a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="edit"><i class="layui-icon">&#xe642;</i>编辑</a>
   </script>
-->
	<div class="demoTable">
		用户类型
		<div class="layui-inline">
			<input class="layui-input" id="type">
		</div>
		<button id="search-but" class="layui-btn ">
			<i class="layui-icon">&#xe615;</i>搜索
		</button>
<!-- 		<button id="remove-but" class="layui-btn  layui-btn-danger"> -->
<!-- 			<i class="layui-icon">&#xe640;</i>删除 -->
<!-- 		</button> -->
	</div>
	<table id="dg" lay-filter="test"></table>

	
</body>
</html>