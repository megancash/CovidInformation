/**
 * Student Name: Megan Cash
 * Student Number: C19317723
 * CountryRepository: Repository for accessing the Country details from the SQL Database, Extending the repositories from 
 * Spring JPARepository interface.
 */

package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Country;


	@Repository
	public interface CountryRepository extends JpaRepository<Country, Long> {
		
}

