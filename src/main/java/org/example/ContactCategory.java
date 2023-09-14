package org.example;

public interface ContactCategory {
    void addContact(String name, Contact person);
    void removeContact(String name);
    void viewContacts();
    Contact searchContacts(String name);
}
