package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Alice", "Smith", 25, "Oradea"),
                new Person("Bob", "Brown", 17, "Cluj"),
                new Person("Charlie", "Davis", 30, "Oradea"),
                new Person("David", "Miller", 45, "Cluj"),
                new Person("Eve", "Wilson", 70, "Oradea"),
                new Person("Frank", "Taylor", 50, "Bucharest"),
                new Person("Ana", "Johnson", 28, "Timisoara")
        );

        PersonService personService = new PersonService(persons);

        System.out.println("All persons names: ");
        personService.getAllPersonNames().forEach(System.out::println);

        System.out.println("\nAll persons that are major: ");
        personService.getAllMajors().forEach(System.out::println);

        System.out.println("\nAll persons from Oradea: ");
        personService.getAllFromOradea().forEach(System.out::println);

        System.out.println("\nAll persons from Oradea or Cluj: ");
        personService.getAllFromOradeaOrCluj().forEach(System.out::println);

        System.out.println("\nAll first names CAPITALIZED: ");
        personService.getAllFirstNamesCapitalized().forEach(System.out::println);

        System.out.println("\nAll person names with initial: ");
        personService.getAllPersonNamesWithInitial().forEach(System.out::println);

        System.out.println("\nAll persons with 18 < age < 60: ");
        personService.getAllPersonsBetween18And60().forEach(System.out::println);

        System.out.println("\nAll persons having first name starting with A: ");
        personService.getAllFirstNamesStartingWithA().forEach(System.out::println);

        System.out.println("\nAll first names UNIQUELY: ");
        personService.getAllUniqueFirstNames().forEach(System.out::println);

        System.out.println("\nPersons sorted by first name: ");
        personService.getPersonsSortedByFirstName().forEach(System.out::println);

        System.out.println("\nPersons sorted by last name: ");
        personService.getPersonsSortedByLastName().forEach(System.out::println);

        System.out.println("\nPersons sorted by first name, last name, and age: ");
        personService.getPersonsSortedByFirstNameLastNameAndAge().forEach(System.out::println);
    }
}
