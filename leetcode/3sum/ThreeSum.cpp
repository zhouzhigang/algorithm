#include <vector>   // std::vector
#include <algorithm>// std::sort
#include <iostream> // std:cout
using namespace std;

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> result;
        sort(nums.begin(), nums.end());
        int right = nums.size() - 1;
        int i, j, k, sum;
        for (i = 0; i < right -1; i++) {
            if (nums[i] > 0) break;
            j = i + 1; k = right;
            while (j < k) {
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    j++;
                    continue;
                }
                sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    result.push_back(vector<int>{nums[i], nums[j], nums[k]});
                    j++;
                    k--;
                }
            }
            while (i < right && nums[i] == nums[i+1]) {
                i++;
            }
        }
        return result;
    }
};

int main(int argc, char const *argv[]) {
    Solution sol;
    vector<vector<int>> nums = {
            {1}, {-1, 1}, {-1, 1, 2}, // no such triple
            {-1, -1, 2},
            {-1, 0, 1, 2, -1, 4},
            {-1, 0, 1, 2, -1, -4},
            {0, 0, 0, 0, 0}, // duplicate number
            {-2, -1, 0, 1, 2},
            {-2, -1, 0, 1, 1, 2},
            {-2, 0, 0, 2, 2, 2},
            {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6},

    };
    int results[] = {
        0, 0, 0, // no such triple
        1,
        2,
        2,
        1, // duplicate number
        2,
        3,
        1,
        6,
    };
    int count = sizeof(results)/sizeof(results[0]);
    int failed = 0;
    vector<vector<int>> result;
    for (int i = 0; i < count; i++) {
        result = sol.threeSum(nums[i]);
        if (result.size() != results[i]) {
            failed++;
            cout << "Test: " << i << ", expect " << results[i] << " triplets, while returnd " << result.size() << " triplets." << endl;
        }
    }
    cout << "Test " << count << " cases: " << (count-failed) << " success, " << failed << " failed." << endl;

    return 0;
}
