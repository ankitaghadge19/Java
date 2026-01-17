package Stream;

import java.util.List;
import java.util.stream.Stream;

public class Stream_Intermediate_Operations {
    public static void main(String[] args) {
        List<String> names = List.of("El", "Mike", "Max", "Lucas", "Max");

        // 1. filter() -> (Predicate - Hold Condition)
        Stream<String> startsWithM = names.stream().filter(x -> x.startsWith("M"));
        System.out.println(startsWithM.count());

        // 2. map() -> Transform stream into another stream
        Stream<String> convertToUpperCase = names.stream().map(x -> x.toUpperCase());

        // 3. sorted()
        Stream<String> sortedNames = names.stream().sorted();
        Stream<String> sortUsingCustomComparator = names.stream().sorted((a, b) -> a.length() - b.length());

        // 4. distinct()
        long noOfUniqueNamesStartsWithM = names.stream().filter(x -> x.startsWith("M")).distinct().count();
        names.stream().filter(x -> x.startsWith("M")).distinct().forEach(x -> System.out.println(x));

        // 5. limit()
        Stream<Integer> oneToFifty = Stream.iterate(1, x -> x + 1).limit(50);

        // 6. skip()
        Stream<Integer> elevenToFifty = Stream.iterate(1, x -> x + 1).skip(10).limit(50);
        System.out.println(elevenToFifty.count());
    }
}