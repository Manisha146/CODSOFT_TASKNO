import java.util.Scanner;

public class ATM {

    private BankAccount account;
    private Scanner sc;

    // Constructor
    public ATM(BankAccount account) {
        this.account = account;
        sc = new Scanner(System.in);
    }

    // ATM Menu
    public void start() {

        int choice;

        do {

            System.out.println("\n==============================");
            System.out.println("       ATM INTERFACE");
            System.out.println("==============================");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Deposit Amount : ");
                    double deposit = sc.nextDouble();

                    account.deposit(deposit);

                    break;

                case 2:

                    System.out.print("Enter Withdraw Amount : ");
                    double withdraw = sc.nextDouble();

                    account.withdraw(withdraw);

                    break;

                case 3:

                    account.checkBalance();

                    break;

                case 4:

                    System.out.println("Thank You For Using ATM.");
                    break;

                default:

                    System.out.println("Invalid Choice!");

            }

        } while (choice != 4);

    }

}
