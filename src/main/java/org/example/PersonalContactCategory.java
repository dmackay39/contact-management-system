package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PersonalContactCategory extends GeneralContactCategory implements ContactCategory{

    private HashMap<String, Contact> personalContacts = new HashMap<>();
    @Override
    public void addContact(String name, Contact person) {
        personalContacts.put(name, person);
    }

    @Override
    public void removeContact(String name) {
        if (personalContacts.containsKey(name)){
            personalContacts.remove(name);
        }
        else{
            System.out.println("Error: Person not found");
        }
    }

    @Override
    public void viewContacts() {
        System.out.println("Personal:");
        for (String key : personalContacts.keySet()){
            String name = personalContacts.get(key).getName();
            String email = personalContacts.get(key).getEmail();
            int phoneNumber = personalContacts.get(key).getPhoneNumber();
            System.out.print("Name: " + name + " ");
            System.out.print("Email: " + email + " ");
            System.out.println("Phone: " + phoneNumber);
        }
    }

    @Override
    public List searchContacts(String name) {
        List<String> validKeys = new ArrayList<>();
        for (String s: personalContacts.keySet()) {
            if (s.toLowerCase().contains(name)){
                validKeys.add(s);
            }
        }
        if (validKeys.isEmpty()){
            System.out.println("Nothing found");
            return new ArrayList<String>();
        }
        return validKeys;
    }

    @Override
    public HashMap<String, Contact> getContacts() {
        return personalContacts;
    }
}
