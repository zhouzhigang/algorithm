#include <vector>    // std::vector
#include <iostream>  //std::cout
using namespace std;

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        // length of each array
        int m = nums1.size() - 1;
        int n = nums2.size() - 1;
        // low, high, and middel position
        int lm = 0, hm = m, mm = (lm + hm) / 2;
        int ln = 0, hn = n, mn = (ln + hn) / 2;

        // special condition
        if (m < 0 && n < 0) { // both are 0
            return 0;
        } else if (m < 0) { // nums1 is empty
            return (n % 2 != 0) ? ((double)nums2[mn] + nums2[mn+1]) / 2 : nums2[mn];
        } else if (n < 0) { // nums2 is empty
            return (m % 2 != 0) ? ((double)nums1[mm] + nums1[mm+1]) / 2 : nums1[mm];
        } else if (m == 0 && n == 0) {
            return ((double)nums1[0] + nums2[0]) / 2;
        }
        // both are not empty
        while (lm < hm || ln < hn) {
            if (nums1[mm] < nums2[mn]) {
                lm = mm + 1;
                hn = mn;
            } else if (nums1[mm] > nums2[mn]) {
                hm = mm;
                ln = mn + 1;
            } else {
                break;
            }
            mm = (lm + hm) / 2;
            mn = (ln + hn) / 2;
        }

        // k is the first median number position
        int k = (m + n + 1) / 2;
        // fix some offset
        int offset = k - (mm + mn) - 1;
        //backward
        while (offset < 0) {
            if (mn -1 < 0 || (mm > 0 && nums1[mm] > nums2[mn])) {
                mm--;
            } else {
                mn--;
            }
            offset++;
        }
        //forward
        while (offset > 0) {
            if (mm + 1 > m || (mn+1 <= n && nums1[mm] > nums2[mn])) {
                mn++;
            } else {
                mm++;
            }
            offset--;
        }

        if (nums1[mm] > nums2[mn]) {
            return getMedian(nums2, mn, nums1, mm);
        }
        return getMedian(nums1, mm, nums2, mn);
    }

    /**
     * Get the median by last position mm and mn.
     * Always assume that `nums1[mm] <= nums2[mn]`
     */
     double getMedian(vector<int>& nums1, int mm, vector<int>& nums2, int mn) {
        double median = 0;
        int second = 0;
        int m = nums1.size() - 1;
        int n = nums2.size() - 1;

        bool hasSecond = ((m+n) % 2 == 0);

        // nums1[mm] <= nums2[mn]
        if (mm < m) {
            if (nums1[mm+1] < nums2[mn]) {
                median = nums1[mm+1];
                if (hasSecond) {
                    second = mm+2 <= m && nums1[mm+2] < nums2[mn] ? nums1[mm+2] : nums2[mn];
                }
            } else {
                median = nums2[mn];
                if (hasSecond) {
                    second = mn+1 > n || nums1[mm+1] < nums2[mn+1] ? nums1[mm+1] : nums2[mn+1];
                }
            }
        } else { // mm + 1 > m
            median = nums2[mn];
            if (hasSecond) {
                second = nums2[mn+1];
            }
        }
        return hasSecond ? (median + second) / 2 : median;
    }
    /**
     * Test function.
     */
    void testMedian(vector<int>& nums1, vector<int>& nums2, double expected) {
        double median = findMedianSortedArrays(nums1, nums2);
        if (median - expected >= 0.001 || expected - median >= 0.001) {
            cout << "median: " << median << "; expected: " << expected << endl;
        }
    }
};

/**
 * Test Method.
 * Note: we should compile the code with g++ -std=c++11.
 * Because we initilized the vector withour constructor which c++98 not supportted.
 *  vector<int> nums = {1, 2, 3};
 *  vector<int> nums{1, 2, 3};
 * in c++98, we should initialize by decaring an array first 
 *  vector<int> nums(&arr[0], &arr[len - 1]);
 */
int main(int argc, char** argv) {
    Solution sol;
    vector<int> nums01 = {1, 2, 5, 8};
    vector<int> nums02 = {};
    sol.testMedian(nums01, nums02, 3.5);
    sol.testMedian(nums02, nums01, 3.5);
    vector<int> nums11 = {1};
    vector<int> nums12 = {2, 3};
    sol.testMedian(nums11, nums12, 2.0);
    sol.testMedian(nums12, nums11, 2.0);
    vector<int> nums21 = {1, 3, 5, 8, 9};
    vector<int> nums22 = {2, 4, 6, 7};
    sol.testMedian(nums21, nums22, 5.0);
    vector<int> nums31 = {1, 3, 5, 8};
    vector<int> nums32 = {2, 4, 11, 13, 15, 16};
    sol.testMedian(nums31, nums32, 6.5);
    vector<int> nums41 = {3};
    vector<int> nums42 = {1, 2};
    sol.testMedian(nums41, nums42, 2.0);
    sol.testMedian(nums42, nums41, 2.0);
    vector<int> nums51 = {1, 3, 5, 8, 9};
    vector<int> nums52 = {10};
    sol.testMedian(nums51, nums52, 6.5);
    sol.testMedian(nums52, nums51, 6.5);
    vector<int> nums61 = {1, 3, 4, 8, 9};
    vector<int> nums62 = {2, 4, 6, 7};
    sol.testMedian(nums61, nums62, 4.0);
    vector<int> nums71 = {1, 3, 6, 8, 9};
    vector<int> nums72 = {2, 4, 6, 7};
    sol.testMedian(nums71, nums72, 6.0);
    vector<int> nums81 = {1, 3, 6, 8, 9, 12};
    vector<int> nums82 = {2, 4, 6, 7, 10};
    sol.testMedian(nums81, nums82, 6.0);
    vector<int> nums91 = {1, 4, 7, 8, 9};
    vector<int> nums92 = {2, 4, 6, 7};
    sol.testMedian(nums91, nums92, 6.0);
    vector<int> nums101 = {1, 2, 3, 4};
    vector<int> nums102 = {5, 6, 7, 8};
    sol.testMedian(nums101, nums102, 4.5);
    vector<int> nums111 = {1, 2, 3, 4, 5};
    vector<int> nums112 = {5, 6, 7, 8};
    sol.testMedian(nums111, nums112, 5);
    vector<int> nums131 = {1, 2, 3, 4, 5};
    vector<int> nums132 = {5, 6, 7, 8, 9};
    sol.testMedian(nums131, nums132, 5);
    vector<int> nums141 = {5};
    vector<int> nums142 = {};
    sol.testMedian(nums141, nums142, 5);
    sol.testMedian(nums142, nums141, 5);
    vector<int> nums151 = {0};
    vector<int> nums152 = {5};
    sol.testMedian(nums151, nums152, 2.5);
    sol.testMedian(nums152, nums151, 2.5);
    vector<int> nums161 = {1, 2};
    vector<int> nums162 = {3, 4, 5, 6, 7, 8, 9};
    sol.testMedian(nums161, nums162, 5);
    sol.testMedian(nums162, nums161, 5);
    vector<int> nums171 = {2};
    vector<int> nums172 = {1, 3};
    sol.testMedian(nums171, nums172, 2);
    sol.testMedian(nums172, nums171, 2);
    vector<int> nums181 = {3};
    vector<int> nums182 = {1, 2, 4};
    sol.testMedian(nums181, nums182, 2.5);
    sol.testMedian(nums182, nums181, 2.5);
    vector<int> nums191 = {1};
    vector<int> nums192 = {2, 3, 4};
    sol.testMedian(nums191, nums192, 2.5);
    sol.testMedian(nums192, nums191, 2.5);
    vector<int> nums201 = {1, 4};
    vector<int> nums202 = {2, 3, 5};
    sol.testMedian(nums201, nums202, 3);
    sol.testMedian(nums202, nums201, 3);
    vector<int> nums211 = {4, 5};
    vector<int> nums212 = {1, 2, 3};
    sol.testMedian(nums211, nums212, 3);
    sol.testMedian(nums212, nums211, 3);
    vector<int> nums221 = {1};
    vector<int> nums222 = {2};
    sol.testMedian(nums221, nums222, 1.5);
    sol.testMedian(nums222, nums221, 1.5);
    vector<int> nums231 = {6, 7};
    vector<int> nums232 = {1, 2, 3, 4, 5, 8};
    sol.testMedian(nums231, nums232, 4.5);
    sol.testMedian(nums232, nums231, 4.5);
    vector<int> nums241 = {1, 5};
    vector<int> nums242 = {2, 3, 4, 6};
    sol.testMedian(nums241, nums242, 3.5);
    sol.testMedian(nums242, nums241, 3.5);
    vector<int> nums251 = {1, 5, 6};
    vector<int> nums252 = {2, 3, 4, 7, 8, 9, 10};
    sol.testMedian(nums251, nums252, 5.5);
    sol.testMedian(nums252, nums251, 5.5);
    vector<int> nums261 = {2};
    vector<int> nums262 = {1, 3, 4};
    sol.testMedian(nums261, nums262, 2.5);
    sol.testMedian(nums262, nums261, 2.5);
    return 0;
}
