# [ZigZag Conversion](https://leetcode.com/problems/zigzag-conversion/)

Difficulty: Easy

Tags: `String`

## Description
The string `"PAYPALISHIRING"` is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

    P   A   H   N
    A P L S I I G
    Y   I   R

And then read line by line: `"PAHNAPLSIIGYIR"`

Write the code that will take a string and make this conversion given a number of rows:

    string convert(string text, int nRows);

`convert("PAYPALISHIRING", 3)` should return `"PAHNAPLSIIGYIR"`.


## Analysis
    
    N=2         N=3         N=4                 N=N
    0 2 4 6     0   4   8   0     6       12    0       2(N-1)  4(N-1)    
    1 3 5       1 3 5 7 9   1   5 7    11       1     . .
                2   6       2 4   8 10          .   .   .
                            3     9             . N+1   .
                                                N       2(N-1)+N



