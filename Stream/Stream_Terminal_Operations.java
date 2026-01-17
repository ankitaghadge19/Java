package Stream;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Stream_Terminal_Operations {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3);

        // 1. collect()
        System.out.println(nums.stream().skip(0).collect(Collectors.toList()));
        // Java 16 onwards: nums.stream().skip(0).toList();

        // 2. forEach()
        nums.stream().forEach(x -> System.out.println(x));
        nums.forEach(System.out::println);

        // 3. reduce() -> Combines elements to produce a single result
        Optional<Integer> sumOfAllNums = nums.stream().reduce((a, b) -> a + b);
        System.out.println(sumOfAllNums.get());

        // 4. count()
        System.out.println(nums.stream().filter(x -> x % 2 == 0).count());

        // 5. anyMatch(), allMatch(), noneMatch()
        boolean isAnyEvenNum = nums.stream().anyMatch(x -> x % 2 == 0);
        boolean isAllNumGreaterThanZero = nums.stream().allMatch(x -> x > 0);
        boolean isAnyNumLessThanZero = nums.stream().noneMatch(x -> x < 0);

        // 8. findFirst() / findAny()
        System.out.println(nums.stream().findFirst().get());
        System.out.println(nums.stream().findAny().get());
    }
}