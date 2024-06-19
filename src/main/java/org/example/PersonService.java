package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PersonService {
    private final List<Person> persons;

    public PersonService(List<Person> persons) {
        this.persons = persons;
    }

    // List all the persons names: firstName lastName
    public List<String> getAllPersonNames() {
        return persons.stream()
                .map(person -> person.getFirstName() + " " + person.getLastName())
                .collect(Collectors.toList());
    }

    // List all persons that are major
    public List<Person> getAllMajors() {
        return persons.stream()
                .filter(person -> person.getAge() >= 18)
                .collect(Collectors.toList());
    }

    // List all persons from Oradea
    public List<Person> getAllFromOradea() {
        return persons.stream()
                .filter(person -> "Oradea".equalsIgnoreCase(person.getCity()))
                .collect(Collectors.toList());
    }

    // List all persons from Oradea OR Cluj
    public List<Person> getAllFromOradeaOrCluj() {
        return persons.stream()
                .filter(person -> "Oradea".equalsIgnoreCase(person.getCity()) || "Cluj".equalsIgnoreCase(person.getCity()))
                .collect(Collectors.toList());
    }

    // List all firstNames CAPITALIZED
    public List<String> getAllFirstNamesCapitalized() {
        return persons.stream()
                .map(person -> person.getFirstName().toUpperCase())
                .collect(Collectors.toList());
    }

    // List all person names: firstName firstletter from last name: Stefan B.
    public List<String> getAllPersonNamesWithInitial() {
        return persons.stream()
                .map(person -> person.getFirstName() + " " + person.getLastName().charAt(0) + ".")
                .collect(Collectors.toList());
    }

    // List all persons with 18 < age < 60
    public List<Person> getAllPersonsBetween18And60() {
        return persons.stream()
                .filter(person -> person.getAge() > 18 && person.getAge() < 60)
                .collect(Collectors.toList());
    }

    // List all persons having first name starting with A
    public List<Person> getAllFirstNamesStartingWithA() {
        return persons.stream()
                .filter(person -> person.getFirstName().startsWith("A"))
                .collect(Collectors.toList());
    }

    // List all first names UNIQUELY
    public List<String> getAllUniqueFirstNames() {
        return persons.stream()
                .map(Person::getFirstName)
                .distinct()
                .collect(Collectors.toList());
    }

    // Sort the persons by first name
    public List<Person> getPersonsSortedByFirstName() {
        return persons.stream()
                .sorted(Comparator.comparing(Person::getFirstName))
                .collect(Collectors.toList());
    }

    // Sort the persons by last name
    public List<Person> getPersonsSortedByLastName() {
        return persons.stream()
                .sorted(Comparator.comparing(Person::getLastName))
                .collect(Collectors.toList());
    }

    // Sort the persons by first name, last name and then age
    public List<Person> getPersonsSortedByFirstNameLastNameAndAge() {
        return persons.stream()
                .sorted(Comparator.comparing(Person::getFirstName)
                        .thenComparing(Person::getLastName)
                        .thenComparing(Person::getAge))
                .collect(Collectors.toList());
    }
}
