//Task 1 - Create a currency converter in java

import java.util.Scanner;

public class CurrencyConverter 
{

    // Exchange rate (hardcoded for simplicity, in a real application, this would be fetched from a service)
    private static final double USD_TO_INR_RATE = 83.76;

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter amount in USD to convert to INR: ");
        double amountInUSD = 0.0;

        // Validate and read user input
        while (true) 
        {
            try 
            {
                amountInUSD = Double.parseDouble(scanner.nextLine().trim());
                if (amountInUSD <= 0) 
                {
                    System.out.println("Please enter a positive amount.");
                    continue;
                }
                break; // Exit loop if input is valid
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        double amountInINR = convertUSDToINR(amountInUSD);

        System.out.printf("%.2f USD is equal to %.2f INR.%n", amountInUSD, amountInINR);

        scanner.close();
    }

    private static double convertUSDToINR(double amountInUSD) 
    {
        return amountInUSD * USD_TO_INR_RATE;
    }
}
