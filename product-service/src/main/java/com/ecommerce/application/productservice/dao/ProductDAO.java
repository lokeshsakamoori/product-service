package com.ecommerce.application.productservice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.application.productservice.model.Product;
import com.ecommerce.application.productservice.respository.ProductRepository;

@Service
public class ProductDAO {

	@Autowired
	private ProductRepository productRepository;
	
	public Product save(Product prod) {		
		return productRepository.save(prod);
	}
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Product findOne(Long id) {
		return productRepository.findById(id).orElse(null);
	}
	
	public void delete(Long id) {
		productRepository.deleteById(id);
	}
}
