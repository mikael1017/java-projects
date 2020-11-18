package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int mailboxCapacity;
    private String alternateEmail;
    private int defaultPasswordLength = 4;

    public Email(String first, String last) {
        this.firstName = first;
        this.lastName = last;
        System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);
        this.department = setDepartment();
        System.out.println("Department: " + this.department);
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Password: " + this.password);
        this.alternateEmail = askAlternateEmail();
        System.out.println("Alternate Email address: " + this.alternateEmail);
        
    }

    // Ask user for the department 
    private String setDepartment() {
        System.out.print("DEPARTMENT CODES\n1 for Sale \n2 for Development\n3 for Accounting\n0 for none\nEnter deparment code: ");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        if (choice == 1) { return "sales"; }
        else if (choice == 2) { return "dev"; }
        else if (choice == 3) { return "acct"; }
        else { return ""; }
    }

    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    private String askAlternateEmail() {
        System.out.print("Enter alternate email address: ");
        Scanner input = new Scanner(System.in);
        String alternate = input.nextLine();
        return alternate;
    }
}
