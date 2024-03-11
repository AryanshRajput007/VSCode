with open("C:\\Users\\Aryansh Rajput\\Dropbox\\PC\\Downloads\\file.csv", "r") as file:
    column_values1 = []
    column_values2 = []
    column_values3 = []
    for line in file:
        columns = line.strip().split(",")
        column_value1 = columns[0]
        column_value2 = columns[1]
        column_value3 = columns[2]
        column_values1.append(column_value1)
        column_values2.append(column_value2)
        column_values3.append(column_value3)

# print(column_values1)
# print(column_values2)
# print(column_values3)
for i in range(len(column_values1)):
    print(column_values1[i] + " " + column_values2[i] + " " + column_values3[i]) 