package Sorting.HardQuestions;
import java.security.Permission;
import java.util.* ;

//Problem Link : https://www.naukri.com/code360/problems/rearrange-string_982765?interviewProblemRedirection=true&practice_topic%5B%5D=Sorting&sort_entity=company_count&sort_order=DESC
public class RearrangeString {

    public static class Solution {
        // Class to store character and its frequency
        private static class Pair {
            public char ch;
            public int freq;

            // Constructor to initialize character and frequency
            public Pair(char ch, int freq) {
                this.ch = ch;
                this.freq = freq;
            }
        }

        public static String reArrangeString(String s) {
            // Handle edge case: null or string length <= 1 returns original string
            if (s == null || s.length() <= 1) {
                return s;
            }

            // Initialize HashMap to store character frequencies
            HashMap<Character, Integer> charToFreqMap = new HashMap<>();
            // Count frequency of each character
            for (char currChar : s.toCharArray()) {
                charToFreqMap.put(currChar, charToFreqMap.getOrDefault(currChar, 0) + 1);
            }

            // Initialize max heap to prioritize characters by frequency
            PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.freq - a.freq);
            // Track maximum frequency
            int maxFreq = 0;
            // Populate heap with character-frequency pairs
            for (Map.Entry<Character, Integer> entry : charToFreqMap.entrySet()) {
                maxFreq = Math.max(maxFreq, entry.getValue());
                maxHeap.offer(new Pair(entry.getKey(), entry.getValue()));
            }

            // Check if rearrangement is possible (max frequency <= (length + 1)/2)
            if (maxFreq > (s.length() + 1) / 2) {
                return "not possible";
            }

            // Initialize previous pair with dummy character and zero frequency
            Pair prevPair = new Pair('S', 0);
            // Initialize StringBuilder for result
            StringBuilder ans = new StringBuilder();

            // Build result by arranging characters
            while (!maxHeap.isEmpty()) {
                // Get character with highest remaining frequency
                Pair currPair = maxHeap.poll();
                char currChar = currPair.ch;

                // Append current character to result
                ans.append(currChar);
                currPair.freq--;

                // If previous character has remaining frequency, add back to heap
                if (prevPair.freq > 0) {
                    maxHeap.offer(prevPair);
                }

                // Update previous pair to current pair
                prevPair = currPair;
            }

            // Return rearranged string
            return ans.toString();
        }
    }

    public static void main(String[] args) {

    }
}
