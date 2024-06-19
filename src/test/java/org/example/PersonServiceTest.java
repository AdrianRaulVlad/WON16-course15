package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonServiceTest {

    private PersonService personService;

    @BeforeEach
    public void setUp() {
        List<Person> persons = Arrays.asList(
                new Person("Alice", "Smith", 25, "Oradea"),
                new Person("Bob", "Brown", 17, "Cluj"),
                new Person("Charlie", "Davis", 30, "Oradea"),
                new Person("David", "Miller", 45, "Cluj"),
                new Person("Eve", "Wilson", 70, "Oradea"),
                new Person("Frank", "Taylor", 50, "Bucharest"),
                new Person("Ana", "Johnson", 28, "Timisoara")
        );
        personService = new PersonService(persons);
    }

    @Test
    public void testGetAllPersonNames() {
        List<String> names = personService.getAllPersonNames();
        assertThat(names).containsExactly("Alice Smith", "Bob Brown", "Charlie Davis", "David Miller", "Eve Wilson", "Frank Taylor", "Ana Johnson");
    }

    @Test
    public void testGetAllMajors() {
        List<Person> majors = personService.getAllMajors();
        assertThat(majors).hasSize(6);
    }

    @Test
    public void testGetAllFromOradea() {
        List<Person> oradeaPersons = personService.getAllFromOradea();
        assertThat(oradeaPersons).hasSize(3);
    }

    @Test
    public void testGetAllFromOradeaOrCluj() {
        List<Person> oradeaOrClujPersons = personService.getAllFromOradeaOrCluj();
        assertThat(oradeaOrClujPersons).hasSize(5);
    }

    @Test
    public void testGetAllFirstNamesCapitalized() {
        List<String> capitalizedNames = personService.getAllFirstNamesCapitalized();
        assertThat(capitalizedNames).containsExactly("ALICE", "BOB", "CHARLIE", "DAVID", "EVE", "FRANK", "ANA");
    }

    @Test
    public void testGetAllPersonNamesWithInitial() {
        List<String> namesWithInitial = personService.getAllPersonNamesWithInitial();
        assertThat(namesWithInitial).containsExactly("Alice S.", "Bob B.", "Charlie D.", "David M.", "Eve W.", "Frank T.", "Ana J.");
    }

    @Test
    public void testGetAllPersonsBetween18And60() {
        List<Person> personsBetween18And60 = personService.getAllPersonsBetween18And60();
        assertThat(personsBetween18And60).hasSize(5);
    }

    @Test
    public void testGetAllFirstNamesStartingWithA() {
        List<Person> namesStartingWithA = personService.getAllFirstNamesStartingWithA();
        assertThat(namesStartingWithA).hasSize(2);
    }

    @Test
    public void testGetAllUniqueFirstNames() {
        List<String> uniqueFirstNames = personService.getAllUniqueFirstNames();
        assertThat(uniqueFirstNames).containsExactlyInAnyOrder("Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Ana");
    }

    @Test
    public void testGetPersonsSortedByFirstName() {
        List<Person> sortedByFirstName = personService.getPersonsSortedByFirstName();
        assertThat(sortedByFirstName.get(0).getFirstName()).isEqualTo("Alice");
        assertThat(sortedByFirstName.get(1).getFirstName()).isEqualTo("Ana");
    }

    @Test
    public void testGetPersonsSortedByLastName() {
        List<Person> sortedByLastName = personService.getPersonsSortedByLastName();
        assertThat(sortedByLastName.get(0).getLastName()).isEqualTo("Brown");
        assertThat(sortedByLastName.get(1).getLastName()).isEqualTo("Davis");
    }

    @Test
    public void testGetPersonsSortedByFirstNameLastNameAndAge() {
        List<Person> sortedByAll = personService.getPersonsSortedByFirstNameLastNameAndAge();
        assertThat(sortedByAll.get(0).getFirstName()).isEqualTo("Alice");
        assertThat(sortedByAll.get(1).getFirstName()).isEqualTo("Ana");
    }
}
