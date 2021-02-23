---
title: "Two Sum"
date: 2015-06-27
weight: 1
description: >
  [Two Sum](https://leetcode.com/problems/two-sum/); Tag `Array`, `Hash`, `Sort`; Difficulty: `Medium`
---


## Description
Give an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers(both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

**Input**: numbers = {2, 7, 11, 15}, target = 9
**Output**: index1 = 1, index2 = 2

## Analysis
### Test Cases


## Solution

[Java](TwoSum.java) [C++](TwoSum.cpp) [Python](TwoSum.py) [Ruby](TwoSum.rb)

### Brute fore - O(n^2) runtime, O(1) space

The brute force approach is simple.
Loop through each element `x` and find if there is another value that equals to `target - x`.
As finding another value requires looping through the rest of array, it's runtime complexity is O(n^2).

    for i = 0..length-1
        for j = i+1..length
            if nums[j] = target - nums[i]
                return [i+1, j+1]


### Hash map/table - O(n) runtime, O(n) space

Reduce the runtime complexity of looking up a value to O(1) using a hash map that maps a value to its index.

    for i = 0..length-1
        j = map.get(target - nums[i])
        if j != null
            return [i+1, j+1]
        map.put(nums[i])

#### Hash/Map/Set/Dict in different languages

* Java: `Map<K, V>`, `HashMap<K, V>`
    - `map.containsKey`
    - `map.get(key)`
    - `map.put(key) = val`

* C++: `map<K, V>`, `map<K, V>::iterator`
    - `map.find(key)`
    - `map[key] = val`

* Python: dictionary `{}`
    - `dict.get(key)`
    - `dict[key] = val`

* Ruby: hash `{}`
    - `hash.iscontains?(key)`
    - `hash.get()`
    - `hash[key] = value`
    - `hash.each { |key, val| }`, `hash.each { |pair| }`, `hash.each_key { |key| }`, `hash.each_value { |val| }`

### Sort the array - O(nlgn) runtime, O(n) space

Use an extra array to save the sorted index
    
    idxs = 0..length-1
    sort idxs according the value in nums

#### Array in different languages
* Java: 
    - declaration: `int[] arr`(more clear), `int arr[]`(c style)
    - defination: 
    - length: `arr.length`(attribute, not a method)
    - loops: `for`

* C++:
    - declaration: `int arr[size]`, `vector<int> vec`(STL)
    - length: `vec.size()`
    - loops: `for`
    - get: `arr[i]`, `vec[i]`
    - set: `arr[i] = val`, `vec.push_back(val)`

* Python:
    - declaration: `{}`
    - length: `len(arr)`
    - loops before 2.3: `for i in range(len(foo))`
    - loops after 2.3: `for i, val in enumerate(foo)`

* Ruby:
    - declartion: `{}`
    - length: `arr.length`
    - loops: `for`, `arr.each {|val| }`, `arr.each_with_index {|val, i| }` 

#### Sort method in different languages

## Solution

+ [TwoSum.java](TwoSum.java)
+ [TwoSum.cpp](TwoSum.cpp)
+ [TwoSum.py](TwoSum.py)
+ [TwoSum.rb](TwoSum.rb)

## Further More
* What if the array aleady sorted?

