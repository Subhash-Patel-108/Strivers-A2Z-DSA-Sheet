package Graph.ProblemOnBFSAndDFS;

import java.util.*;

public class WordLadder {
    public static class Solution {
        public int wordLadderLength(String startWord, String targetWord, String[] wordList) {
            // Handle edge cases: null or empty word list
            if (wordList == null || wordList.length == 0) {
                return 0;
            }

            // Create a set for O(1) lookup of words in wordList
            Set<String> dictionary = new HashSet<>();
            Collections.addAll(dictionary, wordList);
            // Check if targetWord exists in the dictionary
            if (!dictionary.contains(targetWord)) {
                return 0;
            }
            // Remove startWord from dictionary to avoid revisiting
            dictionary.remove(startWord);

            // Initialize queue for BFS
            Queue<String> queue = new LinkedList<>();
            // Add starting word to queue
            queue.offer(startWord);

            // Initialize transformation count (level represents length of ladder)
            int transformations = 1;

            // Process words level by level using BFS
            while (!queue.isEmpty()) {
                // Get the number of words at the current level
                int levelSize = queue.size();
                // Flag to track if any valid transformations are found
                boolean foundNextLevel = false;

                // Process all words at the current level
                while (levelSize-- > 0) {
                    // Get the next word from the queue
                    String currentWord = queue.poll();
                    // If target word is found, return the number of transformations
                    if (currentWord.equals(targetWord)) {
                        return transformations;
                    }

                    // Try replacing each character position
                    for (int i = 0; i < currentWord.length(); i++) {
                        // Create a modifiable copy of the current word
                        StringBuilder nextWord = new StringBuilder(currentWord);
                        // Try all lowercase letters at the current position
                        for (char ch = 'a'; ch <= 'z'; ch++) {
                            nextWord.setCharAt(i, ch);
                            String newWord = nextWord.toString();
                            // If the new word is in the dictionary, add it to the queue
                            if (dictionary.contains(newWord)) {
                                queue.offer(newWord);
                                // Mark dictionary word as used by removing it
                                dictionary.remove(newWord);
                                foundNextLevel = true;
                            }
                        }
                    }
                }

                // Increment transformations only if valid words were found for the next level
                if (foundNextLevel) {
                    transformations++;
                }
            }

            // Return 0 if no transformation sequence is found
            return 0;
        }
    }
    public static void main(String[] args) {

    }
}
