package Stream;

import java.lang.reflect.Field;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
                paymentFields.put("field3", "Pune");
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
                System.out.println(max1.get());
                int max2 = nums.stream().mapToInt(x -> x).max().orElse(0);

                nums.stream().findFirst().get();

                // Min
                Optional<Integer> min1 = nums.stream().collect(Collectors.minBy(Integer::compareTo));
                int min = nums.stream().mapToInt(x -> x).min().orElse(0);

                // groupingBy()
                List<Employee> employees = List.of(
                                new Employee("Mike", "IT", 6000),
                                new Employee("Lucas", "IT", 3000),
                                new Employee("Nancy", "HR", 8000),
                                new Employee("Steve", "HR", 4000),
                                new Employee("Billy", "HR", 4000),
                                new Employee("Jane", "HR", 8000)

                );

                // Group Employess by Department
                Map<String, List<Employee>> deptWiseGroup = employees.stream()
                                .collect(Collectors.groupingBy(x -> x.getDepartment()));
                // Map<String, List<Employee>> deptWiseGroup = employees.stream()
                // .collect(Collectors.groupingBy(Employee::getDepartment));
                System.out.println("Department wise Group: " + deptWiseGroup);

                // Count Employees in each Department
                Map<String, Long> countByDept = employees.stream()
                                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
                System.out.println("Total Employees in each Department: " + countByDept);

                // Max Salary in each Department
                Map<String, Optional<Employee>> maxSalaryDeptWise = employees.stream()
                                .collect(Collectors.groupingBy(
                                                Employee::getDepartment,
                                                Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
                System.out.println("Highest Salary in each Department: " + maxSalaryDeptWise);
                // maxBy() returns Optional<Employee>

                // Min Salary each Department
                Map<String, Optional<Employee>> minSalaryEachDept = employees.stream()
                                .collect(Collectors.groupingBy(Employee::getDepartment,
                                                Collectors.minBy(Comparator.comparing(Employee::getSalary))));
                System.out.println("Min Salary in each Department: " + minSalaryEachDept);

                // All Employee names by Departments
                Map<String, String> namesByDept = employees.stream()
                                .collect(Collectors.groupingBy(
                                                Employee::getDepartment,
                                                Collectors.mapping(Employee::getName, Collectors.joining(", "))));
                System.out.println("Comma separated Names by Department: " + namesByDept);
                // .mapping() (Why?) -> By default Collectors collect whole employee object

                // Get only Names of Employee per Department
                Map<String, List<String>> listOfNamesByDept = employees.stream()
                                .collect(Collectors.groupingBy(Employee::getDepartment,
                                                Collectors.mapping(Employee::getName, Collectors.toList())));
                System.out.println("List of Names by Department: " + listOfNamesByDept);

                // Total Salary per Department
                Map<String, Double> totalSalaryPerDept = employees.stream()
                                .collect(Collectors.groupingBy(
                                                Employee::getDepartment,
                                                Collectors.summingDouble(Employee::getSalary)));
                System.out.println("Total Salary per Department: " + totalSalaryPerDept);

                // Average Salary in each Department
                Map<String, Double> avgSalaryEachDept = employees.stream()
                                .collect(Collectors.groupingBy(Employee::getDepartment,
                                                Collectors.averagingDouble(Employee::getSalary)));
                System.out.println("Avg Salary each Department: " + avgSalaryEachDept);

                // Department wise Employee whose Salary > 5000
                Map<String, Map<Boolean, List<Employee>>> deptWiseEmpSalaryGreaterThanFiveK1 = employees.stream()
                                .collect(Collectors.groupingBy(Employee::getDepartment,
                                                Collectors.partitioningBy(emp -> emp.getSalary() > 5000)));
                Map<String, List<Employee>> deptWiseEmpSalaryGreaterThanFiveK2 = employees.stream()
                                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors
                                                .filtering(emp -> emp.getSalary() > 5000, Collectors.toList())));
                System.out.println("Department wise Employee whose Salary greater than 5000 using .partitionBy(): "
                                + deptWiseEmpSalaryGreaterThanFiveK1);
                System.out.println("Department wise Employee whose Salary greater than 5000 using .filtering(): "
                                + deptWiseEmpSalaryGreaterThanFiveK2);

                // Group by Department then by Salary
                Map<String, Map<Double, List<Employee>>> sortedSalaryDeptWise = employees.stream()
                                .collect(Collectors.groupingBy(Employee::getDepartment,
                                                Collectors.groupingBy(Employee::getSalary)));
                System.out.println("Group by Department then by Salary: " + sortedSalaryDeptWise);

                // Group by Department then Sort by Salary using .sorted()
                Map<String, List<Employee>> groupWiseSortedSalary = employees.stream()
                                .sorted(Comparator.comparing(Employee::getSalary))
                                .collect(Collectors.groupingBy(Employee::getDepartment));
                System.out.println("Group wise Sorted Salary: " + groupWiseSortedSalary);

                List<String> banks = List.of("HSBC Bank", "CITI Bank", "SBI Bank", "COSMOS Bnak");

                // Partition Banks whose length < 10
                Map<Boolean, List<String>> banksLenLessThanThree = banks.stream()
                                .collect(Collectors.partitioningBy(x -> x.length() < 10));
                System.out.println("Banks Partition based on Length < 3: " + banksLenLessThanThree);

                // Banks in uppercase using .map()
                List<String> banksInUppercaseUsingMap = banks.stream().map(x -> x.toLowerCase()).toList();

                // Mapping and Collecting using Collectors()
                List<String> banksInUppercaseUsingMapping = banks.stream()
                                .collect(Collectors.mapping(x -> x.toUpperCase(), Collectors.toList()));

                Map<String, Set<String>> rulesAppliedTagWise = new HashMap<>();
                rulesAppliedTagWise.put("F52", new TreeSet<>(Set.of("HK0001", "HK0002")));
                rulesAppliedTagWise.put("F53", Set.of("HK0004", "HK0003"));
                rulesAppliedTagWise.put("F54", Set.of("HK0006", "HK0005"));

                // Make Group based on Country Code then Sort respective Rules
                List<String> totalRulesTriggered = List.of("HK0004", "HK0002", "HK0003", "AU0006", "AU0007");
                // Unsorted
                Map<String, Set<String>> totalRulesTriggeredUnsorted = totalRulesTriggered.stream()
                                .collect(Collectors.groupingBy(rule -> rule.substring(0, 2),
                                                Collectors.toSet()));
                System.out.println("Total Rules Triggered in Unsorted: " + totalRulesTriggeredUnsorted);
                // Sorted
                Map<String, Set<String>> totalRulesTriggeredSorted = totalRulesTriggered.stream()
                                .collect(Collectors.groupingBy(rule -> rule.substring(0, 2),
                                                Collectors.toCollection(TreeSet::new)));
                System.out.println("Total Rules Triggered in Sorted: " + totalRulesTriggeredSorted);
        }
}
