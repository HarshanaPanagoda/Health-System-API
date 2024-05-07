package com.mycompany.dao;

import com.mycompany.models.Person;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonDAO {
    private static final Logger logger = LoggerFactory.getLogger(PersonDAO.class);
    private static PersonDAO instance;  // Singleton instance
    private final Map<Long, Person> personMap = new HashMap<>();

    public PersonDAO() {
        // Initialize with sample persons
        Person person1 = new Person(1, "John Doe", "555-123-4567", "123 Main St, Anytown, USA");
        Person person2 = new Person(2, "Dr. Johnson", "555-333-4444", "101 Pine St, Othertown, USA");


        personMap.put(person1.getId(), person1);
        personMap.put(person2.getId(), person2);
       
    }

    // Public method to get the singleton instance
    public static synchronized PersonDAO getInstance() {
        if (instance == null) {
            instance = new PersonDAO();
        }
        return instance;
    }

    // Get all persons
    public Collection<Person> getAllPersons() {
        return personMap.values();
    }

    // Add a person
    public void addPerson(Person person) {
        if (!personMap.containsKey(person.getId())) {
            personMap.put(person.getId(), person);
            logger.info("Successfully added person with ID: {}", person.getId());
        } else {
            logger.error("A person with ID {} already exists and was not added.", person.getId());
        }
    }

    // Retrieve a person by ID
    public Person getPersonById(long id) {
        return personMap.get(id);
    }

    // Update a person's details
   public boolean updatePerson(Person person) {
    if (personMap.containsKey(person.getId())) {
        personMap.put(person.getId(), person);
        return true;
    }
    return false;
}


    // Delete a person
  public boolean deletePerson(long id) {
    if (personMap.containsKey(id)) {
        personMap.remove(id);
        return true;
    }
    return false;
}

}
