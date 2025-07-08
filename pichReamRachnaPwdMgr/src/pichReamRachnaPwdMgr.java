import java.util.Scanner;

public class pichReamRachnaPwdMgr{
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        mainMenu();
    }

    /** Main Menu **/
    public static void mainMenu() {
        // Display welcome message
        System.out.println("\n========= Welcome to Rachna's Password Manager =========");

        // Prompt user to enter their name
        String name;
        while (true) {
            System.out.print("\nEnter your name: ");
            name = input.nextLine().trim();

            // Check if name is empty
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty. Please enter your name.");
            } else {
                break;
            }
        }
        userPassword(name);
    }


    /** User's Password **/
    public static void userPassword(String name) {
        while (true) {
            System.out.printf("\n%s, Please enter your password: ", name);
            String password = input.nextLine();

            // Check if password is valid
            if (isValidPwd(password)) {
                System.out.println("The password is valid.");
                // If password is valid, direct user to mini menu
                miniMenu(password, name);
            } else {
                System.out.println("Please re-enter a valid password.");
            }
        }
    }

    /** Mini Menu **/
    public static void miniMenu(String password, String name) {
        while (true) {
            System.out.printf("\n========= Welcome, %s! What would you like to do next? =========\n", name);
            System.out.println("1. Display the password Strength\n" +
                    "2. Check a new password\n" +
                    "3. Exit the program");
            System.out.print("\nPlease enter your choice: ");

            String userChoice = input.nextLine();

            // Check if input is empty
            if (userChoice.isEmpty()) {
                System.out.println("Choice cannot be empty. Please enter your choice.");
                continue;
            }

            // Convert user's choice into an integer, if can't, throws and catch a number format exception
            int choice;
            try {
                choice = Integer.parseInt(userChoice);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter 1, 2, or 3.");
                continue;
            }

            // Handles user's mini menu choice
            switch (choice) {
                case 1:
                    passwordStrength(password);
                    continue;
                case 2:
                    userPassword(name);
                case 3:
                    System.out.printf("\nExiting program... Goodbye, %s", name);
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter 1,2, or 3.");
            }
        }
    }

    /** Validate password **/
    public static boolean isValidPwd(String password) {
        boolean isValid = true;

        // Ensure that password is 8 chars long.
        if (password.length() < 8) {
            System.out.println("Password must be at least 8 characters long.");
            isValid = false;
        }

        // Ensure that password contain an uppercase, a digit, and a special character
        boolean hasUppercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        
        String specialChars = "! @ # $ % ^ & * ( ) _ - + = { } | \\ : ; \" ' < > , . / ?";
        
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (specialChars.indexOf(c) != -1) {
                hasSpecialChar = true;
            }
        }

        // When a condition is false, print the correct error messages according to that condition
        if (!hasUppercase) {
            System.out.println(" *Password must contain at least one uppercase letter.");
            isValid = false;
        }
        if (!hasDigit) {
            System.out.println(" *Password must contain at least one digit.");
            isValid = false;
        }
        if (!hasSpecialChar) {
            System.out.println(" *Password must contain at least one special character (E.g., ! @ # $ % ^ & * ( ) _ - + = { } | \\\\ : ; \\\" ' < > , . / ?)");
            isValid = false;
        }

        return isValid;

    }

    /** Determine Password Strength **/
    public static void passwordStrength(String password) {
        if (password.length() < 10) {
            System.out.println("The password strength : WEAK");
        } else if (password.length() <= 12) {
            System.out.println("The password strength : MEDIUM");
        } else {
            System.out.println("The password strength : STRONG");
        }
    }

}