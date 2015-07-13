#include <string>   // std::string
#include <limits>   // std::numeric_limits<int>::max(), min()
#include<iostream>  // std:cout
using namespace std;

class Solution {
public:
    int myAtoi(string str) {
        if (str == "") { return 0; }
        int len = str.size();
        int res = 0; // result
        bool isNegtive = false;
        int base = 10; // should we consider base 2, 8 and 16?
        int i = 0;
        int maxLen = 9; // used for check overflow
        // skip white space: isWhitespace, isSpace, isSpaceChar?
        while(i < len && isspace(str[i])) {
            i++;
        }
        if (i == len) { return 0; }
        // check if has positive or negtive symbol
        if (str[i] == '+' || str[i] == '-') {
            if (str[i] == '-') {
                isNegtive = true;
            }
            i++;
        }
        // calculate int value
        while (maxLen > 0 && i < len && isdigit(str[i])) {
            res = res * base + (str[i] - '0');
            i++;
            maxLen--;
        }
        // check overflow conditon
        while (i < len && isdigit(str[i])) {
            int ch = str[i] - '0';
            if (isNegtive) {
                // Note: -res and min + ch
                if (-res < (numeric_limits<int>::min() + ch) / base) {
                    return numeric_limits<int>::min();
                }
            } else {
                if (res > (numeric_limits<int>::max() - ch) / base) {
                    return numeric_limits<int>::max();
                }
            }
            res = res * base + ch;
            i++;
        }
        return isNegtive ? -res : res;
    }
};
int main(int argc, char const *argv[]) {
    Solution sol;

    string strs[] = {
        "", "   ", // only contains space
        "123", "+123", "-123", // with positive and negtive symbol
        "-+123", "+-123", "--123", // with multiple +/- symbol
        "  123 ", "-12 3", " +123  ", // with space
        "123junk", "123abcdfg", // with junk character
        "2147483648", "-2147483649", // overflow
        "2147483647", "-2147483647", // not overflow
        "21474836300", "-21474836300" // another overflow
    };
    int results[] = {
        0, 0, // only space
        123, 123, -123, // with negtive symbol
        0, 0, 0, // with mutiple +/- symbol
        123, -12, 123, // skip prefix white space
        123, 123, // ignore junk letter
        2147483647, -2147483648, // overflow
        2147483647, -2147483647, // not overflow
        2147483647, -2147483648 //overflow
    };
    int count = sizeof(results)/sizeof(results[0]);
    int failed = 0;
    int result;
    for (int i = 0; i < count; i++) {
        result = sol.myAtoi(strs[i]);
        if (result != results[i]) {
            failed++;
            cout << "Test: " << strs[i] << ", expect: " << results[i] << ", while returned: " << result << endl;
        }
    }
    cout << "Test " << count << " cases: " << (count - failed) << " success, " << failed << " failed." << endl;
}

