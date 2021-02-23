#include <stdio.h>  // printf

/**
 * Two Pointers solution.
 * i pointer to left, and j pointer to right;
 * if i is the lower one, move i forward, else move j backword;
 * and use (j-i) as the max width.
 * O(n) runtime, O(1) space.
 */
int maxArea(int* height, int heightSize) {
    int max = 0; // max result
    int tmp; // tmp result
    int i = 0; // left index
    int j = heightSize - 1; // right index
    while (i < j) {
        if (height[i] < height[j]) {
            tmp = height[i]*(j-i);
            // height[i] is the lower one, and j is max right;
            // suppose there is another jj > j:
            // 1) if a[jj] < a[i], which means j is the max right for i, and we aready record the max value for jj
            // 2) if a[jj] > a[i], while j have move left, that means there must be a[ii] > a[jj], so the max must greater than currenet result;
            // so the max area form i is aleady recorded;
            // thus we can move i forward to find the next height.
            i++;
        } else {
            tmp = height[j]*(j-i);
            // the same reason with i++
            j--;
        }
        if (tmp > max) { max = tmp; }
    }
    return max;
}
int main(int argc, char const *argv[]) {

    int h1[] = {1, 2, 3, 4, 5};
    int h2[] = {1, 3, 5, 2, 4};
    int* heights[] = {h1, h2};
    int sizes[] = {5, 5};

    int results[] = {
        6,
        9
    };
    int count = sizeof(results)/sizeof(results[0]);
    int failed = 0;
    int result;
    int i;
    for (i = 0; i < count; i++) {
        result = maxArea(heights[i], sizes[i]);
        if (result != results[i]) {
            failed++;
            printf("Test: %d, expect: %d, while returned: %d\n", i,  results[i], result);
        }
    }
    printf("Test %d cases: %d success, %d failed\n.", count, (count - failed), failed);
    return 0;
}
