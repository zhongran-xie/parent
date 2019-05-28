package com.demo.server.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Product;
import com.demo.mapper.ProductMapper;
import com.demo.server.ProductServer;

@Service
public class ProductServerImpl implements ProductServer {

	@Autowired
	private ProductMapper productMapper;
	
	@Override 
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productMapper.findAll();
	}

}
