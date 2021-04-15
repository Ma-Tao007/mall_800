var orderObj;
layui.use(["jquery","table","element"],function(){
	//个人中心——订单
	var table = layui.table;
	var $ = layui.jquery;
	//所有订单
	  table.render({
	    elem: '#house-user-order'
	    ,url:  '/listUserOrder?status=-1'
	    ,skin: 'line'
	    ,cols: [[
	      {field:'number', title:'订单信息', align:'center', templet: '#orderTpl'}
	      ,{field:'productName', title:'商品', templet: '#imgTpl', align:'center'}
	      ,{field:'productNum', title:'件数', align:'center', width:80}
	      ,{field:'price', title:'单价', align:'center', templet: '#priceTpl', width:100}
	      ,{field:'status', title:'订单状态', align:'center', templet: '#stateTpl', width:100}
	      ,{title:'订单操作', align:'center', templet: '#handleTpl', width:120}
	    ]]
	  	,parseData:function(res){
	  		return{
	  			code:0,
	  			data:res
	  		}
	  	}
	  });
	  //等待发货
	  table.render({
	    elem: '#house-user-order-status0'
	    ,url:  '/listUserOrder?status=0'
	    ,skin: 'line'
	    ,cols: [[
	      {field:'number', title:'订单信息', align:'center', templet: '#orderTpl'}
	      ,{field:'productName', title:'商品', templet: '#imgTpl', align:'center'}
	      ,{field:'productNum', title:'件数', align:'center', width:80}
	      ,{field:'price', title:'单价', align:'center', templet: '#priceTpl', width:100}
	      ,{field:'status', title:'订单状态', align:'center', templet: '#stateTpl', width:100}
	      ,{title:'订单操作', align:'center', templet: '#handleTpl', width:120}
	    ]]
	  	,parseData:function(res){
	  		return{
	  			code:0,
	  			data:res
	  		}
	  	}
	  });
    table.on('tool(house-user-order-status0)', function(obj){

        if(obj.event === 'check'){
            var logisticName;
            var logisticId = obj.data.logisticId;  //此处javabean出错，只能将错就错
            $.ajax({
                url:"/getLogisticName",
                type:"post",
                data:{
                    logisticId: logisticId
                },
                success:function(res){
                    logisticName = res;
                    layer.open({
                        type: 1
                        ,content: "物流公司：" + logisticName+"<br>发货地址："+obj.data.sellerAddr+"<br>收获地址："+obj.data.buyerAddr
                        ,area: ['250px', '200px']
                    });
                }
            })

        }else if(obj.event === 'setOrder'){
            //换货
            orderObj = obj.data;
            $("#usermsg").val(obj.data.usermsg)
            layer.open({
                type : 1,
                title : '换货申请',
                shade : 0,
                maxmin : true,
                offset : 'auto',
                content : $('#upload_order'),
            });
        }
    });
	  //已发货
	  table.render({
	    elem: '#house-user-order-status1'
	    ,url:  '/listUserOrder?status=1'
	    ,skin: 'line'
	    ,cols: [[
	      {field:'number', title:'订单信息', align:'center', templet: '#orderTpl'}
	      ,{field:'productName', title:'商品', templet: '#imgTpl', align:'center'}
	      ,{field:'productNum', title:'件数', align:'center', width:80}
	      ,{field:'price', title:'单价', align:'center', templet: '#priceTpl', width:100}
	      ,{field:'status', title:'订单状态', align:'center', templet: '#stateTpl', width:100}
	      ,{title:'订单操作', align:'center', templet: '#handleTpl', width:120}
	    ]]
	  	,parseData:function(res){
	  		return{
	  			code:0,
	  			data:res
	  		}
	  	}
	  });
    table.on('tool(house-user-order-status1)', function(obj){
		//查看物流
        if(obj.event === 'check'){
            var logisticName;
            var logisticId = obj.data.logisticId;  //此处javabean出错，只能将错就错
            $.ajax({
                url:"/getLogisticName",
                type:"post",
                data:{
                    logisticId: logisticId
                },
                success:function(res){
                    logisticName = res;
                    layer.open({
                        type: 1
                        ,content: "物流公司：" + logisticName+"<br>发货地址："+obj.data.sellerAddr+"<br>收获地址："+obj.data.buyerAddr
                        ,area: ['250px', '200px']
                    });
                }
            })

        }else if(obj.event === 'evaluate'){
            //收货
            layer.confirm('确定已收货？', {
                btn: ['确定','取消'] //按钮
            }, function(){
                $.ajax({
                    url:"/receiveProduct",
                    type:"post",
                    data:{
                        orderId: obj.data.orderId
                    },
                    success:function(res){
                        if(res == true){
                            layer.msg('收货成功');
                            window.location.reload();
                        }else{
                            layer.msg('错误！');
                        }
                    }
                })
            })
        }
    });
    //退款成功
    table.render({
        elem: '#house-user-order-status4'
        ,url:  '/listUserOrder?status=4'
        ,skin: 'line'
        ,cols: [[
            {field:'number', title:'订单信息', align:'center', templet: '#orderTpl'}
            ,{field:'productName', title:'商品', templet: '#imgTpl', align:'center'}
            ,{field:'productNum', title:'件数', align:'center', width:80}
            ,{field:'price', title:'单价', align:'center', templet: '#priceTpl', width:100}
            ,{field:'status', title:'订单状态', align:'center', templet: '#stateTpl', width:100}
        ]]
        ,parseData:function(res){
            return{
                code:0,
                data:res
            }
        }
    });
    //申请退款
    table.render({
        elem: '#house-user-order-status3'
        ,url:  '/listUserOrder?status=3'
        ,skin: 'line'
        ,cols: [[
            {field:'number', title:'订单信息', align:'center', templet: '#orderTpl'}
            ,{field:'productName', title:'商品', templet: '#imgTpl', align:'center'}
            ,{field:'productNum', title:'件数', align:'center', width:80}
            ,{field:'price', title:'单价', align:'center', templet: '#priceTpl', width:100}
            ,{field:'status', title:'订单状态', align:'center', templet: '#stateTpl', width:100}
        ]]
        ,parseData:function(res){
            return{
                code:0,
                data:res
            }
        }
    });
	  //交易完成
	  table.render({
	    elem: '#house-user-order-status2'
	    ,url:  '/listUserOrder?status=2'
	    ,skin: 'line'
	    ,cols: [[
	      {field:'number', title:'订单信息', align:'center', templet: '#orderTpl'}
		  ,{field:'productName', title:'商品', templet: '#imgTpl', align:'center'}
		  ,{field:'productNum', title:'件数', align:'center', width:80}
		  ,{field:'price', title:'单价', align:'center', templet: '#priceTpl', width:100}
		  ,{field:'status', title:'订单状态', align:'center', templet: '#stateTpl', width:100}
		  ,{title:'订单操作', align:'center', templet: '#handleTpl', width:120}
	    ]]
	  	,parseData:function(res){
	  		return{
	  			code:0,
	  			data:res
	  		}
	  	}
	  });
    //交易完成
    table.on('tool(house-user-order-status2)', function(obj){
        if(obj.event === 'check'){
            var logisticName;
            var logisticId = obj.data.logisticId;
            $.ajax({
                url:"/getLogisticName",
                type:"post",
                data:{
                    logisticId: logisticId
                },
                success:function(res){
                    logisticName = res;
                    layer.open({
                        type: 1
                        ,content: "物流公司：" + logisticName+"<br>发货地址："+obj.data.sellerAddr+"<br>收获地址："+obj.data.buyerAddr
                        ,area: ['250px', '200px']
                    });
                }
            })

        }else if(obj.event === 'refund'){
            //申请退款
			var orderId = obj.data.orderId

            $.ajax({
                url:"/order/refund",
                type:"post",
                data:{
                    orderId: orderId,
					status:3
                },
                success:function(res){
                   layer.msg("退款申请提交成功!请等待管理员审核")
                    window.location.reload();
                }
            })
        }
    });
    $("#test2").click(function() {
        //换货数据
        var usermsg = $("#usermsg").val()
        if (usermsg == "") {
            layer.msg("请输入换货说明")
            return
        }
        //数据
        orderObj.usermsg = usermsg
        $.ajax({
            url: "/order/updateOrder",
            type: "post",
            data: orderObj,
            success: function (flag) {
                layer.msg('提交成功');
                setTimeout(function(){
                    window.location.reload();
                },2000)
            }
        })
    })
	  table.on('tool(house-user-order)', function(obj){
		  
	    if(obj.event === 'check'){
	    	var logisticName;
			var logisticId = obj.data.logisticId;  //此处javabean出错，只能将错就错
	    	 $.ajax({
	    			url:"/getLogisticName",
	    			type:"post",
	    			data:{
	    				logisticId: logisticId
	    			},
	    			success:function(res){
	    				logisticName = res;
	    				layer.open({
	    			        type: 1
                            ,content: "物流公司：" + logisticName+"<br>发货地址："+obj.data.sellerAddr+"<br>收获地址："+obj.data.buyerAddr
                            ,area: ['250px', '200px']
	    			      });
	    			}
	    	 })
	      
	    }else if(obj.event === 'evaluate'){
	    	layer.confirm('确定已收货？', {
    		  btn: ['确定','取消'] //按钮
    		}, function(){
    		  $.ajax({
    			url:"/receiveProduct",
    			type:"post",
    			data:{
    				orderId: obj.data.orderId
    			},
    			success:function(res){
    				if(res == true){
    					layer.msg('收货成功');
    					window.location.reload();
    				}else{
    					layer.msg('错误！');
    				}
    			}
    		  })
    		})
	    }else if(obj.event === 'refund'){
            //申请退款
            var orderId = obj.data.orderId
            $.ajax({
                url:"/order/refund",
                type:"post",
                data:{
                    orderId: orderId,
                    status:3
                },
                success:function(res){
                    layer.msg("退款申请提交成功!请等待管理员审核")
                    window.location.reload();
                }
            })
        }else if(obj.event === 'setOrder'){
            //换货
            orderObj = obj.data;
            $("#usermsg").val(obj.data.usermsg)
            layer.open({
                type : 1,
                title : '换货申请',
                shade : 0,
                maxmin : true,
                offset : 'auto',
                content : $('#upload_order'),
            });
        }
	  });
})


layui.use(['jquery', 'layer'], function(){ 
	  var $ = layui.jquery //重点处
	  ,layer = layui.layer;
	  $.post('../../user/getInfo','',
	  function(user)
	  {
		  $("#nickname").text(user.nickname);
		  $("#_nickname").text(user.nickname);
		  $("#sex").text(user.sex);
		  $("#phone_number").text(user.phoneNumber);
		  $("#username").text(user.username);
	  });
	
});