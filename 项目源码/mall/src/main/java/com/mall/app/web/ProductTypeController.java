package com.mall.app.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mall.app.bean.ProductType;
import com.mall.app.service.impl.ProductTypeServiceImpl;

@RestController
@RequestMapping("/productType")
public class ProductTypeController {

	@Autowired
	private ProductTypeServiceImpl impl;
	
	/**
	 * �����Ʒ���
	 * @return 
	 * 
	 * @return
	 */
	@RequestMapping("/addProductType")
	public boolean addProductType(String productTypeName) {

		return impl.addProductType(productTypeName);
	}

	/**
	 * ɾ����Ʒ���
	 * 
	 * @return
	 */
	@RequestMapping("/removeProductType")
	public boolean removeProductType(@RequestParam("pids[]")String[] pids) {
		
		return impl.removeProductType(pids);
	}

	/**
	 * ������Ʒ���
	 * 
	 * @return
	 */
	@RequestMapping("/updateProductType")
	public boolean updateProductType(ProductType productType) {
		
		return impl.updateProductType(productType);
	}

	/**
	 * ��ѯ��Ʒ�����Ϣ
	 * 
	 * @return
	 */
	@RequestMapping("/listProductType")
	public Map<String, Object> listProductType(Integer page,Integer limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 下拉框查询用
		if(page==null && limit==null){
			map.put("data", impl.listProductType(map));
			return map;
		}
		
		map.put("page", (page-1)*limit );
		map.put("size", limit );
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", 0 );
		result.put("msg", "" );
		result.put("count", impl.getCountProductType());
		result.put("data", impl.listProductType(map));
		return result;
	}

	/**
	 * ��ѯ��Ʒ�����
	 * 
	 * @return
	 */
	@RequestMapping("/getCountProductType")
	public int getCountProductType() {
		
		return impl.getCountProductType();
	}
}
