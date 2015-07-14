class Solution:
    def isPalindrome(self, x):
        if x < 0:
            return False
        k = 1
        while x/k >= 10:
            k *= 10
        while x/k == x%10:
            x = x - (x/k)*k
            x /= 10
            k /= 100
            if k <= 1:
                return True
        return False

if __name__ == "__main__":
    sol = Solution()
    nums = [
        0, 1, 9, # less than 10
        -2, -101, # negtive
        101, 1001, 121, 1221, # old and even
        10, 100, 100101 # not palindrom
    ]
    results = [
        True, True, True, # less than 10
        False, False, # negtive is not palindrome
        True, True, True, True, # old and even
        False, False, False
    ]
    count = len(nums)
    failed = 0
    for i in range(count):
        result = sol.isPalindrome(nums[i])
        if result != results[i]:
            failed += 1
            print "Test: ", nums[i], ", expect: ", results[i], ", while returned: ", result
    print "Test ", count, " cases, ", (count-failed), " success, ", failed, " failed"
