public class Constants {
    // This variables should be declared inside class but outside method
    // Constants (Uppercase)
    public static final int TIMEOUT = 4;
    public static final String PREFIX = "gpe.";
    public static final String GLOBAL_ENTITY_MAP = PREFIX + "global_entity_map";
    public static final String ENTITY_MAP = PREFIX + "entity_map";

    public static void main() {
        // Cannot modify final value
        // Constants name should be capital
        final float PI = 3.14F;

        // public static final int timeout = 4; -> (Error)
    }
}
