package com.nramiscal.productsCategories.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="categories")
public class Category {

	@Id
	@GeneratedValue
	Long id;
	
	@Column
	@Size(min=1, max=255)
	private String name;
	
	@Column
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date created_at;
	
	@Column
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date updated_at;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name  ="categories_products",
			joinColumns = @JoinColumn(name = "category_id"),
			inverseJoinColumns = @JoinColumn(name = "product_id")
			
	)
	
	private List<Product> products;
	
	
	// constructors
	public Category() {}
	
	public Category(String name) {
		super();
		this.name = name;
	}

	// created_at, updated_at
	@PrePersist
	protected void onCreate(){
	this.created_at = new Date();
	}

	@PreUpdate
	protected void onUpdate(){
	this.updated_at = new Date();
	}
	
	// getters

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public List<Product> getProducts() {
		return products;
	}

	// setters
	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	

	
}
