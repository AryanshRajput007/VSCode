n = 5
# s = bin(n)
# print(s[2:])
# my_list = []
# while(n >= 0):
#     my_list.append(bin(n)[2:])
#     n -= 1
# result = []
# my_list = my_list[::-1]
# for element in my_list:
#     count = 0
#     for i in range(len(element)):
#         if(element[i] == '1'):
#             count += 1
#     result.append(count)
# print(result)
result = [0] * (n + 1)
for i in range(1, n + 1):
    result[i] = result[i >> 1] + (i & 1)
    print(i >> 1)
    print(i & 1)
print(result)