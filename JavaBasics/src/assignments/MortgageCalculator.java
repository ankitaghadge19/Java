package assignments;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    static void main() {
        Scanner sc = new Scanner(System.in);
        final byte MONTHS_IN_YEAR = 12;

        System.out.print("Principal: ");
        int principal = sc.nextInt();

        System.out.print("Rate of Interest(Annually): ");
        float annualInterest = sc.nextFloat();
        float monthlyInterest = annualInterest / 100 / MONTHS_IN_YEAR;


        System.out.print("Period (Years): " );
        byte years = sc.nextByte();
        int noOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, noOfPayments))
                / (Math.pow(1 + monthlyInterest, noOfPayments));

        String formatedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + formatedMortgage);
    }
}
