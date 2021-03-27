package com.mall.app.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mall.app.bean.ProductType;

@Repository
@Mapper
public interface ProductTypeMapper {

	/**
	 * �����Ʒ���
	 * 
	 * @return
	 */
	public boolean addProductType(String productTypeName);

	/**
	 * ɾ����Ʒ���
	 * 
	 * @return
	 */
	public boolean removeProductType(String[] pids);

	/**
	 * ������Ʒ���
	 * 
	 * @return
	 */
	public boolean updateProductType(ProductType productType);

	/**
	 * ��ѯ��Ʒ�����
	 * 
	 * @return
	 */
	public List<ProductType> listProductType(Map<String,Object> map);

	/**
	 * ��ѯ��Ʒ�����Ϣ
	 * 
	 * @return
	 */
	public int getCountProductType();
}
