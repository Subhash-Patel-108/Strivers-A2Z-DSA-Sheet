package BinaryTree.Traversal;

import java.util.* ;
public class LevelOrderTraversal {
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

        public static List<Integer> levelOrder(TreeNode<Integer> root){
            List<Integer> levelOrder = new ArrayList<>() ;

            //Edge case
            if(root == null) {
                return levelOrder ;
            }

            Queue <TreeNode<Integer>> queue = new LinkedList<>() ;
            queue.offer(root) ;

            while(!queue.isEmpty()) {
                TreeNode<Integer> node = queue.poll() ;

                //add the node value
                levelOrder.add(node.data) ;

                //add the next child
                if(node.left != null) {
                    queue.offer(node.left) ;
                }

                //add the right child
                if(node.right != null) {
                    queue.offer(node.right) ;
                }
            }

            return levelOrder ;
        }
    }
}
