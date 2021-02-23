import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // length of each array
        int m = nums1.length - 1;
        int n = nums2.length - 1;
        // low, high, and middel position
        int lm = 0, hm = m, mm = (lm + hm) / 2;
        int ln = 0, hn = n, mn = (ln + hn) / 2;

        // special condition
        if (m < 0 && n < 0) { // both are 0
            return 0;
        } else if (m < 0) { // nums1 is empty
            return (n % 2 != 0) ? ((double)nums2[mn] + nums2[mn+1]) / 2 : nums2[mn];
        } else if (n < 0) { // nums2 is empty
            return (m % 2 != 0) ? ((double)nums1[mm] + nums1[mm+1]) / 2 : nums1[mm];
        } else if (m == 0 && n == 0) {
            return ((double)nums1[0] + nums2[0]) / 2;
        }
        // both are not empty
        while (lm < hm || ln < hn) {
            if (nums1[mm] < nums2[mn]) {
                lm = mm + 1;
                hn = mn;
            } else if (nums1[mm] > nums2[mn]) {
                hm = mm;
                ln = mn + 1;
            } else {
                break;
            }
            mm = (lm + hm) / 2;
            mn = (ln + hn) / 2;
        }

        // k is the first median number position
        int k = (m + n + 1) / 2;
        // fix some offset
        int offset = k - (mm + mn) - 1;
        //backward
        while (offset < 0) {
            if (mn -1 < 0 || (mm > 0 && nums1[mm] > nums2[mn])) {
                mm--;
            } else {
                mn--;
            }
            offset++;
        }
        //forward
        while (offset > 0) {
            if (mm + 1 > m || (mn+1 <= n && nums1[mm] > nums2[mn])) {
                mn++;
            } else {
                mm++;
            }
            offset--;
        }

        if (nums1[mm] > nums2[mn]) {
            return getMedian(nums2, mn, nums1, mm);
        }
        return getMedian(nums1, mm, nums2, mn);
    }
    /**
     * Get the median by last position mm and mn.
     * Always assume that `nums1[mm] <= nums2[mn]`
     */
    private double getMedian(int[] nums1, int mm, int[] nums2, int mn) {
        double median = 0;
        int second = 0;
        int m = nums1.length - 1;
        int n = nums2.length - 1;

        boolean hasSecond = ((m+n) % 2 == 0);

        // nums1[mm] <= nums2[mn]
        if (mm < m) { // mm + 1 < m
            if (nums1[mm+1] < nums2[mn]) {
                median = nums1[mm+1];
                if (hasSecond) {
                    second = mm+2 <= m && nums1[mm+2] < nums2[mn] ? nums1[mm+2] : nums2[mn];
                }
            } else {
                median = nums2[mn];
                if (hasSecond) {
                    second = mn+1 > n || nums1[mm+1] < nums2[mn+1] ? nums1[mm+1] : nums2[mn+1];
                }
            }
        } else { // mm + 1 > m
            median = nums2[mn];
            if (hasSecond) {
                second = nums2[mn+1];
            }
        }
        return hasSecond ? (median + second) / 2 : median;
    }
    /**
     * Test function.
     */
    public static void main(String[] args) {
        MedianOfTwoSortedArrays sol = new MedianOfTwoSortedArrays();
        int[][] nums = {
            {}, {}, // both are empty
            {}, {1, 2}, // one is empty, the other is even
            {1, 2 ,3}, {}, // one is empty, the other is odd
            // one odd(1), one even
            {1}, {2, 3},
            {2}, {1, 3},
            {3}, {1, 2},
            // two odd
            {1}, {2, 3, 4},
            {2}, {1, 3, 4},
            {3}, {1, 2, 4},
            {4}, {1, 2, 3},
            // two even
            {1, 2}, {3, 4},
            {1, 3}, {2, 4},
            {1, 4}, {2, 3},
            // one even, one odd(more than 1)
            {1, 2}, {3, 4, 5},
            {1, 3}, {2, 4, 5},
            {1, 4}, {2, 3, 5},
            {1, 5}, {2, 3, 4},
            {2, 3}, {1, 4, 5},
            {2, 4}, {1, 3, 5},
            {2, 5}, {1, 3, 4},
            {3, 4}, {1, 2, 5},
            {3, 5}, {1, 2, 4},
            {4, 5}, {1, 2, 3}

        };
        double[] expects = {
            // special condition
            0, 1.5, 2,
            // one odd, one even
            2, 2, 2,
            // two odd
            2.5, 2.5, 2.5,
            // two even
            2.5, 2.5, 2.5,
            // one even, one odd(more than 1)
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3
        };
        int len = expects.length;
        double median;
        int failed = 0;
        for (int i = 0; i < len; i++) {
            median = sol.findMedianSortedArrays(nums[2*i], nums[2*i+1]);
            if (median - expects[i] >= 0.001 || median - expects[i] >= 0.001) {
                failed++;
                System.out.print(Arrays.toString(nums[2*i]));
                System.out.println(Arrays.toString(nums[2*i+1]));
                System.out.println("median: " + median + "; expected: " + expects[i]);
            }
        }
        System.out.println("Test " + len + " cases, " + (len-failed) + " success, " + failed + " failed.");
    }
}
