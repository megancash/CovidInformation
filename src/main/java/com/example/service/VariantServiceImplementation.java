/**
 * Student Name: Megan Cash
 * Student Number: C19317723
 * Task 1: Identify the current week number from the table in the center of this web page. This will allow you to calculate the week number of 10 weeks ago. 
 * We will use only data for that week to ensure a full week of data is available.
 * 
 * Task 3: For the countries that are valid and for the specified week, parse and store all the covid variants found during testing along with the number
 * of that variant detected. Store the country code for each country also.
 */
package com.example.service;

import java.io.File;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.example.model.Country;
import com.example.model.Variant;

@Service
public class VariantServiceImplementation implements VariantService {







@Override
public void saveVariant(Variant variant) {
	// TODO Auto-generated method stub
	
}



@Override
public List<Variant> XMLParsingCovidData(Long id) throws ParserConfigurationException, SAXException, IOException {{
	
	//Country ArrayList
	List<Variant> variants = new ArrayList<>();

//ASSIGNMENT BRIEF TASK 1: To get the calendar week number from 10 weeks ago
	
	int year = 2022; // To ensure the year of the specified calendar week is 2022
	int week = 0;
	
		
		String url = "https://www.epochconverter.com/weeks/2022";
		org.jsoup.nodes.Document doc = Jsoup.connect(url).get();
		org.jsoup.select.Elements allRows = doc.getElementsByTag("tr");
		
		LocalDate currentDate = LocalDate.now();
		LocalDate tenWeeksPrevious = currentDate.with( TemporalAdjusters.previous(DayOfWeek.MONDAY)).minusWeeks(10);
		
		int weekSpecified= tenWeeksPrevious.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
		
		for (org.jsoup.nodes.Element row : allRows) {
			Elements rowData = row.getElementsByTag("tr");
			
				if (row.attr("class").equalsIgnoreCase("currentweek")) {
					System.out.println("10 weeks ago, the calendar week number was: " + week);
			}
				
		}

//ASSIGNMENT BRIEF TASK 3: Parsing Covid Variant File
		
		File xmlFile = new File("covidvariant.xml"); 

		//Instantiate the Factory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//Parse the XML file
		DocumentBuilder builder = factory.newDocumentBuilder();
		org.w3c.dom.Document doc2 = builder.parse(xmlFile);

		NodeList covidVariants = doc2.getElementsByTagName("fme:Sheet");
		
	
		for (int i= 0; i< covidVariants.getLength(); i++) {
			Node CovidVariants = covidVariants.item(i);
			
			if (CovidVariants.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) CovidVariants;
				
				Node node= elem.getElementsByTagName("fme:year_week").item(0);
				String calendarWeek = node.getTextContent();
				Node node1 = elem.getElementsByTagName("fme:variant").item(0);
				String variant = node1.getTextContent();
				Node node2 = elem.getElementsByTagName("fme:country").item(0);
				String country = node2.getTextContent();
				Node node3 = elem.getElementsByTagName("fme:country_code").item(0);
				String countrycode = node3.getTextContent();
				Node node4 = elem.getElementsByTagName("fme:number_detections_variant").item(0);
				String numberOfDetections = node4.getTextContent();
			
				String[] weekCalculator = calendarWeek.split("-");
		
				//Only data from the calendar week from 10 weeks ago should be displayed.
				//Do not store if no cases were found.
				if (calendarWeek.equals("2022-41") && !numberOfDetections.trim().equals("0")) {
					
					 //if (weekCalculator[0].equals(String.valueOf(year) && (!value.trim().equals("0"))) {
					 //To calculate the calendar week from the 'fme:year_week' value
					 String week2 = weekCalculator[1].substring(1);
					 //To parse the week string as an Integer
					 int week3 = Integer.parseInt(week2);
					 
					 //To ensure the calendar week is from 10 weeks ago
					 //if (week3== week-10) {
					 
					 //To look for the countries in the covid data file
					 Variant covidVariant = extractVariant (variants, variant);
					 
					System.out.println("\nCovid Variants:");
					System.out.println("Country: " + country);
					System.out.println("Week: " + calendarWeek);
					System.out.println("Country Code: " + countrycode);
					System.out.println("Variant: " + variant);
					System.out.println("Number of variant detections: " + numberOfDetections );	
				  
				 }
			 }

		}
	}

return null;
}



private Variant extractVariant(List<Variant> variants, String variant) {
	for (Variant covidVariant : variants) {
		if (covidVariant.getVariant().equalsIgnoreCase(variant)) {
			return covidVariant;
	}
}
return null;

}

}



