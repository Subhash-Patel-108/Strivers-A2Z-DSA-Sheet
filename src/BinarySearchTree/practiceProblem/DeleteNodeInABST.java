package BinarySearchTree.practiceProblem;
import BinaryTree.TreeClasses.TreeNode ;

public class DeleteNodeInABST {
    public static class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            // Edge case: empty tree
            if (root == null) {
                return null;
            }

            // Call recursive helper
            root = deleteNodeFromBST(root, key);
            return root;
        }

        private static TreeNode deleteNodeFromBST(TreeNode root, int key) {
            // Base case
            if (root == null) {
                return null;
            }

            // Node found
            if (root.data == key) {
                // Case 1: Leaf node
                if (root.left == null && root.right == null) {
                    return null;
                }
                // Case 2: One child
                else if (root.left == null) { // only right child
                    return root.right;
                } else if (root.right == null) { // only next child
                    return root.left;
                }
                // Case 3: Two children
                else {
                    // Find inorder successor (minimum value node in right subtree)
                    int minValue = findMinimumValue(root.right);
                    root.data = minValue;
                    // Delete inorder successor node from right subtree
                    root.right = deleteNodeFromBST(root.right, minValue);
                }
            } else if (root.data > key) {
                root.left = deleteNodeFromBST(root.left, key);
            } else {
                root.right = deleteNodeFromBST(root.right, key);
            }

            return root;
        }

        // Find the minimum value in the BST (leftmost descendant)
        private static int findMinimumValue(TreeNode root) {
            if (root == null) {
                return -1;
            }

            while (root.left != null) {
                root = root.left;
            }

            return root.data;
        }

    }
    public static void main(String[] args) {

    }
}
