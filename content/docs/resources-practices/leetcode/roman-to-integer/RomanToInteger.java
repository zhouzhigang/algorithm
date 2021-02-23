
public class RomanToInteger {
    public int romanToInt(String s) {
        int result = 0;
        int len = s.length();
        char ch;
        for(int i = 0; i < len; i++) {
            ch = s.charAt(i);
            if (ch == 'M') {
                result += 1000;
            } else if(ch == 'D') {
                result += 500;
            } else if (ch == 'C') {
                if (i+1 < len && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')) {
                    result -= 100;
                } else {
                    result += 100;
                }
            } else if (ch == 'L') {
                result += 50;
            } else if (ch == 'X') {
                if (i+1 < len && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')) {
                    result -= 10;
                } else {
                    result += 10;
                }
            } else if (ch == 'V') {
                result += 5;
            } else if (ch == 'I') {
                if (i+1 < len && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')) {
                    result -= 1;
                } else {
                    result += 1;
                }
            }
        }
        return result;
    }

    public static void main(String args[]) {
        RomanToInteger sol = new RomanToInteger();

        String[] strs = {
            "", "I", "III", "V", "IX", // 0 ~ 10
            "X", "XII", "XXVI", "XLIII", "L", "XCVIII", // 10 ~ 100
            "C", "CCXLVII", "DCCVII", "DCCCXC", // 100 ~ 1000
            "M", "MMCCCL", "MMMCDLVIII", "MMMCMXCIX" // 1000 ~ 3999
        };

        int[] results = {
            0, 1, 3, 5, 9, // 0 ~ 10
            10, 12, 26, 43, 50, 98, // 10 ~ 100
            100, 247, 707, 890, // 100 ~ 1000
            1000, 2350, 3458, 3999 // 1000 ~ 3999
        };

        int count = results.length;
        int failed = 0;
        int result;
        for (int i = 0; i < count; i++) {
            result = sol.romanToInt(strs[i]);
            if (result != results[i]) {
                failed++;
                System.out.println("Test: " + strs[i] + ", expect: " + results[i] + ", while returned: " + result);
            }
        }
        System.out.println("Test " + count + " cases: " + (count-failed) + " success, " + failed + " failed.");
    }
}
