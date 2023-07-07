package com.example.demo.project2.repositories;

import com.example.demo.project2.entities.Project;
import com.example.demo.project2.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    @Query(value = "SELECT * FROM Users u WHERE u.id = :id", nativeQuery = true)
    Users findUserById(@Param("id") Integer id);

    @Query(value = "SELECT * FROM Users u WHERE u.email = :email", nativeQuery = true)
    Users findUserByEmail(@Param("email") String email);

    Users findByEmpId (Integer empId);

    @Query(value = "SELECT * FROM Users u WHERE u.delete = false", nativeQuery = true)
    List<Users> getAllUsers();

}
