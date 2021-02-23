def isPalindrome(x)
  if x < 0
    return false
  end
  k = 1
  while x/k >= 10
    k *= 10
  end
  while x/k == x%10
    x = x - (x/k)*k
    x /= 10
    k /= 100
    if k <= 1
      return true
    end
  end
  return false
end

nums = [
  0, 1, 9, # less than 10
  -2, -101, # negtive
  101, 1001, 121, 1221, # old and even
  10, 100, 100101 # not palindrom
]
results = [
  true, true, true, # less than 10
  false, false, # negtive is not palindrome
  true, true, true, true, # old and even
  false, false, false
]
count = nums.length
failed = 0
for i in 0..count-1
  result = isPalindrome(nums[i])
  if result != results[i]
    failed += 1
    puts "Test: #{nums[i]}, expect: #{results[i]}, while returned:  #{result}"
  end
end
puts "Test #{count} cases, #{count-failed} success, #{failed} failed."
