package com.mall.app.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mall.app.bean.Order;

@Repository
@Mapper
public interface UserOrderMapper {
	public List<Map<String,Object>> listUserOrder(@Param("buyerId")int buyerId/*, @Param("start")int start, @Param("capacity")int capacity*/);
	public List<Map<String,Object>> listUserOrderByStatus(@Param("buyerId")int buyerId/*, @Param("start")int start, @Param("capacity")int capacity*/, @Param("status")int status);
	public boolean userReceiveOrder(@Param("orderId")int orderId,@Param("buyerId")int buyerId);
	public int getOrderNumByStatus(@Param("userId")int userId, @Param("status")int status);
	public int getOrderNum(@Param("userId")int userId);
	public String getLogisticName(@Param("logisticId")int logisticId);
}
