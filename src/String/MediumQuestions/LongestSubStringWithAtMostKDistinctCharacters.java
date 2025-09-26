package String.MediumQuestions;
//Problem Link: https://www.naukri.com/code360/problems/longest-sub-string-with-at-most-k-distinct-characters_699944?interviewProblemRedirection=true&practice_topic%5B%5D=Strings&sort_entity=company_count&sort_order=DESC&leftPanelTabValue=SUBMISSION
public class LongestSubStringWithAtMostKDistinctCharacters {
    public static class Solution {
        public static int getLengthOfLongestSubstring(int k, String s) {
            //Edge case
            if(s == null || s.isEmpty()) {
                return 0 ;
            }

            int maxLength = 0 ;

            int[] freq = new int[26] ;
            int uniqueCharacter = 0 ;
            int left = 0 , right = 0 ;

            while (right < s.length()) {
                char currentChar = s.charAt(right) ;
                freq[currentChar - 'a'] ++ ;

                if(freq[currentChar - 'a'] == 1) {
                    uniqueCharacter ++ ;
                }

                while (uniqueCharacter > k) {
                    char leftChar = s.charAt(left) ;
                    freq[leftChar - 'a'] -- ;

                    if (freq[leftChar - 'a'] == 0) {
                        uniqueCharacter -- ;
                    }
                    left++ ;
                }

                int currentLength = right - left + 1 ;
                maxLength = Math.max(maxLength , currentLength ) ;
                right++ ;
            }

            return maxLength ;
        }
    }
    public static void main(String[] args) {

    }
}
