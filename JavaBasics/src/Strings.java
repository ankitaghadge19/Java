public class Strings {
    static void main() {
        String bankName = "HSBC BAN@K";
        String cleanedBankName = bankName.replace("@", "");

        // s1, s2 have same value so they will be pointing same memory address inside pool
        String s1 = "hello";
        String s2 = "hello";
        // Forces java to create new object inside haep but outside pool
        String s3 = new String("hello");
        System.out.println(s1==s2);
        System.out.println(s1==s3);

        // Jva strings are immutable
        String country = "United";
        System.out.println("Hashcode of United: " + System.identityHashCode(country));
        country = country + " States"; // Creates new string does not append to previous value
        System.out.println("Hashcode of United States: " + System.identityHashCode(country));
    }
}
