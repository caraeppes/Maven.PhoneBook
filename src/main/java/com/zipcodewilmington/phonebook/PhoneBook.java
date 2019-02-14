package com.zipcodewilmington.phonebook;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    private TreeMap<String, ArrayList<String>> phonebookMap;

    public PhoneBook(){
        this.phonebookMap = new TreeMap<String, ArrayList<String>>();
    }

    public TreeMap<String, ArrayList<String>> getPhonebookMap() {
        return phonebookMap;
    }

    // adds an entry to the composite associate data type
    public void add(String name, String phoneNumber){
        if (phonebookMap.containsKey(name)){
            phonebookMap.get(name).add(phoneNumber);
        }
        else {
            ArrayList<String> numbers = new ArrayList<String>();
            numbers.add(phoneNumber);
            phonebookMap.put(name, numbers);
        }
    }

    // removes an entry to the composite associate data type
    public void remove(String name, String phoneNumber){
        try{
            if (phonebookMap.get(name).size() == 1){
                this.removeRecord(name);
            }
            else {
                phonebookMap.get(name).remove(phoneNumber);
            }
        }
        catch(NullPointerException e){
            System.out.println("Entry does not exist in this Phonebook");
        }
    }

    // returns a phone number for the respective input name
    public ArrayList<String> lookup(String name){
        return phonebookMap.get(name);
    }

    // returns a name for the respective input phoneNumber
    public String reverseLookup(String phoneNumber){
        for (Map.Entry<String, ArrayList<String>> entry : phonebookMap.entrySet()){
            if (entry.getValue().contains(phoneNumber)){
                return entry.getKey();
            }
        }
        return null;
    }

    // print a human-readable list of all entries (names and phone numbers) in alphabetical order.
    public void display(){
        for (Map.Entry<String, ArrayList<String>> entry : phonebookMap.entrySet()){
            System.out.println(entry.getKey() + ": ");
            for (String number : entry.getValue()){
                System.out.println(number);
            }
        }
    }

    // removeRecord method for removing an entire entry from your PhoneBook.
    public void removeRecord(String name){
        phonebookMap.remove(name);
    }


   /*
   public static void main(String[] args) {

        PhoneBook phonebook = new PhoneBook();
        TreeMap<String, ArrayList<String>> map = phonebook.getPhonebookMap();
        String name = "Cara";
        String phonenumber = "3027507192";
        String phonenumber2 = "3024786620";
        phonebook.add(name, phonenumber);
        phonebook.add(name, phonenumber2);
        String anne = "Anne";
        phonebook.add(anne, "302747939");
        String bob = "Bob";
        phonebook.add(bob, phonenumber2);
        phonebook.add(bob, phonenumber);
        phonebook.display();

        phonebook.remove("fsd", "");
    }
    */

}
