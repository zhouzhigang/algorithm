#!/usr/bin/env ruby
#

def intToRoman(num)
  basic = "IVXLCDM"
  s = ""
  n = 4
  k = 1000
  while n!= 0
    h = num / k
    case h
    when 1..3
      j = h
      while j > 0
        s += basic[2*n-2]
        j -= 1
      end
    when 4
      s = s + basic[2*n-2] + basic[2*n-1]
    when 5..8
      s += basic[2*n-1]
      j = h - 5
      while j > 0
        s += basic[2*n-2]
        j -= 1
      end
    when 9
      s = s + basic[2*n-2] + basic[2*n]
    when 10
      s += basic[2*n]
    end
    num = num - h * k
    k /= 10
    n -= 1
  end
  return s
end

# main test
nums = [
  0, 1, 3, 5, 9, # 0 ~ 10
  10, 12, 26, 43, 50, 98, # 10 ~ 100
  100, 247, 707, 890, # 100 ~ 1000
  1000, 2350, 3458, 3999 # 1000 ~ 3999
]
results = [
  "", "I", "III", "V", "IX", # 0 ~ 10
  "X", "XII", "XXVI", "XLIII", "L", "XCVIII", # 10 ~ 100
  "C", "CCXLVII", "DCCVII", "DCCCXC", # 100 ~ 1000
  "M", "MMCCCL", "MMMCDLVIII", "MMMCMXCIX" # 1000 ~ 3999
]
count = nums.length
failed = 0
for i in 0..count-1
  result = intToRoman(nums[i])
  if result != results[i]
    failed += 1
    puts "Test: #{nums[i]}, expect: #{results[i]}, while returned:  #{result}"
  end
end
puts "Test #{count} cases, #{count-failed} success, #{failed} failed."

