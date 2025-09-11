package BinarySearchTree.practiceProblem;

public class CeilFromBST {
    public static class Solution {
        public static class TreeNode <T> {
            public T data ;
            public TreeNode <T> left ;
            public TreeNode <T> right ;

            //constructor
            public TreeNode (T data ) {
                this.data = data ;
                this.left = null ;
                this.right = null ;
            }
        }
        public  static int findCeil(TreeNode<Integer> root, int x) {
            int ans = -1 ;
            //Edge case
            if(root == null) {
                return ans ;
            }

            TreeNode<Integer> currNode = root ;

            while (currNode != null) {
                //if the exact value is found
                if(currNode.data == x){
                    return currNode.data ;
                }

                if(currNode.data > x) {
                    ans = currNode.data ;
                    currNode = currNode.left ;
                }else{
                    currNode = currNode.right ;
                }
            }

            return ans ;
        }
    }
    public static void main(String[] args) {

    }
}
