package org.example;

import java.util.HashMap;

public class WorkContactCategory implements ContactCategory{

    private HashMap<String, Contact> workContacts = new HashMap<>();
    @Override
    public void addContact(String name, Contact person) {
        workContacts.put(name, person);
    }

    @Override
    public void removeContact(String name) {
        workContacts.remove(name);
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
    public Contact searchContacts(String name) {
        if (workContacts.containsKey(name)){
            return workContacts.get(name);
        }
        else return (null);
    }
}
