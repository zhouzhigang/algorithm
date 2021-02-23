public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows <= 1) { return s; }
        int len = s.length();
        char[] result = new char[len]; // result string
        int k = 0; // index of the result char array
        int base = (numRows - 1) * 2; // used to calculate index
        for (int i = 0; i < numRows; i++) {
            int idx = i;
            int j = 0;
            while(idx < len) {
                result[k++] = s.charAt(idx);
                if (i == 0 || i == numRows - 1) {
                    idx = idx + base;
                } else {
                    j++;
                    // calculate the next index
                    idx = base * j - idx;
                }
            }
        }
        // new String or String.valueOf
        return new String(result);
    }
    public static void main(String args[]) {
        ZigZagConversion sol = new ZigZagConversion();

        String[] strs = {
            "PAYPALISHIRING", "ABCDEF",
            "0123456", "0123456789", "0123456789"
        };
        int[] rows = {
            3, 3,
            2, 3, 4
        };
        String[] results = {
            "PAHNAPLSIIGYIR", "AEBDFC",
            "0246135", "0481357926", "0615724839"
        };
        
        int len = strs.length;
        int failed = 0;
        String result;
        for (int i = 0; i < len; i++) {
            result = sol.convert(strs[i], rows[i]);
            if (!result.equals(results[i])) {
                failed++;
                System.out.println("Test: " + strs[i] + ", numRows: " + rows[i] +", expect: " + results[i] + ", while returned: " + result);
            }
        }
        System.out.println("Test " + len + " cases: " + (len - failed) + " success, " + failed + " failed.");
    }
}
