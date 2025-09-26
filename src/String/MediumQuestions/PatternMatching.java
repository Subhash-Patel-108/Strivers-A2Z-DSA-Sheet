package String.MediumQuestions;
import java.util.* ;

//Problem Link: https://www.naukri.com/code360/problems/pattern-matching_1229403?interviewProblemRedirection=true&practice_topic%5B%5D=Strings&sort_entity=company_count&sort_order=DESC&leftPanelTabValue=SUBMISSION
public class PatternMatching {
    public static class Solution {
        public static boolean isPatternMatching(String pattern, ArrayList<String> words) {
            if (pattern == null || words == null) {
                return false;
            }

            if (pattern.length() != words.size()) {
                return false;
            }

            Map<Character, String> charToWord = new HashMap<>();
            Map<String, Character> wordToChar = new HashMap<>();

            for (int i = 0; i < pattern.length(); i++) {
                char c = pattern.charAt(i);
                String word = words.get(i);

                // Check char -> word mapping
                if (charToWord.containsKey(c)) {
                    if (!charToWord.get(c).equals(word)) {
                        return false; // Character maps to different word
                    }
                } else {
                    charToWord.put(c, word);
                }

                // Check word -> char mapping (bijection)
                if (wordToChar.containsKey(word)) {
                    if (wordToChar.get(word) != c) {
                        return false; // Word maps to different character
                    }
                } else {
                    wordToChar.put(word, c);
                }
            }

            return true;
        }
    }
    public static void main(String[] args) {

    }
}
