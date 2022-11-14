package com.bank;

import java.math.BigDecimal;

//package specific class only for Bank's access
 class CustomerInfo {

     //fields for the customer's info in the bank
    private Integer customerCardNumber;
    private String customerUserName;
    private String customerFirstName;
    private String customerLastName;
    private Integer customerPin;
    private Double customerCheckingBalance;
    private Double customerSavingsBalance;
    private Integer customerAccountNumber;



    //constructor for building the customer's information in List "Database"
    public CustomerInfo(Integer customerCardNumber, String customerUserName, String customerFirstName, String customerLastName, Integer customerPin, Double customerCheckingBalance, Double customerSavingsBalance, Integer customerAccountNumber) {
        this.customerCardNumber = customerCardNumber;
        this.customerUserName = customerUserName;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerPin = customerPin;
        this.customerCheckingBalance = customerCheckingBalance;
        this.customerSavingsBalance = customerSavingsBalance;
        this.customerAccountNumber = customerAccountNumber;
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

    public Integer getCustomerPin() {
        return customerPin;
    }

    public void setCustomerPin(Integer customerPin) {
        this.customerPin = customerPin;
    }

    public Integer getCustomerAccountNumber() {
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
