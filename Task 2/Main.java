import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("       USER INPUT HANDLING");
        System.out.println("=================================");

        // Name Input
        String name;
        while (true) {
            System.out.print("Enter your name: ");
            name = scanner.nextLine().trim();

            // Empty input validation
            if (!name.isEmpty()) {
                break;
            }

            System.out.println("Name cannot be empty. Please try again.");
        }

        // Age Input
        String age;
        while (true) {
            System.out.print("Enter your age: ");
            age = scanner.nextLine().trim();

            // Empty input validation
            if (!age.isEmpty()) {
                break;
            }

            System.out.println("Age cannot be empty. Please try again.");
        }

        // City Input
        String city;
        while (true) {
            System.out.print("Enter your city: ");
            city = scanner.nextLine().trim();

            // Empty input validation
            if (!city.isEmpty()) {
                break;
            }

            System.out.println("City cannot be empty. Please try again.");
        }

        // Display Entered Data
        System.out.println();
        System.out.println("=================================");
        System.out.println("       ENTERED USER DETAILS");
        System.out.println("=================================");

        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
        System.out.println("City : " + city);

        System.out.println("=================================");
        System.out.println("Data entered successfully!");

        scanner.close();
    }
}