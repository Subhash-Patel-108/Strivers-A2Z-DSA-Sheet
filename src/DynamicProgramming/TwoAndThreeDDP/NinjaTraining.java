package DynamicProgramming.TwoAndThreeDDP;

//Problem Link : https://www.naukri.com/code360/problems/ninja-s-training_3621003
public class NinjaTraining {

    //It is a top to down approach, if the value of n is larger, then it will give stack overflow error
    public static class SolutionUsingMemoization{
        public static int ninjaTraining(int n, int points[][]) {
            //Edge case
            if (points == null || points.length == 0 ) {
                return 0 ;
            }

            //Step 1: Create a dp array of size n*4
            int[][] dpArray = new int[n][4] ;

            //Step 2: Initialize the dp array with -1
            for(int row = 0 ; row < n ; row++)  {
                for(int col = 0 ; col < 4 ; col++) {
                    dpArray[row][col] = -1 ;
                }
            }


            return findMaximumPoints(points , n - 1 , 3 ,  dpArray) ;
        }

        private static int findMaximumPoints(int[][] points , int day , int lastTaskIdx , int[][] dpArray ){
            //Base case
            if(day == 0) {
                int maxi = 0 ;
                for(int task = 0 ; task < 3 ; task++ ) {
                    if(task != lastTaskIdx) {
                        maxi = Math.max(maxi , points[0][task]) ;
                    }
                }

                return maxi ;
            }

            //Step 3: Check if the answer is present in the dp array
            if (dpArray[day][lastTaskIdx] != -1) {
                return dpArray[day][lastTaskIdx] ;
            }

            int maxi = 0 ;
            for(int idx = 0 ; idx < 3 ; idx++ ) {
                if(idx != lastTaskIdx) {
                    int includeCurrentElement = points[day][idx] + findMaximumPoints(points , day - 1 , idx , dpArray) ;
                    maxi = Math.max(maxi , includeCurrentElement) ;
                }
            }

            //Step 2: Store the answer in the dp array
            return dpArray[day][lastTaskIdx] = maxi ;
        }
    }

    //It is a bottom to top approach, if the value of n is larger, then it will not give the stack overflow error
    public static class SolutionUsingTabulation {
        public static int ninjaTraining(int n, int points[][]) {
            // Handle edge case: null or empty points array returns 0
            if (points == null || points.length == 0) {
                return 0;
            }

            // Initialize dp array of size n*4 to store maximum points
            int[][] dpArray = new int[n][4];

            // Initialize base cases for day 0
            // Task 0: Max of task 1 and task 2 points
            dpArray[0][0] = Math.max(points[0][1], points[0][2]);
            // Task 1: Max of task 0 and task 2 points
            dpArray[0][1] = Math.max(points[0][0], points[0][2]);
            // Task 2: Max of task 0 and task 1 points
            dpArray[0][2] = Math.max(points[0][0], points[0][1]);
            // No task (lastTask=3): Max of all tasks
            dpArray[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

            // Iterate through each day starting from day 1
            for (int day = 1; day < n; day++) {
                // Iterate through each possible last task (0 to 3)
                for (int lastTask = 0; lastTask < 4; lastTask++) {
                    // Initialize maximum points for current state
                    int maxi = 0;
                    // Check each possible task for current day
                    for (int task = 0; task < 3; task++) {
                        // Skip if task is same as last task
                        if (task != lastTask) {
                            // Calculate points: current task points + previous day's max points
                            int currentPoints = points[day][task] + dpArray[day - 1][task];
                            // Update maximum points
                            maxi = Math.max(maxi, currentPoints);
                        }
                    }
                    // Store maximum points for current day and last task
                    dpArray[day][lastTask] = maxi;
                }
            }

            // Return maximum points possible after last day with no task constraint
            return dpArray[n - 1][3];
        }
    }
    public static void main(String[] args) {

    }
}
