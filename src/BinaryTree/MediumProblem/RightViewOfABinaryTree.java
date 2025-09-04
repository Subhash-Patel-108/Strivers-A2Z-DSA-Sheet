package BinaryTree.MediumProblem;
import java.util.* ;
public class RightViewOfABinaryTree {
    public class Solution {
        private static class BinaryTreeNode<T> {
            public T data;
            public BinaryTreeNode<T> left;
            public BinaryTreeNode<T> right;

            // Constructor to initialize node
            public BinaryTreeNode(T data) {
                this.data = data;
                this.left = null;
                this.right = null;
            }
        };
        public static ArrayList<Integer> printRightView(BinaryTreeNode<Integer> root) {
            ArrayList<Integer> result = new ArrayList<>();

            // Edge case: if the tree is empty, return empty result list
            if (root == null) {
                return result;
            }

            // Queue for level order traversal (BFS)
            Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
            queue.offer(root);

            // Process the tree level by level
            while (!queue.isEmpty()) {
                int queueSize = queue.size();

                // The first node in the queue at each level is the leftmost node
                result.add(queue.peek().data);

                // Traverse nodes for the current level
                while (queueSize-- > 0) {
                    BinaryTreeNode<Integer> currentNode = queue.poll();

                    // Add right child, if present
                    if (currentNode.right != null) {
                        queue.offer(currentNode.right);
                    }

                    // Add left child first to maintain left view order
                    if (currentNode.left != null) {
                        queue.offer(currentNode.left);
                    }
                }
            }
            // Return list containing right view nodes
            return result;
        }
    }

    public static void main(String[] args) {

    }
}
