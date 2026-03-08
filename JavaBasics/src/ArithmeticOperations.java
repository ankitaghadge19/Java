public class ArithmeticOperations {
    static void main() {
        int result1 = 10 / 3;
        System.out.println(result1);

        double result2 = (double) 10 / (double) 3;
        System.out.println(result2);

        int x = 1;
        int y = x++; // Stores value of x in y then increment x by 1
        System.out.println("x : " + x);
        System.out.println("y : " + y);

        int p = 1;
        int q = ++p;
        System.out.println("p : " + p);
        System.out.println("q : " + q);

        int s = 1;
        s = s + 2; // similar to (s += 2 )
        System.out.println("s : " + s);
    }
}
