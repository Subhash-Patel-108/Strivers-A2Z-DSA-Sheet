package BinaryTree.HardProblem;
import BinaryTree.TreeClasses.Node ;
import java.util.* ;
public class ChildrenSumInABinaryTree {
    public class Solution {
        private static boolean isChildSumTree;

        // Public method to check if the binary tree satisfies the children sum property
        public static boolean isParentSum(Node root) {
            // Edge case: empty tree satisfies the children sum property by definition
            if (root == null) {
                return true;
            }

            isChildSumTree = true;  // Initialize flag as true

            // Start recursion to verify children sum property across the tree
            checkChildrenSumProperty(root);

            // Return the result after traversal
            return isChildSumTree;
        }

        // Recursive helper method to verify the children sum property for each node
        private static void checkChildrenSumProperty(Node root) {
            // Base cases:
            // 1. If node is null, just return
            // 2. If node is a leaf (no children), return (property holds trivially)
            // 3. If property already failed in earlier recursion, no need to check further
            if (root == null || (root.left == null && root.right == null) || !isChildSumTree) {
                return;
            }

            // Get values of left and right children; if child is null, value is considered 0
            int leftValue = root.left != null ? root.left.data : 0;
            int rightValue = root.right != null ? root.right.data : 0;

            int totalSum = leftValue + rightValue;

            // If current node's data is not equal to sum of children's data, property fails
            if (totalSum != root.data) {
                isChildSumTree = false;
                return;
            }

            // Recursively check children for the same property
            checkChildrenSumProperty(root.left);
            checkChildrenSumProperty(root.right);

            return;
        }
    }

    public static void main(String[] args) {

    }
}
