#include <string>   // std::string
#include <iostream> // std::cout
using namespace std;

class Solution {
public:
    /**
     * Use 7 basic symbols.
     */
    string intToRoman_1(int num) {
        string sb;
        string basic = "IVXLCDM";
        int n = 4;
        int k = 1000;
        int h = 0;
        while (n != 0) {
            h = num / k;
            switch(h) {
                case 1:
                case 2:
                case 3:
                    sb.append(h, basic[2*n-2]); break;
                case 4:
                    sb.append(1, basic[2*n-2]);
                    sb.append(1, basic[2*n-1]);
                    break;
                case 5:
                    sb.append(1, basic[2*n-1]); break;
                case 6:
                case 7:
                case 8:
                    sb.append(1, basic[2*n-1]);
                    sb.append(h-5, basic[2*n-2]); break;
                case 9:
                    sb.append(1, basic[2*n-2]);
                    sb.append(1, basic[2*n]); break;
                case 10:
                    sb.append(1, basic[2*n]); break;
                default:
                    break;
            }
            num = num - h * k;
            k /= 10;
            n--;
        }
        return sb;
    }

    /**
     * Use space to save time.
     */
    string intToRoman(int num) {
        string sb;
        string basic[4][10] = {
            {"",  "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" },
            {"",  "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" },
            {"",  "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" },
            {"", "M", "MM", "MMM"}
        };
        int i = 3;
        int j = 0;
        int k = 1000;
        while (num != 0) {
            j = num / k;
            sb.append(basic[i][j]);
            num = num - j * k;
            k /= 10;
            i--;
        }
        return sb;
    }
};
int main(int argc, char const * argv[]) {
    Solution sol;

    int nums[] = {
        0, 1, 3, 5, 9, // 0 ~ 10
        10, 12, 26, 43, 50, 98, // 10 ~ 100
        100, 247, 707, 890, // 100 ~ 1000
        1000, 2350, 3458, 3999 // 1000 ~ 3999
    };

    string results[] = {
        "", "I", "III", "V", "IX", // 0 ~ 10
        "X", "XII", "XXVI", "XLIII", "L", "XCVIII", // 10 ~ 100
        "C", "CCXLVII", "DCCVII", "DCCCXC", // 100 ~ 1000
        "M", "MMCCCL", "MMMCDLVIII", "MMMCMXCIX"
    };

    int count = sizeof(nums)/sizeof(nums[0]);
    int failed = 0;
    string result;
    for (int i = 0; i < count; i++) {
        result = sol.intToRoman(nums[i]);
        if (result != results[i]) {
            failed++;
            cout << "Test: " << nums[i] << ", expect: " << results[i] << ", while returned: " << result << endl;
        }
    }
    cout << "Test " << count << " cases: " << (count-failed) << " success, " << failed << " failed." << endl;
}

