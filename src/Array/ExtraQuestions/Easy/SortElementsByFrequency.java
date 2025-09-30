package Array.ExtraQuestions.Easy;
import java.util.* ;

//Problem link : https://www.naukri.com/code360/problems/sort-elements-by-frequency_1280138?interviewProblemRedirection=true&practice_topic%5B%5D=Arrays&sort_entity=company_count&sort_order=DESC
public class SortElementsByFrequency {

    public static class Solution {

        // Class to store value and its frequency
        public static class Pair {
            public int value;
            public int freq;

            public Pair(int value, int freq) {
                this.value = value;
                this.freq = freq;
            }
        }

        public static int[] sortByFrequency(int[] nums) {
            // Handle edge case: null or empty array returns unchanged
            if (nums == null || nums.length == 0) {
                return nums;
            }

            // Map to store frequency of each value
            Map<Integer, Integer> valueToFreqMap = new LinkedHashMap<>();
            // Count frequency of each number
            for (int num : nums) {
                valueToFreqMap.put(num, valueToFreqMap.getOrDefault(num, 0) + 1);
            }

            // Create list of value-frequency pairs
            ArrayList<Pair> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : valueToFreqMap.entrySet()) {
                int value = entry.getKey();
                int freq = entry.getValue();
                list.add(new Pair(value, freq));
            }

            // Sort list by frequency in descending order
            Collections.sort(list, (a, b) -> {
                return Integer.compare(b.freq, a.freq);
            });

            // Rebuild array based on sorted frequencies
            int listIdx = 0;
            int idx = 0;
            while (idx < nums.length) {
                int value = list.get(listIdx).value;
                int freq = list.get(listIdx).freq;

                // Place value in array freq times
                while (freq-- > 0) {
                    nums[idx] = value;
                    idx++;
                }
                listIdx++;
            }

            // Return sorted array
            return nums;
        }
    }

    public static class Solution2 {
        public static int[]  sortByFrequency(int[] nums) {
            if (nums == null || nums.length == 0) return nums;

            Map<Integer, Integer> freqMap = new LinkedHashMap<>();
            for (int num : nums) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }

            // Bucket: index = frequency, value = list of numbers
            List<List<Integer>> buckets = new ArrayList<>(nums.length + 1);
            for (int i = 0; i <= nums.length; i++) {
                buckets.add(new ArrayList<>());
            }
            for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
                buckets.get(entry.getValue()).add(entry.getKey());
            }

            // Rebuild nums from highest frequency to lowest
            int idx = 0;
            for (int freq = nums.length; freq >= 1; freq--) {
                for (int num : buckets.get(freq)) {
                    for (int i = 0; i < freq; i++) {
                        nums[idx++] = num;
                    }
                }
            }

            return nums;
        }
    }

    public static void main(String[] args) {

    }
}
