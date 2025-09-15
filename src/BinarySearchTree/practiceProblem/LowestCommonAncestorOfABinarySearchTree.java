package BinarySearchTree.practiceProblem;
import BinaryTree.TreeClasses.TreeNode ;
public class LowestCommonAncestorOfABinarySearchTree {
    public static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // Edge case: empty subtree
            if(root == null) {
                return null;
            }

            // Recursive helper function to find LCA
            TreeNode LCA = findLCA(root, p, q);
            return LCA;
        }

        private static TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
            // Base case: if root is null, return null
            if(root == null) {
                return null;
            }

            // If current node is p or q, return current node
            if(root == p || root == q) {
                return root;
            }

            // Search recursively in next and right subtree
            TreeNode left = findLCA(root.left, p, q);
            TreeNode right = findLCA(root.right, p, q);

            // If p and q found in different subtrees, current root is LCA
            if(left != null && right != null) {
                return root;
            }

            // Otherwise return the non-null subtree result
            return left != null ? left : right;
        }

    }
    public static void main(String[] args) {

    }
}
