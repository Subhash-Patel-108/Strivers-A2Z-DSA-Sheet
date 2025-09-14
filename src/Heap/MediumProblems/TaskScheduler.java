package Heap.MediumProblems;

public class TaskScheduler {
    public static class Solution {
        public int leastInterval(char[] tasks, int n) {
            int[] freq = new int[26] ;
            for(char ch : tasks) {
                freq[ch - 'A'] ++ ;
            }

            int maxFreq = 0 ;
            int numberOfMaxFreqTasks = 0 ;
            for(int f : freq) {
                if(f > maxFreq) {
                    numberOfMaxFreqTasks = 1 ;
                    maxFreq = f ;
                }else if (f == maxFreq) {
                    numberOfMaxFreqTasks ++ ;
                }
            }

            int partCount = maxFreq - 1 ;
            int partLength = n + 1 ;
            int totalSlot = partCount * partLength  + numberOfMaxFreqTasks ;

            return Math.max(totalSlot , tasks.length) ;
        }
    }
    public static void main(String[] args) {

    }
}
