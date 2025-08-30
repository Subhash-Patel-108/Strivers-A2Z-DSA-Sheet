package BinarySearch.BinarySearchOnOneDArray;
import java.util.* ;
public class FirstAndLastOccurrence {
    public static class GFG {
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

        ArrayList<Integer> find(int arr[], int x) {
            ArrayList<Integer> result = new ArrayList<>();

            // Handle empty array
            if (arr == null || arr.length == 0) {
                return result;
            }

            // Find first occurrence
            int firstIndex = findIndexOfAElement(arr, x, false);
            if (firstIndex == -1) {
                result.add(-1);
                result.add(-1);
                return result;
            }

            result.add(firstIndex);

            // Find last occurrence
            int lastIndex = findIndexOfAElement(arr, x, true);
            result.add(lastIndex);

            return result;
        }
    }


    public static void main(String[] args) {

    }
}
