package BinaryTree.HardProblem;
import BinaryTree.TreeClasses.TreeNode ;
import java.util.* ;
public class MaximumWidthLeetCode {
    public static class Solution {

        public static int getMaxWidth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int maxWidth = 0;
            Queue<Pair> queue = new LinkedList<>();
            queue.offer(new Pair(root, 0));

            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                int minIndex = Integer.MAX_VALUE;
                int maxIndex = Integer.MIN_VALUE;

                // Process all nodes in the current level
                for (int i = 0; i < levelSize; i++) {
                    Pair current = queue.poll();
                    TreeNode node = current.node;
                    int index = current.index;

                    minIndex = Math.min(minIndex, index);
                    maxIndex = Math.max(maxIndex, index);

                    if (node.left != null) {
                        queue.offer(new Pair(node.left, 2 * index + 1));
                    }
                    if (node.right != null) {
                        queue.offer(new Pair(node.right, 2 * index + 2));
                    }
                }

                // Calculate the width of the current level
                int width = maxIndex - minIndex + 1;
                maxWidth = Math.max(maxWidth, width);
            }

            return maxWidth;
        }

        // Helper class to store node and its index
        static class Pair {
            TreeNode node;
            int index;
            Pair(TreeNode node, int index) {
                this.node = node;
                this.index = index;
            }
        }
    }
}
