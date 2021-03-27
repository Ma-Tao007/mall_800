package com.mall.app.service.impl;

import java.util.List;
import java.util.Map;

import com.mall.app.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mall.app.bean.User;
import com.mall.app.dao.UserMapper;
import com.mall.app.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	public User login(String username) {
		return userMapper.login(username) ;
	}
	public boolean updateInfo(Map<String, String> info)
	{
		return userMapper.updateInfo(info);
		
	}
	@Override
	public boolean uploadImg(String string,String string2) {
		// TODO Auto-generated method stub
		
		return userMapper.uploadImg(string,string2);
	}
	
	@Override
	public List<User> listUser(Map<String, Object> map) {
		
		return userMapper.listUser(map);
	}

	@Override
	public int getCountUser() {

		return userMapper.getCountUser();
	}

	@Override
	public int addUser(User user) {

		User login = userMapper.login(user.getUsername());
		if(login!=null){
			//用户名已存在
			return -2;
		}
		user.setPassword(MD5Utils.string2MD5(user.getPassword()));
		return userMapper.insert(user);
	}
}
