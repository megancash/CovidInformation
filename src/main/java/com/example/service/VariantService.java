/**
 * Student Name: Megan Cash
 * Student Number: C19317723
 */
package com.example.service;

import com.example.model.Variant;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
	
	
	public interface VariantService {
	    public void saveVariant(Variant variant);
		public List<Variant> XMLParsingCovidData(Long id) throws ParserConfigurationException, SAXException, IOException;
		
	}