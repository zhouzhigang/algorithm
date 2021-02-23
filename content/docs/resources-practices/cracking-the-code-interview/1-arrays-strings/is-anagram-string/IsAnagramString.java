import java.util.Arrays;

/**
 * Write a method to decide if two strings are anagrams or not.
 *
 * Questions:
 *  Sort the string and comparae one by one.
 *  Use sort method provided by java libary?
 *  Are characters case sensetive?
 */
public class IsAnagramString {

    public boolean isAnagramString1(char[] charArray1, char[] charArray2) {
        if(charArray1.length != charArray2.length) {
            return false;
        }
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        for(int i=0; i < charArray1.length; i++) {
            // Character.toLowerCase
            if(charArray1[i] != charArray2[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagramString2(char[] charArray1, char[] charArray2) {
        if(charArray1.length != charArray2.length) {
            return false;
        }
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        // Use String.valueOf or new String method to convert char[] to String
        return String.valueOf(charArray1).equals(String.valueOf(charArray2));
    }

    public boolean isAnagramString3(String str1, String str2) {
        // Use toCharArray method to convert String to char array
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return String.valueOf(charArray1).equals(String.valueOf(charArray2));
    }

    public static void main(String[] args) {
        IsAnagramString sol = new IsAnagramString();

        String[] strs = {
            "", "",
            "a", "a",
            "abcd", "dcab",
        };
        boolean[] results = {
            true,
            true,
            true,
        };
        int count = results.length;
        int failed = 0;
        boolean result;
        for (int i = 0; i < count; i++) {
            result = sol.isAnagramString3(strs[2*i], strs[2*i+1]);
            if (result != results[i]) {
                failed++;
                System.out.println("Test str1: " + strs[2*i] + ", str2: " + strs[2*i+1] + ", expect: " + results[i] + ", while returned: " + result);
            }
        }
        System.out.println("Test " + count + " cases: " + (count-failed) + " success, " + failed + " failed.");
    }

}
