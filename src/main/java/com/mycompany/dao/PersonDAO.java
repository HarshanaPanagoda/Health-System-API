package com.mycompany.dao;

import com.mycompany.models.Person;

import java.util.HashMap;
import java.util.Map;

public class PersonDAO {
    private final Map<Long, Person> personMap = new HashMap<>();

    public PersonDAO() {
        // Initialize with sample persons
        Person person1 = new Person(1, "John Doe", "1234567890", "123 Main St");
        Person person2 = new Person(2, "Jane Smith", "0987654321", "456 Elm St");

        personMap.put(person1.getId(), person1);
        personMap.put(person2.getId(), person2);
    }

    public void addPerson(Person person) {
        personMap.put(person.getId(), person);
    }

    public Person getPersonById(long id) {
        return personMap.get(id);
    }

    public void updatePerson(Person person) {
        if (personMap.containsKey(person.getId())) {
            personMap.put(person.getId(), person);
        }
    }

    public void deletePerson(long id) {
        personMap.remove(id);
    }
}
