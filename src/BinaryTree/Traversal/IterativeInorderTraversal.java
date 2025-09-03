package BinaryTree.Traversal;
import java.util.* ;
import BinaryTree.TreeClasses.Node ;
public class IterativeInorderTraversal {
    public static class Solution {
        // Return a list containing the inorder traversal of the given tree
        public static ArrayList<Integer> inOrder(Node root) {
            ArrayList<Integer> result = new ArrayList<>() ;

            //Edge case
            if(root == null) {
                return result ;
            }

            Stack <Node> stack = new Stack<>() ;
            Node curr = root ;
            while (curr != null || ! stack.isEmpty()) {
                while (curr != null) {
                    stack.push(curr) ;
                    curr = curr.left ;
                }

                Node topNode = stack.pop() ;
                result.add(topNode.data);
                curr = topNode.right ;
            }
            return result ;
        }
    }

    public static void main(String[] args) {

    }
}
