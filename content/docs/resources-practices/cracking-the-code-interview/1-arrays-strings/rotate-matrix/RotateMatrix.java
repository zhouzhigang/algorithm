import java.util.Arrays;

public class RotateMatrix {
    public void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        int i, j;
        int k = n-1;
        int temp;
        for (i = 0; i < n/2; i++) {
            // inner square from i to k-i
            for (j = i; j < k-i; j++) {
                // save first element
                temp = matrix[i][j];
                // rotate related four elements, j' = i, i' = k -j
                matrix[i][j] = matrix[k-j][i];
                matrix[k-j][i] = matrix[k-i][k-j];
                matrix[k-i][k-j] = matrix[j][k-i];
                matrix[j][k-i] = temp;
            }
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = i*n+j;
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        RotateMatrix sol = new RotateMatrix();

        int[] sizes = {0, 1, 2, 4, 5};
        int[][] matrix;
        int count = sizes.length;
        for (int i = 0; i < count; i++) {
            matrix = generateMatrix(sizes[i]);
            System.out.println("==== Before Rotate ====");
            printMatrix(matrix);
            sol.rotateMatrix(matrix);
            System.out.println("==== After Rotate ====");
            printMatrix(matrix);
        }
    }
}
