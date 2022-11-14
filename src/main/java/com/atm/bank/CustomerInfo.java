package com.atm.bank;

import java.math.BigDecimal;

//package specific class only for Bank's access
 class CustomerInfo {

     //fields for the customer's info in the bank
    private int customerCardNumber;
    private String customerUserName;
    private String customerFirstName;
    private String customerLastName;
    private int customerPin;
    private double customerCheckingBalance;
    private double customerSavingsBalance;
    private int customerAccountNumber;



    //constructor for building the customer's information in List "Database"
    public CustomerInfo(int customerCardNumber, String customerUserName, String customerFirstName,
                        String customerLastName, int customerPin, double customerCheckingBalance,
                        double customerSavingsBalance, int customerAccountNumber) {
        this.customerCardNumber = customerCardNumber;
        this.customerUserName = customerUserName;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerPin = customerPin;
        this.customerCheckingBalance = customerCheckingBalance;
        this.customerSavingsBalance = customerSavingsBalance;
        this.customerAccountNumber = customerAccountNumber;
    }

    public boolean validateCardNumber(int userCard) {
        if(userCard != getCustomerCardNumber()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validatePin(int userPin) {
        if(userPin != getCustomerPin()) {
            return false;
        } else {
            return true;
        }
    }


    //getters and setters
    public Integer getCustomerCardNumber() {
        return customerCardNumber;
    }

    public void setCustomerCardNumber(Integer customerCardNumber) {
        this.customerCardNumber = customerCardNumber;
    }

    public String getCustomerUserName() {
        return customerUserName;
    }

    public void setCustomerUserName(String customerUserName) {
        this.customerUserName = customerUserName;
    }

    public int getCustomerPin() {
        return customerPin;
    }

    public void setCustomerPin(Integer customerPin) {
        this.customerPin = customerPin;
    }

    public int getCustomerAccountNumber() {
        return customerAccountNumber;
    }

    public void setCustomerAccountNumber(Integer customerAccountNumber) {
        this.customerAccountNumber = customerAccountNumber;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public Double getCustomerCheckingBalance() {
        return customerCheckingBalance;
    }

    public void setCustomerCheckingBalance(Double customerCheckingBalance) {
        this.customerCheckingBalance = customerCheckingBalance;
    }

    public Double getCustomerSavingsBalance() {
        return customerSavingsBalance;
    }

    public void setCustomerSavingsBalance(Double customerSavingsBalance) {
        this.customerSavingsBalance = customerSavingsBalance;
    }
}
