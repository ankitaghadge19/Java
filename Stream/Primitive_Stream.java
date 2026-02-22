package Stream;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Primitive_Stream {
    public static void main(String[] args) {
        Integer[] nums1 = { 1, 2, 3, 4, 5 };
        Stream<Integer> intStream1 = Arrays.stream(nums1);

        int[] nums2 = { 1, 2, 3, 4, 5 };
        IntStream intStream2 = Arrays.stream(nums2);

        IntStream.range(0, 6);

        IntStream randomValues = new Random().ints(5);
        // System.out.println(randomValues.sum());

        IntStream addOneToEachValue = randomValues.map(x -> (int) (x + 1));
        System.out.println("Add one to each value: " + addOneToEachValue.boxed().toList());
    }
}
