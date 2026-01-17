package Stream;

import java.util.function.Predicate;

public class Predicate_Functional_Interface {
    public static void main(String[] args) {
        Predicate<Integer> isEven = (x) -> x % 2 == 0;
        System.out.println(isEven.test(4));

        Predicate<String> isWordStartsWithA = x -> x.toLowerCase().startsWith("a");
        Predicate<String> isWordEndsWithA = x -> x.toLowerCase().endsWith("a");

        // .and combines two conditions into a new predicate
        Predicate<String> result = isWordStartsWithA.and(isWordEndsWithA);
        System.out.println(result.test("Ankita"));
    }
}
