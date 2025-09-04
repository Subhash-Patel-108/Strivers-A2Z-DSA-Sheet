package BinaryTree.HardProblem;

public class UniqueBinaryTree {
    public class Solution {
        public static boolean uniqueBinaryTree(int a, int b){
            //if there is no inOrder then we can not build a tree, so return false || both are not inorder
            if((a != 2) && (b != 2) || (a == 2 && b == 2)) {
                return false ;
            }
            return true ;//Otherwise return true
        }
    }
    public static void main(String[] args) {

    }
}
