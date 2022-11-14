package com.atm.client;
import java.util.Scanner;

public class loginClient {

    static String userNameInput;
    Integer cardInput;
    Integer pinInput;

    /*public boolean verifyUserInfo() {
        if

        return true;
    }*/



    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);
        Integer cardNumberUserProvided;
        Integer pinNumberUserProvided;

        // Enter username and press Enter
       // System.out.println("Please enter your card number, ending in the last 4 digits");
        //cardNumberUserProvided = myObj.nextInt();

        do {
            System.out.println("Please enter your 4 digit card number!");
            while (!myObj.hasNextInt()) {
                System.out.println("That's not the correct format for a card number!");
                myObj.next(); // this is important!
            }
            cardNumberUserProvided = myObj.nextInt();
        } while (cardNumberUserProvided <= 1000 || cardNumberUserProvided>=9999);

        System.out.println("Thank you! This your card number " + cardNumberUserProvided);

        do {
            System.out.println("Please enter your 4 digit pin!");
            while (!myObj.hasNextInt()) {
                System.out.println("That's not the correct format for a pin!");
                myObj.next(); // this is important!
            }
            pinNumberUserProvided = myObj.nextInt();
        } while (pinNumberUserProvided <= 1000 || pinNumberUserProvided>=9999);

        System.out.println("Thank you! You have entered the correct pin format " + pinNumberUserProvided);


    }



}



