package Stream.Examples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream_Examples {
        public static void main(String[] args) {
                // List<String> names = Arrays.asList("Max", "El", "Joyce", "Mike");
                List<String> names = List.of("Max", "El", "Joyce", "Mike");

                // Print Names
                System.out.println(names.stream().toList());
                names.stream().forEach(x -> System.out.println(x));

                // Filter and Collect Names with Length > 3
                System.out.println(names.stream().filter(x -> x.length() > 3).toList());
                System.out.println(names.stream().filter(x -> x.length() > 3).count());

                // Squaring and Soriting Numbers
                List<Integer> nums = List.of(1, 3, 5, 4);
                System.out.println(nums.stream().map(x -> x * x).sorted().toList());

                // Sum of all numbers
                System.out.println(nums.stream().reduce(0, (a, b) -> a + b));
                System.out.println(nums.stream().reduce(Integer::sum).get());

                // Find total sum of factorial values
                List<Integer> oneToFifty = Stream.iterate(0, x -> x + 1)
                                .limit(50)
                                .toList();
                long sum = oneToFifty.parallelStream()
                                .mapToLong(x -> factorial(x)) // Returns Stream <Long>
                                .sum();
                System.out.println("Total sum of factorials: " + sum);

                // Why .mapToLong() ?
                // Stream<T> does not have .sum()
                // T = Any reference (Object) type
                // If type is not specify then Java dont know how to sum objects (Eg. How to sum
                // Stream<String>)
                // So need to explicitly convert into numeric data type (IntStream, LongStream,
                // or DoubleStream)

                // Filter Bank Names which contains China
                List<String> bankNames = List.of("Agriculture Bank Of China", "Bank Of China", "HDFC Bank",
                                "HSBC Bank");
                System.out.println(bankNames.stream()
                                .map(x -> x.toUpperCase())
                                .filter(x -> x.contains("CHINA"))
                                .toList());

                // Counting occurances of characters
                String sentence = "Hello World";
                System.out.println(sentence.chars().filter(x -> x == 'l').count());

                // Counting each char occurrances
                Map<Character, Long> eachCharCount = sentence.chars()
                                .mapToObj(c -> (char) c)
                                .filter(c -> c != ' ')
                                .collect(Collectors.groupingBy(
                                                c -> c,
                                                Collectors.counting()));
                System.out.println("Each Char occurance: " + eachCharCount);
                // sentence.chars() -> Returns IntStream(ASCII Values)
                // .mapToObj(c -> (char) c) -> int to char (Stream<Character>)

                // Counting each Word occurrances
                Map<String, Long> eachWordCount = Arrays.stream(sentence.split(" "))
                                .collect(Collectors.groupingBy(
                                                x -> x,
                                                Collectors.counting()));
                System.out.println("Occurance of each Word: " + eachWordCount);

                // Partition Even and Odd occurrances
                Map<Boolean, List<Integer>> evenOddNumsList = nums.stream()
                                .collect(Collectors.partitioningBy(x -> x % 2 == 0));
                System.out.println("Even and Odd nums list: " + evenOddNumsList);

                // Sum map value
                Map<String, Integer> triggeredRulesMap = new HashMap<>();
                triggeredRulesMap.put("PEaSHK0001", 2);
                triggeredRulesMap.put("PEaSHK0002", 1);
                triggeredRulesMap.put("PEaSHK0003", 2);
                // Using .reduce()
                Optional<Integer> sumOfAllTriggeredRulesUsingReduce = triggeredRulesMap.values().stream()
                                .reduce(Integer::sum);
                // Using .collect()
                Integer sumOfAllTriggeredRulesUsingCollect = triggeredRulesMap.values().stream()
                                .collect(Collectors.summingInt(x -> x));
                System.out.println("Sum of All Triggered Rules: " + sumOfAllTriggeredRulesUsingReduce.get());

                // Create Map from List
                Map<String, Integer> bankLengthMap = bankNames.stream()
                                .collect(Collectors.toMap(x -> x.toLowerCase(), x -> x.length()));
                // .toMap(key, value)
                System.out.println("Map of Bank Name -> Length: " + bankLengthMap);

                // Find no. of occurances of Rules in list
                List<String> totalRulesTriggered = List.of("PEaSHK0001", "PEaSHK0002", "PEaSHK0001", "PEaSHK0003");
                // Using .groupingBy()
                Map<Object, Long> triggeredRulesCountUsingGrouping = totalRulesTriggered.stream()
                                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
                System.out.println(
                                "Each Triggered Rule Count using .groupingBy(): " + triggeredRulesCountUsingGrouping);
                // Using .toMap()
                Map<Object, Integer> triggeredRulesCountUsingMapTo = totalRulesTriggered.stream()
                                .collect(Collectors.toMap(k -> k, v -> 1, Integer::sum));
                System.out.println("Each Triggered Rule Count using .mapTo(): " + triggeredRulesCountUsingMapTo);
                // (oldV, newV) -> oldV + newV) = Merge Function

                // Sequence of elements
                // Support functional and Declarative programming
                // Parallel execution
                // Process collections

                // List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);

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

        private static long factorial(int n) {
                long result = 1;
                for (int i = 2; i <= n; i++) {
                        result = result * i;
                }
                return result;
        }
}
