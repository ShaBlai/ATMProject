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
        if (null == bank) {
            bank = new Bank();
        }
        return bank;
    }


    //list created as a database to reference their bank information
    private List<CustomerInfo> userData = Arrays.asList(
            //customer's information attached to their account
            new CustomerInfo("1234", "Blairy", "Shawn",
                    "Blair", "1010", .99, 12.34, 1111),
            new CustomerInfo("5678", "Camo", "Cameron",
                    "Davis", "1234", 9936.89, 12000.34, 2222),
            new CustomerInfo("4321", "TheJuan", "Juan",
                    "Cruz", "0101", 12000.43, 225203.43, 3333)

    );

    //Method to verify the Login Client Fields against the UserData List
    public boolean verifyLoginClientInfo(String providedCardNumber, String providedPinNumber) {

        //Sets initial verificationBoolean to false, until information is verified
        boolean verificationBoolean = false;

        //Enhanced for loop to go through customers in userData and return true if the pin and card number are found
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

    private CustomerInfo authenticate(String cardNumberOfCorrectCustomer) {
        List<CustomerInfo> correctCustomer = userData.stream()
                .filter(customerInfo -> customerInfo.getCustomerCardNumber().equals(cardNumberOfCorrectCustomer))
                .collect(Collectors.toList());
        CustomerInfo customerInfo = correctCustomer.get(0);
        return  customerInfo;
    }

    //Method to perform the Withdrawal from the User's Savings Account
    protected CustomerInfo withdrawFromSavings(String cardNumberOfCorrectCustomer, double withdrawalAmount) {
        //Stream to comb through the customer database and compare card number with client input
        CustomerInfo authenticate = authenticate(cardNumberOfCorrectCustomer);
        //Compares current Savings Balance to the requested withdrawal amount, withdraws it if possible,
        //and updates the savings balance
        if (authenticate.getCustomerSavingsBalance() >= withdrawalAmount) {
            Double customerSavingsBalance = authenticate.getCustomerSavingsBalance();
            customerSavingsBalance -= withdrawalAmount;
            authenticate.setCustomerSavingsBalance(customerSavingsBalance);
            System.out.format("You have withdrawn $%.2f from Savings. " +
                    "\nPlease take cash below. " +
                    "\nYour updated savings account balance is: $" +
                    customerSavingsBalance + ".\n\n", withdrawalAmount);
            //Result if the customer's requested withdraw amount is more than the current balance
        } else {
            System.out.println("Insufficient funds in account.");
        }
        return authenticate;
    }

    //Method to perform the Withdrawal from the User's Checking Account
    protected CustomerInfo withdrawFromChecking(String cardNumberOfCorrectCustomer, double withdrawalAmount) {
        //Stream to comb through the customer fields and compare card number with client input
        CustomerInfo authenticate = authenticate(cardNumberOfCorrectCustomer);
        //Compares current Checking Balance to the requested withdrawal amount, withdraws it if possible,
        //and updates the checking balance
        if (authenticate.getCustomerCheckingBalance() >= withdrawalAmount) {
            Double customerCheckingBalance = authenticate.getCustomerCheckingBalance();
            customerCheckingBalance -= withdrawalAmount;
            authenticate.setCustomerCheckingBalance(customerCheckingBalance);
            System.out.format("You have withdrawn $%.2f from Checking. " +
                    "\nPlease take cash below. " +
                    "\nYour updated savings account balance is: $" +
                    customerCheckingBalance + ".\n\n", withdrawalAmount);
            //Result if the customer's requested withdraw amount is more than the current balance
        } else {
            System.out.println("Insufficient funds in account.");
        }
        return authenticate;
    }

    //Method to perform the Deposit to the User's Savings Account
    protected CustomerInfo depositToSavings(String cardNumberOfCorrectCustomer, double depositAmount) {
        //Similar stream logic as before
        CustomerInfo authenticate = authenticate(cardNumberOfCorrectCustomer);
        //Deposits the cash amount to the Savings and sets the updated account balance
        Double customerSavingsBalance = authenticate.getCustomerSavingsBalance();
        customerSavingsBalance += depositAmount;
        authenticate.setCustomerSavingsBalance(customerSavingsBalance);
        //Result showing the deposit and new savings balance to user
        System.out.format("You have deposited $%.2f into your Savings account. " +
                "\nYour updated account balance is: $" +
                customerSavingsBalance + ".\n\n", depositAmount);

        return authenticate;
    }

    //Method to perform the Deposit to the User's Checking Account
    protected CustomerInfo depositToChecking(String cardNumberOfCorrectCustomer, double depositAmount) {
        //Similar stream logic as before
        CustomerInfo authenticate = authenticate(cardNumberOfCorrectCustomer);
        //similar deposit logic as before
        Double customerCurrentCheckingBalance = authenticate.getCustomerCheckingBalance();
        customerCurrentCheckingBalance += depositAmount;
        authenticate.setCustomerCheckingBalance(customerCurrentCheckingBalance);
        //Result showing the deposit and new checking balance to user
        System.out.format("You have deposited $%.2f into your Checking account. " +
                "\nYour updated account balance is: $" +
                customerCurrentCheckingBalance + ".\n\n", depositAmount);

        return authenticate;
    }

    //Method to perform the Transfer from User's Checking Account to Savings Account
    protected CustomerInfo transferFromChecking(String cardNumberOfCorrectCustomer, double transferAmount) {
        //similar stream logic as before
        CustomerInfo authenticate = authenticate(cardNumberOfCorrectCustomer);

        //Verifies if the transfer amount is possible, then executes the transfer
        if (authenticate.getCustomerCheckingBalance() >= transferAmount) {
            Double customerCheckingBalance = authenticate.getCustomerCheckingBalance();
            Double customerSavingsBalance = authenticate.getCustomerSavingsBalance();
            //Subtracts from checking balance and changes balance accordingly
            customerCheckingBalance -= transferAmount;
            authenticate.setCustomerCheckingBalance(customerCheckingBalance);
            //Adds the transfer amount to the savings balance
            customerSavingsBalance += transferAmount;
            authenticate.setCustomerSavingsBalance(customerSavingsBalance);

            //Result showing the transfer and new savings balance to user
            System.out.format("You have transferred $%.2f to Savings " +
                    "\nYour new Savings account balance is: $" + customerSavingsBalance + ".\n\n", transferAmount);
        //Result shown if transfer amount is insufficient
        } else {
            System.out.println("You cannot transfer this amount, insufficient funds to transfer.");
        }

        return authenticate;
    }

    //Method to perform the Transfer from User's Savings Account to Checking Account
    protected CustomerInfo transferFromSavings(String cardNumberOfCorrectCustomer, double transferAmount) {
        //similar stream logic as before
        CustomerInfo authenticate = authenticate(cardNumberOfCorrectCustomer);
        //verifies if transfer amount is possible, then executes it
        if (authenticate.getCustomerSavingsBalance() >= transferAmount) {
            Double customerSavingsBalance = authenticate.getCustomerSavingsBalance();
            Double customerCheckingBalance = authenticate.getCustomerCheckingBalance();
            //subtracts from savings balance and updates that balance
            customerSavingsBalance -= transferAmount;
            authenticate.setCustomerSavingsBalance(customerSavingsBalance);
            //adds transferred amount to checking
            customerCheckingBalance += (transferAmount);
            authenticate.setCustomerCheckingBalance(customerCheckingBalance);
            //result shown if transfer successful
            System.out.format("You have transferred $%.2f to Checking " +
                    "\nYour new Checking account balance is: $" + customerCheckingBalance + ".\n\n", transferAmount);
        //result shown if insufficient funds to transfer
        } else {
            System.out.println("You cannot transfer this amount, insufficient funds to transfer");
        }

        return authenticate;
    }

    //Method to perform the Balance Inquiry of the User's Checking Account
    protected CustomerInfo displayCustomerCheckingBalance(String cardNumberOfCorrectCustomer) {

        CustomerInfo authenticate = authenticate(cardNumberOfCorrectCustomer);
        Double customerCheckingBalance = authenticate.getCustomerCheckingBalance();
        System.out.println("Your checking balance is $" + customerCheckingBalance);

        return authenticate;
    }

    //Method to perform the Balance Inquiry of the User's Savings Account
    protected CustomerInfo displayCustomerSavingBalance(String cardNumberOfCorrectCustomer) {
        CustomerInfo authenticate = authenticate(cardNumberOfCorrectCustomer);

        Double customerSavingsBalance = authenticate.getCustomerSavingsBalance();
        System.out.println("Your savings balance is $" + customerSavingsBalance);

        return authenticate;
    }


    protected List<CustomerInfo> getUserData() {
        return userData;
    }
}
