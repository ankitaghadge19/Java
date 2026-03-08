public class Variables {
    static void main() {
        // Value stored in stack
        // Create two different variables
        int n = 10;
        int m = n;
        // Autoboxing int -> Integer
        System.out.println(System.identityHashCode(n));
        System.out.println(System.identityHashCode(m));

        // Value stored in heap
        // Reference stored in stack
        // Creates one variable
        Integer a = 20;
        Integer b = a;
        a = 30;
        System.out.println(b);
        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(a));

        Integer u = 20;
        Integer v = 20;
        System.out.println(System.identityHashCode(u));
        System.out.println(System.identityHashCode(v));

        Integer x = new Integer(20); // Create new object
        Integer y = 20;
        System.out.println(x);
        System.out.println(System.identityHashCode(x));
        System.out.println(System.identityHashCode(y));

        // == Returns true if memory address are same
        System.out.println(u == v); // True (Same Address)
        System.out.println(x == y); // False (Diff Address)

        // .equals()
        System.out.println(x.equals(y));
    }
}
