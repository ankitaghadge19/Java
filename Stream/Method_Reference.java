package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Method_Reference {
    public static void main(String[] args) {
        List<String> strangers = List.of("El", "Max", "Nancy");
        
        // Traditional Lambda
        strangers.forEach(x -> System.out.println(x));
        // Method Reference (::) -> Use method without invoking
        strangers.forEach(System.out::println);

        // Constructor Reference
        List<String> employees = Arrays.asList("Mike", "Lucas");
        employees.stream().map(x -> new Employee(x)).collect(Collectors.toList());
        employees.stream().map(Employee::new).collect(Collectors.toList());
    }
}

class Employee {
    String name;
    Employee(String name) {
        this.name = name;
    }
}