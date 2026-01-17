package Stream;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Unary_Binary_Operator {
    public static void main(String[] args) {
        Function<Integer, Integer> twice = x -> 2 * x;

        // UnaryOperator -> Extends Function Interface (No need for return type if same as input)
        UnaryOperator<Integer> dual = x -> 2 * x;
        System.out.println(dual.apply(2));

        // BinaryOperator -> Extends Function Interface (Both arguments and return type are same)
        BinaryOperator<Integer> sum = (x, y) -> x + y;
        System.out.println(sum.apply(2, 3));
    }
}