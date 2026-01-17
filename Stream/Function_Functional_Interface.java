package Stream;

import java.util.function.Function;

public class Function_Functional_Interface {

    public static void main(String[] args) {

        Function<Integer, Integer> twice = x -> x * 2;
        Function<Integer, Integer> triple = x -> x * 3;

        int result = twice.compose(triple).apply(20); // 20 * (2 * 3)
        System.out.println(result);

        Function<Integer, Integer> identity = Function.identity();
        int identityResult = identity.apply(1);
        System.out.println(identityResult);
    }
}

