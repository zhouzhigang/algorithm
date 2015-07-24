/**
 * Write a method to replace all spaces in a string with '%20'
 *
 *
 * Questions:
 *  Can I use a new Array or just use the old char array?
 */
public class ReplaceSpace {
    public char[] replaceSpace(char[] charArr) {
        int length = charArr.length;
        // count space to get the new length
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (charArr[i] == ' ') {
                count++;
            }
        }
        char[] replacedCharArr = new char[length + count*2];
        int idx = 0;
        for(int i = 0 ; i < length; i++) {
            if(charArr[i] == ' ') {
                replacedCharArr[i + idx*2] = '%';
                replacedCharArr[i + idx*2 + 1] = '2';
                replacedCharArr[i + idx*2 + 2] = '0';
                idx++;
            } else {
                replacedCharArr[i + idx*2] = charArr[i];
            }
        }
        return replacedCharArr;
    }

    public static void main(String[] args) {
        ReplaceSpace sol = new ReplaceSpace();

        String[] strs = {
            "", // empty
            "  ", // all space
            "a ", // letter + space
            " a", // space + letter
            "abd d  ae ",
        };
        String[] results = {
            "", // empty
            "%20%20", // all space
            "a%20", // letter + space
            "%20a", // space + letter
            "abd%20d%20%20ae%20"
        };

        int count = strs.length;
        int failed = 0;
        String result;
        for (int i = 0; i < count; i++) {
            result = String.valueOf(sol.replaceSpace(strs[i].toCharArray()));
            if (!result.equals(results[i])) {
                failed++;
                System.out.println("Test: " + strs[i] + ", expect: " + results[i] + ", while returnd: " + result);
            }
        }
        System.out.println("Test " + count + " cases: " + (count-failed) + " success, " + failed + " failed.");
    }
}
