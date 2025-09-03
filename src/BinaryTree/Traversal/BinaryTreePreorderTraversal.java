package BinaryTree.Traversal;
import java.util.* ;
import BinaryTree.TreeClasses.BinaryTreeNode ;
public class BinaryTreePreorderTraversal {
    public static class Solution {
        public static ArrayList<Integer> preorderTraversal(BinaryTreeNode<Integer> root) {
            ArrayList<Integer> preOrder = new ArrayList<>() ;

            //Edge case
            if(root == null) {
                return preOrder ;
            }

            //Step 1: Function calling to find preOrder traversal
            findPreOrder(root , preOrder) ;

            //Step 2: return the result
            return preOrder ;
        }

        //function to find the preorder Traversal
        private static void findPreOrder(BinaryTreeNode<Integer> root , ArrayList<Integer> preOrder) {
            //Base case
            if(root == null) {
                return ;
            }

            //Step 1: Add the root data to the result
            preOrder.add(root.data) ;
            findPreOrder(root.left , preOrder) ; // for left subtree
            findPreOrder(root.right , preOrder) ; // for right subtree

            return ;
        }
    }
    public static void main(String[] args) {

    }
}
