package com.mall.app.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.app.bean.Order;
import com.mall.app.bean.User;
import com.mall.app.dao.UserOrderMapper;
import com.mall.app.service.UserOrderService;

@Service
public class UserOrderServiceImpl implements UserOrderService {

	@Autowired
	private UserOrderMapper userOrderMapper;
	
	/**
	 * status 0未发货 1已发货 2已签收 其他 查询所有
	 */
	@Override
	public List<Map<String,Object>> listUserOrder(/*int pageNo,int pageCapacity, */int status) {
		// TODO Auto-generated method stub
		User user = (User)SecurityUtils.getSubject().getSession().getAttribute("user");
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*");
		System.out.println(user.getUserId());
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*");
		if(status != 0 && status != 1 && status != 2){ //查询所有
			return userOrderMapper.listUserOrder(user.getUserId()/*, (pageNo-1)*pageCapacity, pageCapacity*/);
		}else{ //按状态查询
			return userOrderMapper.listUserOrderByStatus(user.getUserId()/*, (pageNo-1)*pageCapacity, pageCapacity*/, status);
		}
		
	}

	@Override
	public boolean receiveProduct(int orderId) {
		// TODO Auto-generated method stub
		User user = (User)SecurityUtils.getSubject().getSession().getAttribute("user");
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*");
		System.out.println(user.getUserId());
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*");
		return userOrderMapper.userReceiveOrder(orderId,user.getUserId());
	}

	@Override
	public int getOrderNum(int status) {
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
		if(status>3 || status<0){
			userOrderMapper.getOrderNum(user.getUserId());
		}else{
			userOrderMapper.getOrderNumByStatus(user.getUserId(), status);
		}
		return 0;
	}

	@Override
	public String getLogisticName(int logisticId) {
		// TODO Auto-generated method stub
		return userOrderMapper.getLogisticName(logisticId);
	}

}
