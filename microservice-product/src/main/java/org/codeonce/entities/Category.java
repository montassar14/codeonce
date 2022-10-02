package org.codeonce.entities;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Document
public class Category {
	@Id
	private String name;
	@JsonIgnore
	@DBRef
	private Collection<Product> products = new ArrayList<Product>();
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(String name, Collection<Product> products) {
		super();
		this.name = name;
		this.products = products;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<Product> getProducts() {
		return products;
	}
	public void setProducts(Collection<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Category [ name=" + name + ", products=" + products + "]";
	}

	
}
