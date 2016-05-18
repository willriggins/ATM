package com.theironyard;

/**
 * Created by will on 5/18/16.
 */
public class User {
    String name;
    String menuChoice;
    String num;
    int numInt;

    public void chooseName() throws Exception {
        String name = Main.scanner.nextLine();

        if (name.isEmpty()) {
            throw new Exception("Sorry, we were unable to locate your account.");
        }
        else {
            System.out.println("Thanks for banking with us, " + name + ".");
        }
    }

    public void chooseAction() throws Exception {
        System.out.println("What would you like to do? You may choose between the following options:");
        System.out.println("1. Check your balance");
        System.out.println("2. Withdraw funds");
        System.out.println("3. Cancel");
        System.out.println();
        System.out.println("Enter the correct option number to continue.");
    }

    public void finishTransaction() throws Exception {
        String menuChoice = Main.scanner.nextLine();

        if (menuChoice.isEmpty()) {
            throw new Exception("You broke the bank.");
        }
        else if ((menuChoice.equals("1")) || menuChoice.equalsIgnoreCase("one")) {
            System.out.println("Your balance is $100.");
        }
        else if ((menuChoice.equals("2")) || menuChoice.equalsIgnoreCase("two")) {
            System.out.println("How much money would you like to withdraw?");

            String num = Main.scanner.nextLine();

            if (num.isEmpty()) {
                throw new Exception("You must enter the amount that you wish to withdraw.");
            }
            else {
                int numInt = Integer.valueOf(num);

                if (numInt > 100) {
                    throw new Exception("Insufficient funds available. You may only withdraw up to $100.");
                } else if (numInt < 1) {
                    throw new Exception("You must withdraw at least $1.");
                } else {
                    System.out.println("Please take your $" + num + ".");
                }
            }
        }
        else if ((menuChoice.equals("3")) || menuChoice.equalsIgnoreCase("three")) {
            System.out.println("Thank you and please come again.");
        }
        else {
            throw new Exception("You did not select a valid option.");
        }
    }
}
