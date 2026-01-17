package Stream.Examples;

import java.util.Arrays;
import java.util.List;

public class Count_Even_Nums {
    public static void main(String[] args) {
        // Sequence of elements
        // Support functional and Declarative programming
        // Parallel execution
        // Process collections

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);

        // Count even nums (Traditional Way)
        int count = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                count++;
            }
        }
        System.out.println(count);

        // Using Stream
        System.out.println(nums.stream().filter(x -> x % 2 == 0).count());
    }
}
