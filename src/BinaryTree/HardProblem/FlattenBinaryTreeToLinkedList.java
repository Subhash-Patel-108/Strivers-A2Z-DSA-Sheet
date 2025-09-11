package BinaryTree.HardProblem;
import BinaryTree.TreeClasses.Node ;

public class FlattenBinaryTreeToLinkedList {
    public static class Solution {
        public static void flatten(Node root) {
            // Edge case: if the tree is empty, nothing to flatten
            if (root == null) {
                return;
            }

            // Iterate through the tree using the root reference
            while (root != null) {
                // If there is no left child, simply move to the right child
                if (root.left == null) {
                    root = root.right;
                } else {
                    // Find the rightmost node of the left subtree (predecessor)
                    Node curr = root.left;
                    while (curr.right != null) {
                        curr = curr.right;
                    }

                    // Relink: attach the original right subtree after predecessor's right
                    curr.right = root.right;

                    // Move left subtree to the right
                    root.right = root.left;

                    // Set left child to null
                    root.left = null;

                    // Move to next node (now always root.right)
                    root = root.right;
                }
            }
            return;
        }

    }
    public static void main(String[] args) {

    }
}
