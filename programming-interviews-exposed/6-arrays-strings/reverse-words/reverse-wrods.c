#include <stdlib.h>
#include <string.h>
#include <stdio.h>

void reverseString(char* str, int start, int end);

void reverseWords(char* str) {
    int start = 0;
    int end = 0;
    int length = strlen(str);

    // reverse whole string
    reverseString(str, start, length - 1);

    while (end <= length) {
        while (str[end] != ' ') { end++; }
        printf("%d, %d", start, end);
        // reverse each word
        reverseString(str, start, end);
        start = end + 1;
        while (str[start+1] == ' ') { start ++; }
    }

}

void reverseString(char* str, int start, int end) {
    char temp;
    int i, j;
    for (i = start, j= end; i < j; i++, j--) {
        temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}

int main(int argc, char* argv[]) {
    char* strs[] = {
        "One",
        "Two words",
        "Do or do not, there is no try."
    };

    char* results[] = {
        "One",
        "words Two",
        "try. no is there not, do or Do"
    };

    int count = 3;
    int failed = 0;
    int i;
    for (i = 0; i < count; i++) {
        reverseString(strs[i], 0, strlen(strs[i]));
        // reverseWords(strs[i]);
        if (strcmp(strs[i], results[i]) != 0) {
            failed++;
            printf("Excpect: %s, while returned: %s\n", results[i], strs[i]);
        }
    }
    printf("Test %d cases, %d success, %d failed\n", count, count-failed, failed);
}

