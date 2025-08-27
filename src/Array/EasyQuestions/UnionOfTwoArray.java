package Array.EasyQuestions;
import java.util.* ;
public class UnionOfTwoArray {
    class Solution {
        public static ArrayList<Integer> findUnion(int[] a, int[] b) {
            // Use HashSet to store unique elements
            Set<Integer> set = new HashSet<>();

            // Add all elements of first array
            for (int num : a) {
                set.add(num);
            }

            // Add all elements of second array
            for (int num : b) {
                set.add(num);
            }

            // Convert set to a list (order does not matter)
            return new ArrayList<>(set);
        }
    }

    public static void main(String[] args) {

    }
}
