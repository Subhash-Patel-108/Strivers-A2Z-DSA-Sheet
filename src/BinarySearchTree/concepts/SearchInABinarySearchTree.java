package BinarySearchTree.concepts;
import BinaryTree.TreeClasses.TreeNode ;
public class SearchInABinarySearchTree {
    public static class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            TreeNode currNode = root ;

            while (currNode != null) {
                //the value is find
                if(currNode.data == val) {
                    return currNode ;
                }

                //if the value is present on the left side
                if (currNode.data > val) {
                    currNode = currNode.left ;
                }else{//the value is on the right side
                    currNode = currNode.right ;
                }
            }

            return null ; // the value is not present in the tree
        }
    }
    public static void main(String[] args) {

    }
}
