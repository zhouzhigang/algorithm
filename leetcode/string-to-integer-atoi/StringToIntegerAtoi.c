#include <string.h> // strlen
#include <limits.h> // INT_MAX, INT_MIN
#include <stdio.h>  // printf

int myAtoi(char* str) {
    if (str == NULL || *str == '\0') { return 0; }
    int len = strlen(str);
    int res = 0; // result
    int isNegtive = 0;
    int base = 10; // should we consider base 2, 8 and 16?
    int maxLen = 9; // used for check overflow
    // skip white space: isWhitespace, isSpace, isSpaceChar?
    while(isspace(*str)) {
        str++;
    }
    // check if has positive or negtive symbol
    if (*str == '+' || *str == '-') {
        if (*str == '-') {
            isNegtive = 1;
        }
        str++;
    }
    // calculate int value
    while (maxLen > 0 && isdigit(*str)) {
        res = res * base + (*str - '0');
        str++;
        maxLen--;
    }
    // check overflow conditon
    while (isdigit(*str)) {
        int ch = *str - '0';
        if (isNegtive) {
            if (-res < (INT_MIN + ch) / base) {
                return INT_MIN;
            }
        } else {
            if (res > (INT_MAX - ch) / base) {
                return INT_MAX;
            }
        }
        res = res * base + ch;
        str++;
    }
    return isNegtive ? -res : res;
}

int main(int argc, char *argv[]) {

    char* strs[] = {
        "", "   ", // only contains space
        "123", "+123", "-123", // with positive and negtive symbol
        "-+123", "+-123", "--123", // with multiple +/- symbol
        "  123 ", "-12 3", " +123  ", // with space
        "123junk", "123abcdfg", // with junk character
        "2147483648", "-2147483649", // overflow
        "2147483647", "-2147483647", // not overflow
        "21474836300", "-21474836300" // another overflow
    };
    int results[] = {
        0, 0, // only space
        123, 123, -123, // with negtive symbol
        0, 0, 0, // with mutiple +/- symbol
        123, -12, 123, // skip prefix white space
        123, 123, // ignore junk letter
        2147483647, -2147483648, // overflow
        2147483647, -2147483647, // not overflow
        2147483647, -2147483648 //overflow
    };
    int count = sizeof(results)/sizeof(results[0]);
    int failed = 0;
    int result;
    int i;
    for (i = 0; i < count; i++) {
        result = myAtoi(strs[i]);
        if (result != results[i]) {
            failed++;
            printf("Test: %s, expect: %d, while returned: %d\n", strs[i], results[i], result);
        }
    }
    printf("Test %d cases, %d success, %d failed\n", count, (count-failed), failed);
}

