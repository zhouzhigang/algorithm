import java.util.HashMap;

/**
 * Given an array of integets, find two numbers such that they add up to a specific target number.
 */
public class TwoSum {

    /**
     * Hash map solution: using a hashmao to reduce the search time complexity .
     * The map's key is the number, and the value is the position which we need return.
     * O(n) runtime, O(n) space.
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++) {
            // check if `target - num[i]` in the map
            Integer j = map.get(target-nums[i]);
            if (j != null) {
                result[0] = j + 1;
                result[1] = i + 1;
                return result;
            }
            // put `num[i]` into the map
            map.put(nums[i], i);
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = new TwoSum().twoSum(numbers, target);
        System.out.println("index1=" + result[0] + ",index2=" + result[1]);
    }
}
