package BitManipulation.Advancedmath;
import java.util.* ;
public class PrimeFactorisationOfANumber {
    public static class Solution {
        public List<List<Integer>> primeFactors(int[] queries) {
            List <List<Integer>> result = new ArrayList<>() ;

            //Edge case
            if(queries == null || queries.length == 0) return result ;

            for(int num : queries) {
                result.add(getPrimeFactors(num)) ;
            }

            return result ;
        }

        private static List<Integer> getPrimeFactors(int num) {
            List<Integer> factors = new ArrayList<>() ;

            // Check for number of 2s that divide num
            while(num % 2 == 0) {
                factors.add(2) ;
                num /= 2 ;
            }

            // num must be odd at this point, so we can skip even numbers
            for(int i = 3; i <= Math.sqrt(num); i += 2) {
                // While i divides num, add i and divide num
                while(num % i == 0) {
                    factors.add(i) ;
                    num /= i ;
                }
            }

            // This condition is to check if num is a prime number greater than 2
            if(num > 2) {
                factors.add(num) ;
            }

            return factors ;
        }
    }
    public static void main(String[] args) {

    }
}
