/**
 * Student Name: Megan Cash
 * Student Number: C19317723
 * Controller Layer
 */
package com.example.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.xml.sax.SAXException;

import com.example.model.Country;
import com.example.repository.CountryRepository;
import com.example.service.CountryService;
import com.example.service.CountryServiceImplementation;

@Controller
public class CountryController {

	/*
	 * @Autowired CountryService countryService;
	 */

	/*
	 * // Mapping
	 * 
	 * @GetMapping public String homePage2() { return "user/home"; }
	 */
	/*
	 * @GetMapping public List<Country> extractCountry() { return null; }
	 * 
	 * @GetMapping("/{id}") ResponseEntity<Country>
	 * extractCountry(@PathVariable(value = "id") long id) { return null;
	 * 
	 * Optional<Country> countries = CountryRepository.findById(id);
	 * 
	 * if (countries.isPresent()) { return
	 * ResponseEntity.ok().body(countries.get()); } else { return
	 * ResponseEntity.notFound().build(); } }
	 */

	/*
	 * @GetMapping("/parse") public ResponseEntity<List<Country>>
	 * XMLParsingCovidData() throws ParserConfigurationException, SAXException,
	 * IOException { List<Country> countries =
	 * countryService.XMLParsingCovidData(null); return
	 * ResponseEntity.ok(countries); }
	 */

	/*
	 * //Create a new Country
	 * 
	 * @PostMapping public List<Country> addCountry() { return null;
	 * 
	 * }
	 * 
	 * //Update a country
	 * 
	 * @PutMapping public List<Country> updateCountry() { return null; }
	 * 
	 * //Delete a country
	 * 
	 * @DeleteMapping ResponseEntity<List<Country>> deleteCountry() throws
	 * ParserConfigurationException, SAXException, IOException { List<Country>
	 * countries = countryService.XMLParsingCovidData(null);
	 * countryService.delete(countries); return ResponseEntity.ok(countries); }
	 */

}
