package Stream;

import java.util.function.Supplier;

public class Supplier_Functional_Interface {
    public static void main(String[] args) {
        Supplier<String> printWelcome = () -> "Welcome";
        System.out.println(printWelcome.get());
    }
}