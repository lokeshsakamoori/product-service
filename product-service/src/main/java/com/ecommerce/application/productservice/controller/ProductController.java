package com.ecommerce.application.productservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.application.productservice.dao.ProductDAO;
import com.ecommerce.application.productservice.model.Product;

@RestController
@RequestMapping("/amazon")
public class ProductController {

	@Autowired
	private ProductDAO productDao;
	
	@PostMapping("/products")
	public Product createProduct(@Valid @RequestBody Product prod) {		
		return productDao.save(prod);		
	}
	
	@GetMapping("/products")
	public List<Product> findAll(){		
		return productDao.findAll();
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity findOne(@PathVariable(value="id") Long id) {
		Product prod = productDao.findOne(id);
		if(prod == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(prod);
	}
	
	@PutMapping("product/{id}")
	public ResponseEntity updateProduct(@PathVariable(value="id") Long id,@RequestBody Product prod) {
		Product pro = productDao.findOne(id);
		if(prod == null) {
			return ResponseEntity.notFound().build();
			}
		pro.setProductName(prod.getProductName());
		pro.setPrice(prod.getPrice());
		pro.setProductDesc(prod.getProductDesc());
		
		Product updatedProduct = productDao.save(pro);
		return ResponseEntity.ok().body(updatedProduct);
		
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable(value="id") Long id) {
		Product prod = productDao.findOne(id);
		if(prod == null) {
			return ResponseEntity.notFound().build();
		}
		productDao.delete(prod.getProductId());
		return ResponseEntity.ok().body("Deleted successfully");
		
	}
}
