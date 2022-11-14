package account;

public class Account {

    private int accountNumber;
    private int atmCardNumber;
    private int pin;
    private double availableBalance;
    private double totalBalance;
    private String name;

    public Account(int accountNumber, int atmCardNumber, int pin, double availableBalance, double totalBalance, String name) {
        this.accountNumber = accountNumber;
        this.atmCardNumber = atmCardNumber;
        this.pin = pin;
        this.availableBalance = availableBalance;
        this.totalBalance = totalBalance;
        this.name = name;
    }
}
