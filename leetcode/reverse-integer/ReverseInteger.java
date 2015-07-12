public class ReverseInteger {
    public int reverse(int x) {
        int res = 0;
        boolean isNegtive = x < 0 ? true : false;
        // leave last number to check overflow
        while (x/10 != 0) {
            res = 10 * res + x % 10;
            x /= 10;
        }
        int m = x % 10;
        // check overflow 
        if ((!isNegtive && res > (Integer.MAX_VALUE - m)/10) || (isNegtive && res < (Integer.MIN_VALUE - m)/10)) {
            return 0;
        }
        res = 10 * res + m;
        return res;
    }
    public static void main(String args[]) {
        ReverseInteger sol = new ReverseInteger();

        int[] nums = {
            0, -0, // zero
            10, -10, // end with zero
            123, -123, // normal condition
            1000000003, -1000000003, // overlow, and sign will change
            1534236469, // overflow but sign will not chang
            1463847412, -1463847412 // reverse between -2147483648 ~ 2147483647
        };
        int[] results = {
            0, 0, // zero
            1, -1, // no prefix zero
            321, -321, // normal condition
            0, 0, // return 0 when overflow
            0,
            2147483641, -2147483641
        };
        int count = nums.length;
        int failed = 0;
        int result;
        for (int i = 0; i < count; i++) {
            result = sol.reverse(nums[i]);
            if (result != results[i]) {
                failed++;
                System.out.println("Test: " + nums[i] + ", expect: " + results[i] + ", while returned: " + result);
            }
        }
        System.out.println("Test " + count + " cases: " + (count - failed) + " success, " + failed + " failed.");
    }
}
