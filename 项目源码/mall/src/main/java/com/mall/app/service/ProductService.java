package com.mall.app.service;

import java.util.List;
import java.util.Map;

import com.mall.app.bean.Product;
import com.mall.app.bean.ProductType;

public interface ProductService {

	/**
	 * 添加商品
	 * 
	 * @return
	 */
	public boolean addProduct(Product product);

	/**
	 * 删除商品
	 * 
	 * @return
	 */
	public boolean removeProduct(String[] pids);

	/**
	 * 更新商品
	 * 
	 * @return
	 */
	public boolean updateProduct(Product product);

	/**
	 * 查询商品
	 * 
	 * @return
	 */
	public List<ProductType> listProduct(Map<String,Object> map);

	/**
	 * 查询商品数
	 * 
	 * @return
	 * @param map
	 */
	public int getCountProduct(Map<String, Object> map);
	
	/**
	 * 设置商品状态：0-下架  ； 1-上架
	 * @return
	 */
	public boolean setProductState(Map<String, Object> map);
	
	/**
	 * 设置商品库存
	 * @return
	 */
	public boolean setProductStorage(Map<String, Object> map);
	
	/**
	 *
	 * @param map
	 * @return
	 */
	public boolean updateProductPic(Map<String, Object> map);

}
