package com.example;
/**
 * Student Name: Megan Cash
 * Student Number: C19317723
 * TO TEST XML PARSING WHEN RUNNING JAVA APPLICATION BEFORE ADDING TO SPRING BOOT
 */

//Import Libraries
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class XMLParsingCovidVariantTest {

	public static void main(String args[]) throws IOException, ParserConfigurationException, SAXException {

		File xmlFile = new File("covidvariant.xml");

		//Instantiate the Factory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//Parse the XML file
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(xmlFile);

		//System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
		NodeList variants = doc.getElementsByTagName("fme:Sheet");
		
		for (int i= 0; i< variants.getLength(); i++) {
			Node CovidVariants = variants.item(i);
			
			if (CovidVariants.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) CovidVariants;
				
				Node week= elem.getElementsByTagName("fme:year_week").item(0);
				String calendarWeek = week.getTextContent();
				Node node = elem.getElementsByTagName("fme:variant").item(0);
				String variant = node.getTextContent();
				Node node2 = elem.getElementsByTagName("fme:country").item(0);
				String country = node2.getTextContent();
				Node node3 = elem.getElementsByTagName("fme:country_code").item(0);
				String countrycode = node3.getTextContent();
				Node node4 = elem.getElementsByTagName("fme:number_detections_variant").item(0);
				String numberOfDetections = node4.getTextContent();
			
		
				//Only data from the calendar week from 10 weeks ago should be displayed.
				if (calendarWeek.equals("2022-41")){
		
				if (!numberOfDetections.trim().equals("0")) {
					System.out.println("\nCovid Variants:");
					System.out.println("Country: " + country);
					System.out.println("Country Code: " + countrycode);
					System.out.println("Variant: " + variant);
					System.out.println("Number of variant detections: " + numberOfDetections );	
				}
				}
				
				
			}
		}
		
		
	}
}
