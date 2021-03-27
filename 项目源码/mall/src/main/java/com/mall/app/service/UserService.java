package com.mall.app.service;

import java.util.List;
import java.util.Map;

import com.mall.app.bean.User;

public interface UserService {

	User login(String username);
	boolean updateInfo(Map<String, String> info);
	boolean uploadImg(String string, String string2);
	
	/**
	 * 查询用户
	 * 
	 * @return
	 */
	public List<User> listUser(Map<String,Object> map);

	/**
	 * 查询用户数
	 * 
	 * @return
	 */
	public int getCountUser();

	/**
	 * 注册
	 *
	 * @return
	 */
	public int addUser(User user);
}
