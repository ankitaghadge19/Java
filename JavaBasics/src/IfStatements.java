public class IfStatements {
    static void main() {
        int income = 200_000;
        boolean hasHighIncome = false;
        if(income > 100_000){
            hasHighIncome = true;
        }
        
        // Simplifying if statements
        hasHighIncome = (income > 100_000);
    }
}