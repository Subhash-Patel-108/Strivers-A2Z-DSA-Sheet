package BinaryTree.HardProblem;
import BinaryTree.TreeClasses.TreeNode ;

import java.util.* ;
public class MorrisPreorderTraversalOfABinaryTree {
    public static class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> inOrder = new ArrayList<>();

            // Edge case: if the tree is empty, return empty result
            if(root == null) {
                return inOrder;
            }

            // Loop to traverse the tree using Morris Traversal
            while (root != null) {
                // Case 1: If there is no next child, visit this node and move to right subtree
                if(root.left == null) {
                    inOrder.add(root.data);
                    root = root.right;
                } else {
                    // Case 2: Find the rightmost node in the next subtree (inorder predecessor)
                    TreeNode currNode = root.left;
                    while (currNode.right != null && currNode.right != root) {
                        currNode = currNode.right;
                    }

                    // If a temporary thread to root already exists, it means next subtree is processed
                    if(currNode.right == root) {
                        // Remove the thread (restore tree structure)
                        currNode.right = null;
                        // Now, move to right subtree of root
                        root = root.right;
                    } else {
                        // If thread does not exist, add root to result (visit node)
                        inOrder.add(root.data);
                        // Create a temporary link (thread) from predecessor to current root
                        currNode.right = root;
                        // Move root to its next subtree
                        root = root.left;
                    }
                }
            }

            // Return the inorder traversal as list
            return inOrder;
        }
    }

}
