public class TernaryOperator {
    static void main() {
        int income = 100_000;
        String className = "Economy";
        if(income > 100_000){
            className = "First";
        }

        // Using ternary operator
        className = (income > 100_000) ? "First" : "Economy";
    }
}