package BinaryTree.Traversal;
import BinaryTree.TreeClasses.TreeNode ;
import java.util.* ;
public class InOrderTraversal {

    public class Solution {
        public static List< Integer > getInOrderTraversal(TreeNode root) {
            List<Integer> inOrder = new ArrayList<>() ;
            inorderTraversal(root , inOrder) ;
            return inOrder;
        }

        //Function to find inorder traversal
        private static void inorderTraversal(TreeNode root , List<Integer> inOrder) {
            if(root == null) {
                return ;
            }

            inorderTraversal(root.left , inOrder) ;
            inOrder.add(root.data) ;
            inorderTraversal(root.right , inOrder) ;

            return ;
        }
    }
    public static void main(String[] args) {

    }
}
