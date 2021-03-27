package com.mall.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mall.app.bean.Product;
import com.mall.app.service.impl.ListProductServiceImpl;

@RestController
public class ListProductController {
	
	@Autowired
	private ListProductServiceImpl service;
	/**
	 * 根据商品类别返回商品
	 * @param typeId 类别id
	 * @param pageNo 第几页
	 * @param pageCapacity 每页几个
	 * @return
	 */
	@RequestMapping("/listPageProductByType")
	public List<Product> listPageProductByType(int typeId, int pageNo, int pageCapacity,String goodname){
		return service.listPageProductByType(typeId, pageNo, pageCapacity,goodname);
		
	}
	
	/**
	 * 根据商品名返回商品
	 * @param productName 商品名
	 * @param pageNo 第几页
	 * @param pageCapacity 每页几个
	 * @return
	 */
	@RequestMapping("/listPageProductByName")
	public List<Product> listPageProductByName(String productName, int pageNo, int pageCapacity){
		return service.listPageProductByName(productName, pageNo, pageCapacity);
		
	}
	
	/**
	 * 随机抛出数个商品
	 * @param capacity 抛出的商品个数
	 * 
	 * 
	 * @return
	 */
	@RequestMapping("/listRandomProduct")
	public List<Product> listRandomProduct(int capacity){
		return service.listRandomProduct(capacity);
		
	}
	
	@RequestMapping("/getProductNum")
	public int listPageProductByName(String productName, int productTypeId){
		
		return service.getProductNum(productName, productTypeId);
		
	}
	
}
