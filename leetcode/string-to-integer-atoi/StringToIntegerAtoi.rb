#!/usr/bin/ruby
#
# Copyright (c) 2015 zzhou
#
# String to Integer (atoi).
#
def myAtoi(str)
  len = str.length
  res = 0
  isNegtive = false
  base = 10
  i = 0
  # skip whitespace
  while i < len && str[i] =~ /\s/
    i += 1
  end
  if i == len
    return 0
  end
  # check positive or negtive symbol
  if str[i] == '+' || str[i] == '-'
    if str[i] == '-'
      isNegtive = true
    end
    i += 1
  end
  # calculate int value 
  while i < len && str[i] =~ /[0-9]/
    res = res * base + (str[i].ord- '0'.ord)
    i += 1
  end

  if isNegtive
    res = -res < -0x80000000 ? -0x80000000 : -res
  else
    res = res > 0x7fffffff ? 0x7fffffff : res
  end
end

# main method
strs = [
  "", "   ", # only contains space
  "123", "+123", "-123", # with positive or negtive symbol
  "-+123", "+-123", "--123", # with mutiple +/- symbols
  "   123", "-12 3", " +123", # with space
  "123juk", "123abcdefg", # with junk characters
  "2147483648", "-2147483649", # overflow
  "2147483647", "-2147483647", # boundry, not overflow
  "21474836300", "-21474836300" # overflow
]
results = [
  0, 0, # only space
  123, 123, -123, # with negtive symbol
  0, 0, 0, #mutiple +/-
  123, -12, 123, # skip prefix white space
  123, 123, # ignore junk letter
  2147483647, -2147483648, # overflow
  2147483647, -2147483647, # not overflow
  2147483647, -2147483648 # overflow
]
count = strs.length
failed = 0
for i in 0..count-1
  result = myAtoi(strs[i])
  if result != results[i]
    failed += 1
    puts "Test: #{strs[i]}, expect: #{results[i]}, while returned: #{result}"
  end
end
puts "Test: #{count} cases, #{count-failed} success, #{failed} failed."
