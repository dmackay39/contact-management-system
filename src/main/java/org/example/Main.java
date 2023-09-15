package org.example;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        PersonalContactCategory personalCat = new PersonalContactCategory();
        WorkContactCategory workCat = new WorkContactCategory();
        ContactManager contMan = new ContactManager(personalCat, workCat);

        FileInputStream fis;
        Scanner fileScanner;
        try {
            fis = new FileInputStream("src/main/resources/PersonalInputContacts.txt");
            fileScanner = new Scanner(fis);

            while (fileScanner.hasNextLine()) {
                String input = fileScanner.nextLine();
                String[] strArray = input.split(", ", 3);
                String name = strArray[0];
                String email = strArray[1];
                int phoneNumber = Integer.parseInt(strArray[2]);
                contMan.addContact(name, new Contact(name,email,phoneNumber),"Personal");
            }
            fis.close();
        }
        catch (FileNotFoundException fileNotFoundException){
            System.out.println("No such file exists");
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }

        try {
            fis = new FileInputStream("src/main/resources/WorkInputContacts.txt");
            fileScanner = new Scanner(fis);

            while (fileScanner.hasNextLine()) {
                String input = fileScanner.nextLine();
                String[] strArray = input.split(", ", 3);
                String name = strArray[0];
                String email = strArray[1];
                int phoneNumber = Integer.parseInt(strArray[2]);
                contMan.addContact(name, new Contact(name,email,phoneNumber),"Work");
            }
            fis.close();
        }
        catch (FileNotFoundException fileNotFoundException){
            System.out.println("No such file exists");
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }


        Scanner myScanner = new Scanner(System.in);
        System.out.println("Manual entry");
        ManualEntryUI manEntry = new ManualEntryUI();
        manEntry.runUI(contMan);

    }
}