
public class Main {

    public static void main(String[] args) {

        // Initial Balance
        BankAccount account = new BankAccount(10000);

        // ATM Object
        ATM atm = new ATM(account);

        // Start ATM
        atm.start();

    }

}
