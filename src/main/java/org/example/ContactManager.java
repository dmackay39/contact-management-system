package org.example;

import java.util.HashMap;

public class ContactManager {
    private HashMap<String, GeneralContactCategory> allContacts = new HashMap<>();
    private GeneralContactCategory dir1;
    private GeneralContactCategory dir2;

    public ContactManager(GeneralContactCategory dir1, GeneralContactCategory dir2){
        allContacts.put("Personal", dir1);
        allContacts.put("Work", dir2);
    }

    public void addContact(String name, Contact person, String dirChoice){
        if (dirChoice.equalsIgnoreCase("Personal")){
            allContacts.get("Personal").addContact(name, person);
        }
        else if(dirChoice.equalsIgnoreCase("Work")){
            allContacts.get("Work").addContact(name, person);
        }
        else if (dirChoice.equalsIgnoreCase("Both")) {
            allContacts.get("Personal").addContact(name, person);
            allContacts.get("Work").addContact(name, person);
        }
    }

    public void viewContacts(String dirChoice){
        if (dirChoice.equalsIgnoreCase("Personal")){
            allContacts.get("Personal").viewContacts();
        }
        else if(dirChoice.equalsIgnoreCase("Work")){
            allContacts.get("Work").viewContacts();
        }
    }

    public void removeContact(String dirChoice, String name){
        if (dirChoice.equalsIgnoreCase("Personal")){
            allContacts.get("Personal").removeContact(name);
        }
        else if(dirChoice.equalsIgnoreCase("Work")){
            allContacts.get("Work").removeContact(name);
        }
    }

    public void searchContacts(String dirChoice, String name){
        if (dirChoice.equalsIgnoreCase("Personal")){
            allContacts.get("Personal").searchContacts(name);
        }
        else if(dirChoice.equalsIgnoreCase("Work")){
            allContacts.get("Work").searchContacts(name);
        }
    }

}
