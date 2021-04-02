package com.mall.app.service;

import java.util.List;
import java.util.Map;

import com.mall.app.bean.Goods;

public interface GoodsService {


	Goods selectGoods(int id);

	Map<String,Object> immediateBuy(int addressId,int productId,int productNum);

}
