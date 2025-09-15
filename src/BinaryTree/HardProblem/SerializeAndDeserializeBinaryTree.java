package BinaryTree.HardProblem;
import BinaryTree.TreeClasses.Node;
import BinaryTree.TreeClasses.TreeNode ;
import java.util.* ;
public class SerializeAndDeserializeBinaryTree {
    public static class Solution {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder result = new StringBuilder();

            // Edge case: return empty string for empty tree
            if (root == null) {
                return "";
            }

            // Level order traversal using queue
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode currNode = queue.poll();

                // If node is null, append marker ("n ") and continue
                if (currNode == null) {
                    result.append("n ");
                    continue;
                }

                // Append node value to result string
                result.append(currNode.data).append(" ");

                // Add next and right children to queue (even if null)
                queue.offer(currNode.left);
                queue.offer(currNode.right);
            }

            // Return final serialized string
            return result.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            // Edge case: empty string means empty tree
            if (data.equals("")) {
                return null;
            }

            // Split the string to get individual node values or null markers
            String[] elements = data.split(" ");
            int idx = 0;

            // Initialize root node from first element
            TreeNode root = new TreeNode(Integer.parseInt(elements[idx]));
            idx++;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            // Iterate over elements using the queue for parent nodes
            while (idx < elements.length) {
                TreeNode parent = queue.poll();

                // Process next child
                if (!elements[idx].equals("n")) {
                    parent.left = new TreeNode(Integer.parseInt(elements[idx]));
                    queue.offer(parent.left);
                }
                idx++;

                // Make sure we don't exceed array bounds
                if (idx < elements.length && !elements[idx].equals("n")) {
                    parent.right = new TreeNode(Integer.parseInt(elements[idx]));
                    queue.offer(parent.right);
                }
                idx++;
            }

            // Return reconstructed tree root
            return root;
        }
    }


    public static class Solution2 {

        // Serializes the tree to a string using pre-order traversal
        public static String serializeTree(TreeNode root) {
            // Edge case: empty tree returns empty string
            if(root == null) {
                return "";
            }

            StringBuilder ans = new StringBuilder();

            // Helper function to perform pre-order traversal
            preOrderTraversal(root, ans);
            return ans.toString();
        }

        // Performs pre-order traversal: Root, Left, Right
        private static void preOrderTraversal(TreeNode root, StringBuilder ans) {
            // Base case: represent null node with "n "
            if(root == null) {
                ans.append("n ");
                return;
            }

            // Add the current node value to string
            ans.append(root.data).append(" ");

            // Recursively serialize next and right subtrees
            preOrderTraversal(root.left, ans);
            preOrderTraversal(root.right, ans);

            return;
        }

        // For deserialization, maintain a global index
        private static int idx;

        // Deserializes the string back to a tree using pre-order order
        public static TreeNode deserializeTree(String serialized) {
            // Edge case: empty string means empty tree
            if(serialized.equals("")) {
                return null;
            }

            // Split the serialized string into node representations
            String[] values = serialized.split(" ");
            idx = 0;

            // Call helper function to rebuild the tree recursively
            return deserializePreOrder(values);
        }

        // Recursively reconstruct the tree from pre-order sequence
        private static TreeNode deserializePreOrder(String[] values) {
            // Base case: out of bounds or 'n' marker means null node
            if(idx >= values.length || values[idx].equals("n")) {
                return null;
            }

            // Create node for current value
            TreeNode root = new TreeNode(Integer.parseInt(values[idx]));

            idx++; // move to next string for next child
            root.left = deserializePreOrder(values);

            idx++; // move to next string for right child
            root.right = deserializePreOrder(values);

            return root;
        }
    }


    public static void main(String[] args) {

    }
}
