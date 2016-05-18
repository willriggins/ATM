package com.theironyard;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome.");
        System.out.println("What is your name?");

        User user = new User();

        user.chooseName();
        user.chooseAction();
        user.finishTransaction();
    }
}
