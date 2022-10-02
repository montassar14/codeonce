package org.codeonce.dao;

import java.util.ArrayList;

import org.codeonce.entities.Category;
import org.codeonce.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
//@RepositoryRestResource
//@CrossOrigin("*")
public interface ProductRepository extends MongoRepository<Product, String> {

	public 	ArrayList<Product> findByCategory(Category c);
}
