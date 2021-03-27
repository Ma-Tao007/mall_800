package com.mall.app.service;

import java.util.List;
import java.util.Map;

import com.mall.app.bean.ProductType;

public interface ProductTypeService {

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
	 * ��ѯ��Ʒ�����Ϣ
	 * 
	 * @return
	 */
	public List<ProductType> listProductType(Map<String,Object> map);

	/**
	 * ��ѯ��Ʒ�����
	 * 
	 * @return
	 */
	public int getCountProductType();
}
