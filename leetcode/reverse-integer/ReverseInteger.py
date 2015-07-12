class Solution:
    def reverse(self, x):
        res = 0
        flag = 1
        # convert x to positive
        if x < 0:
            x = -x
            flag = -1
        # reverse
        while x != 0:
            #print x, ", " ,
            res = res*10 + x % 10
            x = x / 10
        res *= flag
        # python will not overflow((sys.maxint is 2^32-1 or 2^64-1))
        if res > 2147483647 or res < -2147483648:
            return 0
        return res

if __name__ == "__main__":
    sol = Solution()
    nums = [
            0, -0, # zero
            10, -10, # end with zero
            123, -123, # normal condition
            1000000003, -1000000003, # overlow, and sign will change
            1534236469, # overflow but sign will not change
            1463847412, -1463847412 # reverse between -2147483648 ~ 2147483647
            ]
    results = [
            0, 0, # zero
            1, -1, # no prefix zero
            321, -321, # normal condition
            0, 0, # return 0 when overflow
            0,
            2147483641, -2147483641
            ]
    count = len(nums)
    failed = 0;
    for i in range(count):
        result = sol.reverse(nums[i])
        if (result != results[i]):
            failed += 1
            print "Test: ", nums[i], ", expect: ", results[i], ", while returned: ", result
    print "Test ", count, " cases, ", count-failed, "success, ", failed, " failed."

