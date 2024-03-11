s = "hello"
result = ""
for i in range(len(s)):
    result[len(s) - i -1] = s[i]
print(result)