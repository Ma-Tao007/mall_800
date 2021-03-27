package com.mall.app.service;

import java.util.List;
import java.util.Map;

import com.mall.app.bean.Goods;

public interface GoodsService {

	int getCountGoods();

	List<Goods> listPageGoods(Map<String, Object> map);
	
	Goods selectGoods(int id);
	boolean saveGoods(Goods goods);
	
	boolean immediateBuy(int addressId,int productId,int productNum);

}
