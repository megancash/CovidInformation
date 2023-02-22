/**
 * Student Name: Megan Cash
 * Student Number: C19317723
 * Country class: Placeholder for the country attributes
 */
package com.example.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

	@Entity
	@Table(name = "countries")
	public class Country {
		

		public Country() {
		
		
		}
		
		public Country(long id, String country, int calendarWeek, String value) {
			super();
			this.id = id;
		    this.country=country;
		    this.calendarWeek= calendarWeek;
		    this.value=value;
		}


		@SequenceGenerator(name = "country_sequence", sequenceName = "country_sequence", allocationSize = 1)
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_sequence")
		private long id;
		
		@Column (name="country")
		private String country;
		
		@Column (name="calendarWeek")
		private int calendarWeek;
		
		@Column (name="value")
		private String value;

		//Getter and Setter Methods
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public int getCalendarWeek() {
			return calendarWeek;
		}

		public void setCalendarWeek(int calendarWeek) {
			this.calendarWeek = calendarWeek;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	
		
	}
