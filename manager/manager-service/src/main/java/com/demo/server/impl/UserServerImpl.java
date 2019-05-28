/**
 * 
 */
package com.demo.server.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.User;
import com.demo.mapper.UserMapper;
import com.demo.server.UserServer;

/**   
 * @ClassName:  UserServerImpl   
 * @Description:TODO  
 * @author: xzr 
 * @date:   2019年4月19日 
 *     
 */
@Service
public class UserServerImpl implements UserServer {

    @Autowired
    UserMapper userMapper;

    /*   
     * <p>Title: getByUser</p>   
     * <p>Description: </p>   
     * @param user
     * @return   
     * @see com.demo.server.UserServer#getByUser(com.demo.entity.User)   
     */
    @Override
    public Integer getByUser(HttpServletRequest request, User user) {

	User user1 = userMapper.findByUserName(user.getUserName());
	if (user1 != null) {
	    if (user.getUserName().equals(user1.getUserName()) && user.getPassword().equals(user1.getPassword())) {
		HttpSession session = request.getSession();
		session.setAttribute("user", user1);
		return 0;
	    } else {
		return -2;
	    }
	}
	return -1;
    }

}
