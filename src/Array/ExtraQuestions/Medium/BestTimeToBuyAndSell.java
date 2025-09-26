package Array.ExtraQuestions.Medium;
import java.util.* ;

//Problem Link: https://www.naukri.com/code360/problems/best-time-to-buy-and-sell_696432?interviewProblemRedirection=true&practice_topic%5B%5D=Arrays&sort_entity=company_count&sort_order=DESC
public class BestTimeToBuyAndSell {

    public static class Solution {
        public static int maxProfit(int[] prices) {
            //Edge case
            if(prices == null || prices.length == 0 ) {
                return 0 ;
            }
            int size = prices.length ;
            int totalProfit = 0 ;

            for(int idx = 1 ; idx < size ; idx++ ) {
                int profit = prices[idx] - prices[idx - 1] ;
                if(profit > 0 ) {
                    totalProfit += profit ;
                }
            }
            return totalProfit ;
        }
    }
    public static void main(String[] args) {

    }
}
