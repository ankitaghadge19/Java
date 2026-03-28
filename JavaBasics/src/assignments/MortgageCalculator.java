package assignments;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    static void main() {
        Scanner sc = new Scanner(System.in);
        final byte MONTHS_IN_YEAR = 12;

        double principal = readInput(sc, 1000, 10_00_000, "Principal (₹1k - ₹1M): ");

        double annualInterest = readInput(sc, 1, 30, "Rate of Interest(Annually): ");
        double monthlyInterest = annualInterest / 100 / MONTHS_IN_YEAR;

        double years = readInput(sc, 1, 30, "Period (Years): ");
        int noOfPayments = ((int) years) * MONTHS_IN_YEAR;

        // M = P [ i(1 + i)^n ] / [ (1 + i)^n – 1 ]
        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, noOfPayments))
                / (Math.pow(1 + monthlyInterest, noOfPayments) - 1);

        String formatedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + formatedMortgage);
    }

    // Common method to read parameters required to calculate Mortgage (Home Loan)
    private static double readInput(Scanner sc, double min, double max, String message){
        double finalValue = 0;
        while(true){
            System.out.print(message);
            // .nextDouble() -> throws error if provided String
            // .hasNextDouble() -> returns true if input is double else false
            if(sc.hasNextDouble()){
                double input = sc.nextDouble();
                if(input >= min && input <= max){
                    finalValue = input;
                    break;
                }
            }else{
                sc.next(); // clear invalid input from buffer
            }
            System.out.println("Error: Enter value between " + min + " and " +  max);
        }
        return finalValue;
    }
}
