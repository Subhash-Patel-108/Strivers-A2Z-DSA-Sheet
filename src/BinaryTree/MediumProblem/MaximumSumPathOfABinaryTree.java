package BinaryTree.MediumProblem;

public class MaximumSumPathOfABinaryTree {
    public static class Solution {
        private static class BinaryTreeNode<T> {
            public T data ;
            public BinaryTreeNode<T> left ;
            public BinaryTreeNode<T>right ;

            //Constructor
            public BinaryTreeNode(T data) {
                this.data = data ;
                this.left = null ;
                this.right = null ;
            }
        }
        private static int maxPathSum ; // to store the maximum path sum
        public static int maxPathSum(BinaryTreeNode<Integer> root) {
            maxPathSum = Integer.MIN_VALUE ;
            findMaximumPathSum(root) ;

            return maxPathSum ;
        }

        //function to find the maximum path sum
        private static int findMaximumPathSum(BinaryTreeNode<Integer> root) {
            //Base case
            if(root == null) {
                return 0 ;
            }

            int leftPathSum = Math.max(0 , findMaximumPathSum(root.left)) ;//find the left path the maximum sum if -ve then consider it as 0
            int rightPathSum = Math.max(0 , findMaximumPathSum(root.right)) ;//find the right path the maximum sum if -ve then consider it as 0

            int currentPathSum = root.data + leftPathSum + rightPathSum ;//current path sum

            maxPathSum = Math.max(currentPathSum , maxPathSum ) ; // store maximum path sum

            return root.data + Math.max(leftPathSum , rightPathSum) ; // return the sum of the maximum path sum

        }
    }

    public static void main(String[] args) {

    }
}
