package com.mall.app.service;

import java.util.List;
import java.util.Map;

import com.mall.app.bean.Order;

public interface UserOrderService {
	List<Map<String,Object>> listUserOrder(/*int pageNo,int pageCapacity,*/int status);
	boolean receiveProduct(int orderId);
	int getOrderNum(int status);
	String getLogisticName(int logisticId);
}
