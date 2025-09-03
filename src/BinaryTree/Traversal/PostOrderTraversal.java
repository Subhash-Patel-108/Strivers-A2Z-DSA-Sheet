package BinaryTree.Traversal;
import java.util.* ;
public class PostOrderTraversal {
    public static class Solution {
        public static class TreeNode <T> {
            public T data ;
            public TreeNode<T> left ;
            public TreeNode<T> right ;

            //Constructor
            public TreeNode (T data) {
                this.data = data ;
                this.left = null ;
                this.right = null ;
            }
        };

        public static List<Integer> postorderTraversal(TreeNode<Integer> root) {
            List<Integer> postOrder = new ArrayList<>() ;

            //Edge case
            if(root == null) {
                return postOrder ;
            }

            //Step 1: Function calling to find postOrder traversal
            findPostOrder(root , postOrder) ;

            //Step 2: return the result
            return postOrder ;
        }

        private static void findPostOrder(TreeNode<Integer> root , List<Integer> postOrder) {
            //Base case
            if(root == null) {
                return ;
            }

            //Step 1: Function calling to find postOrder traversal
            findPostOrder(root.left , postOrder) ;//Left call
            findPostOrder(root.right , postOrder) ;//right call
            postOrder.add(root.data ) ;

            return ;
        }
    }
}
