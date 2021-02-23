#!/usr/bin/env python

class Solution:
    def intToRoman(self, num):
        basic = "IVXLCDM"
        s = ""
        n = 4
        k = 1000
        while n != 0:
            h = num / k
            if 1 <= h and h <= 3:
                j = h
                while j > 0:
                    s += basic[2*n-2]
                    j -= 1
            elif h == 4:
                s = s + basic[2*n-2] + basic[2*n-1]
            elif h == 5:
                s += basic[2*n-1]
            elif 6 <= h and h <= 8:
                s += basic[2*n-1]
                j = h - 5
                while j > 0:
                    s += basic[2*n-2]
                    j -= 1
            elif h == 9:
                s = s + basic[2*n-2] + basic[2*n]
            elif h == 10:
                s += basic[2*n]

            num = num - h * k
            k /= 10
            n -= 1
        return s

if __name__ == "__main__":
    sol = Solution()
    nums = [
        0, 1, 3, 5, 9, # 0 ~ 10
        10, 12, 26, 43, 50, 98, # 10 ~ 100
        100, 247, 707, 890, # 100 ~ 1000
        1000, 2350, 3458, 3999 # 1000 ~ 3999
    ]
    results = [
        "", "I", "III", "V", "IX", # 0 ~ 10
        "X", "XII", "XXVI", "XLIII", "L", "XCVIII", # 10 ~ 100
        "C", "CCXLVII", "DCCVII", "DCCCXC", # 100 ~ 1000
        "M", "MMCCCL", "MMMCDLVIII", "MMMCMXCIX" # 1000 ~ 3999
    ]
    count = len(nums)
    failed = 0
    for i in range(count):
        result = sol.intToRoman(nums[i])
        if result != results[i]:
            failed += 1
            print "Test: ", nums[i], ", expect: ", results[i], ", while returned: ", result
    print "Test ", count, " cases, ", (count-failed), " success, ", failed, " failed"
