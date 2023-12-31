package com.example.demo.project2.repositories;

import com.example.demo.project2.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    @Query(value = "SELECT * FROM Users u WHERE u.id = :id", nativeQuery = true)
    Users findUserById(@Param("id") Integer id);
}
