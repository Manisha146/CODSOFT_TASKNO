public class BankAccount {

    private double balance;

    // Constructor
    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Deposit Method
    public void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " Deposited Successfully.");
        } else {
            System.out.println("Invalid Amount!");
        }

    }

    // Withdraw Method
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid Amount!");
        }
        else if (amount > balance) {
            System.out.println("Insufficient Balance!");
        }
        else {
            balance -= amount;
            System.out.println("₹" + amount + " Withdrawn Successfully.");
        }

    }

    // Check Balance
    public void checkBalance() {
        System.out.println("Current Balance : ₹" + balance);
    }
}
