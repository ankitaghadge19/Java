package Stream.Examples;

import java.util.List;
import java.util.stream.Stream;

public class Stream_Examples {
    public static void main(String[] args) {
        // List<String> names = Arrays.asList("Max", "El", "Joyce", "Mike");
        List<String> names = List.of("Max", "El", "Joyce", "Mike");

        // Filter and Collect Names with Length > 3
        System.out.println(names.stream().filter(x -> x.length() > 3).toList());
        System.out.println(names.stream().filter(x -> x.length() > 3).count());

        // Squaring and Soriting Numbers
        List<Integer> nums = List.of(1, 3, 5, 4);
        System.out.println(nums.stream().map(x -> x * x).sorted().toList());

        // Sum of all numbers
        System.out.println(nums.stream().reduce(0, (a, b) -> a + b));
        System.out.println(nums.stream().reduce(Integer::sum).get());

        // Counting occurances of characters
        String sentence = "Hello World";
        System.out.println(sentence.chars().filter(x -> x == 'l').count());

        // Find cumulative sum of factorial values
        List<Integer> oneToFifty = Stream.iterate(0, x -> x + 1)
                .limit(50)
                .toList();
        long sum = oneToFifty.parallelStream()
                .mapToLong(x -> factorial(x))  // Returns Stream <Long>
                .sum();
        System.out.println(sum);
        

        // Why .mapToLong() ?
        // Stream<T> does not have .sum()
        // T = Any reference (Object) type
        // If type is not specify then Java dont know how to sum objects (Eg. How to sum Stream<String>)
        // So need to explicitly convert into numeric data type (IntStream, LongStream, or DoubleStream)
    }

    private static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
}
