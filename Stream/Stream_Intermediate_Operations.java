package Stream;

import java.util.List;
import java.util.stream.Stream;

public class Stream_Intermediate_Operations {
        public static void main(String[] args) {
                List<String> names = List.of("El", "Mike", "Max", "Lucas", "Max");

                // 1. filter() -> (Predicate - Hold Condition) (Stateless Opeartion)
                Stream<String> startsWithM = names.stream()
                                .filter(x -> x.startsWith("M"));
                System.out.println(startsWithM.count());

                // 2. map() -> Transform stream into another stream (Functional Interface) (Stateless Opeartion) 
                Stream<String> convertToUpperCase = names.stream()
                                .map(x -> x.toUpperCase());
                System.out.println(convertToUpperCase.toList());

                // 3. sorted() -> (Stateful Operations)
                Stream<String> sortedNames = names.stream().sorted();

                Stream<String> sortUsingCustomComparator = names.stream()
                                .sorted((a, b) -> a.length() - b.length());

                // 4. distinct() -> internally uses equals() and hashCode() (HashSet) (Stateful Operations) 
                long noOfUniqueNamesStartsWithM = names.stream()
                                .filter(x -> x.startsWith("M"))
                                .distinct()
                                .count();

                names.stream()
                        .filter(x -> x.startsWith("M"))
                        .distinct()
                        .forEach(x -> System.out.println(x));
                        
                names.stream()
                        .filter(x -> x.startsWith("M"))
                        .distinct()
                        .toList();

                // 5. limit() -> (Stateful Operations) 
                Stream<Integer> oneToFifty = Stream.iterate(1, x -> x + 1)
                                .limit(50);

                // 6. skip() -> (skip() based on count is Stateful Operations) 
                Stream<Integer> elevenToFifty = Stream.iterate(1, x -> x + 1)
                                .skip(10)
                                .limit(50);

                System.out.println(elevenToFifty.count());

                // 8. peek(), looging/debugging, consumer, stateless
                // peek() without any terminal operations does nothing
                // Check if bank name length is <= to 10

                List<String> bankNames = List.of("HSBC Bank", "CITI Bank", "COSMOS Bank", "SBI Bank");

                long filteredBankNames = bankNames.stream()
                                .filter(x -> x.length() <= 10)
                                .peek(x -> System.out.println(x))
                                .count();
                System.out.println(filteredBankNames);          
        }
}