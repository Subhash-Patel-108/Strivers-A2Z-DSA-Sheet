package BinaryTree.MediumProblem;
import BinaryTree.TreeClasses.TreeNode ;
public class BalancedBinaryTree {
    public static class Solution {
        private static boolean isBalancedTree;
        public boolean isBalanced(TreeNode root) {
            isBalancedTree = true ;
            checkIsBalanced(root) ;

            return isBalancedTree ;
        }

        //function to check if the tree is balanced or not
        private static int checkIsBalanced(TreeNode root) {
            //Edge case
            if(root == null) {
                return 0 ;
            }

            if(isBalancedTree) {
                int leftHeight = checkIsBalanced(root.left) ;
                int rightHeight = checkIsBalanced(root.right) ;

                if(Math.abs(leftHeight - rightHeight) > 2) {
                    isBalancedTree = false ;
                    return 0 ;
                }

                return Math.max(leftHeight , rightHeight ) + 1 ;
            }

            return 0 ;
        }
    }
}
