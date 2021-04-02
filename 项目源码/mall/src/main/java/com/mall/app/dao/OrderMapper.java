package com.mall.app.dao;

import java.util.List;
import java.util.Map;

import com.mall.app.bean.Refund;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mall.app.bean.Order;

@Repository
@Mapper
public interface OrderMapper {


	public boolean addOrder(Order order);

	public boolean removeOrder(String[] oids);


	public boolean updateOrder(Order order);


	public List<Order> listOrder(Map<String, Object> map);

	public int getCountOrder(Map<String, Object> map);


	public int getOrderStatus(@Param(value = "orderId") int orderId);

	public Map<String, Object> getZST(@Param("id") Integer id);

	int updateStatus(@Param("orderId") Integer orderId, @Param("status") Integer status);

	Order selectById(@Param("orderId")Integer orderId);

	int insertRefund(Refund refund);

	int setRefundStatus(@Param("id")Integer id);

	Refund selectRefundById(@Param("id")Integer id);

	List<Refund> listRefund(Map<String, Object> map);

	int countRefund(Map<String, Object> map);

	int deleteRefundById(@Param("id")Integer id);
}
