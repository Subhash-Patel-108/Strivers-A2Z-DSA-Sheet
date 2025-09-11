package BinarySearchTree.practiceProblem;
import BinaryTree.TreeClasses.Node ;

import java.util.* ;
public class MergeTwoBSTs {
    public static class Solution {
        // Inorder traversal (store elements in a list)
        public static void inOrder(Node root, ArrayList<Integer> in) {
            if (root == null) return;

            inOrder(root.left, in);
            in.add(root.data);
            inOrder(root.right, in);
        }

        // Create a Balanced BST from a sorted list
        public static Node createBST(ArrayList<Integer> nums, int start, int end) {
            if (start > end) return null;

            int mid = start + (end - start) / 2;
            Node root = new Node(nums.get(mid));

            root.left = createBST(nums, start, mid - 1);
            root.right = createBST(nums, mid + 1, end);

            return root;
        }

        // Merge two BSTs into a sorted list
        public static ArrayList<Integer> merge(Node root1, Node root2) {
            ArrayList<Integer> num1 = new ArrayList<>();
            ArrayList<Integer> num2 = new ArrayList<>();

            // Get inorder traversals (sorted lists)
            inOrder(root1, num1);
            inOrder(root2, num2);

            // Merge two sorted lists
            ArrayList<Integer> ans = new ArrayList<>();
            int idx1 = 0, idx2 = 0;

            while (idx1 < num1.size() && idx2 < num2.size()) {
                if (num1.get(idx1) > num2.get(idx2)) {
                    ans.add(num2.get(idx2++));
                } else {
                    ans.add(num1.get(idx1++));
                }
            }

            // Add remaining elements
            while (idx1 < num1.size()) ans.add(num1.get(idx1++));
            while (idx2 < num2.size()) ans.add(num2.get(idx2++));

            // If you want to build a balanced BST back:
            // Node root = createBST(ans, 0, ans.size() - 1);

            return ans;
        }
    }
    public static void main(String[] args) {

    }
}
