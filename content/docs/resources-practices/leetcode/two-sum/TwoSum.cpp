#include <vector>   // std::vector
#include <map>      // std::map
#include <numeric>  // std::iota
#include <algorithm>// std::sort, std::swap
#include <iostream> // std::cout
using namespace std;

/**
 * Given an array of integets, find two numbers such that they add up to a specific target number.
 */
class Solution {
public:
    /**
     * Hash map solution: reduce the complexity using a hash map that maps a value to its index.
     * O(n) runtime, O(n) space.
     */
    vector<int> twoSum_map(vector<int>& nums, int target) {
        vector<int> result;
        int size = nums.size();
        map<int, int> m;
        map<int, int>::iterator itr;
        for (int i = 0; i < size; i++) {
            // check if we find `target - num[i]`
            itr = m.find(target - nums[i]);
            if (itr != m.end()) { // find the first number index
                result.push_back(itr->second + 1);
                result.push_back(i + 1);
                return result;
            }
            // put nums[i] into map like a array
            m[nums[i]] = i;
        }
    }

    /**
     * Sort solution: reduce the extra loop to get the index by sort the index.
     */
    vector<int> twoSum_sort(vector<int> &nums, int target) {
        vector<int> result;
        int size = nums.size();

        // sort the index(not sort the nums because we need return the index)
        vector<int> idxs(size);
        // init the idxs from 0 to size-1
        iota(idxs.begin(), idxs.end(), 0);
        // sort the idxs according the value in nums, lambda supported in c++11
        sort(idxs.begin(), idxs.end(), [&](int x, int y) { return nums[x] < nums[y]; } );
        
        /*
        int low = 0;
        int high = size - 1;
        int i, j, sum;
        while (low < high) {
            i = idxs[low];
            j = idxs[high];
            sum = nums[i] + nums[j];
            if (sum > target) {
                high--;
            } else if (sum < target) {
                low++;
            } else {
                idxs.clear();
                if (i > j) { swap (i, j); }
                result.push_back(i + 1);
                result.push_back(j + 1);
                break;
            }
        }
        */

        for (int i = 0, j = size - 1; i < j; i++ ) {
            while (j > i + 1 && 
                    nums[idxs[i]] + nums[idxs[j]] > target) {
                j--;
            }
            if (nums[idxs[i]] + nums[idxs[j]] == target) {
                int x = idxs[i];
                int y = idxs[j];
                idxs.clear();
                if (x > y) {
                    swap(x, y);
                }
                result.push_back(x + 1);
                result.push_back(y + 1);
                break;
            }
        }

        return result;
    }
};
int main() {
    int arr[] = {3, 7, 9, 2, 11, 15};
    int len = sizeof(arr) / sizeof(int);
    vector<int> nums(&arr[0], &arr[len - 1]);
    int target = 9;
    Solution sol;
    vector<int> result = sol.twoSum_sort(nums, target);
    cout << "index1: " << result[0] << ", index2: " << result[1] << endl;
    return 0;
}
