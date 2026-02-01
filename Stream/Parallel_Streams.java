package Stream;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Parallel_Streams {
    public static void main(String[] args) {
        // Allowing multiple threads to process the parts of stream concurrently
        // Workload is distibuted across multiple threads
        // Use When: CPU-Intensive operations, Large data sets, Independent operations

        List<Integer> nums = Stream.iterate(1, x -> x + 1)
                .limit(2000)
                .toList();

        // List<Long> factorialList = nums.stream()
        //         .map(x -> factorial(x))
        //         .toList();

        // Eg. Calculate Factorial Of Numbers (Independent Operations)
        // 1. Using stream()
        Long startTime = System.currentTimeMillis();
        List<Long> factorialList = nums.stream()
                .map(Parallel_Streams::factorial)
                .toList();
        Long endTime = System.currentTimeMillis();
        System.out.println("Time taken by Squential Stream: " + (endTime - startTime) + "ms");

        // Using parallelStream() 
        startTime = System.currentTimeMillis();
        factorialList = nums.parallelStream()
                .map(x -> factorial(x))
                .toList();
        endTime = System.currentTimeMillis();
        System.out.println("Time taken by Parallel Stream: " + (endTime - startTime) + "ms");

// ******************************************************************************************************************************************* //

        List<Integer> oneToFiveNumsList = List.of(1, 2, 3, 4, 5);
        // Eg. Cumulative Sum (Dependent Operations) using stream()
        // [1, 2, 3, 4, 5] -> [1, 3, 6, 10, 15]
        // Variables in lambda should be final to ensure thread safety
        AtomicInteger sequentialSum = new AtomicInteger(0); // AtomicInteger: Reference does not change, only the value inside changes
        List<Integer> cumulativeSumUsingStream = oneToFiveNumsList.stream()
        .map(sequentialSum :: addAndGet)
                .toList();
        System.out.println("Cumulative Sum Using Sequential Stream: " + cumulativeSumUsingStream);
        

        // Eg. Cumulative Sum (Dependent Operations) using parallelStream()
        // [1, 2, 3, 4, 5] -> [1, 3, 6, 10, 15]
        AtomicInteger parallelSum = new AtomicInteger(0);
        List<Integer> cumulativeSumUsingParallelStream = oneToFiveNumsList.parallelStream()
        .map(x -> parallelSum.addAndGet(x))
                .toList();
        System.out.println("Cumulative Sum Using Parallel Stream: " + cumulativeSumUsingParallelStream);
    }

    private static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
}
