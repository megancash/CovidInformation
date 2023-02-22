/**
 * Student Name: Megan Cash
 * Student Number: C19317723
 * Task 1: Identify the current week number from the table in the center of this web page. This will allow you to calculate the week number of 10 weeks ago. 
 * We will use only data for that week to ensure a full week of data is available.
 * 
 * Task 2: You must parse the XML data. You are required to store data for ONLY countries that provide daily hospital occupancy.
 * If they provide more than 1 figure for that week, you should take all the provided daily hospital occupancy figures for that week & create an
 * average daily hospital occupancy. The country info stored should include country name & country code should be stored. The week number and daily hospital occupancy value for each
 * country should also be stored.
 */
package com.example.service;

import com.example.service.CountryService;
import com.example.model.Country;
import com.example.repository.CountryRepository;

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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;



@Service
public class CountryServiceImplementation implements CountryService {





@Override
public List<Country> XMLParsingCovidData(Long id) throws ParserConfigurationException, SAXException, IOException {{
	
	//Country ArrayList
	List<Country> countries = new ArrayList<>();
	
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
		
//ASSIGNMENT BRIEF TASK 2: Parsing Covid Data File

		File xmlFile = new File("coviddata.xml"); 

		//Instantiate the Factory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//Parse the XML file
		DocumentBuilder builder = factory.newDocumentBuilder();
		org.w3c.dom.Document doc2 = builder.parse(xmlFile);

		//System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
		NodeList occupancy = doc2.getElementsByTagName("fme:Sheet");
		
	
		
		for (int i= 0; i< occupancy.getLength(); i++) {
			Node DailyHospitalOccupancy = occupancy.item(i);
			
			if (DailyHospitalOccupancy.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) DailyHospitalOccupancy;
				
				Element total = (Element)occupancy.item(i);
			
				
				Node node= elem.getElementsByTagName("fme:year_week").item(0);
				String calendarWeek = node.getTextContent();
				Node node1 = elem.getElementsByTagName("fme:country").item(0);
				String country = node1.getTextContent();
				Node node2 = elem.getElementsByTagName("fme:value").item(0);
				String value = node2.getTextContent();
				Node node3=elem.getElementsByTagName("fme:indicator").item(0);
				String indicator= node3.getTextContent();
				
				String[] weekCalculator = calendarWeek.split("-");
				
				//Store data for ONLY countries that provide daily hospital occupancy and for the calendar week specified.
				 if (indicator.equalsIgnoreCase("Daily hospital occupancy") && calendarWeek.equals("2022-W41") && (!value.trim().equals("0"))) {
					 
					 //if (indicator.equalsIgnoreCase("Daily hospital occupancy") && weekCalculator[0].equals(String.valueOf(year) && (!value.trim().equals("0"))) {
					 //To calculate the calendar week from the 'fme:year_week' value
					 String week2 = weekCalculator[1].substring(1);
					 //To parse the week string as an Integer
					 int week3 = Integer.parseInt(week2);
					 
					 //To ensure the calendar week is from 10 weeks ago
					 //if (week3== week-10) {
					 
					 //To look for the countries in the covid data file
					 Country covidCountries = extractCountry (countries, country);
					 
					 //Calculate the average of the daily hospital occupancy, if the country provides more than one figure for that week.
				  
				  System.out.println("\n" + indicator + ":");
				  System.out.println("Week: " + calendarWeek);
				  System.out.println("Country: " + country);
				  System.out.println("Daily Hospital occupancy value: " + value); 
					 }
				 }

			}
		}
return null;

	}


@Override
public Country extractCountry(List<Country> countries, String country) {
	for (Country covidCountries : countries) {
		if (covidCountries.getCountry().equalsIgnoreCase(country)) {
			return covidCountries;
		}
		
	}
	return null;
	
	
}
@Override
public void saveCountry(Country country) {
	// TODO Auto-generated method stub
	
}


@Override
public void delete(List<Country> countries) {
	// TODO Auto-generated method stub
	
}

}




