package BinarySearchTree.concepts;
import BinaryTree.TreeClasses.Node ;

public class MaxAndMinElementInBinaryTree {
    public static class Solution {
        public static int findMin(Node root) {
           //Edge case
            if(root == null) {
                return -1 ;
            }

            Node currNode = root ;
            //go to the next most node
            while (currNode.left != null) {
                currNode = currNode.left ;
            }

            return currNode.data ;//the minimum value
        }

        public static int findMax(Node root) {
            //Edge case
            if(root == null) {
                return -1 ;
            }

            Node currNode = root ;
            //go to the right most node
            while (currNode.right != null) {
                currNode = currNode.right ;
            }

            return currNode.data ;//the maximum value
        }
    }
    public static void main(String[] args) {

    }
}
