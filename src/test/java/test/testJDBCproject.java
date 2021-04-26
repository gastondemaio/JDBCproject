package test;

import data.PersonDAO;
import domain.Person;

import java.util.*;

public class testJDBCproject {
    public static void main(String[] args) {

        PersonDAO personDAO = new PersonDAO();

        //It delete a record
        Person deletePerson = new Person(7);
        personDAO.delete(deletePerson);


        //It insert a new person type's object
        /*Person newPerson = new Person("Ricardo", "Ford", "156944", "ricardoford@gmail.com");
        personDAO.insert(newPerson);
        */

        //It update an existent person's object
        /*Person modifyPerson = new Person(6, "Natali", "De Maio", "148257", "nataliagostina@gmail.com");
        personDAO.update(modifyPerson);
        */

        //Update a person
        List<Person> persons = personDAO.select();
        persons.forEach(person -> {
            System.out.println("person = " + person);
        });


        //Select
       /*List<Person> persons = personDAO.select();
          persons.stream().map(person -> "Persons: " + person).forEach(System.out::println);
        */
    }

}
