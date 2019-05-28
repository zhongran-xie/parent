package com.demo.controller.controller;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.entity.User;
import com.demo.mvc.FormModel;
import com.demo.server.UserServer;
import com.google.code.kaptcha.Producer;

@Controller
public class LoginController {

    // 验证码
    @Autowired
    private Producer captchaProducer;
    // 用户
    @Autowired
    private UserServer userServer;
 
    /**   
     * @Title: logIn   
     * @Description: TODO 验证用户
     * @param: request
     * @param: response   
     * @return: Integer      
     * @throws   
     */
    @RequestMapping("/login")
    @ResponseBody
    public Integer logIn(HttpServletRequest request, HttpServletResponse response, @FormModel("user") User user) {
	return userServer.getByUser(request,user);
    }

    /**   
     * @Title: loginOut   
     * @Description: TODO 退出系统
     * @return: String      
     * @throws   
     */
    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request, HttpServletResponse response) {
	
	HttpSession session = request.getSession();
	session.removeAttribute("user");
	return "login";
    }

    /**
     * 生成验证码
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/createCaptcha", method = { RequestMethod.GET, RequestMethod.POST })
    public void getKaptchaImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
	response.setDateHeader("Expires", 0);
	response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
	response.addHeader("Cache-Control", "post-check=0, pre-check=0");

	response.setHeader("Pragma", "no-cache");
	response.setContentType("image/jpeg");
	String capText = captchaProducer.createText();
	HttpSession session = request.getSession();
	session.setAttribute("authCode", capText);
	BufferedImage bi = captchaProducer.createImage(capText);
	ServletOutputStream out = response.getOutputStream();
	ImageIO.write(bi, "jpg", out);
	try {
	    out.flush();
	} finally {
	    out.close();
	}
    }

    /**   
     * @Title: validateCaptcha   
     * @Description: TODO 验证码验证
     * @param: request
     * @param: response
     * @param: authCode     
     * @return: Integer      
     * @throws   
     */
    @RequestMapping(value = "/validateCaptcha", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Integer validateCaptcha(HttpServletRequest request, HttpServletResponse response,
	    @RequestParam("authCode") String authCode) {
	// 从会话域获取验证码
	HttpSession session = request.getSession();
	String attribute = (String) session.getAttribute("authCode");

	if (authCode.equals(attribute)) {
	    return 0;
	} else {
	    return 1;
	}
    }

}
