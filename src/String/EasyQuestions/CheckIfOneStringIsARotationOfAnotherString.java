package String.EasyQuestions;

public class CheckIfOneStringIsARotationOfAnotherString {
    //this solution takes O(n^2) time and O(1) space
    public static class Solution1 {
        public static int isCyclicRotation(String p, String q)  {
            //Edge case
            if(p == null || q == null || p.length() == 0 || q.length() == 0 || p.length() != q.length()) {
                return 0 ;
            }

            char fistChar = p.charAt(0) ;
            for(int i = 0 ; i < q.length() ; i++ ){
                if(q.charAt(i) == fistChar && isQRotated(q , i , p )) {
                    return 1 ;
                }
            }
            return 0 ;
        }

        //function to check if q is rotated or not
        private static boolean isQRotated(String q , int idx , String checkString){
            int n = q.length() ;
            int i = idx ;
            int idxForCheckString = 0 ;
            do {
                if(q.charAt(idx) != checkString.charAt(idxForCheckString)) {
                    return false ;
                }
                idx = (idx + 1 ) % n ;
                idxForCheckString ++ ;
            }while (i != idx) ;

            return true ;
        }
    }

    //In this solution we will use P + P trick  gives TLE
    public static class Solution2 {
        public static int isCyclicRotation(String p, String q)  {
            if(p.length() != q.length() ) {
                return 0 ;
            }

            String concatString = p + p ;
            if(concatString.contains(q)) {
                return 1 ;
            }
            return 0 ;
        }
    }


    public static void main(String[] args) {

    }
}
