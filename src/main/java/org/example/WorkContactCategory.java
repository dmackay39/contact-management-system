package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WorkContactCategory extends GeneralContactCategory implements ContactCategory{

    private HashMap<String, Contact> workContacts = new HashMap<>();
    @Override
    public void addContact(String name, Contact person) {
        workContacts.put(name, person);
    }

    @Override
    public void removeContact(String name) {
        if (workContacts.containsKey(name)){
            workContacts.remove(name);
        }
        else {
            System.out.println("Error: Person not found");
        }
    }

    @Override
    public void viewContacts() {
        for (String key : workContacts.keySet()){
            String name = workContacts.get(key).getName();
            String email = workContacts.get(key).getEmail();
            int phoneNumber = workContacts.get(key).getPhoneNumber();
            System.out.print("Name: " + name + " ");
            System.out.print("Email: " + email + " ");
            System.out.println("Phone: " + phoneNumber);
        }
    }

    @Override
    public List searchContacts(String name) {
        List<String> validKeys = new ArrayList<>();
        for (String s: workContacts.keySet()) {
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
        return workContacts;
    }
}

