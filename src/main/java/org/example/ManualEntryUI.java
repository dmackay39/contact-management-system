package org.example;

import java.util.Scanner;

public class ManualEntryUI {
    public void runUI(ContactManager contMan) {

        boolean correct = false;
        while (!correct) {

            Scanner myScanner = new Scanner(System.in);
            System.out.println("What would you like to do");
            System.out.println("Add contact: +");
            System.out.println("Remove contact: -");
            System.out.println("View contacts: view");
            System.out.println("Search contacts: search");
            System.out.println("Exit: Q");
            String choice = myScanner.nextLine();

            switch (choice.toLowerCase()) {
                case "q": {
                    correct = true;
                    break;
                }

                case "+": {
                    System.out.println("Personal or Work or both?");
                    String dir = myScanner.nextLine();
                    System.out.println("Please enter the name");
                    String name = myScanner.nextLine();
                    System.out.println("Please enter the email");
                    String email = myScanner.nextLine();
                    System.out.println("Please enter the number");
                    int phoneNumber = myScanner.nextInt();
                    myScanner.nextLine();

                    Contact newPerson = new Contact(name, email, phoneNumber);
                    if (dir.equalsIgnoreCase("Both")){
                        contMan.addContact(name, newPerson, "Personal");
                        contMan.addContact(name, newPerson, "Work");
                    }
                    else {
                        contMan.addContact(name, newPerson, dir);
                    }

                    break;

                }

                case "-":{
                    System.out.println("Personal or Work or Both?");
                    String dir = myScanner.nextLine();
                    System.out.println("Please enter the name");
                    String name = myScanner.nextLine();

                    if (dir.equalsIgnoreCase("both")){
                        contMan.removeContact("Personal", name);
                        contMan.removeContact("Work", name);
                    }
                    else {
                        contMan.removeContact(dir, name);
                    }
                    System.out.println("Contact removed");
                    break;
                }

                case "view":{
                    System.out.println("Personal or Work or Both?");
                    String dir = myScanner.nextLine();
                    if (dir.equalsIgnoreCase("both")){
                        contMan.viewContacts("Personal");
                        contMan.viewContacts("Work");
                    }
                    else {
                        contMan.viewContacts(dir);
                    }
                    break;
                }

                case "search":{
                    System.out.println("Personal or Work or both?");
                    String dir = myScanner.nextLine();
                    System.out.println("Please enter the name");
                    String name = myScanner.nextLine();
                    if (dir.equalsIgnoreCase("both")){
                        contMan.searchContacts("Personal", name);
                        contMan.searchContacts("Work",name);
                    }
                    else {
                        contMan.searchContacts(dir,name);
                    }

                }
            }
        }
    }
}
