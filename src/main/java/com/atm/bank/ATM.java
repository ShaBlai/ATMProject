package com.atm.bank;


import com.atm.bank.Bank;
import com.atm.bank.CustomerInfo;

import java.beans.Customizer;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class ATM{

    private static final int Withdrawal = 1;
    private static final int Deposit = 2;
    private static final int Balance_Inquiry = 3;
    private static final int Transfer = 4;
    private static final int Checking = 5;
    private static final int Savings = 6;
    private static final int Exit = 7;

    private static double balance;


    public void runMenu(String cardNumberThisSession) {

        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Select " + Withdrawal + " to withdraw");
            System.out.println("Select " + Deposit + " to deposit");
            System.out.println("Select " + Balance_Inquiry + " to check balance inquiry");
            System.out.println("Select " + Transfer + " to transfer funds");
            System.out.println("Select " + Checking + " to for checking");
            System.out.println("select " + Savings + " to for savings");
            System.out.println("Select " + Exit + " to Exit");
            int options = scan.nextInt();

            switch (options) {
                case 1:
                    System.out.println("Would you like to withdraw " +
                            "from Savings enter: "+Savings+ " or Checking enter: " +Checking);
//                    int savings = scan.nextInt();
//                    int checking = scan.nextInt();
                    if(scan.nextInt() == Savings) {
                        System.out.println("Enter amount you would like to withdraw from savings");
                        double amountToWithdraw = scan.nextDouble();
                        Bank.getInstance().withdraw(cardNumberThisSession, amountToWithdraw);
//                        CustomerInfo customerInfo = new CustomerInfo();
//                        CustomerInfo customerInfo = Bank.getInstance().getUserData().get(1);
//                        customerInfo.getCustomerSavingsBalance();
                    }
                    else if (scan.nextInt() == Checking) {
                        System.out.println("Enter amount you would like to withdraw from checking");
                        CustomerInfo customerInfo = new CustomerInfo();

                    }

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
                case 7:
                    System.exit(0);


            }
        }
    }

}

