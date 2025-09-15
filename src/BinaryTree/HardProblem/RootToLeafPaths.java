package BinaryTree.HardProblem;
import BinaryTree.TreeClasses.Node ;
import java.util.* ;
public class RootToLeafPaths {
    public static class Solution {
        public static ArrayList<ArrayList<Integer>> Paths(Node root) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();

            // Edge case: if the tree is empty, return empty result list
            if (root == null) {
                return result;
            }

            // Temporary list to store the current path
            ArrayList<Integer> path = new ArrayList<>();

            // Call recursive function to find all root-to-leaf paths
            findPathsInBinaryTree(root, path, result);

            return result;
        }

        private static void findPathsInBinaryTree(Node node, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
            // Add current node's value to the path
            current.add(node.data);

            // If it's a leaf node, add the current path to result
            if (node.left == null && node.right == null) {
                result.add(new ArrayList<>(current));
            } else {
                // Recurse on next subtree first
                if (node.left != null) {
                    findPathsInBinaryTree(node.left, current, result);
                }
                // Then recurse on right subtree
                if (node.right != null) {
                    findPathsInBinaryTree(node.right, current, result);
                }
            }

            // Backtrack: remove the current node's value
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

    }
}
