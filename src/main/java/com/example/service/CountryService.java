/**
 * Student Name: Megan Cash
 * Student Number: C19317723
 * Service Layer
 */
package com.example.service;

import com.example.model.Country;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;
	
	public interface CountryService {
	    public void saveCountry(Country country);
		public List<Country> XMLParsingCovidData(Long id) throws ParserConfigurationException, SAXException, IOException;
		Country extractCountry(List<Country> countries, String country);
		public void delete(List<Country> countries);
		
	}


