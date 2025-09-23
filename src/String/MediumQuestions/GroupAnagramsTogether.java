package String.MediumQuestions;
import java.util.* ;
public class GroupAnagramsTogether {
    public static class Solution {
        public static ArrayList<ArrayList<String>> groupAnagramsTogether(ArrayList<String> strings) {
            // Handle edge case: null or empty list
            if (strings == null || strings.isEmpty()) {
                return new ArrayList<>();
            }

            // Map to store sorted string as key and list of anagrams as value
            HashMap<String, ArrayList<String>> anagramGroups = new HashMap<>();

            // Group strings by their sorted character sequence
            for (String str : strings) {
                // Convert string to char array and sort
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                // Use sorted characters as key
                String sortedKey = String.valueOf(chars);

                // Add string to its anagram group
                anagramGroups.computeIfAbsent(sortedKey, k -> new ArrayList<>()).add(str);
            }

            // Collect all anagram groups into result
            ArrayList<ArrayList<String>> result = new ArrayList<>(anagramGroups.values());

            // Return list of anagram groups
            return result;
        }
    }
    public static void main(String[] args) {

    }
}
