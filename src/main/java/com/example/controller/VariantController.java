/**
 * Student Name: Megan Cash
 * Student Number: C19317723
 * Controller Layer
 */
package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.service.VariantService;

@Controller
public class VariantController {
	
	@Autowired
	VariantService variantService;
	
	//Mapping
	 @GetMapping
	    public String homePage(){
	        return "user/home";

	 //Connecting to REST API with all the methods 
}
}
