package Array.ExtraQuestions.Easy;
import java.util.*;

//Problem Link: https://www.naukri.com/code360/problems/kth-smallest-and-largest-element-of-array_1115488?interviewProblemRedirection=true&practice_topic%5B%5D=Arrays&sort_entity=company_count&sort_order=DESC
public class KthSmallestAndLargestElementOfArray {

    public static class Solution {
        public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {
            //Edge case
            if(arr == null || n == 0 || k > n || k == 0 ) {
                return new ArrayList<>() ;
            }

            ArrayList <Integer> ans = new ArrayList<>() ;

            PriorityQueue <Integer> minHeap = new PriorityQueue<>() ;
            PriorityQueue <Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()) ;

            int idx = 0 ;
            while (idx < k ) {
                minHeap.add(arr.get(idx)) ;
                maxHeap.add(arr.get(idx)) ;
                idx++ ;
            }

            while (idx < n ) {
                int currentValue = arr.get(idx) ;
                if (minHeap.peek() < currentValue) {
                    minHeap.poll() ;
                    minHeap.offer(currentValue) ;
                }

                if(maxHeap.peek() > currentValue) {
                    maxHeap.poll() ;
                    maxHeap.offer(currentValue) ;
                }

                idx++ ;
            }

            ans.add(maxHeap.peek());
            ans.add(minHeap.peek());

            return ans ;
        }
    }
    public static void main(String[] args) {

    }
}
