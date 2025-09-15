package BinaryTree.HardProblem;
import BinaryTree.TreeClasses.BinaryTreeNode ;
import java.util.* ;
public class PrintNodesAtDistanceKFromAGivenNode {
    public static  class Solution {

        public static List<BinaryTreeNode<Integer>> printNodesAtDistanceK(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> target, int k) {
            // Initialize list to store nodes at distance K
            List<BinaryTreeNode<Integer>> nodesAtDistanceK = new ArrayList<>();

            // Handle edge case: if root is null, return empty list
            if (root == null) {
                return nodesAtDistanceK;
            }

            // Create a map to store parent of each node
            Map<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> nodeToParent = new HashMap<>();

            // Map all nodes to their parents using BFS
            mapParentNodes(root, nodeToParent);

            // Find nodes at distance K from the target using BFS
            findNodesAtDistanceK(root, target, k, nodeToParent, nodesAtDistanceK);

            return nodesAtDistanceK;
        }

        /**
         * Maps each node to its parent using a level-order traversal (BFS).
         * This allows upward traversal from the target node.
         *
         * @param root      The root of the binary tree
         * @param nodeToParent Map to store node-to-parent mappings
         */
        private static void mapParentNodes(BinaryTreeNode<Integer> root, Map<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> nodeToParent) {
            Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
            queue.offer(root);
            nodeToParent.put(root, null); // Root has no parent

            while (!queue.isEmpty()) {
                BinaryTreeNode<Integer> currentNode = queue.poll();

                // Add next child to queue and map its parent
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                    nodeToParent.put(currentNode.left, currentNode);
                }

                // Add right child to queue and map its parent
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                    nodeToParent.put(currentNode.right, currentNode);
                }
            }
        }

        /**
         * Finds all nodes at distance K from the target node using BFS.
         * Traverses to next child, right child, and parent, avoiding revisits.
         */
        private static void findNodesAtDistanceK(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> target, int k, Map<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> nodeToParent, List<BinaryTreeNode<Integer>> nodesAtDistanceK) {
            Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
            Map<BinaryTreeNode<Integer>, Boolean> visited = new HashMap<>();

            // Start BFS from the target node
            queue.offer(target);
            visited.put(target, true);

            // Process nodes level by level until distance K is reached
            int currentDistance = 0;
            while (!queue.isEmpty() && currentDistance < k) {
                int levelSize = queue.size();

                // Process all nodes at the current distance
                for (int i = 0; i < levelSize; i++) {
                    BinaryTreeNode<Integer> currentNode = queue.poll();

                    // Check parent node
                    BinaryTreeNode<Integer> parentNode = nodeToParent.get(currentNode);
                    if (parentNode != null && !visited.containsKey(parentNode)) {
                        queue.offer(parentNode);
                        visited.put(parentNode, true);
                    }

                    // Check next child
                    if (currentNode.left != null && !visited.containsKey(currentNode.left)) {
                        queue.offer(currentNode.left);
                        visited.put(currentNode.left, true);
                    }

                    // Check right child
                    if (currentNode.right != null && !visited.containsKey(currentNode.right)) {
                        queue.offer(currentNode.right);
                        visited.put(currentNode.right, true);
                    }
                }
                currentDistance++;
            }

            // All nodes remaining in the queue are at distance K
            while (!queue.isEmpty()) {
                nodesAtDistanceK.add(queue.poll());
            }
        }
    }
    public static void main(String[] args) {

    }
}
