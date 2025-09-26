package String.EasyQuestions;
//Problem Link: https://www.naukri.com/code360/problems/most-frequent-word_981324?interviewProblemRedirection=true&practice_topic%5B%5D=Strings&sort_entity=company_count&sort_order=DESC&leftPanelTabValue=PROBLEM
import java.util.* ;
public class MostFrequentWord {

    public static class Solution {
        public static String mostFrequentWord(String textA, String textB) {
            // Handle edge case: null or empty strings
            if (textA == null || textB == null || textA.isEmpty() || textB.isEmpty()) {
                return "";
            }

            // Use TreeMap to store word frequencies (ensures lexicographical order)
            Map<String, Integer> wordFreq = new TreeMap<>();

            // Split first string into words and count frequencies
            String[] wordsA = textA.split(" ");
            for (String word : wordsA) {
                wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
            }

            // Remove words that appear in second string
            String[] wordsB = textB.split(" ");
            for (String word : wordsB) {
                wordFreq.remove(word);
            }

            // If no words remain, return "-1"
            if (wordFreq.isEmpty()) {
                return "-1";
            }

            // Find word with highest frequency (lexicographically smallest if tied)
            int maxFreq = 0;
            String resultWord = "";
            for (Map.Entry<String, Integer> entry : wordFreq.entrySet()) {
                String word = entry.getKey();
                int freq = entry.getValue();
                if (freq > maxFreq) {
                    maxFreq = freq;
                    resultWord = word;
                }
            }

            // Return the most frequent word
            return resultWord;
        }
    }
    public static void main(String[] args) {

    }
}
