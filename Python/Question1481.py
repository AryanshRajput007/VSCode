from collections import Counter

def findLeastNumOfUniqueInts(arr, k):

    #TODO
    count = Counter(arr)

    unique = len(count)

    countArray = [0] * (max(count.values()) + 1)
    for key in count:
        countArray[count[key]] += 1
        
    for i in range(1, len(countArray)):
        if countArray[i] != 0:
            remove = k // i
            if remove == 0:
                break
            else:
                remove = min(remove, countArray[i])
                unique -= remove
                k -= remove * i

    return unique


arr = [4, 3, 1, 1, 3, 3, 2]
print(max(Counter(arr).values()) + 1)
k = 3
print(findLeastNumOfUniqueInts(arr, k)) 
print(3 // 2)
