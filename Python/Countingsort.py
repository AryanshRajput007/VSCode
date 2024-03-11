import sys

def counting_sort(nums):
    max = -sys.maxsize - 1
    
    for element in nums:
        if(nums > max):
            max = element
    
    count = {}
    temp = 0
    for element in nums:
        for j in range(len(nums)):
            if(element > nums[j]):
                temp += 1
        count[element] = temp
    
    