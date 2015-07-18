#include <stdbool.h>    // bool
#include <stdio.h>      // printf

bool isMatch(char* s, char* p) {
    printf("s: %s, p: %s\n", s, p);
    // recursive exit condition
    if (*p == '\0') { 
        return *s == '\0';
    }
    // check if next char is "*"
    if (*(p+1) == '*') {
        do {
            if(isMatch(s, p+2)) { return true; }
        } while (*s != '\0' && (*s++ == *p || *p == '.'));
    }
    // compare next substring if next char is not "*"
    if (*s != '\0' && (*p == '.' || *p == *s)) {
        return isMatch(s+1, p+1);
    }
    return false;
}

int main(int argc, char *argv[]) {
     char* strs[] = {
         "", "", // empty
        "aa", "a",
        "aa", "aa",
        "aaa", "aa",
        "aaa", "aaa",
        "aa", "a*",
        "aa", ".*",
        "ab", ".*",
        "aab", "c*a*b*",
        "abcd", "d*"
    };
    bool results[] = {
        true, // empty
        false,
        true,
        false,
        true,
        true,
        true,
        true,
        true,
        false
    };

    int count = sizeof(results)/sizeof(results[0]);
    int failed = 0;
    bool result;
    int i;
    for (i = 0; i < count; i++) {
        result = isMatch(strs[2*i], strs[2*i+1]);
        if (result != results[i]) {
            failed++;
            printf("Test string: %s, pattern: %s, expect: %d, while returned: %d\n.", strs[2*i], strs[2*i+1], results[i], result);
        }
    }
    printf("Test %d cases: %d success, %d failed\n.", count, (count - failed), failed);
    return 0;
}

