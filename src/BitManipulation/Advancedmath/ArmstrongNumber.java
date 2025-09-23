package BitManipulation.Advancedmath;

public class ArmstrongNumber {
    public static class Solution {
        public static boolean isArmstrong(int number) {
            // Handle edge case: 0 is not an Armstrong number
            if (number == 0) {
                return false;
            }

            // Calculate number of digits
            int numDigits = (int) (Math.log10(number)) + 1;

            // Initialize sum for Armstrong calculation
            int armstrongSum = 0;
            // Use temporary variable to extract digits
            int temp = number;

            // Compute sum of digits raised to the power of numDigits
            while (temp > 0) {
                int digit = temp % 10;
                armstrongSum += (int) Math.pow(digit, numDigits);
                temp /= 10;
            }

            // Check if sum equals original number
            return armstrongSum == number;
        }
    }


    public static void main(String[] args) {
        return ;
    }
}
