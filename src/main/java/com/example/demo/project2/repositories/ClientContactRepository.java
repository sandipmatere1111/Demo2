package com.example.demo.project2.repositories;

import com.example.demo.project2.entities.ClientContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ClientContactRepository extends CrudRepository<ClientContact , Integer> {

    List<ClientContact> findByClientId(Integer id);
}
