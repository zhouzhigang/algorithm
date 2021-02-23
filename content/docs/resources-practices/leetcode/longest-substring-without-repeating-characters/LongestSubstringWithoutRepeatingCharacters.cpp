#include <string.h>
#include <map>
#include <iostream>
#include <string>
using namespace std;

/**
 * Longest Substring Without Repeating Characters.
 */
class Solution {
public:
    /**
     * Hash map solution.
     * Use a hash map to dectect the duplicated character and index.
     */
    int lengthOfLongestSubstring(string s) {
        int len = 0;
        // use a map to store each char's index.
        map<char, int> m;
        char c;
        // last repeated position(start = lastPos + 1)
        int lastPos = -1;
        for (int i = 0; i < s.size(); i++) {
            c = s[i];
            if (m.find(c) != m.end() && m[c] > lastPos) {
                // update next possible start position
                lastPos = m[c];
            }
            if (i - lastPos > len) {
                len = i - lastPos;
            }
            // update the lastest position of c
            m[c] = i;
        }
        return len;
    }

    /**
     * Array instead of hash map.
     */
   int lengthOfLongestSubstring_array(string s) {
        int len = 0;
        // use an array to replace hash map
        int m[128];
        memset(m, -1, sizeof(m));
        char c;
        int pos;
        int lastPos = -1;
        for (int i = 0; i < s.size(); i++) {
            c = s[i];
            pos = m[c];
            if (pos != -1 && pos > lastPos) {
                // update next possible start position
                lastPos = pos;
            }
            if (i - lastPos > len) {
                len = i - lastPos;
            }
            // update the lastest position of c
            m[c] = i;
        }
        return len;
    }
    
};

int main(int argc, char** argv) {
    string testArray[] = {"abcabcab", "bbbbbbbb", "", "c", "abcd", "cdd", "abba", "pwwkew", "dvdf", "tmmzuxt", "uqinntq"};
    int expectedResult[] = {3, 1, 0, 1, 4, 2, 2, 3, 3, 5, 4};
    int size = 11;
    int len = 0;
    Solution sol;
    for (int i = 0; i < size; i++) {
        len = sol.lengthOfLongestSubstring(testArray[i]);
        if (len == expectedResult[i]) {
            cout << "Success: " << len << endl;
        } else {
            cout << "Failed: " <<  "; expected: " << expectedResult[i] << endl;
        }
    }
}
