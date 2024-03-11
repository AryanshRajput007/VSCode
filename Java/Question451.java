package Java;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question451 {
    public static void main(String[] args) {
        String s = "Tree";
        HashMap<Character, Integer> map = new HashMap<>();
        
        // Count occurrences of each character and store in the map
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // Sort the map entries by frequency in descending order
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());
        Collections.sort(entryList, (a, b) -> b.getValue().compareTo(a.getValue()));
        
        // Construct the string with characters sorted by frequency
        StringBuilder sortedString = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : entryList) {
            char c = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                sortedString.append(c);
            }
        }
        
        // Print the sorted string
        System.out.println("Sorted String: " + sortedString.toString());
    }
}
