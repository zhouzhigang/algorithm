#!/usr/bin/env ruby
#
# Copyright (c) 2015 zzhou
#

def maxArea(height)
  max = 0
  i = 0
  j = height.length - 1
  while i < j
    if height[i] < height[j]
      tmp = height[i] * (j - i)
      i += 1
    else
      tmp = height[j] * (j - i)
      j -= 1
    end
    if tmp > max
      max = tmp
    end
  end
  return max
end

# main test
heights = [
  [1, 2, 3, 4, 5],
  [1, 3, 5, 2, 4]
]
results = [
  6,
  9
]
count = results.length
failed = 0
for i in 0..count-1
  result = maxArea(heights[i])
  if result != results[i]
    failed += 1
    puts "Test: #{heights[i]}, expect: #{results[i]}, while returned:  #{result}"
  end
end
puts "Test #{count} cases, #{count-failed} success, #{failed} failed."
