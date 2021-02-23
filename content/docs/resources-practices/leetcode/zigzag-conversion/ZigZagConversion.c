#include <string.h> // strlen, strcmp
#include <malloc.h> // malloc
#include <stdio.h>  // printf

char* convert(char* s, int numRows) {
    if (numRows <= 1) { return s; }
    int len = strlen(s);
    char* result = (char*)malloc((len+1) * sizeof(char)); // result
    char* p = result; // used for move next
    int base = (numRows - 1) * 2; // used to calculate index
    int i, idx, j;
    for (i = 0; i < numRows; i++) {
        idx = i;
        j = 0;
        while(idx < len) {
            *p++ = s[idx];
            if (i == 0 || i == numRows - 1) {
                idx = idx + base;
            } else {
                j++;
                // calculate the next index
                idx = base * j - idx;
            }
        }
    }
    *p = '\0'; // string end tag
    return result;
}
int main(int argc, char const *argv[]) {

    char* strs[] = {
        "PAYPALISHIRING", "ABCDEF",
        "0123456", "0123456789", "0123456789"
    };
    int rows[] = {
        3, 3,
        2, 3, 4
    };
    char* results[] = {
        "PAHNAPLSIIGYIR", "AEBDFC",
        "0246135", "0481357926", "0615724839"
    };
    
    int len = sizeof(rows)/sizeof(int);
    int failed = 0;
    char* result;
    int i;
    for (i = 0; i < len; i++) {
        result = convert(strs[i], rows[i]);
        if (strcmp(result, results[i]) != 0) {
            printf("Test: %s, , numRows: %d, expect: %s, while returned: %s\n", strs[i], rows[i], results[i], result);
            failed++;
        }
    }
    printf("Test %d cases, %d success, %d failed\n", len, (len-failed), failed);
}
