package Sorting.MediumQuestions;
import java.util.* ;

//Problem Link : https://www.naukri.com/code360/problems/find-k-closest-elements_1263702?interviewProblemRedirection=true&practice_topic%5B%5D=Sorting&sort_entity=company_count&sort_order=DESC
public class FindKClosestElements {

    public static class Solution {

        private static class Pair {
            public int num ;
            public int abs ;

            //Constructor
            public Pair(int num , int abs) {
                this.num = num ;
                this.abs = abs ;
            }
        };

        public static ArrayList<Integer> kClosest(ArrayList<Integer> arr, int n, int k, int x) {
            //Edge case
            if(arr == null || arr.isEmpty() || k == 0 || k > arr.size()) {
                return new ArrayList<>() ;
            }

            ArrayList <Pair> pairList = new ArrayList<>() ;
            for(int num : arr) {
                pairList.add(new Pair(num , Math.abs(num - x)));
            }

            Collections.sort(pairList , (a , b) -> {
                if (a.abs == b.abs) {
                    return Integer.compare(a.num , b.num) ;
                }else{
                    return Integer.compare(a.abs , b.abs) ;
                }
            });

            ArrayList <Integer> ans = new ArrayList<>() ;
            for(int idx = 0 ; idx < k ; idx++ ) {
                ans.add(pairList.get(idx).num) ;
            }

            Collections.sort(ans);
            return ans ;
        }
    }

    public static class Solution2 {
        /**
         * Find K closest elements to X in sorted array using two pointers
         * Time Complexity: O(log n + k), Space Complexity: O(1) extra space
         * */
        public static ArrayList<Integer> kClosest(ArrayList<Integer> arr , int n, int k, int x) {
            //Edge case
            if(arr == null || arr.isEmpty() || k == 0 || k >= arr.size()) {
                return arr ;
            }

            int insertionPos = findInsertionPosition(arr , 0 , arr.size() - 1 , x ) ;

            ArrayList<Integer> result = new ArrayList<>() ;

            int left = insertionPos - 1 ;
            int right = insertionPos ;

            while (result.size() < k) {
                if(left < 0) {
                    result.add(arr.get(right));
                    right++ ;
                }else if (right >= n) {
                    result.add(arr.get(left));
                    left-- ;
                }else {
                    int leftDiff = Math.abs(arr.get(left) - x);
                    int rightDiff = Math.abs(arr.get(right) - x);

                    if (leftDiff < rightDiff || (leftDiff == rightDiff && arr.get(left) < arr.get(right))) {
                        result.add(arr.get(left));
                        left--;
                    } else {
                        result.add(arr.get(right));
                        right++;
                    }
                }
            }
            Collections.sort(result);
            return result ;
        }

        private static int findInsertionPosition(ArrayList<Integer> arr , int left , int right , int target) {
            while(left < right) {
                int mid = left + (right - left) / 2 ;

                if (arr.get(mid) < target) {
                    left = mid + 1 ;
                }else{
                    right = mid ;
                }
            }

            return left ;
        }
    }
    public static void main(String[] args) {

    }
}
