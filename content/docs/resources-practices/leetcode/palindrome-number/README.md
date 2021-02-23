---
title: "Palindrome number"
date: 2015-07-13
weight: 9
description: >
  [Palindrome number](https://leetcode.com/problems/palindrome-number/); Tags: `Math`; Difficulty: `Easy`
---

## Description

Determine whether an integer is a palindrome. Do this without extra space.

## Analysis

### Reverse Number

To determine whether an integer is a palndrome, we can reverse the integer first, then check if they are equals.
Refer to [Reverse Integer](../reverse-integer/)

Test Cases: positive, negtive, overflow?

Negtive number is obvious not a palindrome;
Will a number equals to its reversed overflow number?

### Check if `ith` number equals to the `n-ith` number

Another method is to check if the first number equals to the last number, and the `ith` number equals to the `n-ith` number.

But this is an integer, not a string, how can we get the `ith` and `n-ith` number.

## Solution

+ [PalindromeNumber.java](PalindromeNumber.java)
+ [PalindromeNumber.c](PalindromeNumber.c)
+ [PalindromeNumber.cpp](PalindromeNumber.cpp)
+ [PalindromeNumber.py](PalindromeNumber.py)
+ [PalindromeNumber.rb](PalindromeNumber.rb)
