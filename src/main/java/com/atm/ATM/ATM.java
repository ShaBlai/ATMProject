package com.atm.ATM;


import com.atm.bank.Bank;

import java.util.Scanner;

public class ATM {

    private static final String Withdrawal = "1";
    private static final String Deposit = "2";
    private static final String Balance_Inquiry = "3";
    private static final String Transfer = "4";
    private static final String Checking = "5";
    private static final String Savings = "6";
    private static final String Exit = "7";

    private static double balance;


    public void runMenu(String cardNumberThisSession) {

        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Select " + Withdrawal + " to withdraw");
            System.out.println("Select " + Deposit + " to deposit");
            System.out.println("Select " + Balance_Inquiry + " to check balance inquiry");
            System.out.println("Select " + Transfer + " to transfer funds");
            System.out.println("Select " + Exit + " to Exit");
            String options = scan.nextLine();

            switch (options) {
                case "1":
                    System.out.println("Would you like to withdraw " +
                            "from Savings enter: " + Savings + " or Checking enter: " + Checking);
                    String input = scan.nextLine();
                    if (input.equals("6")) {
                        double withdrawalEntry = 0.0;
                        do {
                            System.out.println("The minimum withdrawal is $20.00." +
                                    "\nThe maximum withdrawal is $1,000.00." +
                                    "\nEnter an amount to withdraw from Savings: ");
                            while (!scan.hasNextDouble()) {
                                System.out.println("Invalid entry type, try again.");
                                scan.next(); // this is important!
                            }
                            withdrawalEntry = scan.nextDouble();
                            scan.nextLine();
                        } while (withdrawalEntry < 20.00 || withdrawalEntry > 1000.00);
                        Bank.getInstance().withdrawFromSavings(cardNumberThisSession, withdrawalEntry);

                    } else if (input.equals("5")) {
                        double withdrawalEntry = 0.0;
                        do {
                            System.out.println("The minimum withdrawal is $20.00." +
                                    "\nThe maximum withdrawal is $1,000.00." +
                                    "\nEnter an amount to withdraw from Checking: ");
                            while (!scan.hasNextDouble()) {
                                System.out.println("Invalid entry type, try again.");
                                scan.next(); // this is important!
                            }
                            withdrawalEntry = scan.nextDouble();
                            scan.nextLine();
                        } while (withdrawalEntry < 20.00 || withdrawalEntry > 1000.00);
                        Bank.getInstance().withdrawFromChecking(cardNumberThisSession, withdrawalEntry);
                    }
                    break;

                case "2":
                    System.out.println("Would you like to deposit in Savings" +
                            " enter: " + Savings + " or Checking enter: " + Checking);
                    input = scan.nextLine();

                    if (input.equals("6")) {
                        double depositInput = 0.0;
                        do {
                            System.out.println("The minimum deposit is $1.00." +
                                    "\nThe maximum deposit is $25,000.00." +
                                    "\nEnter an amount to deposit into Savings: ");
                            while (!scan.hasNextDouble()) {
                                System.out.println("Invalid entry type, try again.");
                                scan.next(); // this is important!
                            }
                            depositInput = scan.nextDouble();
                            scan.nextLine();
                        } while (depositInput < 1.00 || depositInput > 25000.00);
                        Bank.getInstance().depositToSavings(cardNumberThisSession, depositInput);

                    } else if (input.equals("5")) {
                        double depositInput = 0.0;
                        do {
                            System.out.println("The minimum deposit is $1.00." +
                                    "\nThe maximum deposit is $25,000.00." +
                                    "\nEnter an amount to deposit into Checking: ");
                            while (!scan.hasNextDouble()) {
                                System.out.println("Invalid entry type, try again.");
                                scan.next();
                            }
                            depositInput = scan.nextDouble();
                            scan.nextLine();
                        } while (depositInput < 1.00 || depositInput > 25000.00);
                        Bank.getInstance().depositToChecking(cardNumberThisSession, depositInput);
                    }
                    break;

                case "3":
                    System.out.println("Select the account type you'd like to display" +
                            "Savings enter: " + Savings + " or Checking enter: " + Checking);
                    input = scan.nextLine();
                    if (input.equals("6")) {
                        Bank.getInstance().displayCustomerSavingBalance(cardNumberThisSession);
                    } else if (input.equals("5")) {
                        Bank.getInstance().displayCustomerCheckingBalance(cardNumberThisSession);
                    }
                    break;

                case "4":
                    System.out.println("Choose bank account type: enter 5 for Checking or 6 for Savings ");
                    input = scan.nextLine();
                    if (input.equals("5")) {
                        double transferEntry = 0.0;
                        do {
                            System.out.println("Please select amount you would like to transfer from Checking:");
                            while (!scan.hasNextDouble()) {
                                System.out.println("Invalid entry type, try again.");
                                scan.next();
                            }
                            transferEntry = scan.nextDouble();
                            scan.nextLine();
                        } while (transferEntry < 0.01 || transferEntry > 100000.00);
                        Bank.getInstance().transferFromChecking(cardNumberThisSession, transferEntry);

                    } else if (input.equals("6")) {
                        double transferEntry = 0.0;
                        do {
                            System.out.println("Please select amount you would like to transfer from Savings:");
                            while (!scan.hasNextDouble()) {
                                System.out.println("Invalid entry type, try again");
                                scan.next();
                            }
                            transferEntry = scan.nextDouble();
                            scan.nextLine();
                        } while (transferEntry < 0.01 || transferEntry > 100000.00);
                        Bank.getInstance().transferFromSavings(cardNumberThisSession, transferEntry);
                    }
                    break;

                case "7":
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid entry, try again.");
            }
        }
    }
}

