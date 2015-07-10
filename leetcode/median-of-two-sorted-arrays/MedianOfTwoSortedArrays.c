#include <stdio.h>

/**
 * find the first and possible second number according position mm and mn.
 * always assume that `nums1[mm] <= nums2[mn]`(the `>` condition is the same logic, we can call it by swap the parameters)
 */
double getMedian(int* nums1, int mm, int m, int* nums2, int mn, int n) {
    double median = 0;
    int second = 0;

    int hasSecond = ((m+n) % 2 == 0);

    // nums1[mm] <= nums2[mn]
    if (mm < m) {
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
 * Median of Two Sorted Arrays.
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 */
double findMedianSortedArrays(int* nums1, int nums1Size, int* nums2, int nums2Size) {
    // size of each array
    int m = nums1Size - 1;
    int n = nums2Size - 1;
    // low, high, and middel position
    int lm = 0, hm = m, mm = (lm + hm) / 2;
    int ln = 0, hn = n, mn = (ln + hn) / 2;

    // special condition
    if (m <= 0 || n <= 0) {
        if (m < 0 && n < 0) { // both are 0
            return 0;
        } else if (m < 0) { // nums1 is empty
            return (n % 2 != 0) ? ((double)nums2[mn] + nums2[mn+1]) / 2 : nums2[mn];
        } else if (n < 0) { // nums2 is empty
            return (m % 2 != 0) ? ((double)nums1[mm] + nums1[mm+1]) / 2 : nums1[mm];
        } else if (m == 0 && n == 0) {
            return ((double)nums1[0] + nums2[0]) / 2;
        }
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
    // fix some offset(in most condition, offset are 0, 1, 2, so the backward or forward won't take two much time)
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

    // call getMedian to get the result
    if (nums1[mm] > nums2[mn]) {
        return getMedian(nums2, mn, n, nums1, mm, m);
    }
    return getMedian(nums1, mm, m, nums2, mn, n);
}

/**
 * Test function.
 */
void testMedian(int* nums1, int nums1Size, int* nums2, int nums2Size, double expected) {
    double median = findMedianSortedArrays(nums1, nums1Size, nums2, nums2Size);
    if (median - expected >= 0.001 || expected - median >= 0.001) {
    	printf("median: %f; expected: %f\n", median, expected);
    }
}

int main(int argc, char** argv) {
    int nums1[] = {1, 5, 6};
    int nums2[] = {2, 3, 4, 7, 8, 9, 10};

    int n1 = sizeof(nums1)/sizeof(nums1[0]);
    int n2 = sizeof(nums2)/sizeof(nums2[0]);

    testMedian(nums1, n1, nums2, n2, 5.5);
    testMedian(nums2, n2, nums1, n1, 5.5);
    return 0;
}
