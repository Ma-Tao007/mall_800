package com.mall.app.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mall.app.bean.Product;
import com.mall.app.bean.ProductType;

@Repository
@Mapper
public interface ProductMapper {

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
	 * 设置商品状态：上下架
	 * @param map
	 * @return
	 */
	public boolean setProductState(Map<String, Object> map);

	/**
	 * 设置商品库存
	 * @param map
	 * @return
	 */
	public boolean setProductStorage(Map<String, Object> map);

	// 更新图片
	public boolean updateProductPic(Map<String, Object> map);
}
