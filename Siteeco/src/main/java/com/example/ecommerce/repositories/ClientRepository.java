package com.example.ecommerce.repositories;
import com.example.ecommerce.entities.Client;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ClientRepository  extends CrudRepository<Client, Long> {
    @Transactional(readOnly = true)
    @Cacheable("client")
    Iterable<Client> findAll();

    Client findByLogin(String login);


}

