nums1 = [4,9,5]
nums2 = [9,4,9,8,4]
result = []

my_set = set(nums2)
print(my_set)

for ele in my_set:
    if ele in nums1:
        result.append(ele)
        
print(result)