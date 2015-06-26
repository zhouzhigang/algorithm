import java.util.Map;
import java.util.HashMap;

/**
 * Longest Substring Without Repeating Characters.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Hash map solution.
     */
    public static int lengthOfLongestSubstring(String s) {
        int len = 0;
        // int start = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char c;
        Integer pos;
        int lastPos = 0;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            pos = map.get(c);
            if (pos != null && pos >= lastPos) {
                // update `len` when `pos > lastPos` and `i - pos > len`
                if (i - pos > len) {
                    // start = pos;
                    len = i - pos;
                }
                // update next possible start position
                lastPos = pos + 1;
            } else {
                if (i - lastPos >= len) {
                    // start = lastPos;
                    len++;
                }
            }
            // update the lastest position of c
            map.put(c, i);
        }
        System.out.println("len: " + len);
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
            if (pos != -1 && pos >= lastPos) {
                // update `len` when `pos > lastPos` and `i - pos > len`
                if (i - pos > len) {
                    len = i - pos;
                }
                // update next possible start position
                lastPos = pos + 1;
            } else {
                if (i - lastPos >= len) {
                    len++;
                }
            }
            // update the lastest position of c
            map[c] = i;
        }
        System.out.println("len: " + len);
        return len;
    }
    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcab"); // 3
        lengthOfLongestSubstring("bbbbbbbb"); // 1
        lengthOfLongestSubstring(""); // 0
        lengthOfLongestSubstring("c"); // 1
        lengthOfLongestSubstring("abcd"); // 4
        lengthOfLongestSubstring("cdd"); // 2
        lengthOfLongestSubstring("abba"); // 2
        lengthOfLongestSubstring("pwwkew"); //3
        lengthOfLongestSubstring("dvdf"); // 3
        lengthOfLongestSubstring("tmmzuxt"); // 5
        lengthOfLongestSubstring("uqinntq"); // 4
    }
}
