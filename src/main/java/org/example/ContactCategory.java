package org.example;

import java.util.HashMap;
import java.util.List;

public interface ContactCategory {
    void addContact(String name, Contact person);
    void removeContact(String name);
    void viewContacts();
    List searchContacts(String name);

    HashMap<String, Contact> getContacts();

}
