package Array.EasyQuestions;

public class FindSingleElement {
    class Solution {
        //the logic is to use the property of xor
        //if a number is xor with itself then it will become 0
        //there, for we can find the single element in the array
        int getSingle(int arr[]) {
            int xor = 0 ;//to store the xor the of all the element
            for(int num : arr) {
                xor ^= num ;
            }
            return xor ;//return the answer
        }
    }
}
