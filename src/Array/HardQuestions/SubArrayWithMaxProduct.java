package Array.HardQuestions;

public class SubArrayWithMaxProduct {
    public static class Solution {
        public static int subarrayWithMaxProduct(int []arr){
            int maximumProduct = 0 ;

            //Edge case
            if(arr == null || arr.length == 0) {
                return maximumProduct ;
            }
            int size = arr.length ;
            int prefixProduct = 1 , suffixProduct = 1 ;
            for(int i = 0; i < size; i++ ){
                if(prefixProduct == 0) {
                    prefixProduct = 1 ;
                }
                if(suffixProduct == 0){
                    suffixProduct = 1 ;
                }

                prefixProduct *= arr[i] ;
                suffixProduct *= arr[size - i - 1] ;
                maximumProduct = Math.max(maximumProduct , Math.max(prefixProduct , suffixProduct)) ;
            }

            return maximumProduct;
        }
    }
    public static void main(String[] args) {

    }
}
