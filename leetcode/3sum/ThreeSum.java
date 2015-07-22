import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int right = nums.length -1;
        int i, j, k, sum;
        for (i = 0; i < right - 1; i++) {
            if (nums[i] > 0) break;

            j = i+1; k = right;

            while (j < k && nums[k] >= 0) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    List<Integer> triplet = new ArrayList<Integer>(3);
                    // System.out.println(nums[i] + ", " + nums[j] + ", " + nums[k]);
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    result.add(triplet);
                    if (nums[j] != nums[k]) {
                        j++;
                        k--;
                    } else {
                        break; // skip same number
                    }
                }
            }

            while (i < right && nums[i] == nums[i+1]) {
                i++; // skip same number
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum sol = new ThreeSum();

        int[][] nums = {
            {1}, {-1, 1}, {-1, 1, 2}, // no such triple
            {-1, -1, 2},
            {-1, 0, 1, 2, -1, 4},
            {-1, 0, 1, 2, -1, -4},
            {0, 0, 0, 0, 0}, // duplicate number
            {-2, -1, 0, 1, 2},
            {-2, -1, 0, 1, 1, 2},
        };
        int[] results = {
            0, 0, 0, // no such triple
            1,
            2,
            2,
            1, // duplicate number
            2,
            3,
        };
        int count = results.length;
        int failed = 0;
        List<List<Integer>> result;
        for (int i = 0; i < count; i++) {
            result = sol.threeSum(nums[i]);
            if (result.size() != results[i]) {
                failed++;
                System.out.println("Test: " + Arrays.toString(nums[i]) + ", expect " + results[i] + " triplets, while returnd " + result.size() + " triplets.");
            }
        }
        System.out.println("Test " + count + " cases: " + (count-failed) + " success, " + failed + " failed.");
    }
}
