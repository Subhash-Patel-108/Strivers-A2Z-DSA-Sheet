package GreedyAlgorithm.EasyProblems;

public class LemonadeChange {
    public static class Solution {
        // Determines if it's possible to provide change for all lemonade purchases
        public static boolean canProvideLemonadeChange(int[] bills) {
            // Handle edge case: return true if array is null or empty (no transactions to process)
            if (bills == null || bills.length == 0) {
                return true;
            }

            int fiveDollarBills = 0; // Count of $5 bills available
            int tenDollarBills = 0;  // Count of $10 bills available

            // Process each bill to provide $5 change when needed
            for (int bill : bills) {
                if (bill == 5) {
                    // No change needed for $5 bill, just add it
                    fiveDollarBills++;
                } else if (bill == 10) {
                    // Need one $5 bill as change for $10
                    tenDollarBills++;
                    if (fiveDollarBills > 0) {
                        fiveDollarBills--;
                    } else {
                        // Cannot provide change
                        return false;
                    }
                } else {
                    // Need $15 change for $20 bill (prefer $10 + $5, else three $5)
                    if (tenDollarBills > 0 && fiveDollarBills > 0) {
                        tenDollarBills--;
                        fiveDollarBills--;
                    } else if (fiveDollarBills >= 3) {
                        fiveDollarBills -= 3;
                    } else {
                        // Cannot provide change
                        return false;
                    }
                }
            }

            return true;
        }
    }
    public static void main(String[] args) {

    }
}
