package com.theironyard;

import java.util.Scanner;

import static com.theironyard.User.record; // had to import this to get record to work in the nextLine method below?

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        User user = new User();


        while (user.cycle) {
            user.chooseName();
            user.chooseAction();
        }
    }

    public static String nextLine() {
        String line = scanner.nextLine();
        while (line.startsWith("/")) {
            if (line.equals("/hack")) {
                System.out.println("Access Granted");
                System.out.println();
                if (record.size() == 0) {
                    System.out.println("No existing records.");
                }
                else if (record.size() == 1) {
                    System.out.println("1 existing record:");
                    System.out.println(record);
                }
                else if (record.size() > 1) {
                    System.out.println(record.size() + " existing records:");
                    System.out.println(record); // why doesn't user.record work here w/o import?
                }
                System.out.println();
                System.out.println("Please continue.");
            }
            else {
                System.out.println("Error: Please repeat last input.");
            }

            line = scanner.nextLine();
        }
        return line;
    }

}
