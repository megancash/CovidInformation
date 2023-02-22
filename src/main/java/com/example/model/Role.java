/**
 * Student Name: Megan Cash
 * Student Number: C19317723
 * Role class: Placeholder for the role attributes
 */
package com.example.model;


public enum Role {
    USER("User"),
    ADMIN("Admin");



   private final String value;



   private Role(String value) {
        this.value = value;
    }



   public String getValue() {
        return value;
    }
}
