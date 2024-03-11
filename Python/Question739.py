temp = [73,74,75,71,69,72,76,73]
result = []
for i in range(0, len(temp)):
    for j in range(i, len(temp)):
        if temp[i] < temp[j]:
            result.append(j - i)