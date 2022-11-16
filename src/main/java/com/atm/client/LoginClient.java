package com.atm.client;

import com.atm.ATM.ATM;
import com.atm.bank.Bank;


import java.util.Scanner;

public class LoginClient {

    private static String cardNumberUserProvided;
    private static String pinNumberUserProvided;
    private static boolean verifyUserInfoBoolean;

    private static boolean passUserInfoToBankForVerification(String cardNumberUserProvided, String pinNumberUserProvided) {

        verifyUserInfoBoolean = false;

        //calling singleton instance of bank
        boolean banksVerificationCheck = Bank.getInstance().verifyLoginClientInfo(cardNumberUserProvided, pinNumberUserProvided);

        if (banksVerificationCheck) {
            verifyUserInfoBoolean = true;
            ATM atm = new ATM();
            atm.runMenu(cardNumberUserProvided);
        }
        return verifyUserInfoBoolean;
    }


    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);

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



