class Solution:
    # @param {integer[]} nums1
    # @param {integer[]} nums2
    # @return {float}
    def findMedianSortedArrays(self, nums1, nums2):
        m = len(nums1) - 1
        n = len(nums2) - 1
        lm, hm = 0, m
        mm = (lm + hm) / 2
        ln, hn = 0 , n
        mn = (ln + hn) / 2

        if m < 0 and n < 0:
            return 0
        elif m < 0:
            return nums2[mn] if n % 2 == 0 else (nums2[mn] + nums2[mn+1])/2.0
        elif n < 0:
            return nums1[mm] if m % 2 == 0 else (nums1[mm] + nums1[mm+1])/2.0
        elif m == 0 and n == 0:
            return (nums1[0] + nums2[0])/2.0

        while lm < hm or ln < hn:
            if nums1[mm] < nums2[mn]:
                lm, hn = mm + 1, mn
            elif nums1[mm] > nums2[mn]:
                hm, ln = mm, mn + 1
            else:
                break
            mm, mn = (lm + hm) / 2, (ln + hn) / 2

        k = (m + n + 1) / 2
        offset = k - (mm + mn) - 1

        while offset < 0:
            if mn - 1 < 0 or (mm > 0 and nums1[mm] > nums2[mn]):
                mm -= 1
            else:
                mn -= 1
            offset += 1

        while offset > 0:
            if mm + 1 > m or (mn + 1 <= n and nums1[mm] > nums2[mn]):
                mn += 1
            else:
                mm += 1
            offset -= 1

        if (nums1[mm] > nums2[mn]):
            return self.getMedian(nums2, mn, n, nums1, mm, m)
        return self.getMedian(nums1, mm, m, nums2, mn, n)

    def getMedian(self, nums1, mm, m, nums2, mn, n):
        median, second = 0, 0
        hasSecond = (m + n) % 2 == 0;

        # nums1[mm] <= nums2[mn]
        if (mm < m): # mm + 1 < m
            if nums1[mm+1] < nums2[mn]:
                median = nums1[mm+1]
                if hasSecond:
                    second = nums1[mm+2] if  mm + 2 <= m and nums1[mm+2] < nums2[mn] else nums2[mn]
            else:
                median = nums2[mn]
                if hasSecond:
                    second = nums1[mm+1] if mn + 1 > n or nums1[mm+1] < nums2[mn+1] else nums2[mn+1]
        else:
            median = nums2[mn];
            if hasSecond:
                second = nums2[mn+1]

        return (median + second) / 2.0 if hasSecond else median

if __name__ == "__main__":
    sol = Solution()
    nums = [
            [], [], # both are empty
            [], [1, 2], # one is empty, the other is even
            [1, 2, 3], [], # one is empty, the other is odd
            # one odd(1), one even
            [1], [2, 3],
            [2], [1, 3],
            [3], [1, 2],
            # two odd
            [1], [2, 3, 4],
            [2], [1, 3, 4],
            [3], [1, 2, 4],
            [4], [1, 2, 3],
            # one even, one odd(more than one)
            [1, 2], [3, 4, 5],
            [1, 3], [2, 4, 5],
            [1, 4], [2, 3, 5],
            [1, 5], [2, 3, 4],
            [2, 3], [1, 4, 5],
            [2, 4], [1, 3, 5],
            [2, 5], [1, 3, 4],
            [3, 4], [1, 2, 5],
            [3, 5], [1, 2 ,4],
            [4, 5], [1, 2 ,3]
        ]
    expects = [
            # special condition
            0, 1.5, 2,
            # one odd(1), one even
            2, 2, 2,
            # two odd
            2.5, 2.5, 2.5, 2.5,
            # one even, one odd(more than one)
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3
        ]
    count = len(expects)
    failed = 0
    for i in range(count):
        median = sol.findMedianSortedArrays(nums[2*i], nums[2*i+1])
        expected = expects[i]
        if median - expected >= 0.001 or expected - median >= 0.001:
            print nums[2*i], nums[2*i+1]
            print "median: ", median, "; expected:", expected
            failed += 1
    print "Test ", count, " cases, ", count-failed, "success, ", failed, " failed."
