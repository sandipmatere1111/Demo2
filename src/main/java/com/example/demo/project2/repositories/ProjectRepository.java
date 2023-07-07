package com.example.demo.project2.repositories;

import com.example.demo.project2.entities.Client;
import com.example.demo.project2.entities.ClientContact;
import com.example.demo.project2.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer> {

    @Query(value = "SELECT * FROM project WHERE deleted = false", nativeQuery = true)
    List<Project> getAllProjects();

    @Override
    Optional<Project> findById(Integer id);

    List<Project> findByClientId(Integer id);

}
