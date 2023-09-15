package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
@Slf4j
public class ContactManager {
    private HashMap<String, GeneralContactCategory> allContacts = new HashMap<>();

    public ContactManager(GeneralContactCategory dir1, GeneralContactCategory dir2){
        allContacts.put("Personal", dir1);
        allContacts.put("Work", dir2);
    }

    public void addContact(String name, Contact person, String dirChoice){
        if (dirChoice.equalsIgnoreCase("Personal")){
            allContacts.get("Personal").addContact(name, person);
            log.info("Contact added successfully");
        }
        else if(dirChoice.equalsIgnoreCase("Work")){
            allContacts.get("Work").addContact(name, person);
            log.info("Contact added successfully");
        }
        else if (dirChoice.equalsIgnoreCase("Both")) {
            allContacts.get("Personal").addContact(name, person);
            allContacts.get("Work").addContact(name, person);
            log.info("Contact added successfully");
        }
        else {
            System.out.println("Not a valid choice of directory");
            System.out.println("Please choose Personal/Work/Both");
        }

        createContactsFile();

        saveContacts();


    }

    private void createContactsFile() {
        try {
            File myObj = new File("src/main/resources/SavedContacts.txt");
            if (myObj.createNewFile()) {
                log.debug("File created: " + myObj.getName());
            } else {
                myObj.delete();
                myObj.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void saveContacts() {
        try {
            FileWriter myWriter = new FileWriter("src/main/resources/SavedContacts.txt");
            for (String dir : allContacts.keySet()){
                myWriter.write(dir + ":" + "\n");
                for (String contact : allContacts.get(dir).getContacts().keySet()){
                    myWriter.write(allContacts.get(dir).getContacts().get(contact).getName() + ", ");
                    myWriter.write(allContacts.get(dir).getContacts().get(contact).getEmail() + ", ");
                    myWriter.write(allContacts.get(dir).getContacts().get(contact).getPhoneNumber() + "\n");
                }
            }

            myWriter.close();
            log.debug("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void viewContacts(String dirChoice){
        if (dirChoice.equalsIgnoreCase("Personal")){
            allContacts.get("Personal").viewContacts();
        }
        else if(dirChoice.equalsIgnoreCase("Work")){
            allContacts.get("Work").viewContacts();
        }
        else if (dirChoice.equalsIgnoreCase("both")){
            allContacts.get("Personal").viewContacts();
            System.out.println("Work");
            allContacts.get("Work").viewContacts();
        }
        else {
            System.out.println("Invalid directory choice.");
            System.out.println("Please choose Personal/Work/Both");
        }
    }

    public void removeContact(String dirChoice, String name){
        if (dirChoice.equalsIgnoreCase("Personal")){
            allContacts.get("Personal").removeContact(name);
            System.out.println("Contact removed from Personal");
        }
        else if(dirChoice.equalsIgnoreCase("Work")){
            allContacts.get("Work").removeContact(name);
            System.out.println("Contact removed from Work");
        }
        else if (dirChoice.equalsIgnoreCase("Both")) {
            allContacts.get("Personal").removeContact(name);
            System.out.println("Contact removed from Personal");
            allContacts.get("Work").removeContact(name);
            System.out.println("Contact removed from Work");

        }
        else {
            System.out.println("Invalid directory choice");
            System.out.println("Please choose work or personal or both");
        }
        createContactsFile();
        saveContacts();
    }

    public void searchContacts(String dirChoice, String name){
        if (dirChoice.equalsIgnoreCase("Personal")){
            List result = allContacts.get("Personal").searchContacts(name);
            if (result.size()!=0) {
                System.out.println("In Personal directory");
                for (int i = 0; i < result.size(); i++) {
                    Contact found = allContacts.get("Personal").getContacts().get(result.get(i));
                    System.out.println(found.getName() + " " + found.getEmail() + " " + found.getPhoneNumber());
                }
            }
            else {
                System.out.println("Contact not found in Personal");
            }
        }
        else if(dirChoice.equalsIgnoreCase("Work")){
            List result = allContacts.get("Work").searchContacts(name);
            if (result.size() != 0) {
                System.out.println("In work directory:");
                for (int i = 0; i < result.size(); i++) {
                    Contact found = allContacts.get("Work").getContacts().get(result.get(i));
                    System.out.println(found.getName() + " " + found.getEmail() + " " + found.getPhoneNumber());
                }
            }
            else {
                System.out.println("Contact not found in Work");
            }
        } else if (dirChoice.equalsIgnoreCase("Both")) {
            List result = allContacts.get("Work").searchContacts(name);
            if (result.size() != 0) {
                System.out.println("In work directory:");
                for (int i = 0; i < result.size(); i++) {
                    Contact found = allContacts.get("Work").getContacts().get(result.get(i));
                    System.out.println(found.getName() + " " + found.getEmail() + " " + found.getPhoneNumber());
                }
            }
            else {
                System.out.println("Contact not found in Work");
            }

            List result1 = allContacts.get("Personal").searchContacts(name);
            if (result1.size()!=0) {
                System.out.println("In Personal directory");
                for (int i = 0; i < result1.size(); i++) {
                    Contact found = allContacts.get("Personal").getContacts().get(result1.get(i));
                    System.out.println(found.getName() + " " + found.getEmail() + " " + found.getPhoneNumber());
                }
            }
            else {
                System.out.println("Contact not found in Personal");
            }

        } else {
            System.out.println("Not a valid choice of directory");
            System.out.println("Please choose Personal or Work");
        }
    }

}
