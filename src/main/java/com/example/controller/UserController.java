/**
 * Student Name: Megan Cash
 * Student Number: C19317723
 * Controller Layer
 */
package com.example.controller;

import java.lang.annotation.Target;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class UserController {



   @RequestMapping
    public String homePage(){
        return "user/home";
    }
}