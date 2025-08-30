package BinarySearch.BinarySearchOnOneDArray;

public class CountNumberOfOccurrence {
    public static class Solution {
        //function to find the first and last index of a element
        private static int findIndexOfAElement(int arr[], int target, boolean isLastIndex) {
            int start = 0, end = arr.length - 1, mid;
            int ans = -1;

            while (start <= end) {
                mid = start + (end - start) / 2; // Avoids overflow

                if (arr[mid] == target) {
                    ans = mid; // Store current match

                    // Adjust search based on whether we're finding first or last index
                    if (isLastIndex) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                } else if (arr[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            return ans;
        }

        //function to count the number of occurrence of a element
        public static int count(int arr[], int n, int x) {
            int count = 0 ;
            //edge case
            if(arr == null || arr.length == 0) {
                return count ;
            }

            //first we find the first index (position) of the target element
            int firstIndex = findIndexOfAElement(arr, x, false) ;

            if(firstIndex == -1) {// the given target element is not present in the array
                return count ;
            }

            int secondIndex = findIndexOfAElement(arr, x, true) ;

            count = secondIndex - firstIndex + 1 ;//finding the length of the array between the first and last index
            return count ;
        }
    }
    public static void main(String[] args) {

    }
}
