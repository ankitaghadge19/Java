package Stream;

import java.util.function.Function;

public class Function_Functional_Interface {

    public static void main(String[] args) {

        Function<Integer, Integer> twice = x -> x * 2;
        Function<Integer, Integer> triple = x -> x * 3;

        // Parameterized function will be executed after firts one
        int result1 = twice.andThen(triple).apply(20); // (20 * 2) * 3
        System.out.println(result1); 

        // Parameterized function will be xecuted before firts one
        int result2 = twice.compose(triple).apply(20); // 20 * (2 * 3)
        System.out.println(result2);

        //If any function in the chain trows an exception:
        // 1. Execution stops at that function
        // 2. Remaining functions are not executed
        // 3. Exception is propagated to the caller

        // Returns its own argument
        Function<Integer, Integer> identity = Function.identity();
        int identityResult = identity.apply(1);
        System.out.println(identityResult);
    }
}

