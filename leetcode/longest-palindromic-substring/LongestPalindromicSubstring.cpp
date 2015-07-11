#include <string>   //std::string
#include <iostream> //std:cout, std::endl
using namespace std;

class Solution {
public:
    /**
     * Find the Longest Palindromic Substring by checking from middle number one by one.
     * From middle(1 ~ len-1) to left and right, check if they are equal.
     * 
     * O(n^2) runtime, O(1) space.
     */
    string longestPalindrome(string s) {
        int size = s.size();
        // return origin string if length less than 2(exist and only exist one LPS)
        if (size <= 2) { return s; }
        int start = 0;
        int end = 0;
        for (int i = 0; i < size; i++) {
            // l , r means left and right position
            int l = i - 1, r = i + 1;
            // skip the checked substring(same with previous char)
            if (l >= 0 && s[l] == s[i]) { continue; }
            // extend the same characters
            while (r < size && s[i] == s[r]) {
                r++;
            } 
            // check if left equals right
            while (l >= 0 && r < size && s[l] == s[r]) {
                l--;
                r++;
            }
            // check if the longest(the final l,r should not include)
            if (r - l - 2 > end -start) {
                start = l + 1;
                end = r - 1;
            }
        }
        // Note: c++ substring method `substr(start, len)`
        return s.substr(start, end-start+1);
    }
};

int main(int argc, char const *argv[]) {
    Solution sol;

    string strs[] = {
        "", "a",
        "aa", "baa", "aab",
        "aaa", "baaa", "aaab",
        "aaaa", "baaaa", "aaaab",
        "aba", "caba", "abac",
        "abba", "cabba", "abbac",
        "babba", "cbabba", "babbac",
        "ababba", "cababba", "ababbac",
        "bbababba", "cbbababba", "bbababbac"
    };
    string results[] = {
        "", "a",
        "aa", "aa", "aa",
        "aaa", "aaa", "aaa",
        "aaaa", "aaaa", "aaaa",
        "aba", "aba", "aba",
        "abba", "abba", "abba",
        "abba", "abba", "abba",
        "abba", "abba", "abba",
        "bbababb", "bbababb", "bbababb"
    };
    int size = 26;
    int failed = 0;
    string result;
    for (int i = 0; i < size; i++) {
        result = sol.longestPalindrome(strs[i]);
        if (result != results[i]) {
            failed++;
            cout << "Test: " << strs[i] << ", expect: " << results[i] << "; while returned: " << result << endl;
        }
    }
    cout << "Test " << size << " cases: " << (size - failed) << " success, " << failed << " failed." << endl;
}

