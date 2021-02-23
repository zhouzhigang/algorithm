public class SubstringRotation {
    public boolean isSubstring(String s1, String s2) {
        return s2.indexOf(s1) >= 0 ? true : false;
    }

    public boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) { return false; }
        return isSubstring(s1, s2+s2);
    }

    public static void main(String[] args) {
        SubstringRotation sol = new SubstringRotation();

        String[] strs = {
            "ab", "a",
            "abc", "bca",
            "waterbottle", "erbottlewat",
        };
        boolean[] results = {
            false,
            true,
            true,
        };
        int count = results.length;
        int failed = 0;
        boolean result;
        for (int i = 0; i < count; i++) {
            result = sol.isRotation(strs[2*i], strs[2*i+1]);
            if (result != results[i]) {
                failed++;
                System.out.println("Test: " + strs[2*i] + " is rotation of " + strs[2*i+1] + ", expect: " + results[i] + ", while returned: " + result);
            }
        }
        System.out.println("Test " + count + " cases: " + (count - failed) + " success, " + failed + " failed.");
    }
}
