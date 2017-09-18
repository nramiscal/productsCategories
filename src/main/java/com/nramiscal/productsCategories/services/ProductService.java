package com.nramiscal.productsCategories.services;

import org.springframework.stereotype.Service;

import com.nramiscal.productsCategories.models.Product;
import com.nramiscal.productsCategories.repositories.ProductRepo;

import java.util.List;

@Service
public class ProductService {
	
	private ProductRepo productRepo;
	
	public ProductService(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}
	
	public void addProduct(Product product) {
		productRepo.save(product);
	}
	
	public Product getById(Long id) {
		return productRepo.findOne(id);
	}

	public void update(Product product) {
		// TODO Auto-generated method stub
		productRepo.save(product);
		
	}

	public List<Product> allProducts() {
		return (List<Product>) productRepo.findAll();
	}
	
	
}
