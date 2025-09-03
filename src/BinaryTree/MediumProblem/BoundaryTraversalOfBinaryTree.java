package BinaryTree.MediumProblem;
import BinaryTree.TreeClasses.TreeNode ;
import java.util.* ;
public class BoundaryTraversalOfBinaryTree {
    public class Solution {
        public static List<Integer> traverseBoundary(TreeNode root){
            List<Integer> result = new ArrayList<>() ;

            //Edge case
            if(root == null) {
                return result ;
            }

            //Step 1: add root node
            result.add(root.data) ;

            if(root.left == null && root.right == null) {
                return result ;
            }

            //Step 2: add left boundary nodes
            addLeftBoundaryOfTree(root.left , result) ;

            //Step 3: add bottom view nodes
            addBottomViewNodes(root , result);

            //Step 4: add right boundary nodes
            addRightBoundaryOfTree(root.right , result) ;

            return result ;
        }

        //function to find the left boundary nodes
        private static void addLeftBoundaryOfTree(TreeNode root , List<Integer> result) {
            //base case
            if(root == null || (root.left == null && root.right == null)) {
                return ;
            }

            result.add(root.data);

            if(root.left != null) {
                addLeftBoundaryOfTree(root.left , result) ;
            }else{
                addLeftBoundaryOfTree(root.right , result) ;
            }

            return ;
        }

        //function to find the bottom view Nodes
        private static void addBottomViewNodes(TreeNode root , List<Integer> result) {
            //Base case
            if(root == null ) {
                return ;
            }

            if(root.left == null && root.right == null) {
                result.add(root.data) ;
                return ;
            }

            addBottomViewNodes(root.left , result) ;
            addBottomViewNodes(root.right , result) ;

            return ;
        }

        //function to find the right view of the tree
        private static void addRightBoundaryOfTree(TreeNode root , List<Integer> result) {
            //Base case
            if(root == null || (root.left == null && root.right == null)) {
                return ;
            }

            if(root.right != null) {
                addRightBoundaryOfTree(root.right , result) ;
            }else{
                addRightBoundaryOfTree(root.left , result) ;
            }

            result.add(root.data) ;

            return ;
        }

    }
    public static void main(String[] args) {

    }
}
