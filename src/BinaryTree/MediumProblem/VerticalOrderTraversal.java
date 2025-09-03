package BinaryTree.MediumProblem;
import java.util.* ;
public class VerticalOrderTraversal {

    public class Solution {

        private static class TreeNode <T> {
            public T data ;
            public TreeNode <T> left ;
            public TreeNode <T> right ;

            public TreeNode(T data) {
                this.data = data ;
                this.left = null ;
                this.right = null ;
            }
        }

        private static class Pair {
            public TreeNode <Integer> node ;
            public int position ;

            //Constructor
            public Pair(TreeNode <Integer> node , int position) {
                this.node = node ;
                this.position = position ;
            }

        }
        public static ArrayList<Integer> verticalOrderTraversal(TreeNode<Integer> root) {
            ArrayList<Integer> result = new ArrayList<>() ;

            //Edge case
            if(root == null) {
                return result ;
            }
            Map <Integer , ArrayList<Integer>> map = new TreeMap<>() ;
            Queue <Pair> queue = new LinkedList<>() ;
            queue.offer(new Pair(root , 0)) ;

            while (!queue.isEmpty()) {
                int size = queue.size() ;
                while (size -- > 0 ) {
                    Pair current = queue.poll() ;
                    TreeNode<Integer> node = current.node ;
                    int position = current.position ;

                    if(node.left != null) {
                        queue.offer(new Pair(node.left , position - 1)) ;
                    }

                    if(node.right != null) {
                        queue.offer(new Pair(node.right , position + 1)) ;
                    }

                    map.putIfAbsent(position , new ArrayList<>()) ;
                    map.get(position).add(node.data);
                }
            }

            for(Map.Entry<Integer , ArrayList<Integer>> entry : map.entrySet()) {
                result.addAll(entry.getValue()) ;
            }

            return result ;
        }
    }

    public static void main(String[] args) {

    }
}
