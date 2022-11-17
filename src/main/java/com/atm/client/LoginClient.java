package com.atm.client;

import com.atm.bank.ATM;
import com.atm.bank.Bank;

import java.util.Scanner;

//class facing user for Login
public class LoginClient {
    //fields presented to the user via scanner for login attempt
    private static String cardNumberUserProvided;
    private static String pinNumberUserProvided;
    private static boolean verifyUserInfoBoolean;

    //Method to pass information to bank for verification of credentials
    private static boolean passUserInfoToBankForVerification(String cardNumberUserProvided, String pinNumberUserProvided) {

        verifyUserInfoBoolean = false;

        //calling singleton instance of bank and passing information
        boolean banksVerificationCheck = Bank.getInstance().verifyLoginClientInfo(cardNumberUserProvided, pinNumberUserProvided);
        //returns verification from bank if login information matches bank records and runs the ATM Menu selection process
        if (banksVerificationCheck) {
            verifyUserInfoBoolean = true;
            ATM.getInstance().runMenu(cardNumberUserProvided);
        }
        return verifyUserInfoBoolean;
    }

    //Main menu presented to the User
    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);
        //Menu takes the Card number and Pin from user, then verifies if the user correctly provided login credentials
        do {
            System.out.println("Please enter your 4 digit card number: ");
            cardNumberUserProvided = myObj.nextLine();

            System.out.println("Please enter your 4 digit pin: ");
            pinNumberUserProvided = myObj.nextLine();

            System.out.println("You provided card number: " + cardNumberUserProvided + "\nYou provided pin number: " + pinNumberUserProvided);

            verifyUserInfoBoolean = passUserInfoToBankForVerification(cardNumberUserProvided, pinNumberUserProvided);
        } while (!verifyUserInfoBoolean);
    }
}



