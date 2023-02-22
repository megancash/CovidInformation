/**
 * Student Name: Megan Cash
 * Student Number: C19317723
 * Variant class: Placeholder for the variant attributes
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
	@Table(name = "variants")
	public class Variant {
		

		public Variant() {
		
		
		}
		
		public Variant(long id, String country, int calendarWeek, String countrycode, String variant, String numberOfDetections) {
			super();
			this.id = id;
		    this.country=country;
		    this.calendarWeek= calendarWeek;
		    this.countrycode = countrycode;
		    this.variant=variant;
		    this.numberOfDetections = numberOfDetections;
		}


		@SequenceGenerator(name = "variant_sequence", sequenceName = "variant_sequence", allocationSize = 1)
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "variant_sequence")
		private long id;
		
		@Column (name="country")
		private String country;
		
		@Column (name="calendarWeek")
		private int calendarWeek;
		
		@Column (name="countrycode")
		private String countrycode;
		
		@Column (name="variant")
		private String variant;
		
		@Column (name="numberOfDetections")
		private String numberOfDetections;

		
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

		public String getCountrycode() {
			return countrycode;
		}

		public void setCountrycode(String countrycode) {
			this.countrycode = countrycode;
		}

		public String getVariant() {
			return variant;
		}

		public void setVariant(String variant) {
			this.variant = variant;
		}

		public String getNumberOfDetections() {
			return numberOfDetections;
		}

		public void setNumberOfDetections(String numberOfDetections) {
			this.numberOfDetections = numberOfDetections;
		}
		
		
		
	}

