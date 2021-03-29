package com.mall.app.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mall.app.bean.User;

@Repository
@Mapper
public interface UserMapper {

	User login(@Param("username") String username);

	boolean updateInfo(Map<String, String> info);

	boolean uploadImg(@Param("img") String img, @Param("username") String username);

	/**
	 * 查询用户
	 *
	 * @return
	 */
	public List<User> listUser(Map<String, Object> map);

	/**
	 * 查询用户数
	 *
	 * @return
	 */
	public int getCountUser();

    int insert(@Param("user") User user);

    void updateStatus(@Param("status") Integer status, @Param("userid") Integer userid);

	int updatePassword(User user);
}
