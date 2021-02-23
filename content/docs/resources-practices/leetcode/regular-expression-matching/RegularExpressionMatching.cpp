#include <string>   //std::string
#include <iostream> // std:cout
using namespace std;

class Solution {
public:
    bool isMatch(string s, string p) {
        if (p.length() == 0) { return s.length() == 0; }

        if (p.length() > 1 && p[1] == '*') {
            while (true) {
                if (isMatch(s, p.substr(2))) {
                    return true;
                }
                if (s.length() > 0 && (s[0] == p[0] || p[0] == '.')) {
                    s = s.substr(1);
                } else {
                    break;
                }
            }
        }

        if (s.length() > 0 && (s[0] == p[0] || p[0] == '.')) {
            return isMatch(s.substr(1), p.substr(1));
        }

        return false;
    }
};
int main(int argc, char const *argv[]) {
    Solution sol;

    string strs[] = {
        "", "", // empty
        "aa", "aa", // full match
        "aaa", "aaa",
        "aa", "a", // part match
        "aaa", "aa", 
        "aa", "a*", // full match with *
        "aa", ".*", // full match with .*
        "ab", ".*",
        "aab", "c*a*b*", // full match with extra c*
        "abcd", "d*", // part match with *
        "a", ".*..a*" // not match with extra .
    };
    bool results[] = {
        true, // empty
        true, // full match
        true,
        false, // part match(false)
        false,
        true, // full match with *
        true, // full match with .*
        true,
        true, // full match with extra c*
        false, // part match with *
        false // not match with extra .
    };

    int count = sizeof(results)/sizeof(results[0]);
    int failed = 0;
    bool result;
    for (int i = 0; i < count; i++) {
        result = sol.isMatch(strs[2*i], strs[2*i+1]);
        if (result != results[i]) {
            failed++;
            cout << "Test string: " << strs[2*i] << ", pattern: " << strs[2*i+1] << ", expect: " << results[i] << ", while returned: " << result << endl;
        }
    }
    cout << "Test " << count << " cases: " << (count - failed) << " success, " << failed << " failed." << endl;
}
