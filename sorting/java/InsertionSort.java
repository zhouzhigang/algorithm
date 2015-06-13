import java.util.Comparator;

/**
 * Insertion Sort.
 */
public class InsertionSort {
    public static void insertionSort(Comparable[] a) {
        int j;
        for (int i = 1; i < a.length; i++) {
            Comparable curr = a[i];
            
            for (j = i; j > 0; j--) {
                if (curr.compareTo(a[j - 1]) < 0) {
                    a[j] = a[j - 1];
                }
            }
            a[j] = curr;
        }
    }
}
