package Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Question49 {
    public static List<List<String>> groupAnagram(String[] words) {
        List<List<String>> answerList = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String word : words) {
            String sortedWord = sorted(word);
            map.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(word);
        }
        for (Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        answerList.addAll(map.values());
        return answerList;
    }

    public static String sorted(String word) {
        char[] charArray = word.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    public static void main(String[] args) {
        String[] words = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groupedAnagrams = groupAnagram(words);

        for (List<String> group : groupedAnagrams) {
            System.out.println(group);
        }
    }
}
