package BinaryTree.HardProblem;
import BinaryTree.TreeClasses.TreeNode ;

import java.util.* ;

public class CountTotalNodesInACompleteBT {
    public static class Solution1 {
        public int countNodes(TreeNode root) {
            //Edge case
            if(root == null) {
                return 0 ;
            }
            Queue <TreeNode> queue = new LinkedList<>() ;
            queue.offer(root) ;

            int totalNodes = 0 ;
            while (!queue.isEmpty()) {
                int size = queue.size() ;
                totalNodes += size ;

                while (size -- > 0) {
                    TreeNode currNode = queue.poll() ;

                    if(currNode.left != null ) {
                        queue.offer(currNode.left) ;
                    }

                    if(currNode.right != null) {
                        queue.offer(currNode.right) ;
                    }
                }
            }

            return totalNodes ;
        }
    }

    public static class Solution2 {
        public int countNodes (TreeNode root) {
            //Edge case
            if(root == null) {
                return 0 ;
            }
            int leftHeight = getHeight(root , true ) ;
            int rightHeight = getHeight(root , false ) ;

            //if the next and right heights are equal it mean the tree is complete binary tree
            if(leftHeight == rightHeight ) {
                return (int)(Math.pow(2 , leftHeight) - 1) ;
            }

            return 1 + countNodes(root.left) + countNodes(root.right) ;
        }

        private static int getHeight(TreeNode root , boolean goLeft) {
            int height = 0 ;
            while (root != null) {
                height ++ ;
                root = goLeft ? root.left : root.right ;
            }

            return height ;
        }
    }
    public static void main(String[] args) {

    }
}
