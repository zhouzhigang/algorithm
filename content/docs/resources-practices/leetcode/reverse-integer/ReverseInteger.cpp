#include <limits>   // std::numeric_limits<int>::max()
#include <iostream> // std::cout
using namespace std;

class Solution {
public:
    int reverse(int x) {
        int res = 0;
        bool isNegtive = x < 0 ? true : false;
        // leave last number to check overflow
        while (x/10 != 0) {
            res = 10 * res + x % 10;
            x /= 10;
        }
        int m = x % 10;
        // check overflow 
        if ((!isNegtive && res > (numeric_limits<int>::max() - m)/10) || (isNegtive && res < (numeric_limits<int>::min() - m)/10)) {
            return 0;
        }
        res = 10 * res + m;
        return res;
    }
};

int main(int argc, char const *argv[]) {
    Solution sol;

    int nums[] = {
        0, -0, // zero
        10, -10, // end with zero
        123, -123, // normal condition
        1000000003, -1000000003, // overlow, and sign will change
        1534236469, // overflow but sign will not chang
        1463847412, -1463847412 // reverse between -2147483648 ~ 2147483647
    };
    int results[] = {
        0, 0, // zero
        1, -1, // no prefix zero
        321, -321, // normal condition
        0, 0, // return 0 when overflow
        0,
        2147483641, -2147483641
    };
    int count = sizeof(nums)/sizeof(nums[0]);
    int failed = 0;
    int result;
    for (int i = 0; i < count; i++) {
        result = sol.reverse(nums[i]);
        if (result != results[i]) {
            failed++;
            cout << "Test: " << nums[i] << ", expect: " << results[i] << ", while returned: " << result << endl;
        }
    }
    cout << "Test " << count << " cases: " << (count - failed) << " success, " << failed << " failed." << endl;
}
