package com.mall.app.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mall.app.bean.Order;

@Repository
@Mapper
public interface OrderMapper {

	/**
	 * ��Ӷ�����Ϣ
	 * 
	 * @return
	 */
	public boolean addOrder(Order order);

	/**
	 * ɾ��������Ϣ
	 * 
	 * @return
	 */
	public boolean removeOrder(String[] oids);

	/**
	 * ���¶�����Ϣ
	 * 
	 * @return
	 */
	public boolean updateOrder(Order order);

	/**
	 * ��ѯ������Ϣ
	 * 
	 * @return
	 */
	public List<Order> listOrder(Map<String,Object> map);

	/**
	 * ��ѯ��������
	 * 
	 * @return
	 * @param buyerId
	 */
	public int getCountOrder(Map<String, Object> map);

	/**
	 * ��ѯ����״̬
	 * @param orderId  ����ID
	 * @return
	 */
	public int getOrderStatus(@Param(value="orderId")int orderId);
	
}
