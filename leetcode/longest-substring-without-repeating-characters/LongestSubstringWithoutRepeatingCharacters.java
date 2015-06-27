import java.util.Map;
import java.util.HashMap;

/**
 * Longest Substring Without Repeating Characters.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Hash map solution.
     * Use a hash map to dectect the duplicated character and index.
     */
    public static int lengthOfLongestSubstring(String s) {
        int len = 0;
        // use a map to store each char's index.
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char c;
        Integer pos;
        // last repeated position(start = lastPos + 1)
        int lastPos = -1;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            pos = map.get(c);
            if (pos != null && pos > lastPos) {
                // update next possible start position
                lastPos = pos;
            }
            if (i - lastPos > len) {
                len = i - lastPos;
            }
            // update the lastest position of c
            map.put(c, i);
        }
        return len;
    }

    /**
     * Array instead of hash map.
     */
    public static int lengthOfLongestSubstring_array(String s) {
        int len = 0;
        // use an array to replace hash map
        int[] map = new int[256];
        for (int i = 0 ; i < map.length; i ++) {
            map[i] = -1;
        }
        char c;
        Integer pos;
        int lastPos = 0;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            pos = map[c];
            if (pos != -1 && pos > lastPos) {
                // update next possible start position
                lastPos = pos + 1;
            }
            if (i - lastPos > len) {
                len = i - lastPos;
            }
            // update the lastest position of c
            map[c] = i;
        }
        System.out.println("len: " + len);
        return len;
    }
    public static void main(String[] args) {
        String[] testArray = {"abcabcab", "bbbbbbbb", "", "c", "abcd", "cdd", "abba", "pwwkew", "dvdf", "tmmzuxt", "uqinntq"};
        int[] expectedResult = {3, 1, 0, 1, 4, 2, 2, 3, 3, 5, 4};
        int len = 0;
        for (int i = 0; i < testArray.length; i++) {
            len = lengthOfLongestSubstring(testArray[i]);
            if (len == expectedResult[i]) {
                System.out.println("Success: " + len);
            } else {
                System.out.println("Failed: " + len + "; expected: " + expectedResult[i]);
            }
        }
    }
}
