package StackAndQueue.MonotonicStackAndQueueProblem;
import java.util.* ;
public class AsteroidCollision {
    public static class Solution {
        // Simulates asteroid collisions and returns the surviving asteroids
        public static int[] asteroidCollision(int N, int[] asteroids) {
            // Handle edge case: return empty array if asteroids is null or N is 0
            if (asteroids == null || N == 0) {
                return new int[] {};
            }

            // Stack to keep track of surviving asteroids (positive for right-moving, negative for left-moving)
            Stack<Integer> stack = new Stack<>();
            // Iterate through each asteroid in the array
            for (int asteroid : asteroids) {
                // If asteroid is moving right (positive), add it to the stack
                if (asteroid > 0) {
                    stack.push(asteroid);
                } else {
                    // For left-moving asteroid (negative), simulate collision
                    int absAsteroid = Math.abs(asteroid); // Absolute value for comparison
                    // Destroy smaller right-moving asteroids while stack has right-moving and smaller than current
                    while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < absAsteroid) {
                        stack.pop();
                    }

                    // If sizes are equal, both destroy each other
                    if (!stack.isEmpty() && stack.peek() == absAsteroid) {
                        stack.pop();
                    } else if (stack.isEmpty() || stack.peek() <= 0) {
                        // If no collision or collides with left-moving, add current asteroid
                        stack.push(asteroid);
                    }
                }
            }

            // Convert stack to array by popping elements in reverse order
            int[] ans = new int[stack.size()];
            for (int i = ans.length - 1; i >= 0; i--) {
                ans[i] = stack.pop();
            }

            return ans;
        }
    }
    public static void main(String[] args) {

    }
}
