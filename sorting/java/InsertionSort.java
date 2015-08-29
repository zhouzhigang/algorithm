import java.util.Arrays;

/**
 * Insertion Sort.
 */
public class InsertionSort {
    public static void sort(int[] a) {
        int i, j, curr;
        for (i = 1; i < a.length; i++) {
            curr = a[i];
            for (j = i; j >0 && curr < a[j-1]; j--) {
                a[j] = a[j - 1];
            }
            a[j] = curr;
        }
    }

    public static void sort(Comparable[] a) {
        int i, j;
        for (i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i-1]) < 0) {
                Comparable curr = a[i];
                for (j = i; j > 0 && curr.compareTo(a[j - 1]) < 0; j--) {
                    a[j] = a[j - 1];
                }
                a[j] = curr;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        System.out.println(Arrays.toString(arr));
        InsertionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
