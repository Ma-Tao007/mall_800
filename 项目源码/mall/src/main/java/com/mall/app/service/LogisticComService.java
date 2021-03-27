package com.mall.app.service;

import java.util.List;
import java.util.Map;

import com.mall.app.bean.LogisticCom;

public interface LogisticComService {

	/**
	 * ���������˾
	 * 
	 * @return
	 */
	public boolean addLogisticCom(String comName);

	/**
	 * ɾ��������˾
	 * 
	 * @return
	 */
	public boolean removeLogisticCom(String[] lids);

	/**
	 * ����������˾
	 * 
	 * @return
	 */
	public boolean updateLogisticCom(LogisticCom logisticCom);

	/**
	 * ��ѯ������˾
	 * 
	 * @return
	 */
	public List<LogisticCom> listLogisticCom(Map<String,Object> map);

	/**
	 * ��ѯ������˾����
	 * 
	 * @return
	 */
	public int getCountLogisticCom();
}
