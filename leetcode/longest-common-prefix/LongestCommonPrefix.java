public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        int minLen = strs[0].length();
        int i;
        for (i = 1 ; i < len; i++) {
            if (minLen > strs[i].length()) {
                minLen = strs[i].length();
            }
        }
        for (int j = 0; j < minLen; j++) {
            for (i = 1; i < len; i++) {
                if (strs[0].charAt(j) != strs[i].charAt(j)) {
                    return strs[0].substring(0, j);
                }
            }
        }
        return strs[0].substring(0, minLen);
    }

    public static void main(String[] args) {
        LongestCommonPrefix sol = new LongestCommonPrefix();

        String[][] strs = {
            {""}, // empty string
            {"abcd"}, // only one string
            {"a", "abcd", "acd", "abd"},
            {"abc", "abcd", "abd", "abde"},
            {"abc", "abd", "bcd"} // no common prefix
        };
        String[] results = {
            "", // empty string
            "abcd", // only one string
            "a",
            "ab",
            "" // no common prefix
        };
        int count = results.length;
        int failed = 0;
        String result;
        for (int i = 0; i < count; i++) {
            result = sol.longestCommonPrefix(strs[i]);
            if (!result.equals(results[i])) {
                failed++;
                System.out.println("Test: " + java.util.Arrays.toString(strs[i]) + ", expect: " + results[i] + ", while returned: " + result);
            }
        }
        System.out.println("Test " + count + " cases: " + (count-failed) + " success, " + failed + " failed.");
    }
}
            
