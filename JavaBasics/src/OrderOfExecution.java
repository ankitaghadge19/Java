public class OrderOfExecution {
    static void main() {
        // Order:
        // ()
        // * /
        // + -
        // * / or + - -> Left to right
        int x = 10 + 3 * 2;
        int y = (10 + 3) * 2;
    }
}
