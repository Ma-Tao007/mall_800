package com.mall.app.service.impl;

import java.text.DateFormat;
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
import com.mall.app.bean.ShoppingCart;
import com.mall.app.bean.User;
import com.mall.app.dao.GoodsMapper;
import com.mall.app.dao.ShoppingCartMapper;
import com.mall.app.service.ShoppingCartService;
@Service
@Transactional
public class ShoppingCartImpl implements ShoppingCartService{
	@Autowired
	private ShoppingCartMapper shoppingCartMapper;
	
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private AddressMapper addressMapper;

	@Override
	public boolean saveShoppingCart(ShoppingCart shoppingCart) {
		int flag=shoppingCartMapper.findifexist(shoppingCart);
		if(flag==0) {
			shoppingCartMapper.saveShoppingCart(shoppingCart);
			return true;
		}
		else if(flag==1){
			shoppingCartMapper.updateShoppingCart(shoppingCart);
			return true;
		}
		else
		return false;
	}
	@Override
	public List<ShoppingCart> listShoppingCart(Map<String, Object> map) {
		return  shoppingCartMapper.listShoppingCart(map);
	}

	@Override
	public int getCountShoppingCart(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return shoppingCartMapper.getCountShoppingCart(map);
	}

	@Override
	public boolean removeShoppingCart(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		return shoppingCartMapper.removeShoppingCart( shoppingCart)>0;
	}
	
	@Override
	@Transactional
	public Map<String,Object> emptyShoppingcart(int addressId, String productIds, String productNums,String colors,String sizes) {
		Map<String,Object> map = new HashMap<String, Object>();
		String[] productIdArr = productIds.split(",");
		String[] productNumArr = productNums.split(",");
		String[] colorsArr = colors.split(",");
		String[] sizesArr = sizes.split(",");
		boolean flag = true;
		Address address = addressMapper.selectAddress(addressId);
		String addressname = address.getProvince()+address.getCity()+address.getCounty()+address.getAddress_detail();
		for(int i=0;i<productIdArr.length;i++) {
			int productId = Integer.parseInt(productIdArr[i]);
			int productNum = Integer.parseInt(productNumArr[i]);
			String color = colorsArr[i];
			String size = sizesArr[i];
			Goods goods = goodsMapper.selectGoods(productId);
			boolean ret1 = false;
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
				boolean ret2 = goodsMapper.insertOrder(productId, productNum, goods.getPrice(), user.getUserId(), goods.getSeller_id(), addressname, formatter.format(date),orderno,color,size);
				map.put("orderno",orderno);
				map.put("price",goods.getPrice()*productNum);
				ShoppingCart shoppingCart = new ShoppingCart();
				shoppingCart.setBuyerId(user.getUserId());
				shoppingCart.setProductId(productId);
				boolean ret3 = shoppingCartMapper.removeShoppingCart(shoppingCart) > 0;
				flag = ret1 && ret2 && ret3 && flag;
			}
		}

		map.put("flag",flag);
		return map;
	}

}
