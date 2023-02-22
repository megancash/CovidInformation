/**
 * Student Name: Megan Cash
 * Student Number: C19317723
 * Service Layer
 */

package com.example.service;

import com.example.model.User;
import java.util.List;

public interface UserService {
    public void saveUser(User user);
    public List<Object> isUserPresent(User user);
}