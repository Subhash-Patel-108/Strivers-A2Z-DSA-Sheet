package BinaryTree.MediumProblem;
import java.util.* ;
public class LeftViewOfABinaryTree {
    public class Solution {
        // Generic TreeNode class for integer data
        private static class TreeNode<T> {
            public T data;
            public TreeNode<T> left;
            public TreeNode<T> right;

            // Constructor to initialize node
            public TreeNode(T data) {
                this.data = data;
                this.left = null;
                this.right = null;
            }
        };

        // Function to calculate the left view of the binary tree
        public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) {
            ArrayList<Integer> result = new ArrayList<>();

            // Edge case: if the tree is empty, return empty result list
            if (root == null) {
                return result;
            }

            // Queue for level order traversal (BFS)
            Queue<TreeNode<Integer>> queue = new LinkedList<>();
            queue.offer(root);

            // Process the tree level by level
            while (!queue.isEmpty()) {
                int queueSize = queue.size();

                // The first node in the queue at each level is the leftmost node
                result.add(queue.peek().data);

                // Traverse nodes for the current level
                while (queueSize-- > 0) {
                    TreeNode<Integer> currentNode = queue.poll();

                    // Add left child first to maintain left view order
                    if (currentNode.left != null) {
                        queue.offer(currentNode.left);
                    }
                    // Add right child, if present
                    if (currentNode.right != null) {
                        queue.offer(currentNode.right);
                    }
                }
            }
            // Return list containing left view nodes
            return result;
        }
    }

}
