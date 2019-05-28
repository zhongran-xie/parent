/**
 * 
 */
package com.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.demo.entity.User;

/**   
 * @ClassName:  MyHandlerInterceptor   
 * @Description:TODO  拦截请求条件
 * @author: xzr 
 * @date:   2019年4月24日 
 *     
 */
public class MyHandlerInterceptor implements HandlerInterceptor {

    /*   
     * Title: preHandle  
     * Description:   
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception   
     */  
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // TODO Auto-generated method stub
	boolean flag=false;
	User user = (User) request.getSession().getAttribute("user");
	if (null==user) {
	    response.sendRedirect("/page/login.jsp");
	}else {
	    flag=true;
	}
	return flag;
    }
}
