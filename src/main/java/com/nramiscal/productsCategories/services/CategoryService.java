package com.nramiscal.productsCategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nramiscal.productsCategories.models.Category;
import com.nramiscal.productsCategories.repositories.CategoryRepo;

@Service
public class CategoryService {

	private CategoryRepo categoryRepo;
//	private ProductRepo productRepo;
	
	public CategoryService(CategoryRepo categoryRepo) {
		this.categoryRepo = categoryRepo;
//		this.productRepo = productRepo;
	}
	
	public void addCategory(Category category) {
		categoryRepo.save(category);
	}
	
	public List<Category> allCategories(){
		return (List<Category>) categoryRepo.findAll();
	}
	
	public Category getById(Long id) {
		return (Category) categoryRepo.findOne(id);
	}

	public void update(Category category) {
		categoryRepo.save(category);
		
	}


}
