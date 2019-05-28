package com.demo.mapper;

import java.util.List;

import com.demo.entity.Product;

public interface ProductMapper {
	
//	@Select("select * from trading_product")
	public List<Product> findAll();
}
