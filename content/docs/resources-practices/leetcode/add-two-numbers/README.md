---
title: "Add Two Numbers"
date: 2015-07-10
weight: 2
description: >
  [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/); Tag: `Linked List`, `Math`; Difficulty: `Medium`
---

## Description
You are given two linked lists representing two non-negative numbers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

**Input**: (2 -> 4 -> 3) + (5 -> 6 -> 4)
**Output**: 7 -> 0 ->8

## Analysis

Add from left to right one by one, remember add the carray(sum/10);
if one is empty, then continue add the rest one.

## Solution

+ [AddTwoNumbers.java](AddTwoNumbers.java)
+ [AddTwoNumbers.cpp](AddTwoNumbers.cpp)
+ [AddTwoNumbers.py](AddTwoNumbers.py)