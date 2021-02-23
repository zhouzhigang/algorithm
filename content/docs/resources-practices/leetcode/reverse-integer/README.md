---
title: "Reverse Integer"
date: 2015-07-12
weight: 7
description: >
  [Reverse Integer](https://leetcode.com/problems/reverse-integer/); Tags: `Math`; Difficulty: `Easy`
---

## Description

Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

## Analysis

The reverse logic is very simple

    result = 0
    while x != 0
        result = result * 10 + x % 10
        x /= 10

But the question is it might overflow when multiple 10 in the last loop.
We need check if will overflow or not.

## Solution

+ [ReverseInteger.java](ReverseInteger.java)
+ [ReverseInteger.c](ReverseInteger.c)
+ [ReverseInteger.cpp](ReverseInteger.cpp)
+ [ReverseInteger.py](ReverseInteger.py)
+ [ReverseInteger.rb](ReverseInteger.rb)