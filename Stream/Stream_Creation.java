package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream_Creation {
    public static void main(String[] args) {
        //

        // 1. Using Collections
        List<Integer> nums = Arrays.asList(1, 2, 3);
        Stream<Integer> stream1 = nums.stream();

        // 2. Using Arrays
        String[] fruits = {"Apple", "Banana", "Mango"};
        Stream<String> stream2 = Arrays.stream(fruits);

        // 3. Using Stream.of()
        Stream<Integer> stream3 = Stream.of(1, 2, 3);

        // 4. Infinite Streams
        // generate() -> Sequence where each element does not depend on previous
        Stream<Integer> generate = Stream.generate(() -> 1).limit(10);
        System.out.println(generate.count());

        // iterate() -> Sequence where each element depends on previous
        List<Integer> OneToFiftyNums = Stream.iterate(0, x -> x + 1).limit(50).collect(Collectors.toList());
        System.out.println(OneToFiftyNums);
    }
}