package com.example.ecommerce;

import com.example.ecommerce.entities.Produits;
import com.example.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class SiteApplication implements CommandLineRunner, WebMvcConfigurer {
	@Autowired
	ProductRepository pr;


	public static void main(String[] args) {
		SpringApplication.run(SiteApplication.class, args);
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/static/")
				.setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
	}
	@Override
	public void run(String... args) throws  Exception{

		pr.save(new Produits("Faces","images/faces.jpg",130.80,5));
		pr.save(new Produits("Forest","images/forest.jpg",200.67,9));
		pr.save(new Produits("Anime","images/anime.jpg",350.00,20));
		pr.save(new Produits("City","images/city.png",250.99,40));
		for(Produits product : pr.findAll()){
			System.out.println("     "+ product.toString());
		}
	}



}
