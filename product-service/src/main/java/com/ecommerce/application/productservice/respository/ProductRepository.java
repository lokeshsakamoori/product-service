package com.ecommerce.application.productservice.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.application.productservice.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
