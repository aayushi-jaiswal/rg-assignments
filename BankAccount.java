public class BankAccount {
    // Private fields
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Public getter for account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Public getter for balance
    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber + ", Balance: $" + balance);
    }

    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount("123456789", 500.0);

        myAccount.displayAccountInfo();

        myAccount.deposit(200.0);

        myAccount.withdraw(100.0);

        myAccount.displayAccountInfo();
    }
}
