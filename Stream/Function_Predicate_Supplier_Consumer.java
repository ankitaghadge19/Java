package Stream;

import java.util.function.*;

public class Function_Predicate_Supplier_Consumer {

    public static void main(String[] args) {

        // Functional Interfaces
        Predicate<Integer> predicate = x -> x % 2 == 0;
        Function<Integer, Integer> function = x -> x * x;
        Consumer<Integer> consumer = x -> System.out.println(x);
        Supplier<Integer> supplier = () -> 10;

        if (predicate.test(supplier.get())) {
            consumer.accept(function.apply(supplier.get()));
        }
    }
}

