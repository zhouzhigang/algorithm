import java.util.Map;
import java.util.HashMap;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you can not use additional data structures?
 *
 * Questions:
 *  what about using hashMap or hashcode function?
 *  What's the characters endcoding? ASCII or Unicode?
 */
public class UniqueCharacters {

    /**
     * use Hashmap to determine if a string has duplicated characters.
     * Hashmap is an additional data structure.
     * @param  str string
     * @return is unique
     */
    public boolean isUniqueByHash(String str) {
        Map<Character,Integer> charmap = new HashMap<Character,Integer>();
        for(int i = 0; i< str.length(); i++) {
            Character key = str.charAt(i);
            Integer count = charmap.get(key);
            if(count != null) {
                System.out.println("Char at " + i + " is not unique: " + key);
                return false;
            } else {
                count = 0;
            }
            charmap.put(key, count+1);
        }
        return true;
    }

    /**
     * use Array to determine if a string has duplicated characters.
     * Char code encoding: ASCII(256)? Unicode(65535)?
     * @param  str string
     * @return is unique
     */
    public boolean isUniqueByArray(String str) {
        int[] charArray = new int[65535];
        for(int i = 0; i < str.length(); i++) {
            char key = str.charAt(i);
            int idx = key;
            int count = charArray[idx];
            if(count != 0) {
                System.out.println("Char at " + i + " is not unique: " + key);
                return false;
            }
            charArray[idx] = count + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        UniqueCharacters unique = new UniqueCharacters();

        String str = "abcded";
        System.out.println(unique.isUniqueByHash(str));
        System.out.println(unique.isUniqueByArray(str));

        str = "abc我de我d";
        System.out.println(unique.isUniqueByHash(str));
        System.out.println(unique.isUniqueByArray(str));
    }
}
