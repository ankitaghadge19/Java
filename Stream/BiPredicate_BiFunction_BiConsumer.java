package Stream;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiPredicate_BiFunction_BiConsumer {

    public static void main(String[] args) {

        // BiPredicate
        BiPredicate<Integer, Integer> isSumEven =
                (x, y) -> (x + y) % 2 == 0;
        System.out.println(isSumEven.test(2, 4));

        // BiConsumer
        BiConsumer<String, Integer> printNameAge =
                (x, y) -> {
                    System.out.println("Name: " + x + ", Age: " + y);
                };
        printNameAge.accept("Ankita", 24);

        // BiFunction
        BiFunction<String, String, Integer> sumOfLenOfTwoStrings =
                (x, y) -> x.length() + y.length();
        System.out.println(sumOfLenOfTwoStrings.apply("Tom", "Jerry"));
    }
}
