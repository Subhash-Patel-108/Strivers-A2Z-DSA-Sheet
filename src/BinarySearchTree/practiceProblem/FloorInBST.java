package BinarySearchTree.practiceProblem;

public class FloorInBST {
    public static class Solution {
        public static class TreeNode <T> {
            public T data ;
            public TreeNode <T> left ;
            public TreeNode <T> right ;

            //constructor
            public TreeNode (T data) {
                this.data = data ;
                this.left = null ;
                this.right = null ;
            }
        };


        public static int floorInBST(TreeNode<Integer> root, int X) {
            // Edge case: if BST is empty, return -1
            if (root == null) {
                return -1;
            }

            int potentailFloor = -1; // Stores the best floor found so far

            TreeNode<Integer> currNode = root;

            // Iterate through BST nodes
            while (currNode != null) {
                // If value matches X, it is its own floor
                if (currNode.data == X) {
                    return currNode.data;
                }

                // If current node is less than X, it is a candidate for floor
                if (currNode.data < X) {
                    potentailFloor = currNode.data;
                    currNode = currNode.right; // look for a closer/larger value in the right subtree
                } else {
                    // If current node is greater than X, look for floor in the left subtree
                    currNode = currNode.left;
                }
            }

            // After traversal, potentailFloor has largest value ≤ X, or -1 if not found
            return potentailFloor;
        }

    }
    public static void main(String[] args) {

    }
}
