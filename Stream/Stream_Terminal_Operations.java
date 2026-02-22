package Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream_Terminal_Operations extends Parallel_Streams {
        public static void main(String[] args) {
                List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

                // 1. collect() -> Mutable List
                System.out.println(nums.stream().skip(0).collect(Collectors.toList()));
                List<Integer> mutableNumsList = nums.stream().collect(Collectors.toList());
                mutableNumsList.add(4);
                // Java 16 onwards: nums.stream().skip(0).toList();

                // .toList()
                List<Integer> immutableNumsList = nums.stream().toList();
                // immutableNumsList.add(5); // UnsupportedOperationException

                // 2. forEach() -> (Stateless Operations)
                nums.stream().forEach(x -> System.out.println(x));
                nums.forEach(System.out::println); // Method Referencing

                // 3. forEachOrdered()
                System.out.println("Print factorial values using forEach(): ");
                nums.parallelStream()
                                .map(Parallel_Streams::factorial)
                                .forEach(x -> System.out.println(x));

                System.out.println("Print factorial values using forEachOrdered(): ");
                nums.parallelStream()
                                .map(x -> Parallel_Streams.factorial(x))
                                .forEachOrdered(x -> System.out.println(x));

                List<Long> factorials = nums.parallelStream()
                                .map(x -> Parallel_Streams.factorial(x))
                                .toList();
                System.out.println("Print factorials using .toList(): " + factorials); // .toList() -> Maintains Order

                // 4. reduce() -> Combines elements to produce a single result (Stateful Operations)
                Optional<Integer> sumOfAllNums = nums.stream().reduce((a, b) -> a + b);
                // Optional<Integer> sumOfAllNums = nums.stream().reduce(Integer::sum);
                System.out.println(sumOfAllNums.get());

                // 5. count() -> (Stateful Operations)
                System.out.println(nums.stream().filter(x -> x % 2 == 0).count());
                System.out.println(nums.stream().filter(x -> x % 2 == 0).findAny());

                // 6. anyMatch(), allMatch(), noneMatch() -> (Stateless Operations)
                boolean isAnyEvenNum = nums.stream().anyMatch(x -> x % 2 == 0); // Atleast one true
                boolean isAllNumGreaterThanZero = nums.stream().allMatch(x -> x > 0); // All true
                boolean isAnyNumLessThanZero = nums.stream().noneMatch(x -> x < 0); // None true

                // 7. findFirst() / findAny() -> (Stateless Operations)
                System.out.println(nums.stream().findFirst().get());
                System.out.println(nums.stream().findAny().get());

                // 8. toArray()
                String lengths = "2, 4";
                // split() -> Returns String[]
                // Arrays.stream(String[])
                List<Integer> lengthList = Arrays.stream(lengths.split(","))
                .peek(x -> System.out.println("After split(): " + x + " | type = " + x.getClass().getName()))
                                .map(x -> x.trim()) // object -> object
                .peek(x -> System.out.println("After trim(): " + x + " | type = " + x.getClass().getName()))
                                .map(x -> Integer.parseInt(x)) // object -> object
                .peek(x -> System.out.println("After parseInt(): " + x + " | type = " + x.getClass().getName()))
                                .toList(); // object -> object
                System.out.println(lengthList.stream().count());

                int[] lengthArray = Arrays.stream(lengths.split(","))
                                .map(x -> x.trim()) // object -> object
                                .mapToInt(x -> Integer.parseInt(x)) // object -> int
                                .toArray(); // int[]
                System.out.println(lengthArray.length);

                // -> toCharArray()
                String pattern = "abcab";
                char[] chars = pattern.toCharArray();

                // 9. max()
                int maxNum1 = nums.stream().max((a, b) -> a - b).get();
                int maxNum2 = nums.stream().max(Integer::compareTo).get();
                System.out.println("Max: " + maxNum1);

                // 10. min()
                int minNum1 = nums.stream().min(Comparator.naturalOrder()).get();
                int minNum2 = nums.stream().max((a, b) -> b - a).get();
                System.out.println("Min1: " + minNum1);
                System.out.println("Min2: " + minNum2);

                // Note: Stream cannot be resued after terminal operation has been called
                List<String> names = List.of("Max", "Mike", "El");
                Stream<String> namesStream = names.stream().filter(x -> x.startsWith("M"));
                System.out.println(namesStream.toList());
                // List<String> uppercaseNames = namesStream.map(x -> x.toUpperCase()).toList();
                // // IllegalStateException: stream has already been operated upon or closed
        }
}