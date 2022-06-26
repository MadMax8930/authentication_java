package com.max.safetyalerts.service;

import com.max.safetyalerts.model.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    @Mock
    PersonService personService;

    Boolean deleted = false;

    @Test
    public void deletePerson(){
        Person p = new Person();
        p.setFirstName("John");
        p.setLastName("Wayne");

        personService.deletePerson(p);
        // verif que l'appel au service a été exécutée successfully, test check
        Mockito.verify(personService, Mockito.times(1)).deletePerson(p);
    }
}
