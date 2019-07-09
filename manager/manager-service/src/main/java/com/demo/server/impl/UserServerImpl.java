/**
 * 
 */
package com.demo.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.EncodeUtils;
import com.demo.entity.User;
import com.demo.mapper.UserMapper;
import com.demo.server.UserServer;

/**
 * @ClassName: UserServerImpl
 * @Description:TODO
 * @author: xzr
 * @date: 2019年4月19日
 * 
 */
@Service
public class UserServerImpl implements UserServer {

	@Autowired
	UserMapper userMapper;

	@Override
	public User getByUser(User user) {
		User user1 = userMapper.findByUserName(user.getUserName());
		String password = EncodeUtils.MD5Encode(user.getPassword());
		if (user1 != null) {
			if (user.getUserName().equals(user1.getUserName()) && password.equals(user1.getPassword())) {
				return user1;
			} else {
				throw new RuntimeException("密码错误");
			}
		} else {
			return null;
		}
	}

}
