#include <vector>   // std::vector
#include <string>   // std::string
#include <iostream> // std:cout
using namespace std;

class Solution {
public:
    string longestCommonPrefix(vector<string> strs) {
        int len = strs.size();
        if (len == 0) return "";
        if (len == 1) return strs[0];
        int minLen = strs[0].length();
        int i;
        for (i = 1 ; i < len; i++) {
            if (minLen > strs[i].length()) {
                minLen = strs[i].length();
            }
        }
        for (int j = 0; j < minLen; j++) {
            for (i = 1; i < len; i++) {
                if (strs[0][j] != strs[i][j]) {
                    return strs[0].substr(0, j);
                }
            }
        }
        return strs[0].substr(0, minLen);
    }
};
int main(int argc, char const *argv[]) {
    Solution sol;

    vector< vector<string> > strs = {
        {}, // empty array
        {"abcd"}, // only one string
        {"a", "abcd", "acd", "abd"},
        {"abc", "abcd", "abd", "abde"},
        {"abc", "abd", "bcd"} // no common prefix
    };
    string results[] = {
        "", // empty string
        "abcd", // only one string
        "a",
        "ab",
        "" // no common prefix
    };
    int count = strs.size();
    int failed = 0;
    string result;
    for (int i = 0; i < count; i++) {
        result = sol.longestCommonPrefix(strs[i]);
        if (result != results[i]) {
            failed++;
            cout << "Test: " << i << ", expect: " << results[i] << ", while returned: " << result << endl;
        }
    }
    cout << "Test " << count << " cases: " << (count-failed) << " success, " << failed << " failed." << endl;
}
        
