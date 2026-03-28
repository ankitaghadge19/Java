public class SwitchCase {
    static void main() {
        String mapName = Constants.PREFIX + "global_entity_map";

        switch (mapName){
            case Constants.GLOBAL_ENTITY_MAP:
                System.out.println("It's GLOBAL_ENTITY_MAP");
                break;
            case Constants.ENTITY_MAP:
                System.out.println("It's ENTITY_MAP");
                break;
        }
    }
}