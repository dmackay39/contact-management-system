package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PersonalContactCategory personalCat = new PersonalContactCategory();
        WorkContactCategory workCat = new WorkContactCategory();
        ContactManager contMan = new ContactManager(personalCat, workCat);

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Manual entry");
        ManualEntryUI manEntry = new ManualEntryUI();
        manEntry.runUI(contMan);

    }
}