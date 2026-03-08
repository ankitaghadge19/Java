import java.util.Arrays;

public class Array {
    static void main() {
        int[] numbers = new int[5];
        numbers[0] = 2;
        numbers[1] = 1;
        numbers[1] = 3;
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        String[] bankNames = {"HSBC BANK", "SBI BANK"};
        System.out.println(bankNames.length);

        for(String bankName : bankNames){
            System.out.println(bankName);
        }
        // Java arrays are fixed size cannot remove or add element but can update existing index values
    }
}
