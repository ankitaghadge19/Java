package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Consumer_Functional_Interface {

    public static void main(String[] args) {

        Consumer<Integer> printInt = x -> System.out.println(x);
        printInt.accept(20);

        List<Integer> nums = Arrays.asList(1, 2, 3);

        Consumer<List<Integer>> printListOfInt = x -> {
            for (int i : x) {
                System.out.println(i);
            }
        };

        printListOfInt.accept(nums);
    }
}
