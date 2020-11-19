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
        System.out.print("Enter your first and last name ");
        Scanner input = new Scanner(System.in);
        this.firstName = input.next();
        this.lastName = input.next();
        System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);
        this.department = setDepartment();
        System.out.println("Department: " + this.department);
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Password: " + this.password);
        this.alternateEmail = askAlternateEmail();
        System.out.println("Your alternate Email address: " + this.alternateEmail);
        setMailboxCapacity(100);
        
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

    // Ask user an atlernate email address
    private String askAlternateEmail() {
        System.out.print("Enter alternate email address: ");
        Scanner input = new Scanner(System.in);
        String alternate = input.nextLine();
        while (!validEmail(alternate)) {
            System.out.print("Invalid address! please enter valid email address: ");
            alternate = input.nextLine();
        }
        return alternate;
    }

    // Helper method to check if email address is valid
    private boolean validEmail(String email) {
        if (email.contains("@")) {
            return true;
        }
        return false;
    }

    // set mailboxcapacity to input capacity
    private void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }
    
    // change password
    private void changePassword(String requestPassword) {
        this.password = requestPassword;
    }

    // change alternate email address
    private void changeAlternateEmail(String alternate) {
        if (validEmail(alternate) {
            this.alternateEmail = alternate;
        }
    }
    
    // Reset password to random default length password
    private void resetPassword() {
        String temp = randomPassword(this.defaultPasswordLength);
        changePassword(temp);
    }


}
