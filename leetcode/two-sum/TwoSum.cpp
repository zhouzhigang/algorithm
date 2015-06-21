/**
 * Given an array of integets, find two numbers such that they add up to a specific target number.
 */
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> result;
        int sz = nums.size();
        map<int, int> m;
        map<int, int>::iterator p;
        for (int i = 0; i < sz; i++) {
            // check if we find `target - num[i]`
            p = m.find(target - nums[i]);
            if (p != m.end()) {
                result.push_back(p->second + 1);
                result.push_back(i + 1);
                return result;
            }
            // put nums[i] into map
            m[nums[i]] = i;
        }
    }
};
