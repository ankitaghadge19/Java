package Stream;

import java.lang.reflect.Field;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Collectors_Utility_Class {
        public static void main(String[] args) {

                List<String> names = List.of("Max", "Lucas", "El", "Mike");

                List<Integer> nums = List.of(1, 2, 3, 3, 4, 5);

                // Collecting to a List
                List<String> namesStartsWithA = names.stream()
                                .filter(x -> x.startsWith("M"))
                                .collect(Collectors.toList());
                System.out.println(namesStartsWithA);

                // Collecting to a Set (List -> Set)
                Set<Integer> numsSet = nums.stream().collect(Collectors.toSet());
                System.out.println(numsSet);

                // Collecting to a specified collection
                // List -> LinkedHashSet(Preseves Order + Remove Duplicates)
                List<String> rulesTriggered = List.of("PEaSHK0002", "PEaSHK0001", "PEaSHK0003", "PEaSHK0003",
                                "PEaSHK0004");
                Set<String> unOrderedUniqueRules = rulesTriggered.stream()
                                .collect(Collectors.toSet());
                System.out.println(unOrderedUniqueRules); // Does not preserve order

                Set<String> orderedUniqueRules = rulesTriggered.stream()
                                .collect(Collectors.toCollection(LinkedHashSet::new));
                System.out.println(orderedUniqueRules); // Preserve order

                // List -> Map
                List<ReturnCode> returnCodes = List.of(
                                new ReturnCode("1", "8001", "Test Description 1"),
                                new ReturnCode("2", "8002", "Test Description 2"),
                                new ReturnCode("3", "8003", "Test Description 3"));

                Map<String, ReturnCode> returnCodeMap = returnCodes.stream()
                                .collect(Collectors.toMap(
                                                rc -> rc.getId(),
                                                rc -> rc));
                System.out.println(returnCodeMap.keySet());

                // Joining Stream
                Map<String, String> paymentFields = new LinkedHashMap<>(
                                Map.of( // Immutable Map, Map.of() does not guarantee order
                                                "Field1", "HSBC",
                                                "Field2", "BANK"));
                String joinedString = paymentFields.values().stream()
                                .collect(Collectors.joining(" "));
                System.out.println(joinedString);

                // Statistical Summary (count, sum, min, average, max)
                IntSummaryStatistics stats = nums.stream().collect(Collectors.summarizingInt(x -> x));
                System.out.println("Count: " + stats.getCount());
                System.out.println("Sum: " + stats.getSum());
                System.out.println("Min: " + stats.getMin());
                System.out.println("Max: " + stats.getMax());
                System.out.println("Average: " + stats.getAverage());

                // Average
                OptionalDouble average1 = nums.stream().mapToInt(x -> x).average();
                Double average2 = nums.stream().collect(Collectors.averagingInt(x -> x));

                // Count
                Long count1 = nums.stream().collect(Collectors.counting());
                Long count2 = nums.stream().mapToInt(x -> x).count();

                // Sum
                Integer sum1 = nums.stream().collect(Collectors.summingInt(x -> x));
                Integer sum2 = nums.stream().mapToInt(x -> x).sum();

                // Max
                Optional<Integer> max1 = nums.stream().collect(Collectors.maxBy(Integer::compareTo));
                int max2 = nums.stream().mapToInt(x -> x).max().orElse(0);

                // Min
                Optional<Integer> min1 = nums.stream().collect(Collectors.minBy(Integer::compareTo));
                int min = nums.stream().mapToInt(x -> x).min().orElse(0);
        }
}
