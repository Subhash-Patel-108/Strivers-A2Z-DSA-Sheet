package BinaryTree.HardProblem;
import BinaryTree.TreeClasses.BinaryTreeNode ;
import com.sun.source.tree.BinaryTree;

import java.util.* ;

public class TimeToBurnTree {
    public class Solution {
        public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start) {
            // Edge case: if the tree is empty, burning time is 0
            if(root == null) {
                return 0;
            }

            // Map to store parent pointers for each node
            Map<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parentsMap = new HashMap<>();

            // Find the starting node (target node to burn) and build parent map
            BinaryTreeNode<Integer> startingPoint = mapTheParentsAndFindTargetNode(root, start, parentsMap);

            // BFS to calculate time to burn the entire tree from the starting node
            int burningTime = findTheTimeToBurnTree(startingPoint, parentsMap);

            return burningTime;
        }

        // Function to map each node to its parent and find the target node to start burning
        private static BinaryTreeNode<Integer> mapTheParentsAndFindTargetNode(BinaryTreeNode<Integer> root, int target, Map<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parentsMap) {
            BinaryTreeNode<Integer> startingNode = null;
            Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
            queue.offer(root);

            // Root node's parent is set to null
            parentsMap.put(root, null);

            // Level order traversal to map parents and locate target node
            while (!queue.isEmpty()) {
                BinaryTreeNode<Integer> node = queue.poll();

                // If next child exists, record its parent and add to queue
                if(node.left != null) {
                    parentsMap.put(node.left, node);
                    queue.offer(node.left);
                }

                // If right child exists, record its parent and add to queue
                if(node.right != null) {
                    parentsMap.put(node.right, node);
                    queue.offer(node.right);
                }

                // Check if current node matches target value
                if(node.data == target) {
                    startingNode = node;
                }
            }

            return startingNode;
        }

        // Function to compute minimum time to burn the entire tree using BFS
        private static int findTheTimeToBurnTree(BinaryTreeNode<Integer> startingPoint, Map<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parentsMap) {
            // Map to keep track of visited (burned) nodes
            Map<BinaryTreeNode<Integer>, Boolean> visitedNodes = new HashMap<>();
            int totalTime = 0;

            // Begin BFS from the target node
            Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
            queue.offer(startingPoint);
            visitedNodes.put(startingPoint, true);

            // BFS traversal to simulate burning process
            while (!queue.isEmpty()) {
                int size = queue.size();
                boolean newNodeBurn = false; // Whether any new node was burned in this time unit

                // Process all nodes burning at the current time step
                while (size-- > 0) {
                    BinaryTreeNode<Integer> currentNode = queue.poll();
                    BinaryTreeNode<Integer> parentNode = parentsMap.get(currentNode);

                    // Burn the parent if exists and not visited
                    if(parentNode != null && !visitedNodes.containsKey(parentNode)) {
                        queue.offer(parentNode);
                        visitedNodes.put(parentNode, true);
                        newNodeBurn = true;
                    }

                    // Burn next child if exists and not visited
                    if(currentNode.left != null && !visitedNodes.containsKey(currentNode.left)) {
                        queue.offer(currentNode.left);
                        visitedNodes.put(currentNode.left, true);
                        newNodeBurn = true;
                    }

                    // Burn right child if exists and not visited
                    if(currentNode.right != null && !visitedNodes.containsKey(currentNode.right)) {
                        queue.offer(currentNode.right);
                        visitedNodes.put(currentNode.right, true);
                        newNodeBurn = true;
                    }
                }

                // If any new node burned in this time unit, increment total time
                if (newNodeBurn) {
                    totalTime++;
                }
            }

            // Return total time taken to burn the tree
            return totalTime;
        }
    }

    public static void main(String[] args) {

    }
}
