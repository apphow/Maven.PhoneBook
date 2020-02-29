package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    private String name;
    private String number;
    private String numbers;

    private Map<String, List<String>> map;

    public PhoneBook(Map<String, List<String>> map) {
        this.map = map;
    }

    public PhoneBook() {
        this(null);
        this.map = new LinkedHashMap<String, List<String>>();
    }
    public void add(String name, String phoneNumber) {
        if (this.map.containsKey(name)) {
            this.map.get(name).add(phoneNumber);
        } else {
            ArrayList<String> contact = new ArrayList<>();
            contact.add(phoneNumber);
            this.map.put(name, contact);
        }
    }

   public void addAll(String name, String... phoneNumbers) {
       for (String phoneNumber : phoneNumbers) {
           this.add(name, phoneNumber);
       }

   }

    public void remove(String name) {
        if (this.hasEntry(name)) this.map.remove(name);
    }

    public Boolean hasEntry(String name) {
        Boolean isVisible = false;

        for (List<String> numbers : this.map.values()){
            if (numbers.contains(name)) {
                isVisible = true;
            }
        }
        return isVisible;
    }

    public List<String> lookup(String name) {
        return this.map.get(name);

    }

    public String reverseLookup(String phoneNumber)  {
       String output = "";
       for(String name : this.map.keySet()) {
           for(String contact : this.map.get(name)) {
               if (contact.equals(phoneNumber)) {
                   output = name;
                   break;
               }
           }
           if (output.length() > 0) break;
       }
       return output;
    }

    public List<String> getAllContactNames() {

        ArrayList<String> contacts = new ArrayList<>();
        for (String name : this.map.keySet()) {
            contacts.add(name);
        }
        return contacts;
    }

    public Map<String, List<String>> getMap() {
        return this.map;
    }
}
