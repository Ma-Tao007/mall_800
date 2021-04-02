package com.mall.app.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.mall.app.service.AlipayService;
import com.mall.app.utils.AlipayConfig;
import com.mall.app.utils.DateUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@Service
public class AlipayServiceImpl implements AlipayService {

    @Override
    public void aliPay(HttpServletResponse response, HttpServletRequest request,String order_number,String total_amount) throws IOException {
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest aliPayRequest = new AlipayTradePagePayRequest();
        aliPayRequest.setReturnUrl(AlipayConfig.return_url);
//        aliPayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，后台可以写一个工具类生成一个订单号，必填
//        String order_number = new String(DateUtils.formatDateToString(new Date(),DateUtils.DATE_FORMAT_YMDHMS));
//        //付款金额，从前台获取，必填
//        String total_amount = new String("0.2");
        //订单名称，必填
        String subject = new String("沙箱支付卖家");
        aliPayRequest.setBizContent("{\"out_trade_no\":\"" + order_number + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求
        String result = null;
        try {
            result = alipayClient.pageExecute(aliPayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        //输出
        out.println(result);
        System.out.println("返回的结果:"+result);

    }

    @Override
    public Boolean refund(HttpServletResponse response, HttpServletRequest request, String orderno, String money) {
        // 获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
                AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key,
                AlipayConfig.sign_type);
        AlipayTradeRefundRequest req = new AlipayTradeRefundRequest();

        req.setBizContent("{\"out_trade_no\":\"" + orderno + "\"," + "\"refund_amount\":\"" + money + "\"}");
        AlipayTradeRefundResponse resp = null;
        try {
            resp = alipayClient.execute(req);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return true;
    }
}
