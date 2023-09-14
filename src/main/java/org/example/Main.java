package org.example;

public class Main {
    public static void main(String[] args) {
        PersonalContactCategory personalCat = new PersonalContactCategory();
        WorkContactCategory workCat = new WorkContactCategory();

        Contact person1 = new Contact("person1", "asds", 123);
        Contact person2 = new Contact("person2", "assdsg", 24);

        personalCat.addContact("person1", person1);
        workCat.addContact("person2", person2);

        ContactManager contMan = new ContactManager(personalCat, workCat);

    }
}