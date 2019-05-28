/**
 * 
 */
package com.demo.entity;

import lombok.Getter;
import lombok.Setter;

/**   
 * @ClassName:  User   
 * @Description:TODO  用户基本信息
 * @author: xzr 
 * @date:   2019年4月19日 
 *     
 */
@Getter
@Setter
public class User {
    // 用户id(主键)
    private Integer id;
    // 用户名称
    private String userName;
    //用户昵称
    private String nickName;
    // 用户密码
    private String password;
    //用户权限
    private Integer authority;
}
