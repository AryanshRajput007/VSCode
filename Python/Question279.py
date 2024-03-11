import math

my_list = []
a = 12
temp = a
while temp >= 1:
    temp = math.sqrt(temp)
    print(temp)
    my_list.append(temp)
    
print(my_list)