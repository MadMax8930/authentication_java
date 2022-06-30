package com.max.safetyalerts.auth.payload.request;

import lombok.Data;

import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.validation.constraints.*;

@Data
public class SignupRequest {
   private String email;
   private int id;
   private String firstName;
   private String lastName;
   private String address;
   private String city;
   private String zip;
   private String phone;
   private long age;
   private List<String> medications;
   private List<String> allergies;
   private List<String> station;
   private String role;
   private String password;
}
