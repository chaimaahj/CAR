package com.example.ecommerce.repositories;
import com.example.ecommerce.entities.Produits;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface ProductRepository extends CrudRepository<Produits, Long> {
    @Transactional(readOnly = true)
    @Cacheable("products")
    Collection<Produits> findAll() ;
    Produits findById(Integer id);
    Collection<Produits> findByNom(String nom);


}
