package BinaryTree.MediumProblem;
import java.util.* ;
public class SymmetricTree {
    public class Solution {
        private static class BinaryTreeNode<T> {
            public T data;
            public BinaryTreeNode<T> left;
            public BinaryTreeNode<T> right;

            // Constructor to initialize node value and children
            public BinaryTreeNode(T data) {
                this.data = data;
                this.left = null;
                this.right = null;
            }
        };

        private static boolean isMirrorTree;

        // Main function to check if binary tree is symmetric
        public static boolean isSymmetric(BinaryTreeNode<Integer> root) {
            // Edge case: An empty tree is symmetric
            if(root == null ) {
                return true ;
            }

            isMirrorTree = true ; // Initialize symmetry status

            // Start recursion to check mirror property between left and right subtrees
            checkMirrorTree(root.left , root.right) ;

            // Return status
            return isMirrorTree ;
        }

        // Helper function to check if two subtrees are mirrors of each other
        private static void checkMirrorTree(BinaryTreeNode<Integer> root1 , BinaryTreeNode<Integer> root2) {
            // Base case: If both nodes are null or we've already found asymmetry
            if(root1 == null && root2 == null || !isMirrorTree) {
                return ;
            }

            // If one is null and the other isn't, tree is not symmetric
            if((root1 == null && root2 != null) || (root1 != null && root2 == null) ) {
                isMirrorTree = false ;
                return ;
            }

            // If data doesn't match, tree is not symmetric
            if(! root1.data.equals(root2.data)){
                isMirrorTree = false ;
                return ;
            }

            // Compare left subtree of first with right subtree of second, and vice versa
            checkMirrorTree(root1.left , root2.right);
            checkMirrorTree(root1.right , root2.left);

            return ;
        }
    }

    public static void main(String[] args) {

    }
}
