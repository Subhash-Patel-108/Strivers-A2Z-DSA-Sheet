package String.MediumQuestions;

public class SumOfBeautyOfAllSubstrings {
    public static class Solution {
        public int beautySum(String s) {
            int totalBeauty = 0;
            int n = s.length();

            // Outer loop selects start of substring
            for (int i = 0; i < n; i++) {
                int[] freq = new int[26]; // Frequency of letters in substring

                // Inner loop expands substring until end
                for (int j = i; j < n; j++) {
                    freq[s.charAt(j) - 'a']++; // increment frequency of current char

                    int maxFreq = 0;
                    int minFreq = Integer.MAX_VALUE;

                    // Find max and min frequency in current substring
                    for (int f : freq) {
                        if (f > 0) {
                            maxFreq = Math.max(maxFreq, f);
                            minFreq = Math.min(minFreq, f);
                        }
                    }

                    totalBeauty += maxFreq - minFreq; // Add beauty for this substring
                }
            }
            return totalBeauty;
        }
    }

    public static void main(String[] args) {

    }
}
