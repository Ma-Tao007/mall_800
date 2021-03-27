package com.mall.app.service;

import java.util.List;
import java.util.Map;

import com.mall.app.bean.Order;

public interface OrderService {

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
	public int getCountOrder(Map<String, Object> buyerId);

	/**
	 * �鶩��״̬
	 * @param orderId
	 * @return
	 */
	public int getOrderStatus(int orderId);
	
}
