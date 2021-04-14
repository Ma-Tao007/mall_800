package com.mall.app.utils;

public class AlipayConfig {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016102300742696";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCUL70Sh2c1eslvjOwXaaIk49EJyZraW1tuT1cEYnXtMAbWiXyuPu0IQ5xzNhgqvkRxldXSRGrvQb41Xt35KHN1bIBt1PXjN6OL/qd9+dwFQFq37ah5s/su52y70kIm2qCcNvwWgFZzYFS9qL6a+s8703dIADXj6YnW5yPM8PiJSPR5jZpbFEVGNxInFx7uj6xDfnk9MDXI9mSglaRLufRqa112Owy4Lz61ni9hnYIxriXwDVyJsfpvLKXyOu/mNcEaho2hrGYVohhmuModXhbzQA82a9PXL4odcxOQqoi/zkXalFyGe/f+UND45/FluKIoTuTfWiHq2cmOO8ogM25hAgMBAAECggEAbPaFcuB5tctp30qiN70G61VRWn8SDMnsezp/48t6p0QPYyWJtp6ysMb2fYkjUBrEPTlOFuUUNIYFFT2CvzlNXOTBswFLJR6+dax1AJ7/eCUQD/sDTSpY4u5s99btqaBNRVDxIKKR7xjAdw1jypXuWDFwnlL5TXNmVc10d7ghKOCLhxl8hn8AnVif1vFsKMvh15IaaUxuZmL7xPKoQB7e+Ogj8z0wyLPlFzvlgRmbRnJsq2XfJFuRBN4j+UQmCv2nnVJEiGCPCaV2Lck4rPdthnSOxbg7E0N6rzQHzi50pfAUX5GRY33GV1M+0w9ZY1lLHH5TUVWy6iNTe7TSVfXQAQKBgQDMzuDzKXCoTBrFYxJwQ6CG1wT0kNBcGuh30JpPtdrIMLZJX8KDPLD78OrR2QjO3Loq+7hd7uiCvgzHhAgcVqRmDXToiIunQkyAQl2Ahz0+TslG3W7tiWqnJS86gEIt84iEeuNs5t5RSFss1DB2/M00BnK3K9czZzhbk2y2LZ9FwQKBgQC5OcsNVskG9KSWCQoooxfNnT3vfxEMlrRsKM0eG+J4oNAy0/yRpz3jLDi7cGzbMfJRIa+Da/Mu3lYwIwoVrq2imkVIAzQbR6Dx6dFzsNaI/YeYR8gER0u2k5fRyPzURxQYIuBOW4bygvP2MheYvUk7gdMVuSiJQzOgUwNGwsyQoQKBgBB/TZFosiFsV++0ZkTSvbh+03BbxdzVcgpMrFFlZaUgf15zrzhhCCSTKGcU42e+UeSqeBRg7Suy4Vak5P5bYEy0IsmkThN//KeMMPnsatt8/yuNJKVPn16tWRuOP0ZySnnZaD5abmf/uxBmWy0KegEJz+2/Q0tpshl2S5h1HlJBAoGBAIPnAhBXswR/Bw3JFjDmI7dKuKZqqGt8jrNPQvKkDNy2OE1Z5MycelfiT+w7HWni4ZqhEGnYX+8KafoRmcbjA8d9cMTdcyfSFGzxgzSNw9j+IqdwxqE1XFeCN2UvacyJaWfevjlOuITOeIjkFyWv9gyoYPdhSdqlvof3Vaf4ZNDBAoGAQs/9iWWbY6t/eepQFoSYI+vjJ7F8Gm5A0+fTJbFjNGaCkt6USw/yn2ZCxhyX+oDpGFRgQx4p08JolOz4yVNCCdheyAiHVIGnIpAY5UH6sFibTXlCqfOnLrWUE+ANHnOjl+YSNvRAn6+2pVhQTNNteT3aj3eyjXEz3VB8SuWd1gw=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlC+9EodnNXrJb4zsF2miJOPRCcma2ltbbk9XBGJ17TAG1ol8rj7tCEOcczYYKr5EcZXV0kRq70G+NV7d+ShzdWyAbdT14zeji/6nffncBUBat+2oebP7Ludsu9JCJtqgnDb8FoBWc2BUvai+mvrPO9N3SAA14+mJ1ucjzPD4iUj0eY2aWxRFRjcSJxce7o+sQ355PTA1yPZkoJWkS7n0amtddjsMuC8+tZ4vYZ2CMa4l8A1cibH6byyl8jrv5jXBGoaNoaxmFaIYZrjKHV4W80APNmvT1y+KHXMTkKqIv85F2pRchnv3/lDQ+OfxZbiiKE7k31oh6tnJjjvKIDNuYQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//    public static String notify_url = "http://localhost:808/jsp/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:808/mall/html/postMoneySuccess.html";
//    public static String return_url = "http://rzxqxw.natappfree.cc/mall/html/postMoneySuccess.html";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

}
