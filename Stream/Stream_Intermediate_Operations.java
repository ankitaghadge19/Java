package Stream;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
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

                // 9. flatMap()
                // [rc1, [rc2, rc3]] -> [rc1, rc2, rc3]
                // Flaten elements into single stream (One Level)
                // Nested Collections Eg. List<List<String>>
                ReturnCode rCSelectedOnUI = new ReturnCode("1", "Code 1", "Description 1");

                ReturnCode rc1 = new ReturnCode("1", "Code 1", "Description 1");
                ReturnCode rc2 = new ReturnCode("2", "Code 2", "Description 2");
                ReturnCode rc3 = new ReturnCode("3", "Code 3", "Description 3");

                Map<String, LinkedHashSet<ReturnCode>> filedReturnCodeList = new HashMap<>();
                filedReturnCodeList.put("cdtr", new LinkedHashSet<>(List.of(rc1)));
                filedReturnCodeList.put("intrmy", new LinkedHashSet<>(List.of(rc2, rc3)));

                // Problem Statement: Return Code with ID = 1 applied to the payment?
                boolean matchFound = filedReturnCodeList.values()
                                .stream() // [ rc1, [rc2, rc3]]
                                .flatMap(x -> x.stream())
                                .anyMatch(rc -> rc.getId().equals(rCSelectedOnUI.getId()));
                System.out.println("Is ReturnCode already applied to payment: " + matchFound);

                // Multiple orders and each order has multiple items
                List<List<String>> orders = List.of(
                                List.of("Mouse", "Keyboard"),
                                List.of("Mic", "Pendrive"),
                                List.of("Pendrive", "Laptop Stand"));
                List<String> allItems = orders.stream()
                                .flatMap(x -> x.stream())
                                .toList();
                // Count requirement of particular item
                Long pdCount = orders.stream()
                                .flatMap(x -> x.stream())
                                .filter(x -> x.equals("Pendrive"))
                                .count();
                System.out.println("Pendrive count: " + pdCount);
        }
}