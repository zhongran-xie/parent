package com.demo.controller.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.entity.Product;
import com.demo.server.ProductServer;

@Controller
public class ProductController {

    @Resource
    private ProductServer productServer;

    @RequestMapping("/find")
    @ResponseBody
    private List<Product> findAll(Map<String, Object> model) {
	List<Product> findAll = productServer.findAll();
	System.out.println(findAll);
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String dateString = formatter.format(new Date());

	model.put("time", dateString);
	model.put("tradingProduct", findAll);
	return findAll;
    }
}
