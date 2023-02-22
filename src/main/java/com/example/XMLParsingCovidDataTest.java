package com.example;
/**
 * Student Name: Megan Cash 
 * Student Number: C19317723 
 * TO TEST XML PARSING WHEN RUNNING JAVA APPLICATION BEFORE ADDING TO SPRING BOOT
 */


  import java.io.File; //Import Libraries import java.io.IOException;
import java.io.IOException;
import java.time.DayOfWeek; import java.time.LocalDate; import
  java.time.temporal.ChronoField; import java.time.temporal.TemporalAdjusters;
  import java.util.ArrayList; import java.util.Collections; import
  java.util.List;
  
  import javax.xml.parsers.DocumentBuilder; import
  javax.xml.parsers.DocumentBuilderFactory; import
  javax.xml.parsers.ParserConfigurationException;
  
  import org.w3c.dom.NodeList; import org.xml.sax.SAXException; import
  org.w3c.dom.Node; import org.jsoup.Jsoup; import org.w3c.dom.NodeList; import
  org.w3c.dom.Node; import org.w3c.dom.Element; import
  org.jsoup.select.Elements; import org.jsoup.parser.*; import
  com.example.model.Country;
  
  
  
 
 
  public class XMLParsingCovidDataTest {
  
  public static void main(String[] args) throws ParserConfigurationException,
  SAXException {
  
  
  
  try { String url = "https://www.epochconverter.com/weeks/2022";
  org.jsoup.nodes.Document doc =
  Jsoup.connect("https://www.epochconverter.com/weeks/2022").get();
  org.jsoup.select.Elements allRows = doc.getElementsByTag("tr");
  
  LocalDate currentDate = LocalDate.now(); LocalDate tenWeeksPrevious =
  currentDate.with(
  TemporalAdjusters.previous(DayOfWeek.MONDAY)).minusWeeks(10);
  
  int week = tenWeeksPrevious.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
  
  for (org.jsoup.nodes.Element row : allRows) { Elements rowData =
  row.getElementsByTag("td");
  
  if (row.attr("class").equalsIgnoreCase("currentweek")) {
  System.out.println("10 weeks ago, the calendar week number was: " + week); }
  
  } File xmlFile = new File("coviddata.xml");
  
  //Instantiate the Factory 
  DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); //Parse the XML file 
  DocumentBuilder builder = factory.newDocumentBuilder(); org.w3c.dom.Document doc2 =
  builder.parse(xmlFile);
  
  //System.out.println("Root element: " + doc.getDocumentElement().getNodeName()); 
  NodeList occupancy = doc2.getElementsByTagName("fme:Sheet");
  
  List<Country> countries = new ArrayList<Country>();
  
  for (int i= 0; i< occupancy.getLength(); i++) { Node DailyHospitalOccupancy =
  occupancy.item(i); if (DailyHospitalOccupancy.getNodeType() ==
  Node.ELEMENT_NODE) { Element elem = (Element) DailyHospitalOccupancy;
  
  Element total = (Element)occupancy.item(i);
  
  
  Node node= elem.getElementsByTagName("fme:year_week").item(0); String
  calendarWeek = node.getTextContent(); Node node1 =
  elem.getElementsByTagName("fme:country").item(0); String country =
  node1.getTextContent(); Node node2 =
  elem.getElementsByTagName("fme:value").item(0); String value =
  node2.getTextContent(); Node
  node3=elem.getElementsByTagName("fme:indicator").item(0); String indicator=
  node3.getTextContent();
  
  //Store data for ONLY countries that provide daily hospital occupancy.
  if (calendarWeek.equals("2022-W41")){ if (!value.trim().equals("0")) {
  
  System.out.println("\nDaily Hospital Occupancy:");
  System.out.println(indicator); System.out.println(calendarWeek);
  System.out.println("Country: " + country);
  System.out.println("Daily Hospital occupancy value: " + value);
  
  
  //Convert the string value into a double 
  double actualValue = Double.parseDouble(value);
  
  //If a country has more than one figure for that week, create an average daily hospital occupancy. 
  //int countAustria=Collections.frequency(countries, "Austria");
  
  
  
  
  
  
  
  } }
  
  } } } catch (IOException e) { e.printStackTrace(); } } }
  
  
 