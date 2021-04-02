package com.mall.app.service;

import java.util.List;
import java.util.Map;

import com.mall.app.bean.Order;
import com.mall.app.bean.Refund;

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

    Map<String, Object> getZST(Integer userId);

    void updateStatus(Integer orderId, Integer status);

    Order selectById(Integer order);

	int insertRefund(Refund refund);

	int updateRefund(Integer id);

	Refund selectRefundById(Integer id);

	int deleteRefundById(Integer id);

	int getCountRefund(Map<String, Object> map);

	List<Refund> listRefund(Map<String, Object> map);
}
