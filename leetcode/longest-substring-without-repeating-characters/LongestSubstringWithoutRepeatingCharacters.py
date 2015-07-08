#
# Given a string, find the length of the longest substring without repeating characters.
# For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
# For "bbbbb" the longest substring is "b", with the length of 1.
#
class Solution:
    # Array map solution
    def lengthOfLongestSubstring(self, s):
        longestLen = 0
        pos = -1
        lastPos = -1
        arr = [-1 for _ in range(256)]
        for i, char in enumerate(s):
            pos = arr[ord(char)]
            if pos != -1 and pos > lastPos:
                lastPos = pos
            if i - lastPos > longestLen:
                longestLen += 1
            arr[ord(char)] = i
        return longestLen

# the main code
if __name__=='__main__':
    sol = Solution()
    testArray = ["abcabcab", "bbbbbbbb", "", "c", "abcd", "cdd", "abba", "pwwkew", "dvdf", "tmmzuxt", "uqinntq"]
    expectedResult = [3, 1, 0, 1, 4, 2, 2, 3, 3, 5, 4]
    for i, testStr in enumerate(testArray):
        print sol.lengthOfLongestSubstring(testStr) == expectedResult[i]

