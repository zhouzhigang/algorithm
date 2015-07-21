import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int right = nums.length -1;
        int i, j, sum;
        for (int k = 1; k < right; k++) {
            i = 0; j = right;
            while (i < k && k < j) {
                // a+b+c = 0  <=> a+c = -b
                sum = nums[i] + nums[j];
                if (sum > -nums[k]) {
                    j--;
                } else if (sum < -nums[k]) {
                    i++;
                } else {
                    List<Integer> triplet = new ArrayList<Integer>(3);
                    // System.out.println(nums[i] + ", " + nums[k] + ", " + nums[j]);
                    triplet.add(nums[i]);
                    triplet.add(nums[k]);
                    triplet.add(nums[j]);
                    result.add(triplet);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum sol = new ThreeSum();

        int[][] nums = {
            {-1, 0, 1, 2, -1, 4},
        };
        int[] results = {
            2
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
