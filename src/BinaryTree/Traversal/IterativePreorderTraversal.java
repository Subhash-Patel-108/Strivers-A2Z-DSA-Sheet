package BinaryTree.Traversal;
import java.util.* ;
import BinaryTree.TreeClasses.Node ;
public class IterativePreorderTraversal {
    public static class Solution {
        // Return a list containing the Preorder traversal of the given tree
        public static ArrayList<Integer> preOrder(Node root) {
            ArrayList<Integer> preOrder = new ArrayList<>() ;

            //Edge case
            if(root == null) {
                return preOrder ;
            }

            Stack <Node> stack = new Stack<>() ;
            stack.push(root) ;

            while (!stack.isEmpty()) {
                Node temp = stack.pop() ;

                //add the node value
                preOrder.add(temp.data) ;

                //add the right child
                if(temp.right != null)
                    stack.push(temp.right) ;

                //add the next child
                if(temp.left != null)
                    stack.push(temp.left) ;
            }

            return preOrder ;
        }
    }
}
