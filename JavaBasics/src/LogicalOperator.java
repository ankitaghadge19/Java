public class LogicalOperator {
    static void main() {
        int temperature = 12;
        // Short-circuiting
        // In case of && when 1st condition is false then 2nd won't be evaluated as result will be false always
        boolean isWarm = temperature > 20 && temperature < 30;
        System.out.println(isWarm);

        boolean isActionPerformed = true;
        boolean isReturnCodeAttached = true;
        // In case of || when 1st condition is true then 2nd won't be evaluated as result will be true always
        boolean isRuleTriggered = isActionPerformed || isReturnCodeAttached;

        // Evaluation of expression -> Left to Right
    }
}
