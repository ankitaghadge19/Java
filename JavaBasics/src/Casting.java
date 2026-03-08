public class Casting {
    static void main() {
        // Implicit casting
        // byte > short > int > long > double > float
        int x = 3;
        double y = 1.1 + x;
        System.out.println(y);

        // Explicit casting
        double m = 2.1;
        int n = (int) m + 2;
        System.out.println(n);

        String accountLength = "9";
        int len = Integer.parseInt(accountLength);
        System.out.println(len);
    }
}
