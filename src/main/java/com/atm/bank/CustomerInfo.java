package com.atm.bank;

//package specific class only for Bank's access
class CustomerInfo {

    //fields for the customer's info in the bank
    private String customerCardNumber;
    private String customerUserName;
    private String customerFirstName;
    private String customerLastName;
    private String customerPin;
    private double customerCheckingBalance;
    private double customerSavingsBalance;
    private int customerAccountNumber;


    //constructor for building the customer's information in List "Database"
    public CustomerInfo(String customerCardNumber, String customerUserName, String customerFirstName,
                        String customerLastName, String customerPin, double customerCheckingBalance,
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

    //getters and setters of the customer's information'
    public String getCustomerCardNumber() {
        return customerCardNumber;
    }

    public void setCustomerCardNumber(String customerCardNumber) {
        this.customerCardNumber = customerCardNumber;
    }

    public String getCustomerUserName() {
        return customerUserName;
    }

    public void setCustomerUserName(String customerUserName) {
        this.customerUserName = customerUserName;
    }

    public String getCustomerPin() {
        return customerPin;
    }

    public void setCustomerPin(String customerPin) {
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
