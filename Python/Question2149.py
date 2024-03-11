nums = [3, 1, -2, -5, 2, -4]
stack = []
stack2 = []
result = []
for element in nums:
    if element < 0:
        stack.append(element)
    if element > 0:
        stack2.append(element)

for i in range(len(nums)//2):  # Corrected integer division
    result.append(stack2[i])
    result.append(stack[i])
print(result)
