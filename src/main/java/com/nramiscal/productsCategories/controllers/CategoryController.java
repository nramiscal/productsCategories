package com.nramiscal.productsCategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nramiscal.productsCategories.models.Category;
import com.nramiscal.productsCategories.models.Product;
import com.nramiscal.productsCategories.services.CategoryService;
import com.nramiscal.productsCategories.services.ProductService;

@Controller
public class CategoryController {

	private final CategoryService categoryService;
	private final ProductService productService;
	
	public CategoryController(CategoryService categoryService, ProductService productService) {
		this.categoryService = categoryService;
		this.productService = productService;
	}
	
	@RequestMapping("/categories/new")
	public String newCategory(Model model) {
		model.addAttribute("category", new Category());
		return "newCategory";
	}
	
	@PostMapping("/categories/new")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "newCategory";
		}else {
			categoryService.addCategory(category);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/categories/{id}")
	public String show(Model model, @PathVariable("id") Long id) {
		model.addAttribute("category", categoryService.getById(id));
		model.addAttribute("products", productService.allProducts());
		return "showCategory";
	}
	
	@PostMapping("/categories/{id}")
	public String addProductToCategory(@PathVariable("id") Long id, @RequestParam("product") Long productId) {
		Category category = categoryService.getById(id);
		Product product = productService.getById(productId);
		
		List<Product> products = (List<Product>) category.getProducts();
		products.add(product);
		categoryService.update(category);
	
		return "redirect:/categories/"+id;
	}
	
}
