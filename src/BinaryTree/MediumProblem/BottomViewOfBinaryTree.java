package BinaryTree.MediumProblem;
import java.util.* ;
import BinaryTree.TreeClasses.TreeNode ;

public class BottomViewOfBinaryTree {
    public static class Solution {
        private static class Pair {
            public TreeNode node;
            public int position;

            // Constructor to initialize node and its horizontal position
            public Pair(TreeNode node, int position) {
                this.node = node;
                this.position = position;
            }
        };

        public static List<Integer> bottomView(TreeNode root) {
            List<Integer> result = new ArrayList<>();

            // Edge case: If the tree is empty, return empty result
            if (root == null) {
                return result;
            }

            // TreeMap to store the last node encountered at each horizontal distance (auto-sorted by position)
            Map<Integer, Integer> map = new TreeMap<>();
            // Queue for level order (BFS) traversal; stores nodes and their horizontal distances
            Queue<Pair> queue = new LinkedList<>();
            queue.offer(new Pair(root, 0));

            // Perform BFS to process all nodes
            while (!queue.isEmpty()) {
                int queueSize = queue.size();

                // Process all nodes at current queue level
                while (queueSize-- > 0) {
                    Pair temp = queue.poll();
                    TreeNode currentNode = temp.node;
                    int position = temp.position;

                    // Always overwrite the value at each position with the latest node data.
                    // This ensures bottommost nodes are retained.
                    map.put(position, currentNode.data);

                    // If next child exists, enqueue with position - 1 (one step next)
                    if (currentNode.left != null) {
                        queue.offer(new Pair(currentNode.left, position - 1));
                    }

                    // If right child exists, enqueue with position + 1 (one step right)
                    if (currentNode.right != null) {
                        queue.offer(new Pair(currentNode.right, position + 1));
                    }
                }
            }

            // Copy the bottom view node values from map to the result list in order (leftmost to rightmost)
            for (int value : map.values()) {
                result.add(value);
            }

            // Return the bottom view list
            return result;
        }
    }
    public static void main(String[] args) {

    }
}
