/**
 * Write code to reverse a C-Style String
 * C-String means that “abcd” is represented as five characters, including the null character.
 *
 * Questions:
 *  How can I present C-Style String in Java?
 */
public class ReverseCString {

    public void reverseCString(char[] str) {
        int i = 0;
        int length = str.length - 1;
        while(i < length) {
            char temp;
            // swap `i`th and `(len-i)`th
            temp = str[i];
            str[i++] = str[length];
            str[length--] = temp;
        }
    }

    public static void main(String[] args) {
        ReverseCString reverseCString = new ReverseCString();

        char[] str = new char[]{'a','b','c','d','e'};
        System.out.println(str);
        reverseCString.reverseCString(str);
        System.out.println(str);
    }
}
