package org.codeonce.service;

import java.util.ArrayList;

import org.codeonce.entities.Product;

public interface ProductService {

	public Product save(Product p);
	public ArrayList<Product> allProducts();
	public ArrayList<Product> availableProducts();
	public ArrayList<Product> productsByCategorie(String CatName);
}
