package com.theironyard;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws Exception {
        System.out.println("Welcome.");
        System.out.println("What is your name?");

        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        if (name.isEmpty()) {
            throw new Exception("He with no name may not use this ATM.");
        }
        else {
            System.out.println("Thanks for banking with us, " + name + ".");
        }

        System.out.println("What would you like to do? You may choose between the following options:");
        System.out.println("1. Check your balance");
        System.out.println("2. Withdraw funds");
        System.out.println("3. Cancel");
        System.out.println();
        System.out.println("Enter the correct option number to continue.");

        String menuChoice = scanner.nextLine();

        if (menuChoice.isEmpty()) {
            throw new Exception("You broke the bank.");
        }
        else if ((menuChoice.equals("1")) || menuChoice.equalsIgnoreCase("one")) {
            System.out.println("Your balance is $100.");
        }
        else if ((menuChoice.equals("2")) || menuChoice.equalsIgnoreCase("two")) {
            System.out.println("How much money would you like to withdraw?");

            String num = scanner.nextLine();
            int numInt = Integer.valueOf(num);
            if (numInt > 100) {
                throw new Exception("Insufficient funds available.");
            }
            else {
                System.out.println("Please take your $" + num + ".");
            }
        }
        else if ((menuChoice.equals("3")) || menuChoice.equalsIgnoreCase("three")) {
            System.out.println("Thank you and please come again.");
        }
    }
}
