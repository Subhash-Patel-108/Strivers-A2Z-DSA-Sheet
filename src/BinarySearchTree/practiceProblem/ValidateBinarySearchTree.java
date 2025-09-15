package BinarySearchTree.practiceProblem;
import BinaryTree.TreeClasses.TreeNode ;

public class ValidateBinarySearchTree {
    public static class Solution {
        private static boolean isBST;

        public boolean isValidBST(TreeNode root) {
            // Edge case: empty tree is valid BST
            if (root == null) {
                return true;
            }

            isBST = true; // Initialize flag

            // Start recursion checking with full long range to handle Integer.MIN_VALUE, MAX_VALUE edge cases
            checkTreeIsBST(root, Long.MIN_VALUE, Long.MAX_VALUE);

            return isBST; // Return result
        }

        private static void checkTreeIsBST(TreeNode root, long minValue, long maxValue) {
            // If node is null or violation already found, return early
            if (root == null || !isBST) {
                return;
            }

            // Current node must be strictly within (minValue, maxValue)
            if (root.data >= maxValue || root.data <= minValue) {
                isBST = false; // Violation found
                return;
            }

            // Check next subtree with updated max bound (current node's data)
            checkTreeIsBST(root.left, minValue, root.data);

            // Check right subtree with updated min bound (current node's data)
            checkTreeIsBST(root.right, root.data, maxValue);

            return;
        }

    }
    public static void main(String[] args) {

    }
}
