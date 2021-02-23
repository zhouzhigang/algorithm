public class LongestPalindromicSubstring {
    /**
     * Find the Longest Palindromic Substring by checking from middle number one by one.
     * From middle(1 ~ len-1) to left and right, check if they are equal.
     * 
     * O(n^2) runtime, O(1) space.
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        // return origin string if length less than 2(exist and only exist one LPS)
        if (len <= 2) { return s; }
        int start = 0;
        int end = 0;
        // l , r pointers to left and right position(i as the middle)
        int l, r;
        for (int i = 0; i < len; i++) {
            l = i - 1;
            r = i + 1;
            // skip the checked substring(same with previous char)
            if (l >= 0 && s.charAt(l) == s.charAt(i)) { continue; }
            // extend the same characters
            while (r < len && s.charAt(i) == s.charAt(r)) {
                r++;
            } 
            // check if left equals right
            while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            // check if the longest(the final l,r should not include)
            if (r - l - 2 > end -start) {
                start = l + 1;
                end = r - 1;
            }
        }
        return s.substring(start, end+1);
    }

    public static void main(String args[]) {
        LongestPalindromicSubstring sol = new LongestPalindromicSubstring();

        String[] strs = {
            "", "a",
            "aa", "baa", "aab",
            "aaa", "baaa", "aaab",
            "aaaa", "baaaa", "aaaab",
            "aba", "caba", "abac",
            "abba", "cabba", "abbac",
            "babba", "cbabba", "babbac",
            "ababba", "cababba", "ababbac",
            "bbababba", "cbbababba", "bbababbac"
        };
        String[] results = {
            "", "a",
            "aa", "aa", "aa",
            "aaa", "aaa", "aaa",
            "aaaa", "aaaa", "aaaa",
            "aba", "aba", "aba",
            "abba", "abba", "abba",
            "abba", "abba", "abba",
            "abba", "abba", "abba",
            "bbababb", "bbababb", "bbababb"
        };
        int len = strs.length;
        int failed = 0;
        String result;
        for (int i = 0; i < len; i++) {
            result = sol.longestPalindrome(strs[i]);
            if (!result.equals(results[i])) {
                failed++;
                System.out.println("Test: " + strs[i] +", expect: " + results[i] + "; while returned: " + result);
            }
        }
        System.out.println("Test " + len + " cases: " + (len - failed) + " success, " + failed + " failed.");
    }
}
