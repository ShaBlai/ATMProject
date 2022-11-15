package com.atm.bank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Bank {

    private static Bank bank;
    private Bank() {
        //test of the singleton
    }

    //singleton implementation of the bank
    public static Bank getInstance() {
        if(null == bank) {
            bank = new Bank();
        }
        return bank;
    }


    //list created as a database to reference their bank information
    private List<CustomerInfo> userData = Arrays.asList(
            //customer's information attached to their account
            new CustomerInfo("1234", "Blairy", "Shawn",
                    "Blair", "1010", .99, 12.34, 1111),
            new CustomerInfo("6969", "Camo", "Cameron",
                    "Davis", "1234", 9936.89, 12000.34, 2222),
            new CustomerInfo("4321", "TheJuan", "Juan",
                    "Cruz", "0101", 12000.43, 225203.43, 3333)

    );

    public boolean verifyLoginClientInfo(String providedCardNumber, String providedPinNumber) {

        boolean verificationBoolean = false;
        for (CustomerInfo customer : userData) {
            if (customer.getCustomerCardNumber().equals(providedCardNumber) && customer.getCustomerPin().equals(providedPinNumber)) {
                System.out.println("Card number & pin verification passed.");
                verificationBoolean = true;
            }
        }

        if (!verificationBoolean) {
            System.out.println("Incorrect card number and/or pin entered.");
        }
        return verificationBoolean;
    }


    public void withdrawFromSavings(String cardNumberOfCorrectCustomer, double withdrawalAmount) {

        List<CustomerInfo> correctCustomer = userData.stream()
                .filter(customerInfo -> customerInfo.getCustomerCardNumber().equals(cardNumberOfCorrectCustomer))
                .collect(Collectors.toList());
        CustomerInfo customerInfo = correctCustomer.get(0);

        if (customerInfo.getCustomerSavingsBalance() >= withdrawalAmount) {
            Double customerSavingsBalance = customerInfo.getCustomerSavingsBalance();
            customerSavingsBalance -= withdrawalAmount;
            customerInfo.setCustomerSavingsBalance(customerSavingsBalance);
            System.out.println("You have withdrawn " + withdrawalAmount + " dollars. " +
                    "\nPlease take cash below. " +
                    "\nYour new savings account balance is: " + customerSavingsBalance);
        } else {

//        for(CustomerInfo customer : userData) {
//            if(customer.getCustomerCheckingBalance().equals(balance)) {
//                System.out.println(customer);
//            }
//            if(customer.getCustomerSavingsBalance().equals(balance)) {
//                System.out.println(customer);
//            }
//        }
        }
    }

    public void withdrawFromChecking(String cardNumberOfCorrectCustomer, double withdrawalAmount) {
        List<CustomerInfo> correctCustomer = userData.stream()
                .filter(customerInfo -> customerInfo.getCustomerCardNumber().equals(cardNumberOfCorrectCustomer))
                .collect(Collectors.toList());
        CustomerInfo customerInfo = correctCustomer.get(0);

        if (customerInfo.getCustomerCheckingBalance() >= withdrawalAmount) {
            Double customerCheckingBalance = customerInfo.getCustomerCheckingBalance();
            customerCheckingBalance -= withdrawalAmount;
            customerInfo.setCustomerCheckingBalance(customerCheckingBalance);
            System.out.println("You have withdrawn " + withdrawalAmount + " dollars. " +
                    "\nPlease take cash below. " +
                    "\nYour new checking account balance is: " + customerCheckingBalance);
        } else {
            System.out.println("Insufficient Balance ");
            }
    }



    public List<CustomerInfo> getUserData() {
        return userData;
    }



    //method in case the user inputs the incorrect username to their account
    public CustomerInfo nullCustomerUserName(String customerUserName) throws IllegalArgumentException {

        // if (//scanner inputted field.equals null){
        //throw new IllegalArgumentException ("You must provide a username");
        //}
        // else if (//scanner inputted field != customerUserName){
        //throw new IllegalArgumentException ("You must provide a correct username");

        // }

        return null;

    }

    //method in case the user inputs the incorrect pin to their account
    public CustomerInfo nullCustomerPin(Integer customerPin) throws IllegalArgumentException {

        // if (//scanner inputted field.equals null) {
        //throw new IllegalArgumentException ("You must provide a pin");
        //}
        //else if (//scanner inputted field != customerPin){
        //throw new IllegalArgumentException ("Your pin is incorrect, please enter the correct pin")

        return null;

    }


}
