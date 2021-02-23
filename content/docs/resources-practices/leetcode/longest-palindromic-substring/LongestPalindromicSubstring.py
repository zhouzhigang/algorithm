class Solution:
    # @param {string} s
    # @return {string}
    def longestPalindrome(self, s):
        length = len(s)
        if length <= 2:
            return s
        start, end = 0, 0
        for i in range(length):
            l = i - 1
            r = i + 1
            if l >= 0 and s[l] == s[i]:
                continue
            while r < length and s[i] == s[r]:
                r += 1
            while l >= 0 and r < length and s[l] == s[r]:
                l -= 1
                r += 1
            if r - l - 2 > end - start:
                start = l + 1
                end = r - 1
        return s[start: end+1]

if __name__ == "__main__":
    sol = Solution()
    strs = [
            "", "a",
            "aa", "baa", "aab",
            "aaa", "baaa", "aaab",
            "aaaa", "baaaa", "aaaab",
            "aba", "caba", "abac",
            "abba", "cabba", "abbac",
            "babba", "cbabba", "babbac",
            "ababba", "cababba", "ababbac",
            "bbababba", "cbbababba", "bbababbac"
            ]
    results = [
            "", "a",
            "aa", "aa", "aa",
            "aaa", "aaa", "aaa",
            "aaaa", "aaaa", "aaaa",
            "aba", "aba", "aba",
            "abba", "abba", "abba",
            "abba", "abba", "abba",
             "abba", "abba", "abba",
             "bbababb", "bbababb", "bbababb"
            ]
    count = len(strs)
    failed = 0
    for i in range(count):
        result = sol.longestPalindrome(strs[i])
        if results[i] != result:
            failed += 1
            print "Test: ", strs[i], ", expect: ", results[i], " , while returned: ", result
    print "Test ", count, " cases, ", count-failed, "success, ", failed, " failed."
