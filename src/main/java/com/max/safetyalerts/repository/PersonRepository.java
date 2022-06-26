package com.max.safetyalerts.repository;

import com.max.safetyalerts.model.Person;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

    List<Person> findPersonByFirstNameAndLastName(String firstName, String lastName);

    List<Person> findPersonByAddress(String address, Sort sort);

    List<Person> findPersonByCity(String city);

    Person findPersonById(int id);

}
