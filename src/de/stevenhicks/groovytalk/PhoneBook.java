package de.stevenhicks.groovytalk;

import java.util.List;
import java.util.Optional;

/**
 * Created by steven on 6/1/16.
 */
public class PhoneBook {
    private List<Person> listOfPeople;

    public PhoneBook(List<Person> listOfPeople) {
        this.listOfPeople = listOfPeople;
    }

    public Optional<Person> findByPersonsFirstName(String firstNameToFind) {
        Optional<Person> result = Optional.empty();

        for (Person current : listOfPeople) {
            if (current.getFirstName().equals(firstNameToFind)) {
                result = Optional.of(current);
            }
        }

        return result;
    }

    public Optional<Person> findByPersonsAddress(String addressToFind) {
        Optional<Person> result = Optional.empty();

        for (Person current : listOfPeople) {
            if (current.getAddress().equals(addressToFind)) {
                result = Optional.of(current);
            }
        }

        return result;
    }
}
