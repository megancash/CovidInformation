/**
 * Student Name: Megan Cash
 * Student Number: C19317723
 * VariantRepository: Repository for accessing the Variant details from the SQL Database, Extending the repositories from 
 * Spring JPARepository interface.
 */
package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Variant;


	@Repository
	public interface VariantRepository extends JpaRepository<Variant, Long> {

}
