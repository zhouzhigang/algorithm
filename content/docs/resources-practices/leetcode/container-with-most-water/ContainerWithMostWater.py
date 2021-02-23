#!/usr/bin/env python

class Solution:
    def maxArea(self, height):
        maxArea = 0
        i = 0
        j = len(height) - 1
        while i < j:
            if height[i] < height[j]:
                tmp = height[i] * (j - i)
                i += 1
            else:
                tmp = height[j] * (j - i)
                j -= 1
            if tmp > maxArea:
                maxArea = tmp
        return maxArea

if __name__ == "__main__":
    sol = Solution()

    heights = [
        [1, 2, 3, 4, 5],
        [1, 3, 5, 2, 4]
    ]
    results = [
        6,
        9
    ]
    count = len(results)
    failed = 0
    for i in range(count):
        result = sol.maxArea(heights[i])
        if result != results[i]:
            print "Test: ", heights[i], ", expect: ", results[i], ", while returned: ", result
    print "Test ", count, " cases: ", count-failed, " success, ", failed, " failed."
