# find two numbers such that they can add up to a specific target number.
# @return a tuple, (index1, index2)
class Solution:

    # dict(map) solution.
    def twoSum_dict(self, nums, target):
        dict = {};
        for i in range(len(nums)):
            if dict.get(target - nums[i]) != None:
                return (dict[target - nums[i]] + 1, i + 1)
            else:
                dict[nums[i]] = i

    # dict solution with enumerate function.
    def twoSum_dict2(self, nums, target):
        dict = {};
        for i, val in enumerate(nums):
            if val in dict:
                return  dict[val] + 1, i + 1
            dict[target - val] = i


    # sort solution.
    def twoSum_sort(self, nums, target):
        idxs = [i for i in range(len(nums))]
        idxs.sort(lambda x, y: nums[x] - nums[y])
        low = 0

        high = len(nums) - 1
        while low < high:
            i = idxs[low]
            j = idxs[high]
            sum = nums[i] + nums[j]

            if sum > target:
                high = high - 1
            elif sum < target:
                low = low + 1
            else:
                return (i + 1, j + 1)

# the main code
sol = Solution()
print sol.twoSum_dict([3, 2, 9, 7, 11, 13], 9)
print sol.twoSum_dict([3, 2, 9, 7, 11, 13], 8)
print sol.twoSum_sort([3, 2, 9, 7, 11, 13], 9)
print sol.twoSum_sort([3, 2, 9, 7, 11, 13], 8)
