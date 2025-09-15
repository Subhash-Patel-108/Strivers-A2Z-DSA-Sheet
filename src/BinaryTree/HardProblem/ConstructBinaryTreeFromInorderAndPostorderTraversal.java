package BinaryTree.HardProblem;
import java.util.* ;
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static class TreeNode <T> {
        public T data ;
        public TreeNode <T> left ;
        public TreeNode <T> right ;

        //constructor
        public TreeNode (T data) {
            this.data = data ;
            this.left = null ;
            this.right = null ;
        }
    };


    public static class Solution {
        private static int idx;
        private static Map<Integer, Integer> inorderIndexMap;

        public static TreeNode<Integer> getTreeFromPostorderAndInorder(int[] postOrder, int[] inOrder) {
            if (postOrder == null || inOrder == null || postOrder.length != inOrder.length) {
                return null;
            }

            inorderIndexMap = new HashMap<>();
            for (int i = 0; i < inOrder.length; i++) {
                inorderIndexMap.put(inOrder[i], i);
            }

            idx = postOrder.length - 1;
            return helper(postOrder, 0, inOrder.length - 1);
        }

        private static TreeNode<Integer> helper(int[] postOrder, int start, int end) {
            if (start > end || idx < 0) {
                return null;
            }

            int rootData = postOrder[idx--];
            TreeNode<Integer> root = new TreeNode<>(rootData);

            int position = inorderIndexMap.get(rootData);

            // Build right first, then next
            root.right = helper(postOrder, position + 1, end);
            root.left = helper(postOrder, start, position - 1);

            return root;
        }
    }
    public static void main(String[] args) {

    }
}
