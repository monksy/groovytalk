package de.stevenhicks.groovytalk;

import java.util.logging.Logger;

/**
 * Created by steven on 6/1/16.
 */
public class Person implements Comparable<Person> {
    private final Logger LOG = Logger.getLogger(Person.class.getName());
    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;
    private String address;

    public Person(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!firstName.equals(person.firstName)) return false;
        if (!lastName.equals(person.lastName)) return false;
        return address != null ? address.equals(person.address) : person.address == null;

    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Person o) {
        //3 Comparisons, this is getting ugly!
        int lastNameComparison = lastName.compareTo(o.lastName);
        int firstNameComparison = firstName.compareTo(o.firstName);
        int addressComparison = address.compareTo(o.address);
        //This is just plain ugly
        return  (lastNameComparison != 0 ? lastNameComparison : (firstNameComparison != 0 ? firstNameComparison : addressComparison));
    }
}
