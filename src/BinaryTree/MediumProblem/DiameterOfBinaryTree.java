package BinaryTree.MediumProblem;
import BinaryTree.TreeClasses.TreeNode ;
public class DiameterOfBinaryTree {
    public static class Solution {
        private static int diameter ;
        public int diameterOfBinaryTree(TreeNode root) {
            diameter = 0 ;

            //Edge case
            if(root == null) {
                return diameter ;
            }

            checkDiameter(root) ;

            return diameter ;
        }

        //function to find the diameter of the binary tree
        private static int checkDiameter(TreeNode root) {
            //Base case
            if(root == null) {
                return 0 ;
            }

            int leftHeight = checkDiameter(root.left) ;//find the left height
            int rightHeight = checkDiameter(root.right) ;//find the right height

            diameter = Math.max(diameter , leftHeight + rightHeight) ;//store the maximum diameter

            return Math.max(leftHeight , rightHeight ) + 1 ;//return the maximum height
        }
    }
    public static void main(String[] args) {

    }
}
