package BinarySearchTree.practiceProblem;
import BinaryTree.TreeClasses.TreeNode ;
public class InsertIntoABinarySearchTree {
    public static class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            // Edge case: if tree is empty, create and return the new node as root
            if(root == null) {
                return new TreeNode(val);
            }

            // Call the recursive helper to insert new value
            root = insertValueIntoBST(root, val);

            return root;
        }

        // Recursive helper to insert value into the BST
        private static TreeNode insertValueIntoBST(TreeNode root, int val) {
            // Base case: found the position for insertion
            if(root == null) {
                return new TreeNode(val);
            }

            // If value is less than current node, insert in left subtree
            if(root.data > val) {
                root.left = insertValueIntoBST(root.left, val);
            } else {
                // Otherwise, insert in right subtree
                root.right = insertValueIntoBST(root.right, val);
            }

            // Return the unchanged root pointer
            return root;
        }
    }
    public static void main(String[] args) {

    }
}
