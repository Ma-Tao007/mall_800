
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>退货</title>
    <link rel="stylesheet" href="../layui/css/layui.css">
</head>
<body>
<script src="../layui/layui.js"></script>
<script type="text/javascript">
    layui.use([ 'layer', 'form', 'jquery', 'table' ], function() {
        const layer = layui.layer;
        const $ = layui.jquery;
        const table = layui.table

        //第一个实例
        table.render({
            elem : '#dg',
            url : '../order/listRefund',
            page : true,
            cols : [ [ //表头
                {
                    field : 'id',
                    title : 'ID',
                    type : 'checkbox'
                },{
                    field : 'orderno',
                    title : '订单号'
                }, {
                    field : 'sellername',
                    title : '卖家'
                }, {
                    field : 'buyername',
                    title : '买家'
                },
                {
                    field : 'money',
                    title : '金额'
                },  {
                    field : 'inputtime',
                    title : '申请时间'
                },{
                    field : 'status',
                    title : '状态',
                    templet:function(data){
                        if(data.status==0){
                            return "未同意";
                        }else{
                            return "已退款"
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
            var objs = obj.data
            console.log("退货信息",objs)
            if(obj.event === 'edit'){
                //同意
                if(obj.status==1){
                    layer.msg("该订单已退款")
                    return
                }else{
                    $.ajax({
                        url: '/order/updateRefund',
                        type: 'post',
                        data:{id:objs.id},
                        success: function () {
                            layer.msg("操作成功")
                            setTimeout(function(){
                                table.reload('dg', {});//刷新表格
                            },1500)
                        }
                    });

                }

            }else if(obj.event === 'delete'){
                //启用
                $.ajax({
                    url: '/order/deleteRefund',
                    type: 'post',
                    data:{id:objs.id},
                    success: function () {
                        layer.msg("删除成功")
                        setTimeout(function(){
                            table.reload('dg', {});//刷新表格
                        },1500)
                    }
                });
            }
        })
    })
</script>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="edit"><i class="layui-icon">&#xe642;</i>同意退货</a>
    <a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="delete"><i class="layui-icon">&#xe642;</i>删除</a>
</script>

<table id="dg" lay-filter="test"></table>


</body>
</html>