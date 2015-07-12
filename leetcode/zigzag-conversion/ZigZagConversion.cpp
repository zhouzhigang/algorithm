#include <string>   // std::string
#include <iostream> // std:cout
using namespace std;

class Solution {
public:
    string convert(string s, int numRows) {
        if (numRows <= 1) { return s; }
        int size = s.size();
        string result;
        int base = (numRows - 1) * 2; // used to calculate index
        for (int i = 0; i < numRows; i++) {
            int idx = i;
            int j = 0;
            while(idx < size) {
                result += s[idx];
                if (i == 0 || i == numRows - 1) {
                    idx = idx + base;
                } else {
                    j++;
                    // calculate the next index
                    idx = base * j - idx;
                }
            }
        }
        return result;
    }
};
int main(int argc, char const *argv[]) {
    Solution sol;

    string strs[] = {
        "PAYPALISHIRING", "ABCDEF",
        "0123456", "0123456789", "0123456789"
    };
    int rows[] = {
        3, 3,
        2, 3, 4
    };
    string results[] = {
        "PAHNAPLSIIGYIR", "AEBDFC",
        "0246135", "0481357926", "0615724839"
    };
    
    int len = sizeof(rows)/sizeof(int);
    int failed = 0;
    string result;
    for (int i = 0; i < len; i++) {
        result = sol.convert(strs[i], rows[i]);
        if (result != results[i]) {
            failed++;
            cout << "Test: " << strs[i] + ", numRows: " << rows[i] << ", expect: " << results[i] << ", while returned: " << result << endl;
        }
    }
    cout << "Test " << len << " cases: " << (len - failed) << " success, " << failed << " failed." << endl;
}
