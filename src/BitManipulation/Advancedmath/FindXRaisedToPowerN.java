package BitManipulation.Advancedmath;

import java.util.HashMap;

public class FindXRaisedToPowerN {
    public static class Solution {
        // Calculates x raised to the power of n
        public static double calculatePower(double base, int exponent) {
            // Handle edge cases
            if (exponent == 0) return 1.0;
            if (base == 1.0) return 1.0;
            if (base == 0.0) return 0.0;
            if (base == -1.0) return (exponent % 2 == 0) ? 1.0 : -1.0;

            double result = 1.0;
            int binaryExponent = exponent;

            // Handle negative exponents
            if (exponent < 0) {
                base = 1 / base;
                // Handle overflow for Integer.MIN_VALUE
                if (exponent == Integer.MIN_VALUE) {
                    result *= base;
                    binaryExponent = Integer.MAX_VALUE;
                } else {
                    binaryExponent = -exponent;
                }
            }

            // Use binary exponentiation for efficiency
            while (binaryExponent > 0) {
                // If current bit is 1, multiply result by base
                if ((binaryExponent & 1) == 1) {
                    result *= base;
                }
                // Square the base for the next bit
                base *= base;
                // Right shift to process next bit
                binaryExponent >>= 1;
            }

            return result;
        }
    }
    public static void main(String[] args) {
        HashMap <Integer , Boolean> map = new HashMap<>() ;

    }
}
