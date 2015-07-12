public class StringToIntegerAtoi {
    public int myAtoi(String str) {
        if (str == null || str == "") { return 0; }
        int len = str.length();
        int res = 0; // result
        boolean isNegtive = false;
        int base = 10; // should we consider base 2, 8 and 16?
        int i = 0;
        int maxLen = 9; // used for check overflow
        // skip white space: isWhitespace, isSpace, isSpaceChar?
        while(i < len && Character.isWhitespace(str.charAt(i))) {
            i++;
        }
        if (i == len) { return 0; }
        // check if has positive or negtive symbol
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            if (str.charAt(i) == '-') {
                isNegtive = true;
            }
            i++;
        }
        // calculate int value
        while (maxLen > 0 && i < len && Character.isDigit(str.charAt(i))) {
            res = res * base + (str.charAt(i) - '0');
            i++;
            maxLen--;
        }
        // check overflow conditon
        while (i < len && Character.isDigit(str.charAt(i))) {
            int ch = str.charAt(i) - '0';
            if (isNegtive) {
                if (-res < (Integer.MIN_VALUE + ch) / base) {
                    return Integer.MIN_VALUE;
                }
            } else {
                if (res > (Integer.MAX_VALUE - ch) / base) {
                    return Integer.MAX_VALUE;
                }
            }
            res = res * base + ch;
            i++;
        }
        return isNegtive ? -res : res;
    }
    
    public static void main(String args[]) {
        StringToIntegerAtoi sol = new StringToIntegerAtoi();

        String[] strs = {
            "", "   ", // only contains space
            "123", "+123", "-123", // with positive and negtive symbol
            "-+123", "+-123", "--123", // with multiple +/- symbol
            "  123 ", "-12 3", " +123  ", // with space
            "123junk", "123abcdfg", // with junk character
            "2147483648", "-2147483649", // overflow
            "2147483647", "-2147483647", // not overflow
            "21474836300", "-21474836300" // another overflow
        };
        int[] results = {
            0, 0, // only space
            123, 123, -123, // with negtive symbol
            0, 0, 0, // with mutiple +/- symbol
            123, -12, 123, // skip prefix white space
            123, 123, // ignore junk letter
            2147483647, -2147483648, // overflow
            2147483647, -2147483647, // not overflow
            2147483647, -2147483648 //overflow
        };
        int count = strs.length;
        int failed = 0;
        int result;
        for (int i = 0; i < count; i++) {
            result = sol.myAtoi(strs[i]);
            if (result != results[i]) {
                failed++;
                System.out.println("Test: " + strs[i] + ", expect: " + results[i] + ", while returned: " + result);
            }
        }
        System.out.println("Test " + count + " cases: " + (count - failed) + " success, " + failed + " failed.");
    }
}

