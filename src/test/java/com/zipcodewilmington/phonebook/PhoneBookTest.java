package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    @Test
    public void addTest(){
        // Given
        PhoneBook phonebook = new PhoneBook();
        TreeMap<String, ArrayList<String>> map = phonebook.getPhonebookMap();
        String name = "Cara";
        String phonenumber = "3027507192";
        String phonenumber2 = "3024786620";
        ArrayList<String> expected = new ArrayList<String>();
        expected.add(phonenumber);

        // When
        phonebook.add(name, phonenumber);
        ArrayList<String> actual = map.get(name);

        // Then
        Assert.assertEquals(phonenumber, map.get(name).get(0));
        Assert.assertEquals(expected, actual);
        Assert.assertNull(map.get("notakey"));

        // When
        phonebook.add(name, phonenumber2);
        expected.add(phonenumber2);

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(phonenumber2, map.get(name).get(1));
    }

    @Test
    public void removeTest(){
        // Given
        PhoneBook phonebook = new PhoneBook();
        TreeMap<String, ArrayList<String>> map = phonebook.getPhonebookMap();
        String name = "Cara";
        String phonenumber = "3027507192";
        String phonenumber2 = "3024786620";
        phonebook.add(name, phonenumber);
        phonebook.add(name, phonenumber2);

        // When
        phonebook.remove(name, phonenumber);

        // Then
        Assert.assertEquals(phonenumber2, map.get(name).get(0));

        // When
        phonebook.remove(name, phonenumber2);

        // Then
        Assert.assertNull(map.get(name));
        Assert.assertEquals(0, map.size());

    }

    @Test
    public void lookupTest(){
        // Given
        PhoneBook phonebook = new PhoneBook();
        TreeMap<String, ArrayList<String>> map = phonebook.getPhonebookMap();
        String name = "Cara";
        String phonenumber = "3027507192";
        phonebook.add(name, phonenumber);

        // When
        ArrayList<String> actual = phonebook.lookup(name);

        // Then
        Assert.assertEquals(phonenumber, actual.get(0));
    }

    @Test
    public void reverseLookupTest(){
        // Given
        PhoneBook phonebook = new PhoneBook();
        TreeMap<String, ArrayList<String>> map = phonebook.getPhonebookMap();
        String name = "Cara";
        String phonenumber = "3027507192";
        String phonenumber2 = "3024786620";
        phonebook.add(name, phonenumber);
        phonebook.add(name, phonenumber2);

        // When
        String actual = phonebook.reverseLookup(phonenumber);
        String actual2 = phonebook.reverseLookup(phonenumber2);

        // Then
        Assert.assertEquals(name, actual);
        Assert.assertEquals(name, actual2);
        Assert.assertNull(phonebook.reverseLookup("notaphonenumer"));
    }

    @Test
    public void removeRecordTest(){
        // Given
        PhoneBook phonebook = new PhoneBook();
        TreeMap<String, ArrayList<String>> map = phonebook.getPhonebookMap();
        String name = "Cara";
        String phonenumber = "3027507192";
        phonebook.add(name, phonenumber);

        // When
        phonebook.removeRecord(name);

        // Then
        Assert.assertNull(map.get(name));
        Assert.assertEquals(0, map.size());

    }
}
