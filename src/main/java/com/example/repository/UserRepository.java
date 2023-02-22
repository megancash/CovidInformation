/**
 * Student Name: Megan Cash
 * Student Number: C19317723
 * UserRepository: Repository for accessing the User & Role details from the SQL Database, Extending the repositories from 
 * Spring JPARepository interface.
 */
package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.User;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByMobile(String mobile);
}