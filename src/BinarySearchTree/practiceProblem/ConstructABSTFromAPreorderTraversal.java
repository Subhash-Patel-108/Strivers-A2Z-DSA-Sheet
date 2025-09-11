package BinarySearchTree.practiceProblem;
import BinaryTree.TreeClasses.TreeNode ;

public class ConstructABSTFromAPreorderTraversal {
    public static class Solution {
        public static TreeNode preOrderTree(int[] preOrder) {
            // Edge case: empty or null array
            if (preOrder == null || preOrder.length == 0) {
                return null;
            }

            TreeNode root = new TreeNode(preOrder[0]);

            // Insert remaining values one by one into BST
            for (int i = 1; i < preOrder.length; i++) {
                root = insertIntoBST(root, preOrder[i]);
            }

            return root;
        }

        private static TreeNode insertIntoBST(TreeNode root, int val) {
            // Base case: place for new node found
            if (root == null) {
                return new TreeNode(val);
            }

            if (root.data > val) {
                root.left = insertIntoBST(root.left, val);
            } else {
                root.right = insertIntoBST(root.right, val);
            }

            return root;
        }
    }

    public class Solution2 {
        // Global index to track the current element in preorder array
        private static int idx;

        public static TreeNode preOrderTree(int[] preOrder) {
            // Handle edge case: if array is null or empty, return null
            if (preOrder == null || preOrder.length == 0) {
                return null;
            }

            // Initialize index to start of preorder array
            idx = 0;

            // Build the tree with range [MIN_VALUE, MAX_VALUE]
            return buildBST(preOrder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private static TreeNode buildBST(int[] preOrder, int min, int max) {
            // Base case: if index exceeds array or value is out of range, return null
            if (idx >= preOrder.length || preOrder[idx] < min || preOrder[idx] > max) {
                return null;
            }

            // Create the current node with the current preorder value
            TreeNode root = new TreeNode(preOrder[idx]);
            idx++; // Move to the next element in preorder

            // Recursively construct the left subtree (values < root.data)
            root.left = buildBST(preOrder, min, root.data);

            // Recursively construct the right subtree (values > root.data)
            root.right = buildBST(preOrder, root.data, max);

            return root;
        }
    }
    public static void main(String[] args) {

    }
}
