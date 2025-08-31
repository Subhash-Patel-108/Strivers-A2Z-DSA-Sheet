package String.MediumQuestions;
import java.util.* ;
public class SortCharactersByFrequency {
    public static class Solution {
        private static class Pair {
            public char ch ;
            public int freq ;

            public Pair(char ch , int freq) {
                this.ch = ch ;
                this.freq = freq ;
            }
        };

        public String frequencySort(String s) {
            //Edge case
            if(s == null || s.length() == 0) {
                return "" ;
            }

            //Step 1: Create a frequency map
            HashMap <Character , Integer> frequencyMap = new HashMap<>();
            for(char ch : s.toCharArray()) {
                frequencyMap.put(ch , frequencyMap.getOrDefault(ch , 0) + 1) ;
            }

            //Step 2: Create a priority queue
            PriorityQueue <Pair> maxHeap = new PriorityQueue<>((a , b) -> b.freq - a.freq) ;//sort in descending order

            //Step 3: Enter all the pairs into the priority queue
            for(Map.Entry<Character , Integer> entry : frequencyMap.entrySet()) {
                maxHeap.add(new Pair(entry.getKey() , entry.getValue())) ;
            }

            //Step 4: Create a sorted String from the priority queue
            StringBuilder result = new StringBuilder() ;
            while (!maxHeap.isEmpty()) {
                Pair temp = maxHeap.poll() ;
                char ch = temp.ch ;
                int freq = temp.freq ;

                for(int i = 1 ; i <= freq ; i++ ){
                    result.append(ch) ;
                }
            }

            //Step 5: Return the result
            return result.toString() ;
        }
    }

    public static void main(String[] args) {

    }
}
