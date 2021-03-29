
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>个人信息</title>
    <link rel="stylesheet" href="../layui/css/layui.css">
</head>

<body>
<script src="../layui/layui.js"></script>
<script type="text/javascript">

    layui.use([ 'layer', 'upload','form', 'jquery', 'table' ], function() {
        const layer = layui.layer;
        const $ = layui.jquery;
        const upload = layui.upload;
        var userObj = {}
        //加载用户信息
        $.ajax({
            url:"/user/getUser",
            type:"get",
            success:function(data){
                userObj = data
                $("#userid").val(data.userId)
                $("#username").val(data.username)
                $("#ypassword").val(data.password)
            }
        })

        //普通图片上传
        var productId11;
        var uploadInst = upload.render({
            elem: '#upload'
            ,url: '/user/addProductpic' //改成您自己的上传接口
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#demo1').attr('src', result); //图片链接（base64）
                });
            }
            ,done: function(res){
                //如果上传失败
                if(res.code > 0){
                    return layer.msg('上传失败');
                }
                //上传成功
                $('#upload_img').attr("style","display:none;")//显示div

                layer.msg('上传成功')
                setTimeout(function(){
                    window.location.reload();
                    layer.closeAll();
                },1500)
            }
            ,error: function(){
            }
        });

        $("#showPhoto").click(function () {
            layer.open({
                type: 1,
                title: '上传营业执照',
                content: $('#upload_img').attr("style", "display:block"),//显示div
                end: function () {//无论是确认还是取消，只要层被销毁了，end都会执行，不携带任何参数。layer.open关闭事件
                    $('#upload_img').attr("style", "display:none")
                }
            });
            $('#demo1').attr('src', "../../img/" + userObj.img)
        })

        //修改用户信息
        $("#updateUser").click(function(){
            var ypassword = $("#ypassword").val()
            var password = $("#password").val()//输入的原密码
            var newPassword = $("#newpassword").val()//新密码
            var rePassword = $("#repassword").val()//确认密码
            if(ypassword!=password){
                layer.msg('原密码不正确')
                return
            }
            if(newPassword!=rePassword){
                layer.msg('两次密码输入不一致')
                return
            }
            $.ajax({
                url:"/seller/updateInfo",
                type:"get",
                success:function(data){
                    userObj = data
                    $("#userid").val(data.userId)
                    $("#username").val(data.username)
                    $("#ypassword").val(data.password)
                }
            })
        })
    })
</script>
<div style="width: 50%;margin: auto;text-align: center">
    <form class="layui-form">
        <h2>个人信息</h2>
        <br>
        <br>
        <div class="layui-input-block login">
            <input id="userid" style="display: none" class="layui-input">
            <input type="text" id="username" name="username" readonly lay-verify="required" placeholder="用户名" class="layui-input">
        </div>
        <br>
        <input id="ypassword" style="display: none" placeholder="原密码" class="layui-input">
        <div class="layui-input-block login">
            <input type="password" name="password" id="password" required lay-verify="required" placeholder="原密码" class="layui-input">
        </div>
        <br>
        <div class="layui-input-block login">
            <input type="password" name="newpassword" id="newpassword" required lay-verify="required" placeholder="新密码" class="layui-input">
        </div>
        <br>
        <div class="layui-input-block login">
            <input type="password" name="repassword" id="repassword" required lay-verify="required" placeholder="确认密码" class="layui-input">
        </div>
        <br>
        <div class="layui-input-block login">
            <button type="button" style="width: 50%;" class="layui-btn" id="showPhoto">查看营业执照</button>
        </div>
        <br>
        <button type="button" class="layui-btn" lay-submit="lay-submi" id="updateUser">保存</button>
    </form>
</div>




<!-- 	添加 -->


<div class="layui-upload" id="upload_img"  style="width:500px;height:400px;display: none" align="center">
    <div class="layui-upload-list">
        <img class="layui-upload-img" src="" align="middle" width=500px height=500px id="demo1">
    </div>
    <button type="button" class="layui-btn" id="upload">修改营业执照</button>
</div>
</body>
</html>