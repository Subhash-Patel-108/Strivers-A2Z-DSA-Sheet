package BinarySearchTree.practiceProblem;
import BinaryTree.TreeClasses.Node ;

import java.util.* ;
public class PairSumInBST {
    public static class Solution {
        boolean findTarget(Node root, int target) {
            //Edge case
            if(root == null){
                return false ;
            }

            ArrayList <Integer> arr = new ArrayList<>() ;
            inOrder (root , arr) ;

            return twoSumPair(arr , target) ;
        }

        private static void inOrder(Node root , ArrayList <Integer> ans) {
            //Base case
            if(root == null) {
                return ;
            }

            inOrder(root.left , ans);
            ans.add(root.data);
            inOrder(root.right , ans);

            return ;
        }
        private static boolean twoSumPair(ArrayList<Integer> arr , int target) {
            int start = 0 , end = arr.size() - 1 ;

            while (start < end) {
                int totalSum = arr.get(start) + arr.get(end) ;

                if(totalSum == target) {
                    return true ;
                }

                if(totalSum < target) {
                    start ++ ;
                }else{
                    end -- ;
                }
            }
            return false ;
        }
    }
    public static void main(String[] args) {

    }
}
