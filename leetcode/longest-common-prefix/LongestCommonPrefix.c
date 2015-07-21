#include <string.h> // strlen
#include <stdlib.h> // malloc
#include <stdio.h>  //printf

char* longestCommonPrefix(char** strs, int strsSize) {
    if (strsSize == 0) return "";
    if (strsSize == 1) return strs[0];
    int minLen = strlen(strs[0]);
    int i, j;
    for (i = 1; i < strsSize; i++) {
        if (minLen > strlen(strs[i])) {
            minLen = strlen(strs[i]);
        }
    }
    char* s = (char *)malloc(minLen*sizeof(char));
    char ch;
    for (j = 0; j < minLen; j++) {
        ch = strs[0][j];
        for (i = 1; i < strsSize; i++) {
            if(ch != strs[i][j]) {
                s[j] = '\0';
                return s;
            }
        }
        s[j] = ch;
    }
    s[j] = '\0';
    return s;
}

int main(int argc, char *argv[]) {
    char* s1[] = {}; // empty array
    char* s2[]= {"abcd"}; // only one string
    char* s3[] = {"a", "abcd", "acd", "abd"};
    char* s4[] = {"abc", "abcd", "abd", "abde"};
    char* s5[] = {"abc", "abd", "bcd"}; // no common prefix
    char** strs[] = { s1, s2, s3, s4, s5 };
    int strsSizes[] = { 0, 1, 4, 4, 3 };
    char* results[] = {
        "", // empty string
        "abcd", // only one string
        "a",
        "ab",
        "" // no common prefix
    };
    int count = sizeof(strsSizes)/sizeof(strsSizes[0]);
    int failed = 0;
    char* result;
    int i;
    for (i = 0; i < count; i++) {
        result = longestCommonPrefix(strs[i], strsSizes[i]);
        if (strcmp(result, results[i]) != 0) {
            failed++;
            printf("Test: %d, expect: %s, while returned: %s\n", i, results[i], result);
        }
    }
    printf("Test %d cases: %d success, %d failed\n.", count, (count - failed), failed);
    return 0;
}
