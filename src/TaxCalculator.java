import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TaxCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            // Prompt user for input data
            System.out.print("Enter your first name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter your last name: ");
            String lastName = scanner.nextLine();
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();
            System.out.print("Enter your income: ");
            double income = scanner.nextDouble();
            System.out.print("Enter your deductions: ");
            double deductions = scanner.nextDouble();
            System.out.print("Enter your allowances: ");
            double allowances = scanner.nextDouble();

            // Prompt the user to enter their annual income
            System.out.print("Enter your annual income: ");

            // Read the input from the user
            int annualIncome = scanner.nextInt();

            // Print the entered income
            System.out.println("Your annual income is: $" + annualIncome);

            // Calculate income tax
            int incomeTax = tax(annualIncome);
            System.out.println("Your income tax is: $" + incomeTax);

            // Write output to a file
            try {
                File outputFile = new File("output.txt");
                FileWriter writer = new FileWriter(outputFile, true);
                writer.write("Name: " + firstName + " " + lastName + "\n");
                writer.write("Age: " + age + "\n");
                writer.write("Income: $" + income + "\n");
                writer.write("Deductions: $" + deductions + "\n");
                writer.write("Allowances: $" + allowances + "\n");
                writer.write("Annual Income: $" + annualIncome + "\n");
                writer.write("Income Tax: $" + incomeTax + "\n");
                writer.write("-------------------------\n");
                writer.close();
                System.out.println("Output written to output.txt");
            } catch (IOException e) {
                System.out.println("An error occurred while writing the output to a file.");
                e.printStackTrace();
            }

            // Prompt the user if they want to continue
            System.out.print("Do you want to calculate tax again? (y/n): ");
            scanner.nextLine(); // Consume the newline character after nextInt()
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("n")) {
                exit = true;
            }
        }

        scanner.close();
        System.out.println("Program exited. Goodbye!");
    }

    public static int tax(int annualIncome) {
        int incomeTax = 0;

        if (annualIncome <= 50000) {
            incomeTax = (int) (annualIncome * 0.02);
        } else if (annualIncome <= 100000) {
            incomeTax = (int) (50000 * 0.02 + (annualIncome - 50000) * 0.06);
        } else if (annualIncome <= 150000) {
            incomeTax = (int) (50000 * 0.02 + 50000 * 0.06 + (annualIncome - 100000) * 0.1);
        } else if (annualIncome <= 200000) {
            incomeTax = (int) (50000 * 0.02 + 50000 * 0.06 + 50000 * 0.1 + (annualIncome - 150000) * 0.14);
        } else {
            incomeTax = (int) (50000 * 0.02 + 50000 * 0.06 + 50000 * 0.1 + 50000 * 0.14 + (annualIncome - 200000) * 0.17);
        }

        return incomeTax;
    }

}