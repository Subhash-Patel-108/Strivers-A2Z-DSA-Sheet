package GreedyAlgorithm.MediumAndHardProblems;
import java.util.* ;
public class JobSequencingProblem {
    public static class Solution {
        private static class Pair {
            public int deadline ;
            public int profit ;

            //Constructor
            public Pair(int deadline , int profit) {
                this.deadline = deadline ;
                this.profit = profit ;
            }
        }
        public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
            ArrayList <Pair> jobList = new ArrayList<>();
            //Edge case
            if(deadline == null || profit == null || deadline.length != profit.length ) {
                return new ArrayList<>() ;
            }
            for(int idx = 0 ; idx < deadline.length ; idx ++) {
                jobList.add(new Pair(deadline[idx] , profit[idx])) ;
            }

            //Sort the jobList on the basis of profit
            jobList.sort((a , b) -> b.profit - a.profit) ;

            //Finding the maximum
        }
    }
    public static void main(String[] args) {

    }
}
