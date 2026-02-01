package Stream;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Stream_Terminal_Operations {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3);

        // 1. collect() -> Mutable List
        System.out.println(nums.stream().skip(0).collect(Collectors.toList()));
        List<Integer> mutableNumsList = nums.stream().collect(Collectors.toList());
        mutableNumsList.add(4);
        // Java 16 onwards: nums.stream().skip(0).toList();

        // .toList()
        List<Integer> immutableNumsList = nums.stream().toList();
        immutableNumsList.add(5); // UnsupportedOperationException

        // 2. forEach() -> (Stateless Operations) 
        nums.stream().forEach(x -> System.out.println(x));
        nums.forEach(System.out::println); // Method Referencing

        // 3. reduce() -> Combines elements to produce a single result (Stateful Operations) 
        Optional<Integer> sumOfAllNums = nums.stream().reduce((a, b) -> a + b);
        // Optional<Integer> sumOfAllNums = nums.stream().reduce(Integer::sum);
        System.out.println(sumOfAllNums.get());

        // 4. count() -> (Stateful Operations) 
        System.out.println(nums.stream().filter(x -> x % 2 == 0).count());
        System.out.println(nums.stream().filter(x -> x % 2 == 0).findAny());

        // 5. anyMatch(), allMatch(), noneMatch() -> (Stateless Operations) 
        boolean isAnyEvenNum = nums.stream().anyMatch(x -> x % 2 == 0);
        boolean isAllNumGreaterThanZero = nums.stream().allMatch(x -> x > 0);
        boolean isAnyNumLessThanZero = nums.stream().noneMatch(x -> x < 0);

        // 8. findFirst() / findAny() -> (Stateless Operations) 
        System.out.println(nums.stream().findFirst().get());
        System.out.println(nums.stream().findAny().get());
    }
}