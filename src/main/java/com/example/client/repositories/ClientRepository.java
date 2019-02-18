package com.example.client.repositories;

import com.example.client.domain.ClientPersitent;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface ClientRepository extends CrudRepository<ClientPersitent, String> {
    List<ClientPersitent> findByName(String name);
}
