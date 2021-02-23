---
title: "Regular Expression Matching"
date: 2015-07-15
weight: 10
description: >
  [Regular Expression Matching](https://leetcode.com/problems/regular-expression-matching/); Tags: `Dynamic Programming`, `Backtracing`, `String`; Difficulty: `Hard`
---

## Description

Implement regular expression matching with support for `'.'` and `'*'`.


`'.'` Matches any single character.
`'*'` Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:

    bool isMatch(const char *s, const char *p)

Some examples:

    isMatch("aa","a") → false
    isMatch("aa","aa") → true
    isMatch("aaa","aa") → false
    isMatch("aa", "a*") → true
    isMatch("aa", ".*") → true
    isMatch("ab", ".*") → true
    isMatch("aab", "c*a*b") → true

## Solution

+ [RegularExpressionMatching.java](RegularExpressionMatching.java)
+ [RegularExpressionMatching.c](RegularExpressionMatching.c)
+ [RegularExpressionMatching.cpp](RegularExpressionMatching.cpp)