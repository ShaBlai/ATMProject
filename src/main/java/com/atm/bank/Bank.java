package com.atm.bank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Bank {


    //Singleton creation for use of "InstanceOf" instead of new objects
    private static Bank bank;

    private Bank() {

    }

    //Singleton implementation of the Bank Instances to assist with data encapsulation
    public static Bank getInstance() {
        if (null == bank) {
            bank = new Bank();
        }
        return bank;
    }


    //List created containing the customer's bank information
    private List<CustomerInfo> userData = Arrays.asList(
            //customer's information attached to their account
            new CustomerInfo("1234", "Blairy", "Shawn",
                    "Blair", "1010", .99, 12.34, 1111),
            new CustomerInfo("6969", "Camo", "Cameron",
                    "Davis", "1234", 9936.89, 12000.34, 2222),
            new CustomerInfo("4321", "TheJuan", "Juan",
                    "Cruz", "0101", 12000.43, 225203.43, 3333)

    );

    //Method to verify the Login Client Fields against the UserData List
    public boolean verifyLoginClientInfo(String providedCardNumber, String providedPinNumber) {
        //Sets initial verificationBoolean to false, until information is verified
        boolean verificationBoolean = false;

        //Enhanced for loop to go through customers in user and return if the pin and card number are the same
        for (CustomerInfo customer : userData) {
            if (customer.getCustomerCardNumber().equals(providedCardNumber) && customer.getCustomerPin().equals(providedPinNumber)) {
                System.out.println("Card number & pin verification passed. \n\nWelcome " +
                        customer.getCustomerFirstName() + " " + customer.getCustomerLastName() + "!");
                verificationBoolean = true;
            }
        }
        //if the user does not input the correct during login, return this below
        if (!verificationBoolean) {
            System.out.println("Incorrect card number and/or pin entered.");
        }

        return verificationBoolean;
    }

    //Method to perform the Withdrawal from the User's Savings Account
    public void withdrawFromSavings(String cardNumberOfCorrectCustomer, double withdrawalAmount) {
        //Stream to comb through the customer database and compare card number with client input
        List<CustomerInfo> correctCustomer = userData.stream()
                .filter(customerInfo -> customerInfo.getCustomerCardNumber().equals(cardNumberOfCorrectCustomer))
                .collect(Collectors.toList());
        CustomerInfo customerInfo = correctCustomer.get(0);
        //Compares Savings Balance to the requested withdrawal amount, withdraws it if possible, and sets the updated savings balance//
        if (customerInfo.getCustomerSavingsBalance() >= withdrawalAmount) {
            Double customerSavingsBalance = customerInfo.getCustomerSavingsBalance();
            customerSavingsBalance -= withdrawalAmount;
            customerInfo.setCustomerSavingsBalance(customerSavingsBalance);
            System.out.format("You have withdrawn $%.2f from Savings. " +
                    "\nPlease take cash below. " +
                    "\nYour updated savings account balance is: $" +
                    customerSavingsBalance + ".\n\n", withdrawalAmount);
            //Result if the customer's requested withdraw amount is more than the balance
        } else {
            System.out.println("Insufficient funds in account.");
        }
    }

    //Method to perform the Withdrawal from the User's Checking Account
    public void withdrawFromChecking(String cardNumberOfCorrectCustomer, double withdrawalAmount) {
        //Stream to comb through the customer fields and compare card number with client input
        List<CustomerInfo> correctCustomer = userData.stream()
                .filter(customerInfo -> customerInfo.getCustomerCardNumber().equals(cardNumberOfCorrectCustomer))
                .collect(Collectors.toList());
        CustomerInfo customerInfo = correctCustomer.get(0);
        //Compares Checking Balance to the requested withdrawal amount, withdraws it if possible, and sets the updated checking balance
        if (customerInfo.getCustomerCheckingBalance() >= withdrawalAmount) {
            Double customerCheckingBalance = customerInfo.getCustomerCheckingBalance();
            customerCheckingBalance -= withdrawalAmount;
            customerInfo.setCustomerCheckingBalance(customerCheckingBalance);
            System.out.format("You have withdrawn $%.2f from Checking. " +
                    "\nPlease take cash below. " +
                    "\nYour updated savings account balance is: $" +
                    customerCheckingBalance + ".\n\n", withdrawalAmount);
            //Result if the customer's requested withdraw amount is more than the balance
        } else {
            System.out.println("Insufficient funds in account.");
        }
    }

    //Method to perform the Deposit to the User's Savings Account
    public void depositToSavings(String cardNumberOfCorrectCustomer, double depositAmount) {
        //Stream to comb through the customer database and compare card number with client input
        List<CustomerInfo> correctCustomer = userData.stream()
                .filter(customerInfo -> customerInfo.getCustomerCardNumber().equals(cardNumberOfCorrectCustomer))
                .collect(Collectors.toList());
        CustomerInfo correctCustomerInfo = correctCustomer.get(0);
        //Deposits the cash amount to the Savings and sets the updated account balance
        Double customerSavingsBalance = correctCustomerInfo.getCustomerSavingsBalance();
        customerSavingsBalance += depositAmount;
        correctCustomerInfo.setCustomerSavingsBalance(customerSavingsBalance);
        //Result showing the deposit and new savings balance to user
        System.out.format("You have deposited $%.2f into your Savings account. " +
                "\nYour updated account balance is: $" +
                customerSavingsBalance + ".\n\n", depositAmount);
    }

    //Method to perform the Deposit to the User's Checking Account
    public void depositToChecking(String cardNumberOfCorrectCustomer, double depositAmount) {
        //Stream to comb through the customer database and compare card number with client input
        List<CustomerInfo> correctCustomer = userData.stream()
                .filter(customerInfo -> customerInfo.getCustomerCardNumber().equals(cardNumberOfCorrectCustomer))
                .collect(Collectors.toList());
        CustomerInfo customerInfo = correctCustomer.get(0);
        //Deposits the cash amount to the Checking and sets the updated account balance
        Double customerCurrentCheckingBalance = customerInfo.getCustomerCheckingBalance();
        customerCurrentCheckingBalance += depositAmount;
        customerInfo.setCustomerCheckingBalance(customerCurrentCheckingBalance);
        //Result showing the deposit and new checking balance to user
        System.out.format("You have deposited $%.2f into your Checking account. " +
                "\nYour updated account balance is: $" +
                customerCurrentCheckingBalance + ".\n\n", depositAmount);
    }

    //Method to perform the Transfer from User's Checking Account to Savings Account
    public void transferFromChecking(String cardNumberOfCorrectCustomer, double transferAmount) {
        //Stream to comb through the customer database and compare card number with client input
        List<CustomerInfo> correctCustomerTransfer = userData.stream()
                .filter(customerInfoTransfer -> customerInfoTransfer.getCustomerCardNumber().equals(cardNumberOfCorrectCustomer))
                .collect(Collectors.toList());
        CustomerInfo customerInfoTransfer = correctCustomerTransfer.get(0);
        //Verifies if the transfer amount is possible, then executes the transfer
        if (customerInfoTransfer.getCustomerCheckingBalance() >= transferAmount) {
            Double customerCheckingBalance = customerInfoTransfer.getCustomerCheckingBalance();
            Double customerSavingsBalance = customerInfoTransfer.getCustomerSavingsBalance();
            //Subtracts from checking balance and changes balance accordingly
            customerCheckingBalance -= transferAmount;
            customerInfoTransfer.setCustomerCheckingBalance(customerCheckingBalance);
            //Adds the transfer amount to the savings balance
            customerSavingsBalance += transferAmount;
            customerInfoTransfer.setCustomerSavingsBalance(customerSavingsBalance);
            //Result showing the transfer and new savings balance to user
            System.out.format("You have transferred $%.2f to Savings " +
                    "\nYour new Savings account balance is: $" + customerSavingsBalance + ".\n\n", transferAmount);
            //Result showing if transfer amount is insufficient
        } else {
            System.out.println("You cannot transfer this amount, insufficient funds to transfer.");
        }
    }

    //Method to perform the Transfer from User's Savings Account to Checking Account
    public void transferFromSavings(String cardNumberOfCorrectCustomer, double transferAmount) {
        //Stream to comb through the customer database and compare card number with client input
        List<CustomerInfo> correctCustomerTransfer = userData.stream()
                .filter(customerInfoTransfer -> customerInfoTransfer.getCustomerCardNumber().equals(cardNumberOfCorrectCustomer))
                .collect(Collectors.toList());
        CustomerInfo customerInfoTransfer = correctCustomerTransfer.get(0);
        //Verifies if the transfer amount is possible, then executes the transfer
        if (customerInfoTransfer.getCustomerSavingsBalance() >= transferAmount) {
            Double customerSavingsBalance = customerInfoTransfer.getCustomerSavingsBalance();
            Double customerCheckingBalance = customerInfoTransfer.getCustomerCheckingBalance();
            //Subtracts from savings balance and changes balance accordingly
            customerSavingsBalance -= transferAmount;
            customerInfoTransfer.setCustomerSavingsBalance(customerSavingsBalance);
            //Adds the transfer amount to the checking balance
            customerCheckingBalance += (transferAmount);
            customerInfoTransfer.setCustomerCheckingBalance(customerCheckingBalance);
            //Result showing the transfer and new checking balance to user
            System.out.format("You have transferred $%.2f to Checking " +
                    "\nYour new Checking account balance is: $" + customerCheckingBalance + ".\n\n", transferAmount);
            //Result showing if transfer amount is insufficient
        } else {
            System.out.println("You cannot transfer this amount, insufficient funds to transfer");
        }
    }

    //Method to perform the Balance Inquiry of the User's Checking Account
    public void displayCustomerCheckingBalance(String cardNumberOfCorrectCustomer) {
        //Stream to comb through the customer database and compare card number with client input
        List<CustomerInfo> correctCustomer = userData.stream()
                .filter(customerInfo -> customerInfo.getCustomerCardNumber().equals(cardNumberOfCorrectCustomer))
                .collect(Collectors.toList());
        CustomerInfo customerInfo = correctCustomer.get(0);
        //Result showing the current balance of the checking account
        Double customerCheckingBalance = customerInfo.getCustomerCheckingBalance();
        System.out.println("Your checking balance is $" + customerCheckingBalance);
    }

    //Method to perform the Balance Inquiry of the User's Checking Account
    public void displayCustomerSavingBalance(String cardNumberOfCorrectCustomer) {
        //Stream to comb through the customer database and compare card number with client input
        List<CustomerInfo> correctCustomer = userData.stream()
                .filter(customerInfo -> customerInfo.getCustomerCardNumber().equals(cardNumberOfCorrectCustomer))
                .collect(Collectors.toList());
        CustomerInfo customerInfo = correctCustomer.get(0);
        //Result showing the current balance of the savings account
        Double customerSavingsBalance = customerInfo.getCustomerSavingsBalance();
        System.out.println("Your savings balance is $" + customerSavingsBalance);
    }

    public List<CustomerInfo> getUserData() {
        return userData;
    }

}
