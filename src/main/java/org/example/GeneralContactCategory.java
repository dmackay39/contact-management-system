package org.example;

import java.util.HashMap;
import java.util.List;

public abstract class GeneralContactCategory implements ContactCategory {
    @Override
    public void addContact(String name, Contact person) {

    }

    @Override
    public void removeContact(String name) {

    }

    @Override
    public void viewContacts() {

    }

    @Override
    public List searchContacts(String name) {
        return null;
    }

    @Override
    public HashMap<String, Contact> getContacts(){
        return null;
    }
}
