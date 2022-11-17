package com.atm.bank;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class BankTest {

    List<CustomerInfo> shawnBlair;
    List<CustomerInfo> cameronDavis;
    List<CustomerInfo> juanCruz;

    @Before
    public void setUp() throws Exception {

        shawnBlair = Bank.getInstance().getUserData().stream()
                .filter(customerInfo -> customerInfo.getCustomerCardNumber().equals("1234"))
                .collect(Collectors.toList());

        cameronDavis = Bank.getInstance().getUserData().stream()
                .filter(customerInfo -> customerInfo.getCustomerCardNumber().equals("5678"))
                .collect(Collectors.toList());

        juanCruz = Bank.getInstance().getUserData().stream()
                .filter(customerInfo -> customerInfo.getCustomerCardNumber().equals("4321"))
                .collect(Collectors.toList());
    }

    @Test
    public void test_Verify_Login_Client_Info_Providing_Null_And_Actual_Cases() {

        String testCardNumber = null;
        String testPinNumber = null;
        boolean b = Bank.getInstance().verifyLoginClientInfo(testCardNumber, testPinNumber);
        assertFalse(b);

        String testCardNumberUsingEmptyString = "";
        String testPinNumberUsingEmptyString = "";
        boolean b1= Bank.getInstance().verifyLoginClientInfo(testCardNumberUsingEmptyString, testPinNumberUsingEmptyString);
        assertFalse(b1);

        String testCameronsCardNumber = cameronDavis.get(0).getCustomerCardNumber();
        String testCameronsPinNumber = cameronDavis.get(0).getCustomerPin();
        boolean b2 = Bank.getInstance().verifyLoginClientInfo(testCameronsCardNumber, testCameronsPinNumber);
        assertTrue(b2);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_Withdraw_From_Savings_Providing_Illegal_Customer_Info() {

        CustomerInfo actualCustomerInfo = Bank.getInstance().withdrawFromSavings(
                "5949",
                23999);

        Bank.getInstance().withdrawFromSavings(null, -10);
    }

    @Test
    public void test_Withdraw_From_Savings_Providing_Actual_Cases() {

        CustomerInfo shawnBlairSavings = Bank.getInstance().withdrawFromSavings(
                shawnBlair.get(0).getCustomerCardNumber(),
                10);
        CustomerInfo cameronDavisSavings = Bank.getInstance().withdrawFromSavings(
                cameronDavis.get(0).getCustomerCardNumber(),
                10);
        CustomerInfo juanCruzSavings = Bank.getInstance().withdrawFromSavings(
                juanCruz.get(0).getCustomerCardNumber(),
                10);

        assertEquals(2.34, shawnBlairSavings.getCustomerSavingsBalance(), 0.001);
        assertEquals(11990.34, cameronDavisSavings.getCustomerSavingsBalance(), 0.001);
        assertEquals((225203.43 - 10), juanCruzSavings.getCustomerSavingsBalance(), 0.001);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_Withdraw_From_Checking_Providing_Illegal_Customer_Info() {

        Bank.getInstance().withdrawFromChecking("1252", 2500000);
    }

    @Test
    public void test_Withdraw_From_Checking_Providing_Actual_Cases() {

        CustomerInfo shawnBlairChecking = Bank.getInstance().withdrawFromChecking(
                shawnBlair.get(0).getCustomerCardNumber(),
                100);
        CustomerInfo cameronDavisChecking = Bank.getInstance().withdrawFromChecking(
                cameronDavis.get(0).getCustomerCardNumber(),
                100);
        CustomerInfo juanCruzChecking = Bank.getInstance().withdrawFromChecking(
                juanCruz.get(0).getCustomerCardNumber(),
                100);

        assertEquals(.99, shawnBlairChecking.getCustomerCheckingBalance(), 0.001);
        assertEquals(9836.89, cameronDavisChecking.getCustomerCheckingBalance(), 0.001);
        assertEquals(11900.43, juanCruzChecking.getCustomerCheckingBalance(), 0.001);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_Deposit_To_Savings_Providing_Illegal_Customer_Info() {

        Bank.getInstance().depositToSavings("10000", 10);
    }

    @Test
    public void test_Deposit_To_Savings_Providing_Actual_Cases() {

        CustomerInfo shawnBlairDepositToSavings = Bank.getInstance().depositToSavings(
                shawnBlair.get(0).getCustomerCardNumber(),
                10);
        CustomerInfo cameronDavisDepositToSavings = Bank.getInstance().depositToSavings(
                cameronDavis.get(0).getCustomerCardNumber(),
                10);
        CustomerInfo juanCruzDepositToSavings = Bank.getInstance().depositToSavings(
                juanCruz.get(0).getCustomerCardNumber(),
                10);

        assertEquals(22.34, shawnBlairDepositToSavings.getCustomerSavingsBalance(), 0.001);
        assertEquals(12010.34, cameronDavisDepositToSavings.getCustomerSavingsBalance(), 0.001);
        assertEquals(225213.43, juanCruzDepositToSavings.getCustomerSavingsBalance(), 0.001);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_Deposit_To_Checking_Providing_Illegal_Customer_Info() {

        Bank.getInstance().depositToChecking("0000", 10);
    }

    @Test
    public void test_Deposit_To_Checking_Providing_Actual_Cases() {

        CustomerInfo shawnBlairDepositToChecking = Bank.getInstance().depositToChecking(
                shawnBlair.get(0).getCustomerCardNumber(),
                10);
        CustomerInfo cameronDavisDepositToChecking = Bank.getInstance().depositToChecking(
                cameronDavis.get(0).getCustomerCardNumber(),
                10);
        CustomerInfo juanCruzDepositToChecking = Bank.getInstance().depositToChecking(
                juanCruz.get(0).getCustomerCardNumber(),
                10);

        assertEquals(10.99, shawnBlairDepositToChecking.getCustomerCheckingBalance(), 0.001);
        assertEquals(9946.89, cameronDavisDepositToChecking.getCustomerCheckingBalance(), 0.001);
        assertEquals(12010.43, juanCruzDepositToChecking.getCustomerCheckingBalance(), 0.001);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_Transfer_From_Checking_Providing_Illegal_Customer_Info() {

        Bank.getInstance().transferFromChecking("0001", 100);
    }

    @Test
    public void test_Transfer_From_Checking_Providing_Actual_Cases() {

        CustomerInfo shawnBlairTransferFromChecking = Bank.getInstance().transferFromChecking(
                shawnBlair.get(0).getCustomerCardNumber(),
                10);
        CustomerInfo cameronDavisTransferFromChecking = Bank.getInstance().transferFromChecking(
                cameronDavis.get(0).getCustomerCardNumber(),
                10);
        CustomerInfo juanCruzTransferFromChecking = Bank.getInstance().transferFromChecking(
                juanCruz.get(0).getCustomerCardNumber(),
                10);

        assertEquals(.99, shawnBlairTransferFromChecking.getCustomerCheckingBalance(), 0.001);
        assertEquals(9926.89, cameronDavisTransferFromChecking.getCustomerCheckingBalance(), 0.001);
        assertEquals(11990.43, juanCruzTransferFromChecking.getCustomerCheckingBalance(), 0.001);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_Transfer_From_Savings_Providing_Illegal_Customer_Info() {

        Bank.getInstance().transferFromSavings("0001", 100);
    }

    @Test
    public void test_Transfer_From_Savings_Providing_Actual_Cases() {

        CustomerInfo shawnBlairTransferFromSavings = Bank.getInstance().transferFromSavings(
                shawnBlair.get(0).getCustomerCardNumber(),
                10);
        CustomerInfo cameronDavisTransferFromSavings = Bank.getInstance().transferFromSavings(
                cameronDavis.get(0).getCustomerCardNumber(),
                10);
        CustomerInfo juanCruzTransferFromSavings = Bank.getInstance().transferFromSavings(
                juanCruz.get(0).getCustomerCardNumber(),
                10);

        assertEquals(2.34, shawnBlairTransferFromSavings.getCustomerSavingsBalance(), 0.001);
        assertEquals(11990.34, cameronDavisTransferFromSavings.getCustomerSavingsBalance(), 0.001);
        assertEquals(225193.43, juanCruzTransferFromSavings.getCustomerSavingsBalance(), 0.001);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_Display_Customer_Checking_Balance_Providing_Illegal_Customer_Info() {

        Bank.getInstance().displayCustomerCheckingBalance("0987");
    }

    @Test
    public void test_Display_Customer_Checking_Balance_Providing_Actual_Cases() {

        CustomerInfo shawnBlairDisplayChecking = Bank.getInstance().displayCustomerCheckingBalance(
                shawnBlair.get(0).getCustomerCardNumber());
        CustomerInfo cameronDavisDisplayChecking = Bank.getInstance().displayCustomerCheckingBalance(
                cameronDavis.get(0).getCustomerCardNumber());
        CustomerInfo juanCruzDisplayChecking = Bank.getInstance().displayCustomerCheckingBalance(
                juanCruz.get(0).getCustomerCardNumber());

        assertEquals(.99, shawnBlairDisplayChecking.getCustomerCheckingBalance(), 0.001);
        assertEquals(9936.89, cameronDavisDisplayChecking.getCustomerCheckingBalance(), 0.001);
        assertEquals(12000.43, juanCruzDisplayChecking.getCustomerCheckingBalance(), 0.001);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_Display_Customer_Savings_Balance_Providing_Illegal_Customer_Info() {

        Bank.getInstance().displayCustomerSavingBalance("0987");
    }

    @Test
    public void test_Display_Customer_Savings_Balance_Providing_Actual_Cases() {

        CustomerInfo shawnBlairDisplaySavings = Bank.getInstance().displayCustomerSavingBalance(
                shawnBlair.get(0).getCustomerCardNumber());
        CustomerInfo cameronDavisDisplaySavings = Bank.getInstance().displayCustomerSavingBalance(
                cameronDavis.get(0).getCustomerCardNumber());
        CustomerInfo juanCruzDisplaySavings = Bank.getInstance().displayCustomerSavingBalance(
                juanCruz.get(0).getCustomerCardNumber());

        assertEquals(12.34, shawnBlairDisplaySavings.getCustomerSavingsBalance(), 0.001);
        assertEquals(12000.34, cameronDavisDisplaySavings.getCustomerSavingsBalance(), 0.001);
        assertEquals(225203.43, juanCruzDisplaySavings.getCustomerSavingsBalance(), 0.001);
    }

    @After
    public void tearDown() throws Exception {

        shawnBlair.get(0).setCustomerCheckingBalance(0.99);
        shawnBlair.get(0).setCustomerSavingsBalance(12.34);
        cameronDavis.get(0).setCustomerCheckingBalance(9936.89);
        cameronDavis.get(0).setCustomerSavingsBalance(12000.34);
        juanCruz.get(0).setCustomerCheckingBalance(12000.43);
        juanCruz.get(0).setCustomerSavingsBalance(225203.43);
    }
}