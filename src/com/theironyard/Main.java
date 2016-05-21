package com.theironyard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


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
                System.out.println("ACCESS GRANTED. RETRIEVING ALL AVAILABLE RECORDS...");
                System.out.println();
                if (Main.record.size() == 0) {
                    System.out.println("UNABLE TO LOCATE ANY RECORDS");
                }
                else if (Main.record.size() == 1) {
                    System.out.println("FOUND ONE RECORD:");
                    System.out.println();
                    getList();
                }
                else if (Main.record.size() > 1) {
                    System.out.println("FOUND " + Main.record.size() + " RECORDS:");
                    System.out.println();
                    getList();
                }
            }
            else {
                System.out.println("Command not recognized");
            }

            line = scanner.nextLine();
        }
        return line;
    }

    public static void getList() {
        Set setOfKeys = record.keySet();
        Iterator iterator = setOfKeys.iterator();
        int i = 1;
        while (iterator.hasNext()) {
            String key = (String)iterator.next();
            Double value = record.get(key);
            double valueDouble = Double.valueOf(value);
            System.out.println(i + ". " + key+ ": $" + String.format("%.2f", valueDouble));
            i += 1;
        }
    }
}
