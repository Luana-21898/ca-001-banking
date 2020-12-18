package com.company;

import java.util.Scanner;

public class MenuBuilder {

    private static int startMenu() {

        int selection;
        Scanner input = new Scanner(System.in);
        /***************************************************/

        System.out.println("Welcome to JavaBank!");
        System.out.println("Choose from these choices below:");

        System.out.println("-------------------------\n");
        System.out.println("1 - Bank Employee Login");
        System.out.println("2 - Customer Login");
        System.out.println("3 - Quit");

        selection = input.nextInt();
        return selection;

    }

    private static int customerMenu() {

        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("-------------------------\n");
        System.out.println("1 - Saving Account");
        System.out.println("2 - Current Account");
        System.out.println("3 - History Account");
        System.out.println("4 - Quit");

        selection = input.nextInt();
        return selection;

    }

    private static Customer AddCustomerForm() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter First Name");

        String firstName = myObj.nextLine();  // Read user input
        System.out.println("FirstName  is: " + firstName);  // Output user input
        System.out.println();

        System.out.println("Enter Last Name");

        String lastName = myObj.nextLine();  // Read user input
        System.out.println("LastName  is: " + lastName);  // Output user input
        System.out.println();

        System.out.println("Enter Account Number");

        String accountNumber = myObj.nextLine();  // Read user input
        System.out.println("Account Number  is: " + accountNumber);  // Output user input
        System.out.println();

        System.out.println("Enter PIN");

        String pinNumber = myObj.nextLine();  // Read user input
        System.out.println("PIN Number  is: " + pinNumber);  // Output user input
        System.out.println();

        // You might validate here.....

        Customer customer = new Customer(firstName, lastName, accountNumber, pinNumber);
        // And if happy /// create the customer

        return customer;

    }

    private static  void DeleteCustomer() {


    }


    private static int bankingMenu() {

        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("-------------------------\n");
        System.out.println("1 - Create Customer Account");
        System.out.println("2 - Edit Customer Account");
        System.out.println("3 - List of Customers");
        System.out.println("4 - Quit");

        selection = input.nextInt();
        return selection;

    }

    private static String  getBankEmployeePin() {

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter PIN");
        String employeePin = "A1234";

        if (employeePin == employeePin){
            System.out.println("Access Authorized.");
        } else{
            System.out.println("Wrong PIN. Please try again.");
        }

            String pin = myObj.nextLine();  // Read user input
        System.out.println("PIN is: " + pin);  // Output user input

        return pin;

    }

    public static void Run() {

        int userChoice = MenuBuilder.startMenu();

        switch (userChoice) {

            case 1:

                // Get the banking Pin from employee
                String pin = getBankEmployeePin();
                SecurityBanking sb = new SecurityBanking();
                boolean isAuthenticated = sb.login(pin);

                // add logic here if isAuthenticated

                if (isAuthenticated) {

                    int bankEmployeeAction = MenuBuilder.bankingMenu();

                    // Write a switch statement here
                    // Here I demo creating a customer as if I used a switch
                    Customer newCustomer = AddCustomerForm(); // this calls the form, which then creates the custsomer
                    // validate the newCustomer
                    BankingAction.AddCustomer(newCustomer);


                } else {
                    System.out.println("error....");
                    return;
                }


                break;
            case 2:

                // Get the banking Pin from employee
                //String pin = getBankEmployeePin();
                //SecurityBanking sb = new SecurityBanking();
                /// boolean isAuthenticated = sb.login(pin);

                // add logic here if isAuthenticated

                // if (isAuthenticated) {

                // int customerAction = MenuBuilder.customerMenu();

                // userChoice = MenuBuilder.customerMenu();

                // } else {
                // System.out.println("error....");
                //  return;
                //  }


                break;
            case 3:
                System.out.println("Option 3s");
                break;
            case 4:
                return;
        }

    }
}