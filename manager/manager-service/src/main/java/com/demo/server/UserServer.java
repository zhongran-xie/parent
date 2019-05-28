/**
 * 
 */
package com.demo.server;

import javax.servlet.http.HttpServletRequest;

import com.demo.entity.User;

/**   
 * @ClassName:  UserServer   
 * @Description:TODO  用户服务接口
 * @author: xzr 
 * @date:   2019年4月19日 
 *     
 */
public interface UserServer {

    /**   
     * @Title: getUserByUserName   
     * @Description: TODO 获取单个用户
     * @param user 用户信息
     * @return: Integer  状态
     * @throws   
     */  
    public Integer getByUser(HttpServletRequest request,User user);
}
