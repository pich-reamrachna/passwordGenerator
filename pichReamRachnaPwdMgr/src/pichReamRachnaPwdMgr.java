import java.util.Scanner;

public class pichReamRachnaPwdMgr{
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        mainMenu();
    }

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

        // Prompt user to enter their password
        while (true) {
            System.out.printf("\n%s, Please enter your preferred password: ", name);
            String password = input.nextLine();

            // Check if password is Valid
            if (isValidPwd(password)) {
                System.out.println("The password is valid.");
                // If password is valid, direct user to mini menu
                miniMenu(password, name);
            } else {
                System.out.println("Please re-enter a valid password.");
            }
        }
    }

    // Mini Menu
    public static void miniMenu(String password, String name) {
        while (true) {
            System.out.println("\nWhat would you like to do next?");
            System.out.println("1. Display the password Strength\n" + "2. Exit the program");
            System.out.print("\nPlease enter your choice: ");

            String userChoice = input.nextLine();

            if (userChoice.isEmpty()) {
                System.out.println("Choice cannot be empty. Please enter your choice.");
                continue;
            }

            int choice;
            try {
                choice = Integer.parseInt(userChoice);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter 1 or 2.");
                continue;
            }


            switch (choice) {
                case 1:
                    passwordStrength(password);
                    return;
                case 2:
                    System.out.printf("Exiting program... Goodbye, %s", name);
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter 1 or 2.");
            }
        }

    }

    public static boolean isValidPwd(String password) {
        boolean isValid = true;

        if (password.length() < 8) {
            System.out.println("Password must be at least 8 characters long.");
            isValid = false;
        }

        boolean hasUppercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        String specialChars = "@#$%&";

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (specialChars.indexOf(c) != -1) {
                hasSpecialChar = true;
            }
        }

        if (!hasUppercase) {
            System.out.println("Password must contain at least one uppercase letter.");
            isValid = false;
        }
        if (!hasDigit) {
            System.out.println("Password must contain at least one digit.");
            isValid = false;
        }
        if (!hasSpecialChar) {
            System.out.println("Password must contain at least one special character (E.g., @, #, $, %, &).");
            isValid = false;
        }

        return isValid;

    }

    public static void passwordStrength(String password) {
        // Determine password strength

        if (password.length() < 10) {
            System.out.println("The password Strength : WEAK");
        } else if (password.length() <= 12) {
            System.out.println("The password Strength : MEDIUM");
        } else {
            System.out.println("The password Strength : STRONG");
        }
    }

}