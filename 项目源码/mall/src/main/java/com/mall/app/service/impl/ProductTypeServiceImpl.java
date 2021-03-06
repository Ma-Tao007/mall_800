package com.mall.app.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.app.bean.ProductType;
import com.mall.app.dao.ProductTypeMapper;
import com.mall.app.service.ProductTypeService;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
	
	@Autowired
	private ProductTypeMapper productTypeMapper;

	/**
	 * �����Ʒ���
	 * 
	 * @return
	 */
	public boolean addProductType(String productTypeName) {
		
		return productTypeMapper.addProductType(productTypeName);
	}

	/**
	 * ɾ����Ʒ���
	 * 
	 * @return
	 */
	public boolean removeProductType(String[] pids) {
		
		return productTypeMapper.removeProductType(pids);
	}

	/**
	 * ������Ʒ���
	 * 
	 * @return
	 */
	public boolean updateProductType(ProductType productType) {
		
		return productTypeMapper.updateProductType(productType);
	}

	/**
	 * ��ѯ��Ʒ�����Ϣ
	 * 
	 * @return
	 */
	public List<ProductType> listProductType(Map<String,Object> map) {
		
		return productTypeMapper.listProductType(map);
	}

	/**
	 * ��ѯ��Ʒ�����
	 * 
	 * @return
	 */
	public int getCountProductType() {
		
		return productTypeMapper.getCountProductType();
	}

}
