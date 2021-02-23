---
title: "Median of Two Sorted Arrays"
date: 2015-07-07
weight: 4
description: >
  [Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/); Tags: `Divide and Conquer`, `Array`, `Binary Search`; Difficulty: `Hard`
---

## Description
There are two sorted arrays `nums1` and `nums2` of size m and n respectively.
Find the median of the two sorted arrays.
The overall run time should be O(log(m+n)).

## Analysis

What is median?

Take one sorted array for example.

    if n % 2 == 0
        median = (a[n/2] + a[n/2+1]) / 2;
    else
        median = a[n/2];

So the question became find the number which order is (m+n)/2 and (m+n)/2+1.

    if nums1[m/2] > nums2[n/2] // means the first n/2 of nums2 will in the left of nums1
        find in nums1[0..m/2] and nums2[n/2..n]
    else if nums1[m/2] < nums[n/2] // means the first m/2 of nums1 wiil in the left of nums2
        find in nums1[m/2, m] and nums2[0..n/2]
    else // equal

## Solution

+ [MedianOfTwoSortedArrays.java](MedianOfTwoSortedArrays.java)
+ [MedianOfTwoSortedArrays.c](MedianOfTwoSortedArrays.c)
+ [MedianOfTwoSortedArrays.cpp](MedianOfTwoSortedArrays.cpp)
+ [MedianOfTwoSortedArrays.py](MedianOfTwoSortedArrays.py)
