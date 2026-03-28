public class ForAndForEachLoop {
    static void main() {
        String[] fruits = {"Apple", "Mango", "Orange"};
        for(int i = 0; i < fruits.length; i++){
            System.out.println(fruits[i]);
        }

        for(int i = fruits.length - 1; i >= 0; i--){
            System.out.println(fruits[i]);
        }

        // No access to index, no backward execution
        for(String fruit: fruits){
            System.out.println(fruit);
        }
    }
}