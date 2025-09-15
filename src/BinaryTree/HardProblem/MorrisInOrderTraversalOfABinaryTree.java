package BinaryTree.HardProblem;
import BinaryTree.TreeClasses.Node ;
import java.util.* ;
public class MorrisInOrderTraversalOfABinaryTree {
    public static class Solution {
        // Function to return a list containing the inorder traversal of the tree.
        public static ArrayList<Integer> inOrder(Node root) {
            //Edge case
            ArrayList <Integer> result = new ArrayList<>() ;

            if(root == null) {
                return result ;
            }

            //Code for morris traversal
            Node currRoot = root ;
            while (currRoot != null) {
                //the next node of the current root doesn't exist
                if(currRoot.left == null) {
                    result.add(currRoot.data);
                    currRoot = currRoot.right;
                }else{//If the right sub tree is exist
                    Node temp = currRoot.left  ;

                    while (temp.right != null && temp.right != currRoot) {
                        temp = temp.right ;
                    }

                    //The next subTree is Already traverse
                    if(temp.right == currRoot) {
                        temp.right = null ;
                        result.add(currRoot.data);
                        currRoot = currRoot.right ;
                    }else{//if the next tree is not traverse
                        temp.right = currRoot ;
                        currRoot = currRoot.left ;
                    }
                }
            }

            return result ;
        }
    }
}
