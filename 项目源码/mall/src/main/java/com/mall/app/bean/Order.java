package com.mall.app.bean;

import java.io.Serializable;

public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	private int orderId;        // ����ID
	private int productId;      // ��ƷID
	private int ProductNum;     // ��Ʒ����
	private double price;          // ��Ʒ����
	private int buyerId;        // ���ID
	private int sellerId;       // ���ID
	private String orderTime;      // ��������ʱ��
 	private String buyerAddr;      // ����ջ���ַ
	private String sellerAddr;     // ���ҷ�����ַ
 	private int logisticId;    //  logisticId 单词拼写出错！！！！！！！！！！！！！！！！！！
	private int status;         // ����״̬--�Ƿ񷢻
	private String productName;    // 商品名称
	private String comName;    // 物流公司名
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductNum() {
		return ProductNum;
	}
	public void setProductNum(int ProductNum) {
		this.ProductNum = ProductNum;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public String getBuyerAddr() {
		return buyerAddr;
	}
	public void setBuyerAddr(String buyerAddr) {
		this.buyerAddr = buyerAddr;
	}
	public String getSellerAddr() {
		return sellerAddr;
	}
	public void setSellerAddr(String sellerAddr) {
		this.sellerAddr = sellerAddr;
	}
	public int getLogisticId() {
		return logisticId;
	}
	public void setLogisticId(int logisticId) {
		this.logisticId = logisticId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	
	
}
