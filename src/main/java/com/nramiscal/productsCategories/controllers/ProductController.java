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
public class ProductController {

		private final ProductService productService;
		private final CategoryService categoryService;
		
		public ProductController(ProductService productService, CategoryService categoryService) {
			this.productService = productService;
			this.categoryService = categoryService;
		}
		
		@RequestMapping("/")
		public String index() {
			return "redirect:/products/new";
		}
		
		@RequestMapping("/products/new")
		public String newProduct(@Valid @ModelAttribute("product") Product product) {
			return "newProduct";
		}
		
		@PostMapping("/products/new")
		public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
			if (result.hasErrors()) {
				return "newProduct";
			}else {
				productService.addProduct(product);
				return "redirect:/";
			}
		}
		
		@RequestMapping("/products/{id}")
		public String show(Model model, @PathVariable("id") Long id) {
			model.addAttribute("product", productService.getById(id));
			model.addAttribute("categories", categoryService.allCategories());
			return "showProduct";
		}
		
		@PostMapping("/products/{id}")
		public String addCategoryToProduct(@PathVariable("id") Long id, @RequestParam("category") Long categoryId) {
			Product product = productService.getById(id);
			Category category = categoryService.getById(categoryId);
			
			List<Category> categories = (List<Category>) product.getCategories();
			categories.add(category);
			productService.update(product);
			
			return "redirect:/products/"+id;
		}
}
