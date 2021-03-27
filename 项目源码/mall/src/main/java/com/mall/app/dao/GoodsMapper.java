package com.mall.app.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mall.app.bean.Goods;

@Repository
@Mapper
public interface GoodsMapper {

	int getCountGoods();

	List<Goods> listPageGoods(Map<String, Object> map);
	
	
	int saveGoods(Goods goods);
	
	int updateGoodsOfSale(@Param("productId")int productId,@Param("getProductNum")int getProductNum);
	
	boolean updateProductNum(@Param("number")int number,@Param("productId")int productId);
	boolean insertOrder(@Param("product_id")int product_id,@Param("product_num")int product_num,@Param("price")double price,@Param("buyer_id")int buyer_id,
						@Param("seller_id")int seller_id,@Param("buyer_addr")String buyer_addr,@Param("order_time")String order_time);
	Goods selectGoods(@Param("product_id")int product_id);

}
