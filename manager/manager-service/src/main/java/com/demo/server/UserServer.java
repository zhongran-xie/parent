/**
 * 
 */
package com.demo.server;

import com.demo.entity.User;

/**
 * @ClassName: UserServer
 * @Description:TODO 用户服务接口
 * @author: xzr
 * @date: 2019年4月19日
 * 
 */
public interface UserServer {

	/**
	 * 获取单个用户
	 *  @Title: getUserByUserName 
	 *  @param user 用户信息 
	 *  @return: User 用户信息 
	 */
	public User getByUser(User user);
}
