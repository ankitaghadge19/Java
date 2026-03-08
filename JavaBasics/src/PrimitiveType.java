public class PrimitiveType {
    static void main() {
        byte age = 30;

        // _ is for readability, no effect on value
        int subscribersCount = 1_000_000;

        // Even though type is long java sees this value as integer
        // long revenue = 3_000_000_000;
        // Need to say explicitly (Suffix L)
        long revenue = 3_000_000_000L;

        System.out.println(subscribersCount);

        double price = 10.55;
        // Need to say explicitly (Suffix F)
        // float weight = 10.55;
        float weight = 10.55F;

        char letter = 'A';
        boolean isEven = true;
    }
}
