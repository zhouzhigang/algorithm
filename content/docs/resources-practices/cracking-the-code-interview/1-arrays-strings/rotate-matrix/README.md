---
title: "Rotate Matrix"
date: 2015-07-25
weight: 6
description: >
  Rotate Matrix
---

Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees.

Can you do this in place?


## Analysis

Suppose we rotate by clockwise, counter-clockwise is the same.

Start from easy example

    0   1       2   0       0   1   2       6   3   0
    2   3       3   1       3   4   5       7   4   1
                            6   7   8       8   5   2


General condition

    0   1   2   ...  N-1            [i][j]
    N   N+1 N+2 ...  2N-1                       [k-j][i]
    .
    .
    .                       [k-i][k-j]
    (N-1)N      ...  NN-1                   [j][k-i]


## Solution

+ [RotateMatrix.java](RotateMatrix.java)
