# hash(map) solution.
def two_sum(nums, target)
  hash = {}
  nums.each_with_index do |val, i|
    if hash.include?(val)
      return [hash[val] + 1, i + 1]
    end
    hash[target - val] = i;
  end
  nil
end

def two_sum_sort(nums, target)
  idxs = Array.new(nums.length){ |i| i}
  # idxs = 1.step(nums.length, 1).to_a # enumerators in Ruby 1.8.7+
  idxs.sort! { |x, y| nums[x] <=> nums[y]}
  low = 0
  high = nums.length - 1;
  while low < high
    i = idxs[low]
    j = idxs[high]
    sum = nums[i] + nums[j]
    if sum > target
        high -= 1
    elsif sum < target
        low += 1
    else
      if i > j
        return [j + 1, i + 1]
      else
        return [i + 1, j + 1]
      end
    end
  end
end
# main method

p two_sum([3, 2, 9, 7, 11, 13], 9)
p two_sum([3, 2, 9, 7, 11, 13], 8)
p two_sum_sort([3, 2, 9, 7, 11, 13], 9)
p two_sum_sort([3, 2, 9, 7, 11, 13], 8)

