package com.max.safetyalerts.service;

import com.max.safetyalerts.dto.PersonInfoDto;
import com.max.safetyalerts.model.*;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.List;

public interface PersonService {

    Iterable<Person> listAllPersonns();

    public Person save(Person Person);

    public Iterable<Person> save(List<Person> people);


    public List<PersonInfoDto> getlistPersonsByFirstNameAndLastName(String firstName, String lastName);

    public List<Child> getlistOfChildren(String address) throws ParseException;

    public List<Person> getAllInformationsForPersonnAtAnAddress(String address);

    public List<Person> findPersonByAddress(String address);

    public List<Email> getEmailPerCity(String city);

    public ResponseEntity deletePerson(String firstName,String lastName);

    public Person updatePerson(String firstName, String lastName, Person PersonDetails);


}
