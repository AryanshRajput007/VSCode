def group_anagrams(words):
    anagram_groups = {}

    for word in words:
        # Sorting the characters of the word to use it as a key
        sorted_word = ''.join(sorted(word))

        # If the sorted word is already a key in the dictionary, append the word to its list
        if sorted_word in anagram_groups:
            anagram_groups[sorted_word].append(word)
        else:
            # If the sorted word is not a key, create a new list with the word as its first element
            anagram_groups[sorted_word] = [word]

    return list(anagram_groups.values())

# Test case
words = ["eat", "tea", "tan", "ate", "nat", "bat"]
result = group_anagrams(words)
print("Anagram groups:")
count = 0
for group in result:
    count += 1
print(count)