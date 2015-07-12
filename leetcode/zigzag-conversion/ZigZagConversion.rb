#!/usr/bin/ruby
#
# Copyright (c) 2015 zzhou
#
# ZigZag Conversion
#
# https://leetcode.com/problems/zigzag-conversion/
#
def convert(s, num_rows)
  if num_rows <= 1
    return s
  end
  result = ""
  len = s.length
  base = (num_rows - 1) * 2
  for i in 0..num_rows-1
    idx = i
    j = 0
    while idx < len
      result += s[idx]
      if i == 0 || i == num_rows - 1
        idx += base
      else
        j += 1
        idx = base * j - idx
      end
    end
  end
  return result
end

# main method
strs = [
  "PAYPALISHIRING", "ABCDEF",
  "0123456", "0123456789", "0123456789"
]
rows = [
  3, 3,
  2, 3, 4
]
results = [
  "PAHNAPLSIIGYIR", "AEBDFC",
  "0246135", "0481357926", "0615724839"
]
count = strs.length
failed = 0
for i in 0..count-1
  result = convert(strs[i], rows[i])
  if results[i] != result
    failed += 1 # doesn't exist self increment operator(++)
    puts "Test: #{strs[i]}, numRows: #{rows[i]}, expect: #{results[i]}, while returned: #{result}"
  end
end
puts "Test #{count} cases, #{count} success, #{failed} failed"
