
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
					title : '用户类型',
					templet:function(data){
						if(data.type==0){
							return "管理员";
						}else if(data.type==1){
							return "卖家"
						}else{
						    return "买家"
						}
					}
				}, {
					field : 'sex',
					title : '性别'
				},{
                	field : 'status',
                    title : '状态',
					templet:function(data){
						if(data.status==0){
							return "禁用";
						}else{
							return "启用"
						}
					}
            		}
 				, {
 					title : '操作',
 					toolbar : '#barDemo',
 					width : 250
 				}
				] ]
			});
            table.on('tool(test)', function(obj) {
                var user = obj.data
                if (obj.event === 'show') {
                    //查看执照
                    layer.open({
                        type : 1,
                        title : '上传图片',
                        content : $('#upload_img').attr("style","display:block"),//显示div
                        end: function () {//无论是确认还是取消，只要层被销毁了，end都会执行，不携带任何参数。layer.open关闭事件
                            $('#upload_img').attr("style","display:none")
                        }
                    });
                    $('#demo1').attr('src',"../../img/")

				}else if(obj.event === 'edit'){
                    //禁用
					if(user.status==0){
                        layer.msg("该用户已被禁用")
						return
					}else{
                        layer.msg("禁用成功")
					}

				}else if(obj.event === 'open'){
                    //启用
                    if(user.status==1){
                        layer.msg("该用户已启用")
                        return
                    }else{
                        layer.msg("启用成功")
                    }
				}
			})
		})
	</script>
	<div class="layui-upload" id="upload_img"  style="display: none;width: 500px;height: 500px" align="center">
		<div class="layui-upload-list">
			<img class="layui-upload-img" src="../res/static/img/person.png" align="middle" width=400px height=500px id="demo1">
		</div>
	</div>


	<script type="text/html" id="barDemo">
		<a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="show"><i class="layui-icon">&#xe642;</i>查看执照</a>
		<a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="edit"><i class="layui-icon">&#xe642;</i>禁用</a>
		<a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="open"><i class="layui-icon">&#xe642;</i>启用</a>
   </script>
	<div class="demoTable">
		用户类型
		<div class="layui-inline">
			<input class="layui-input" id="type">
		</div>
		<button id="search-but" class="layui-btn ">
			<i class="layui-icon">&#xe615;</i>搜索
		</button>
	</div>
	<table id="dg" lay-filter="test"></table>

	
</body>
</html>