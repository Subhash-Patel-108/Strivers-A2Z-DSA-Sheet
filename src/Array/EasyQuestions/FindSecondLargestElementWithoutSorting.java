package Array.EasyQuestions;

public class FindSecondLargestElementWithoutSorting {
    //function to find the second largest element in an array
    public int getSecondLargest(int[] arr) {
        int largestElement = Integer.MIN_VALUE ;
        int secondLargestElement = Integer.MIN_VALUE ;

        for(int i = 0 ; i < arr.length ; i++) {
            if(arr[i] > largestElement) {
                secondLargestElement = largestElement ;
                largestElement = arr[i] ;
            }else if (arr[i] > secondLargestElement && arr[i] != largestElement) {
                secondLargestElement = arr[i] ;
            }
        }
        return secondLargestElement == Integer.MIN_VALUE ? -1 : secondLargestElement ;
    }
    public static void main(String[] args) {

    }
}
