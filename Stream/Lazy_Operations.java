package Stream;

import java.util.List;
import java.util.stream.Stream;

public class Lazy_Operations {
    public static void main(String[] args) {
        List<String> names = List.of("El", "Mike", "Max", "Lucas", "Max");

        Stream<String> namesLengthGreaterThanThree = names.stream()
                .filter(name -> {
                    System.out.println("Filtering: " + name);
                    return name.length() > 3;
                }); // Stream is defined but not executed yet

        System.out.println("Before Terminal Operations");

        List<String> result = namesLengthGreaterThanThree.toList();

        System.out.println("After Terminal Operations");
        System.out.println(result);
    }
}
