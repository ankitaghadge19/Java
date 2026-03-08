import java.util.Arrays;

public class MultiDimensionalArray {
    static void main() {
        int[][] matrix = new int[2][3]; // [Rows][Columns] -> 2 Rows, 3 Columns
        matrix[0][0] = 1;
        System.out.println(Arrays.deepToString(matrix));

        int[][] nums = {{1, 2, 3}, {4, 5, 6}};
    }
}
