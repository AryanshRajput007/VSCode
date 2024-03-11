def arrange_by_frequency(string):
    # Step 1: Count the frequency of each character manually
    frequency_counter = {}
    for char in string:
        if char in frequency_counter:
            frequency_counter[char] += 1
        else:
            frequency_counter[char] = 1

    # Step 2: Sort the characters based on their frequencies
    sorted_characters = sorted(frequency_counter.items(), key=lambda x: x[1], reverse=True)

    # Step 3: Construct the arranged string
    arranged_string = ''.join(char * freq for char, freq in sorted_characters)

    return arranged_string

# Example usage:
input_string = "tree"
arranged = arrange_by_frequency(input_string)
print("Arranged string by frequency:", arranged)
