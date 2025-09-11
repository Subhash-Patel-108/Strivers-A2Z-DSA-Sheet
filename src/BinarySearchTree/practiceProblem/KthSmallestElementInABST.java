package BinarySearchTree.practiceProblem;
import BinaryTree.TreeClasses.TreeNode ;

public class KthSmallestElementInABST {
    public static class Solution {
        private static int ans, count;

        public int kthSmallest(TreeNode root, int k) {
            // Edge case: empty tree returns 0 as fallback value
            if (root == null) {
                return 0;
            }

            ans = -1;    // Variable to store kth smallest value once found
            count = 0;   // Counter to track number of nodes visited in inorder

            // Perform inorder traversal to find kth smallest value
            findKthSmallestValue(root, k);

            return ans;  // Return the kth smallest element
        }

        private static void findKthSmallestValue(TreeNode root, int k) {
            // Base case: node is null or kth element already found
            if (root == null || ans != -1) {
                return;
            }

            // Traverse left subtree to find smaller elements first
            findKthSmallestValue(root.left, k);

            // Increment count for current node
            count++;

            // If count matches k, record the node value as answer
            if (count == k) {
                ans = root.data;
                return;
            }

            // Traverse right subtree for larger elements
            findKthSmallestValue(root.right, k);
            return ;
        }
    }
    public static void main(String[] args) {

    }
}
