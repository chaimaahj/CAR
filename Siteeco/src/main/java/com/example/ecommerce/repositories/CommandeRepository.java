package com.example.ecommerce.repositories;
import com.example.ecommerce.entities.Client;
import com.example.ecommerce.entities.Commande;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface CommandeRepository  extends CrudRepository<Commande, Long> {
    @Transactional(readOnly = true)
    @Cacheable("commande")
    Collection<Commande> findAll() throws DataAccessException;


}