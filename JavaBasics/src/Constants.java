public class Constants {
    // This variables should be declared inside class but outside method
    public static final int timeout = 4;

    public static void main() {
        // Cannot modify final value
        // Constants name should be capital
        final float PI = 3.14F;

        // public static final int timeout = 4; -> (Error)
    }
}
