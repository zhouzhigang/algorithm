class Solution:
    def convert(self, s, numRows):
        if numRows <= 1:
            return s
        result = ""
        base = (numRows - 1) * 2; # used to calculate string index
        for i in range(numRows):
            idx = i
            j = 0
            while idx < len(s):
                result += s[idx]
                if i == 0 or i == numRows - 1:
                    idx = idx + base
                else:
                    j += 1
                    idx = base * j - idx
        return result

if __name__ == "__main__":
    sol = Solution()
    strs = [ "PAYPALISHIRING", "ABCDEF",
            "0123456", "0123456789", "0123456789"]
    rows = [3, 3,
            2, 3, 4]
    results = ["PAHNAPLSIIGYIR", "AEBDFC",
            "0246135", "0481357926", "0615724839"]
    count = len(strs)
    failed = 0
    for i in range(count):
        result = sol.convert(strs[i], rows[i])
        if results[i] != result:
            failed += 1
            print "Test: ", strs[i], ", numRows: ", rows[i], ", expect: ", results[i], ", while returned: ", result
    print "Test ", count, " cases, ", count-failed, "success, ", failed, " failed."
