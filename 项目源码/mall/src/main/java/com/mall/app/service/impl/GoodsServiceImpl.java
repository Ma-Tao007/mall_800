package com.mall.app.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mall.app.bean.Address;
import com.mall.app.dao.AddressMapper;
import com.mall.app.utils.DateUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mall.app.bean.Goods;
import com.mall.app.bean.User;
import com.mall.app.dao.GoodsMapper;
import com.mall.app.service.GoodsService;
@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private AddressMapper addressMapper;
	@Override
	public Goods selectGoods(int id) {
		
		return goodsMapper.selectGoods(id);
	}

	@Override
	@Transactional
	public Map<String,Object> immediateBuy(int addressId, int productId, int productNum,String color,String size) {
		// TODO Auto-generated method stub
		//获取货物信息
		Map<String,Object> map = new HashMap<String, Object>();
		Boolean flag = true;
		Address address = addressMapper.selectAddress(addressId);
		String addressname = address.getProvince()+address.getCity()+address.getCounty()+address.getAddress_detail();
		Goods goods = goodsMapper.selectGoods(productId);
		boolean ret1 = false;
		boolean ret2 = false;
		if (goods.getStorage() >= productNum) {
			ret1 = goodsMapper.updateProductNum(productNum, productId);
		}else{
			flag = false;
		}
		if(flag){
			User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String orderno = new String(DateUtils.formatDateToString(new Date(),DateUtils.DATE_FORMAT_YMDHMS));
			ret2 = goodsMapper.insertOrder(productId, productNum, goods.getPrice(), user.getUserId(), goods.getSeller_id(), addressname,formatter.format(date),orderno,color,size);
			map.put("orderno",orderno);
			map.put("price",productNum*goods.getPrice());
		}
		flag = ret1 && ret2;
		map.put("flag",flag);
		return map;
	}
	
	

}
