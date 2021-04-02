package com.mall.app.service.impl;

import java.util.List;
import java.util.Map;

import com.mall.app.bean.Refund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.app.bean.Order;
import com.mall.app.dao.OrderMapper;
import com.mall.app.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;

	@Override
	public boolean addOrder(Order order) {

		return orderMapper.addOrder(order);
	}

	@Override
	public boolean removeOrder(String[] oids) {

		return orderMapper.removeOrder(oids);
	}

	@Override
	public boolean updateOrder(Order order) {

		return orderMapper.updateOrder(order);
	}

	@Override
	public List<Order> listOrder(Map<String, Object> map) {

		return orderMapper.listOrder(map);
	}

	@Override
	public int getCountOrder(Map<String, Object> map) {

		return orderMapper.getCountOrder(map);
	}

	@Override
	public int getOrderStatus(int orderId) {
		
		return orderMapper.getOrderStatus(orderId);
	}


	@Override
	public Map<String, Object> getZST(Integer userId) {
		return orderMapper.getZST(userId);
	}

	@Override
	public void updateStatus(Integer orderId, Integer status) {
		int num = orderMapper.updateStatus(orderId,status);
	}

	@Override
	public Order selectById(Integer orderId) {
		return orderMapper.selectById(orderId);
	}

	@Override
	public int insertRefund(Refund refund) {
		return orderMapper.insertRefund(refund);
	}

	@Override
	public int updateRefund(Integer id) {
		return orderMapper.setRefundStatus(id);
	}

	@Override
	public Refund selectRefundById(Integer id) {
		return orderMapper.selectRefundById(id);
	}

	@Override
	public int deleteRefundById(Integer id) {
		return orderMapper.deleteRefundById(id);
	}

	@Override
	public int getCountRefund(Map<String, Object> map) {
		return orderMapper.countRefund(map);
	}

	@Override
	public List<Refund> listRefund(Map<String, Object> map) {
		return orderMapper.listRefund(map);
	}
}
