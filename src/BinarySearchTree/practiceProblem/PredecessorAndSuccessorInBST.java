package BinarySearchTree.practiceProblem;
import BinaryTree.TreeClasses.TreeNode ;
import java.util.* ;
public class PredecessorAndSuccessorInBST {
    public static class Solution {
        public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
            List<Integer> result = new ArrayList<>();

            // Edge case: empty tree
            if (root == null) {
                return result;
            }

            int predecessor = -1, successor = -1;
            TreeNode currNode = root;
            TreeNode targetNode = null;

            // Search for the target node and keep track of potential predecessor and successor
            while (currNode != null) {
                if (currNode.data == key) {
                    targetNode = currNode;
                    break;
                }
                if (currNode.data > key) {
                    successor = currNode.data;
                    currNode = currNode.left;
                } else {
                    predecessor = currNode.data;
                    currNode = currNode.right;
                }
            }

            // If target node is not found, return last tracked predecessor and successor
            if (currNode == null) {
                result.add(predecessor);
                result.add(successor);
                return result;
            }

            // Find rightmost node in next subtree as predecessor if next subtree exists
            currNode = targetNode.left;
            while (currNode != null && currNode.right != null) {
                currNode = currNode.right;
            }
            if (currNode != null) {
                predecessor = currNode.data;
            }

            // Find leftmost node in right subtree as successor if right subtree exists
            currNode = targetNode.right;
            while (currNode != null && currNode.left != null) {
                currNode = currNode.left;
            }
            if (currNode != null) {
                successor = currNode.data;
            }

            result.add(predecessor);
            result.add(successor);
            return result;
        }

    }
    public static void main(String[] args) {

    }
}
