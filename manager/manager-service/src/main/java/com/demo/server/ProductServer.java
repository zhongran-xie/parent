package com.demo.server;

import java.util.List;

import com.demo.entity.Product;

public interface ProductServer {

	List<Product> findAll();
}
