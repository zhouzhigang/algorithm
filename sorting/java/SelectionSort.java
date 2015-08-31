import java.util.Arrays;

/**
 * Selection Sort.
 */
public class SelectionSort {

    public static void sort(int[] a) {
        int i, j, k;
        int n = a.length;
        for (i = 0; i < n - 1; i++) {
            k = i;
            // find the min the unsorted sequence
            for (j = i + 1; j < n; j++) {
                if (a[j] < a[k]) {
                    k = j;
                }
            }
            swap(a, i, k);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        System.out.println(Arrays.toString(arr));
        SelectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}

