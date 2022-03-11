package com.example.ecommerce.repositories;
import com.example.ecommerce.entities.LigneCommande;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

public interface LigneCommandeRepository extends CrudRepository<LigneCommande, Long> {
    @Transactional(readOnly = true)
    @Cacheable("lignecommande")
    Collection<LigneCommande> findAll() ;
    Optional<LigneCommande> findByIdProduit(Long idProduit);



}
