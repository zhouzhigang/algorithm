import java.util.Arrays;

/**
 * Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer.
 *
 * NOTE:
 *  One or two additional variables are fine;
 *  An extra copy of the array is not .
 *  Write the test cases for this method.
 *
 * Questions:
 *  Use String or char[] to represent the string in java?
 *  Are these characters are sorted?
 *  Sort before remove duplicate?
 */
public class RemoveDuplicates {

    public int removeDuplicates1(char[] chArr) {
        int length = chArr.length;
        for(int i = 0; i < length-1; i++) {
            for(int j = i+1; j < length; j++) {
                if(chArr[i] == chArr[j]) {
                    for(int k = j; k < length-1; k++) {
                        chArr[k] = chArr[k+1];
                    }
                    chArr[--length] = ' ';
                }
            }
        }
        return length;
    }

    /**
     * Compare with the new string to check if exist, if not exist, insert char.
     */
    public int removeDuplicates2(char[] chArr) {
        if (chArr.length == 0) return 0;
        int length = 1;
        for(int i = 1; i < chArr.length; i++) {
            boolean exist = false;
            // check if current char(i) is exist in new string(0-length)
            for(int j = 0; j < length; j++) {
                if(chArr[i] == chArr[j]) {
                    exist = true;
                    break;
                }
            }
            if(!exist) {
                chArr[length++] = chArr[i];
            }
        }
        return length;
    }

    public static void main(String[] args) {
        RemoveDuplicates sol = new RemoveDuplicates();
        
        String[] strs = {
            "", // empty string
            "aaa", // all duplicate
            "abcd", // no duplicate
            "aaabbb", // continuous duplicates
            "ababab", // non-contiguous duplicates
        };

        int[] results = {
            0, // empty string
            1, // all duplicate
            4, // no duplicate
            2, // continuous duplicates
            2, // non-contiguous duplicates
        };

        int count = results.length;
        int failed = 0;
        int result;
        for (int i = 0; i < count; i++) {
            result = sol.removeDuplicates2(strs[i].toCharArray());
            if (result != results[i]) {
                failed++;
                System.out.println("Test: " + strs[i] + ", expect: " + results[i] + ", while returned: " + result);
            }
        }
        System.out.println("Test " + count + " cases: " + (count-failed) + " success, " + failed + " failed.");
    }
}
