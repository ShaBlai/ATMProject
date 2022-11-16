package com.atm.ATM;

import com.atm.bank.Bank;

import java.util.Scanner;

//class for the ATM execution
public class ATM {

    private static final String Withdrawal = "1";
    private static final String Deposit = "2";
    private static final String Balance_Inquiry = "3";
    private static final String Transfer = "4";
    private static final String Checking = "5";
    private static final String Savings = "6";
    private static final String Exit = "0";


    //Singleton implementation of the ATM Instances to assist with data encapsulation
    private static ATM atm;

    private ATM() {

    }

    public static ATM getInstance() {
        if (null == atm) {
            atm = new ATM();
        }
        return atm;
    }

    //Method to perform the Menu logic once User Account is logged in
    public void runMenu(String cardNumberThisSession) {

        Scanner scan = new Scanner(System.in);
        //Beginning of Menu for User Input
        while (true) {
            System.out.println("Select " + Withdrawal + " for Withdrawal");
            System.out.println("Select " + Deposit + " for Deposit");
            System.out.println("Select " + Balance_Inquiry + " for Balance Inquiry");
            System.out.println("Select " + Transfer + " for Transfer Funds");
            System.out.println("Select " + Exit + " to Exit");
            String options = scan.nextLine();
            switch (options) {
                //Withdrawal Method if User Selects "1" in Menu
                case "1":
                    System.out.println("Would you like to withdraw " +
                            "from Savings enter: " + Savings + " or Checking enter: " + Checking);
                    String input = scan.nextLine();
                    //Savings Withdrawal if user Selects "6"
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
                        //Checking Withdrawal if user Selects "5"
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
                //Deposit case if user selects "2"
                case "2":
                    System.out.println("Would you like to deposit in Savings" +
                            " enter: " + Savings + " or Checking enter: " + Checking);
                    input = scan.nextLine();
                    //Savings Deposit if user selects "6"
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
                        //Checking Deposit if user selects "5"
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
                //Balance Inquiry Case if User selects "3"
                case "3":
                    System.out.println("Select the account type you'd like to display" +
                            " Savings enter: " + Savings + " or Checking enter: " + Checking);
                    input = scan.nextLine();
                    //Balance of Savings is displayed if User selects "6"
                    if (input.equals("6")) {
                        Bank.getInstance().displayCustomerSavingBalance(cardNumberThisSession);
                        //Balance of Checking is displayed if User selects "5"
                    } else if (input.equals("5")) {
                        Bank.getInstance().displayCustomerCheckingBalance(cardNumberThisSession);
                    }
                    break;
                //Transfer case if user selects "4"
                case "4":
                    System.out.println("Choose bank account type: enter 5 for Checking or 6 for Savings ");
                    input = scan.nextLine();
                    //Checking Transfer To Savings if user selects "5"
                    if (input.equals("5")) {
                        double transferEntry = 0.0;
                        do {
                            System.out.println("Please select amount you would like to transfer from Checking to Savings:");
                            while (!scan.hasNextDouble()) {
                                System.out.println("Invalid entry type, try again.");
                                scan.next();
                            }
                            transferEntry = scan.nextDouble();
                            scan.nextLine();
                        } while (transferEntry < 0.01 || transferEntry > 100000.00);
                        Bank.getInstance().transferFromChecking(cardNumberThisSession, transferEntry);
                        //Savings transfer to Checking if user selects "6"
                    } else if (input.equals("6")) {
                        double transferEntry = 0.0;
                        do {
                            System.out.println("Please select amount you would like to transfer from Savings to Checking:");
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
                //Case exits current session of ATM
                case "0":
                    System.exit(0);
                    break;
                //Default case if user does not select correct input
                default:
                    System.out.println("Invalid entry, try again.");
            }
        }
    }
}

