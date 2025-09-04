package BinaryTree.HardProblem;
import BinaryTree.TreeClasses.TreeNode ;
import java.util.* ;
public class MaximumWidthInBinaryTree {
    public class Solution {
        public static int getMaxWidth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int maxWidth = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                // Width of current level is the number of nodes
                maxWidth = Math.max(maxWidth, levelSize);

                // Process all nodes in the current level
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();

                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }

            return maxWidth;
        }
    }
    public static void main(String[] args) {

    }
}
