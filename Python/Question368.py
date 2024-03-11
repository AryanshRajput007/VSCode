my_list = [3, 7]
result = []
for i in range(len(my_list)):
    count = 0  # Reset count to 0 at the beginning of each iteration
    if i == 0:
        result.append(my_list[i])
    else:
        key = my_list[i]
        for j in range(len(result)):
            if key % result[j] == 0:
                count += 1
        if count == len(result):
            result.append(key)
print(result)



# my_list = [1,2,4,8]
# result = []
# temp = 0
# if (len(my_list) == 0):
#     print(result)
# for i in range(0, len(my_list), 2):
#     if (my_list[i] % my_list[i + 1] == 0) or (my_list[i + 1] % my_list[i] == 0):
#         result.append(my_list[i])
#         result.append(my_list[i + 1])
#         temp += 1
#         break
# if(temp == 0):
#     if (len(my_list) <= 2):
#         result.append(my_list[0])
#         print(result)
#         exit()
# print(result)


#my_list = [1, 2]
# if(len(my_list) ==2 and (my_list[1] % my_list[0] == 0 or my_list[0] % my_list[1] == 0)):
#     print(my_list)
#     exit()
# result = []
# for i in range(len(my_list), 2):
#     if(my_list[i] % my_list[i + 1] == 0):
#         result.append(my_list[i])
#         result.append(my_list[i + 1])
# if result:
#     print(result)
#     exit()
# else:
#     result.append(my_list[0])
# print(result)