#include <stdlib.h> // malloc
#include <string.h> // strcmp
#include <stdio.h>  // printf

/**
 * Use 7 basic symbols.
 */
char* intToRoman_1(int num) {
    char* s = (char *)malloc(15 * sizeof(char));
    int i = 0;
    int j = 0;
    char* basic = "IVXLCDM";
    int n = 4;
    int k = 1000;
    int h = 0;
    while (n != 0) {
        h = num / k;
        switch(h) {
            case 1:
            case 2:
            case 3:
                j = h;
                while (j > 0) {
                    s[i] = basic[2*n-2];
                    i++;
                    j--;
                }
                break;
            case 4:
                s[i] = basic[2*n-2]; i++;
                s[i] = basic[2*n-1]; i++;
                break;
            case 5:
                s[i] = basic[2*n-1]; i++;
                break;
            case 6:
            case 7:
            case 8:
                j = h - 5;
                s[i] = basic[2*n-1]; i++;
                while (j > 0) {
                    s[i] = basic[2*n-2];
                    i++;
                    j--;
                }
                break;
            case 9:
                s[i] = basic[2*n-2]; i++;
                s[i] = basic[2*n]; i++;
                break;
            case 10:
                s[i] = basic[2*n]; i++;
                break;
            default:
                break;
        }
        num = num - h * k;
        k /= 10;
        n--;
    }
    s[i] = '\0';
    return s;
}


int main(int argc, char *argv[]) {

    int nums[] = {
        0, 1, 3, 5, 9, // 0 ~ 10
        10, 12, 26, 43, 50, 98, // 10 ~ 100
        100, 247, 707, 890, // 100 ~ 1000
        1000, 2350, 3458, 3999 // 1000 ~ 3999
    };

    char* results[] = {
        "", "I", "III", "V", "IX", // 0 ~ 10
        "X", "XII", "XXVI", "XLIII", "L", "XCVIII", // 10 ~ 100
        "C", "CCXLVII", "DCCVII", "DCCCXC", // 100 ~ 1000
        "M", "MMCCCL", "MMMCDLVIII", "MMMCMXCIX" // 1000 ~ 3999
    };

    int count = sizeof(nums)/sizeof(nums[0]);
    int failed = 0;
    char* result;
    int i;
    for (i = 0; i < count; i++) {
        result = intToRoman_1(nums[i]);
        if (strcmp(result, results[i]) != 0) {
            failed++;
            printf("Test: %d, expect: %s, while returned: %s\n ", nums[i] , results[i], result);
        }
    }
    printf("Test %d cases: %d success, %d failed\n.", count, (count - failed), failed);
    return 0;
}

