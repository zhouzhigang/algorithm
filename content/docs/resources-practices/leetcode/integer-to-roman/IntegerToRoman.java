public class IntegerToRoman {
    /**
     * Use 7 basic symbols.
     */
    public String intToRoman_1(int num) {
        StringBuilder sb = new StringBuilder();
        char[] basic = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int n = 4;
        int k = 1000;
        int h = 0;
        while (n != 0) {
            h = num / k;
            switch(h) {
                case 1:
                    sb.append(basic[2*n-2]); break;
                case 2:
                    sb.append(basic[2*n-2]).append(basic[2*n-2]); break;
                case 3:
                    sb.append(basic[2*n-2]).append(basic[2*n-2]).append(basic[2*n-2]); break;
                case 4:
                    sb.append(basic[2*n-2]).append(basic[2*n-1]); break;
                case 5:
                    sb.append(basic[2*n-1]); break;
                case 6:
                    sb.append(basic[2*n-1]).append(basic[2*n-2]); break;
                case 7:
                    sb.append(basic[2*n-1]).append(basic[2*n-2]).append(basic[2*n-2]); break;
                case 8:
                    sb.append(basic[2*n-1]).append(basic[2*n-2]).append(basic[2*n-2]).append(basic[2*n-2]); break;
                case 9:
                    sb.append(basic[2*n-2]).append(basic[2*n]); break;
                case 10:
                    sb.append(basic[2*n]); break;
                default:
                    break;
            }
            num = num - h * k;
            k /= 10;
            n--;
        }
        return sb.toString();
    }

    /**
     * Use space to save time.
     */
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        String[][] basic = {
            {"",  "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" },
            {"",  "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" },
            {"",  "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" },
            {"", "M", "MM", "MMM"}
        };
        int i = 3;
        int j = 0;
        int k = 1000;
        while (num != 0) {
            j = num / k;
            sb.append(basic[i][j]);
            num = num - j * k;
            k /= 10;
            i--;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        IntegerToRoman sol = new IntegerToRoman();

        int[] nums = {
            0, 1, 3, 5, 9, // 0 ~ 10
            10, 12, 26, 43, 50, 98, // 10 ~ 100
            100, 247, 707, 890, // 100 ~ 1000
            1000, 2350, 3458, 3999 // 1000 ~ 3999
        };

        String[] results = {
            "", "I", "III", "V", "IX", // 0 ~ 10
            "X", "XII", "XXVI", "XLIII", "L", "XCVIII", // 10 ~ 100
            "C", "CCXLVII", "DCCVII", "DCCCXC", // 100 ~ 1000
            "M", "MMCCCL", "MMMCDLVIII", "MMMCMXCIX"
        };

        int count = nums.length;
        int failed = 0;
        String result;
        for (int i = 0; i < count; i++) {
            result = sol.intToRoman(nums[i]);
            if (!result.equals(results[i])) {
                failed++;
                System.out.println("Test: " + nums[i] + ", expect: " + results[i] + ", while returned: " + result);
            }
        }
        System.out.println("Test " + count + " cases: " + (count-failed) + " success, " + failed + " failed.");
    }
}


