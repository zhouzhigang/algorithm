#!/usr/bin/ruby
#
# Copyright (c) 2015 zzhou
#
# Reverse Integer
#
def reverse(x)
  res = 0
  flag = 1
  if x < 0
    flag = -1
    x = -x
  end
  while x != 0
    res = res * 10 + x % 10
    x /= 10
  end
  res *= flag
  # Ruby automatically converts integers to a large integer class when they overflow
  if res > 2147483647 || res < -2147483648
      return 0
  end
  return res
end

# main method

nums = [
  0, -0, # zero
  10, -10, # end with zero
  123, -123, # normal condition
  1000000003, -1000000003, # overlow, and sign will change
  1534236469, # overflow but sign will not change
  1463847412, -1463847412 # reverse between -2147483648 ~ 2147483647
]

results = [
  0, 0, # zero
  1, -1, # no prefix zero
  321, -321, # normal condition
  0, 0, # return 0 when overflow
  0,
  2147483641, -2147483641
]

count = nums.length
failed = 0
for i in 0..count-1
  result = reverse(nums[i])
  if result != results[i]
    failed += 1
    puts "Test: #{nums[i]}, expect: #{results[i]}, while returned: #{result}"
  end
end
puts "Test #{count} cases, #{count-failed} success, #{failed} failed"

