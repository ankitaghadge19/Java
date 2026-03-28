import java.util.Scanner;

public class WhileLoop {
    static void main() {
        // while() loop is used when we dont know how many times we are gonna repeate something
        Scanner sc = new Scanner(System.in);
        String input = "";
        boolean flag = true;
        while(flag){
            System.out.print("Enter a number: ");
            input = sc.next().toLowerCase();

            if(input.equals("quit")){
                flag = false;
            }else if(!input.equals("pass")){
                // If input is not pass and quit it means it is number, so print it
                System.out.println(input);
            }
        }

        // do{} while{} is executed the least one
        String input1;
        do{
            System.out.print("Enter a number: ");
            input1 = sc.next().toLowerCase();

            if(!input1.equals("quit") && !input1.equals("pass")){
                System.out.println(input1);
            }
        }while(!input1.equals("quit"));
    }
}