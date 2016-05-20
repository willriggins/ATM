package com.theironyard;

import java.util.HashMap;
import java.util.Scanner;


public class Main {

    static Scanner scanner = new Scanner(System.in);
    static User user = new User();
    static HashMap<String, Double> record = new HashMap();
    static boolean cycle = true;


    public static void main(String[] args) throws Exception {

        while (Main.cycle) {
            Main.user.chooseName();
            Main.user.chooseAction();
        }
    }

    public static String nextLine() {
        String line = scanner.nextLine();
        while (line.startsWith("/")) {
            if (line.equals("/hack")) {
                System.out.println("Access Granted");
                System.out.println();
                if (Main.record.size() == 0) {
                    System.out.println("No existing records.");
                }
                else if (Main.record.size() == 1) {
                    System.out.println("1 existing record:");
                    System.out.println(Main.record);
                }
                else if (Main.record.size() > 1) {
                    System.out.println(Main.record.size() + " existing records:");
                    System.out.println(Main.record); // why doesn't user.record work here w/o import?
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
