import java.util.Set;
import java.util.HashSet;

public class  ZeroRowCol {
    public void setZeros(int[][] matrix) {
        int m = matrix.length;
        if (m <= 0) {
            return;
        }
        int n = matrix[0].length;
        int i, j;
        // find all zero elements(rows and cols)
        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> cols = new HashSet<Integer>();
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        // set related rows to zero
        for (Integer row : rows) {
            for (j = 0; j < n; j++) {
                matrix[row][j] = 0;
            }
        }
        // set related cols to zero
        for (Integer col : cols) {
            for (i = 0; i < m; i++) {
                matrix[i][col] = 0;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m <= 0) {
            System.out.println("empty matrix"); 
            return;
        }
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ZeroRowCol sol = new ZeroRowCol();
        
        int[][] matrix1 = {}; // empty
        int[][] matrix2 = {
            {1, 2, 0} // row = 1
        };
        int[][] matrix3 = {
            {1}, // col = 0
            {0},
        };
        int[][] matrix4 = {
            {1, 2, 3, 4, 5},
            {4, 5, 0, 2, 3},
            {0, 3, 5, 4, 1},
        };
        int[][][] matrixs = {matrix1, matrix2, matrix3, matrix4};
        int[][] matrix;
        int count = matrixs.length;
        for (int i = 0; i < count; i++) {
            matrix = matrixs[i];
            System.out.println("==== Before Set Zero ====");
            printMatrix(matrix);
            sol.setZeros(matrix);
            System.out.println("==== After Set Zero ====");
            printMatrix(matrix);
        }
    }
}
