package com.mall.app.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.mall.app.bean.Refund;
import com.mall.app.service.AlipayService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mall.app.bean.Order;
import com.mall.app.bean.User;
import com.mall.app.service.impl.OrderServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderServiceImpl impl;

	@Autowired
	private AlipayService alipayService;
	// ��
	@RequestMapping("/addOrder")
	public boolean addOrder(Order order) {

		return impl.addOrder(order);
	}

	//申请退款
	@RequestMapping("/refund")
	public String refund(Integer orderId,Integer status) {
		//1.改变订单状态 status=4
		impl.updateStatus(orderId,status);
		//2.写入退款表
		Order order = impl.selectById(orderId);
		Refund refund = new Refund();
		refund.setBuyerid(order.getBuyerId());
		refund.setMoney(order.getProductNum()*order.getPrice()+"");
		refund.setStatus(0);
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		refund.setInputtime(formatter.format(date));
		refund.setSellerid(order.getSellerId());
		refund.setOrderno(order.getOrderno());
		refund.setOrderid(orderId);
		impl.insertRefund(refund);
		return "";
	}

	//通过退款
	@RequestMapping("/updateRefund")
	public String updateRefund(HttpServletRequest request, HttpServletResponse response,Integer id) {
		//支付宝退款请求
		Refund refund = impl.selectRefundById(id);
		Boolean flag = alipayService.refund(response,request,refund.getOrderno(),refund.getMoney());
		impl.updateRefund(id);
		impl.updateStatus(refund.getOrderid(),4);
		return "";
	}

	//删除退款记录
	@RequestMapping("/deleteRefund")
	public String deleteRefund(Integer id) {
		impl.deleteRefundById(id);
		return "";
	}

	// ɾ
	@RequestMapping("/removeOrder")
	public boolean removeOrder(@RequestParam("oids[]")String[] oids) {

		return impl.removeOrder(oids);
	}

	// ��
	@RequestMapping("/updateOrder")
	public boolean updateOrder(Order order) {

		return impl.updateOrder(order);
	}

	@RequestMapping("/getZST")
	public Map<String, Object> getZST() {
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
		return impl.getZST(user.getUserId());
	}

	// �鶩����Ϣ
	@RequestMapping("/listOrder")
	public Map<String, Object> listOrder(int page,int limit) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", (page-1)*limit );
		map.put("size", limit );
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
		map.put("sellerId", user.getUserId());
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", 0 );
		result.put("msg", "" );
		result.put("count", impl.getCountOrder(map));
		result.put("data", impl.listOrder(map));
		
		return result;
	}

	// �鶩������--ĳĳ�û���������
	@RequestMapping("/getCountOrder")
	public int getCountOrder(int buyerId) {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
		map.put("sellerId", user.getUserId());
		return impl.getCountOrder(map);
	}
	
	@RequestMapping("/getOrderStatus")
	public int getOrderStatus(int orderId){
		
		return impl.getOrderStatus(orderId);
	}

	@RequestMapping("/listRefund")
	public Map<String, Object> listRefund(int page,int limit) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", (page-1)*limit );
		map.put("size", limit );
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", 0 );
		result.put("msg", "" );
		result.put("count", impl.getCountRefund(map));
		result.put("data", impl.listRefund(map));
		return result;
	}


}
