import java.util.Arrays;

public class ContainerWithMostWater {
    /**
     * Brute force solution.
     *
     * O(n^2) runtime, O(1) space.
     */
    public int maxArea_BF(int[] height) {
        int max = 0;
        int tmp = 0;
        int n = height.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                tmp = height[i] < height[j] ? height[i] : height[j]; //min
                tmp *= (j-i); // current area
                if (max < tmp) {
                    max = tmp;
                }
            }
        }
        return max;
    }

    /**
     * Two Pointers solution.
     * i pointer to left, and j pointer to right;
     * if i is the lower one, move i forward, else move j backword;
     * and use (j-i) as the max width.
     * O(n) runtime, O(1) space.
     */
    public int maxArea(int[] height) {
        int max = 0; // max result
        int tmp; // tmp result
        int i = 0; // left index
        int j = height.length - 1; // right index
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

    public static void main(String[] args) {
        ContainerWithMostWater sol = new ContainerWithMostWater();

        int[][] heights = {
            {1, 2, 3, 4, 5},
            {1, 3, 5, 2, 4}
        };

        int[] results = {
            6,
            9
        };
        int count = results.length;
        int failed = 0;
        int result;
        for (int i = 0; i < count; i++) {
            result = sol.maxArea(heights[i]);
            if (result != results[i]) {
                failed++;
                System.out.println("Test: " + Arrays.toString(heights[i]) + ", expect: " + results[i] + ", while returned: " + result);
            }
        }
        System.out.println("Test " + count + " cases: " + (count - failed) + " success, " + failed + " failed.");
    }
}
