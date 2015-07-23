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

    public static int removeDuplicates1(char[] chArr) {
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
     * compare with the new string to check if exist, if not exist, insert char
     * @param  chArr [description]
     * @return       [description]
     */
    public static int removeDuplicates2(char[] chArr) {
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

    public static void arrayToString(char[] array, int length) {
        for(int i = 0; i < length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char[] chArr = new char[]{'a','b','d','d','a','e',};
        System.out.println(chArr);

        int length = RemoveDuplicates.removeDuplicates2(chArr);
        System.out.println("new length: " + length);
        RemoveDuplicates.arrayToString(chArr, length);

    }
}
