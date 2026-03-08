public class MathClass {
    static void main() {
        // .round() -> If decimal < .5, it floors
        //             If decimal >= .5, it ceils.
        int result1 = Math.round(1.1F);
        System.out.println(result1);

        // .ceil() -> Rounds up next highest value
        int result2 = (int) Math.ceil(1.1F);
        System.out.println(result2);

        // .floor() -> Rounds up next lowest value
        int result3 = (int) Math.floor(1.1F);
        System.out.println(result3);

        int result4 = Math.min(1, 2);
        int result5 = Math.max(1, 2);

        // .random() -> Returns double (0 - 1)
        double result6 = Math.random();
        System.out.println(result6);

        // For numbers in between 0 and 100
        int result7 = (int) (Math.random() * 100);
        System.out.println(result7);
    }
}
