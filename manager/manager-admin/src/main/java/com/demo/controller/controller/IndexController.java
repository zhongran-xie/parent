package com.demo.controller.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.entity.User;
import com.demo.server.MenuServer;

@Controller
public class IndexController {

    @Autowired
    private MenuServer menuServer;

    @RequestMapping(value="/")
    public String  index() {
	return "index";
    }
   
    
    /**   
     * @Title: index   
     * @Description: TODO 查询菜单列表  
     * @return: List<Map<String,Object>>  菜单列表
     * @throws   
     */
    @RequestMapping("/index")
    @ResponseBody
    private Object index(HttpServletRequest request, HttpServletResponse response) {

	 List<Map<String, Object>> findAll = null;
	 try {
	 findAll = menuServer.findAll();
	 } catch (Exception e) {
	 System.err.println("查询出错了");
	 }
	 return findAll;
//	try {
//	    request.setCharacterEncoding("utf-8");
//	    response.setHeader("Content-type", "text/html;charset=UTF-8");
//	    response.setCharacterEncoding("utf-8");
//	    JSONArray json = JSONArray.fromObject(menuServer.findAll());
//	    System.out.println(json);
//	    response.getWriter().write(json.toString());
//	    response.getWriter().flush();
//	} catch (Exception e) {
//	    System.err.println("查询出错了");
//	}
//	return null;
    }

    @RequestMapping("/getRoleIndex")
    @ResponseBody
    private Map<String, String> getRoleIndex() {
	Map<String, String> map = new HashMap<String, String>();
	map.put("indexUrl", "/welcome");
	return map;
	// try {
	// JSONObject json = JSONObject.fromObject(map);
	// response.getWriter().write(json.toString());
	// response.getWriter().flush();
	// } catch (UnsupportedEncodingException e) {
	// e.printStackTrace();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
    }

    /**   
     * @Title: welcome   
     * @Description: TODO 跳转欢迎页(首页)
     * @param: model
     * @param: request
     * @param: response
     * @throws Exception      
     * @return: String  跳转的页面      
     * @throws   
     */
    @RequestMapping(value="/welcome")
    public String welcome(Model model, HttpServletRequest request, HttpServletResponse response)  {
	try {
	    User user = (User) request.getSession().getAttribute("user");
	    model.addAttribute("loginName", user.getUserName());
	    return "welcome";
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return null;
    }
}
