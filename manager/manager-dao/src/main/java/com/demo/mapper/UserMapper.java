/**
 * 
 */
package com.demo.mapper;

import com.demo.entity.User;

/**   
 * @ClassName:  UserMapper   
 * @Description:TODO  用户操作
 * @author: xzr 
 * @date:   2019年4月19日 
 *     
 */
public interface UserMapper {
    
    /**   
     * @Title: findByUserName   
     * @Description: TODO 根据用户名查询用户
     * @param: userName 用户名称    
     * @return: User 用户对象
     * @throws   
     */  
    public  User findByUserName( String userName);
}
