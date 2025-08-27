package Array.EasyQuestions;

public class LinearSearch {
    // Method to perform linear search on the array
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return index where target is found
            }
        }
        return -1; // Target not found
    }

    // Main method to test linear search
    public static void main(String[] args) {
        int[] arr = {3, 7, 1, 9, 5, 11};
        int target = 9;

        int result = linearSearch(arr, target);
        if (result == -1) {
            System.out.println("Element " + target + " not found in the array.");
        } else {
            System.out.println("Element " + target + " found at index: " + result);
        }
    }
}
