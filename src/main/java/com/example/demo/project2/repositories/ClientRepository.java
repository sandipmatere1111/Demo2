package com.example.demo.project2.repositories;

import com.example.demo.project2.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Query(value = "SELECT * FROM client WHERE deleted = false", nativeQuery = true)
    List<Client> getAll();
    @Query(value = "SELECT * FROM client WHERE id = ?1 AND deleted = false", nativeQuery = true)
    List<Client> findAllById(int id);

    @Query(value = "SELECT c FROM Client c WHERE c.id = :id" )
    Client findClientById(Integer id);
}
