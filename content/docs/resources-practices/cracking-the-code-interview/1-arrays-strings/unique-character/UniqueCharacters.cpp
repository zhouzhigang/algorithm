#include <iostream> // std::cout
#include <string>   // std::string
using namespace std;

class UniqueCharacters {
public:
    /**
     * Use bool array to determine if a string has duplicated characters.
     * O(n) runtime;
     * space depends on the char set(Alphabeta: 26; ASCII:256, Unicode: 65535)
     */
    bool isUniqueByArray(string str) {
        bool charArr[256];// default value is false, needn't initialize
        // memset(charArr, 0, sizeof(charArr);
        int len = str.length();
        int ch;
        for (int i = 0; i < len; i++) {
            ch = (int)str[i];
            if (charArr[ch]) {
                cout << "char at " << i << " is not unique: " << str[i] << endl;
                return false;
            } else {
                charArr[ch] = true;
            }
        }
        return true;
    }

    /**
     * Use bit vector to reduce space usage.
     * How many memory do we need?
     *  Take ASCII for example, we need 256 bits.
     *  if we use int array, 1 int has 4 Bytes(32bits), then the array size should be 8(N/32).
     *
     * How to map these char to bits?
     *  Bitmap: each int has 32 bits, and one bit map one char
     *   a[0] -> 0~31; a[1] -> 32~63; ...
     *  idx = ch / 32; shift = ch % 32;
     *
     * How to set and get each bit?
     *  int a[idx]  00000000000000000000000000000000
     *  1 << shift  11111111111111111111111111111100
     */
    bool isUniqueByBitVector(string str) {
        int bitArr[8];
        int len = str.length();
        int ch, idx, shift;
        for (int i = 0; i < len; i++) {
            ch = (int)str[i];
            idx = ch >> 5; // ch / 32;
            shift = ch & ((1 << 5) - 1); //ch % 32;
            if (bitArr[idx] & (1 << shift)) {
                return false;
            }
            bitArr[idx] |= (1 << shift); 
        }
        return true;
};

int main(int argc, char const *argv[]) {
    UniqueCharacters unique;
    string str = "abcded";
    cout << unique.isUniqueByArray(str) << endl;
}
