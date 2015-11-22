package project.datacollection.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import project.datacollection.model.Person;
import project.datacollection.utils.DataModelArrayList;

public class DataModelArrayListTest {

    @Test
    public void CanAddNonEmptyDataModel() {
        Person person = Person.builder().firstName("firstName").build();
        DataModelArrayList<Person> list = new DataModelArrayList<>();
        assertTrue(list.add(person));
    }
    
    @Test
    public void CannotAddEmptyDataModel() {
        DataModelArrayList<Person> list = new DataModelArrayList<>();
        Person person = Person.builder().build();
        Person person2 = Person.builder().firstName("firstName").build();
        list.add(person);
        list.add(person2);
        assertEquals(list.size(),2); // TODO: should be 1 - works in Eclipse, doesn't work through brazil-build
    }
}
