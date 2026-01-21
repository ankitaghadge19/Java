package Stream;

public class Lambda_Expression {
    public static void main(String[] args) {
        // Traditional way
        Addition add = new Addition();
        int addRes = add.calculate(2, 3);
        System.out.println(addRes);

        // Lambda Expression
        // No need of parameter type, If single stmt then no need of return
        MathOperations sum = (int a, int b) -> {
            return a + b;
        };

        // sum1 is object that knows how to perform addition but instead of writing whole class Addition we define its behaviour 
        MathOperations sum1 = (a, b) -> a + b;
        int sumRes = sum1.calculate(3, 2);
        System.out.println(sumRes);

        MathOperations sub = (a, b) -> a - b;
        int subRes = sub.calculate(3, 2);
        System.out.println(subRes);
    }
}

class Addition implements MathOperations {
    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}

class Subtraction implements MathOperations {
    @Override
    public int calculate(int a, int b) {
        return a - b;
    }
}

@FunctionalInterface
interface MathOperations {
    int calculate(int a, int b);
}
