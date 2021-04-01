
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>订单</title>
    <link rel="stylesheet" href="../layui/css/layui.css">
</head>

<body>
<script src="../layui/layui.js"></script>
<%@ page import="java.util.*"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.mall.app.utils.*"%>
<%@ page import="com.alipay.api.internal.util.*"%>
<%
        //商户订单号
        String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

        //支付宝交易号
        String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

        //付款金额
        String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");

        out.println("trade_no:"+trade_no+"<br/>out_trade_no:"+out_trade_no+"<br/>total_amount:"+total_amount);

%>
<!-- 	修改-->
<div>
    返回的页面
</div>

</body>
</html>