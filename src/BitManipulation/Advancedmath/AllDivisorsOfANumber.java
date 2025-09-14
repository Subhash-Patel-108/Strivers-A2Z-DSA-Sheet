package BitManipulation.Advancedmath;
import java.util.* ;
public class AllDivisorsOfANumber {
    public class Solution{
        // Returns a list of all divisors of a given number
        public static List<Integer> findDivisors(int number) {
            List<Integer> divisorList = new ArrayList<>();
            //Handle edge case: return empty list if number is non-positive
            if (number <= 0) return divisorList;

            // Iterate up to square root of number to find divisors
            for (int i = 1; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    // Add the divisor
                    divisorList.add(i);
                    // Add the corresponding divisor (n/i) if it's different
                    if (i != number / i) {
                        divisorList.add(number / i);
                    }
                }
            }

            //Sort the list of divisors in ascending order
            Collections.sort(divisorList);

            return divisorList;
        }
    }

    public static void main(String[] args) {

    }
}
