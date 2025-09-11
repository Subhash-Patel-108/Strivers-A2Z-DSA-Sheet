package BinaryTree.HardProblem;
import BinaryTree.TreeClasses.TreeNode ;
public class ConstructTreeFromInorderAndPreorder {
    public static class Solution {
        private static int idx;

        // Public method to build binary tree from inorder and preorder traversals
        public static TreeNode buildBinaryTree(int[] inorder, int[] preorder) {
            // Edge case: if either traversal array is null, return null tree
            if (inorder == null || preorder == null) {
                return null;
            }

            // Initialize index for preorder array
            idx = 0;

            // Recursively construct the binary tree using helper
            TreeNode root = helper(inorder, preorder, 0, inorder.length - 1);

            return root;
        }

        // Helper method to construct subtree from traversals within start and end indices
        private static TreeNode helper(int[] inorder, int[] preorder, int start, int end) {
            // Base case: if range is invalid or preorder is fully traversed, return null
            if (start > end || idx >= inorder.length) {
                return null;
            }

            // Find the current root position in inorder array
            int position = findElementIndex(inorder, preorder[idx], start, end);

            // Create tree node with current preorder value and move to next index
            TreeNode root = new TreeNode(preorder[idx++]);

            // Recursively build left subtree (elements before root in inorder)
            root.left = helper(inorder, preorder, start, position - 1);

            // Recursively build right subtree (elements after root in inorder)
            root.right = helper(inorder, preorder, position + 1, end);

            return root;
        }

        // Utility method to find the index of target value in inorder subarray
        private static int findElementIndex(int[] inOrder, int target, int start, int end) {
            // Linear search between start and end
            for (int i = start; i <= end; i++) {
                if (inOrder[i] == target) {
                    return i;
                }
            }

            // If not found, return -1
            return -1;
        }
    }

    public static void main(String[] args) {

    }
}
