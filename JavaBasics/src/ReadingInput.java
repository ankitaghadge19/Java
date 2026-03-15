import java.util.Scanner;

public class ReadingInput {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Age: ");
        byte age = sc.nextByte();
        System.out.println("You age: " + age);

        // .next() -> Skips leading white spaces, new line or tabs
        //            Stop reading as soon as it sees space, new line or tab.
        System.out.print("Enter First Name: ");
        String firstName = sc.next();
        System.out.println("Your First Name: " + firstName);

        // .next() stops before new line and leaves it in buffer, while nextLine() stops after new line
        sc.nextLine();

        // .nextLine() -> Read everything until the end of the line
        System.out.print("Enter Full Name: ");
        String fullName = sc.nextLine();
        System.out.println("Your Full Name: " + fullName);
    }
}
