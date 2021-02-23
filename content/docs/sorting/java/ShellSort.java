import java.util.Arrays;

/**
 * Shell Sort.
 * Gap Insertion.
 */
public class ShellSort {

    public static void sort(int[] a) {
        int i, j, gap;
        int n = a.length;
        for (gap = n/2; gap > 0; gap /= 2) {
            // (jump)insertion sort
            for (i = gap; i < n; i++) {
                int temp = a[i];
                for (j = i; j > 0 && a[j-gap] > temp; j -= gap) {
                    a[j] = a[j-gap];
                }
                // j is the insetion position
                a[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        System.out.println(Arrays.toString(arr));
        ShellSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}

