package org.example;

import java.util.HashMap;

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
    public Contact searchContacts(String name) {
        if (personalContacts.containsKey(name)) {
            return personalContacts.get(name);
        }
        else {
            System.out.println("Not in the list");
            return null;
        }
    }

    public HashMap<String, Contact> getPersonalContacts() {
        return personalContacts;
    }
}
