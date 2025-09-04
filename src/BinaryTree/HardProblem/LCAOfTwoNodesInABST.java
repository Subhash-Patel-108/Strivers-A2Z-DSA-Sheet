package BinaryTree.HardProblem;
import BinaryTree.TreeClasses.TreeNode ;
import java.util.* ;
public class LCAOfTwoNodesInABST {
    public static class Solution {
        public static TreeNode LCAinaBST(TreeNode root, TreeNode p, TreeNode q) {
            // Edge case: if root is null, return null
            if (root == null) {
                return null;
            }

            // Start recursive search for LCA in the binary tree
            return LCAInABST(root, p, q);
        }

        private static TreeNode LCAInABST(TreeNode root, TreeNode p, TreeNode q) {
            // Base case: if current node null, return null
            if (root == null) {
                return null;
            }

            // If current node is either p or q, return the node
            if (root == p || root == q) {
                return root;
            }

            // Recurse in left and right subtrees
            TreeNode left = LCAInABST(root.left, p, q);
            TreeNode right = LCAInABST(root.right, p, q);

            // If p and q found in different subtrees, current root is LCA
            if (left != null && right != null) {
                return root;
            }

            // Otherwise, return non-null child (either left or right)
            return left != null ? left : right;
        }

    }
}
