class Solution:
    def myAtoi(self, str):
        length = len(str)
        res = 0
        isNegtive = False
        base = 10
        i = 0
        # skip whitespace
        while i < length and str[i].isspace():
            i += 1
        if i == length:
            return 0
        # check positive or negtive symbol
        if str[i] == '+' or str[i] == '-':
            if str[i] == '-':
                isNegtive = True
            i += 1
        if str[i].isdigit() == False: return 0
        # calculate int value
        while i < length and str[i].isdigit():
            res = res * base + ord(str[i]) - ord('0')
            i += 1
        # check overflow(in fact, it will convert to long automatully))
        if isNegtive:
            res = -res
            if res < -0x80000000:
                return -0x80000000
        else:
            if res > 0x7fffffff:
                return 0x7fffffff
        return res

if __name__ == "__main__":
    sol = Solution()
    strs = [
        "", "   ", # only contains space
        "123", "+123", "-123", # with positive and negtive symbol
        "-+123", "+-123", "--123", # with mutiple +/- symbols
        "   123", "-12 3", " +123 ", # with space
        "123junk", "123abcdefg", # with junk characters
        "2147483648", "-2147483649", # overflow
        "2147483647", "-2147483647", # boundry, not overflow
        "21474836300", "-21474836300", # overflow
    ]
    results = [
        0, 0, # only space
        123, 123, -123, # with negtive symbol
        0, 0, 0, # with mutiple +/- symbol is invalid
        123, -12, 123, # skip prefix white space
        123, 123, # ignore junk letter
        2147483647, -2147483648, # overflow
        2147483647, -2147483647, # not overflow
        2147483647, -2147483648 # overflow
    ]
    count = len(strs)
    failed = 0
    for i in range(count):
        result = sol.myAtoi(strs[i])
        if result != results[i]:
            failed += 1
            print "Test: ", strs[i], ", expect: ", results[i], ", while returned: ", result
    print "Test ", count, " cases, ", count-failed, "success, ", failed, " failed."
