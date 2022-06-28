package com.max.safetyalerts.repository;

import com.max.safetyalerts.model.Person;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

    List<Person> findPersonByFirstNameAndLastName(String firstName, String lastName);

    List<Person> findPersonByAddress(String address, Sort sort);

    List<Person> findPersonByCity(String city);
    Boolean existsByEmail(String email);
    Person findPersonById(int id);
    Person findPersonByEmail(String email);
    Optional<Person> findByEmail(String username);
    Optional<Person> findById(Long id);
//
//    Boolean existsByUsername(String username);
//    Boolean existsByEmail(String email);
}
