package com.theironyard;

/**
 * Created by will on 5/18/16.
 */
public class User {
    static String name;
    String menuChoice;
    String num;
    double numDouble;
    String deposit;
    double numDeposit;
    String response;
    boolean inUse;
    double newBalance;

    public void chooseName() {
        System.out.println();
        System.out.println("Welcome to the ATM. Please enter your name?");

        name = Main.nextLine();


        if (Main.record.containsKey(name)) {
            System.out.println("Welcome back, " + name + ".");
            inUse = true;
        } else {
            System.out.println("We could not find an account under this name.");
            System.out.println("Would you like to set up an account? Please choose an option:");
            System.out.println("1 - Yes");
            System.out.println("2 - No");
            System.out.println();

            response = Main.nextLine();

            if (response.equalsIgnoreCase("Yes") || (response.equals("1"))) {
                System.out.println("Thanks, " + name + ". Your account has been created.");
                Main.record.put(name, 0.0);
                inUse = true;
            } else {
                inUse = false;
                System.out.println("Thank you. Please come again.");
            }
        }
    }

    public void chooseAction() throws Exception {

        while (inUse) {
            System.out.println();
            System.out.println("What would you like to do? You may choose between the following options:");
            System.out.println("1. Check your balance");
            System.out.println("2. Withdraw funds");
            System.out.println("3. Deposit funds");
            System.out.println("4. Close your account");
            System.out.println("5. Cancel and Exit");
            System.out.println();
            System.out.println("Enter the correct option number to continue.");


            menuChoice = Main.nextLine();

            if ((menuChoice.equals("1")) || menuChoice.equalsIgnoreCase("one")) {
                newBalance = Main.record.get(name);
                System.out.println();
                System.out.println("Your balance is $" + String.format("%.2f", newBalance) + ".");
            } else if ((menuChoice.equals("2")) || menuChoice.equalsIgnoreCase("two")) {
                System.out.println("How much money would you like to withdraw?");

                num = Main.nextLine();

                if (num.isEmpty()) {
                    throw new Exception("You must enter the amount that you wish to withdraw.");
                } else {
                    numDouble = Double.valueOf(num);

                    if (numDouble > newBalance) {
                        System.out.println("Insufficient funds available. You may only withdraw up to $" + String.format("%.2f", newBalance) + ".");
                    } else if (numDouble < 1) {
                        System.out.println("You must withdraw at least $1.");
                    } else {
                        System.out.println("Please take your $" + String.format("%.2f", numDouble) + ".");
                        newBalance -= numDouble;
                        Main.record.put(name, newBalance);
                    }
                }
            } else if (menuChoice.equals("3") || menuChoice.equalsIgnoreCase("three")) {
                System.out.println("How much would you like to deposit?");

                deposit = Main.nextLine();
                numDeposit = Double.valueOf(deposit);

                System.out.println("You deposited $" + String.format("%.2f", numDeposit) + " into your account.");

                newBalance = numDeposit + Main.record.get(name);
                Main.record.put(name, newBalance);

                System.out.println("Your balance is now $" + String.format("%.2f", newBalance) + ".");
            } else if ((menuChoice.equals("4")) || menuChoice.equalsIgnoreCase("four")) {
                System.out.println("Your account has been closed.");
                System.out.println("Please consider opening a new account with us. Thank you.");
                Main.record.remove(name);
                inUse = false;
            } else if ((menuChoice.equals("5")) || menuChoice.equalsIgnoreCase("five")) {
                System.out.println("Thank you and please come again.");
                inUse = false;
            } else {
                System.out.println("You did not select a valid option. Please try again.");
            }
        }
    }
}

