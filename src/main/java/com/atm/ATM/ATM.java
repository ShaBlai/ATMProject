package com.atm.ATM;


import com.atm.bank.Bank;

import java.util.Scanner;

public class ATM {

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
                        Bank.getInstance().withdrawFromSavings(cardNumberThisSession, amountToWithdraw);

                    }
                    else if (scan.nextInt() == Checking) {
                        System.out.println("Enter amount you would like to withdraw from checking");


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
                    System.out.println("Choose bank account type: Input 5 for Checking or 6 for Savings ");
                    if (scan.nextInt() == Checking) {
                        System.out.println("Please select amount you would like to transfer from Checking:");
                        double transferAmount = scan.nextDouble();
                        Bank.getInstance().transferFromChecking(cardNumberThisSession, transferAmount);

                    } else if (scan.nextInt() == Savings){
                        System.out.println("Please select amount you would like to transfer from Savings:");
                        double transferAmount = scan.nextDouble();
                        Bank.getInstance().transferFromSavings(cardNumberThisSession, transferAmount);
                    }
                    System.out.println();
            }


           /* break;
                case 7:
                    System.exit(0);


            }*/
        }
    }

}

