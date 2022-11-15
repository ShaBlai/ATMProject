package com.atm.client;

import com.atm.bank.ATM;
import com.atm.bank.Bank;
//import com.atm.bank.CustomerInfo;
//import com.atm.bank.CustomerInfo;

import java.util.Scanner;

public class loginClient {

    private static String cardNumberUserProvided;
    private static String pinNumberUserProvided;
    private static boolean verifyUserInfoBoolean;

    private static boolean passUserInfoToBankForVerification(String cardNumberUserProvided, String pinNumberUserProvided) {

        verifyUserInfoBoolean = false;

        //old way of object creation of bank
        //Bank bank = new Bank();

                                            //calling singleton instance of bank
        boolean banksVerificationCheck = Bank.getInstance().verifyLoginClientInfo(cardNumberUserProvided, pinNumberUserProvided);

        if (banksVerificationCheck) {
            verifyUserInfoBoolean = true;
            //add logic to call ATMClient
            ATM atm = new ATM();
            atm.runMenu();
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





        //        boolean checkCardNumberIsFourDigits = false;

//        do {
//            if (cardNumberUserProvided.length() != 4) {
//                System.out.println("Entry must be a 4-digit number");
////                myObj.next();
//                cardNumberUserProvided = myObj.nextLine();
//            } else {
//                checkCardNumberIsFourDigits = true;
//                for (int i = 0; i < 4; i++) {
//                    if (!Character.isDigit(cardNumberUserProvided.charAt(i))) {
//                        checkCardNumberIsFourDigits = false;
//                        break;
//                    }
//                }
//                if (checkCardNumberIsFourDigits) {
//                    System.out.println("Received " + cardNumberUserProvided + ". Proceed to pin entry.");
//                } else {
//                    System.out.println("Your entry must only contain four digits!");
////                    myObj.next();
//                    cardNumberUserProvided = myObj.nextLine();
//                }
//            }
////            cardNumberUserProvided = myObj.nextLine();
//        } while (!checkCardNumberIsFourDigits);


//        do {
//            System.out.println("Please enter your 4 digit card number!");
//            while (!myObj.hasNextInt()) {
//                System.out.println("That's not the correct format for a card number!");
//                myObj.next(); // this is important!
//            }
//            cardNumberUserProvided = myObj.nextInt();
//        } while (cardNumberUserProvided <= 1000 || cardNumberUserProvided>=9999);



//        System.out.println("Thank you! This your card number " + cardNumberUserProvided);

//        do {
//            System.out.println("Please enter your 4 digit pin!");
//            while (!myObj.hasNextInt()) {
//                System.out.println("That's not the correct format for a pin!");
//                myObj.next(); // this is important!
//            }
//            pinNumberUserProvided = myObj.nextInt();
//        } while (pinNumberUserProvided <= 1000 || pinNumberUserProvided>=9999);

//        System.out.println("Thank you! You have entered the correct pin format " + pinNumberUserProvided);


    }



}



