package org.codeonce.web;

import java.util.ArrayList;

import org.codeonce.entities.Product;
import org.codeonce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/App")
public class ProductRestController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public ArrayList<Product> getAvailableProduct(){
		return productService.availableProducts();
	}
	@GetMapping("/products/{catName}")
	public ArrayList<Product> getProductsByCat(@PathVariable("catName") String catName){
		
		return productService.productsByCategorie(catName);
	}
}
