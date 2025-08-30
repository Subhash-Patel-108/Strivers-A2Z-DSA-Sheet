package BinarySearch.BinarySearchOnAnswer;

public class FindNthRootOfM {
    public static class Solution {
        // Function to find the Nth root of M using binary search
        private static int findNthRoot(int n, int m) {
            int start = 1, end = m, mid;
            int ans = -1;

            // Binary search for the integer root
            while (start <= end) {
                // Calculate mid-point of current search range
                mid = start + (end - start) / 2;
                // Calculate mid raised to the power of n
                int midN = (int) Math.pow(mid, n);

                // Check if midN is exactly equal to m
                if (midN == m) {
                    return mid; // Nth root found
                }
                // If midN is less than m, search in upper half
                else if (midN < m) {
                    start = mid + 1;
                }
                // If midN is greater than m, search in lower half
                else {
                    end = mid - 1;
                }
            }
            // If no integer root is found, return -1
            return ans;
        }

        // Wrapper function that calls the binary search function
        public int nthRoot(int n, int m) {
            return findNthRoot(n, m);
        }
    }

    public static void main(String[] args) {

    }
}
