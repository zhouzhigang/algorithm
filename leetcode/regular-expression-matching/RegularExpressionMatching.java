public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) { return s.length() == 0; }

        if (p.length() > 1 && p.charAt(1) == '*') {
            while (true) {
                if (isMatch(s, p.substring(2))) {
                    return true;
                }
                if (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
                    s = s.substring(1);
                } else {
                    break;
                }
            }
        }

        if (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
            return isMatch(s.substring(1), p.substring(1));
        }

        return false;
    }
    public static void main(String[] args) {
        RegularExpressionMatching sol = new RegularExpressionMatching();

        String[] strs = {
            "", "", // empty
            "aa", "aa", // full match
            "aaa", "aaa",
            "aa", "a", // part match
            "aaa", "aa", 
            "aa", "a*", // full match with *
            "aa", ".*", // full match with .*
            "ab", ".*",
            "aab", "c*a*b*", // full match with extra c*
            "abcd", "d*", // part match with *
            "a", ".*..a*" // not match with extra .
        };
        boolean[] results = {
            true, // empty
            true, // full match
            true,
            false, // part match(false)
            false,
            true, // full match with *
            true, // full match with .*
            true,
            true, // full match with extra c*
            false, // part match with *
            false // not match with extra .
        };

        int count = results.length;
        int failed = 0;
        boolean result;
        for (int i = 0; i < count; i++) {
            result = sol.isMatch(strs[2*i], strs[2*i+1]);
            if (result != results[i]) {
                failed++;
                System.out.println("Test string: " + strs[2*i] + ", pattern: " + strs[2*i+1] + ", expect: " + results[i] + ", while returned: " + result);
            }
        }
    System.out.println("Test " + count + " cases: " + (count - failed) + " success, " + failed + " failed.");
    }
}
