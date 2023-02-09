package DefiningClassesLab.P03BankAccount;

public class BankAccount {

    private static final double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int accountsCounter = 0;
    private int id;
    private double balance;

    public BankAccount() {
        accountsCounter++;
        this.id = accountsCounter;
        this.balance = 0;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public static int getAccountsCounter() {
        return accountsCounter;
    }

    public static void setAccountsCounter(int accountsCounter) {
        BankAccount.accountsCounter = accountsCounter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterest(int years) {
        return this.balance * interestRate * years;
    }

    public void deposit (int balance){
        this.balance+=balance;
    }
}
