package Stream;

public class Lambda_Expression {

    public static void main(String[] args) {

        // Traditional way
        Addition add = new Addition();
        int addRes = add.calculate(2, 3);
        System.out.println(addRes);

        // Lambda Expression
        MathOperations sum = (a, b) -> a + b;
        int sumRes = sum.calculate(3, 2);
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
