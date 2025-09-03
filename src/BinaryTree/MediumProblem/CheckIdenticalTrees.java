package BinaryTree.MediumProblem;
import java.util.* ;
import BinaryTree.TreeClasses.BinaryTreeNode ;
public class CheckIdenticalTrees {
    public static class Solution {
        private static boolean isIdentical ;
        public static boolean identicalTrees(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
            isIdentical = true ;

            //Edge case
            if(root1 == null && root2 == null) {
                return true ;
            }else if (root1 == null || root2 == null) {
                return false ;
            }

            //function calling
            checkIsIdentical(root1 , root2) ;

            return isIdentical ;
        }

        private static void checkIsIdentical(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
            //base case
            if(root1 == null && root2 == null || !isIdentical) {
                return ;
            }

            //check for identical
            if((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
                isIdentical = false ;
                return ;
            }

            if( !(root1.data.equals(root2.data)) ){
                isIdentical = false ;
                return ;
            }

            checkIsIdentical(root1.left , root2.left);
            checkIsIdentical(root1.right , root2.right);

            return ;
        }
    }
    public static void main(String[] args) {

    }
}

