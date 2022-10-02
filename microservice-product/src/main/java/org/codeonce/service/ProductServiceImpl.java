package org.codeonce.service;

import java.util.ArrayList;

import org.codeonce.dao.CategoryRepository;
import org.codeonce.dao.ProductRepository;
import org.codeonce.entities.Category;
import org.codeonce.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public Product save(Product p) {
		// TODO Auto-generated method stub
		return productRepository.save(p);
	}

	@Override
	public ArrayList<Product> allProducts() {
		// TODO Auto-generated method stub
		return (ArrayList<Product>) productRepository.findAll();
	}

	@Override
	public ArrayList<Product> availableProducts() {
		// TODO Auto-generated method stub
		ArrayList<Product> allProd = new ArrayList<Product>();
		ArrayList<Product> availableProd = new ArrayList<Product>();
		allProd = this.allProducts();
		for(int i=0;i<allProd.size();i++) {
			if(allProd.get(i).getQte()>0) {
				availableProd.add(allProd.get(i));
			}
		}
		return availableProd;
	}

	@Override
	public ArrayList<Product> productsByCategorie(String catName) {
		// TODO Auto-generated method stub
		Category category = new Category();
		category =categoryRepository.findByName(catName);
		return productRepository.findByCategory(category);
	}

}
