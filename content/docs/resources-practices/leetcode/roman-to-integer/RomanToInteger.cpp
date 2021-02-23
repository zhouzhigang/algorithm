#include <string>   // std::string
#include <iostream> // std::cout
using namespace std;

class Solution {
public:
    int romanToInt(string s) {
        int result = 0;
        int len = s.length();
        char ch;
        for (int i = 0; i < len; i++) {
            ch = s[i];
            switch (ch) {
                case 'M':
                    result += 1000;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'C':
                    if (i+1 < len && (s[i+1] == 'D' || s[i+1] == 'M')) {
                        result -= 100;
                    } else {
                        result += 100;
                    }
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'X':
                    if (i+1 < len && (s[i+1] == 'L' || s[i+1] == 'C')) {
                        result -= 10;
                    } else {
                        result += 10;
                    }
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'I':
                    if (i+1 < len && (s[i+1] == 'V' || s[i+1] == 'X')) {
                        result -= 1;
                    } else {
                        result += 1;
                    }
                    break;
            }
        }
        return result;
    }
};

int main(int argc, char const *argv[]) {
    Solution sol;

    string strs[] = {
        "", "I", "III", "V", "IX", // 0 ~ 10
        "X", "XII", "XXVI", "XLIII", "L", "XCVIII", // 10 ~ 100
        "C", "CCXLVII", "DCCVII", "DCCCXC", // 100 ~ 1000
        "M", "MMCCCL", "MMMCDLVIII", "MMMCMXCIX" // 1000 ~ 3999
    };

    int results[] = {
        0, 1, 3, 5, 9, // 0 ~ 10
        10, 12, 26, 43, 50, 98, // 10 ~ 100
        100, 247, 707, 890, // 100 ~ 1000
        1000, 2350, 3458, 3999 // 1000 ~ 3999
    };

    int count = sizeof(results)/sizeof(results[0]);
    int failed = 0;
    int result;
    for (int i = 0; i < count; i++) {
        result = sol.romanToInt(strs[i]);
        if (result != results[i]) {
            failed++;
            cout << "Test: " << strs[i] << ", expect: " << results[i] << ", while returned: " << result << endl;
        }
    }
    cout << "Test " << count << " cases: " << (count-failed) << " success, " << failed << " failed." << endl;

    return 0;
}
