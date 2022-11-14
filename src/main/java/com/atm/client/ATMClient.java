package com.atm.client;


import com.atm.bank.Bank;

import java.util.Scanner;

public class ATMClient {


    private static final int Withdrawal = 1;
    private static final int Deposit = 2;
    private static final int Balance_Inquiry = 3;
    private static final int Transfer = 4;
    private static final int Checking = 5;
    private static final int savings = 6;
    private static final int Exit = 7;

    private static double balance ;

    Scanner scan = new Scanner(System.in);

    public void runMenu() {
        while(true) {
            System.out.println("Select " + Withdrawal + " to withdraw");
            System.out.println("Select " + Deposit + " to deposit");
            System.out.println("Select " + Balance_Inquiry + " to check balance inquiry");
            System.out.println("Select " + Transfer + " to transfer funds");
            System.out.println("Select " + Checking + " to check checking");
            System.out.println("select " + savings + "to check savings");
            System.out.println("Select " + Exit + "to Exit");
            int options = scan.nextInt();

            switch (options) {
                case 1:
                    System.out.println("Enter amount you would like to withdraw");
                    double withdraw = scan.nextDouble();
                    if (balance >= withdraw) {
                        balance -= withdraw;
                    } else {
                        System.out.println("Insufficient Balance");
                    }
                    break;

                case 2:
                    System.out.println("Enter the amount you want to deposit");
                    double deposit = scan.nextDouble();
                    balance += deposit;
                    System.out.println("Deposit successful your current balance is " + balance);
                    break;

                case 3:
                    System.out.println("Balance: " + balance);
                    break;

                case 4:
                    System.out.println("Choose bank account type: ");
                    if (options == Checking) {
                        System.out.println("select amount you would like to transfer:");
                        double transferAmount = scan.nextDouble();
                        System.out.println("would you like to proceed with this transfer?" + transferAmount);
                    } else {
                        System.out.println();
                    }
                    break;
                case 5:
                    System.out.println();


            }
        }
    }
}
