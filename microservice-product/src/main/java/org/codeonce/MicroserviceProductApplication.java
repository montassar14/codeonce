package org.codeonce;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.codeonce.dao.CategoryRepository;
import org.codeonce.dao.ProductRepository;
import org.codeonce.entities.Category;
import org.codeonce.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MicroserviceProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProductApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CategoryRepository categoryRepository , ProductRepository productRepository) {
		return args->{
			categoryRepository.deleteAll();
			Stream.of("Ordinateurs","Imprimantes").forEach(c->{
				categoryRepository.save(new Category(c, new ArrayList<>()));
			});
			categoryRepository.findAll().forEach(System.out::println);
			
			productRepository.deleteAll();
			Category c1 =categoryRepository.findById("Ordinateurs").get();
			Stream.of("p1","P2","P3","P4").forEach(name->{
				Product p=productRepository.save(new Product(null,name,Math.random()*1000,c1));
				c1.getProducts().add(p);
				categoryRepository.save(c1);
			});
			
			Category c2 =categoryRepository.findById("Imprimantes").get();
			Stream.of("P5","P6").forEach(name->{
				Product p=productRepository.save(new Product(null,name,Math.random()*1000,c2));
				c2.getProducts().add(p);
				categoryRepository.save(c2);
			});
			
			productRepository.findAll().forEach(p->{
				System.out.println(p.getName().toString());
			});
		};
	}
}
