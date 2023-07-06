package com.example.demo.project2.repositories;

import com.example.demo.project2.entities.ClientContact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientContactRepository extends CrudRepository<ClientContact , Integer> {

    List<ClientContact> findByClientId(Integer id);

    @Query(value = "SELECT c FROM ClientContact c WHERE c.id = :id and deleted = false" )
    ClientContact findClientContactById(Integer id);
}
