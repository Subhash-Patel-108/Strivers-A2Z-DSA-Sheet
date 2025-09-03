package BinaryTree.MediumProblem;
import java.util.* ;
import BinaryTree.TreeClasses.Node ;
public class ZigZagTreeTraversal {
    public static class Solution {

        ArrayList<Integer> zigZagTraversal(Node root) {
            ArrayList<Integer> result = new ArrayList<>() ;
            //Edge case
            if(root == null) {
                return result ;
            }

            Queue <Node> queue = new LinkedList<>() ;//for level order traversal
            queue.offer(root) ;

            boolean leftToRight = true ;//to alternate the direction of traversal

            while (!queue.isEmpty()) {
                int queueSize = queue.size() ;
                ArrayList<Integer> inner = new ArrayList<>() ;
                while (queueSize -- > 0) {
                    Node currentNode = queue.poll() ;

                    if(leftToRight) {
                        inner.add(currentNode.data);
                    }else{
                        inner.add(0 , currentNode.data) ;
                    }

                    if(currentNode.left != null) {
                        queue.offer(currentNode.left) ;
                    }
                    if(currentNode.right != null) {
                        queue.offer(currentNode.right) ;
                    }
                }
                result.addAll(inner) ;
                leftToRight = !leftToRight ;
            }
            return result ;
        }
    }
    public static void main(String[] args) {

    }
}
