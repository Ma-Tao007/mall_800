package com.mall.app.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mall.app.bean.LogisticCom;

@Repository
@Mapper
public interface LogisticComMapper {

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
