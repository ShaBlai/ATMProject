package com.atm.client;


import com.atm.bank.Bank;

import java.util.Scanner;

public class ATMClient extends Bank {


    private static final int Withdrawal = 1;
    private static final int Deposit = 2;
    private static final int Balance_Inquiry = 3;
    private static final int Transfer = 4;
    private static final double Checking = 5;
    private static final double savings = 6;
    private static final int Exit = 7;

    Scanner scan = new Scanner(System.in);

    public ATMClient() {
    }




    /*while (true)
    {
        System.out.println("Select " +Withdrawal+ " to withdraw");
        System.out.println("Select " +Deposit+ " to deposit");
        System.out.println("Select " + Balance_Inquiry+ " to check balance inquiry");
        System.out.println("Select " +Transfer+ " to transfer funds");
        System.out.println("Select "+Checking+ " to check checking");
        System.out.println("select "+savings+ "to check savings");
        System.out.println("Select " +Exit+ "to Exit");
        int options = scan.nextInt();

        switch(options)
        {
            case 1:
            System.out.println("Enter amount you would like to withdraw");
                int withdraw = scan.nextInt();
                if(getUserData().)


        }
    }

    public Scanner getScan() {
        return scan;
    }

    public void setScan(Scanner scan) {
        this.scan = scan;
    }
*/
}
