package BinaryTree.MediumProblem;
import BinaryTree.TreeClasses.TreeNode ;
public class MaximumDepthOfBinaryTree {
    public static class Solution {
        //function to find the maximum depth of the binary tree
        public int maxDepth(TreeNode root) {
            if(root == null ) return 0 ;

            int left_height = maxDepth(root.left) ;//to find maximum depth of left subtree
            int right_height = maxDepth(root.right) ;//to find maximum depth of right subtree

            return 1 + Math.max( left_height , right_height ) ;//to find the maximum depth of the binary tree
        }
    }

    public static void main(String[] args) {

    }
}
