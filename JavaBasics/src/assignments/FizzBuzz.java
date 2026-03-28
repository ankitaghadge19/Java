package assignments;

import java.util.Scanner;

public class FizzBuzz {
    static void main() {
        // If number is divisible by 5 then print FIZZ
        // If number is divisible by 3 then print BUZZ
        // If number is divisible by 5 and 3 then print FIZZBUZZ
        // If number is not divisible by 5 or 3 then print number

        Scanner sc = new Scanner(System.in);
        System.out.print("Number: ");
        int n = sc.nextInt();

        if((n % 5 == 0) && (n % 3 == 0)){
            System.out.println("FizzBuzz");
        }else if(n % 3 == 0){
            System.out.println("Buzz");
        }else if(n % 5 == 0){
            System.out.println("Fuzz");
        }else{
            System.out.println(n);
        }

        // Another way
        if(n % 5 == 0){
            if(n % 3 == 0){
                System.out.println("FizzBuzz");
            }else{
                System.out.println("Fuzz");
            }
        }else if(n % 3 == 0){
            System.out.println("Buzz");
        }else{
            System.out.println(n);
        }
    }
}