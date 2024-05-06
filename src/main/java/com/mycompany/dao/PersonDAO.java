package com.mycompany.dao;

import com.mycompany.models.Person;
import java.util.HashMap;
import java.util.Map;

public class PersonDAO {
    private final Map<Long, Person> personMap = new HashMap<>();
    
    // Create operation
    public void addPerson(Person person) {
        personMap.put(person.getId(), person);
    }
    
    // Read operation
    public Person getPersonById(long id) {
        return personMap.get(id);
    }
    
    // Update operation
    public void updatePerson(Person person) {
        if (personMap.containsKey(person.getId())) {
            personMap.put(person.getId(), person);
        }
    }
    
    // Delete operation
    public void deletePerson(long id) {
        personMap.remove(id);
    }
}
