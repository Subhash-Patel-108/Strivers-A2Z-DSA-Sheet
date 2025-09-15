package BinaryTree.MediumProblem;
import BinaryTree.TreeClasses.TreeNode ;
import java.util.* ;
public class TopViewOfBinaryTree {
    public static class Solution {
        // Helper class to store node and its horizontal position in the tree
        private static class Pair {
            public TreeNode node ;
            public int position ;

            // Constructor to initialize node and its position
            public Pair(TreeNode node, int position) {
                this.node = node ;
                this.position = position ;
            }
        }

        public static List<Integer> getTopView(TreeNode root) {
            List<Integer> result = new ArrayList<>() ;

            // Edge case: If tree is empty, return empty result
            if(root == null) {
                return result ;
            }

            // TreeMap to store the first node found at each horizontal position (ordered by position)
            Map<Integer, Integer> map = new TreeMap<>() ;

            // Queue for level order traversal; stores node and their horizontal positions
            Queue<Pair> queue = new LinkedList<>() ;
            queue.offer(new Pair(root, 0)); // Root node at position 0

            // Perform level order traversal (BFS)
            while (!queue.isEmpty()) {
                int size = queue.size();

                // Process all nodes at current level
                while (size-- > 0) {
                    Pair temp = queue.poll();
                    TreeNode node = temp.node;
                    int position = temp.position;

                    // If next child exists, enqueue with position-1 (one step next)
                    if(node.left != null) {
                        queue.offer(new Pair(node.left, position - 1));
                    }

                    // If right child exists, enqueue with position+1 (one step right)
                    if(node.right != null) {
                        queue.offer(new Pair(node.right, position + 1));
                    }

                    // Store node value in map only if this position is encountered for the first time
                    // (i.e., topmost node for that horizontal position)
                    if(!map.containsKey(position)) {
                        map.put(position, node.data);
                    }
                }
            }

            // Copy the top view node values from map to the result list in order
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                result.add(entry.getValue());
            }

            // Return the top view list
            return result ;
        }

    }
}
