package de.stevenhicks.groovytalk

import groovy.transform.EqualsAndHashCode
import groovy.transform.Sortable
import groovy.transform.ToString
import groovy.util.logging.Log

@ToString
@EqualsAndHashCode(includes = ['firstName', 'lastName', 'address'])
@Sortable(includes = ['lastName', 'firstName', 'address'])
@Log
class GroovyPerson {
    final String firstName;
    final String lastName;
    int age;
    String phoneNumber;
    String address;
}

//phonebook.find { it.firstName == 'name' }

List<de.stevenhicks.groovytalk.GroovyPerson> phonebook = []
ArrayList.metaClass.methodMissing = { String name, Object args ->
    assert name.startsWith("findBy")
    assert args.size() == 1
    String propertyName = name.toLowerCase - 'findby' // <- Gets the property to find

    delegate.findAll { it[propertyName] == args[0] } // <- Returns all Persons
}

phonebook.findByAge(5)
phonebook.findByFirstName('Jim')
phonebook.findByLastName('Morrison')
phonebook.findByPhoneNumber('2134-323')
phonebook.findByAddress('Platz der Republik 1')

